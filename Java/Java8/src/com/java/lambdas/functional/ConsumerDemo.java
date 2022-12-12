package com.java.lambdas.functional;

import java.util.function.Consumer;

/**
 * @author danfe
 */

// Implementacion tradicional sin expresiones Lambdas
class ConsumerImpl implements Consumer<String> {
    @Override
    public void accept(String s) {
        System.out.println(s);
    }
}

public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> consumer = new ConsumerImpl();
        consumer.accept("Hola Daniel");
        
        System.out.println("------");
        
        Consumer<String> consumer2 = (s) -> System.out.println(s);
        consumer2.accept("Hola Daniel");
    }
}
