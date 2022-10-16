//Clase Estadio
public class Estadio {
    //Atributos
    //idEstadio es el identificador del estadio, es un número entero y es único
    private Integer idEstadio;
    //nombre es el nombre del estadio, es un String
    private String nombre;
    //ciudad es la ciudad donde se encuentra el estadio, es un String
    private String ciudad;
    //Constructor con todos los atributos de la clase Estadio
    public Estadio(Integer idEstadio, String nombre, String ciudad) {
        this.idEstadio = idEstadio;
        this.nombre = nombre;
        this.ciudad = ciudad;
    }
    //Constructor vacío de la clase Estadio
    public Estadio() {
    }
    //Getters y Setters de los atributos de la clase Estadio
    public Integer getIdEstadio() {
        return idEstadio;
    }
    public void setIdEstadio(Integer idEstadio) {
        this.idEstadio = idEstadio;
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
    //Método toString de la clase Estadio que devuelve un String con los atributos de la clase. Id: ### Estadio: Nombre de Ciudad.
    @Override
    public String toString() {
        return "Id: " + idEstadio + " Estadio " + nombre + " de " + ciudad;
    }

}
