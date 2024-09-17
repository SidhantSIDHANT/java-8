package com.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayListDemo implements Cloneable {
    public static void main(String[] arg) {
// 1. Write a Java program to create an array list, add some colors (strings) and print out the collection.
        List<String> colorsList = new ArrayList();
        colorsList.add("red");
        colorsList.add("blue");
        colorsList.add("green");
        colorsList.add("orange");
        colorsList.add("pink");
//        Write a Java program to iterate through all elements in an array list.
        System.out.println("----------------way-3--------------------");
        colorsList.forEach(element -> {
            if (element.length() <= 3) {
                System.out.println(element);
            }
        });
        System.out.println("----------------way-2--------------------");
        for (String element : colorsList) {
            if (element.length() >= 6) {
                System.out.println(element);
            }
        }
        System.out.println("------------------way-3------------------");
        for (int i = 0; i < colorsList.size(); i++) {
            if (colorsList.get(i).length() >= 3 && colorsList.get(i).length() <= 4) {
                System.out.println(colorsList.get(i));
            }
        }
        System.out.println("------------------way-4------------------");
        Iterator iterator = colorsList.iterator();
        while (iterator.hasNext()) {
            String element = (String) iterator.next();
            if (element.length() >= 3) {
                System.out.println(element);
            }
        }
//        Write a Java program to insert an element into the array list at the first position.
        colorsList.add(0, "Inserted Fist Index Element ");
        System.out.println(colorsList);
//        Write a Java program to retrieve an element (at a specified index) from a given array list.
        System.out.println(colorsList.get(5));
//        Write a Java program to update an array element by the given element
        String element = colorsList.set(2, "programming in java");
        colorsList.add(2, "java");
        System.out.println(colorsList);

//        Write a Java program to remove the third element from an array list
        int findIndexElement = colorsList.indexOf(colorsList.get(3));
        colorsList.remove(findIndexElement);

//        Write a Java program to search for an element in an array list.
        if (colorsList.contains("java".toLowerCase())) {
            colorsList.remove(colorsList.indexOf(colorsList.get(2)));
        }
//        8. Write a Java program to sort a given array list.

        Collections.sort(colorsList);
//        9. Write a Java program to copy one array list into another.
        List<String> copyOnNewArrayList =  colorsList.stream().collect(Collectors.toList());
        copyOnNewArrayList.clear();
        System.out.println(colorsList + " "+ copyOnNewArrayList);

    }
}