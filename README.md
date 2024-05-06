# Word Ladder Solver
> Program Word Ladder Solver adalah sebuah program yang bisa menemukan solusi permainan Word Ladder dengan pendekatan tiga algoritma: Uniform Cost Search(UCS), Greedy Best First Search(GBFS), dan A-star Search.

## Table of Contents
* [General Info](#general-information)
* [Technologies Used](#technologies-used)
* [Screenshots](#screenshots)
* [Setup](#setup)
* [Usage](#usage)
* [Restrictions](#restriction)
<!-- * [License](#license) -->


## General Information
- Provide general information about your project here.
- What problem does it (intend to) solve?
- What is the purpose of your project?
- Why did you undertake it?
<!-- You don't have to answer all the questions - just the ones relevant to your project. -->


## Technologies Used
- Scene builder
- Java jdk-22
- javafx-sdk-22.0.1


## Screenshots
![Example screenshot](./img/screenshot.png)
<!-- If you have screenshots you'd like to share, include them here. -->


## Setup
Untuk menjalankan program ini diperlukan:
- JDK 11 atau yang lebih baru (https://www.azul.com/downloads/?version=java-22&os=windows&package=jdk#zulu)
- JavaFX SDK version 22.0.1  (https://gluonhq.com/products/javafx/)
Langkah-langkah setup program bisa dilihat pada link: https://openjfx.io/openjfx-docs/

## Usage
Windows :
Pastikan sedang di folder src
compile:
`javac --module-path "C:\Program Files\Java\javafx-sdk-22.0.1\lib" --add-modules javafx.controls,javafx.fxml App.java MainSceneController.java`
run program:
`java --module-path "C:\Program Files\Java\javafx-sdk-22.0.1\lib" --add-modules javafx.controls,javafx.fxml App`
keterangan: "C:\Program Files\Java\javafx-sdk-22.0.1\lib" diganti dengan letak javafx-sdk/lib pada device pengguna
Setelah program GUI berjalan dengan baik, masukkan input sesuai keinginan.

## Restrictions
Folder word hanya memiliki kumpulan kata dengan jumlah huruf hingga 15.
Waktu pembuatan graf akan naik secara drastis mulai dari 8 hurud ke atas.