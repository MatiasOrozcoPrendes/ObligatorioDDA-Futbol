import java.time.LocalDate;
//Clase Persona que es la clase padre de las clases DirectorTecnico, Arbitro y Jugador.
public abstract class Persona {
    //Atributos
    //nombre es el nombre de la persona, es un String.
    private String nombre;
    //apellido es el apellido de la persona, es un String.
    private String apellido;
    //documento es el documento de la persona, es un entero de 8 digitos y es unico.
    private Integer documento;
    //fechaNacimiento es la fecha de nacimiento de la persona, es un LocalDate.
    private LocalDate fechaNacimiento;
    //Constructor con todos los atributos de la clase Persona.
    public Persona(String nombre, String apellido, Integer documento, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.fechaNacimiento = fechaNacimiento;
    }
    //Constructor vacio de la clase Persona.
    public Persona() {
    }
    //Metodos get y set de los atributos de la clase Persona.
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

}
