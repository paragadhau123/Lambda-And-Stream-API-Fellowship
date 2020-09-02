package com.bridgelabz.lambdastreamapi.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NumberPlayList {

        public static void numberPlayList(){
            //creating simple collection and adding values on it
            List<Integer> myNumberList = new ArrayList<Integer>();
            for( int i = 1; i < 11 ; i++) {
                myNumberList.add(i);
            }
            //method 1 traversing using Iterator
            Iterator<Integer> it = myNumberList.iterator();

            while(it.hasNext())
            {
                Integer num = it.next();
                System.out.println("method 1 =="+num);
            }

            //method 2 traversing with explicit consumer interface implementation
            class Myconsumer implements Consumer<Integer> {
                @Override
                public void accept(Integer integer) {
                    System.out.println("Method 2 =="+integer);
                }
            }
            Myconsumer action = new Myconsumer();
            myNumberList.forEach(action);
            //method 3 traversing with anonymous consumer interface implementation
            myNumberList.forEach(new Consumer<Integer>() {
                @Override
                public void accept(Integer integer) {
                    System.out.println("method 3 =="+integer);
                }
            });

            //method 4 explicit using lambda expression
            Consumer<Integer> myListAction = integer -> {
                System.out.println("method 4 =="+integer);
            };
            myNumberList.forEach(myListAction);

            //method 5 implicit using lambda expression
            myNumberList.forEach(integer -> System.out.println("method 5 =="+integer));


            //method 6 conversion from integer to double and print double values
            Function<Integer,Double> toDoubleFunction= integer -> integer.doubleValue();
            myNumberList.forEach(integer -> System.out.println("method 6 =="+toDoubleFunction.apply(integer)));

            //method 7 lambda function to check even
            Predicate<Integer> isEven = integer -> integer > 0 && integer%2 == 0;
            myNumberList.forEach(integer -> System.out.println("method7 even no =="+integer+"    "+
                    isEven.test(integer)));

            //Method 8 processing and printing using stream
            myNumberList.stream().forEach( integer -> System.out.println("method8 =="+integer));

            //method 9 process the stream apply operations
            //store the stream
            List<Double> doubleList =  myNumberList.stream().map(toDoubleFunction).collect(Collectors.toList());
            System.out.println("method9 =="+doubleList );

            //method 9 process the stream apply operations
            //store even No in stream
            List<Double> evenList =  myNumberList.stream().filter(isEven).map(toDoubleFunction).collect(Collectors.toList());
            System.out.println("method10 =="+evenList );

            //method 10 process the stream apply operations
            //store 1st even No in stream
            Integer evenFirst =  myNumberList.stream()
                    .filter(isEven)
                    .peek(integer -> System.out.println("Peek First Even Nnumber "+integer))
                    .findFirst()
                    .orElse(null);
            System.out.println("method10 =="+evenFirst );

            //method 11 to get min even no
            Integer min = myNumberList.stream().filter(isEven)
                    .min((n1,n2)->n1-n2)
                    .orElse(null);
            System.out.println("Minimum even number is =="+min);

            //method 12 to get max even no
            Integer max = myNumberList.stream().filter(isEven)
                    .max((n1,n2)->n1-n2)
                    .orElse(null);
            System.out.println("Maximum even number is =="+max);

            //method 13 to find the average of all numbers
            Integer sum = myNumberList.stream()
                    .reduce(0,(n1,n2)->n1-n2);
            long count =myNumberList.stream().count();
            System.out.println("Average of all numbers is "+(sum/count));

            //method 14 checking all even,single even, or none even
            boolean allEven = myNumberList.stream().allMatch(isEven);
            boolean anyEven = myNumberList.stream().anyMatch(isEven);
            boolean anyMulOf6 = myNumberList.stream().anyMatch(integer -> integer !=0 && integer%6 == 0);
            System.out.println("allEven->"+allEven+"   anyEven->"+anyEven+"   anyMulOf6->"+anyMulOf6);

        }

    }



