package com.volumen;

public class Main {

    public static void main(String[] args) {
        int iteraciones = 100000;
        long startTime, endTime;

        Volumen volumen = new Volumen(0.0, 1.0, 0.0, 1.0);

        startTime = System.currentTimeMillis();
        System.out.println(volumen.areaValoresMedios(iteraciones));
        endTime = System.currentTimeMillis();

        System.out.println("Tiempo para " + iteraciones + " iteraciones: " + (endTime-startTime) + "ms");
    }
}
