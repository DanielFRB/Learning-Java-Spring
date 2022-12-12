package com.java.lambdas.methodreference;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author danfe
 */

@FunctionalInterface
interface Printable {
    void print(String msg);
}

public class MethodReferenceDemo {
    
    public static int adicion(int a, int b) {
        return (a + b);
    }
    
    public void mostrar(String msg) {
        msg = msg.toUpperCase();
        System.out.println(msg);
    }
    
    public static void main(String[] args) {
        // 1. Referencia de método a un método estático
        // Lambda expresion
        Function<Integer, Double> function = (input) -> Math.sqrt(input);
        System.out.println(function.apply(6));
        
        System.out.println("--------");
        
        // Usando Referencia de método
        Function<Integer, Double> functionMethodRef = Math::sqrt;
        System.out.println(functionMethodRef.apply(8));
        
        System.out.println("--------");
        
        // Lambda expresion
        BiFunction<Integer, Integer, Integer> biFunctionLambda = (a, b) -> MethodReferenceDemo.adicion(a, b);
        System.out.println(biFunctionLambda.apply(4, 5));
        
        System.out.println("--------");
        
        // Usando Referencia de método
        BiFunction<Integer, Integer, Integer> biFunctionLambdaMethodRef = MethodReferenceDemo::adicion;
        System.out.println(biFunctionLambdaMethodRef.apply(4, 5));
        
        System.out.println("--------");
        
        // 2. Referencia de método a una instancia de un objeto
        MethodReferenceDemo methodReferenceDemo = new MethodReferenceDemo();
        
        // Lambda expresion
        Printable printable = (msg) -> methodReferenceDemo.mostrar(msg);
        printable.print("Hola Daniel");
        
        System.out.println("--------");
        
        // Usando Referencia de método
        Printable printableMethodRef = methodReferenceDemo::mostrar;
        printableMethodRef.print("Hola Mundo");
        
        System.out.println("--------");
        
        // 3. Referencia a un método de instancia de un objeto arbitrario
        // A veces, llamamos a un método de argumento en la expresión lambda
        // En este caso, podemos usar una referencia de método para llamar a un
        // método de instancia de un objeto arbitrario de un tipo especifico.
        
        // Lambda expresion
        Function<String, String> stringFuction = (String s) -> s.toLowerCase();
        System.out.println(stringFuction.apply("Hola Daniel"));
        
        System.out.println("--------");
        
        // Usando Referencia de método
        Function<String, String> stringFuctionMethodRef = String::toLowerCase;
        System.out.println(stringFuctionMethodRef.apply("Hola Mundo"));
        
        System.out.println("--------");
        
        String[] strArray = {"A", "E", "I", "O", "U", "a", "e", "i", "o", "u"};
        
        // Lambda expresion
        Arrays.sort(strArray, (s1, s2) -> s1.compareToIgnoreCase(s2));
        
        // Usando Referencia de método
        Arrays.sort(strArray, String::compareToIgnoreCase);
        
        System.out.println("--------");
        
        // 4. Referncia a un Constructor
        List<String> frutas = new ArrayList<>();
        frutas.add("Pera");
        frutas.add("Manzanas");
        frutas.add("Melon");
        frutas.add("Cambur");
        
        // Lambda expresion
        Function<List<String>, Set<String>> setFunction = (listaFrutas) -> new HashSet<>(listaFrutas);
        System.out.println(setFunction.apply(frutas));
        
        System.out.println("--------");
        
        // Usando Referencia de método
        Function<List<String>, Set<String>> setFunctionMethodRef = HashSet::new;
        System.out.println(setFunctionMethodRef.apply(frutas));
    }       
    
}
