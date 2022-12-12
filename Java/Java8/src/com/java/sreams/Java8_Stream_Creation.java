package com.java.sreams;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.logging.*;
import java.util.regex.Pattern;
import java.util.stream.*;

/**
 * @author danfe
 */

public class Java8_Stream_Creation {
    public static void main(String[] args) {
        // Collection
        List<Integer> lista = Arrays.asList(1, 2, 3, 4);
        lista.stream().forEach(System.out::println);
        
        // Arrays
        Integer[] intArray = new Integer[] {1, 2, 3, 4};
        Arrays.stream(intArray).forEach(System.out::println);
        
        // Stream.of
        Stream
                .of("Esto", "es", "una", "prueba")
                .forEach(System.out::println);
        
        // IntStream.range
        IntStream.range(0, 5).forEach(System.out::println);
        
        // Stream.iterate
        Stream
                .iterate(5, (n) -> n * 2)
                .limit(10)
                .forEach(System.out::println);
        
        // BufferedReader - lines
        // Stream.txt - 11, 12, 13
        File file = new File("C:\\Proyectos\\AprendiendoJava\\Java8Clases\\src\\java8Streams\\streams.txt");
        FileReader in = null;
        try {
            in = new FileReader(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Java8_Stream_Creation.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedReader br = new BufferedReader(in);
        br.lines().forEach(System.out::println);
        
        // Paths
        Path p = Paths.get("");
        try {
            Files.list(p).forEach(System.out::println);
        } catch (IOException ex) {
            Logger.getLogger(Java8_Stream_Creation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Random
        new Random()
                .ints()
                .limit(10)
                .forEach(System.out::println);
        
        // Pattern
        String s = "Esto es una cadena";
        Pattern pa = Pattern.compile(" ");
        pa.splitAsStream(s).forEach(System.out::println);
        
        
    }
}
