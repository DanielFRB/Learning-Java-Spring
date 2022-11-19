package com.archivos;

import java.io.*;

/**
 * @author danfe
 */

public class LeerArchivoTexto {
    public static void main(String[] args) {
        LeerArchivo a = new LeerArchivo();
        a.leer();
    }
}

class LeerArchivo {
    private FileReader archivo;
    private int c;
    
    public void leer() {
        try {
            archivo = new FileReader("C:/Proyectos/Learning-Java-Spring/Java/Fundamentos/src/archivotexto.txt");
            while (c != -1) {
                c = archivo.read();
                char letra = (char) c;
                System.out.print(letra);
            }
            archivo.close();
        } catch (IOException e) {
            System.out.println("No se puede localizar el archivo");
        }
    }
}
