public class PrimtivosFloat {

    static float varFlotante;

    public static void main(String[] args) {
        float realFloat=1.5e-10f;//1.5e4f;//2.12e3f;//21s0F; 0.00000000015f

        System.out.println("realFloat = " + realFloat);
        System.out.println("tipo float corresponde en bytes a " +Float.BYTES);
        System.out.println("tipo float corresponde en biies a " +Float.SIZE);
        System.out.println("valor máximo de un float : " + Float.MAX_VALUE);
        System.out.println("valor máximo de un float : " + Float.MIN_VALUE);

        double realDouble=3.4028235E38;

        System.out.println("realDouble "+ realDouble);
        System.out.println("tipo double corresponde en bytes a " +Double.BYTES);
        System.out.println("tipo double corresponde en bites a " +Double.SIZE);
        System.out.println("valor máximo de un double : " + Double.MAX_VALUE);
        System.out.println("valor máximo de un double : " + Double.MIN_VALUE);


        System.out.println("varFlotante = " + varFlotante);




    }
}
