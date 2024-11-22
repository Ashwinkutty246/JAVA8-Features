package com.caching.javafeatures;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.Base64;

public class JavaFeatures {

    public static void main(String[] args) {
        // 1. Lambda Expressions
        List<String> names = Arrays.asList("John", "Jane", "Jack", "Doe");
        names.forEach(name -> System.out.println("Name: " + name));

        // 2. Method References
        names.forEach(System.out::println);

        // 3. Functional Interfaces - Predicate, Function, Consumer, Supplier
        Predicate<String> startsWithJ = s -> s.startsWith("J");
        names.stream().filter(startsWithJ).forEach(System.out::println);

        Function<String, Integer> stringLength = String::length;
        System.out.println("Length of 'Jane': " + stringLength.apply("Jane"));

        // 4. Stream API - Filtering, Mapping, Collecting
        List<String> filteredNames = names.stream()
                .filter(name -> name.length() > 3) // Lambda used here
                .map(String::toUpperCase) // Method reference here
                .collect(Collectors.toList());
        System.out.println("Filtered and Mapped Names: " + filteredNames);

        // 5. Optional - Handling null values gracefully
        Optional<String> optionalName = names.stream().filter(startsWithJ).findFirst();
        optionalName.ifPresent(name -> System.out.println("Found: " + name));
        System.out.println("Or Else: " + optionalName.orElse("Default"));

        // 6. Default and Static Methods in Interfaces
        MyInterface myInterface = new MyInterfaceImpl();
        myInterface.defaultMethod();
        MyInterface.staticMethod();

        // 7. New Date and Time API - LocalDate, LocalTime, LocalDateTime
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Current DateTime: " + LocalDateTime.now());

        // 8. Type Inference with 'var' in Lambda (valid within lambda expressions only)
        names.forEach((var name) -> System.out.println("Name with var: " + name));

        // 9. Parallel Streams for Multithreading
        IntStream.range(1, 10).parallel().forEach(System.out::println);

        // 10. Collectors Grouping By
        Map<Integer, List<String>> namesByLength = names.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("Names Grouped By Length: " + namesByLength);

        // 11. Base64 Encoding and Decoding
        String originalString = "Hello Java 8!";
        String encoded = Base64.getEncoder().encodeToString(originalString.getBytes());
        System.out.println("Encoded: " + encoded);
        String decoded = new String(Base64.getDecoder().decode(encoded));
        System.out.println("Decoded: " + decoded);
    }
}

// Functional Interface with Default and Static Methods
interface MyInterface {
    // Default method
    default void defaultMethod() {
        System.out.println("Default method in interface.");
    }

    // Static method
    static void staticMethod() {
        System.out.println("Static method in interface.");
    }
}

// Class implementing the Functional Interface
class MyInterfaceImpl implements MyInterface {
}
