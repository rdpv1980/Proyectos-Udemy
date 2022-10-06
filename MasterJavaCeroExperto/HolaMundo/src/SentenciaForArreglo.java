import javax.swing.*;

public class SentenciaForArreglo {
    public static void main(String[] args) {
        /*String [] nombres=new String[6];
        ó
        String [] nombres=new String[]{"a","b","c","d","e","f"};
        */
        String [] nombres={"Andres","Pepe","Maria","Paco","Lalo","Bea","Pato","Pepa"};

        for (int i=0;i<nombres.length;i++){
            if (nombres[i].equalsIgnoreCase("andres") ||
                    nombres[i].equalsIgnoreCase("pepa")){
                continue;
            }
            System.out.println(i+".- " + nombres[i]);
        }

        String buscar= JOptionPane.showInputDialog("Ingrese un nombre, ejmplo \"Pepe\" o \"Maria\":");
        System.out.println("buscar = " + buscar);

        boolean encontrado=false;
        for (int i=0;i<nombres.length; i++){
            if (nombres[i].equalsIgnoreCase(buscar)){
                encontrado=true;
                break;
            }
        }

        if (encontrado){
            JOptionPane.showMessageDialog(null,buscar +" fue encontrado");
        }
        else
            JOptionPane.showMessageDialog(null,buscar +" No existe en el sistema");
    }
}
