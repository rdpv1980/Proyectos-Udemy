import java.util.Arrays;

public class EjemploArreglosForOrdenamientoBurbuja {

    public static void arregloInverso(String[] arreglo){
        int total2= arreglo.length;
        int total=arreglo.length;
        //for (int i=0;i<total/2; i++)  : Una forma
        for (int i=0;i<total2; i++){
            String actual=arreglo[i];
            String inverso=arreglo[total-1-i];
            arreglo[i]=inverso;
            arreglo[total-1-i]=actual;
            total2--;
        }
    }

    public static void sortBurbuja(Object[] arreglo) {

        int total= arreglo.length;

        int contador=0;
        for (int i = 0; i < total-1; i++) {
            for (int j = 0; j < total-1-i; j++) {
                if (((Comparable)arreglo[j+1]).compareTo(arreglo[j])<0) {//En ves de Integer puede estar Comparable
                    //para ordenarlo de manera descendente es solo colocar > 0
                    Object auxiliar=arreglo[j];
                    arreglo[j]=arreglo[j+1];
                    arreglo[j+1]=auxiliar;
                }
                contador++;
            }
        }
        System.out.println("contador = " + contador);
    }

    public static void main(String[] args) {

        String[] productos={"Kingston Pendrive 64GB","Samsung Galaxy","Disco Duro SSD Samsung Externo",
                "Asus Notebook","Macbook Air","Chromecast 4ta generación","Bicicleta Oxford"};


       /* for (int i = 0; i < total; i++) {
            for (int j = 0; j < total; j++) {
                if (productos[i].compareTo(productos[j])<0) {
                    String auxiliar=productos[i];
                    productos[i]=productos[j];
                    productos[j]=auxiliar;
                }
                contador++;
            }
        }
        System.out.println("contador = " + contador);*/


        /*Arrays.sort(productos);
        arregloInverso(productos);*/
        int total= productos.length;
        sortBurbuja(productos);
        //Collections.reverse(Arrays.asList(productos));   con el api de java
        System.out.println("==========Usando for a la inversa=================");
        for (int i=0;i<total; i++){
            System.out.println("para indice = " + i +" : "+productos[i]);
        }

        Integer[] numeros=new Integer[4];

        numeros[0]=10;
        numeros[1]=Integer.valueOf("7");
        numeros[2]=35;
        numeros[3]=-1;

        sortBurbuja(numeros);

        for (int i = 0; i < numeros.length; i++) {
            System.out.println("i = " + i +" : "+ numeros[i]);
        }
    }
}
