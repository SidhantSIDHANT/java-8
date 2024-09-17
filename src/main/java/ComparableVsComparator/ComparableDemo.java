package ComparableVsComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ComparableTest implements Comparable<ComparableTest> {
    String name;
    int age;
    String address;

    ComparableTest(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String toString() {
        return this.name + " " + this.age + " " + this.address;
    }

    public int compareTo(ComparableTest object) {
        return object.name.compareTo(this.name);
    }
}


public class ComparableDemo {
    public static void main(String[] arg) {
        ComparableTest test1 = new ComparableTest("Java", 20, "java Programming");
        ComparableTest test2 = new ComparableTest("Phython", 50, "Phython Programming");
        ComparableTest test3 = new ComparableTest("JavaScript Programming", 22, "JavaScript ");
        ComparableTest test4 = new ComparableTest("html", 55, "Html Programming");

        List<ComparableTest> list = new ArrayList();
        list.add(test1);
        list.add(test2);
        list.add(test3);
        list.add(test4);
        Collections.sort(list);
        System.out.println(list);

    }
}