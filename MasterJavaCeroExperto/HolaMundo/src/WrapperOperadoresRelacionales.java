public class WrapperOperadoresRelacionales {
    public static void main(String[] args) {
        Integer num1=Integer.valueOf(1000);//Integer num1=1000;
        Integer num2=num1;

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);

        System.out.println("Son el mismo objeto? "+ (num1==num2));

        num2=1000;// se le asigna otro objeto

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);

        System.out.println("Son el mismo objeto? "+ (num1==num2));//se compara por referencia cuando son objetos
        //para el valor es co equals, como en el caso de los primitivos

        System.out.println("tienen el mismo valor? :" + num1.equals(num2));
        System.out.println("tienen el mismo valor? :" + (num1.intValue()==num2.intValue()));

        /*Hay una peculiaridad con los valores hasta 127, en ese caso compara por valor y no por referencia*/

        boolean condicion=num1>num2;
        System.out.println("condicion = " + condicion);

        boolean concicion2=num1.intValue() <num2.intValue();
        System.out.println("concicion2 = " + concicion2);
    }
}
