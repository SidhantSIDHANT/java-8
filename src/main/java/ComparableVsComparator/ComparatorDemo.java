package ComparableVsComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee {
    int age;
    String name;
    String address;
    int employeeId;

    Employee(int age, String name, String address, int employeeId) {
        this.age = age;
        this.name = name;
        this.address = address;
        this.employeeId = employeeId;
    }

    public String toString() {
        return age + " " + name + " " + address + " " + employeeId;
    }
}

class EmployeeSortingWithComparator implements Comparator<Employee> {
    public int compare(Employee emp, Employee emp2) {
        return emp.name.compareTo(emp2.name);
    }
}

public class ComparatorDemo {
    public static void main(String[] arg) {
        Employee emp1 = new Employee(10, "java", "Java Programming", 1);
        Employee emp2 = new Employee(30, "phython", "phython programming", 3);
        Employee emp3 = new Employee(40, "javaScript", "javaScript", 5);
        Employee emp4 = new Employee(50, "phython", "phython", 6);
        List<Employee> list = new ArrayList();
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
        list.add(emp4);
        Collections.sort(list, new EmployeeSortingWithComparator());
        System.out.println(list);
    }
}