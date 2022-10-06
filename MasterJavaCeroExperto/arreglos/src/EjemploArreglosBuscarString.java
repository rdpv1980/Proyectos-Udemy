import java.util.Locale;
import java.util.Scanner;

public class EjemploArreglosBuscarString {
    public static void main(String[] args) {

        String[] a =new String[4];

        Scanner sc=new Scanner(System.in);

        for (int i = 0; i < a.length; i++) {
            System.out.print("Ingrese un nombre : ");
            a[i]=sc.next();
        }

        System.out.println("\r\nIngres un nombre a buscar : ");
        String nombre= sc.next();
        int i=0;
        /*while (i <a.length && a[i]!=num){
            i++;
        }*/
        for (; i <a.length && a[i].equalsIgnoreCase(nombre) ; i++) {}

        if (i==a.length){
            System.out.println("Nombre no encontrado");
        }else if(a[i].toLowerCase().compareTo(nombre.toLowerCase())==0){
            System.out.println("Encontrado en la posicon: "+ i);
        }


    }
}
