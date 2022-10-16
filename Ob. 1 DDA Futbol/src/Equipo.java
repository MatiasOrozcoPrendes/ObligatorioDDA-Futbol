//Clase Equipo
public class Equipo {
    //Atributos
    //idEquipo es el identificador del equipo, es un número entero y es único
    private Integer idEquipo;
    //nombre es el nombre del equipo, es un String
    private String nombre;
    //ciudad es la ciudad donde se encuentra el equipo, es un String
    private String ciudad;
    //Constructor con todos los atributos de la clase Equipo
    public Equipo(Integer idEquipo, String nombre, String ciudad) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.ciudad = ciudad;
    }
    //Constructor vacío de la clase Equipo
    public Equipo() {
    }
    //Getters y Setters de los atributos de la clase Equipo
    public Integer getIdEquipo() {
        return idEquipo;
    }
    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    //Método toString de la clase Equipo que devuelve un String con los atributos de la clase. Id: ### Equipo: Nombre de Ciudad.
    @Override
    public String toString() {
        return "Id: " + idEquipo + " Equipo " + nombre + " de " + ciudad;
    }
}
