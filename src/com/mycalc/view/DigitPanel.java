package com.mycalc.view;

import com.mycalc.controller.MyCalcController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DigitPanel extends JPanel {

    private MyCalcController myCalcController;
    private JButton btn1, btn2, btn3, btn4, btn5, btn6,
        btn7, btn8, btn9, btn0, btnComa, btnEquals;

    public DigitPanel(MyCalcController myCalcController) {

        this.myCalcController = myCalcController;

        setLayout(new GridLayout(4, 3, 10, 10));
        setBorder(new EmptyBorder(10, 10, 10, 10));

        btn1 = new JButton("1");
        btn2 = new JButton("2");
        btn3 = new JButton("3");
        btn4 = new JButton("4");
        btn5 = new JButton("5");
        btn5 = new JButton("5");
        btn6 = new JButton("6");
        btn7 = new JButton("7");
        btn8 = new JButton("8");
        btn9 = new JButton("9");
        btn0 = new JButton("0");
        btnComa = new JButton(",");
        btnEquals = new JButton("=");

        setupDigitPanel();
        setupDigitPanelButtons();
    }

    private void setupDigitPanel() {
        add(btn7);
        add(btn8);
        add(btn9);
        add(btn4);
        add(btn5);
        add(btn6);
        add(btn1);
        add(btn2);
        add(btn3);
        add(btn0);
        add(btnComa);
        add(btnEquals);
    }

    private void setupDigitPanelButtons() {

        btn0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!myCalcController.getMyCalcView().getDisplayPanel().isToReset()) {
                    myCalcController.getMyCalcView().getDisplayPanel().setDisplay("0");
                    myCalcController.getMyCalcModel().setWaitingForDigit(false);
                }
            }
        });

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myCalcController.getMyCalcView().getDisplayPanel().setDisplay("1");
                myCalcController.getMyCalcModel().setWaitingForDigit(false);
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myCalcController.getMyCalcView().getDisplayPanel().setDisplay("2");
                myCalcController.getMyCalcModel().setWaitingForDigit(false);
            }
        });

        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myCalcController.getMyCalcView().getDisplayPanel().setDisplay("3");
                myCalcController.getMyCalcModel().setWaitingForDigit(false);
            }
        });

        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myCalcController.getMyCalcView().getDisplayPanel().setDisplay("4");
                myCalcController.getMyCalcModel().setWaitingForDigit(false);
            }
        });

        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myCalcController.getMyCalcView().getDisplayPanel().setDisplay("5");
                myCalcController.getMyCalcModel().setWaitingForDigit(false);
            }
        });

        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myCalcController.getMyCalcView().getDisplayPanel().setDisplay("6");
                myCalcController.getMyCalcModel().setWaitingForDigit(false);
            }
        });

        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myCalcController.getMyCalcView().getDisplayPanel().setDisplay("7");
                myCalcController.getMyCalcModel().setWaitingForDigit(false);
            }
        });

        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myCalcController.getMyCalcView().getDisplayPanel().setDisplay("8");
                myCalcController.getMyCalcModel().setWaitingForDigit(false);
            }
        });

        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myCalcController.getMyCalcView().getDisplayPanel().setDisplay("9");
                myCalcController.getMyCalcModel().setWaitingForDigit(false);
            }
        });

        btnComa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(myCalcController.getMyCalcView().getDisplayPanel().isToReset()) {
                    myCalcController.getMyCalcView().getDisplayPanel().setDisplay("0,");
                } else if(!myCalcController.getMyCalcView().getDisplayPanel().getDisplay().contains(",")) {
                    myCalcController.getMyCalcView().getDisplayPanel().setDisplay(",");
                }
            }
        });

        btnEquals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                myEquals();

            }
        });
    }

    public void myEquals() {
        if(!myCalcController.getMyCalcModel().isWaitingForDigit()) {
            if(myCalcController.getMyCalcModel().isDigitInMemory()) {
                myCalcController.getMyCalcModel().computeToDisplay(
                        myCalcController.getMyCalcModel().getDigitA(),
                        myCalcController.getMyCalcModel().getDigitFromDisplay(),
                        myCalcController.getMyCalcModel().getStoredOperation());
                myCalcController.getMyCalcModel().setWaitingForDigit(true);
            }
        }
    }

}
