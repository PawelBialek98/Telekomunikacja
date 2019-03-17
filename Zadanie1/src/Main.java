//package com.javacodegeeks.snippets.core;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.*;


public class Main extends Application{

    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Podpis cyfrowy");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(15, 15, 15, 15));
        grid.setVgap(5);
        grid.setHgap(5);

        Label sendLabel = new Label("Podaj ścieżkę do pliku do wyslania");
        GridPane.setConstraints(sendLabel, 0, 0);

        TextField fileInput = new TextField();
        fileInput.setPrefWidth(300);
        GridPane.setConstraints(fileInput, 0, 1);

        Button buttonSend = new Button("Wyslij");
        GridPane.setConstraints(buttonSend, 1,1);

        Label verifyLabel = new Label("Podaj ścieżkę gdzie zapisac zmodyfikowany plik do wyslania");
        GridPane.setConstraints(verifyLabel, 0,2);

        TextField verifyInput = new TextField();
        verifyInput.setPrefWidth(300);
        GridPane.setConstraints(verifyInput, 0,3);

        Label receiveLabel = new Label("Podaj ścieżkę do odbioru pliku");
        GridPane.setConstraints(receiveLabel, 0,4);

        TextField receiveInput = new TextField();
        verifyInput.setPrefWidth(300);
        GridPane.setConstraints(receiveInput, 0,5);

        Button buttonReceive = new Button("Odbierz");
        GridPane.setConstraints(buttonReceive, 1,5);

        Files files = new Files();
        Pojedynczy pojedynczy = new Pojedynczy();

        buttonSend.setOnAction(event -> {
            byte[] kod = files.readFromFile(fileInput.getText());
            pojedynczy.BytesToVector(kod);
            pojedynczy.encrypt();
            pojedynczy.changeT();
            byte[] wysylka = pojedynczy.VectorToBytes();
            files.saveToFile(wysylka, verifyInput.getText());
        });

        buttonReceive.setOnAction(event ->{
            pojedynczy.decrypt();
            byte[] out = pojedynczy.VectorToBytes();
            files.saveToFile(out,receiveInput.getText());
        });

        grid.getChildren().addAll(sendLabel,fileInput,buttonSend,verifyLabel, verifyInput, receiveInput, receiveLabel, buttonReceive);
        Scene scene = new Scene(grid, 480, 250);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}