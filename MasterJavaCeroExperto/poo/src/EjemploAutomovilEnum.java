public class EjemploAutomovilEnum {
    public static void main(String[] args) {

        Automovil.setCapacidadEstanqueEstatico(45);
        Automovil subaru=new Automovil("Subaru","Impreza");
        subaru.setMotor(new Motor(2.0,TipoMotor.BENCINA));
        subaru.setColor(Color.BLANCO);// con constantes : subaru.setColor(Automovil.COLOR_BLANCO);
        subaru.setTipo(TipoAutomovil.HATCHBACK);


        Automovil mazda=new Automovil("Mazda","BT-50",Color.ROJO,new Motor(3.0,TipoMotor.DIESEL));
        mazda.setTipo(TipoAutomovil.PICKUP);
        mazda.setEstanque(new Estanque(4));
        
        TipoAutomovil tipo=subaru.getTipo();
        System.out.println("tipoSubaru = " + tipo.getNombre());
        System.out.println("tipoSubaru.getDescripcion() = " + tipo.getDescripcion());

        tipo=mazda.getTipo();
        /*switch (tipo){
            case CONVERTIBLE :
                System.out.println("El automovil es deportivo y descapotable de dos puertas");
                break;
            case COUPE:
                System.out.println("Es un automovil pequeño de dos puertas y típicamente deportivo");
                break;
            case FURGON:
                System.out.println("Es un automovil utilitario de transporte,de empresas ");
                break;
            case HATCHBACK:
                System.out.println("Es un automovil mediano compacto, aspecto deportivo");
                break;
            case PICKUP:
                System.out.println("Es un automovil de doble cabina o camioneta");
                break;
            case SEDAN:
                System.out.println("Es un automovil mediano");
                break;
            case STATION_WAGON:
                System.out.println("Es un automovil más grande, con maleta grande");
                break;*/

            //swtich mejorado a partir de java 13, el break es automático
        switch (tipo) {
            case CONVERTIBLE -> System.out.println("El automovil es deportivo y descapotable de dos puertas");
            case COUPE -> System.out.println("Es un automovil pequeño de dos puertas y típicamente deportivo");
            case FURGON -> System.out.println("Es un automovil utilitario de transporte,de empresas ");
            case HATCHBACK -> System.out.println("Es un automovil mediano compacto, aspecto deportivo");
            case PICKUP -> System.out.println("Es un automovil de doble cabina o camioneta");
            case SEDAN -> System.out.println("Es un automovil mediano");
            case STATION_WAGON -> System.out.println("Es un automovil más grande, con maleta grande");
        }

        TipoAutomovil[] tipos=TipoAutomovil.values();
        for (TipoAutomovil ta: tipos) {
            System.out.print(ta + " => " + ta.name() +  " , "+
                    ta.getNombre()+ ", "+
                    ta.getDescripcion() + ", "+
                    ta.getNumeroPuerta());
            System.out.println();
        }


    }
}
