import java.time.LocalDate;

public class Partido {
    private String idPartido;
    private LocalDate fecha;
    private String hora;
    private String clima;
    private Integer duracion;
    private Integer idEquipoLocal;
    private Integer idEquipoVisitante;
    private Integer idEstadio;
    private Integer idArbitroPrincipal;
    private Integer idLinea1;
    private Integer idLinea2;
    private Integer idCuartoArbitro;
    private String FormacionInicialLocal;
    private String FormacionInicialVisitante;
    private String FormacionFinalLocal;
    private String FormacionFinalVisitante;
    private String GolesLocal;
    private String GolesVisitante;
    private String CambiosLocal;
    private String CambiosVisitante;

    public Partido(String idPartido, LocalDate fecha, String hora, String clima, Integer duracion, Integer idEquipoLocal, Integer idEquipoVisitante, Integer idEstadio, Integer idArbitroPrincipal, Integer idLinea1, Integer idLinea2, Integer idCuartoArbitro, String FormacionInicialLocal, String FormacionInicialVisitante, String FormacionFinalLocal, String FormacionFinalVisitante, String GolesLocal, String GolesVisitante, String CambiosLocal, String CambiosVisitante) {
        this.idPartido = idPartido;
        this.fecha = fecha;
        this.hora = hora;
        this.clima = clima;
        this.duracion = duracion;
        this.idEquipoLocal = idEquipoLocal;
        this.idEquipoVisitante = idEquipoVisitante;
        this.idEstadio = idEstadio;
        this.idArbitroPrincipal = idArbitroPrincipal;
        this.idLinea1 = idLinea1;
        this.idLinea2 = idLinea2;
        this.idCuartoArbitro = idCuartoArbitro;
        this.FormacionInicialLocal = FormacionInicialLocal;
        this.FormacionInicialVisitante = FormacionInicialVisitante;
        this.FormacionFinalLocal = FormacionFinalLocal;
        this.FormacionFinalVisitante = FormacionFinalVisitante;
        this.GolesLocal = GolesLocal;
        this.GolesVisitante = GolesVisitante;
        this.CambiosLocal = CambiosLocal;
        this.CambiosVisitante = CambiosVisitante;
    }
    public Partido(String idPartido, LocalDate fecha, String hora, String clima, Integer idEquipoLocal, Integer idEquipoVisitante, Integer idEstadio, Integer idArbitroPrincipal, Integer idLinea1, Integer idLinea2, Integer idCuartoArbitro, String FormacionInicialLocal, String FormacionInicialVisitante) {
        this.idPartido = idPartido;
        this.fecha = fecha;
        this.hora = hora;
        this.clima = clima;
        this.duracion = 0;
        this.idEquipoLocal = idEquipoLocal;
        this.idEquipoVisitante = idEquipoVisitante;
        this.idEstadio = idEstadio;
        this.idArbitroPrincipal = idArbitroPrincipal;
        this.idLinea1 = idLinea1;
        this.idLinea2 = idLinea2;
        this.idCuartoArbitro = idCuartoArbitro;
        this.FormacionInicialLocal = FormacionInicialLocal;
        this.FormacionInicialVisitante = FormacionInicialVisitante;
        this.FormacionFinalLocal = "";
        this.FormacionFinalVisitante = "";
        this.GolesLocal = "Sin goles";
        this.GolesVisitante = "Sin goles";
        this.CambiosLocal = "Sin cambios";
        this.CambiosVisitante = "Sin cambios";
    }
    public Partido() {
    }

