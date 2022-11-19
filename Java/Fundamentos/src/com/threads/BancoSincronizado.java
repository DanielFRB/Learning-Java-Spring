package com.threads;

/**
 * @author danfe
 */

public class BancoSincronizado {
    public static void main(String[] args) {
        Banco2 b = new Banco2();
        for (int i = 0; i < 100; i++) {
            EjecutaTransferencia2 rb = new EjecutaTransferencia2(b, i, 2000);
            Thread t = new Thread(rb);
            t.start();
        }
    }
}

class Banco2 {
    private final double[] cuentas;
    
    public Banco2() {
        cuentas = new double[100];
        for (int i = 0; i < cuentas.length; i++) {
            cuentas[i] = 2000;
        }
    }
    
    public synchronized void transferencia(int cuentaOrigen, int cuentaDestino, double monto) throws InterruptedException {
        while (cuentas[cuentaOrigen] < monto) {
            wait();
        }
        System.out.println(Thread.currentThread());
        cuentas[cuentaOrigen] -= monto;
        System.out.printf("%10.2f de %d para %d ", monto, cuentaOrigen, cuentaDestino);
        cuentas[cuentaDestino] += monto;
        System.out.printf("Saldo Total: %10.2f%n ", getSaltoTotal());
        notifyAll();
    }
    
    public double getSaltoTotal() {
        double sumaCuentas = 0;
        for (double c : cuentas) {
            sumaCuentas += c;
        }
        return sumaCuentas;
    }
}

class EjecutaTransferencia2 implements Runnable {
    private Banco2 banco;
    private int ctaOrigen;
    private double cantMaxima;
    
    public EjecutaTransferencia2(Banco2 b, int ctaO, double max) {
        this.banco = b;
        this.ctaOrigen = ctaO;
        this.cantMaxima = max;
    }
    
    @Override
    public void run() {
        try {
            while (true) {
                int ctaDestino = (int) (100 * Math.random());
                double cantidad = cantMaxima * Math.random();
                banco.transferencia(ctaOrigen, ctaDestino, cantidad);
                Thread.sleep((int)(10 * Math.random()));
            }
        } catch(InterruptedException e) {
        }
    }
}
