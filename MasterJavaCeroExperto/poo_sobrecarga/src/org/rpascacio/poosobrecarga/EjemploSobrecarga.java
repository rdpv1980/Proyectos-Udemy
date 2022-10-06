package org.rpascacio.poosobrecarga;
import static org.rpascacio.poosobrecarga.Calculadora.*;


public class EjemploSobrecarga {
    public static void main(String[] args) {

        //Calculadora cal=new Calculadora();


        System.out.println("sumar int : "+sumar(10,5));
        System.out.println("sumar float : "+sumar(10.0f,5F));
        System.out.println("sumar float-int : "+sumar(10f,5));
        System.out.println("sumar int-float : "+sumar(10,5.0));
        System.out.println("sumar double : "+sumar(10d,5D));
        System.out.println("sumar string : "+sumar("10","5"));
        System.out.println("sumar tres int : "+sumar(10,5,3));

        System.out.println("sumar long : "+sumar(10l, 5L));
        System.out.println("sumar int : "+sumar(10,'@'));//@ tiene valor decimal 64
        System.out.println("sumar float-int : "+sumar(10F,'@'));
        System.out.println("sumar 4 double: "+sumar(10.0,5.0,3.0,4.5));

        System.out.println("sumar int : "+sumar(10,5,4,3,6));
        System.out.println("sumar int : "+sumar(10,5));
        System.out.println("sumar float-int : "+sumar(10.5F,5,9,15));

    }
}
