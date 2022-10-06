import java.util.Scanner;

public class EjemploArreglosDesplazarPosicion3 {
    public static void main(String[] args) {

        int[]a =new int[7];
        int numero,posicion;

        Scanner sc=new Scanner(System.in);

        for (int i = 0; i <a.length-1 ; i++) {
            System.out.print("Ingrese un número :");
            a[i]= sc.nextInt();
        }
        System.out.println();

        System.out.println("Ingrese un número a insertar");
        numero=sc.nextInt();

        posicion=0;
        while (posicion<6 && numero>a[posicion]){
            posicion++;
        }

        for (int i = a.length-2; i >=posicion; i--) {
            a[i+1]=a[i];
        }
        a[posicion]=numero;
        System.out.println("El nuevo arreglo ordenado");

        for (int i = 0; i < a.length; i++) {
            System.out.println(i + " => " + a[i]);
        }
    }
}
