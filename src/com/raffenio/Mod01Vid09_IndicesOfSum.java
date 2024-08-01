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

    static List<Integer> getIndicesVideoSolution(List<Integer> source, int target) {
/*
        values    sum
        1 2 3       3
                        value to find
        1       (3-1) = 2
        2       (3-2) = 1
        3       (3-3) = 0


        0  1   2   3    4
        7, 17, 13, 19, 55      26

        7 19
        17 9
        13 13
        19 7
        55 -29



*/



        Map<Integer,Integer> indexes = new HashMap<>();
        for (int i = 0; i < source.size(); i++) {
            indexes.put(source.get(i),i);
        }

        System.out.println("value index map");
        indexes.entrySet().stream().forEach(entry-> System.out.println(entry.getKey()+" "+entry.getValue()));

        //now calculate the next number
        for (int i = 0; i < source.size(); i++) {
            int solutionNumber =target - source.get(i);//indexes.get(source.get(i));

            System.out.println("source.get(i) : "+source.get(i) +"  index : "+i);
            System.out.println("solutionNumber: "+solutionNumber);
            System.out.println("contains "+solutionNumber+" ?: "+indexes.containsKey(solutionNumber));
            System.out.println("index?: "+  (indexes.containsKey(solutionNumber) ?indexes.get(solutionNumber):-1)   );

            if(indexes.containsKey(solutionNumber) && indexes.get(solutionNumber) != i ){
                return Arrays.asList(i,indexes.get(solutionNumber));
            }
            System.out.println("--");
        }

        return Arrays.asList(-1,-1);
    }


    public static void main(String[] args) {
                                         //    0   1  2   3    4
        List<Integer> numbers = Arrays.asList( 7, 17, 13, 19, 55 );
        int targetSum = 26;

        List<Integer> result = Mod01Vid09_IndicesOfSum.getIndices(numbers, targetSum);
        System.out.println("shoud print 0 ,3");
        result.stream().forEach(System.out::println);

        System.out.println("\n\n");
        result = Mod01Vid09_IndicesOfSum.getIndicesVideoSolution(numbers, targetSum);
        System.out.println("shoud print 0 ,3");
        result.stream().forEach(System.out::println);

    }
}
