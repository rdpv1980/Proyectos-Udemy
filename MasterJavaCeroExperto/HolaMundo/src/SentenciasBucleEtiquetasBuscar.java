public class SentenciasBucleEtiquetasBuscar {
    public static void main(String[] args) {
        String frase = " trigo tres tristes tigres tragan trigotrigo en un trigaltrigo";
        String palabra = "trigo";

        int maxPalabra = palabra.length();
        int maxFrase = frase.length()- maxPalabra + 1;

        int cantidad = 0;
        char letra = 'g';

        rommer:
        for (int i = 0; i <=maxFrase;) {
            int k=i;
            for (int j = 0; j < maxPalabra; j++) {
                if (frase.charAt(k++) != palabra.charAt(j)) {
                    i++;
                    continue rommer;
                }
            }
            cantidad++;
            i=i+maxPalabra;
        }
        System.out.println("Encontrado = " + cantidad + " veces la palabra " + palabra + " en la frase");
    }
}
