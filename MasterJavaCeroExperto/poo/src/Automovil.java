import java.util.Objects;

public class Automovil implements  Comparable{// una clase solo puede ser public o default, sin el public es default

    private int id;
    private String fabricante;
    private String modelo;
    private Color color=Color.GRIS;//private String color="gris";
    private Motor motor;
    private Estanque estanque;
    private Persona conductor;
    private Rueda[] ruedas;
    private int indiceRuedas;
    private TipoAutomovil tipo;

    private static Color colorPatente=Color.NARANJA;
    private static int capacidadEstanqueEstatico=30;
    private static int ultimoId;

    public static final Integer VELOCIDAD_MAXIMA_CARRETERA=120;
    static public final int VELOCIDAD_MAX_CIUDAD=60;
    final  public static int VELOCIDAD=100;
    public static final String COLOR_ROJO="Rojo";
    public static final String COLOR_AMARILLO="Amarillo";
    public static final String COLOR_AZUL="Azul";
    public static final String COLOR_BLANCO="Blanco";
    public static final String COLOR_GRIS_OSCURO="Gris Oscuro";

    //por defecto hay un constructor vacio, pero si llega a implementar uno con argumentos
    //ya reemplazaria al vacio por defecto, en ese caso se deberia crear explicitamente el constructor
    //vacio
    public Automovil() {
        this.id=++ultimoId;
        this.ruedas=new Rueda[5];
    }

    public Automovil(String fabricante, String modelo) {
        this();
        this.fabricante=fabricante;
        this.modelo=modelo;
    }

/*    public Automovil(String fabricante,String modelo,String color){
        this.fabricante=fabricante;
        this.modelo=modelo;
        this.color=color;
    }*/
    //Otra forma con this, llamando a otro constructor
    public Automovil(String fabricante,String modelo,Color color){
        this(fabricante,modelo);
        this.color=color;
    }


    public Automovil(String fabricante,String modelo,Color color, Motor motor){
        this(fabricante,modelo,color);
        this.motor=motor;
    }
    public Automovil(String fabricante,String modelo,Color color, Motor motor, Estanque estanque){
        this(fabricante,modelo,color,motor);
        this.estanque=estanque;
    }

    public Automovil(String fabricante, String modelo, Color color, Motor motor, Estanque estanque, Persona conductor, Rueda[] ruedas) {
        this(fabricante,modelo,color,motor,estanque);
        this.conductor = conductor;
        this.ruedas = ruedas;
    }

    public String getFabricante(){
        return this.fabricante;
    }

    public void setFabricante(String fabricante){
        this.fabricante=fabricante;
    }

    public String getModelo(){
        return this.modelo;
    }

    public void setModelo(String modelo){
        this.modelo=modelo;
    }

    public Color getColor(){
        return this.color;
    }

    public void setColor(Color color){
        this.color=color;
    }

    public static Color getColorPatente() {
        return colorPatente;
    }

    public static void setColorPatente(Color colorPatente) {
        Automovil.colorPatente = colorPatente;
    }
    public static int getCapacidadEstanqueEstatico() {
        return capacidadEstanqueEstatico;
    }

    public static void setCapacidadEstanqueEstatico(int capacidadEstanqueEstatico) {
        Automovil.capacidadEstanqueEstatico = capacidadEstanqueEstatico;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoAutomovil getTipo() {
        return tipo;
    }

    public void setTipo(TipoAutomovil tipo) {
        this.tipo = tipo;
    }

    /*    public String detalle(){
        StringBuilder sb=new StringBuilder();
        sb.append("auto.fabricante = " + this.fabricante);
        sb.append("\nauto.modelo = " + this.modelo);
        sb.append("\nauto.color = " + this.color);
        sb.append("\nauto.cilindrada = " + this.cilindrada);

        return sb.toString();
    }*/

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public Estanque getEstanque() {
        if (estanque==null){
            this.estanque=new Estanque();
        }
        return estanque;
    }

    public void setEstanque(Estanque estanque) {
        this.estanque = estanque;
    }

    public Persona getConductor() {
        return conductor;
    }

    public void setConductor(Persona conductor) {
        this.conductor = conductor;
    }

    public Rueda[] getRuedas() {
        return ruedas;
    }

    public void setRuedas(Rueda[] ruedas) {
        this.ruedas = ruedas;
    }

    public Automovil addRueda(Rueda rueda){
        if (indiceRuedas<this.ruedas.length) {
            this.ruedas[indiceRuedas++] = rueda;
        }
        return this;
    }

    public String verDetalle(){
        String detalle=  "auto.id = "+this.id+
                "\nauto.fabricante = " + this.getFabricante() +
                "\nauto.modelo = " + this.modelo;

        if (this.getTipo()!=null) {
            detalle += "\nauto.tipo = " + this.getTipo().getDescripcion();
        }
          detalle+=      "\nauto.color = " + this.color.getColor() +
                "\nauto.patenteColor = "+ colorPatente.getColor()+
                "\nauto.cilindrada = " + this.motor.getCilindrada();

        if (conductor!=null) {
            detalle += "\nConductor subaru : " + this.getConductor();
        }

        if (getRuedas()!=null){
            detalle+=" Ruedas del automovil";
        for (Rueda rueda:this.getRuedas()) {
            detalle+= "\n"+rueda.getFabricante()+", aro: "+rueda.getAro() +", ancho: " + rueda.getAncho();
           }
        }

            return  detalle;
    }

    public String acelerar(int rpm){
        return "el auto "+ fabricante + " acelerando a "+ rpm +" rpm";
    }

    public String frenar(){
        return fabricante +" "+ modelo + " frenando";
    }

    public String acelerarFrenar(int rpm){
        String acelerar=this.acelerar(rpm);
        String frenar=this.frenar();

        return acelerar + "\n"+frenar;
    }

    public float calcularConsumo(int km, float porcentajeBencina){
        return km/(porcentajeBencina*this.getEstanque().getCapacidad());
    }

    public float calcularConsumo(int km, int porcentajeBencina){
        return km/(getEstanque().getCapacidad()*(porcentajeBencina/100f));
    }

    public static float calcularConsumoEstatico(int km, int porcentajeBencina){
        return km/(capacidadEstanqueEstatico*(porcentajeBencina/100f));
    }
    @Override
    public boolean equals(Object obj) {

        if (this==obj){
            return true;
        }

        if (!(obj instanceof Automovil)){
            return false;
        }
        Automovil a=(Automovil) obj;
        return (this.fabricante!=null && this.modelo!=null && this.fabricante.equals(a.getFabricante())&& this.modelo.equals(a.getModelo()));
    }

    @Override
    public String toString() {
        return this.id + " : " + fabricante + " "+ modelo;
    }

    @Override
    public int compareTo(Object o) {
        Automovil a=(Automovil) o;

        return this.fabricante.compareTo(a.fabricante);
    }

    /*    @Override
    public String toString() {
        return "Automovil{" +
                "id=" + id +
                ", fabricante='" + fabricante + '\'' +
                ", modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", cilindrada=" + motor.getCilindrada() +
                ", capacidadEstanque=" + estanque.getCapacidad() +
                '}';
    }*/
}
