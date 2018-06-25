package com.volumen;

public class Volumen {
    double limI, limS, amplitud;

    public Volumen(double limInferior, double limSuperior) {
        limI = limInferior;
        limS = limSuperior;
        amplitud = limS - limI;
    }
    public double areaP(int k) {
        int buenos = 0;

        for (int i = 0; i < k; i++) {
            double x = Math.random() * amplitud + limI;
            double y = Math.random() * amplitud + limI;
            double z = Math.random() * fun(limS, limS);

            if (z <= fun(x, y)) buenos++;
        }
        IntervaloConfProporciones(buenos/(double)k, k);

        return amplitud*fun(limS, limS)* buenos/(double)k;
    }

    private double fun(double x, double y) {
        return (Math.pow(x, 2) + Math.pow(y, 2));
    }

    private void IntervaloConfProporciones (double p, double n){
        double intervaloInf = p - 1.96* Math.sqrt (p*(1 - p)/n);
        double intervaloSup = p+1.96* Math.sqrt (p*(1 - p)/n);

        System.out.println("Intervalo: ["+ intervaloInf +" , "+ intervaloSup +"]");
    }
}