    public String getIdPartido() {
        return idPartido;
    }
    public void setIdPartido(String idPartido) {
        this.idPartido = idPartido;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public String getClima() {
        return clima;
    }
    public void setClima(String clima) {
        this.clima = clima;
    }
    public Integer getDuracion() {
        return duracion;
    }
    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }
    public Integer getIdEquipoLocal() {
        return idEquipoLocal;
    }
    public void setIdEquipoLocal(Integer idEquipoLocal) {
        this.idEquipoLocal = idEquipoLocal;
    }
    public Integer getIdEquipoVisitante() {
        return idEquipoVisitante;
    }
    public void setIdEquipoVisitante(Integer idEquipoVisitante) {
        this.idEquipoVisitante = idEquipoVisitante;
    }
    public Integer getIdEstadio() {
        return idEstadio;
    }
    public void setIdEstadio(Integer idEstadio) {
        this.idEstadio = idEstadio;
    }
    public Integer getIdArbitroPrincipal() {
        return idArbitroPrincipal;
    }
    public void setIdArbitroPrincipal(Integer idArbitroPrincipal) {
        this.idArbitroPrincipal = idArbitroPrincipal;
    }
    public Integer getIdLinea1() {
        return idLinea1;
    }
    public void setIdLinea1(Integer idLinea1) {
        this.idLinea1 = idLinea1;
    }
    public Integer getIdLinea2() {
        return idLinea2;
    }
    public void setIdLinea2(Integer idLinea2) {
        this.idLinea2 = idLinea2;
    }
    public Integer getIdCuartoArbitro() {
        return idCuartoArbitro;
    }
    public void setIdCuartoArbitro(Integer idCuartoArbitro) {
        this.idCuartoArbitro = idCuartoArbitro;
    }
    public String getFormacionInicialLocal() {
        return FormacionInicialLocal;
    }
    public void setFormacionInicialLocal(String FormacionInicialLocal) {
        this.FormacionInicialLocal = FormacionInicialLocal;
    }
    public String getFormacionInicialVisitante() {
        return FormacionInicialVisitante;
    }
    public void setFormacionInicialVisitante(String FormacionInicialVisitante) {
        this.FormacionInicialVisitante = FormacionInicialVisitante;
    }
    public String getFormacionFinalLocal() {
        return FormacionFinalLocal;
    }
    public void setFormacionFinalLocal(String FormacionFinalLocal) {
        this.FormacionFinalLocal = FormacionFinalLocal;
    }
    public String getFormacionFinalVisitante() {
        return FormacionFinalVisitante;
    }
    public void setFormacionFinalVisitante(String FormacionFinalVisitante) {
        this.FormacionFinalVisitante = FormacionFinalVisitante;
    }
    public String getGolesLocal() {
        return GolesLocal;
    }
    public void setGolesLocal(String GolesLocal) {
        this.GolesLocal = GolesLocal;
    }
    public String getGolesVisitante() {
        return GolesVisitante;
    }
    public void setGolesVisitante(String GolesVisitante) {
        this.GolesVisitante = GolesVisitante;
    }
    public String getCambiosLocal() {
        return CambiosLocal;
    }
    public void setCambiosLocal(String CambiosLocal) {
        this.CambiosLocal = CambiosLocal;
    }
    public String getCambiosVisitante() {
        return CambiosVisitante;
    }
    public void setCambiosVisitante(String CambiosVisitante) {
        this.CambiosVisitante = CambiosVisitante;
    }

    @Override
    public String toString() {
        return "Partido{" + "idPartido=" + idPartido + ", fecha=" + fecha + ", hora=" + hora + ", clima=" + clima + ", duracion=" + duracion + ", idEquipoLocal=" + idEquipoLocal + ", idEquipoVisitante=" + idEquipoVisitante + ", idEstadio=" + idEstadio + ", idArbitroPrincipal=" + idArbitroPrincipal + ", idLinea1=" + idLinea1 + ", idLinea2=" + idLinea2 + ", idCuartoArbitro=" + idCuartoArbitro + ", FormacionInicialLocal=" + FormacionInicialLocal + ", FormacionInicialVisitante=" + FormacionInicialVisitante + ", FormacionFinalLocal=" + FormacionFinalLocal + ", FormacionFinalVisitante=" + FormacionFinalVisitante + ", GolesLocal=" + GolesLocal + ", GolesVisitante=" + GolesVisitante + ", CambiosLocal=" + CambiosLocal + ", CambiosVisitante=" + CambiosVisitante + '}';
    }

}
