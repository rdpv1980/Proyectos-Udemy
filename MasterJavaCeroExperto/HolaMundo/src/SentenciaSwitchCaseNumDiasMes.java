import java.util.Scanner;

public class SentenciaSwitchCaseNumDiasMes {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Ingrese el número del mes e 1 - 12");
       int mes=sc.nextInt(); //int mes=2;

       int numeroDias=0;
       System.out.println("Ingrese el año (YYYY)");
       int anio=sc.nextInt();

       switch (mes){
           case 1,3,5,7,8,10,12:
               numeroDias=31;
               break;
           case 4,6,9,11:
               numeroDias=30;
               break;
           case 2:
               if(anio%400==0||((anio%4==0)&& !(anio%100==0))){
                   numeroDias=29;
               }else{
                   numeroDias=28;
               }
               break;
           default:
               numeroDias=0;
       }
        System.out.println("numeroDias : "+ numeroDias);
    }
}
