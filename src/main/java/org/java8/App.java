package org.java8;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    List<Employee> employeeList = new ArrayList<Employee>();
    List<Integer> arrList = new ArrayList();

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
            return this.empName + " " + this.empAddress + " " + this.empId + " " + this.empContactNumber;
        }
    }

    public void collectrosMethod() {
        Employee emp1 = new App().new Employee("java", "mumbai", 15, 2222222222l);
        Employee emp2 = new App().new Employee("phython", "pune", 25, 123456789l);
        Employee emp3 = new App().new Employee("javaScript", "Latur", 35, 3333333333l);
        Employee emp4 = new App().new Employee("Hari Om", "Banner", 2566541, 78945612300l);
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
        employeeList.add(emp4);

        Map<Integer, List<Employee>> map = employeeList.stream().collect(Collectors.groupingBy((item) -> {
            return item.empId;
        }, () -> {
            return new HashMap<Integer, List<Employee>>();
        }, Collectors.toList()));
        System.out.println(map);

        Map<String, List<Employee>> groupingByConcurrent = employeeList.stream().collect(Collectors.groupingByConcurrent((Employee element) -> {
            return element.empAddress;
        }, () -> {
            return new ConcurrentHashMap<>();
        }, Collectors.toList()));
        System.out.println(groupingByConcurrent);

        String joining = employeeList.stream().map(element -> {
            return element.empName;
        }).collect(Collectors.joining(""));
        System.out.println(joining);

        Map<Integer, List<Integer>> mapping = employeeList.stream()
                .collect(Collectors.groupingBy(element -> element.empId, Collectors.mapping(maping -> maping.empId, Collectors.toList())));

        List<String> mappingTheElement = employeeList.stream()
                .collect(Collectors.mapping(element -> element.empAddress, Collectors.toList()));
        System.out.println(mappingTheElement);

        List<Integer> mappingWithInteger = employeeList.stream().collect(Collectors.mapping(element -> element.empId, Collectors.toList()));
        System.out.println(mappingWithInteger);
//
        Map<Integer, List<Employee>> mapElement = employeeList.stream().collect(Collectors.toMap(element -> element.empId, element2 -> {
            return Collections.singletonList(element2);
//            List<Employee> list = new ArrayList<Employee>();
//            list.add(element2);
//            return list;
        }));
        System.out.println(mapElement);

        List<Integer> mapElement2 = employeeList.stream().collect(Collectors.mapping(mapped -> mapped.empId, Collectors.toList()));

        Optional<Integer> optional = mapElement2.stream().collect(Collectors.minBy((min1, min2) -> {
            return min1.compareTo(min2);
        }));
        System.out.println(optional);

        Map<Boolean, List<Integer>> partitioningBy = employeeList.stream().collect(Collectors.partitioningBy((element) -> {
            return element.empId >= 100;
        }, Collectors.mapping(element -> element.empId, Collectors.toList())));
        System.out.println(partitioningBy);

        Map<Boolean, Map<Integer, Employee>> partitioningByMap = employeeList.stream().collect(Collectors.partitioningBy(predicate -> predicate.empId <= 100, Collectors.toMap(key -> key.empId, value -> value)));
        System.out.println(partitioningByMap);

        arrList.add(20);
        arrList.add(30);
        arrList.add(40);
        arrList.add(55);
        Optional<Integer> optional23 = arrList.stream().collect(Collectors.reducing((ele, ele2) -> {
            return ele + ele2;
        }));
        System.out.println(optional23);

        Optional<Employee> optional12 = employeeList.stream().collect(Collectors.reducing(new BinaryOperator<Employee>() {
            public Employee apply(Employee a, Employee b) {
                return a;
            }
        }));
        System.out.println(optional12);

        Optional<Employee> optional123 = employeeList.stream().collect(Collectors.reducing((Employee emp, Employee emp12) -> {
            return emp;
        }));

        Optional<Integer> returnOptional = arrList.stream().collect(Collectors.reducing((reduce1, reduce2) -> {
            return reduce1 - reduce2;
        }));
        System.out.println(returnOptional);

        //summarizingLong
        LongSummaryStatistics summrizingToLong = arrList.stream().collect(Collectors.summarizingLong((Integer integer) -> {
            return integer;
        }));
        System.out.println(summrizingToLong);

    }

    public void streamMethod() {
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

    public static void main(String[] args) {
        App app = new App();
        app.collectrosMethod();
        app.streamMethod();
    }
}
