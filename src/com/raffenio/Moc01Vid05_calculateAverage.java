package com.raffenio;

import java.util.Arrays;
import java.util.List;

public class Moc01Vid05_calculateAverage {
    // Return the average value of the source list
    static double getAverage(List<Integer> source) {

        long count = source.stream().count();
        int sum = source.stream().mapToInt(x->x).sum();
        double average = (double) sum/count;

        return average;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList( 7, 17, 13, 19, 5 );
        double result = Moc01Vid05_calculateAverage.getAverage(numbers);

        if(result==12.2){
            System.out.println("OK");
        }else {
            System.out.println("wrong");
        }
    }

}
