package com.java.lambdas;

/**
 * @author danfe
 */

interface Figura {
    void dibujar();
}

// Implementacion tradicional sin expresiones Lambdas
// En este caso tres clases implementan la interface funcional

class Rectangulo implements Figura {
    @Override
    public void dibujar() {
        System.out.println("Clase Rectanculo utiliza el metodo dibujar()");
    }
} 

class Cuadrado implements Figura {
    @Override
    public void dibujar() {
        System.out.println("Clase Cuadrado utiliza el metodo dibujar()");
    }
}

class Circulo implements Figura {
    @Override
    public void dibujar() {
        System.out.println("Clase Circulo utiliza el metodo dibujar()");
    }
}

public class LambdaExample {
    public static void main(String[] args) {
        String str = "Hola";
        
        Figura rectangulo = new Rectangulo();
        rectangulo.dibujar();
        
        Figura cuadrado = new Cuadrado();
        cuadrado.dibujar();
        
        Figura circulo = new Circulo();
        circulo.dibujar();
        
        System.out.println("----------");
        
        imprimir(rectangulo);
        imprimir(cuadrado);
        imprimir(circulo);
        
        System.out.println("----------");
        
        imprimir(() -> System.out.println("El objeto rectanculo utiliza el metodo dibujar()"));
        imprimir(() -> System.out.println("El objeto cuadrado utiliza el metodo dibujar()"));
        imprimir(() -> System.out.println("El objeto circulo utiliza el metodo dibujar()"));
    }
    
    private static void imprimir(Figura f) {
        f.dibujar();
    }
}
