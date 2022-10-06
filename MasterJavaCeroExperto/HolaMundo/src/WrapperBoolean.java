public class WrapperBoolean {
    public static void main(String[] args) {

        Integer num1, num2;
        num1 = 1;
        num2 = 2;

        boolean primeBoolean = num1 > num2;//false
        Boolean objBoolean = Boolean.valueOf(primeBoolean);//o tambien objBoolean=false, se hace el autoboxing
        Boolean objBoolean2 = Boolean.valueOf("false");
        Boolean objBoolean3=false;

        System.out.println("primeBoolean = " + primeBoolean);
        System.out.println("objetoBoolean = " + objBoolean);
        System.out.println("objetoBoolean2 = " + objBoolean2);

        System.out.println("comparando dos objetos boolean : " + (objBoolean == objBoolean2));
        System.out.println("comparando dos objetos boolean : " + (objBoolean.equals(objBoolean2)));
        System.out.println("comparando dos objetos boolean : " + (objBoolean2 == objBoolean3));
        System.out.println("comparando dos objetos boolean : " + (objBoolean == objBoolean3));
        //en el boolean con el == se compara valor o referencias, da lo mismo

        boolean primBoolean2=objBoolean2.booleanValue();//unboxing
        System.out.println("primBoolean2 = " + primBoolean2);
    }
}
