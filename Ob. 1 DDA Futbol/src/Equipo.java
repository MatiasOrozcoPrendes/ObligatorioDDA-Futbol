public class Equipo {
    private Integer idEquipo;
    private String nombre;
    private String ciudad;

    public Equipo(Integer idEquipo, String nombre, String ciudad) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.ciudad = ciudad;
    }
    public Equipo() {
    }
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
    @Override
    public String toString() {
        return "Id: " + idEquipo + " Equipo " + nombre + " de " + ciudad;
    }
}
