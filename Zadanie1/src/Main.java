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
        pojedynczy.encrypt();
        pojedynczy.changeT();
        pojedynczy.decrypt();

    }
}