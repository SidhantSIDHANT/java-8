package org.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

interface ILabmdaUsed<T> {
    public void show(T a, T b);
}

public class StreamMap {
    public void streamMethods() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(40);
        list.add(20);
        list.add(30);
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        int result = 0;
        Integer reduce = list.stream().reduce(0, (element, element2) -> {
            return element + element2;
        });

        Optional<List> optionalList = Optional.of(list);

        int a = !optionalList.isPresent() ? 10 : 20;

        Stream<Integer> stream = list.stream().map(element -> element * 1);

        Stream.Builder builder = Stream.builder();
        builder.add("java");
        builder.add("programming");
        builder.add("java is programming ");
        builder.build().forEach(System.out::println);

        long count = list.stream().count();

        List<Integer> removeDuplicate = list.stream().distinct().collect(Collectors.toList());

        removeDuplicate.stream().filter(element -> {
            return element / 2 == 0;
        }).collect(Collectors.toList());

        Optional<Integer> optional = list.stream().parallel().findFirst();
        List<List<Integer>> arrList = new ArrayList<List<Integer>>();
        arrList.add(list);
        arrList.add(removeDuplicate);

        IntStream intStream = list.stream().flatMapToInt(element -> IntStream.of(element));

        DoubleStream intStream2 = arrList.stream().flatMap(item -> {
            return item.stream();
        }).mapToDouble(element -> element * 2);

        intStream2.forEach(element -> {
            System.out.println(element);
        });

        Optional<Integer> maxValue = list.stream().max((Integer i1, Integer i2) -> {
            return i1.compareTo(i2);
        });

        Optional<Integer> minimumValue = list.stream().min((Integer i1, Integer i2) -> {
            return i1.compareTo(i2);
        });

        Integer reduceValue = list.stream().reduce(0, (element1, element2) -> {
            return element1 + element2;
        });

        List<Integer> skip = list.stream().skip(8).collect(Collectors.toList());

        list.stream().sorted().forEach(element -> {
            System.out.println(element);
        });

        List<Integer> mapList = list.parallelStream().map((var element) -> {
            return element * 50;
        }).collect(Collectors.toList());
    }

    public static void main(String[] arg) {
        StreamMap streamMap = new StreamMap();
        streamMap.streamMethods();
    }
}