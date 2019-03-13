//package com.javacodegeeks.snippets.core;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.*;


public class Main extends Application {

    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window=primaryStage;
        window.setTitle("Hello World");     //cale te trzy linijki co jest window to tworzymy jakby nasze okno

        GridPane grid = new GridPane();     //tworzymy nową siatkę żeby ładnie mozna było porozkładać wszystkie elementy
        grid.setPadding(new Insets(10, 10, 10, 10));        //pokazujemy na ile elementow dzielimy siatke
        grid.setVgap(5);
        grid.setHgap(5); //ustalamy poziome i pionowe odleglosci

        Label singleLabel = new Label("Podaj ciąg 8 bitów do stworzenia słów kodowych");
        GridPane.setConstraints(singleLabel, 0, 0);       //tworzymy nowa etykiete i mowimy gdzie ma sie znajdowac

        TextField singleInput = new TextField();
        singleInput.setPrefWidth(300);
        GridPane.setConstraints(singleInput, 0, 1);       //tworzymy nowe pole tekstowe i mowimy gdzie ma sie znajdowac

        Button buttonSingle = new Button("Wykonaj");
        GridPane.setConstraints(buttonSingle, 1,1);        //tworzymy nowy guzik i mowimy gdzie ma sie znajdowac

        Label inputLabel = new Label("Tu wyświetlimy stworzone słowo kodowe, zmien 1 bit i sprawdź");
        GridPane.setConstraints(inputLabel, 0, 2);      //tworzymy nowa etykiete i mowimy gdzie ma sie znajdowac

        TextField userInput = new TextField();
        GridPane.setConstraints(userInput, 0, 3);        //tworzymy nowe pole tekstowe i mowimy gdzie ma sie znajdowac

        Button buttonInput = new Button("Wykonaj");
        GridPane.setConstraints(buttonInput, 1,3);       //tworzymy nowy guzik i mowimy gdzie ma sie znajdowac

        Label cipherLabel = new Label("Zaszyfrowany tekst");
        GridPane.setConstraints(cipherLabel, 0, 4);     //tworzymy nowa etykiete i mowimy gdzie ma sie znajdowac

        TextField cipherOutput = new TextField();
        GridPane.setConstraints(cipherOutput, 0, 5);    //tworzymy nowe pole tekstowe i mowimy gdzie ma sie znajdowac

        Label decipherLabel = new Label("Ponownie odszyfrowany tekst");
        GridPane.setConstraints(decipherLabel, 0, 6);       //tworzymy nowa etykiete i mowimy gdzie ma sie znajdowac

        TextField decipherOutput = new TextField();
        GridPane.setConstraints(decipherOutput, 0, 7);      //tworzymy nowe pole tekstowe i mowimy gdzie ma sie znajdowac

        //OneTimePad cipherInput = new OneTimePad();      //tworzymy nowy obiekt klasy onetimepad czyli naszego algorytmu
        Pojedynczy pojedynczy = new Pojedynczy();

        buttonSingle.setOnAction(e -> {                                              //tutaj beda rzeczy co sie beda dzialy po wcisnieciu guzika ktory zwie sie button imput
            //cipherInput.setInput(userInput.getText());                              //ustawaimy w naszym obiekcie typu onetimepad tekst jawny jako zawartosc pola tekstowego co sie zwie userinput
            //System.out.println(cipherInput.getInput());
            //cipherInput.getKey();                                                   //losujemy se klucza
            //System.out.println(cipherInput.key);
            //String zaszyfrowany = cipherInput.cipher(cipherInput.getInput());
            //System.out.println(zaszyfrowany);
            // System.out.println(cipherInput.cipher(zaszyfrowany));

            //cipherOutput.setText(cipherInput.cipher(cipherInput.getInput()));       //szyfrujemy i wyswietlamy
            //cipherInput.saveToFile();
            //System.out.println(cipherInput.cipher(cipherInput.getInput()));
            //decipherOutput.setText(cipherInput.cipher(cipherOutput.getText()));     //odszyfrujemy i wyswietlamy
            // System.out.println(cipherInput.cipher(cipherOutput.getText()));
            //pojedynczy.encrypt(singleInput.getText());
            userInput.setText(pojedynczy.encrypt(singleInput.getText()));
        });

        buttonInput.setOnAction(e -> {

           /* cipherInput.setInput(cipherInput.setFileInput(fileInput.getText()));   // To samo zo wyżej, tylko czytam z okienka fileInput
            cipherInput.getKey();
            cipherOutput.setText(cipherInput.cipher(cipherInput.getInput()));
            decipherOutput.setText(cipherInput.cipher(cipherOutput.getText()));*/
            //BitSet bitSet = new BitSet();
            //BitSet.valueOf(cipherInput.setFileInput(fileInput.getText()));

        });


        grid.getChildren().addAll(singleLabel,singleInput,buttonSingle, inputLabel, userInput, buttonInput, cipherLabel, cipherOutput, decipherLabel, decipherOutput); //dodajemy wszystko do siaty

        Scene scene = new Scene(grid, 400, 375);        //ustawiamy "scene" i podajemy wymiary
        window.setScene(scene);     //przekazujemy ja do naszego okna
        window.show();      //i wyswietlamy
    }


    public static void main(String[] args) {
        launch(args);
    }
}