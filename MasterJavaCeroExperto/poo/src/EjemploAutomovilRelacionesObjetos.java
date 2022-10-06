import java.lang.reflect.AnnotatedArrayType;
import java.util.ArrayList;
import java.util.List;

public class EjemploAutomovilRelacionesObjetos {
    public static void main(String[] args) {

        Persona conductoSubaru=new Persona("Luci","Martinez");
        Automovil.setCapacidadEstanqueEstatico(45);
        Automovil subaru=new Automovil("Subaru","Impreza");
        subaru.setMotor(new Motor(2.0,TipoMotor.BENCINA));
        subaru.setEstanque(new Estanque());
        subaru.setColor(Color.BLANCO);// con constantes : subaru.setColor(Automovil.COLOR_BLANCO);
        subaru.setTipo(TipoAutomovil.HATCHBACK);
        subaru.setConductor(conductoSubaru);
        //subaru.setRuedas(ruedasSub);

        Rueda[] ruedasSub=new Rueda[5];
        for (int i = 0; i < ruedasSub.length ; i++) {
            //ruedasSub[i]=new Rueda("Yokohama",16,7.5);
            subaru.addRueda(new Rueda("Yokohama",16,7.5));
        }

        Persona pato=new Persona("Pato","Rodriguez");
        Automovil mazda=new Automovil("Mazda","BT-50",Color.ROJO,new Motor(3.0,TipoMotor.DIESEL));
        mazda.setTipo(TipoAutomovil.PICKUP);
        mazda.setEstanque(new Estanque(4));
        mazda.setConductor(pato);
       // mazda.setRuedas(ruedasMaz);

        Rueda[] ruedasMaz=new Rueda[5];
        for (int i = 0; i < ruedasMaz.length ; i++) {
            //ruedasMaz[i]=new Rueda("Michelin",18,10.5);
            mazda.addRueda(new Rueda("Michelin",18,10.5));
        }

        /*Rueda[] ruedasNissan={new Rueda("Pirelli",20,11.5),
                new Rueda("Pirelli",20,11.5),
                new Rueda("Pirelli",20,11.5),
                new Rueda("Pirelli",20,11.5),
                new Rueda("Pirelli",20,11.5)};*/
        Persona bea=new Persona("Bea","Gonzalez");
        Automovil nissan=new Automovil("Nissan", "Navara",Color.GRIS,
                new Motor(3.5,TipoMotor.DIESEL),new Estanque(50));
        nissan.setConductor(bea);
        nissan.setTipo(TipoAutomovil.PICKUP);
        nissan.addRueda(new Rueda("Pirelli",20,11.5))
                .addRueda(new Rueda("Pirelli",20,11.5))
                .addRueda(new Rueda("Pirelli",20,11.5))
                .addRueda(new Rueda("Pirelli",20,11.5))
                .addRueda(new Rueda("Pirelli",20,11.5));

        Rueda[] ruedasNissan2={new Rueda("Pirelli",20,11.5),
                new Rueda("Pirelli",20,11.5),
                new Rueda("Pirelli",20,11.5),
                new Rueda("Pirelli",20,11.5),
                new Rueda("Pirelli",20,11.5)};
        Persona lalo=new Persona("Lalo","Mena");
        Automovil nissan2=new Automovil("Nissan", "Navara",
                Color.GRIS,new Motor(3.5,TipoMotor.BENCINA),new Estanque(50),lalo,ruedasNissan2);
        nissan2.setColor(Color.AMARILLO);
        nissan2.setTipo(TipoAutomovil.PICKUP);
        Automovil.setColorPatente(Color.AZUL);
        Automovil auto=new Automovil();

        System.out.println(subaru.verDetalle());
        System.out.println(mazda.verDetalle());
        System.out.println(nissan.verDetalle());

        System.out.println(nissan2.verDetalle());

     /*   System.out.println("Conductor subaru : " + subaru.getConductor());
        System.out.println("Ruedas Subaru : ");
        for (Rueda rueda:subaru.getRuedas()) {
            System.out.println(rueda.getFabricante()+", aro: "+rueda.getAro() +", ancho: " + rueda.getAncho());
        }*/
    }
}
