public class SentenciaFor {
    public static void main(String[] args) {

     //   for (int i=0;i<=5;i++){
     //       System.out.println("i = "+i);
     //   }

        /* este tipo de for no termina nunca
        for (;;) {
            System.out.println("hola");
        }*/

        //Otra forma
      /*  int i=0;
        for (;i<=5;){
           System.out.println("i = "+i);
           i++;
        }
        System.out.println("i = " + i);*/

        for (int i=1, j=10; i<j; i++,j--){
            System.out.println(i + " - " + j);
        }

        for (int i=0; i<=10;i++){
            if (!(i%2==0)){
                continue;
            }
            System.out.println("i = " + i);
        }
        
    }
}
