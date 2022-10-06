package org.rpascacio.poointerfaces.imprenta.modelo;

public interface Imprimible {

    //es redundante en una interface los modificadores public final static para los atributos
    String TEXTO_DEFECTO="Imprimiento un valor por defecto";

    default String imprimir(){
        return TEXTO_DEFECTO;
    }

    static void imprimir(Imprimible imprimible){
        System.out.println(imprimible.imprimir());
    }
}
