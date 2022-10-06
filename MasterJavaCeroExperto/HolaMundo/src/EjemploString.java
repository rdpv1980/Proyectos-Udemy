public class EjemploString 
{
    public static void main(String[] args) {
        String curso="Programación java";// si se crea otro String con el mismo valor , automaticamente
                  //el jvm usa el mismo objeto por eso son iguales a pesar que se hayan cradon con new
        String curso2=new String("Programación java");
        
        boolean esIgual=curso==curso2;
        System.out.println("curso==curso2 = " + esIgual);
        
        esIgual=curso.equals(curso2);
        System.out.println("curso.equals(curso2) = " + esIgual);

        String curso3="Programación java";
        esIgual=curso==curso3;
        System.out.println("curso==curso3 = " + esIgual);
        
    }
}
