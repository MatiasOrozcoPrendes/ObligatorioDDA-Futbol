import java.time.LocalDate;

public class Jugador  extends Persona {
    private Integer idJugador;
    private Short numeroCamiseta;
    private String puesto;
    private Integer idEquipo;

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
    public Jugador() {
    }
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
    @Override
    public String toString() {
        return "Id: " + idJugador + ", Jugador: " + super.getNombre() + " " + super.getApellido()
                + ", Número de camiseta: " + numeroCamiseta + ", Puesto: " + puesto;
    }

}
