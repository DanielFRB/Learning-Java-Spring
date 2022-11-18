package com.primerospasos;

import java.util.*;

/**
 * @author danfe
 */

public class UsoTallas {
    //enum Talla {MINI, MEDIANO, GRANDE, MUY_GRANDE};
    
    public static void main(String args[]){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Escribe una talla: MINI, MEDIANO, GRANDE, MUY_GRANDE");
        String captura = entrada.next().toUpperCase();
        Talla talla = Enum.valueOf(Talla.class, captura);
        System.out.println("Talla: "+ talla);
        System.out.println("Abreviatura: "+ talla.getAbreviatura());
    }
    
    enum Talla {
        MINI("S"), MEDIANO("M"), GRANDE("L"), MUY_GRANDE("XL");
        
        private String abreviatura;
        
        private Talla(String a) {
            this.abreviatura = a;
        }
        
        public String getAbreviatura() {
            return abreviatura;
        }
    }
}
