import java.time.LocalDate;
//Clase Jugador que hereda de Persona
public class Jugador  extends Persona {
    //Atributos
    //idJugador es el identificador del jugador, es un entero, unico.
    private Integer idJugador;
    //numeroCamiseta es el numero de la camiseta del jugador, es un entero menor a 100, unico por equipo.
    private Short numeroCamiseta;
    //puesto es la posicion en la que juega el jugador, es un String, puede ser: "arquero", "defensor", "mediocampista" o "delantero".
    private String puesto;
    //idEquipo es el identificador del equipo al que pertenece el jugador, es un entero, unico. Cada equipo tiene varios jugadores y cada jugador pertenece a un equipo.
    private Integer idEquipo;
    //Constructor con todos los atributos de la clase Jugador, hereda de Persona y ademas tiene los atributos de la clase Jugador.
    public Jugador(Integer idJugador, String nombre, String apellido, Integer documento, LocalDate fechaNacimiento, Short numeroCamiseta, String puesto, Integer idEquipo) {
        this.idJugador = idJugador;
        super.setNombre(nombre);
        super.setApellido(apellido);
        super.setDocumento(documento);
        super.setFechaNacimiento(fechaNacimiento);
        this.numeroCamiseta = numeroCamiseta;
        this.puesto = puesto;
        this.idEquipo = idEquipo;
    }
    //Constructor vacio de la clase Jugador.
    public Jugador() {
    }
    //Metodos get y set de los atributos de la clase Jugador.
    public Integer getIdJugador() {
        return idJugador;
    }
    public void setIdJugador(Integer idJugador) {
        this.idJugador = idJugador;
    }
    public Short getNumeroCamiseta() {
        return numeroCamiseta;
    }
    public void setNumeroCamiseta(Short numeroCamiseta) {
        this.numeroCamiseta = numeroCamiseta;
    }
    public String getPuesto() {
        return puesto;
    }
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    public Integer getIdEquipo() {
        return idEquipo;
    }
    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }
    //Metodo toString de la clase Jugador. Imprime los atributos de la clase Jugador. Id: ### Jugador Nombre Apellido Numero de camiseta: ## Puesto
    @Override
    public String toString() {
        return "Id: " + idJugador + ", Jugador: " + super.getNombre() + " " + super.getApellido()
                + ", Número de camiseta: " + numeroCamiseta + ", Puesto: " + puesto;
    }

}
