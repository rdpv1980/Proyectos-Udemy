public class PrimitivosEnteros
{
    public static void main(String[] args) {
        
        byte numeroByte=127;
        System.out.println("numeroByte = " + numeroByte);
        System.out.println("tipo byte corresponde en byte a " +Byte.BYTES);
        System.out.println("tipo byte corresponde en byte a " +Byte.SIZE);
        System.out.println("valor máximo de un byte : " + Byte.MAX_VALUE);
        System.out.println("valor máximo de un byte : " + Byte.MIN_VALUE);

        short numeroShort=30000;
        System.out.println("numeroShort = " + numeroShort);
        System.out.println("tipo short corresponde en byte a " +Short.BYTES);
        System.out.println("tipo short corresponde en byte a " +Short.SIZE);
        System.out.println("valor máximo de un short : " + Short.MAX_VALUE);
        System.out.println("valor máximo de un short : " + Short.MIN_VALUE);

        int numeroInt=214748364;
        System.out.println("numeroInt = " + numeroInt);
        System.out.println("tipo int corresponde en bytes a " +Integer.BYTES);
        System.out.println("tipo int corresponde en bytes a " +Integer.SIZE);
        System.out.println("valor máximo de un int : " + Integer.MAX_VALUE);
        System.out.println("valor máximo de un int : " + Integer.MIN_VALUE);

        long numeroLong=9223372036854775807L;
        System.out.println("numeroLong = " + numeroLong);
        System.out.println("tipo long corresponde en bytes a " +Long.BYTES);
        System.out.println("tipo long corresponde en bytes a " +Long.SIZE);
        System.out.println("valor máximo de un long : " + Long.MAX_VALUE);
        System.out.println("valor máximo de un long : " + Long.MIN_VALUE);

        var numeroVar=127;

    }
}
