import java.time.LocalDate;
//Clase Arbitro que hereda de Persona
public class Arbitro  extends Persona {
    //Atributos
    //idArbitro es el identificador del arbitro, es un entero, unico.
    private Integer idArbitro;
    //puesto es el tipo de arbitro que es, es un String, puede ser: "arbitro" o "asistente".
    private String puesto;
    //Constructor con todos los atributos de la clase Arbitro, hereda de Persona y ademas tiene los atributos de la clase Arbitro.
    public Arbitro(Integer idArbitro, String nombre, String apellido, Integer documento, LocalDate fechaNacimiento, String puesto) {
        this.idArbitro = idArbitro;
        super.setNombre(nombre);
        super.setApellido(apellido);
        super.setDocumento(documento);
        super.setFechaNacimiento(fechaNacimiento);
        this.puesto = puesto;
    }
    //Constructor vacio de la clase Arbitro.
    public Arbitro() {
    }
    //Metodos get y set de los atributos de la clase Arbitro.
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
    //Metodo toString de la clase Arbitro. Imprime los atributos de la clase Arbitro. Id: ### Arbitro Nombre Apellido Puesto
    @Override
    public String toString() {
        return "Id: " + idArbitro + " Arbitro " + super.getNombre() + " " + super.getApellido() + " " + puesto;
    }
}
