package org.java8;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class App {

    List<Employee> employeeList = new ArrayList<Employee>();

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
            //
        }, () -> {
            return new ConcurrentHashMap<>();
            //
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
//            List<Employee> list = new ArrayList<Employee>();
//            list.add(element2);
//            return list;
            return Collections.singletonList(element2);
        }));
        System.out.println(mapElement);

        List<Integer> mapElement2 = employeeList.stream().collect(Collectors.mapping(mapped -> mapped.empId, Collectors.toList()));

        Optional<Integer> optional = mapElement2.stream().collect(Collectors.minBy((min1, min2) -> {
            return min1.compareTo(min2);
        }));
        System.out.println(optional);
    }

    public void streamMethod() {

    }

    public static void main(String[] args) {
        App app = new App();
        app.collectrosMethod();
        app.streamMethod();
    }
}
