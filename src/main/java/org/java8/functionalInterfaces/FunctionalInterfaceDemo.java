package org.java8.functionalInterfaces;

import java.util.function.*;

public class FunctionalInterfaceDemo {

    public static void main(String[] arg) {
        //predicate
        Predicate<Integer> anonymousPredicateFunction = new Predicate<Integer>() {
            public boolean test(Integer integer) {
                return true;
            }
        };
        anonymousPredicateFunction.test(200);

        Predicate<String> lambdaPredicateFunction = (String a) -> {
            return true;
        };
        lambdaPredicateFunction.test("Java Programming");

        //Function
        Function<Integer, String> anonymousFunction = new Function<Integer, String>() {
            public String apply(Integer integer) {
                return "25";
            }
        };
        anonymousFunction.apply(55);

        Function<Integer, String> lambdaFunction = (Integer integer) -> integer + "";
        lambdaFunction.apply(50);

        //Consumer
        Consumer<Integer> consumerFunction = new Consumer<Integer>() {
            public void accept(Integer integer) {
                for (Integer i = 0; i <= integer; i++) {
                    System.out.println(i);
                }
            }
        };
        consumerFunction.accept(2);

        Consumer<Integer> lambdaConsumerFunction = (Integer integer) -> {
            for (Integer i = 0; i <= integer; i++) {
                System.out.println(i);
            }
        };
        lambdaConsumerFunction.accept(3);

        //Supplier
        Supplier<Integer> supplierFunction = new Supplier() {
            public Integer get() {
                return 10;
            }
        };
        supplierFunction.get();

        Supplier<Integer> lambdaSupplierFunction = () -> {
            return 20;
        };
        lambdaSupplierFunction.get();

        //UnaryOprator
        UnaryOperator<Integer> unaryOperator = new UnaryOperator<Integer>() {
            public Integer apply(Integer integer) {
                System.out.println("Integer value is...");
                return integer;
            }
        };
        unaryOperator.apply(3);
        UnaryOperator<String> lambdaUnaryOperator = (String str) -> {
            System.out.println(str);
            return "Java Programming";
        };
        lambdaUnaryOperator.apply("The java is Programming language");
    }
}