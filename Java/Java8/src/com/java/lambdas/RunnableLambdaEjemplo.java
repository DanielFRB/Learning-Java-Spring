package com.java.lambdas;

/**
 * @author danfe
 */

class ThreadDemo implements Runnable {
    @Override
    public void run() {
        System.out.println("Metodo run llamado...");
    }
}

public class RunnableLambdaEjemplo {
    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadDemo());
        thread.start();
        
        Runnable runnable = () -> {
            System.out.println("Metodo run llamado usando lambdas...");
        };
        Thread threadLambda = new Thread(runnable);
        threadLambda.start();
    }
}
