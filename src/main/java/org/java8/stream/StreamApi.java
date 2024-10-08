package org.java8.stream;

import java.sql.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    String employeeName;
    String employeeAddress;
    int empId;

    List<StreamApi.Employee> employeeList = new ArrayList<StreamApi.Employee>();
    List<Integer> arrList = new ArrayList();

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

    class Employee {
        String empName;
        String empAddress;
        int empId;
        long empContactNumber;

        public Employee(String empName, String empAddress, int empId, long empContactNumber) {
            this.empName = empName;
            this.empAddress = empAddress;
            this.empId = empId;
            this.empContactNumber = empContactNumber;
        }

        public String toString() {
            return "{" + empName + "," + empAddress + "," + empId + "," + empContactNumber + "}";
        }
    }

    public void streamMethods() {
        Employee emp1 = new Employee("java", "java Programming", 22, 123456789);
        Employee emp2 = new Employee("javaScript", "javaScript Programming", 01, 010101010101);
        Employee emp3 = new Employee("Phython", "Phython Programming", 0365, 55555555555555L);
        Employee emp4 = new Employee("Html", "Html Programming", 22, 125468896545L);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
        employeeList.add(emp4);

        //Remove the reference
        List<Integer> arrList = this.arrList.stream().collect(Collectors.toList());
        arrList.add(10);
        arrList.add(20);
        arrList.add(50);
        arrList.add(40);
        arrList.add(20);
        arrList.add(10);

        System.out.println(this.arrList + " line number 221");

        double getDoubleValue = arrList.stream().collect(Collectors.averagingInt(element -> {
            return element.intValue();
        }));
        System.out.println(getDoubleValue);

        List<Integer> collectingAndThen = arrList.stream().collect(Collectors.collectingAndThen(Collectors.toList(), (element) -> {
            return Collections.unmodifiableList(element);
        }));
        System.out.println(collectingAndThen);

        long counting = arrList.stream().collect(Collectors.counting());
        System.out.println(counting);
        Map<Integer, List<Integer>> map = arrList.stream().collect(Collectors.groupingBy((Integer ele) -> {
            return ele;
        }));

        Map<String, Set<Employee>> employeeMap = employeeList.stream().collect(Collectors.groupingBy(groupElement -> {
            return groupElement.empName;
        }, Collectors.toSet()));
        System.out.println(employeeMap);

        Map<Integer, List<Employee>> employeeMap2 = employeeList.stream().collect(Collectors.groupingBy(groupElement -> groupElement.empId));

        Random random = new Random();
        Stream.generate(random::nextInt).limit(4).forEach(System.out::println);
        this.employeeList.stream().forEachOrdered(element -> {
            System.out.println(element);
        });

        System.out.println("-----------------------------------------------------------------------------");

        this.employeeList.stream().forEach(item -> {
            System.out.println(item);
        });
        List<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(10);
        linkedList.add(50);
        linkedList.add(20);
        linkedList.add(30);
        List<Integer> mappedData = linkedList.stream().peek(System.out::println).map(element -> element * 2).collect(Collectors.toList());
        System.out.println(linkedList);
        List<Integer> sorted = linkedList.stream().sorted().collect(Collectors.toList());
        System.out.println(sorted);
    }

    public void collectrosMethod() {
        StreamApi.Employee emp1 = new StreamApi().new Employee("java", "mumbai", 15, 2222222222L);
        StreamApi.Employee emp2 = new StreamApi().new Employee("phython", "pune", 25, 123456789L);
        StreamApi.Employee emp3 = new StreamApi().new Employee("javaScript", "Latur", 35, 3333333333L);
        StreamApi.Employee emp4 = new StreamApi().new Employee("Hari Om", "Banner", 2566541, 78945612300L);
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
        employeeList.add(emp4);

        Map<Integer, List<StreamApi.Employee>> map = employeeList.stream()
                .collect(Collectors.groupingBy((item) -> {
                    return item.empId;
                }, () -> {
                    return new HashMap<Integer, List<StreamApi.Employee>>();
                }, Collectors.toList()));

        Map<String, List<StreamApi.Employee>> groupingByConcurrent = employeeList.stream()
                .collect(Collectors.groupingByConcurrent((StreamApi.Employee element) -> {
                    return element.empAddress;
                }, () -> {
                    return new ConcurrentHashMap<>();
                }, Collectors.toList()));

        String joining = employeeList.stream().map(element -> {
            return element.empName;
        }).collect(Collectors.joining(""));

        Map<Integer, List<Integer>> mapping = employeeList.stream()
                .collect(Collectors.groupingBy(element -> element.empId, Collectors.mapping(maping -> maping.empId, Collectors.toList())));

        List<String> mappingTheElement = employeeList.stream()
                .collect(Collectors.mapping(element -> element.empAddress, Collectors.toList()));

        List<Integer> mappingWithInteger = employeeList.stream()
                .collect(Collectors.mapping(element -> element.empId, Collectors.toList()));
        //
        Map<Integer, List<StreamApi.Employee>> mapElement = employeeList.stream()
                .collect(Collectors.toMap(element -> element.empId, element2 -> {
                    return Collections.singletonList(element2);
                    // List<Employee> list = new ArrayList<Employee>();
                    // list.add(element2);
                    // return list;
                }));

        List<Integer> mapElement2 = employeeList.stream()
                .collect(Collectors.mapping(mapped -> mapped.empId, Collectors.toList()));

        Optional<Integer> optional = mapElement2.stream()
                .collect(Collectors.minBy((min1, min2) -> {
                    return min1.compareTo(min2);
                }));

        Map<Boolean, List<Integer>> partitioningBy = employeeList.stream()
                .collect(Collectors.partitioningBy((element) -> {
                    return element.empId >= 100;
                }, Collectors.mapping(element -> element.empId, Collectors.toList())));

        Map<Boolean, Map<Integer, StreamApi.Employee>> partitioningByMap = employeeList.stream()
                .collect(Collectors.partitioningBy(predicate -> predicate.empId <= 100, Collectors.toMap(key -> key.empId, value -> value)));

        //Remove the reference
        List<Integer> arrList = this.arrList.stream()
                .collect(Collectors.toList());
        arrList.add(20);
        arrList.add(30);
        arrList.add(40);
        arrList.add(55);

        Optional<Integer> optional23 = arrList.stream()
                .collect(Collectors.reducing((ele, ele2) -> {
                    return ele + ele2;
                }));

        Optional<StreamApi.Employee> optional12 = employeeList.stream()
                .collect(Collectors.reducing(new BinaryOperator<StreamApi.Employee>() {
                    public StreamApi.Employee apply(StreamApi.Employee a, StreamApi.Employee b) {
                        return a;
                    }
                }));

        Optional<StreamApi.Employee> optional123 = employeeList.stream()
                .collect(Collectors.reducing((StreamApi.Employee emp, StreamApi.Employee emp12) -> {
                    return emp;
                }));

        Optional<Integer> returnOptional = arrList.stream()
                .collect(Collectors.reducing((reduce1, reduce2) -> {
                    return reduce1 - reduce2;
                }));

        // summarizingLong
        LongSummaryStatistics summarizingLong = arrList.stream()
                .collect(Collectors.summarizingLong((Integer integer) -> {
                    return integer;
                }));

        Integer summingInt = arrList.stream()
                .collect(Collectors.summingInt(element -> {
                    return 20;
                }));

        Double summrizingToDuble = arrList.stream()
                .collect(Collectors.summingDouble(element -> {
                    return element;
                }));

//        List<Employee> toCollection = employeeList.stream().collect(Collectors.toCollection(() -> {
//            return employeeList;
//        }));
//        System.out.println(toCollection);
    }

    public void createDataBaseConnection() {
        System.out.println("Please Enter the Employee Name");
        Scanner scanner = new Scanner(System.in);
        this.employeeAddress = scanner.next();
        System.out.println("Please Enter the Employee Id");
        this.empId = scanner.nextInt();
        System.out.println("Please Enter the Employee Name");
        this.employeeName = scanner.next();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/employeeInformation", "root", "root@123"); Statement statement = conn.createStatement();) {
                String createSqlDataBase = "CREATE TABLE employeeDetails(employeeName VARCHAR(255), " + "empId INT," + "empAddress VARCHAR(255))";
                try {
                    statement.executeUpdate(createSqlDataBase);
                } catch (SQLSyntaxErrorException se) {
                    try {
                        throw new SQLSyntaxErrorException("Database is created");
                    } catch (SQLSyntaxErrorException sql) {
                        sql.printStackTrace();
                    }
                }

                String insertData = "INSERT INTO employeeDetails (employeeName, empId, empAddress) VALUES (" + " '" + this.employeeName + "', '" + this.empId + "', '" + this.employeeAddress + "')";
                statement.executeUpdate(insertData);
                String selectQuery = "select * from employeeDetails";
                ResultSet resultSet = statement.executeQuery(selectQuery);
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("employeeName"));
                }
            } catch (SQLException ie) {
                ie.printStackTrace();
            }
//            boolean executeQuery = statement.execute("select * from rohit_sharma_centuries");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ie) {
            ie.printStackTrace();
        }
    }

    public static void main(String[] arg) {
        StreamApi streamApi = new StreamApi();
        //        streamApi.binaryOperator();
        //        streamApi.unaryOperator();
        //        streamApi.predicate();
        //        streamApi.function();
        //        streamApi.consumer();
        //        streamApi.supplier();
        //        streamApi.streamMethods();
        streamApi.collectrosMethod();
        streamApi.createDataBaseConnection();
    }
}
