package com.poo;

/**
 * @author danfe
 */

public class Coche {
    private int ruedas;
    private int largo;
    private int ancho;
    private int motor;
    private int pesoPlataforma;
    private String color;
    private int pesoTotal;
    private boolean asientosCuero, climatizador;
    
    public Coche() {
        ruedas = 4;
        largo = 500;
        ancho = 200;
        motor = 1600;
        pesoPlataforma = 500;
    }

    public String getRuedas() {
        return "Este coche tiene "+ ruedas +" ruedas";
    }

    public String getLargo() {
        return "Este coche mide "+ (largo/100) +" metros de largo";
    }

    public String getAncho() {
        return "Este coche mide "+ (ancho/100) +" metros de ancho";
    }

    public String getMotor() {
        return "Este coche tiene un motor de: "+ motor +" centimetros cubicos";
    }

    public String getPesoPlataforma() {
        return "Este coche tiene un peso inicial de: "+ pesoPlataforma +" kilos";
    }
    
    public String getColor() {
        return "Este coche es de color "+ color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public String getDatosGenerales() {
        return "Este coche tiene un peso inicial de: "+ pesoPlataforma +" kilos. "+
                "Tiene "+ ruedas +" ruedas, "+ "mide "+ (largo/100) +" metros de largo. "+
                "Mide "+ (ancho/100) +" metros de ancho "+ "y es de color "+ color;
    }
    
    public void setAsientosCuero(String a) {
        asientosCuero = a.equalsIgnoreCase("si");
    }
    
    public String getAsientosCuero() {
        if (asientosCuero) {
            return "El coche tiene asientos de cuero";
        } else {
            return "El coche tiene asientos de tela";
        }
    }
    
    public void setClimatizador(String c) {
        climatizador = c.equalsIgnoreCase("si");
    }
    
    public String getClimatizador() {
        if (climatizador) {
            return "El coche tiene climatizador";
        } else {
            return "El coche no tiene climatizador";
        }
    }
    
    public String getPesoTotal() {
        int pesoCarroceria = 400;
        pesoTotal = pesoPlataforma + pesoCarroceria;
        if (climatizador) {
            pesoTotal += 20;
        }
        if (asientosCuero) {
            pesoTotal += 50;
        }   
        return "El Peso total del coche es: "+ pesoTotal +" kilogramos";
    }
    
    public String getPrecioTotal() {
        int precioTotal = 8000;
        if (climatizador) {
            precioTotal += 200;
        }
        if (asientosCuero) {
            precioTotal += 600;
        }
        return "El precio total del coche es: "+ precioTotal +" dolares";
    }
}
