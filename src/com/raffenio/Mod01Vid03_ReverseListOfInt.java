package com.raffenio;

import java.util.*;
import java.util.stream.Collectors;

public class Mod01Vid03_ReverseListOfInt {
    // Change these boolean values to control whether you see
    // the expected result and/or hints.
    static boolean showExpectedResult = false;
    static boolean showHints = false;

    // Return a new list in reversed order
    static List<Integer> getReversed(List<Integer> source) {

        //prints
        //List<Integer>  result =
        source.stream()
                .collect(Collectors.toCollection(ArrayDeque::new))
                .descendingIterator()
                .forEachRemaining(System.out::println);
        //.collect(Collectors.toList());


        List<Integer>  result = new ArrayList<>();

        source.stream()
                .collect(Collectors.toCollection(ArrayDeque::new))
                .descendingIterator()
                .forEachRemaining(x -> result.add(x));
        return result;
    }

    static List<Integer> getReversedSolution02(List<Integer> source) {
        Collections.reverse(source); //reverses the list passed
        return source;
    }

    static List<Integer> getReversedSolution03(List<Integer> source) {
        List<Integer> result = new ArrayList<>(source);  //craate a copy first of the list
        Collections.reverse(result); //reverses the result list , this does not affect the source list
        return result;
    }

    public static void main(String[] args) {

        // This is how your code will be called.
    // Your answer should be a new list in reverse order.
    // You can edit this code to try different testing cases.
        List<Integer> numbers = Arrays.asList( 7, 17, 13, 19, 5 );
        List<Integer> result = Mod01Vid03_ReverseListOfInt.getReversed(numbers);

        System.out.println("\\result1:");
        result.stream().forEach(System.out::println);



        numbers = Arrays.asList( 7, 17, 13, 19, 5 );
        result = Mod01Vid03_ReverseListOfInt.getReversedSolution02(numbers);

        System.out.println("\\result 02:");
        result.stream().forEach(System.out::println);




        numbers = Arrays.asList( 7, 17, 13, 19, 5 );
        result = Mod01Vid03_ReverseListOfInt.getReversedSolution03(numbers);

        System.out.println("\\result 03:");
        result.stream().forEach(System.out::println);
    }
}
