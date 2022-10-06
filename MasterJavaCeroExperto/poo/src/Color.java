public enum Color {
  /*  //es una coleccion de atributos constantes
    ROJO,
    AMARILLO,
    AZUL,
    BLANCO,
    GRIS,
    NARANJA;//no es necesario el punto y coma, pero si luego hay constructor, ahi si*/

    //Con valores personalizados :
    ROJO("Rojo"),
    AMARILLO("Amarillo"),
    AZUL("Azul"),
    BLANCO("Blanco"),
    GRIS("Gris Oscuro"),
    NARANJA("Naranja");

    private final String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return this.color;
    }
}
