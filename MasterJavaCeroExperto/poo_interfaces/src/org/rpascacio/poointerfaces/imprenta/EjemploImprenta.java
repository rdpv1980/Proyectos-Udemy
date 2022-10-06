package org.rpascacio.poointerfaces.imprenta;
import org.rpascacio.poointerfaces.imprenta.modelo.*;

import static org.rpascacio.poointerfaces.imprenta.modelo.Genero.*;
import static org.rpascacio.poointerfaces.imprenta.modelo.Imprimible.*;

public class EjemploImprenta {
    public static void main(String[] args) {
        Curriculo cv=new Curriculo(new Persona("John", "Doe"),"Ingeniero de sistemas", "Resumen Laboral..");
        cv.addExperiencia("Java");
        cv.addExperiencia("Oracle DBA");
        cv.addExperiencia("Spring Framework");
        cv.addExperiencia("Desarrollador fullstack");
        cv.addExperiencia("Angular");

        Libro libro=new Libro(new Persona("Erick", "Gamma"),"Patrones de diseños: Elem. Reusables POO"
                , PROGRAMACION);
        libro.addPagina(new Pagina("Patrón Singleton"))
                .addPagina(new Pagina("Patrón Observador"))
                .addPagina(new Pagina("Patrón Factory"))
                .addPagina(new Pagina("Patrón Composite"))
                .addPagina(new Pagina("Patrón Facade"));


        Informe informe=new Informe(new Persona("Martin","Fowler"),
                       new Persona("James","Gosling"),"Estudio sobre microseervicios");
        imprimir(cv);
        imprimir(informe);
        imprimir(libro);

        Imprimible objImp=new Imprimible() {
            @Override
            public String imprimir() {
                return "Hola que tal, imprimiendo un objeto genérico de una clase anónima! ";
            }
        };
        imprimir(objImp);
        imprimir(new Imprimible() {

        });

        System.out.println(TEXTO_DEFECTO);

    }

 /*   public static void imprimir(Imprimible imprimible){
        System.out.println(imprimible.imprimir());
    }*/
}
