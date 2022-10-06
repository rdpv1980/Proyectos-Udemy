import java.util.Arrays;

public class EjemploAutomovilArreglo {
    public static void main(String[] args) {

        Persona conductoSubaru=new Persona("Luci","Martinez");
        Automovil.setCapacidadEstanqueEstatico(45);
        Automovil subaru=new Automovil("Subaru","Impreza");
        subaru.setMotor(new Motor(2.0,TipoMotor.BENCINA));
        subaru.setEstanque(new Estanque());
        subaru.setColor(Color.BLANCO);// con constantes : subaru.setColor(Automovil.COLOR_BLANCO);
        subaru.setTipo(TipoAutomovil.HATCHBACK);
        subaru.setConductor(conductoSubaru);

        Persona pato=new Persona("Pato","Rodriguez");
        Automovil mazda=new Automovil("Mazda","BT-50",Color.ROJO,new Motor(3.0,TipoMotor.DIESEL));
        mazda.setTipo(TipoAutomovil.PICKUP);
        mazda.setEstanque(new Estanque(4));
        mazda.setConductor(pato);

        Persona bea=new Persona("Bea","Gonzalez");
        Automovil nissan=new Automovil("Nissan", "Navara",Color.GRIS,
                new Motor(3.5,TipoMotor.DIESEL),new Estanque(50));
        nissan.setConductor(bea);
        nissan.setTipo(TipoAutomovil.PICKUP);

        Persona lalo=new Persona("Lalo","Mena");
        Automovil suzuki=new Automovil("Nissan", "Navara",
                Color.GRIS,new Motor(16,TipoMotor.BENCINA),new Estanque(50));
        suzuki.setConductor(lalo);
        suzuki.setColor(Color.AMARILLO);
        suzuki.setTipo(TipoAutomovil.PICKUP);
        Automovil.setColorPatente(Color.AZUL);

        Automovil audi=new Automovil("Audi","A3");
        audi.setConductor(new Persona("Jano","Perez"));

        Automovil[]autos=new Automovil[5];
        autos[0]=subaru;
        autos[1]=mazda;
        autos[2]=nissan;
        autos[3]=suzuki;
        autos[4]=audi;

        Arrays.sort(autos);

        for (int i = 0; i < autos.length; i++) {
            System.out.println(autos[i]);
        }



    }
}
