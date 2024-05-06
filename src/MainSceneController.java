
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.ProgressBar;
import javafx.application.Platform;

import java.util.ArrayList;
import java.util.Map;

import Solver.*;

public class MainSceneController{
    ObservableList<String> algoList = FXCollections.observableArrayList("UCS", "GBFS", "A-Star");

    @FXML
    private Label wordDoesntexit1;

    @FXML
    private Label wordDoesntexit2;

    @FXML
    private ChoiceBox<String> AlgoChoice;

    @FXML
    private Label nodeVisited;

    @FXML
    private Label time;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Label lengthWordnotSame;

    @FXML
    private Button buttonSearch;

    @FXML
    private TextField endTextField;

    @FXML
    private ListView<String> listAnswer;

    @FXML
    private TextField startTextField;

    @FXML
    private Label time1;

    @FXML
    private Label makingGraph;

    private double graphElapsedTime;
    private double algorithmElapsedTime;

    @FXML
    void BeginSearch(ActionEvent event) {
        String Start = startTextField.getText().toUpperCase();
        String End = endTextField.getText().toUpperCase();
        Start = Algo.ValidString(Start);
        End = Algo.ValidString(End);
        wordDoesntexit1.setVisible(false);
        wordDoesntexit2.setVisible(false);
        nodeVisited.setVisible(false);
        makingGraph.setVisible(false);
        time.setVisible(false);
        time1.setVisible(false);
        listAnswer.setItems(null);
        if (Start.length() != End.length()) {
            lengthWordnotSame.setVisible(true);
        } else {
            lengthWordnotSame.setVisible(false);
            listAnswer.setItems(null);
            ArrayList<String> dict = new ArrayList<>();
            
            
            String FileName = Integer.toString(Start.length()) + ".txt";
            dict = GetFile.findFile("src/word", FileName);
            if (!dict.contains(Start)) {
                wordDoesntexit1.setVisible(true);
            }
            if (!dict.contains(End)) {
                wordDoesntexit2.setVisible(true);
            }
            if (!wordDoesntexit1.visibleProperty().get() && !wordDoesntexit2.visibleProperty().get()) {
                Task<Tuple> task = new Task<Tuple>() {
                    @Override
                    protected Tuple call() throws Exception {
                        // Background task: Make graph
                        makingGraph.setVisible(true);
                        String Start = Algo.ValidString(startTextField.getText().toUpperCase());
                        String End = Algo.ValidString(endTextField.getText().toUpperCase());
                        long startTime = System.nanoTime();
                        ArrayList<String> dict = GetFile.findFile("src/word", FileName);
                        Map<String, ArrayList<String>> map = MakeGraf.makeGraf(dict);
                        long endTime = System.nanoTime();
                        graphElapsedTime = (endTime - startTime) / 1e6; // milliseconds

                        // Background task: Run algorithm
                        updateMessage("Running algorithm...");
                        startTime = System.nanoTime();
                        Tuple result = Algo.MainAlgo(map, Start, End, AlgoChoice.getValue());
                        endTime = System.nanoTime();
                        algorithmElapsedTime = (endTime - startTime) / 1e6; // milliseconds


                        return result;
                    }
                };

                progressBar.progressProperty().bind(task.progressProperty());

                task.setOnSucceeded(e -> {
                    makingGraph.setVisible(false);
                    Tuple result = task.getValue();
                    nodeVisited.setText("Node visited: " + result.y);
                    nodeVisited.setVisible(true);
                    ObservableList<String> items = FXCollections.observableArrayList(result.x);
                    listAnswer.setItems(items);

                    progressBar.setVisible(false);
                    time1.setVisible(true);
                    Platform.runLater(() -> {
                        time1.setText("Graph making: " + graphElapsedTime + "ms");
                        time.setText("Algorithm exec: " + algorithmElapsedTime + "ms");
                        time.setVisible(true);
                        time1.setVisible(true);
                    });
                });

                progressBar.setVisible(true);

                new Thread(task).start();
                    }
                }
    }

    @FXML
    public void initialize() {
        AlgoChoice.setItems(algoList);
        AlgoChoice.getSelectionModel().selectFirst();
    }
}