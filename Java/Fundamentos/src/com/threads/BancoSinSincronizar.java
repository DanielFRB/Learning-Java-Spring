package com.threads;

import java.util.concurrent.locks.*;

/**
 * @author danfe
 */

public class BancoSinSincronizar {
    public static void main(String[] args) {
        Banco banco = new Banco();
        for (int i = 0; i < 100; i++) {
            EjecutaTransferencia r = new EjecutaTransferencia(banco, i, 2000);
            Thread tb = new Thread(r);
            tb.start();
        }
    }
}

class Banco {
    private final double[] cuentas;
    private Lock cierraCodigo = new ReentrantLock();
    private Condition saldoSuficiente;
    
    public Banco() {
        cuentas = new double[100];
        for (int i = 0; i < cuentas.length; i++) {
            cuentas[i] = 2000;
        }
        saldoSuficiente = cierraCodigo.newCondition();
    }
    
    public void transferencia(int cuentaOrigen, int cuentaDestino, double monto) throws InterruptedException {
        cierraCodigo.lock();
        try {
            while (cuentas[cuentaOrigen] < monto) {
                saldoSuficiente.await();
            }
            System.out.println(Thread.currentThread());
            cuentas[cuentaOrigen] -= monto;
            System.out.printf("%10.2f de %d para %d ", monto, cuentaOrigen, cuentaDestino);
            cuentas[cuentaDestino] += monto;
            System.out.printf("Saldo Total: %10.2f%n ", getSaltoTotal());
            saldoSuficiente.signalAll();
        } finally {
            cierraCodigo.unlock();
        }
    }
    
    public double getSaltoTotal() {
        double sumaCuentas = 0;
        for (double c : cuentas) {
            sumaCuentas += c;
        }
        return sumaCuentas;
    }
}

class EjecutaTransferencia implements Runnable {
    private Banco banco;
    private int ctaOrigen;
    private double cantMaxima;
    
    public EjecutaTransferencia(Banco b, int ctaO, double max) {
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