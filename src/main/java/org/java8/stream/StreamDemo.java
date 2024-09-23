package org.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamDemo {
    List<Integer> arrList = new ArrayList();

    public void functionalInterface() {
        this.arrList.add(10);
        this.arrList.add(20);
        this.arrList.add(500);
        Predicate<Integer> predicate = new Predicate<Integer>() {
            public boolean test(Integer t) {
                return t >= 100;
            }
        };
        boolean boolean1 = predicate.test(100);
        System.out.println(boolean1);

        Predicate<Integer> predicateLambdaFunction = (Integer integer) -> {
            return integer >= 100;
        };
        boolean bb = predicateLambdaFunction.test(200);

        Optional<List<Integer>> optional = Optional.ofNullable(this.arrList);
        System.out.println(optional);
        List<Integer> list = optional.stream().flatMap(element -> element.stream()).filter(filterdElement -> {
            return filterdElement >= 20;
        }).collect(Collectors.toList());

        System.out.println(list);


    }

    public static void main(String[] arg) {
//        functionalInterface();
        StreamDemo streamDemo = new StreamDemo();
        streamDemo.functionalInterface();
    }
}