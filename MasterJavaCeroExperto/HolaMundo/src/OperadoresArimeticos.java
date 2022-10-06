import javax.swing.*;

public class OperadoresArimeticos {
    public static void main(String[] args) {
        int i=5;
        int j=4;
        int suma=i+j;
        System.out.println("suma = " + suma);
        System.out.println("i + j "+i+j);
        System.out.println("i + j "+(i+j));
        
        int resta=i-j;
        System.out.println("resta = " + resta);
        System.out.println("i - j = " + (i-j));

        int multi=i*j;
        System.out.println("multiplicación = " + multi);

        int div=i/j;
        float div2=(float) i/j;
        System.out.println("division = " + div);
        System.out.println("div2 = " + div2);

        int resto = i%j;
        System.out.println("resto = " + resto);
        
        resto= 8%5;
        System.out.println("resto = " + resto);

        int numero= Integer.parseInt(JOptionPane.showInputDialog("ingrese un número"));
        if (numero%2==0){
            System.out.println("numero par =" +numero);
        }
        else {
            System.out.println("numero impar =" + numero);
        }

    }

}
