import java.time.LocalDate;
//Clase Partido
public class Partido {
    //Atributos
    //idPartido es el identificador del partido, es un número entero y es único
    private String idPartido;
    //fecha es la fecha del partido, es un LocalDate
    private LocalDate fecha;
    //hora es la hora del partido, es un String con el formato HH:MM
    private String hora;
    //clima es el clima del partido, es un String puede ser soleado, nublado o lluvioso
    private String clima;
    //duración es la duración del partido en minutos, es un número entero
    private Integer duracion;
    //idEquipoLocal es el identificador del equipo local, es un entero y es único
    private Integer idEquipoLocal;
    //idEquipoVisitante es el identificador del equipo visitante, es un entero y es único
    private Integer idEquipoVisitante;
    //idEstadio es el identificador del estadio, es un entero y es único
    private Integer idEstadio;
    //idArbitroPrincipal es el identificador del árbitro principal, es un entero y es único. El árbitro principal tiene que ser un árbitro de la lista de árbitros del tipo arbitro.
    private Integer idArbitroPrincipal;
    //idLinea1 es el identificador del árbitro de línea 1, es un entero y es único. El árbitro de línea 1 tiene que ser un árbitro de la lista de árbitros del tipo asistente.
    private Integer idLinea1;
    //idLinea2 es el identificador del árbitro de línea 2, es un entero y es único. El árbitro de línea 2 tiene que ser un árbitro de la lista de árbitros del tipo asistente.
    private Integer idLinea2;
    //idCuartoArbitro es el identificador del cuarto árbitro, es un entero y es único. El cuarto árbitro tiene que ser un árbitro de la lista de árbitros del tipo arbitro.
    private Integer idCuartoArbitro;
    //FormacionInicialLocal es la formación inicial del equipo local, es un String con la lista con los numeros de camiseta de los jugadores separados por espacio. Los primeros 11 jugadores son los titulares y los siguientes 5 son los suplentes.
    private String FormacionInicialLocal;
    //FormacionInicialVisitante es la formación inicial del equipo visitante, es un String con la lista con los numeros de camiseta de los jugadores separados por espacio. Los primeros 11 jugadores son los titulares y los siguientes 5 son los suplentes.
    private String FormacionInicialVisitante;
    //FormacionFinalLocal es la formación final del equipo local, es un String con la lista con los numeros de camiseta de los jugadores separados por espacio. Solo se guardan los 11 jugadores que terminaron el partido.
    private String FormacionFinalLocal;
    //FormacionFinalVisitante es la formación final del equipo visitante, es un String con la lista con los numeros de camiseta de los jugadores separados por espacio. Solo se guardan los 11 jugadores que terminaron el partido.
    private String FormacionFinalVisitante;
    //GolesLocal es un String con la lista de los goles del equipo local, cada gol tiene el formato "numeroCamiseta#minutoGol" separados por "-#-".
    private String GolesLocal;
    //GolesVisitante es un String con la lista de los goles del equipo visitante, cada gol tiene el formato "numeroCamiseta#minutoGol" separados por "-#-".
    private String GolesVisitante;
    //CambiosLocal es un String con la lista de los cambios del equipo local, cada cambio tiene el formato "numeroCamisetaJugadorSaliente#numeroCamisetaJugadorEntrante" separados por "-#-".
    private String CambiosLocal;
    //CambiosVisitante es un String con la lista de los cambios del equipo visitante, cada cambio tiene el formato "numeroCamisetaJugadorSaliente#numeroCamisetaJugadorEntrante" separados por "-#-".
    private String CambiosVisitante;
    //Constructor de la clase Partido con todos los atributos de la clase Partido.
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
    //Constructor de la clase Partido solo con los atributos necesarios para iniciar un partido.
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
    //Constructor de la clase Partido sin atributos.
    public Partido() {
    }
    //Getters y Setters de la clase Partido.
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
    //Método toString de la clase Partido devuelve: Partido Id #### AAAA-MM-DD HH:MM, idEquipoLocal= ####, idEquipoVisitante= ####.
    @Override
    public String toString() {
        return "Partido Id" + idPartido + " " + fecha + " " + hora + ", idEquipoLocal=" + idEquipoLocal + ", idEquipoVisitante=" + idEquipoVisitante ;
    }

}
