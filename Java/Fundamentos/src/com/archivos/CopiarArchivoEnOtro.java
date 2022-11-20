package com.archivos;

import java.io.*;

/**
 * @author danfe
 */

public class CopiarArchivoEnOtro {
    public static void main(String[] args) {
        LeerEscribirArchivos a = new LeerEscribirArchivos();
        a.leerEscribir();
    }
}

class LeerEscribirArchivos {
    InputStream input;
    OutputStream output;
    
    public void leerEscribir() {
        File original = new File("C:/Proyectos/Learning-Java-Spring/Java/Fundamentos/src/archivotexto3.txt");
        File destino = new File("C:/Proyectos/Learning-Java-Spring/Java/Fundamentos/src/archivotexto5.txt");
        try {
            int length;
            input = new FileInputStream(original);
            output = new FileOutputStream(destino);
            byte[] buffer = new byte[1024];
            System.out.println("Leyendo Archivo Original");
            while ((length = input.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            System.out.println("Archivo Copiado con Exito");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
                output.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
}
