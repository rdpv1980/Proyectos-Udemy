import java.util.Locale;

public class EjemploStringMetodos {
    public static void main(String[] args) {
        String nombre="Rommer";

        System.out.println("nombre : "+ nombre.length());
        System.out.println("nombre en mayuscula :" +  nombre.toUpperCase());
        System.out.println("nombre en miniscula :" +  nombre.toLowerCase());
        System.out.println("nombre es igual a Rommer : "+nombre.equals("Rommer"));
        System.out.println("nombre es igual a rommer : "+nombre.equals("rommer"));
        System.out.println("nombre es igual a rommer : "+nombre.equalsIgnoreCase("rommer"));
        System.out.println("nombre.compareTo(\"Rommer\") = " + nombre.compareTo("Rommer"));
        System.out.println("nombre.compareTo(\"Rommer\") = " + nombre.compareTo("Pascacio"));
        System.out.println("nombre.compareTo(\"Rommer\") = " + nombre.charAt(1));
        System.out.println("nombre.compareTo(\"Rommer\") = " + nombre.charAt(0));
        System.out.println("nombre.compareTo(\"Rommer\") = " + nombre.charAt(nombre.length()-1));

        System.out.println("nombre.substring(1) = " + nombre.substring(1));
        System.out.println("nombre.substring(1) = " + nombre.substring(1,4));
        System.out.println("nombre.substring(4,6) = " + nombre.substring(4,6));
        System.out.println("nombre.substring(nombre.length()-1) = " + nombre.substring(nombre.length()-1));
        
        String trabalenguas="trabalenguas";
        System.out.println("trabalenguas.replace('a','.') = " + trabalenguas.replace('a','.'));
        System.out.println("trabalenguas.indexOf('a') = " + trabalenguas.indexOf('a'));
        System.out.println("trabalenguas.lastIndexOf('a') = " + trabalenguas.lastIndexOf('a'));
        System.out.println("trabalenguas.indexOf('z') = " + trabalenguas.indexOf("lenguas"));
        System.out.println("trabalenguas.contains(\"z\") = " + trabalenguas.contains("lenguas"));
        System.out.println("trabalenguas.startsWith(\"tr\") = " + trabalenguas.startsWith("tr"));
        System.out.println("trabalenguas.endsWith(\"as\") = " + trabalenguas.endsWith("as"));
        System.out.println(" trabalenguas ".trim());
        
    }
}
