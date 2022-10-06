public class WrapperInteger {
    public static void main(String[] args) {

        int intPrimitivo=32768;
        Integer intObjeto=Integer.valueOf(intPrimitivo);// asi esta depreciado
        System.out.println("intObjeto = " + intObjeto);
        Integer intObjeto2=32768;//autoboxing

        int num=intObjeto;//unboxing
        System.out.println("num = " + num);
        int num2=intObjeto.intValue();
        System.out.println("num2 = " + num2);

        String valorTvLcd="67000";
        Integer valor=Integer.valueOf(valorTvLcd);
        Integer valor2=Integer.parseInt(valorTvLcd);
        System.out.println("valor = " + valor);
        System.out.println("valor2 = " + valor2);

        Short shortObjeto=intObjeto.shortValue();
        System.out.println("shortObjeto = " + shortObjeto);//hay perdida de valor -32768

        Byte byteObjeto=intObjeto.byteValue();
        System.out.println("byteObjeto = " + byteObjeto);//hay perdida de valor

        Long longObjeto=intObjeto.longValue();
        System.out.println("longObjeto = " + longObjeto);


    }
}
