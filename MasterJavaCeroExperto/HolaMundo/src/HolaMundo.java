import java.util.Locale;

public class HolaMundo {
    public static void main(String[] args) {

        String saludar="Hola mundo desde Java";
        System.out.println(saludar);
        System.out.println("saludar.toUpperCase() = " + saludar.toUpperCase(Locale.ROOT));
         int numero=10;

        boolean valor=true;
        if (valor){
            System.out.println("numero  = " + numero );
            int numero2=10;
        }
        System.out.println("numero = " + numero);
        var numero3="";
    }
}
