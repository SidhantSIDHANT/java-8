package org.java8.stream;

import java.util.function.*;

class PredicateDemo implements Predicate<Integer> {
    @Override
    public boolean test(Integer integer) {
        return false;
    }
}

class BiPredicateDemo implements BiPredicate<String, String> {
    @Override
    public boolean test(String str1, String str2) {
        return true;
    }
}

class FunctionDemo implements Function<String, String> {
    @Override
    public String apply(String str) {
        return str;
    }
}

class BiFunctionDemo implements BiFunction<Integer, Integer, Integer> {
    public Integer apply(Integer i2, Integer i3) {
        return i2 + i3;
    }
}

class ConsumerDemo implements Consumer<Integer> {
    public void accept(Integer integer) {
        for (int i = 0; i <= integer; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}

class SupplierDemo implements Supplier<Integer> {
    public Integer get() {
        return 50;
    }
}

class UnaryOperatorDemo implements UnaryOperator<Integer> {
    @Override
    public Integer apply(Integer integer) {
        return integer;
    }
}

class BinaryOperatorDemo implements BinaryOperator<String> {
    @Override
    public String apply(String string1, String string2) {
        return string1 + string2;
    }
}

public class StreamApi {

    public void binaryOperator() {
        BinaryOperator<String> binaryOperatorAnonymousFunction = new BinaryOperator<String>() {
            public String apply(String string1, String string2) {
                return string1 + string2;
            }
        };
        binaryOperatorAnonymousFunction.apply("Java ", "Programming");

        BinaryOperator<Integer> binaryOperatorLambdaFunction = (Integer integer1, Integer integer2) -> {
            return integer1 + integer2;
        };
        Integer integerValue = binaryOperatorLambdaFunction.apply(10, 30);
        System.out.println(integerValue);
    }

    public void unaryOperator() {
        UnaryOperator<String> unaryOperatorAnonymousFunction = new UnaryOperator<String>() {
            public String apply(String str) {
                return str;
            }
        };
        String getString = unaryOperatorAnonymousFunction.apply("java8");
        System.out.println(getString);

        UnaryOperator<Integer> unaryOperatorLambdaFunction = (Integer integer) -> {
            return integer;
        };
        Integer getInteger = unaryOperatorLambdaFunction.apply(20);
        System.out.println(getInteger);
    }

    public void predicate() {
        Predicate<Integer> predicateAnonymousFunction = new Predicate<Integer>() {
            public boolean test(Integer integer) {
                return false;
            }
        };
        predicateAnonymousFunction.test(259);

        Predicate<Integer> predicateLambdaFunction = (Integer integer) -> {
            return false;
        };
        predicateLambdaFunction.test(10);
    }

    public void function() {
        Function<Integer, Integer> functionAnonymous = new Function<Integer, Integer>() {
            public Integer apply(Integer integer) {
                return integer;
            }
        };

        Function<Integer, Integer> functionLambda = (Integer integer) -> {
            return integer;
        };
        functionLambda.apply(500);

        BiFunction<Integer, Integer, String> biFunctionAnonymousFunction = new BiFunction<Integer, Integer, String>() {
            public String apply(Integer integer3, Integer integer4) {
                return integer3 + integer4 + "";
            }
        };
    }

    public void consumer() {
        Consumer<Integer> consumerAnonymousFunction = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                for (int i = 0; i <= integer; i++) {
                    try {
                        Thread.sleep(1000);
                        System.out.println(i);
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
            }
        };
        consumerAnonymousFunction.accept(2);

        Consumer<Integer> consumerLambdaFunction = (Integer integer) -> {
            for (int i = 0; i <= integer; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.println(i);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        };
        consumerLambdaFunction.accept(2);
    }

    public void supplier() {
        Supplier<StringBuilder> supplierAnonymousFunction = new Supplier<StringBuilder>() {
            @Override
            public StringBuilder get() {
                return new StringBuilder();
            }
        };
        StringBuilder stringBuilder = supplierAnonymousFunction.get();
        stringBuilder.append("java is programming language");
        System.out.println(stringBuilder);

        Supplier<StringBuffer> supplierLambdaFunction = () -> {
            return new StringBuffer();
        };
        StringBuffer stringBuffer = supplierLambdaFunction.get();
    }

    public static void main(String[] arg) {
        StreamApi streamApi = new StreamApi();
        streamApi.binaryOperator();
        streamApi.unaryOperator();
        streamApi.predicate();
        streamApi.function();
        streamApi.consumer();
        streamApi.supplier();
    }
}