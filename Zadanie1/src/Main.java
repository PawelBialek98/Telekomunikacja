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
        //System.out.println(pojedynczy.getT().get(4));
        //pojedynczy.changeT();

        //file.saveToFile(out,"C:\\Users\\Łukasz\\Desktop\\wiadomosc2.txt");

        pojedynczy.decrypt();
        byte [] out = pojedynczy.VectorToBytes();
        file.saveToFile(out,"wiadomosc2.txt");

    }
}