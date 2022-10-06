public class PasarPorReferencia {

    public static void main(String[] args) {
        int[] edad={10,11,12};

        System.out.println("iniciamos el metodo main");
        for (int i=0;i<edad.length; i++){
            System.out.println("edad[i] = " + edad[i]);
        }
        System.out.println("Antes de llamar al metodo test");
        test(edad);
        System.out.println("Después de llamar al metodo test");
        for (int i=0;i<edad.length; i++){
            System.out.println("edad[i] = " + edad[i]);
        }

        System.out.println("Finaliza el método main con los datos del arreglo modificados!");
    }

    public static void test(int[] edadArr){
        System.out.println("Iniciamos el metodo test ");
        for (int i=0;i<edadArr.length;i++){
            edadArr[i]=edadArr[i]+20;
        }
        System.out.println("Finaliza el método test con") ;
    }
}