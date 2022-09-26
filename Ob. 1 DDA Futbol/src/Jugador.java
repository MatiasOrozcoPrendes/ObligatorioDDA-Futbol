import java.time.LocalDate;

public class Jugador {
    private Integer idJugador;
    private String nombre;
    private String apellido;
    private Integer documento;
    private LocalDate fechaNacimiento;
    private Short numeroCamiseta;
    private String puesto;
    private Integer idEquipo;

    public Jugador(Integer idJugador, String nombre, String apellido, Integer documento, LocalDate fechaNacimiento, Short numeroCamiseta, String puesto, Integer idEquipo) {
        this.idJugador = idJugador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.fechaNacimiento = fechaNacimiento;
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
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public Integer getDocumento() {
        return documento;
    }
    public void setDocumento(Integer documento) {
        this.documento = documento;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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
        return "Id: " + idJugador + ", Jugador: " + nombre + " " + apellido
                + ", Número de camiseta: " + numeroCamiseta + ", Puesto: " + puesto;
    }

}
