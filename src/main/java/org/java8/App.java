package org.java8;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.Optional;

public class App {
	
    public static void main(String[]args) {
        List < Integer > copyOnWriteArrayList = new CopyOnWriteArrayList < Integer > ();
        copyOnWriteArrayList.add(43);
        copyOnWriteArrayList.add(10);
        copyOnWriteArrayList.add(20);
        copyOnWriteArrayList.add(30);
        copyOnWriteArrayList.add(23);

        System.out.println(copyOnWriteArrayList);
        List < Integer > oddNumberList = new ArrayList < Integer > ();
        copyOnWriteArrayList.forEach((element)->{
            if (element % 2 == 0) {
                oddNumberList.add(element);
            }
        });
        List < Integer > oddNumberList2 = copyOnWriteArrayList.stream().filter((Integer element)->{
            return element % 2 == 0;
        }).collect(Collectors.toList());
        // System.out.println(oddNumberList2.stream().count());

        Optional < Integer > findFirst = oddNumberList.stream().findFirst();
        System.out.println(findFirst);
		if(findFirst.isPresent()){
			Integer value = findFirst.get();
			System.out.println(value);
		}
		
//		Optional<Integer> findLast = oddNumberList.stream().findLast();
    }
}
