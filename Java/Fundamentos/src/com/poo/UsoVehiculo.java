package com.poo;

/**
 * @author danfe
 */

public class UsoVehiculo {
    public static void main(String[] args) {
        /*Coche renault = new Coche();
        System.out.println(renault.getRuedas());
        renault.setColor(JOptionPane.showInputDialog("Introduce el Color"));
        System.out.println(renault.getColor());
        System.out.println(renault.getDatosGenerales());
        renault.setAsientosCuero(JOptionPane.showInputDialog("Tiene Asientos de Cuero???"));
        System.out.println(renault.getAsientosCuero());
        renault.setClimatizador(JOptionPane.showInputDialog("Tiene Climatizador???"));
        System.out.println(renault.getClimatizador());
        System.out.println(renault.getPesoTotal());
        System.out.println(renault.getPrecioTotal());*/
        
        Coche fiesta = new Coche();
        fiesta.setColor("Rojo");
        Furgoneta fiat = new Furgoneta(500, 7);
        fiat.setColor("Gris");
        fiat.setAsientosCuero("si");
        fiat.setClimatizador("si");
        
        System.out.println(fiesta.getDatosGenerales());
        System.out.println(fiat.getDatosFurgoneta());
        System.out.println(fiat.getDatosGenerales());
    }
}
