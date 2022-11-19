package com.poo;

/**
 * @author danfe
 */

public class Furgoneta extends Coche {
    private int capacidadCarga;
    private int plazasExtras;
    
    public Furgoneta(int capacidadCarga, int plazasExtras) {
        super();
        this.capacidadCarga = capacidadCarga;
        this.plazasExtras = plazasExtras;
    }
    
    public String getDatosFurgoneta() {
        return "La capacidad de carga es: "+ capacidadCarga +" kilos y las plazas son: "+ plazasExtras;
    }
}
