package com.archivos;

import java.io.*;

/**
 * @author danfe
 */

public class CopiarArchivo {
    FileInputStream inStream;
    FileOutputStream outStream;
    
    public CopiarArchivo(String fuente, String destino) {
        System.out.println("Copiando desde: " + fuente);
        System.out.println("Hacia el destino: " + destino);
        try {
            int length;
            File in = new File(fuente);
            File out = new File(destino);
            inStream = new FileInputStream(in);
            outStream = new FileOutputStream(out);
            
            byte[] buffer = new byte[1024];
            while ((length = inStream.read(buffer)) > 0) {
                outStream.write(buffer, 0, length);
            }
            System.out.println("Archivo Copiado");
        } catch (IOException e) {
            System.err.println("Hubo un error de entrada/salida!!!");
            e.printStackTrace();
        } finally {
            try {
                inStream.close();
                outStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        if (args.length == 2) {
            new CopiarArchivo(args[0], args[1]);
        } else {
            System.out.println("Debe ingresar el nombre del archivo origen y un archivo destino");
        }
    }
}