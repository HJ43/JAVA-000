package com.las.util;

public class Hello {
    private int a = 1;
    private int b = 2;

    public int add() {
        return a + b;
    }

    public int subtract() {
        return a - b;
    }

    public int multiply() {
        return a * b;
    }

    public int divide() {
        return a / b;
    }

    public static void main(String[] args) {
        Hello hello = new Hello();
        int sum = hello.add();
        hello.subtract();
        hello.multiply();
        hello.divide();
        if (sum > 1) {
            System.out.println("Sum > 1");
        }
        for (int i = 0; i < sum; i++) {
            System.out.println("i=" + i);
        }
    }
}
