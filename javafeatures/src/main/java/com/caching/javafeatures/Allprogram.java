package com.caching.javafeatures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Allprogram {
    public static void main (String args[]) {
        List<String> names = Arrays.asList("Hari", "Siva", "Brahman");
        //Java 7
//        System.out.println("Java 7");
//        for(String name:names) {
//            System.out.println(name);
//        }
        //Lamda Expression
//        System.out.println("Java 8");
//        names.forEach(name -> System.out.println(name));

        //java 7
//        List<String> FilterByName = new ArrayList<>();
//        for(String name: names) {
//            if (name.startsWith("S")) {
//                FilterByName.add(name);
//            }
//        }
//        System.out.println("Java 7 Traditional method : " +FilterByName);
//
//
        //Java 8
//        List<String> filteredNames = (List<String>) names.stream()
//                .filter(name-> name.startsWith("B"))
//                .toList();
//        System.out.println("Java 8 Features : " + filteredNames);

//        List<String> upper = new ArrayList<>();
//        for(String name : names) {
//            upper.add(name.toUpperCase());
//        }
//        System.out.println("Java 7:" + upper);

        //java 8
        List<String> upper = names.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println("Java 8 Mapping to Uppercase: " + upper);

    }
}
