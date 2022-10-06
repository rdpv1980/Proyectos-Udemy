class Persona{
    private String nombre;

    public void modificarNombre(String nuevoNombre){
        this.nombre=nuevoNombre;
    }

    public String leerNombre(){
        return this.nombre;
    }
}

public class PasarPorReferencia2 {
    public static void main(String[] args) {

        Persona persona =new Persona();
        persona.modificarNombre("Andrés");

        System.out.println("iniciamos el metodo main");
        System.out.println("persona = " + persona.leerNombre());

        System.out.println("Antes de llamar al metodo test");
        test(persona);
        System.out.println("Después de llamar al metodo test");
        System.out.println("persona = " + persona.leerNombre());

        System.out.println("Finaliza el método main con los datos de la persona modificados!");
    }

    public static void test(Persona persona){
        System.out.println("Iniciamos el metodo test ");
        persona.modificarNombre("Pepe");
        System.out.println("Finaliza el método test con") ;
    }
}