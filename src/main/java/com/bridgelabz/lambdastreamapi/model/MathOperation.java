package com.bridgelabz.lambdastreamapi.model;

import java.util.ArrayList;
import java.util.List;

public class MathOperation {
    public static void lambdaExample() {
        System.out.println("\nLambda Operations");
        IMathOperation add = Integer::sum;
        IMathOperation sub = (a, b) -> a - b;
        IMathOperation mul = (a, b) -> a * b;
        IMathOperation div = (a, b) -> a / b;
        System.out.println("12 + 10 = " + add.operation(12, 10));
        System.out.println("12 - 10 = " + sub.operation(12, 10));
        System.out.println("12 * 10 = " + mul.operation(12, 10));
        System.out.println("12 / 10 = " + div.operation(12, 10));
        StringInterface strConcat = (str1, str2) -> str1 + str2;
        System.out.println(strConcat.strConcat("Hello ", "Java"));
        List<String> list = new ArrayList<>();
        list.add("parag");
        list.add("adhau");
        list.add("KA");
        list.forEach(System.out::println);
        //Passing lambda expression as function parameter to print result
        IMathOperation.printResult(5, 4, "Addition", add);
        IMathOperation.printResult(5, 4, "Substraction", sub);
        IMathOperation.printResult(5, 4, "Multiplication", mul);
        IMathOperation.printResult(5, 4, "Division", div);
    }
  }


