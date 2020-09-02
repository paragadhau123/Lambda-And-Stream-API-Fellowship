package com.bridgelabz.lambdastreamapi.model;

@FunctionalInterface
interface IMathOperation {
    int operation(int a, int b);

    static void printResult(int a, int b, String function, IMathOperation mobj) {
        System.out.println("Result of " + function + " is " + mobj.operation(a, b));
    }
}

@FunctionalInterface
interface StringInterface {
    String strConcat(String a, String b);
}