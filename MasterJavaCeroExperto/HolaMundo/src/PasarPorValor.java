public class PasarPorValor {
    //los wrapper son inmutables osea se pasa por valor más q referencia
    public static void main(String[] args) {
        int i=10;

        System.out.println("iniciamos el metodo main con i = " + i);
        test(i);
        System.out.println("Finaliza el método main con i = "+ i);
    }

    public static void test(int i){
        System.out.println("Iniciamos el metodo test con i = " + i);
        i=35;
        System.out.println("Finaliza el método test con i = "+ i);
    }
}