package com.mycalc.controller;

import com.mycalc.model.MyCalcModel;
import com.mycalc.view.MyCalcView;

public class MyCalcController {

    private MyCalcView myCalcView;
    private MyCalcModel myCalcModel;

    public MyCalcController() {

        myCalcView = new MyCalcView(this);
        myCalcModel = new MyCalcModel(this);
    }


    public MyCalcView getMyCalcView() {
        return myCalcView;
    }

    public MyCalcModel getMyCalcModel() {
        return myCalcModel;
    }
}
