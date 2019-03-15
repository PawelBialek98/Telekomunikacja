//package com.javacodegeeks.snippets.core;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.*;


public class Main {


    public static void main(String[] args) {
        Pojedynczy pojedynczy = new Pojedynczy();
        Files file = new Files();
        //byte [] kod = file.readFromFile("C:\\Users\\Łukasz\\Desktop\\wiadomosc.txt");
        byte [] kod = file.readFromFile("wiadomosc.txt");
        pojedynczy.BytesToVector(kod);
        pojedynczy.encrypt();

        pojedynczy.changeT();
        byte[] wysylka = pojedynczy.VectorToBytes();
        //file.saveToFile(out,"C:\\Users\\Łukasz\\Desktop\\wiadomosc2.txt");
        file.saveToFile(wysylka,"wiadomoscDoWysylki.txt");

        pojedynczy.decrypt();
        byte [] out = pojedynczy.VectorToBytes();
        file.saveToFile(out,"wiadomoscOdszyfrowana.txt");


    }
}