import java.time.LocalDate;
//Clase DirectorTecnico que hereda de Persona
public class DirectorTecnico extends Persona {
    //Atributos
    //idDirectorTecnico es el identificador del director tecnico, es un entero, unico.
    private Integer idDirectorTecnico;
    // idEquipo es el identificador del equipo al que pertenece el director tecnico, es un entero, unico. Cada equipo tiene un director tecnico.
    private Integer idEquipo;
    //Constructor con todos los atributos de la clase DirectorTecnico, hereda de Persona y ademas tiene los atributos de la clase DirectorTecnico.
    public DirectorTecnico(Integer idDirectorTecnico, String nombre, String apellido, Integer documento, LocalDate fechaNacimiento, Integer idEquipo) {
        this.idDirectorTecnico = idDirectorTecnico;
        super.setNombre(nombre);
        super.setApellido(apellido);
        super.setDocumento(documento);
        super.setFechaNacimiento(fechaNacimiento);
        this.idEquipo = idEquipo;
    }
    //Constructor vacio de la clase DirectorTecnico.
    public DirectorTecnico() {
    }
    //Metodos get y set de los atributos de la clase DirectorTecnico.
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
    //Metodo toString de la clase DirectorTecnico. Imprime los atributos de la clase DirectorTecnico. Id: ### Director Tecnico Nombre Apellido idEquipo: ###
    @Override
    public String toString() {
        return "Id: " + idDirectorTecnico + ", Director Técnico" + super.getNombre() + " " + super.getApellido()
                + "idEquipo " + idEquipo;
    }
}
