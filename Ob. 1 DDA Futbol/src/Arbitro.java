import java.time.LocalDate;

public class Arbitro  extends Persona {
    private Integer idArbitro;
    private String puesto;

    public Arbitro(Integer idArbitro, String nombre, String apellido, Integer documento, LocalDate fechaNacimiento, String puesto) {
        this.idArbitro = idArbitro;
        super.setNombre(nombre);
        super.setApellido(apellido);
        super.setDocumento(documento);
        super.setFechaNacimiento(fechaNacimiento);
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

    public String getPuesto() {
        return puesto;
    }
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    @Override
    public String toString() {
        return "Id: " + idArbitro + " Arbitro " + super.getNombre() + " " + super.getApellido() + " " + puesto;
    }
}
