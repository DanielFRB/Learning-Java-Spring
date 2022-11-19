package com.programaciongenerica.clasespropias;

/**
 * @author danfe
 */

public class HerenciaGenericos {
    public static void main(String[] args) {
        /*Empleado Secretaria = new Empleado("Ana", 25, 1500);
        Jefe DirectoraComercial = new Jefe("Yaneth", 45, 5000);
        Empleado nuevoEmpleado = DirectoraComercial;*/
        Pareja<Empleado> Secretaria = new Pareja<>();
        Pareja<Jefe> DirectoraComercial = new Pareja<>();
        
        Pareja.imprimirTrabajador(Secretaria);
        Pareja.imprimirTrabajador(DirectoraComercial);
    }
}
