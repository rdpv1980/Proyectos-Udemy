public class EjemploStringExtensionArchivo {
    public static void main(String[] args) {
        String archivo="alguna.imagen.pdf";
        int i=archivo.indexOf(".");
        int i2=archivo.lastIndexOf(".");

        System.out.println("archivo.length() " + archivo.length());
        System.out.println("archivo.substring(14) = " +  archivo.substring(i2+1));

    }
}
