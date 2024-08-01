package com.raffenio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;


/**
 *
 * info from
 *  https://www.baeldung.com/java-stream-reduce
 *  and
 *  https://www.arquitecturajava.com/java-stream-reduce-eliminando-bucles/
 */
public class Mod01Vid05_calculateAverage_reduceExamples {
    public static void main(String[] args) {
        /*
        reduce ( acumulador, elemento )
          acumulador: acumula iteraciones
          elemento  : elemento iteracion

        Convierte una lista de elementos en un unico resultado

         */

        System.out.println("ejemplo uno acumular el gasto resultado 600 :");

        List<Integer> gastos = new ArrayList<>();
        gastos.add(100);
        gastos.add(200);
        gastos.add(300);

        System.out.println("Primer solucion");
        //sumar los gastos
        gastos.stream().reduce((acumulador, numero) -> {
            return acumulador + numero;
        }).ifPresent(System.out::println);

        System.out.println("Segunda solucion");
        gastos.stream().reduce(Integer::sum).ifPresent(System.out::println);

        //se puede utilizar el metodo de reduccion para combinar cadenas tambien


        System.out.println("\n\nejemplo concatenar cadenas:");
        List<String> nombres= new ArrayList<String>();
        nombres.add("juan");
        nombres.add("gema");
        nombres.add("maria");

        System.out.println("Solucion 1:");
        nombres.stream().reduce((acumularor,elemento)->{return acumularor+" "+elemento;}).ifPresent(System.out::println);

        System.out.println("Solucion 2:");
        nombres.stream().reduce(String::concat).ifPresent(System.out::println);





        System.out.println("\n\nejemplo sumar enteros positivos, resultado debe de ser 50:");

        List<Integer> integers = new ArrayList<>();
        integers.add(10);
        integers.add(0);
        integers.add(-5);
        integers.add(10);
        integers.add(-10);
        integers.add(10);
        integers.add(20);

        System.out.println("Solucion");

        integers.stream().filter(x->x>=0).reduce(Integer::sum).ifPresent(System.out::println);

        System.out.println("\n\nel mayor de la lista de ser 20:");
        System.out.println("Solucion 1");
        integers.stream().reduce(Integer::max).ifPresent(System.out::println);



        System.out.println("\n\nel menor de la lista de ser -10:");
        System.out.println("Solucion 1");
        integers.stream().reduce(Integer::min).ifPresent(System.out::println);

        System.out.println("Solucion 2  sin usar if presnet");
        int min = integers.stream().reduce(0,Integer::min); //se le manda el valor inicial, si if not present, entonces regresa ese valor inicial
        System.out.println(min);

        //assertThat(min).isEqualTo(-20);



        //   https://www.baeldung.com/java-stream-reduce

        List<String> letters = Arrays.asList("a", "b", "c", "d", "e");
        String result = letters
                .stream()
                .reduce("", (partialString, element) -> partialString + element);

        //assertThat(result).isEqualTo("abcde");
        System.out.println("abcde is equual to; "+result);

        result = letters
                .stream()
                .reduce("", String::concat);

        //assertThat(result).isEqualTo("abcde");
        System.out.println("abcde is equual to; "+result);

        result = letters
                .stream()
                .reduce("", (partialString, element) -> partialString + element.toUpperCase());

        //assertThat(result).isEqualTo("abcde");
        System.out.println("ABCDE is equual to; "+result);


        //let’s use the reduce() operation for joining the uppercase elements of the letters array:

        List<Integer> ages = Arrays.asList(25, 30, 45, 28, 32);
        int computedAges = ages.parallelStream().reduce(0, (a, b) -> a + b, Integer::sum  /* this is a combiner, and runs this in pararell*/);
        //(assertThat(result).isEqualTo("ABCDE");
        System.out.println("160 is equual to; "+computedAges);


        //Funnily enough, this code won’t compile:
        List<User> users = Arrays.asList(new User("John", 30), new User("Julie", 35));
   /*
        int computedAges =
                users.stream().reduce(0, (partialAgeResult, user) -> partialAgeResult + user.getAge());
*/

        //this will work, using a combiner
        int resultAge = users.stream()
                .reduce(0, (partialAgeResult, user) -> partialAgeResult + user.getAge(), Integer::sum/* este le pongo min, y no calcula el min " Integer::min", solo se suma*/);
        //assertThat(result).isEqualTo(65);
        System.out.println("65 is the result: "+resultAge);


        //this will work, using a combiner
        resultAge = users.stream().map(user -> user.getAge())
                .reduce(0, Integer::sum);
        //assertThat(result).isEqualTo(65);
        System.out.println("65 is the result: "+resultAge);





        List<String> words= new ArrayList<String>();
        words.add("juan");
        words.add("gema");
        words.add("maria");

        StringJoiner sj = new StringJoiner(",","[","]");
        for (String word : words){
            sj.add(word);
        }

        System.out.println("words joned : "+sj.toString());
    }


}

class User{
    public User(String name, int age){
        this.age=age;
        this.name= name;
    }
    private int age;
    private String name;
    public int getAge(){
        return age;
    }

}