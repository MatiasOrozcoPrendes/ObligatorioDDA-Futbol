import java.time.LocalDate;

public class DirectorTecnico {
    private Integer idDirectorTecnico;
    private String nombre;
    private String apellido;
    private Integer documento;
    private LocalDate fechaNacimiento;
    private Integer idEquipo;

    public DirectorTecnico(Integer idDirectorTecnico, String nombre, String apellido, Integer documento, LocalDate fechaNacimiento, Integer idEquipo) {
        this.idDirectorTecnico = idDirectorTecnico;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.fechaNacimiento = fechaNacimiento;
        this.idEquipo = idEquipo;
    }
    public DirectorTecnico() {
    }
    public Integer getIdDirectorTecnico() {
        return idDirectorTecnico;
    }
    public void setIdDirectorTecnico(Integer idDirectorTecnico) {
        this.idDirectorTecnico = idDirectorTecnico;
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
    public Integer getIdEquipo() {
        return idEquipo;
    }
    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }
    @Override
    public String toString() {
        return "Id: " + idDirectorTecnico + ", Director Técnico" + nombre + " " + apellido
                + "idEquipo " + idEquipo;
    }
}
