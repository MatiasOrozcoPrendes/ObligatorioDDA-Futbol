import java.time.LocalDate;

public class Arbitro  {
    private Integer idArbitro;
    private String nombre;
    private String apellido;
    private Integer documento;
    private LocalDate fechaNacimiento;
    private String puesto;

    public Arbitro(Integer idArbitro, String nombre, String apellido, Integer documento, LocalDate fechaNacimiento, String puesto) {
        this.idArbitro = idArbitro;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.fechaNacimiento = fechaNacimiento;
        this.puesto = puesto;
    }
    public Arbitro() {
    }
    public Integer getIdArbitro() {
        return idArbitro;
    }
    public void setIdArbitro(Integer idArbitro) {
        this.idArbitro = idArbitro;
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
    public String getPuesto() {
        return puesto;
    }
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    @Override
    public String toString() {
        return "Id: " + idArbitro + " Arbitro " + nombre + " " + apellido + " Puesto: " + puesto;
    }
}
