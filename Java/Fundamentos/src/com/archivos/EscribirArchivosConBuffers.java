package com.archivos;

import java.io.*;

/**
 * @author danfe
 */

public class EscribirArchivosConBuffers {
    public static void main(String[] args) {
        EscribirArchivo2 a = new EscribirArchivo2();
        a.escribir();
    }
}

class EscribirArchivo2 {
    private FileWriter escribe;
    
    public void escribir() {
        String fraseEscribir = "Este es un nuevo archivo de texto para el Curso Aprendiendo Java.";
        try {
            escribe = new FileWriter("C:/Proyectos/Learning-Java-Spring/Java/Fundamentos/src/archivotexto4.txt");
            BufferedWriter buffer = new BufferedWriter(escribe);
            buffer.write(fraseEscribir);
            System.out.println("Archivo escrito con exito");
            buffer.close();
        } catch (IOException e) {
            System.out.println("No se pudo escribir en el archivo");
        } finally {
            try {
                if (escribe != null) {
                    escribe.close();
                    System.out.println("Archivo Cerrado");
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
}
