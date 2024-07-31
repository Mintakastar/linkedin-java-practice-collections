package com.raffenio;

import java.util.*;
public class Mod01Vid01FindOcurrences {
    // Change these boolean values to control whether you see
    // the expected result and/or hints.
    static boolean showExpectedResult = true;
    static boolean showHints = true;

    // Return the number of occurrences of word in source
    static int getOccurrences(String source, String word) {
        // Your code goes here.

        /*
        String[] list = source.split(word);
        //"it was a long day. it was also hot outside. that's hot it was"// OK
        //"it was a long day. it was also hot outside. that's hot it"// NO

        return list.length;
        */
        //Arrays.stream(source.split(" ")).forEach(x-> System.out.println(x));
        source=source.replaceAll("\\.","");
        long count= Arrays.stream(source.split(" ")).filter( x ->  x.equalsIgnoreCase(word)).count();
        System.out.println(count);
        return (int)count;

    }

    public static void main(String[] args) {

        String source = "Here is an example. Right here";
        String word = "here";
        int result = Mod01Vid01FindOcurrences.getOccurrences(source, word);
        if(result == 2){
            System.out.println("This is fine: "+result);
        }else{
            System.out.println("Wrong answer "+result);
        }


        source = "Here is an example. Right here.";
        word = "here";
        result = Mod01Vid01FindOcurrences.getOccurrences(source, word);
        if(result == 2){
            System.out.println("This is fine: "+result);
        }else{
            System.out.println("Wrong answer "+result);
        }

        source = "Here is an example. Right here. here.";
        word = "here";
        result = Mod01Vid01FindOcurrences.getOccurrences(source, word);
        if(result == 3){
            System.out.println("This is fine: "+result);
        }else{
            System.out.println("Wrong answer "+result);
        }

    }
}
