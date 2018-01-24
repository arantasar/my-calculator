package com.mycalc.model;

import com.mycalc.controller.MyCalcController;

public class MyCalcModel {

    private double digitA, digitB;
    private boolean digitInMemory, waitingForDigit;
    private MyCalcController myCalcController;
    private Operation storedOperation = Operation.NONE;


    public MyCalcModel(MyCalcController myCalcController) {
        this.myCalcController = myCalcController;
        digitA = 0;
        digitB = 0;
        digitInMemory = false;
        waitingForDigit = true;
    }

    public double compute(double a, double b, Operation operation) {
        double result = 0;
        switch (operation) {
            case PLUS:
                result = a + b;
                break;
            case MINUS:
                result = a - b;
                break;
            case MULTIPLY:
                result = a * b;
                break;
            case DIVIDE:
                if(b!=0) {
                    result = a / b;
                }
                break;
            case LOG:
                result = Math.log(a);
                break;
            case SQUARE:
                result = a * a;
                break;
            case ROOT:
                result = Math.sqrt(a);
                break;
            case PERCENT:
                result = (a * b) / 100;
        }
        return result;
    }

    // METODY POMOCNICZE

    private String doubleToString(double a) {
        String ans;
        if(a == (long) a) {
            ans = String.format("%d",(long)a);
        }
        else {
            ans = String.format("%s",a);
        }
        if (ans.contains(".")) {
            ans = ans.replace(".", ",");
        }
        return ans;
    }

    private double stringToDouble(String a) {
        if (a.contains(",")) {
            a = a.replace(",", ".");
        }
        return Double.parseDouble(a);
    }

    // METODY DOSTEPNE Z ZEWNATRZ

    public void fromDisplayToMemory() {
        String display = myCalcController.getMyCalcView().getDisplayPanel().getDisplay();
        digitA = stringToDouble(display);
        digitInMemory = true;
        myCalcController.getMyCalcView().getDisplayPanel().setToReset(true);
    }

    public void computeToDisplay(double a, double b, Operation operation) {
        double res = compute(a, b, operation);
        digitA = res;
        String sres = doubleToString(res);
        myCalcController.getMyCalcView().getDisplayPanel().setDisplay(sres);
        myCalcController.getMyCalcView().getDisplayPanel().setToReset(true);
    }

    public double getDigitFromDisplay() {
        myCalcController.getMyCalcView().getDisplayPanel().setToReset(true);
        return stringToDouble(myCalcController.getMyCalcView().getDisplayPanel().getDisplay());
    }

    public void sendToDisplay(double a) {
        myCalcController.getMyCalcView().getDisplayPanel().setDisplay(
                doubleToString(a)
        );
    }

    public double getDigitA() {
        return digitA;
    }

    public void setDigitA(double digitA) {
        this.digitA = digitA;
    }

    public double getDigitB() {
        return digitB;
    }

    public void setDigitB(double digitB) {
        this.digitB = digitB;
    }

    public boolean isDigitInMemory() {
        return digitInMemory;
    }

    public void setDigitInMemory(boolean digitInMemory) {
        this.digitInMemory = digitInMemory;
    }

    public boolean isWaitingForDigit() {
        return waitingForDigit;
    }

    public void setWaitingForDigit(boolean waitingForDigit) {
        this.waitingForDigit = waitingForDigit;
    }

    public Operation getStoredOperation() {
        return storedOperation;
    }

    public void setStoredOperation(Operation storedOperation) {
        this.storedOperation = storedOperation;
    }
}