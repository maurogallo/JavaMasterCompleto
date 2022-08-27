package src;

public class Automovil implements Comparable<Automovil>{
    private int id;
    private String fabricante;
    private String modelo;
    private Color color = Color.GRIS;
    private Motor motor;
    private Estanque estanque;
    private Persona conductor;
    private Rueda[] ruedas;
    private TipoAutomovil tipo;
    private static int ultimoId;
    private int indiceRuedas;
    public static final Integer VELOCIDAD_MAXIMA_CARRETERA = 120;
    public static final Integer VELOCIDAD_MAXIMA_Ciudad = 60;
    public static final String COLOR_ROJO = "Rojo";
    public static final String COLOR_AMARILLO = "Amarillo";
    public static final String COLOR_AZUL = "Azul";
    public static final String COLOR_BLANCO = "Blanco";
    public static final String COLOR_GRIS = "Gris Oscuro";
    private static Color colorPatente = Color.NARANJO;
    private static int capacidadEstanqueEstatico = 30;

    public Automovil() {
        this.id = ++ultimoId;
        this.ruedas = new Rueda[5];
    }

    public Automovil(String fabricante, String modelo) {
        this();
        this.fabricante = fabricante;
        this.modelo = modelo;
    }

    public Automovil(String fabricante, String modelo, Color color) {
        this(fabricante, modelo);
        this.color = color;
    }

    public Automovil(String fabricante, String modelo, Color color, Motor motor) {
        this(fabricante, modelo, color);
        this.motor = motor;
    }

    public Automovil(String fabricante, String modelo, Color color, Motor motor, Estanque estanque) {
        this(fabricante, modelo, color, motor);
        this.estanque = estanque;
    }

    public Automovil(String fabricante, String modelo, Color color, Motor motor, Estanque estanque, Persona conductor, Rueda[] ruedas) {
        this(fabricante, modelo, color, motor, estanque);
        this.conductor = conductor;
        this.ruedas = ruedas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFabricante() {
        return this.fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


    public static int getCapacidadEstanqueEstatico() {
        return capacidadEstanqueEstatico;
    }

    public static void setCapacidadEstanqueEstatico(int capacidadEstanqueEstatico) {
        Automovil.capacidadEstanqueEstatico = capacidadEstanqueEstatico;
    }

    public TipoAutomovil getTipo() {
        return tipo;
    }

    public void setTipo(TipoAutomovil tipo) {
        this.tipo = tipo;
    }

    public static Color getColorPatente() {
        return colorPatente;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public Estanque getEstanque() {
        if (estanque == null) {
            this.estanque = new Estanque();
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

    public Automovil addRueda(Rueda rueda) {
        if(indiceRuedas < this.ruedas.length){
            this.ruedas[indiceRuedas++] = rueda;
        }
        return this;
    }

    public static void setColorPatente(Color colorPatente) {
        Automovil.colorPatente = colorPatente;
    }

    public String verDetalle() {
        String detalle = "auto.id = " + this.id +
                "\nauto.fabricante = " + this.getFabricante() +
                "\nauto.modelo = " + this.getModelo();

        if (this.getTipo() != null) {
            detalle += "\nauto.tipo = " + this.getTipo().getDescripcion();
        }
        detalle += "\nauto.color = " + this.color +
                "\nauto.patenteColor = " + Automovil.colorPatente;
        if (this.motor != null) {
            detalle += "\nauto.cilindrada = " + this.motor.getCilindrada();
        }
        if (conductor != null) {
            detalle += ("\nConductor subaru:" + this.getConductor());
        }

        if (getRuedas() != null) {
            detalle += "\nRuedas del automovil:";
            for (Rueda r : this.getRuedas()) {
                detalle += "\n" + r.getFabricante() + ", aro: " + r.getAro() + ", ancho: " + r.getAncho();
            }
        }
        return detalle;
    }

    public String acelerar(int rpm) {
        return "El  auto " + fabricante + " acelerando a " + rpm + " rpm";
    }

    public String frenar() {
        return this.fabricante + " " + this.modelo + " frenando!";
    }

    public String acelerarFrenar(int rpm) {
        String acelerar = this.acelerar(rpm);
        String frenar = this.frenar();
        return acelerar + "\n" + frenar;
    }

    public float calcularConsumo(int km, float porcentajeBencina) {
        return km / (this.getEstanque().getCapacidad() * porcentajeBencina);
    }

    public float calcularConsumo(int km, int porcentajeBencina) {
        return km / (this.getEstanque().getCapacidad() * (porcentajeBencina / 100f));
    }

    public static float calcularConsumoEstatico(int km, float porcentajeBencina) {
        return km / (Automovil.capacidadEstanqueEstatico * (porcentajeBencina / 100f));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Automovil)) {
            return false;
        }
        Automovil a = (Automovil) obj;
        return (this.fabricante != null
                && this.modelo != null
                && this.fabricante.equals((a.getFabricante()))
                && this.modelo.equals(a.getModelo()));
    }

    @Override
    public String toString() {
        return this.id + " : " + fabricante + " " + modelo;
    }

    @Override
    public int compareTo(Automovil a) {
         return this.fabricante.compareTo(a.fabricante);
    }
}