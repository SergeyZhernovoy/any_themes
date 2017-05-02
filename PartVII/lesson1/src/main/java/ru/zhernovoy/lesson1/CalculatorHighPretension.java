package ru.zhernovoy.lesson1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public strictfp  class CalculatorHighPretension implements Calculation,UI{

    private static final Logger logger = LoggerFactory.getLogger(CalculatorHighPretension.class);

    private double result = 0;

    private String strResult = "";

    private double operand;

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public double getOperand() {
        return operand;
    }

    public void setOperand(double operand) {
        this.operand = operand;
    }

    @Override
    public double multiplex(double result, double operand) {
        return 0;
    }

    @Override
    public double add(double result, double operand) {
        this.result = this.result + operand;
        this.strResult = printResult(String.valueOf(operand));
        return 0;
    }

    @Override
    public double divide(double result, double operand) {
        return 0;
    }

    @Override
    public double sub(double result, double operand) {
        return 0;
    }

    @Override
    public String printResult(String operand) {
        String calcResult  = String.join("/",this.strResult,operand);
        System.out.println(calcResult);
        return calcResult;
    }
}

    