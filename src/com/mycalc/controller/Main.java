package com.mycalc.controller;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        // OKNO SYSTEMOWE

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // KONIEC OKNA SYSTEMOWEGO

        new MyCalcController();

    }
}

