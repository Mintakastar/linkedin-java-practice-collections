package com.raffenio;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Mod01Vid07_WordsWithFive {
    static List<String> findFiveOrFewer(String source) {

        List<String> result = Arrays.stream(source.split(" "))
                .filter( word -> word.length()<=5)
                .collect(Collectors.toList());


        return result;
    }

    public static void main(String[] args) {
        String source = "there are both smaller and bigger words here";
        List<String> result = Mod01Vid07_WordsWithFive.findFiveOrFewer(source);

        System.out.println("resultado esperado '[there, are, both, and, words, here]': ");
        result.stream().forEach(System.out::println);
    }

}
