import java.util.Date;

public class EjemploAutomovilStatic {
    public static void main(String[] args) {

        Automovil.setCapacidadEstanqueEstatico(45);
        Automovil subaru=new Automovil("Subaru","Impreza");
        subaru.setMotor(new Motor(2.0,TipoMotor.BENCINA));
        subaru.setEstanque(new Estanque());
        subaru.setColor(Color.BLANCO);// con constantes : subaru.setColor(Automovil.COLOR_BLANCO);
        subaru.setTipo(TipoAutomovil.HATCHBACK);

        Automovil mazda=new Automovil("Mazda","BT-50",Color.ROJO,new Motor(3.0,TipoMotor.DIESEL));
        mazda.setTipo(TipoAutomovil.PICKUP);
        //mazda.setEstanque(new Estanque(4));

        Automovil nissan=new Automovil("Nissan", "Navara",Color.GRIS,
                new Motor(3.5,TipoMotor.DIESEL),new Estanque(50));
        nissan.setTipo(TipoAutomovil.PICKUP);
        Automovil nissan2=new Automovil("Nissan", "Navara",
                Color.GRIS,new Motor(3.5,TipoMotor.BENCINA),new Estanque(50));
        nissan2.setColor(Color.AMARILLO);
        nissan2.setTipo(TipoAutomovil.PICKUP);
        Automovil.setColorPatente(Color.AZUL);
        Automovil auto=new Automovil();

        System.out.println(subaru.verDetalle());
        System.out.println(mazda.verDetalle());
        System.out.println(nissan.verDetalle());

        System.out.println(nissan2.verDetalle());
        System.out.println("Automovil.getColorPatente() = " + Automovil.getColorPatente());
        System.out.println("Kilómetros por litros = "+ Automovil.calcularConsumoEstatico(300,60));
        System.out.println("Velócidad máxima cerretera : "+Automovil.VELOCIDAD_MAXIMA_CARRETERA);
        System.out.println("Velócidad máxima ciudad : "+Automovil.VELOCIDAD_MAX_CIUDAD);
        
        TipoAutomovil tipoSubaru=subaru.getTipo();
        System.out.println("tipoSubaru = " + tipoSubaru.getNombre());
        System.out.println("tipoSubaru.getDescripcion() = " + tipoSubaru.getDescripcion());

        System.out.println(mazda.calcularConsumo(300,70));
    }
}
