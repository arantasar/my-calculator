package com.mycalc.view;

import com.mycalc.controller.MyCalcController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayPanel extends JPanel {

    private String display;
    private int maxDisplayLen;
    private boolean toReset;
    private JTextField displayTextField;
    private JButton btnDisplayClear;
    private MyCalcController myCalcController;

    public DisplayPanel(MyCalcController myCalcController) {

        this.myCalcController = myCalcController;

        display = "0";
        toReset = true;
        maxDisplayLen = 15;
        displayTextField = new JTextField(display);
        btnDisplayClear = new JButton("C");

        setupDisplayPanel();
        setupDisplayPanelButtons();
    }

    private void setupDisplayPanel() {

        displayTextField.setHorizontalAlignment(SwingConstants.RIGHT);
        displayTextField.setFont(displayTextField.getFont().deriveFont(displayTextField.getFont().getSize() + 10f));
        displayTextField.setEditable(false);
        displayTextField.setBackground(new Color(255, 255, 255));
        displayTextField.setBorder(new EmptyBorder(0, 10, 0, 10));

        setLayout(new BorderLayout(10, 0));
        setBorder(new EmptyBorder(10, 10, 10, 10));

        add(displayTextField, BorderLayout.CENTER);
        add(btnDisplayClear, BorderLayout.EAST);

    }

    private void setupDisplayPanelButtons() {
        btnDisplayClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetDisplay();
                myCalcController.getMyCalcModel().setDigitInMemory(false);
            }
        });
    }

    public void setDisplay(String newDisplayContent) {
        if(toReset) {
            displayTextField.setText(newDisplayContent);
            toReset = false;
        } else {
            if (displayTextField.getText().length() <= maxDisplayLen) {
                displayTextField.setText(displayTextField.getText() + newDisplayContent);
            }
        }
    }

    public String getDisplay() {
        return displayTextField.getText();
    }

    public void resetDisplay() {
        displayTextField.setText("0");
        toReset = true;
    }

    public boolean isToReset() {
        return toReset;
    }

    public void setToReset(boolean toReset) {
        this.toReset = toReset;
    }
}