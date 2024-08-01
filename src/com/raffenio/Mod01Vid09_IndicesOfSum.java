package com.raffenio;
import java.util.*;
import java.util.stream.Collectors;
public class Mod01Vid09_IndicesOfSum {

    static List<Integer> getIndices(List<Integer> source, int target) {
/*
        values    sum
        1 2 3       3
                        value to find
        1       (3-1) = 2
        2       (3-2) = 1
        3       (3-3) = 0


        0  1   2   3
        7, 17, 13, 19, 55      26

        7 19
        17 9
        13 13
        19 7
        55 -29



*/

        //generate themap
        Map<Integer, Integer> mapCalculated = source.stream().collect(Collectors.toMap(value->value, value->target-value/* , mergeFunction, mapFactory*/));

        System.out.println("calculated");
        mapCalculated.entrySet().stream().forEach(en -> System.out.println(en.getKey()+" "+en.getValue()));


        List<Integer> values=mapCalculated.entrySet().stream().filter(entry ->mapCalculated.containsKey(entry.getValue()) &&  entry.getValue() != entry.getKey())
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());

        System.out.println("values");
        values.stream().forEach(System.out::println);

        List<Integer> indexList = values.stream().map(value -> source.indexOf(value)).collect(Collectors.toList());

        System.out.println("indexList");
        indexList.stream().forEach(System.out::println);

        Collections.reverse(indexList);

        return indexList;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList( 7, 17, 13, 19, 55 );
        int targetSum = 26;
        List<Integer> result = Mod01Vid09_IndicesOfSum.getIndices(numbers, targetSum);

        System.out.println("shoud print 0 ,3");

        result.stream().forEach(System.out::println);

    }
}
