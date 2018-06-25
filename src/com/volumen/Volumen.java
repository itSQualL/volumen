package com.volumen;

public class Volumen {
    double limIx, limSx, limIy, limSy, amplitudx, amplitudy;

    public Volumen(double limInferiorX, double limSuperiorX, double limInferiorY, double limSuperiorY) {
        limIx = limInferiorX;
        limSx = limSuperiorX;
        limIy = limInferiorY;
        limSy = limSuperiorY;
        amplitudx = limSx - limIx;
        amplitudy = limSy - limIy;
    }

    public double areaValoresMedios(int k) {
        double[] valores = new double[k]; //para calcular medias, cuasi varianzas e intervalos de confianza
        double suma = 0.0;

        for (int i = 0; i < k; i++) {
            double x = Math.random() * amplitudx + limIx;
            double y = Math.random() * amplitudy+ limIy;
            double z = fun(x, y);

            valores[i] = amplitudx * amplitudy * z;
            suma = suma + valores[i];
        }

        intervaloConfianza(valores);
        return suma/k;
    }

    public double areaProporcion(int k) {
        int buenos = 0;

        for (int i = 0; i < k; i++) {
            double x = Math.random() * amplitudx+ limIx;
            double y = Math.random() * amplitudy + limIy;
            double z = Math.random() * fun(limSx, limSy);

            if (z <= fun(x, y)) buenos++;
        }
        IntervaloConfProporciones((double)buenos/k, k);

        return amplitudx * amplitudy * fun(limSx, limSy) * buenos/(double)k;
    }

    private double fun(double x, double y) {
        return (Math.pow(x, 2) + Math.pow(y, 2));
    }

    private void IntervaloConfProporciones (double p, double n){
        double intervaloInf = p - 1.96* Math.sqrt (p*(1 - p)/n);
        double intervaloSup = p+1.96* Math.sqrt (p*(1 - p)/n);

        System.out.println("Intervalo para proporción: ["+ intervaloInf +" , "+ intervaloSup +"]");
    }

    public void intervaloConfianza ( double [] valores){// valores.length tamaño de la muestra
        double media=media(valores);
        double S= cuasiV (valores, media);
        double intervaloInf = media - 1.96*S/ Math.sqrt ( valores.length );
        double intervaloSup = media+1.96*S/ Math.sqrt ( valores.length );
        System.out.println("Intervalo: ["+ intervaloInf +" , "+ intervaloSup +"]");
    }

    public double cuasiV ( double [] valores, double media){
        double S=0;
        for ( int x=0;x< valores.length;x ++){
            S= S+Math.pow (valores[x] - media,2);
        }
        return Math.sqrt (S/(valores.length - 1));
    }

    public double media( double valores[]){
        double media=0;
        for ( int x=0;x< valores.length;x ++){
            media= media+valores [x];
        }
        return media/ valores.length ;
    }
}
