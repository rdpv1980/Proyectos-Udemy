import java.util.Scanner;

public class EjemploArregloNotasAlumnos {
    public static void main(String[] args) {

        double[] claseMatematicas, claseHistoria,claseLenguaje;
        double sumNotasMatematicas=0,sumNotasHistoria=0,sumNotasLenguaje=0;
        claseMatematicas=new double[7];
        claseHistoria=new double[7];
        claseLenguaje=new double[7];

        Scanner sc=new Scanner(System.in);
        System.out.println("Ingrese 7 notas para matemáticas");
        for (int i = 0; i <claseMatematicas.length ; i++) {
            claseMatematicas[i]= sc.nextDouble();
        }

        System.out.println("Ingrese 7 notas para Historia");
        for (int i = 0; i <claseHistoria.length ; i++) {
            claseHistoria[i]= sc.nextDouble();
        }

        System.out.println("Ingrese 7 notas para Lenguaje");
        for (int i = 0; i <claseLenguaje.length ; i++) {
            claseLenguaje[i]= sc.nextDouble();
        }

        for (int i = 0; i < 7; i++) {
            sumNotasMatematicas+=claseMatematicas[i];
            sumNotasHistoria+=claseHistoria[i];
            sumNotasLenguaje+=claseLenguaje[i];
        }

        double promedioMatematicas=(sumNotasMatematicas/claseMatematicas.length);
        double promedioHistoria=(sumNotasHistoria/claseHistoria.length);
        double promedioLentguaje=(sumNotasLenguaje/claseLenguaje.length);

        System.out.println("Promedio clase matemáticas : "+ promedioMatematicas);
        System.out.println("Promedio clase historia : "+ promedioHistoria);
        System.out.println("Promedio clase lenguaje : "+ promedioLentguaje);
        System.out.println("Promedio total del curso : "+
                (promedioMatematicas+promedioHistoria+promedioLentguaje)/3);

        System.out.println("Ingrese el identificador del alumno (de 0 - 6 ):");
        int id=sc.nextInt();
        double promedioAlumno=(claseHistoria[id]+claseLenguaje[id]+claseMatematicas[id])/3;
        System.out.println("Promedio alumno Nro  " + id + " : "+promedioAlumno);
    }
}
