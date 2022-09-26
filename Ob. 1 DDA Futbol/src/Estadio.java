public class Estadio {
    private Integer idEstadio;
    private String nombre;
    private String ciudad;

    public Estadio(Integer idEstadio, String nombre, String ciudad) {
        this.idEstadio = idEstadio;
        this.nombre = nombre;
        this.ciudad = ciudad;
    }
    public Estadio() {
    }
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
    @Override
    public String toString() {
        return "Id: " + idEstadio + " Estadio " + nombre + " de " + ciudad;
    }

}
