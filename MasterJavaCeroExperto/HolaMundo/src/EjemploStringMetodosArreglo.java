import java.util.Arrays;

public class EjemploStringMetodosArreglo {
    public static void main(String[] args) {

        String trabalenguas="trabalenguas";
        System.out.println("trabalenguas.length() = " + trabalenguas.length());;
        System.out.println("trabalenguas.toCharArray() = " + trabalenguas.toCharArray());

        char[] arreglo= trabalenguas.toCharArray();
        int largo=arreglo.length;
        System.out.println("largo = " + largo);
        for (int i=0; i<largo; i++){
            System.out.println("arreglo["+i+"] = " + arreglo[i]);
        }

        System.out.println("trabalenguas.split(\"a\") = " + trabalenguas.split("a"));

        String[] arreglo2=trabalenguas.split("a");

        for (String a: arreglo2) {
            System.out.println(a);
        }

        Arrays.stream(arreglo2).forEach(System.out::println);

        String archivo="alguna.imagen.pdf";
        String[] arreglo3=archivo.split("[.]");//o ("\\.")
        Arrays.stream(arreglo3).forEach(System.out::println);
        System.out.println("extension = " + arreglo3[arreglo3.length-1]);
        
    }
}
