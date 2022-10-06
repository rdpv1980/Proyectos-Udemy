public class SentenciasBuclesEtiquetas {
    public static void main(String[] args) {

        bucle1:
        for (int i = 0; i < 5; i++) {
            System.out.println();
            for (int j = 0; j < 5; j++) {
                if (i == 2) {
                    continue bucle1;
                }
                System.out.print("[i = " + i +" . j= "+j+"], ");
            }
        }
        System.out.println("\n===========================================================");
        etiqueta:
        for (int i = 0; i < 5; i++) {
            System.out.println();

            for (int j = 0; j < 5; j++) {
                if (i == 2) {
                    break etiqueta;
                }
                System.out.print("[i = " + i +" . j= "+j+"], ");
            }
        }

        bucle:
        for (int i=1;i<=7;i++){
            int j=1;
            while (j<=8){
                if (i==6 || i==7){
                    System.out.println("Dia " + i + ": descanso de fin de semana");
                    continue bucle;
                }
                System.out.println("Dia " + i +", trabajando a las "+j+" hrs. ");
                j++;
            }
        }

        boolean esVerdadero = true;
        externo: //etiqueta la siguiente sentencia, es decir el for.
        for (int i = 0; i<5; i++){
            while (esVerdadero){
                System.out.println("Hola!");
                break externo; //break con etiqueta, hace que rompa la sentencia de la etiqueta, el for.
                            //sin la etiqueta, sería salir del bucle más interno, el while en este caso
            }
            System.out.println("Despues del while!");
        }
        System.out.println("Despues del for!");
    }
}
