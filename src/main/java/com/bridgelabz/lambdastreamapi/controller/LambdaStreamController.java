package com.bridgelabz.lambdastreamapi.controller;

import com.bridgelabz.lambdastreamapi.model.MathOperation;
import com.bridgelabz.lambdastreamapi.model.NumberPlayList;
import com.bridgelabz.lambdastreamapi.model.StreamOperationExample;

import java.util.Scanner;

public class LambdaStreamController {
    public static void main(String[] args) {
        int i = 0;
        Scanner input = new Scanner(System.in);
        while (i == 0) {
            System.out.println("\nJAVA 8 Features Implementation\n" +
                    "1. Math Operation\n" +
                    "2. Stream Examples\n" +
                    "3. Number Play List\n"+
                    "4. Exit");
            int choice = input.nextInt();
            switch (choice) {
                case 1 -> MathOperation.lambdaExample();
                case 2 -> StreamOperationExample.streamExample();
                case 3 -> NumberPlayList.numberPlayList();
                case 4 -> i = 1;
            }
        }
    }
}
