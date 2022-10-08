import java.time.LocalDate;

public class DirectorTecnico extends Persona {
    private Integer idDirectorTecnico;
    private Integer idEquipo;

    public DirectorTecnico(Integer idDirectorTecnico, String nombre, String apellido, Integer documento, LocalDate fechaNacimiento, Integer idEquipo) {
        this.idDirectorTecnico = idDirectorTecnico;
        super.setNombre(nombre);
        super.setApellido(apellido);
        super.setDocumento(documento);
        super.setFechaNacimiento(fechaNacimiento);
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
    public Integer getIdEquipo() {
        return idEquipo;
    }
    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }
    @Override
    public String toString() {
        return "Id: " + idDirectorTecnico + ", Director Técnico" + super.getNombre() + " " + super.getApellido()
                + "idEquipo " + idEquipo;
    }
}
