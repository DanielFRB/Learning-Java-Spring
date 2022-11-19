package com.archivos;

import java.io.*;

/**
 * @author danfe
 */

public class EscribirArchivoTexto {
    public static void main(String[] args) {
        EscribirArchivo a = new EscribirArchivo();
        a.escribir();
    }
}

class EscribirArchivo {
    public void escribir() {
        String fraseEscribir = "Este es un nuevo archivo de texto para el Curso Aprendiendo Java.";
        try {
            FileWriter escribe = new FileWriter("C:/Proyectos/Learning-Java-Spring/Java/Fundamentos/src/archivotexto2.txt");
            for (int i = 0; i < fraseEscribir.length(); i++) {
                escribe.write(fraseEscribir.charAt(i));
            }
            System.out.println("Archivo escrito con exito");
            escribe.close();
        } catch (IOException e) {
            System.out.println("No se pudo escribir en el archivo");
        }
    }
}