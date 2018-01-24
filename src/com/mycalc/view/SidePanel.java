package com.mycalc.view;

import com.mycalc.controller.MyCalcController;
import com.mycalc.model.Operation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SidePanel extends JPanel {

    private JButton opPlus, opMinus, opDivide, opMultiply, opRoot, opSquare, opPercent, opLog;
    private MyCalcController myCalcController;

    public SidePanel(MyCalcController myCalcController) {

        this.myCalcController = myCalcController;

        setLayout(new GridLayout(4, 2, 10, 10));
        setBorder(new EmptyBorder(10, 10, 10, 10));

        opPlus = new JButton("+");
        opMinus = new JButton("-");
        opDivide = new JButton("/");
        opMultiply = new JButton("*");
        opRoot = new JButton("\u221A");
        opSquare = new JButton("x^2");
        opPercent = new JButton("%");
        opLog = new JButton("log");

        setupSidePanel();
        setupSidePanelButtons();
    }

    private void setupSidePanel() {
        add(opRoot);
        add(opSquare);
        add(opPercent);
        add(opLog);
        add(opPlus);
        add(opMinus);
        add(opMultiply);
        add(opDivide);
    }

    private void setupSidePanelButtons() {
        opPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                myCalcController.getMyCalcView().getDigitPanel().myEquals();
                myCalcController.getMyCalcModel().setStoredOperation(Operation.PLUS);

                if(!myCalcController.getMyCalcModel().isWaitingForDigit()) {
                    if(!myCalcController.getMyCalcModel().isDigitInMemory()) {
                        myCalcController.getMyCalcModel().fromDisplayToMemory();
                    }
                }
                myCalcController.getMyCalcModel().setWaitingForDigit(true);
            }
        });
        opMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                myCalcController.getMyCalcView().getDigitPanel().myEquals();
                myCalcController.getMyCalcModel().setStoredOperation(Operation.MINUS);

                if(!myCalcController.getMyCalcModel().isWaitingForDigit()) {
                    if(!myCalcController.getMyCalcModel().isDigitInMemory()) {
                        myCalcController.getMyCalcModel().fromDisplayToMemory();
                    }
                }
                myCalcController.getMyCalcModel().setWaitingForDigit(true);
            }
        });
        opMultiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myCalcController.getMyCalcView().getDigitPanel().myEquals();
                myCalcController.getMyCalcModel().setStoredOperation(Operation.MULTIPLY);

                if(!myCalcController.getMyCalcModel().isWaitingForDigit()) {
                    if(!myCalcController.getMyCalcModel().isDigitInMemory()) {
                        myCalcController.getMyCalcModel().fromDisplayToMemory();
                    }
                }
                myCalcController.getMyCalcModel().setWaitingForDigit(true);
            }
        });
        opSquare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myCalcController.getMyCalcView().getDigitPanel().myEquals();
                myCalcController.getMyCalcModel().setStoredOperation(Operation.NONE);

                double ans = myCalcController.getMyCalcModel().getDigitFromDisplay();
                myCalcController.getMyCalcModel().sendToDisplay(ans*ans);
                myCalcController.getMyCalcModel().fromDisplayToMemory();

                myCalcController.getMyCalcModel().setWaitingForDigit(true);
            }
        });
        opRoot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myCalcController.getMyCalcView().getDigitPanel().myEquals();
                myCalcController.getMyCalcModel().setStoredOperation(Operation.NONE);

                double ans = myCalcController.getMyCalcModel().getDigitFromDisplay();
                myCalcController.getMyCalcModel().sendToDisplay(Math.sqrt(ans));
                myCalcController.getMyCalcModel().fromDisplayToMemory();

                myCalcController.getMyCalcModel().setWaitingForDigit(true);
            }
        });
        opLog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myCalcController.getMyCalcView().getDigitPanel().myEquals();
                myCalcController.getMyCalcModel().setStoredOperation(Operation.NONE);

                double ans = myCalcController.getMyCalcModel().getDigitFromDisplay();
                myCalcController.getMyCalcModel().sendToDisplay(Math.log10(ans));
                myCalcController.getMyCalcModel().fromDisplayToMemory();

                myCalcController.getMyCalcModel().setWaitingForDigit(true);
            }
        });
        opPercent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myCalcController.getMyCalcView().getDigitPanel().myEquals();
                myCalcController.getMyCalcModel().setStoredOperation(Operation.PERCENT);

                if(!myCalcController.getMyCalcModel().isWaitingForDigit()) {
                    if(!myCalcController.getMyCalcModel().isDigitInMemory()) {
                        myCalcController.getMyCalcModel().fromDisplayToMemory();
                    }
                }
                myCalcController.getMyCalcModel().setWaitingForDigit(true);
            }
        });
        opDivide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myCalcController.getMyCalcView().getDigitPanel().myEquals();
                myCalcController.getMyCalcModel().setStoredOperation(Operation.DIVIDE);

                if(!myCalcController.getMyCalcModel().isWaitingForDigit()) {
                    if(!myCalcController.getMyCalcModel().isDigitInMemory()) {
                        myCalcController.getMyCalcModel().fromDisplayToMemory();
                    }
                }
                myCalcController.getMyCalcModel().setWaitingForDigit(true);
            }
        });

    }
}