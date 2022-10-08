import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    static Scanner teclado = new Scanner(System.in);
    static ArrayList<Equipo> equipos = new ArrayList<>();
    static ArrayList<DirectorTecnico> directoresTecnicos = new ArrayList<>();
    static ArrayList<Jugador> jugadores = new ArrayList<>();
    static ArrayList<Arbitro> arbitros = new ArrayList<>();
    static ArrayList<Estadio> estadios = new ArrayList<>();
    static ArrayList<Partido> partidos = new ArrayList<>();

    //Metodos iniciales
    public static void main(String[] args) {
        crearArchivos();
        leerArchivos();
        System.out.println(" ___________________________");
        System.out.println("|             |             |      _______          _________ ______   _______  _");
        System.out.println("|___          |          ___|     (  ____ \\|\\     /|\\__   __/(  ___ \\ (  ___  )( \\");
        System.out.println("|_  |         |         |  _|     | (    \\/| )   ( |   ) (   | (   ) )| (   ) || (");
        System.out.println("| | |.       ,|.       .| | |     | (__    | |   | |   | |   | (__/ / | |   | || |");
        System.out.println("| | | )     ( | )     ( | | |     |  __)   | |   | |   | |   |  __ (  | |   | || |");
        System.out.println("|_| |'       `|'       `| |_|     | (      | |   | |   | |   | (  \\ \\ | |   | || |");
        System.out.println("|___|         |         |___|     | )      | (___) |   | |   | )___) )| (___) || (____/");
        System.out.println("|             |             |     |/       (_______)   )_(   |______/ (_______)(_______/");
        System.out.println("|_____________|_____________|");
        System.out.println(" ");
        System.out.println(" ");
        Byte opcion = 0;
        do {
            menu();
            opcion = ingresoByte();
            switch (opcion){
                case 1:
                    gestionEquipos();
                    break;
                case 2:
                    gestionArbitros();
                    break;
                case 3:
                    gestionEstadios();
                    break;
                case 4:
                    iniciarPartido();
                    break;
                case 5:
                    listarPartidos();
                    break;
                case 6:
                    System.out.println("Gracias por utilizar el programa.");
                    break;
                case 7:
//                    Arbitro testArbitro = ingresoArbitroPrincipal();
//                    System.out.println(testArbitro);
                default:
                    System.out.println("Opción incorrecta.");
                    break;
            }
        } while (opcion != 6);
    }
    public static void crearArchivos() {
        pEquipo.crearArchivo();
        pDirectorTecnico.crearArchivo();
        pJugador.crearArchivo();
        pArbitro.crearArchivo();
        pEstadio.crearArchivo();
        pPartido.crearArchivo();
    }
    public static void leerArchivos() {
        equipos = pEquipo.leerEquipos();
        directoresTecnicos = pDirectorTecnico.leerDirectoresTecnicos();
        jugadores = pJugador.leerJugadores();
        arbitros = pArbitro.leerArbitros();
        estadios = pEstadio.leerEstadios();
        partidos = pPartido.leerPartidos();
    }
    //Metodos para crear los menus y submenus
    static void menu() {
        System.out.println(" ");
        System.out.println("1. Gestión de Equipos.");
        System.out.println("2. Gestión de Árbitros.");
        System.out.println("3. Gestión de Estadios.");
        System.out.println("4. Iniciar Partido.");
        System.out.println("5. Listar Partidos.");
        System.out.println("6. Salir.");
        System.out.println(" ");
        System.out.print("Ingrese una opción: ");
    }
    static void gestionEquipos() {
        Byte opcion = 0;
        do {
            System.out.println(" ");
            System.out.println("1. Alta de equipos.");
            System.out.println("2. Baja de equipos.");
            System.out.println("3. Modificación de equipos.");
            System.out.println("4. Listado de equipos.");
            System.out.println("5. Volver.");
            System.out.println(" ");
            System.out.print("Ingrese una opción: ");
            opcion = ingresoByte();
            switch (opcion){
                case 1:
                    altaEquipo();
                    break;
                case 2:
                    bajaEquipo();
                    break;
                case 3:
                    Byte aux = 0;
                    do {
                        Integer idEquipo = 0;
                        System.out.print("Ingrese el id del equipo a modificar: ");
                        idEquipo = ingresoInteger();
                        if (existeEquipo(idEquipo)) {
                            modificarEquipo(idEquipo);
                            aux = 1;
                        } else {
                            System.out.println("El id ingresado no existe.");
                            aux = 1;
                        }
                    } while (aux == 0);

                    break;
                case 4:
                    System.out.println(" ");
                    listarEquipos();
                    break;
                case 5:
                    System.out.println("Volviendo...");
                    break;
            }
        } while (opcion != 5);
    }
    public static void modificarEquipo(Integer idEquipo) {
        Byte opcion = 0;
        do {
            Equipo equipo = doyEquipoPorId(idEquipo);
            System.out.println(" ");
            System.out.println("El equipo a modificar es: " + equipo.getNombre());
            DirectorTecnico directorTecnico = doyDirectorTecnicoPorEquipo(idEquipo);
            if (directorTecnico != null) {
                System.out.println("El director técnico del equipo es: " + directorTecnico.getNombre() + " " + directorTecnico.getApellido());
                System.out.println("El equipo esta " + (equipoCompleto(idEquipo)? "completo" : "incompleto"));
            } else {
                System.out.println("El equipo no tiene director técnico.");
            }
            System.out.println(" ");
            System.out.println("1. Agregar Director Técnico.");
            System.out.println("2. Eliminar Director Técnico.");
            System.out.println("3. Gestionar Jugadores.");
            System.out.println("4. Volver.");
            System.out.println(" ");
            System.out.print("Ingrese una opción: ");
            opcion = ingresoByte();
            switch (opcion){
                case 1:
                    altaDirectorTecnico(idEquipo);
                    break;
                case 2:
                    bajaDirectorTecnicoPorEquipo(idEquipo);
                    break;
                case 3:
                    gestionJugadores(idEquipo);
                    break;
                case 4:
                    System.out.println("Volviendo...");
                    break;
            }
        } while (opcion != 4);
    }
    public static void gestionArbitros() {
        Byte opcion = 0;
        do {
            System.out.println(" ");
            System.out.println("1. Alta de Árbitro.");
            System.out.println("2. Baja de Árbitro.");
            System.out.println("3. Listar Árbitros.");
            System.out.println("4. Volver.");
            System.out.println(" ");
            System.out.print("Ingrese una opción: ");
            opcion = ingresoByte();
            switch (opcion){
                case 1:
                    altaArbitro();
                    break;
                case 2:
                    System.out.println(" ");
                    System.out.println("Ingrese id del arbitro a eliminar: ");
                    Integer idArbitro = ingresoInteger();
                    if (existeArbitro(idArbitro)) {
                        bajaArbitro(idArbitro);
                    } else {
                        System.out.println("No existe el arbitro con id " + idArbitro);
                    }
                    break;
                case 3:
                    System.out.println(" ");
                    listarArbitros();
                    break;
                case 4:
                    System.out.println("Volviendo...");
                    break;
            }
        } while (opcion != 4);
    }
    public static void gestionEstadios (){
        Byte opcion = 0;
        do {
            System.out.println(" ");
            System.out.println("1. Alta de Estadio.");
            System.out.println("2. Baja de Estadio.");
            System.out.println("3. Listar Estadios.");
            System.out.println("4. Volver.");
            System.out.println(" ");
            System.out.print("Ingrese una opción: ");
            opcion = ingresoByte();
            switch (opcion){
                case 1:
                    altaEstadio();
                    break;
                case 2:
                    System.out.println(" ");
                    System.out.println("Ingrese id del estadio a eliminar: ");
                    Integer idEstadio = ingresoInteger();
                    if (existeEstadio(idEstadio)) {
                        bajaEstadio(idEstadio);
                    } else {
                        System.out.println("No existe el estadio con id " + idEstadio);
                    }
                    break;
                case 3:
                    System.out.println(" ");
                    listarEstadios();
                    break;
                case 4:
                    System.out.println("Volviendo...");
                    break;
            }
        } while (opcion != 4);
    }
    public static void gestionJugadores(Integer idEquipo) {
        Byte opcion = 0;
        do {
            ArrayList<Jugador> jugadoresEquipo = jugadoresPorEquipos(idEquipo);
            System.out.println(" ");
            System.out.println("El equipo tiene " + jugadoresEquipo.size() + " jugadores.");
            System.out.println(" ");
            System.out.println("1. Alta de Jugador.");
            System.out.println("2. Baja de Jugador.");
            System.out.println("3. Listar Jugadores.");
            System.out.println("4. Volver.");
            System.out.println(" ");
            System.out.print("Ingrese una opción: ");
            opcion = ingresoByte();
            switch (opcion){
                case 1:
                    altaJugador(idEquipo);
                    break;
                case 2:
                    System.out.println("Ingrese id del jugador a eliminar: ");
                    Integer idJugador = ingresoInteger();
                    bajaJugador(idJugador);
                    break;
                case 3:
                    System.out.println(" ");
                    for (Jugador unJugador : jugadoresEquipo) {
                        System.out.println(unJugador);
                    }
                    break;
                case 4:
                    System.out.println("Volviendo...");
                    break;
            }
        } while (opcion != 4);
    }
    public static void iniciarPartido() {
        Byte opcion = 0;
        do {
            System.out.println(" ");
            System.out.println("1. Iniciar Partido.");
            System.out.println("2. Volver.");
            System.out.println(" ");
            System.out.print("Ingrese una opción: ");
            opcion = ingresoByte();
            switch (opcion){
                case 1:
                    System.out.println(" ");
                    System.out.println("Ingrese el id del equipo local: ");
                    Equipo equipoLocal = ingresoEquipo();
                    System.out.println("Ingrese el id del equipo visitante: ");
                    // verifico que el equipo local sea distinto al visitante
                    Equipo equipoVisitante = ingresoEquipo();
                    while (equipoLocal.getIdEquipo() == equipoVisitante.getIdEquipo()) {
                        System.out.println("El equipo local no puede ser el mismo que el visitante.");
                        System.out.println("Ingrese el id del equipo visitante: ");
                        equipoVisitante = ingresoEquipo();
                    }
                    System.out.println("Ingrese la fecha del partido a iniciar: ");
                    LocalDate fecha = ingresoFecha();
                    String idPartido = fecha.toString() + "-" + equipoLocal.getIdEquipo() + "-" + equipoVisitante.getIdEquipo();
                    if (!existePartido(idPartido)) {
                        altaPartido(idPartido, equipoLocal, equipoVisitante, fecha);
                    } else {
                        System.out.println("Ya existe un partido con esa fecha y equipos.");
                    }
                case 2:
                    System.out.println("Volviendo...");
                    break;
            }
        } while (opcion != 2);
    }

    //Metodos para crear los objetos
    public static void altaEquipo() {
        System.out.println(" ");
        System.out.println("Ingreso de equipos.");
        System.out.println(" ");
        System.out.println("Ingrese el nombre del equipo: ");
        String nombre = teclado.nextLine();
        System.out.println("Ingrese la ciudad del equipo: ");
        String ciudad = teclado.nextLine();
        Integer idEquipo = doyProximoIdEquipo();
        Equipo equipo = new Equipo(idEquipo, nombre, ciudad);
        pEquipo.escribirEquipo(equipo);
        equipos.add(equipo);
    }
    public static void altaJugador(Integer idEquipo) {
        System.out.println(" ");
        System.out.println("Ingreso de Jugador.");
        System.out.println(" ");
        System.out.println("Ingrese el nombre del Jugador: ");
        String nombre = teclado.nextLine();
        System.out.println("Ingrese el apellido del Jugador: ");
        String apellido = teclado.nextLine();
        System.out.println("Ingrese el documento del Jugador: ");
        Integer documento = ingresoDocumento();
        System.out.println("Ingrese la fecha de nacimiento del Jugador: ");
        LocalDate fechaNacimiento = ingresoFecha();
        System.out.println("Ingrese el número de camiseta del Jugador: ");
        Short numeroCamiseta = ingresoCamiseta(idEquipo);
        System.out.println("Ingrese la posición del Jugador: ");
        String puesto = ingresoPuestoJugador();
        Integer idJugador = doyProximoIdJugador();
        Jugador jugador = new Jugador(idJugador, nombre, apellido, documento, fechaNacimiento, numeroCamiseta, puesto, idEquipo);
        jugadores.add(jugador);
        pJugador.escribirJugador(jugador);
    }
    public static void altaDirectorTecnico(Integer idEquipo) {
        bajaDirectorTecnicoPorEquipo(idEquipo);
        System.out.println(" ");
        System.out.println("Ingreso de Director Técnico.");
        System.out.println(" ");
        System.out.println("Ingrese el nombre del Director Técnico: ");
        String nombre = teclado.nextLine();
        System.out.println("Ingrese el apellido del Director Técnico: ");
        String apellido = teclado.nextLine();
        System.out.println("Ingrese el documento del Director Técnico: ");
        Integer documento = ingresoDocumento();
        System.out.println("Ingrese la fecha de nacimiento del Director Técnico AAAA-MM-DD: ");
        LocalDate fechaNacimiento = ingresoFecha();
        Integer idDirectorTecnico = doyProximoIdDirectorTecnico();
        DirectorTecnico directorTecnico = new DirectorTecnico(idDirectorTecnico, nombre, apellido, documento, fechaNacimiento, idEquipo);
        directoresTecnicos.add(directorTecnico);
        pDirectorTecnico.escribirDirectorTecnico(directorTecnico);
        pDirectorTecnico.cargoNuevaListaDirectorTecnico(directoresTecnicos);


    }
    public static void altaArbitro() {
        System.out.println(" ");
        System.out.println("Ingreso de Arbitro.");
        System.out.println(" ");
        System.out.println("Ingrese el nombre del Arbitro: ");
        String nombre = teclado.nextLine();
        System.out.println("Ingrese el apellido del Arbitro: ");
        String apellido = teclado.nextLine();
        System.out.println("Ingrese el documento del Arbitro: ");
        Integer documento = ingresoDocumento();
        System.out.println("Ingrese la fecha de nacimiento del Arbitro  AAAA-MM-DD: ");
        LocalDate fechaNacimiento = ingresoFecha();
        System.out.println("Ingrese el puesto del Arbitro: ");
        String puesto = ingresoPuestoArbitro();
        Integer idArbitro = doyProximoIdArbitro();
        Arbitro arbitro = new Arbitro(idArbitro, nombre, apellido, documento, fechaNacimiento, puesto);
        arbitros.add(arbitro);
        pArbitro.escribirArbitro(arbitro);
    }
    public static void altaEstadio() {
        System.out.println(" ");
        System.out.println("Ingreso de Estadio.");
        System.out.println(" ");
        System.out.println("Ingrese el nombre del Estadio: ");
        String nombre = teclado.nextLine();
        System.out.println("Ingrese la ciudad del Estadio: ");
        String ciudad = teclado.nextLine();
        Integer idEstadio = doyProximoIdEstadio();
        Estadio estadio = new Estadio(idEstadio, nombre, ciudad);
        estadios.add(estadio);
        pEstadio.escribirEstadio(estadio);
    }
    public static void altaPartido(String idPartido, Equipo equipoLocal, Equipo equipoVisitante, LocalDate fechaPartido){
        System.out.println(" ");
        System.out.println("Ingrese la hora del partido en firma HH:MM: ");
        String horaPartido = ingresoHora();
        System.out.println("Ingrese el estadio del partido: ");
        Estadio estadioPartido = ingresoEstadio();
        System.out.println("Ingrese el clima del partido: ");
        String climaPartido = ingresoClima();
        ArrayList <Arbitro> arbitrosPartido = new ArrayList<>();
        System.out.println("Ingrese el arbitro principal del partido: ");
        Arbitro arbitroPrincipal = ingresoArbitroPrincipal(arbitrosPartido);
        arbitrosPartido.add(arbitroPrincipal);
        System.out.println("Ingrese el primer linea del partido: ");
        Arbitro arbitroLinea1 = ingresoArbitroAsistente(arbitrosPartido);
        arbitrosPartido.add(arbitroLinea1);
        System.out.println("Ingrese el segundo linea del partido: ");
        Arbitro arbitroLinea2 = ingresoArbitroAsistente(arbitrosPartido);
        arbitrosPartido.add(arbitroLinea2);
        System.out.println("Ingrese el cuarto arbitro: ");
        Arbitro cuartoArbitro = ingresoArbitroPrincipal(arbitrosPartido);
        arbitrosPartido.add(cuartoArbitro);
        System.out.println("Ingrese la formacion del equipo local: ");
        String formacionInicialLocal = ingresoFormacion(equipoLocal);
        muestroFormacion(formacionInicialLocal);
        System.out.println("Ingrese la formacion del equipo visitante: ");
        String formacionInicialVisitante = ingresoFormacion(equipoVisitante);
        muestroFormacion(formacionInicialVisitante);
        Partido partido = new Partido(idPartido, fechaPartido, horaPartido, climaPartido, equipoLocal.getIdEquipo(), equipoVisitante.getIdEquipo(), estadioPartido.getIdEstadio(), arbitroPrincipal.getIdArbitro(), arbitroLinea1.getIdArbitro(), arbitroLinea2.getIdArbitro(), cuartoArbitro.getIdArbitro(), formacionInicialLocal, formacionInicialVisitante);
        System.out.println("Ya esta todo pronto para comenzar el partido!");
        Byte opcionPartido = 0;
        String golesLocal = "";
        String golesVisitante = "";
        String cambiosLocal = "";
        String cambiosVisitante = "";
        int contadorCambiosLocal = 0;
        int contadorCambiosVisitante = 0;
        ArrayList<Jugador> titularesLocal = titularesPorEquipo(equipoLocal.getIdEquipo(), formacionInicialLocal);
        ArrayList<Jugador> suplentesLocal = suplentesPorEquipo(equipoLocal.getIdEquipo(), formacionInicialLocal);
        ArrayList<Jugador> titularesVisitante = titularesPorEquipo(equipoVisitante.getIdEquipo(), formacionInicialVisitante);
        ArrayList<Jugador> suplentesVisitante = suplentesPorEquipo(equipoVisitante.getIdEquipo(), formacionInicialVisitante);
        Short ultimoMinuto = 0;
        while (opcionPartido != 5) {
            System.out.println(" ");
            System.out.println("Que desea hacer?");
            System.out.println("1. Ingresar un gol del equipo local.");
            System.out.println("2. Ingresar un gol del equipo visitante.");
            System.out.println("3. Ingresar un cambio del equipo local.");
            System.out.println("4. Ingresar un cambio del equipo visitante.");
            System.out.println("5. Terminar el partido.");
            opcionPartido = ingresoByte();
            switch (opcionPartido){
            case 1:
                ultimoMinuto = ultimoMinutoGol(golesLocal, golesVisitante);
                golesLocal = ingresoGol(titularesLocal, golesLocal, ultimoMinuto);
                break;
            case 2:
                ultimoMinuto = ultimoMinutoGol(golesLocal, golesVisitante);
                golesVisitante = ingresoGol(titularesVisitante, golesVisitante, ultimoMinuto);
                break;
            case 3:
                if (contadorCambiosLocal < 3) {
                    String cambio1 = realizoCambio(titularesLocal, suplentesLocal);
                    cambiosLocal = cambiosLocal + cambio1.split(" ")[0] + "#" + cambio1.split(" ")[1] + "-#-" ;
                    titularesLocal = realizoCambio(titularesLocal, suplentesLocal, cambio1, "titulares");
                    suplentesLocal = realizoCambio(titularesLocal, suplentesLocal, cambio1, "suplentes");
                    contadorCambiosLocal++;
                } else {
                    System.out.println("Ya se realizaron los 3 cambios permitidos para el equipo local.");
                }
                break;
            case 4:
                if (contadorCambiosVisitante < 3) {
                    String cambio2 = realizoCambio(titularesVisitante, suplentesVisitante);
                    cambiosVisitante = cambiosVisitante + cambio2.split(" ")[0] + "#" + cambio2.split(" ")[1] + "-#-";
                    titularesVisitante = realizoCambio(titularesVisitante, suplentesVisitante, cambio2, "titulares");
                    suplentesVisitante = realizoCambio(titularesVisitante, suplentesVisitante, cambio2, "suplentes");
                    contadorCambiosVisitante++;
                } else {
                    System.out.println("Ya se realizaron los 3 cambios permitidos para el equipo visitante.");
                }
                break;
            case 5:
                System.out.println("El partido ha finalizado.");
                partido.setGolesLocal(golesLocal);
                partido.setGolesVisitante(golesVisitante);
                partido.setCambiosLocal(cambiosLocal);
                partido.setCambiosVisitante(cambiosVisitante);
                partido.setFormacionFinalLocal(pasoDeArrayAString(titularesLocal));
                partido.setFormacionFinalVisitante(pasoDeArrayAString(titularesVisitante));
                ultimoMinuto = ultimoMinutoGol(golesLocal, golesVisitante);
                System.out.println("Ingrese la duracion del partido en minutos: ");
                Integer duracionPartido = ingresoInteger();
                while (duracionPartido < ultimoMinuto) {
                    System.out.println("La duracion del partido no puede ser menor al ultimo minuto en el que se anoto un gol.");
                    System.out.println("Ingrese la duracion del partido en minutos: ");
                    duracionPartido = ingresoInteger();
                }
                partido.setDuracion(duracionPartido);
                partidos.add(partido);
                pPartido.escriboPartido(partido);
                break;
            }
        }
    }

    //Metodos para eliminar los objetos
    public static void bajaEquipo() {
        System.out.println(" ");
        System.out.println("Baja de equipos.");
        System.out.println(" ");
        System.out.println("Ingrese el id del equipo a dar de baja: ");
        Boolean valido = false;
        Integer idEquipo = 0;
        do {
            idEquipo = ingresoInteger();
        } while (!valido);
        if (existeEquipo(idEquipo)) {
            for (Equipo equipo : equipos) {
                if (equipo.getIdEquipo() == idEquipo) {
                    equipos.remove(equipo);
                    break;
                }
            }
            pEquipo.cargoNuevaListaEquipo(equipos);
            for (int i = jugadores.size() - 1; i >= 0; i--) {
                if (jugadores.get(i).getIdEquipo() == idEquipo) {
                    jugadores.remove(i);
                }
            }
            pJugador.cargoNuevaListaJugador(jugadores);
            for (int i = directoresTecnicos.size() - 1; i >= 0; i--) {
                if (directoresTecnicos.get(i).getIdEquipo() == idEquipo) {
                    directoresTecnicos.remove(i);
                }
            }
            pDirectorTecnico.cargoNuevaListaDirectorTecnico(directoresTecnicos);
            System.out.println("Equipo eliminado.");
        } else {
            System.out.println("El id ingresado no existe.");
        }


    }
    public static void bajaJugador(Integer idJugador) {
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getIdJugador() == idJugador) {
                jugadores.remove(i);
                pJugador.cargoNuevaListaJugador(jugadores);
            }
        }
    }
    public static void bajaDirectorTecnicoPorEquipo(Integer idEquipo) {
        for (int i = 0; i < directoresTecnicos.size(); i++) {
            if (directoresTecnicos.get(i).getIdEquipo() == idEquipo) {
                directoresTecnicos.remove(i);
                pDirectorTecnico.cargoNuevaListaDirectorTecnico(directoresTecnicos);
            }
        }
    }
    public static void bajaArbitro(Integer idArbitro) {
        for (int i = 0; i < arbitros.size(); i++) {
            if (arbitros.get(i).getIdArbitro() == idArbitro) {
                arbitros.remove(i);
                pArbitro.cargoNuevaListaArbitro(arbitros);
            }
        }
    }
    public static void bajaEstadio(Integer idEstadio) {
        for (int i = 0; i < estadios.size(); i++) {
            if (estadios.get(i).getIdEstadio() == idEstadio) {
                estadios.remove(i);
                pEstadio.cargoNuevaListaEstadio(estadios);
            }
        }
    }

    //Metodos para ingresar los datos por teclado
    public static Integer ingresoDocumento() {
        Integer numeroValido = 0;
        Boolean validado = false;
        do {
            try {
                numeroValido = Integer.parseInt(teclado.nextLine());
                //verifico que el numero ingresado tenga 8 digitos y no comience con 0
                if (numeroValido.toString().length() == 8 && numeroValido.toString().charAt(0) != '0') {
                    if (!existeDocumento(numeroValido)) {
                        validado = true;
                    } else {
                        System.out.println("El documento ingresado ya esta registrado \ncomo jugador, arbitro o juez.");
                    }
                } else {
                    System.out.println("El documento debe tener 8 dígitos y no puede comenzar con 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("El documento debe ser un número.");
            }
        } while (!validado);
        return numeroValido;
    }
    public static LocalDate ingresoFecha() {
        LocalDate fecha = null;
        Boolean fechaValida = false;
        do {
            try {
                fecha = LocalDate.parse(teclado.nextLine());
                fechaValida = true;
            } catch (DateTimeParseException e) {
                System.out.println("Fecha invalida. Formato esperado AAAA-MM-DD Ingrese nuevamente: ");
            }
        } while (!fechaValida);
        return fecha;
    }
    public static Short ingresoShort() {
        Short numeroValido = 0;
        Boolean validado = false;
        do {
            try {
                numeroValido = Short.parseShort(teclado.nextLine());
                validado = true;
            } catch (NumberFormatException e) {
                System.out.println("Debe ser numérico menor a 32767. Ingrese nuevamente: ");
            }
        } while (!validado);
        return numeroValido;
    }
    public static Short ingresoCamiseta(Integer idEquipo){
        Short numeroValido = 0;
        Boolean validado = false;
        String textoIngresado = "";
        do {
            try {
                textoIngresado = teclado.nextLine();
                if (textoIngresado.equals("list")){

                }
                numeroValido = Short.parseShort(teclado.nextLine());
                if (numeroValido > 0 && numeroValido < 100) {
                    if (!numeroCamisetaEnEquipo(numeroValido, idEquipo)) {
                        validado = true;
                    } else {
                        System.out.println("El número de camiseta ya esta registrado.");
                    }
                } else {
                    System.out.println("El número de camiseta debe ser mayor a 0 y menor a 100.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe ser numérico menor a 32767. Ingrese nuevamente: ");
            }
        } while (!validado);
        return numeroValido;
    }
    public static Integer ingresoInteger() {
        Integer numeroValido = 0;
        Boolean validado = false;
        do {
            try {
                numeroValido = Integer.parseInt(teclado.nextLine());
                validado = true;
            } catch (NumberFormatException e) {
                System.out.println("Debe ser numérico menor a 2147483647. Ingrese nuevamente: ");
            }
        } while (!validado);
        return numeroValido;
    }
    public static Byte ingresoByte() {
        Byte numeroValido = 0;
        Boolean validado = false;
        do {
            try {
                numeroValido = Byte.parseByte(teclado.nextLine());
                validado = true;
            } catch (NumberFormatException e) {
                System.out.println("Debe ser numérico menor a 127. Ingrese nuevamente: ");
            }
        } while (!validado);
        return numeroValido;
    }
    public static Character ingresoChar() {
        Character caracterValido = null;
        Boolean validado = false;
        do {
            try {
                caracterValido = teclado.nextLine().charAt(0);
                validado = true;
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Debe ingresar un caracter. Ingrese nuevamente: ");
            }
        } while (!validado);
        return caracterValido;
    }
    public static String ingresoHora() {
        String horaValida = "";
        Boolean validado = false;
        do {
            try {
                horaValida = teclado.nextLine();
                if (horaValida.length() == 5) {
                    if (horaValida.charAt(2) == ':') {
                        //verifico que los primeros dos caracteres sean numeros
                        try {
                            Integer.parseInt(horaValida.substring(0, 2));
                            //verifico que los ultimos dos caracteres sean numeros
                            try {
                                Integer.parseInt(horaValida.substring(3, 5));
                                if (Integer.parseInt(horaValida.substring(0, 2)) < 24) {
                                    if (Integer.parseInt(horaValida.substring(3, 5)) < 60) {
                                        validado = true;
                                    } else {
                                        System.out.println("Los minutos deben ser menores a 60. Ingrese nuevamente: ");
                                    }
                                } else {
                                    System.out.println("La hora debe ser menor a 24. Ingrese nuevamente: ");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Los minutos deben ser numéricos. Ingrese nuevamente: ");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Las horas deben ser numéricas. Ingrese nuevamente: ");
                        }
                    } else {
                        System.out.println("Debe ingresar los minutos con dos puntos. Ingrese nuevamente: ");
                    }
                } else {
                    System.out.println("Debe ingresar la hora con el formato HH:MM. Ingrese nuevamente: ");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Hora invalida. Formato esperado HH:MM Ingrese nuevamente: ");
            }
        } while (!validado);
        return horaValida;
    }
    public static String ingresoPuestoJugador() {
        String puesto = teclado.nextLine();
        Boolean puestoValido = false;
        do {
            if (puesto.equals("arquero") || puesto.equals("defensor") || puesto.equals("centrocampista") || puesto.equals("delantero")) {
                puestoValido = true;
            } else {
                System.out.println("Puesto invalido. \nLos puestos validos son: arquero, defensor, centrocampista, delantero. \nIngrese nuevamente: ");
                puesto = teclado.nextLine();
            }
        } while (!puestoValido);
        return puesto;
    }
    public static String ingresoPuestoArbitro() {
        String puesto = teclado.nextLine();
        Boolean puestoValido = false;
        do {
            if (puesto.equals("arbitro") || puesto.equals("asistente") ) {
                puestoValido = true;
            } else {
                System.out.println("Puesto invalido. \nLos puestos validos son: arbitro y asistente. \nIngrese nuevamente: ");
                puesto = teclado.nextLine();
            }
        } while (!puestoValido);
        return puesto;
    }
    public static Equipo ingresoEquipo() {
        Equipo equipo = null;
        Integer numeroValido = 0;
        Boolean validado = false;
        String textoEntrada = "";
        do {
            try {
                textoEntrada = teclado.nextLine();
                if (textoEntrada.equals("list")){
                    listarEquipos();
                } else {
                    numeroValido = Integer.parseInt(textoEntrada);
                    if (existeEquipo(numeroValido)) {
                        if (equipoCompleto(numeroValido)) {
                            equipo = doyEquipoPorId(numeroValido);
                            validado = true;
                        } else {
                            System.out.println("El equipo ingresado no esta completo. Ingrese nuevamente: ");
                        }
                    } else {
                        System.out.println("El equipo ingresado no existe. Ingrese nuevamente: ");
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println("Debe ser numérico. Ingrese nuevamente: ");
            }
        } while (!validado);
        return equipo;
    }
    public static String ingresoClima(){
        String clima = teclado.nextLine();
        Boolean climaValido = false;
        do {
            if (clima.equals("soleado") || clima.equals("nublado") || clima.equals("lluvioso")) {
                climaValido = true;
            } else {
                System.out.println("Clima invalido. \nLos climas validos son: soleado, nublado, lluvioso. \nIngrese nuevamente: ");
                clima = teclado.nextLine();
            }
        } while (!climaValido);
        return clima;
    }
    public static Estadio ingresoEstadio() {
        Estadio estadio = null;
        Integer numeroValido = 0;
        Boolean validado = false;
        String textoEntrada = "";
        do {
            try {
                textoEntrada = teclado.nextLine();
                if (textoEntrada.equals("list")){
                    listarEstadios();
                } else {
                    numeroValido = Integer.parseInt(textoEntrada);
                    if (existeEstadio(numeroValido)) {
                        estadio = doyEstadioPorId(numeroValido);
                        validado = true;
                    } else {
                        System.out.println("El estadio ingresado no existe. Ingrese nuevamente: ");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe ser numérico. Ingrese nuevamente: ");
            }
        } while (!validado);
        return estadio;
    }
    public static Arbitro ingresoArbitroPrincipal(ArrayList<Arbitro> arbitros) {
        Arbitro arbitro = null;
        Integer numeroValido = 0;
        Boolean validado = false;
        String textoEntrada = "";
        do {
            try {
                textoEntrada = teclado.nextLine();
                if (textoEntrada.equals("list")){
                    listarArbitros();
                } else {
                    numeroValido = Integer.parseInt(textoEntrada);
                    if (existeArbitro(numeroValido, arbitros)) {
                        System.out.println("El arbitro ingresado ya esta asignado en este partido. Ingrese nuevamente: ");
                    } else {
                        if (existeArbitro(numeroValido)) {
                            arbitro = doyArbitroPorId(numeroValido);
                            if (arbitro.getPuesto().equals("arbitro")) {
                                validado = true;
                            } else {
                                System.out.println("El arbitro ingresado no es principal. Ingrese nuevamente: ");
                            }
                        } else {
                            System.out.println("El arbitro ingresado no existe. Ingrese nuevamente: ");
                        }
                    }
                }


            } catch (NumberFormatException e) {
                System.out.println("Debe ser numérico. Ingrese nuevamente: ");
            }
        } while (!validado);
        return arbitro;
    }
    public static Arbitro ingresoArbitroAsistente(ArrayList<Arbitro> arbitros) {
        Arbitro arbitro = null;
        Integer numeroValido = 0;
        Boolean validado = false;
        String textoEntrada = "";
        do {
            try {
                textoEntrada = teclado.nextLine();
                if (textoEntrada.equals("list")){
                    listarArbitros();
                } else {
                    numeroValido = Integer.parseInt(textoEntrada);
                    if (existeArbitro(numeroValido, arbitros)) {
                        System.out.println("El arbitro ingresado ya esta asignado en este partido. Ingrese nuevamente: ");
                    } else {
                        if (existeArbitro(numeroValido)) {
                            arbitro = doyArbitroPorId(numeroValido);
                            if (arbitro.getPuesto().equals("asistente")) {
                                validado = true;
                            } else {
                                System.out.println("El arbitro ingresado no es asistente. Ingrese nuevamente: ");
                            }
                        } else {
                            System.out.println("El arbitro ingresado no existe. Ingrese nuevamente: ");
                        }
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe ser numérico. Ingrese nuevamente: ");
            }
        } while (!validado);
        return arbitro;
    }
    public static String ingresoFormacion(Equipo equipo) {
        //Cargo los jugadores del equipo
        ArrayList<Jugador> jugadores = jugadoresPorEquipos(equipo.getIdEquipo());
        //Creo un ArrayList de jugadores para la formacion
        ArrayList<Jugador> formacion = new ArrayList<>();
        //Listo los jugadores del equipo
        System.out.println("Jugadores del equipo: ");
        listarJugadores(equipo.getIdEquipo());
        //Pido los jugadores para la formacion
        System.out.println("Los primeros 11 jugadores ingresados seran los titulares. Los siguientes 5 seran los suplentes.");
        int i = 0;
        while (i < 16) {
            System.out.println("Ingrese el numero de camiseta del jugador: ");
            System.out.println("Faltan " + (16 - i) + " jugadores.");
            Short numero = ingresoShort();
            if (existeJugador(numero, jugadores)) {
                if (existeJugador(numero, formacion)) {
                    System.out.println("El jugador ya esta en la formacion. Ingrese nuevamente: ");
                } else {
                    formacion.add(doyJugadorPorCamisetaEquipo(numero, equipo.getIdEquipo()));
                    i++;
                }
            } else {
                System.out.println("El jugador no pertenece al equipo. Ingrese nuevamente: ");
            }
        }
        //Creo el string de la formacion con los numeros de camiseta de los jugadores
        String formacionString = "";
        for (Jugador jugador : formacion) {
            //Agrego el numero de camiseta del jugador al string colocando un 0 delante si es menor a 10
            if (jugador.getNumeroCamiseta() < 10) {
                formacionString += "0" + jugador.getNumeroCamiseta() + " ";
            } else {
                formacionString += jugador.getNumeroCamiseta() + " ";
            }
        }
        return formacionString;
    }
    public static String ingresoGol(ArrayList<Jugador> jugadores, String anterior, Short ultimoMinutoGol) {
        String gol = anterior;
        Boolean validado = false;
        String textoEntrada = "";
        do {
            System.out.println("Ingrese el numero de camiseta del jugador que hizo el gol: ");
            textoEntrada = teclado.nextLine();
            if (textoEntrada.equals("list")){
                for (Jugador jugador : jugadores) {
                    System.out.println(jugador.getNumeroCamiseta() + " - " + jugador.getNombre() + " " + jugador.getApellido());
                }
            } else {
                try {
                    Short numero = Short.parseShort(textoEntrada);
                    if (existeJugador(numero, jugadores)){
                        System.out.println("Ingrese el minuto en el que hizo el gol: ");
                        Short minuto = ingresoShort();
                        while (minuto <= ultimoMinutoGol) {
                            System.out.println("El minuto ingresado debe ser mayor al ultimo gol. Ingrese nuevamente: ");
                            minuto = ingresoShort();
                        }
                        gol += numero + "#" + minuto + "-#-";
                        validado = true;
                    } else {
                        System.out.println("El jugador no pertenece al equipo. Ingrese nuevamente: ");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Debe ser numérico. Ingrese nuevamente: ");
                }
            }
        } while (!validado);
        return gol;
    }


    //Metodos doyProximoId
    public static Integer doyProximoIdEquipo() {
        if (equipos.size() == 0) {
            return 1;
        } else {
            Integer ultimoId = equipos.get(equipos.size() - 1).getIdEquipo();
            return ultimoId + 1;
        }
    }
    public static Integer doyProximoIdJugador() {
        if (jugadores.size() == 0) {
            return 1;
        } else {
            Integer ultimoId = jugadores.get(jugadores.size() - 1).getIdJugador();
            return ultimoId + 1;
        }
    }
    public static Integer doyProximoIdDirectorTecnico() {
        if (directoresTecnicos.size() == 0) {
            return 1;
        } else {
            Integer ultimoId = directoresTecnicos.get(directoresTecnicos.size() - 1).getIdDirectorTecnico();
            return ultimoId + 1;
        }
    }
    public static Integer doyProximoIdArbitro() {
        if (arbitros.size() == 0) {
            return 1;
        } else {
            Integer ultimoId = arbitros.get(arbitros.size() - 1).getIdArbitro();
            return ultimoId + 1;
        }
    }
    public static Integer doyProximoIdEstadio() {
        if (estadios.size() == 0) {
            return 1;
        } else {
            Integer ultimoId = estadios.get(estadios.size() - 1).getIdEstadio();
            return ultimoId + 1;
        }
    }

    //Metodos Existe
    public static Boolean existeEquipo(Integer idEquipo) {
        Boolean existe = false;
        for (Equipo equipo : equipos) {
            if (equipo.getIdEquipo() == idEquipo) {
                existe = true;
            }
        }
        return existe;
    }
    public static Boolean existeArbitro(Integer idArbitro) {
        for (Arbitro unArbitro : arbitros) {
            if (unArbitro.getIdArbitro() == idArbitro) {
                return true;
            }
        }
        return false;
    }
    public static Boolean existeArbitro(Integer idArbitro, ArrayList<Arbitro> arbitros) {
        for (Arbitro unArbitro : arbitros) {
            if (unArbitro.getIdArbitro() == idArbitro) {
                return true;
            }
        }
        return false;
    }
    public static Boolean existeEstadio(Integer idEstadio) {
        for (Estadio unEstadio : estadios) {
            if (unEstadio.getIdEstadio() == idEstadio) {
                return true;
            }
        }
        return false;
    }
    public static Boolean existeDocumento(Integer documento) {
        for (Jugador unJugador : jugadores) {
            //if (unJugador.getDocumento() == documento) {
            if (String.valueOf(unJugador.getDocumento()).equals(String.valueOf(documento))) {
                return true;
            }
        }
        for (DirectorTecnico unDirectorTecnico : directoresTecnicos) {
            //if (unDirectorTecnico.getDocumento() == documento) {
            if (String.valueOf(unDirectorTecnico.getDocumento()).equals(String.valueOf(documento))) {
                return true;
            }
        }
        for (Arbitro unArbitro : arbitros) {
            //if (unArbitro.getDocumento() == documento) {
            if (String.valueOf(unArbitro.getDocumento()).equals(String.valueOf(documento))) {
                return true;
            }
        }
        return false;
    }
    public static Boolean existeJugador(Short idJugador, ArrayList<Jugador> jugadores) {
        for (Jugador unJugador : jugadores) {
            if (unJugador.getNumeroCamiseta() == idJugador) {
                return true;
            }
        }
        return false;
    }
    public static Boolean existePartido(String idPartido) {
        for (Partido unPartido : partidos) {
            if (unPartido.getIdPartido().equals(idPartido)) {
                return true;
            }
        }
        return false;
    }

    //Metodos que devuelven objetos
    public static Equipo doyEquipoPorId(Integer idEquipo) {
        Equipo equipo = null;
        for (Equipo unEquipo : equipos) {
            if (unEquipo.getIdEquipo() == idEquipo) {
                equipo = unEquipo;
            }
        }
        return equipo;
    }
    public static DirectorTecnico doyDirectorTecnicoPorEquipo(Integer idEquipo) {
        DirectorTecnico directorTecnico = null;
        for (DirectorTecnico unDirectorTecnico : directoresTecnicos) {
            if (unDirectorTecnico.getIdEquipo() == idEquipo) {
                directorTecnico = unDirectorTecnico;
            }
        }
        return directorTecnico;
    }
    public static Estadio doyEstadioPorId(Integer idEstadio) {
        Estadio estadio = null;
        for (Estadio unEstadio : estadios) {
            if (unEstadio.getIdEstadio() == idEstadio) {
                estadio = unEstadio;
            }
        }
        return estadio;
    }
    public static Arbitro doyArbitroPorId(Integer idArbitro) {
        Arbitro arbitro = null;
        for (Arbitro unArbitro : arbitros) {
            if (unArbitro.getIdArbitro() == idArbitro) {
                arbitro = unArbitro;
            }
        }
        return arbitro;
    }
    public static Jugador doyJugadorPorCamisetaEquipo(Short numeroCamiseta, Integer idEquipo) {
        Jugador jugador = null;
        for (Jugador unJugador : jugadores) {
            if (unJugador.getNumeroCamiseta() == numeroCamiseta && unJugador.getIdEquipo() == idEquipo) {
                jugador = unJugador;
            }
        }
        return jugador;
    }

    //Metodos para listar
    public static void listarEquipos() {
        for (Equipo equipo : equipos) {
            System.out.println(equipo + " " + (equipoCompleto(equipo.getIdEquipo())? "Completo" : "Incompleto"));
        }
    }
    public static void listarArbitros() {
        for (Arbitro arbitro : arbitros) {
            System.out.println(arbitro);
        }
    }
    public static void listarEstadios() {
        for (Estadio estadio : estadios) {
            System.out.println(estadio);
        }
    }
    public static void listarJugadores(Integer idEquipo)  {
        for (Jugador jugador : jugadores) {
            if (jugador.getIdEquipo() == idEquipo) {
                System.out.println(jugador);
            }
        }
    }
    public static void muestroFormacion(String formacion) {
        String[] jugadores = formacion.split(" ");
        if (jugadores.length == 11) {
            System.out.println("----------------------------------------");
            System.out.println("|             |    " + jugadores[0] + "    |             |");
            System.out.println("|             |          |             |");
            System.out.println("|             ------------             |");
            System.out.println("|  " + jugadores[1] + "     " + jugadores[2] + "                " + jugadores[3] + "     " + jugadores[4] + "  |");
            System.out.println("|                                      |");
            System.out.println("|                 ----                 |");
            System.out.println("|               -      -               |");
            System.out.println("-------" + jugadores[5] + "----------" + jugadores[6] + "----------" + jugadores[7] + "-------");
            System.out.println("|               -      -               |");
            System.out.println("|                 ----                 |");
            System.out.println("|                                      |");
            System.out.println("|      " + jugadores[8] + "          " + jugadores[9] + "          " + jugadores[10] + "      |");
            System.out.println("|             ------------             |");
            System.out.println("|             |          |             |");
            System.out.println("|             |          |             |");
            System.out.println("----------------------------------------");
        } else {
            System.out.println("----------------------------------------");
            System.out.println("|             |    " + jugadores[0] + "    |             |   " + jugadores[11]);
            System.out.println("|             |          |             |   " + jugadores[12]);
            System.out.println("|             ------------             |   " + jugadores[13]);
            System.out.println("|  " + jugadores[1] + "     " + jugadores[2] + "                " + jugadores[3] + "     " + jugadores[4] + "  |   " + jugadores[14]);
            System.out.println("|                                      |   " + jugadores[15]);
            System.out.println("|                 ----                 |");
            System.out.println("|               -      -               |");
            System.out.println("-------" + jugadores[5] + "----------" + jugadores[6] + "----------" + jugadores[7] + "-------");
            System.out.println("|               -      -               |");
            System.out.println("|                 ----                 |");
            System.out.println("|                                      |");
            System.out.println("|      " + jugadores[8] + "          " + jugadores[9] + "          " + jugadores[10] + "      |");
            System.out.println("|             ------------             |");
            System.out.println("|             |          |             |");
            System.out.println("|             |          |             |");
            System.out.println("----------------------------------------");
        }



    }
    public static void listarPartidos() {
        System.out.println(" ");
        System.out.println("Ingrese la fecha del partido que desea ver (AAAA-MM-DD)");
        LocalDate fecha = ingresoFecha();
        ArrayList<Partido> partidosFecha = new ArrayList<>();
        for (Partido partido : partidos) {
            if (partido.getFecha().equals(fecha)) {
                partidosFecha.add(partido);
            }
        }
        if (partidosFecha.size() > 0) {
            System.out.println(" ");
            System.out.println("Partidos de la fecha " + fecha);
            for (Partido partido : partidosFecha) {
                System.out.println(doyEquipoPorId(partido.getIdEquipoLocal()).getNombre() + " ID: " + partido.getIdEquipoLocal() + " VS " + doyEquipoPorId(partido.getIdEquipoVisitante()).getNombre() + " ID: " + partido.getIdEquipoVisitante());
            }
            System.out.println(" ");
            System.out.println("Ingrese el id del equipo local");
            Integer idEquipoLocal = ingresoInteger();
            System.out.println("Ingrese el id del equipo visitante");
            Integer idEquipoVisitante = ingresoInteger();
            for (Partido partido : partidosFecha) {
                if (partido.getIdEquipoLocal() == idEquipoLocal && partido.getIdEquipoVisitante() == idEquipoVisitante) {
                    System.out.println(" ");
                    System.out.println("Partido entre " + doyEquipoPorId(partido.getIdEquipoLocal()).getNombre() + " y " + doyEquipoPorId(partido.getIdEquipoVisitante()).getNombre());
                    System.out.println("Fecha: " + partido.getFecha());
                    System.out.println("Hora: " + partido.getHora());
                    System.out.println("Estadio: " + doyEstadioPorId(partido.getIdEstadio()).getNombre());
                    System.out.println("Arbitro Principal: " + doyArbitroPorId(partido.getIdArbitroPrincipal()).getNombre() + " " + doyArbitroPorId(partido.getIdArbitroPrincipal()).getApellido());
                    System.out.println("Arbitro Linea 1: " + doyArbitroPorId(partido.getIdLinea1()).getNombre() + " " + doyArbitroPorId(partido.getIdLinea1()).getApellido());
                    System.out.println("Arbitro Linea 2: " + doyArbitroPorId(partido.getIdLinea2()).getNombre() + " " + doyArbitroPorId(partido.getIdLinea2()).getApellido());
                    System.out.println("Arbitro Cuarto Arbitro: " + doyArbitroPorId(partido.getIdCuartoArbitro()).getNombre() + " " + doyArbitroPorId(partido.getIdCuartoArbitro()).getApellido());
                    System.out.println(" ");
                    System.out.println("Formacion " + doyEquipoPorId(partido.getIdEquipoLocal()).getNombre());
                    System.out.println(" ");
                    System.out.println("Director Tecnico: " + doyDirectorTecnicoPorEquipo(partido.getIdEquipoLocal()).getNombre() + " " + doyDirectorTecnicoPorEquipo(partido.getIdEquipoLocal()).getApellido());
                    muestroFormacion(partido.getFormacionInicialLocal());
                    System.out.println(" ");
                    System.out.println("Formacion " + doyEquipoPorId(partido.getIdEquipoVisitante()).getNombre());
                    System.out.println(" ");
                    System.out.println("Director Tecnico: " + doyDirectorTecnicoPorEquipo(partido.getIdEquipoVisitante()).getNombre() + " " + doyDirectorTecnicoPorEquipo(partido.getIdEquipoVisitante()).getApellido());
                    muestroFormacion(partido.getFormacionInicialVisitante());
                    System.out.println(" ");
                    System.out.println("Goles " + doyEquipoPorId(partido.getIdEquipoLocal()).getNombre());
                    System.out.println(" ");
                    String[] golesLocal = partido.getGolesLocal().split("-#-");
                    int golesLocalInt = 0;
                    if (!golesLocal[0].equals("")) {
                        for (String goles : golesLocal) {
                            String[] golesSeparados = goles.split("#");
                            System.out.println("Gol de: " + doyJugadorPorCamisetaEquipo(Short.parseShort(golesSeparados[0]), partido.getIdEquipoLocal()).getNombre() + " " + doyJugadorPorCamisetaEquipo(Short.parseShort(golesSeparados[0]), partido.getIdEquipoLocal()).getApellido() + " En el minuto: " + golesSeparados[1] + "'");
                            golesLocalInt++;
                        }
                    }
                    System.out.println("Total de goles: " + golesLocalInt);
                    System.out.println(" ");
                    System.out.println("Goles " + doyEquipoPorId(partido.getIdEquipoVisitante()).getNombre());
                    System.out.println(" ");
                    String[] golesVisitante = partido.getGolesVisitante().split("-#-");
                    int golesVisitanteInt = 0;
                    if (!golesVisitante[0].equals("")) {
                        for (String goles : golesVisitante) {
                            String[] golesSeparados = goles.split("#");
                            System.out.println("Gol de: " + doyJugadorPorCamisetaEquipo(Short.parseShort(golesSeparados[0]), partido.getIdEquipoVisitante()).getNombre() + " " + doyJugadorPorCamisetaEquipo(Short.parseShort(golesSeparados[0]), partido.getIdEquipoVisitante()).getApellido() + " En el minuto: " + golesSeparados[1] + "'");
                            golesVisitanteInt++;
                        }
                    }
                    System.out.println("Total de goles: " + golesVisitanteInt);
                    System.out.println(" ");
                    System.out.println("Cambios " + doyEquipoPorId(partido.getIdEquipoLocal()).getNombre());
                    System.out.println(" ");
                    String[] cambiosLocal = partido.getCambiosLocal().split("-#-");
                    if (!cambiosLocal[0].equals("")) {
                        for (String cambio : cambiosLocal) {
                            String[] cambioSeparado = cambio.split("#");
                            System.out.println("Cambio de: " + doyJugadorPorCamisetaEquipo(Short.parseShort(cambioSeparado[0]), partido.getIdEquipoLocal()).getNombre() + " " + doyJugadorPorCamisetaEquipo(Short.parseShort(cambioSeparado[0]), partido.getIdEquipoLocal()).getApellido() + " por " + doyJugadorPorCamisetaEquipo(Short.parseShort(cambioSeparado[1]), partido.getIdEquipoLocal()).getNombre() + " " + doyJugadorPorCamisetaEquipo(Short.parseShort(cambioSeparado[1]), partido.getIdEquipoLocal()).getApellido());
                        }
                    }
                    System.out.println(" ");
                    System.out.println("Cambios " + doyEquipoPorId(partido.getIdEquipoVisitante()).getNombre());
                    System.out.println(" ");
                    String[] cambiosVisitante = partido.getCambiosVisitante().split("-#-");
                    if (!cambiosVisitante[0].equals("")) {
                        for (String cambio : cambiosVisitante) {
                            String[] cambioSeparado = cambio.split("#");
                            System.out.println("Cambio de: " + doyJugadorPorCamisetaEquipo(Short.parseShort(cambioSeparado[0]), partido.getIdEquipoVisitante()).getNombre() + " " + doyJugadorPorCamisetaEquipo(Short.parseShort(cambioSeparado[0]), partido.getIdEquipoVisitante()).getApellido() + " por " + doyJugadorPorCamisetaEquipo(Short.parseShort(cambioSeparado[1]), partido.getIdEquipoVisitante()).getNombre() + " " + doyJugadorPorCamisetaEquipo(Short.parseShort(cambioSeparado[1]), partido.getIdEquipoVisitante()).getApellido());
                        }
                    }
                    System.out.println(" ");
                    System.out.println("Formacion final de " + doyEquipoPorId(partido.getIdEquipoLocal()).getNombre());
                    System.out.println(" ");
                    muestroFormacion(partido.getFormacionFinalLocal());
                    System.out.println(" ");
                    System.out.println("Formacion final de " + doyEquipoPorId(partido.getIdEquipoVisitante()).getNombre());
                    System.out.println(" ");
                    muestroFormacion(partido.getFormacionFinalVisitante());
                    System.out.println(" ");
                    if (golesLocalInt == golesVisitanteInt) {
                        System.out.println("Empate");
                    } else if (golesLocalInt > golesVisitanteInt) {
                        System.out.println("Gana " + doyEquipoPorId(partido.getIdEquipoLocal()).getNombre());
                    } else {
                        System.out.println("Gana " + doyEquipoPorId(partido.getIdEquipoVisitante()).getNombre());
                    }
                    System.out.println(" ");
                    System.out.println("Desea guardar el detalle del partido en un archivo de texto? (s/n)");
                    Character opcion = ingresoChar();
                    if (opcion.equals('s')){
                        escriboPartidoDetallado(partido);
                    }
                }
            }
        } else {
            System.out.println("No hay partidos para esa fecha");
            System.out.println("Las fechas disponibles son: ");
            for (Partido partido : partidos) {
                System.out.println(partido.getFecha());
            }
        }
    }

    //Metodos para crear arrays de objetos
    public static ArrayList<Jugador> jugadoresPorEquipos(Integer idEquipo) {
        ArrayList<Jugador> jugadoresEquipo = new ArrayList<Jugador>();
        for (Jugador jugador : jugadores) {
            if (jugador.getIdEquipo().equals(idEquipo)) {
                jugadoresEquipo.add(jugador);
            }
        }
        return jugadoresEquipo;
    }
    public static ArrayList<Jugador> titularesPorEquipo(Integer idEquipo, String formacion){
        ArrayList<Jugador> titulares = new ArrayList<Jugador>();
        String[] camisetas = formacion.split(" ");
        int i = 1;
        for (String camiseta : camisetas) {
            if (i <= 11) {
                titulares.add(doyJugadorPorCamisetaEquipo(Short.valueOf(camiseta), idEquipo));
            }
            i++;
        }
        return titulares;
    }
    public static ArrayList<Jugador> suplentesPorEquipo(Integer idEquipo, String formacion){
        ArrayList<Jugador> suplentes = new ArrayList<Jugador>();
        String[] camisetas = formacion.split(" ");
        int i = 1;
        for (String camiseta : camisetas) {
            if (i > 11) {
                suplentes.add(doyJugadorPorCamisetaEquipo(Short.valueOf(camiseta), idEquipo));
            }
            i++;
        }
        return suplentes;
    }

    //Metodos de Partidos
    public static Boolean equipoCompleto(Integer idEquipo) {
        Boolean completo = false;
        ArrayList<Jugador> auxJugadores = jugadoresPorEquipos(idEquipo);
        DirectorTecnico directorTecnico = doyDirectorTecnicoPorEquipo(idEquipo);
        if (auxJugadores.size() >= 16 && directorTecnico != null) {
            completo = true;
        }
        return completo;
    }
    public static Boolean numeroCamisetaEnEquipo(Short numeroCamiseta, Integer idEquipo) {
        Boolean existe = false;
        ArrayList<Jugador> jugadores = jugadoresPorEquipos(idEquipo);
        for (Jugador jugador : jugadores) {
            if (jugador.getNumeroCamiseta() == numeroCamiseta) {
                existe = true;
            }
        }
        return existe;
    }
    public static String realizoCambio(ArrayList<Jugador> titulares, ArrayList<Jugador> suplentes){
        System.out.println("Ingrese el numero de camiseta del jugador que sale: ");
        for (Jugador titular : titulares) {
            System.out.println(titular.getNumeroCamiseta() + " - " + titular.getNombre() + " " + titular.getApellido());
        }
        System.out.println(" ");
        Short numero1 = ingresoShort();
        while (!existeJugador(numero1, titulares)){
            System.out.println("El jugador no pertenece a los titulares. Ingrese nuevamente: ");
            numero1 = ingresoShort();
        }
        System.out.println("Ingrese el numero de camiseta del jugador que entra: ");
        for (Jugador suplente : suplentes) {
            System.out.println(suplente.getNumeroCamiseta() + " - " + suplente.getNombre() + " " + suplente.getApellido());
        }
        System.out.println(" ");
        Short numero2 = ingresoShort();
        while (!existeJugador(numero2, suplentes)){
            System.out.println("El jugador no pertenece a los suplentes. Ingrese nuevamente: ");
            numero2 = ingresoShort();
        }
        return numero1 + " " + numero2;
    }
    public static ArrayList<Jugador> realizoCambio(ArrayList<Jugador> titulares, ArrayList<Jugador> suplentes, String cambios, String tipo){
        ArrayList<Jugador> respuesta = new ArrayList<>();
        String[] camisetas = cambios.split(" ");
        Short numero1 = Short.valueOf(camisetas[0]);
        Short numero2 = Short.valueOf(camisetas[1]);
        if (tipo.equals("titulares")){
            for (Jugador titular : titulares) {
                if (titular.getNumeroCamiseta() != numero1) {
                    respuesta.add(titular);
                }
            }
            for (Jugador suplente : suplentes) {
                if (suplente.getNumeroCamiseta() == numero2) {
                    respuesta.add(suplente);
                }
            }
        } else {
            for (Jugador suplente : suplentes) {
                if (suplente.getNumeroCamiseta() != numero2) {
                    respuesta.add(suplente);
                }
            }
        }
        return respuesta;
    }
    public static String pasoDeArrayAString(ArrayList<Jugador> jugadores) {
        String formacion = "";
        for (Jugador jugador : jugadores) {
            if (jugador.getNumeroCamiseta() < 10) {
                formacion += "0" + jugador.getNumeroCamiseta() + " ";
            } else {
                formacion += jugador.getNumeroCamiseta() + " ";
            }

        }
        return formacion;
    }
    public static Short ultimoMinutoGol(String golesLocal, String golesVisitante) {
        Short ultimoMinutoLocal = 0;
        String[] golesArray = golesLocal.split("-#-");
        for (String gol : golesArray) {
            String[] golArray = gol.split("#");
            if (!golArray[0].equals("")) {
                Short minuto = Short.valueOf(golArray[1]);
                if (minuto > ultimoMinutoLocal) {
                    ultimoMinutoLocal = minuto;
                }
            }
        }
        Short ultimoMinutoVisitante = 0;
        golesArray = golesVisitante.split("-#-");
        for (String gol : golesArray) {
            String[] golArray = gol.split("#");
            if (!golArray[0].equals("")) {
                Short minuto = Short.valueOf(golArray[1]);
                if (minuto > ultimoMinutoVisitante) {
                    ultimoMinutoVisitante = minuto;
                }
            }
        }
        if (ultimoMinutoLocal > ultimoMinutoVisitante) {
            return ultimoMinutoLocal;
        } else {
            return ultimoMinutoVisitante;
        }

    }


    public static void escriboPartidoDetallado (Partido unPartido) {
        File archivo = new File("Partido" + unPartido.getIdPartido() +".txt");
        if (!archivo.exists()) {
            FileWriter fichero = null;
            PrintWriter pw = null;
            try {
                fichero = new FileWriter("Partido" + unPartido.getIdPartido() +".txt", true);
                pw = new PrintWriter(fichero);
                pw.println("Partido entre " + doyEquipoPorId(unPartido.getIdEquipoLocal()).getNombre() + " y " + doyEquipoPorId(unPartido.getIdEquipoVisitante()).getNombre());
                pw.println("Fecha: " + unPartido.getFecha());
                pw.println("Hora: " + unPartido.getHora());
                pw.println("Estadio: " + doyEstadioPorId(unPartido.getIdEstadio()).getNombre());
                pw.println("Arbitro Principal: " + doyArbitroPorId(unPartido.getIdArbitroPrincipal()).getNombre() + " " + doyArbitroPorId(unPartido.getIdArbitroPrincipal()).getApellido());
                pw.println("Arbitro Linea 1: " + doyArbitroPorId(unPartido.getIdLinea1()).getNombre() + " " + doyArbitroPorId(unPartido.getIdLinea1()).getApellido());
                pw.println("Arbitro Linea 2: " + doyArbitroPorId(unPartido.getIdLinea2()).getNombre() + " " + doyArbitroPorId(unPartido.getIdLinea2()).getApellido());
                pw.println("Arbitro Cuarto Arbitro: " + doyArbitroPorId(unPartido.getIdCuartoArbitro()).getNombre() + " " + doyArbitroPorId(unPartido.getIdCuartoArbitro()).getApellido());
                pw.println(" ");
                pw.println("Formacion " + doyEquipoPorId(unPartido.getIdEquipoLocal()).getNombre());
                pw.println(" ");
                pw.println("Director Tecnico: " + doyDirectorTecnicoPorEquipo(unPartido.getIdEquipoLocal()).getNombre() + " " + doyDirectorTecnicoPorEquipo(unPartido.getIdEquipoLocal()).getApellido());
                String[] jugadores = unPartido.getFormacionInicialLocal().split(" ");
                pw.println("----------------------------------------");
                pw.println("|             |    " + jugadores[0] + "    |             |   " + jugadores[11]);
                pw.println("|             |          |             |   " + jugadores[12]);
                pw.println("|             ------------             |   " + jugadores[13]);
                pw.println("|  " + jugadores[1] + "     " + jugadores[2] + "                " + jugadores[3] + "     " + jugadores[4] + "  |   " + jugadores[14]);
                pw.println("|                                      |   " + jugadores[15]);
                pw.println("|                 ----                 |");
                pw.println("|               -      -               |");
                pw.println("-------" + jugadores[5] + "----------" + jugadores[6] + "----------" + jugadores[7] + "-------");
                pw.println("|               -      -               |");
                pw.println("|                 ----                 |");
                pw.println("|                                      |");
                pw.println("|      " + jugadores[8] + "          " + jugadores[9] + "          " + jugadores[10] + "      |");
                pw.println("|             ------------             |");
                pw.println("|             |          |             |");
                pw.println("|             |          |             |");
                pw.println("----------------------------------------");
                pw.println(" ");
                pw.println("Formacion " + doyEquipoPorId(unPartido.getIdEquipoVisitante()).getNombre());
                pw.println(" ");
                pw.println("Director Tecnico: " + doyDirectorTecnicoPorEquipo(unPartido.getIdEquipoVisitante()).getNombre() + " " + doyDirectorTecnicoPorEquipo(unPartido.getIdEquipoVisitante()).getApellido());
                jugadores = unPartido.getFormacionInicialVisitante().split(" ");
                pw.println("----------------------------------------");
                pw.println("|             |    " + jugadores[0] + "    |             |   " + jugadores[11]);
                pw.println("|             |          |             |   " + jugadores[12]);
                pw.println("|             ------------             |   " + jugadores[13]);
                pw.println("|  " + jugadores[1] + "     " + jugadores[2] + "                " + jugadores[3] + "     " + jugadores[4] + "  |   " + jugadores[14]);
                pw.println("|                                      |   " + jugadores[15]);
                pw.println("|                 ----                 |");
                pw.println("|               -      -               |");
                pw.println("-------" + jugadores[5] + "----------" + jugadores[6] + "----------" + jugadores[7] + "-------");
                pw.println("|               -      -               |");
                pw.println("|                 ----                 |");
                pw.println("|                                      |");
                pw.println("|      " + jugadores[8] + "          " + jugadores[9] + "          " + jugadores[10] + "      |");
                pw.println("|             ------------             |");
                pw.println("|             |          |             |");
                pw.println("|             |          |             |");
                pw.println("----------------------------------------");
                pw.println(" ");
                pw.println("Goles " + doyEquipoPorId(unPartido.getIdEquipoLocal()).getNombre());
                pw.println(" ");
                String[] golesLocal = unPartido.getGolesLocal().split("-#-");
                int golesLocalInt = 0;
                if (!golesLocal[0].equals("")) {
                    for (String goles : golesLocal) {
                        String[] golesSeparados = goles.split("#");
                        pw.println("Gol de: " + doyJugadorPorCamisetaEquipo(Short.parseShort(golesSeparados[0]), unPartido.getIdEquipoLocal()).getNombre() + " " + doyJugadorPorCamisetaEquipo(Short.parseShort(golesSeparados[0]), unPartido.getIdEquipoLocal()).getApellido() + " En el minuto: " + golesSeparados[1] + "'");
                        golesLocalInt++;
                    }
                }
                pw.println("Total de goles: " + golesLocalInt);
                pw.println(" ");
                pw.println("Goles " + doyEquipoPorId(unPartido.getIdEquipoVisitante()).getNombre());
                pw.println(" ");
                String[] golesVisitante = unPartido.getGolesVisitante().split("-#-");
                int golesVisitanteInt = 0;
                if (!golesVisitante[0].equals("")) {
                    for (String goles : golesVisitante) {
                        String[] golesSeparados = goles.split("#");
                        pw.println("Gol de: " + doyJugadorPorCamisetaEquipo(Short.parseShort(golesSeparados[0]), unPartido.getIdEquipoVisitante()).getNombre() + " " + doyJugadorPorCamisetaEquipo(Short.parseShort(golesSeparados[0]), unPartido.getIdEquipoVisitante()).getApellido() + " En el minuto: " + golesSeparados[1] + "'");
                        golesVisitanteInt++;
                    }
                }
                pw.println("Total de goles: " + golesVisitanteInt);
                pw.println(" ");
                pw.println("Cambios " + doyEquipoPorId(unPartido.getIdEquipoLocal()).getNombre());
                pw.println(" ");
                String[] cambiosLocal = unPartido.getCambiosLocal().split("-#-");
                if (!cambiosLocal[0].equals("")) {
                    for (String cambio : cambiosLocal) {
                        String[] cambioSeparado = cambio.split("#");
                        pw.println("Cambio de: " + doyJugadorPorCamisetaEquipo(Short.parseShort(cambioSeparado[0]), unPartido.getIdEquipoLocal()).getNombre() + " " + doyJugadorPorCamisetaEquipo(Short.parseShort(cambioSeparado[0]), unPartido.getIdEquipoLocal()).getApellido() + " por " + doyJugadorPorCamisetaEquipo(Short.parseShort(cambioSeparado[1]), unPartido.getIdEquipoLocal()).getNombre() + " " + doyJugadorPorCamisetaEquipo(Short.parseShort(cambioSeparado[1]), unPartido.getIdEquipoLocal()).getApellido());
                    }
                }
                pw.println(" ");
                pw.println("Cambios " + doyEquipoPorId(unPartido.getIdEquipoVisitante()).getNombre());
                pw.println(" ");
                String[] cambiosVisitante = unPartido.getCambiosVisitante().split("-#-");
                if (!cambiosVisitante[0].equals("")) {
                    for (String cambio : cambiosVisitante) {
                        String[] cambioSeparado = cambio.split("#");
                        pw.println("Cambio de: " + doyJugadorPorCamisetaEquipo(Short.parseShort(cambioSeparado[0]), unPartido.getIdEquipoVisitante()).getNombre() + " " + doyJugadorPorCamisetaEquipo(Short.parseShort(cambioSeparado[0]), unPartido.getIdEquipoVisitante()).getApellido() + " por " + doyJugadorPorCamisetaEquipo(Short.parseShort(cambioSeparado[1]), unPartido.getIdEquipoVisitante()).getNombre() + " " + doyJugadorPorCamisetaEquipo(Short.parseShort(cambioSeparado[1]), unPartido.getIdEquipoVisitante()).getApellido());
                    }
                }
                pw.println(" ");
                pw.println("Formacion final de " + doyEquipoPorId(unPartido.getIdEquipoLocal()).getNombre());
                pw.println(" ");
                jugadores = unPartido.getFormacionFinalLocal().split(" ");
                pw.println("----------------------------------------");
                pw.println("|             |    " + jugadores[0] + "    |             |");
                pw.println("|             |          |             |");
                pw.println("|             ------------             |");
                pw.println("|  " + jugadores[1] + "     " + jugadores[2] + "                " + jugadores[3] + "     " + jugadores[4] + "  |");
                pw.println("|                                      |");
                pw.println("|                 ----                 |");
                pw.println("|               -      -               |");
                pw.println("-------" + jugadores[5] + "----------" + jugadores[6] + "----------" + jugadores[7] + "-------");
                pw.println("|               -      -               |");
                pw.println("|                 ----                 |");
                pw.println("|                                      |");
                pw.println("|      " + jugadores[8] + "          " + jugadores[9] + "          " + jugadores[10] + "      |");
                pw.println("|             ------------             |");
                pw.println("|             |          |             |");
                pw.println("|             |          |             |");
                pw.println("----------------------------------------");
                pw.println(" ");
                pw.println("Formacion final de " + doyEquipoPorId(unPartido.getIdEquipoVisitante()).getNombre());
                pw.println(" ");
                jugadores = unPartido.getFormacionFinalLocal().split(" ");
                pw.println("----------------------------------------");
                pw.println("|             |    " + jugadores[0] + "    |             |");
                pw.println("|             |          |             |");
                pw.println("|             ------------             |");
                pw.println("|  " + jugadores[1] + "     " + jugadores[2] + "                " + jugadores[3] + "     " + jugadores[4] + "  |");
                pw.println("|                                      |");
                pw.println("|                 ----                 |");
                pw.println("|               -      -               |");
                pw.println("-------" + jugadores[5] + "----------" + jugadores[6] + "----------" + jugadores[7] + "-------");
                pw.println("|               -      -               |");
                pw.println("|                 ----                 |");
                pw.println("|                                      |");
                pw.println("|      " + jugadores[8] + "          " + jugadores[9] + "          " + jugadores[10] + "      |");
                pw.println("|             ------------             |");
                pw.println("|             |          |             |");
                pw.println("|             |          |             |");
                pw.println("----------------------------------------");
                pw.println(" ");
                if (golesLocalInt == golesVisitanteInt) {
                    pw.println("Empate");
                } else if (golesLocalInt > golesVisitanteInt) {
                    pw.println("Gana " + doyEquipoPorId(unPartido.getIdEquipoLocal()).getNombre());
                } else {
                    pw.println("Gana " + doyEquipoPorId(unPartido.getIdEquipoVisitante()).getNombre());
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    // Nuevamente aprovechamos el finally para
                    // asegurarnos que se cierra el fichero.
                    if (null != fichero)
                        fichero.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        } else {
            System.out.println("Ya existe un archivo con ese nombre");
        }

    }

}
