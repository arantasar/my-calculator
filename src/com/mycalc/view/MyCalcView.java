package com.mycalc.view;

import com.mycalc.controller.MyCalcController;
import com.mycalc.view.DigitPanel;
import com.mycalc.view.DisplayPanel;

import javax.swing.*;
import java.awt.*;

public class MyCalcView extends JFrame{

    private DisplayPanel displayPanel;
    private DigitPanel digitPanel;
    private SidePanel sidePanel;
    private MyCalcController myCalcController;

    public MyCalcView(MyCalcController myCalcController) {

        this.displayPanel = new DisplayPanel(myCalcController);
        this.digitPanel = new DigitPanel(myCalcController);
        this.sidePanel = new SidePanel(myCalcController);
        this.myCalcController = myCalcController;

        setupFrame();

    }

    public void setupFrame() {
        setTitle("MyCalc");
        setSize(420, 320);
        setLayout(new BorderLayout());
        add(displayPanel, BorderLayout.NORTH);
        add(digitPanel, BorderLayout.CENTER);
        add(sidePanel, BorderLayout.EAST);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public DisplayPanel getDisplayPanel() {
        return displayPanel;
    }

    public DigitPanel getDigitPanel() {
        return digitPanel;
    }

    public SidePanel getSidePanel() {
        return sidePanel;
    }
}