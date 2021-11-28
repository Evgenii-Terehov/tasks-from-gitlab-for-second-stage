package com.epam.tat.calculator.impl;

import com.epam.tat.calculator.ICalculator;

public class Calculator implements ICalculator {

    private int precision;

    public Calculator(int precision) {
        this.precision = precision;
    }

    @Override
    public double add(double a, double b) {
        double res = a + b;
        if (res != Double.POSITIVE_INFINITY && res != Double.NEGATIVE_INFINITY) {
            return Math.round(res * Math.pow(10, 2)) / Math.pow(10, 2);
        } else {
            return res;}
    }

    @Override
    public double subtract(double a, double b) {
        double res = a - b;
        if (res != Double.POSITIVE_INFINITY && res != Double.NEGATIVE_INFINITY) {
            return Math.round(res * Math.pow(10, 2)) / Math.pow(10, 2);
        } else {
            return res;}
    }

    @Override
    public double multiply(double a, double b) {
        double res = a * b;
        if (res != Double.POSITIVE_INFINITY && res != Double.NEGATIVE_INFINITY) {
            return Math.round(res * Math.pow(10, 2)) / Math.pow(10, 2);
        } else {
            return res;}
    }

    @Override
    public double divide(double a, double b) {
        double res = a / b;
        if (res != Double.POSITIVE_INFINITY && res != Double.NEGATIVE_INFINITY) {
            return Math.round(res * Math.pow(10, 2)) / Math.pow(10, 2);
        } else {
            return res;
        }
    }
}
