package com.archivos;

import java.io.*;

/**
 * @author danfe
 */

public class LeerArchivosConBuffers {
    public static void main(String[] args) {
        LeerArchivo2 a = new LeerArchivo2();
        a.leer();
    }
}

class LeerArchivo2 {
    private FileReader archivo;
    private int c;
    
    public void leer() {
        try {
            archivo = new FileReader("C:/Proyectos/Learning-Java-Spring/Java/Fundamentos/src/archivotexto3.txt");
            BufferedReader buffer = new BufferedReader(archivo);
            String linea = "";
            while ((linea = buffer.readLine()) != null) {
                System.out.println(linea);
            }
            buffer.close();
        } catch (IOException e) {
            System.out.println("No se puede localizar el archivo");
        } finally {
            try {
                if (null != archivo) {
                    archivo.close();
                    System.out.println("Archivo Cerrado");
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
}
