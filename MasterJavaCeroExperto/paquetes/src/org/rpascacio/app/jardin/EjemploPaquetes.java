package org.rpascacio.app.jardin;
import org.rpascacio.app.hogar.*;
/*import static org.rpascacio.app.hogar.Persona.saludar;
import static org.rpascacio.app.hogar.Persona.GENERO_FEMENINO;
import static org.rpascacio.app.hogar.Persona.GENERO_MASCULINO;*/
import static org.rpascacio.app.hogar.ColorPelo.*;
import static org.rpascacio.app.hogar.Persona.*;


public class EjemploPaquetes {
    public static void main(String[] args) {

        Persona p=new Persona();
        p.setNombre("Rommer");
        p.setApellido("Pascacio");
        p.setColorPelo(CAFE);
        System.out.println(p.getNombre() + " "+p.getApellido());

        Perro perro=new Perro();
        perro.nombre="tobby";
        perro.raza="Bulldog";

        String jugando=perro.jugar(p);
        System.out.println("jugando = " + jugando);
        String saludo=saludar();
        System.out.println("saludo = " + saludo);
        String generoMujer=GENERO_FEMENINO;
        String generoHombre=GENERO_MASCULINO;
    }
}
