import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
//Clase Principal con el metodo main
public class Principal {
    //Creo un objeto de la clase Scanner para leer datos por teclado
    static Scanner teclado = new Scanner(System.in);
    //Creo el ArrayList "equipos" que contendra los equipos
    static ArrayList<Equipo> equipos = new ArrayList<>();
    //Creo el ArrayList "directoresTecnicos" que contendra los directores tecnicos
    static ArrayList<DirectorTecnico> directoresTecnicos = new ArrayList<>();
    //Creo el ArrayList "jugadores" que contendra los jugadores
    static ArrayList<Jugador> jugadores = new ArrayList<>();
    //Creo el ArrayList "arbitros" que contendra los arbitros
    static ArrayList<Arbitro> arbitros = new ArrayList<>();
    //Creo el ArrayList "estadios" que contendra los estadios
    static ArrayList<Estadio> estadios = new ArrayList<>();
    //Creo el ArrayList "partidos" que contendra los partidos
    static ArrayList<Partido> partidos = new ArrayList<>();

    //Metodos iniciales
    public static void main(String[] args) {
        crearArchivos();
        leerArchivos();
        //Imprimo un ASCII Art con el nombre del programa
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
        //Creo un bucle do-while para que el menu se repita hasta que el usuario decida salir
        do {
            //Imprimo el menu
            menu();
            //Pido al usuario que ingrese una opcion
            opcion = ingresoByte();
            //Creo un switch para que el programa sepa que opcion ejecutar
            //Llamo a la funcion correspondiente a la opcion elegida
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
                    //Si el usuario elige la opcion 6, el programa termina
                    System.out.println("Gracias por utilizar el programa.");
                    break;
                default:
                    //Si el usuario ingresa una opcion invalida, se le informa
                    System.out.println("Opción incorrecta.");
                    break;
            }
        } while (opcion != 6);
    }
    //Metodo para crear los archivos de persistencia si no existen al iniciar el programa
    public static void crearArchivos() {
        pEquipo.crearArchivo();
        pDirectorTecnico.crearArchivo();
        pJugador.crearArchivo();
        pArbitro.crearArchivo();
        pEstadio.crearArchivo();
        pPartido.crearArchivo();
    }
    //Metodo para leer los archivos de persistencia al iniciar el programa y cargar los ArrayList
    public static void leerArchivos() {
        equipos = pEquipo.leerEquipos();
        directoresTecnicos = pDirectorTecnico.leerDirectoresTecnicos();
        jugadores = pJugador.leerJugadores();
        arbitros = pArbitro.leerArbitros();
        estadios = pEstadio.leerEstadios();
        partidos = pPartido.leerPartidos();
    }
    //Metodos para crear los menus y submenus
    //Metodo para crear el menu principal
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
    //Metodo para crear el submenu de gestion de equipos
    static void gestionEquipos() {
        Byte opcion = 0;
        //Creo un bucle do-while para que el submenu se repita hasta que el usuario decida volver al menu principal
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
            //Creo un switch la opcion elegida
            switch (opcion){
                case 1:
                    //Llamo al metodo para dar de alta un equipo
                    altaEquipo();
                    break;
                case 2:
                    //Llamo al metodo para dar de baja un equipo
                    bajaEquipo();
                    break;
                case 3:
                    //Creo un bucle do-while para ingresar un id de equipo valido
                    Byte aux = 0;
                    do {
                        Integer idEquipo = 0;
                        System.out.print("Ingrese el id del equipo a modificar: ");
                        //Llamo al metodo ingresoInteger para que el usuario ingrese un id de equipo
                        idEquipo = ingresoInteger();
                        //Si el id ingresado es valido, llamo al metodo para modificar el equipo
                        if (existeEquipo(idEquipo)) {
                            //Llamo al metodo para modificar un equipo
                            modificarEquipo(idEquipo);
                            //Cambio el valor de aux para que el bucle se rompa
                            aux = 1;
                        } else {
                            //Si el id ingresado no es valido, se le informa al usuario y se repite el bucle
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
    //Metodo para crear el submenu de modificacion de equipos
    public static void modificarEquipo(Integer idEquipo) {
        //Creo un bucle do-while para que el submenu se repita hasta que el usuario decida volver al submenu de gestion de equipos
        Byte opcion = 0;
        do {
            //Creo un equipo y utilizo el metodo doyEquipoPorId para obtener el equipo a modificar
            Equipo equipo = doyEquipoPorId(idEquipo);
            System.out.println(" ");
            //Imprimo los datos del equipo a modificar
            System.out.println("El equipo a modificar es: " + equipo.getNombre());
            DirectorTecnico directorTecnico = doyDirectorTecnicoPorEquipo(idEquipo);
            //Si el equipo tiene un director tecnico, imprimo sus datos
            if (directorTecnico != null) {
                System.out.println("El director técnico del equipo es: " + directorTecnico.getNombre() + " " + directorTecnico.getApellido());
                System.out.println("El equipo esta " + (equipoCompleto(idEquipo)? "completo" : "incompleto"));
            } else {
                //Si el equipo no tiene un director tecnico, imprimo un mensaje
                System.out.println("El equipo no tiene director técnico.");
            }
            //Imprimo el submenu de modificacion de equipos
            System.out.println(" ");
            System.out.println("1. Agregar Director Técnico.");
            System.out.println("2. Eliminar Director Técnico.");
            System.out.println("3. Gestionar Jugadores.");
            System.out.println("4. Volver.");
            System.out.println(" ");
            System.out.print("Ingrese una opción: ");
            opcion = ingresoByte();
            //Creo un switch para la opcion elegida
            switch (opcion){
                case 1:
                    //Llamo al metodo para agregar un director tecnico
                    altaDirectorTecnico(idEquipo);
                    break;
                case 2:
                    //Llamo al metodo para eliminar un director tecnico
                    bajaDirectorTecnicoPorEquipo(idEquipo);
                    break;
                case 3:
                    //Llamo al metodo para gestionar los jugadores
                    gestionJugadores(idEquipo);
                    break;
                case 4:
                    System.out.println("Volviendo...");
                    break;
            }
        } while (opcion != 4);
    }
    //Metodo para crear el submenu de gestion de arbitros
    public static void gestionArbitros() {
        //Creo un bucle do-while para que el submenu se repita hasta que el usuario decida volver al menu principal
        Byte opcion = 0;
        do {
            //Imprimo el submenu de gestion de arbitros
            System.out.println(" ");
            System.out.println("1. Alta de Árbitro.");
            System.out.println("2. Baja de Árbitro.");
            System.out.println("3. Listar Árbitros.");
            System.out.println("4. Volver.");
            System.out.println(" ");
            System.out.print("Ingrese una opción: ");
            opcion = ingresoByte();
            //Creo un switch para la opcion elegida
            switch (opcion){
                case 1:
                    //Llamo al metodo para dar de alta un arbitro
                    altaArbitro();
                    break;
                case 2:
                    //Pido los datos del arbitro a eliminar
                    System.out.println(" ");
                    System.out.println("Ingrese id del arbitro a eliminar: ");
                    Integer idArbitro = ingresoInteger();
                    //Si el id ingresado es valido, llamo al metodo para eliminar el arbitro
                    if (existeArbitro(idArbitro)) {
                        bajaArbitro(idArbitro);
                    } else {
                        System.out.println("No existe el arbitro con id " + idArbitro);
                    }
                    break;
                case 3:
                    //Llamo al metodo para listar los arbitros
                    System.out.println(" ");
                    listarArbitros();
                    break;
                case 4:
                    System.out.println("Volviendo...");
                    break;
            }
        } while (opcion != 4);
    }
    //Metodo para crear el submenu de gestion de estadios
    public static void gestionEstadios (){
        //Creo un bucle do-while para que el submenu se repita hasta que el usuario decida volver al menu principal
        Byte opcion = 0;
        do {
            //Imprimo el submenu de gestion de estadios
            System.out.println(" ");
            System.out.println("1. Alta de Estadio.");
            System.out.println("2. Baja de Estadio.");
            System.out.println("3. Listar Estadios.");
            System.out.println("4. Volver.");
            System.out.println(" ");
            System.out.print("Ingrese una opción: ");
            opcion = ingresoByte();
            //Creo un switch para la opcion elegida
            switch (opcion){
                case 1:
                    //Llamo al metodo para dar de alta un estadio
                    altaEstadio();
                    break;
                case 2:
                    //Pido los datos del estadio a eliminar
                    System.out.println(" ");
                    System.out.println("Ingrese id del estadio a eliminar: ");
                    Integer idEstadio = ingresoInteger();
                    //Si el id ingresado es valido, llamo al metodo para eliminar el estadio
                    if (existeEstadio(idEstadio)) {
                        bajaEstadio(idEstadio);
                    } else {
                        //Si el id ingresado no es valido, imprimo un mensaje
                        System.out.println("No existe el estadio con id " + idEstadio);
                    }
                    break;
                case 3:
                    //Llamo al metodo para listar los estadios
                    System.out.println(" ");
                    listarEstadios();
                    break;
                case 4:
                    System.out.println("Volviendo...");
                    break;
            }
        } while (opcion != 4);
    }
    //Metodo para crear el submenu de gestion de jugadores
    public static void gestionJugadores(Integer idEquipo) {
        //Creo un bucle do-while para que el submenu se repita hasta que el usuario decida volver al menu principal
        Byte opcion = 0;
        do {
            //Creo un  ArrayList para guardar los jugadores del equipo seleccionado y lo completo con el metodo jugadoresPorEquipos
            ArrayList<Jugador> jugadoresEquipo = jugadoresPorEquipos(idEquipo);
            //Imprimo el submenu de gestion de jugadores
            System.out.println(" ");
            //Muestro la cantidad de jugadores que tiene el equipo
            System.out.println("El equipo tiene " + jugadoresEquipo.size() + " jugadores.");
            System.out.println(" ");
            System.out.println("1. Alta de Jugador.");
            System.out.println("2. Baja de Jugador.");
            System.out.println("3. Listar Jugadores.");
            System.out.println("4. Volver.");
            System.out.println(" ");
            System.out.print("Ingrese una opción: ");
            opcion = ingresoByte();
            //Creo un switch para la opcion elegida
            switch (opcion){
                case 1:
                    //Llamo al metodo para dar de alta un jugador y le paso el id del equipo
                    altaJugador(idEquipo);
                    break;
                case 2:
                    //Pido los datos del jugador a eliminar
                    System.out.println("Ingrese id del jugador a eliminar: ");
                    Integer idJugador = ingresoInteger();
                    //Llamamos al metodo para eliminar el jugador
                    bajaJugador(idJugador);
                    break;
                case 3:
                    //Listo los jugadores del equipo
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
    //Metodo para crear el submenu de gestion de partidos
    public static void iniciarPartido() {
        //Creo un bucle do-while para que el submenu se repita hasta que el usuario decida volver al menu principal
        Byte opcion = 0;
        do {
            System.out.println(" ");
            System.out.println("1. Iniciar Partido.");
            System.out.println("2. Volver.");
            System.out.println(" ");
            System.out.print("Ingrese una opción: ");
            opcion = ingresoByte();
            //Creo un switch para la opcion elegida
            switch (opcion){
                case 1:
                    //Pido los datos del partido a iniciar
                    System.out.println(" ");
                    System.out.println("Ingrese el id del equipo local: ");
                    Equipo equipoLocal = ingresoEquipo();
                    System.out.println("Ingrese el id del equipo visitante: ");
                    // verifico que el equipo local sea distinto al visitante
                    Equipo equipoVisitante = ingresoEquipo();
                    // verifico que el equipo local sea distinto al visitante
                    while (equipoLocal.getIdEquipo() == equipoVisitante.getIdEquipo()) {
                        //Si el equipo local es igual al visitante, imprimo un mensaje y vuelvo a pedir el equipo visitante
                        System.out.println("El equipo local no puede ser el mismo que el visitante.");
                        System.out.println("Ingrese el id del equipo visitante: ");
                        equipoVisitante = ingresoEquipo();
                    }
                    System.out.println("Ingrese la fecha del partido a iniciar: ");
                    //Utilizo el metodo ingresoFecha para pedir la fecha del partido
                    LocalDate fecha = ingresoFecha();
                    //Creo el string para el id del partido utilizando la fecha y los id de los equipos
                    String idPartido = fecha.toString() + "-" + equipoLocal.getIdEquipo() + "-" + equipoVisitante.getIdEquipo();
                    //Creo un objeto partido con los datos ingresados si no existe un partido de los mismos equipos en la misma fecha
                    if (!existePartido(idPartido)) {
                        //Llamo al metodo para dar de alta un partido y le paso los datos del partido
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
    //Metodo para dar de alta un equipo
    public static void altaEquipo() {
        //Pido los datos del equipo a crear
        System.out.println(" ");
        System.out.println("Ingreso de equipos.");
        System.out.println(" ");
        System.out.println("Ingrese el nombre del equipo: ");
        String nombre = teclado.nextLine();
        System.out.println("Ingrese la ciudad del equipo: ");
        String ciudad = teclado.nextLine();
        //Utilizo el metodo doyProximoIdEquipo para obtener el id del equipo
        Integer idEquipo = doyProximoIdEquipo();
        //Creo un objeto equipo con los datos ingresados
        Equipo equipo = new Equipo(idEquipo, nombre, ciudad);
        //utilizo el metodo escribirEquipo de la clase pEquipo para escribir el equipo en persistencia
        pEquipo.escribirEquipo(equipo);
        //Agrego el equipo al ArrayList de equipos
        equipos.add(equipo);
    }
    //Metodo para dar de alta un jugador
    public static void altaJugador(Integer idEquipo) {
        //Pido los datos del jugador a crear
        System.out.println(" ");
        System.out.println("Ingreso de Jugador.");
        System.out.println(" ");
        System.out.println("Ingrese el nombre del Jugador: ");
        String nombre = teclado.nextLine();
        System.out.println("Ingrese el apellido del Jugador: ");
        String apellido = teclado.nextLine();
        System.out.println("Ingrese el documento del Jugador: ");
        //Utilizo el metodo ingresoDocumento para pedir el documento del jugador
        Integer documento = ingresoDocumento();
        System.out.println("Ingrese la fecha de nacimiento del Jugador: ");
        //Utilizo el metodo ingresoFecha para pedir la fecha de nacimiento del jugador
        LocalDate fechaNacimiento = ingresoFecha();
        System.out.println("Ingrese el número de camiseta del Jugador: ");
        //Utilizo el metodo ingresoCamiseta para pedir el numero de camiseta del jugador
        Short numeroCamiseta = ingresoCamiseta(idEquipo);
        System.out.println("Ingrese la posición del Jugador: ");
        //Utilizo el metodo ingresoPuestoJugador para pedir la posicion del jugador
        String puesto = ingresoPuestoJugador();
        //Utilizo el metodo doyProximoIdJugador para obtener el id del jugador
        Integer idJugador = doyProximoIdJugador();
        //Creo un objeto jugador con los datos ingresados
        Jugador jugador = new Jugador(idJugador, nombre, apellido, documento, fechaNacimiento, numeroCamiseta, puesto, idEquipo);
        //utilizo el metodo escribirJugador de la clase pJugador para escribir el jugador en persistencia
        pJugador.escribirJugador(jugador);
        //Agrego el jugador al ArrayList de jugadores
        jugadores.add(jugador);
    }
    //Metodo para dar de alta un Director Técnico
    public static void altaDirectorTecnico(Integer idEquipo) {
        //Llamo al metodo bajaDirectorTecnicoPorEquipo() para dar de baja al director tecnico del equipo si existe
        bajaDirectorTecnicoPorEquipo(idEquipo);
        //Pido los datos del director tecnico a crear
        System.out.println(" ");
        System.out.println("Ingreso de Director Técnico.");
        System.out.println(" ");
        System.out.println("Ingrese el nombre del Director Técnico: ");
        String nombre = teclado.nextLine();
        System.out.println("Ingrese el apellido del Director Técnico: ");
        String apellido = teclado.nextLine();
        System.out.println("Ingrese el documento del Director Técnico: ");
        //Utilizo el metodo ingresoDocumento para pedir el documento del director tecnico
        Integer documento = ingresoDocumento();
        System.out.println("Ingrese la fecha de nacimiento del Director Técnico AAAA-MM-DD: ");
        //Utilizo el metodo ingresoFecha para pedir la fecha de nacimiento del director tecnico
        LocalDate fechaNacimiento = ingresoFecha();
        //Utilizo el metodo doyProximoIdDirectorTecnico para obtener el id del director tecnico
        Integer idDirectorTecnico = doyProximoIdDirectorTecnico();
        //Creo un objeto director tecnico con los datos ingresados
        DirectorTecnico directorTecnico = new DirectorTecnico(idDirectorTecnico, nombre, apellido, documento, fechaNacimiento, idEquipo);
        //Agrego el director tecnico al ArrayList de directores tecnicos
        directoresTecnicos.add(directorTecnico);
        //utilizo el metodo escribirDirectorTecnico de la clase pDirectorTecnico para escribir el director tecnico en persistencia
        pDirectorTecnico.escribirDirectorTecnico(directorTecnico);
        //utilizo el metodo cargoNuevaListaDirectorTecnico de la clase pDirectorTecnico para actualizar la lista de directores tecnicos en persistencia
        pDirectorTecnico.cargoNuevaListaDirectorTecnico(directoresTecnicos);
    }
    public static void altaArbitro() {
        //Pido los datos del arbitro a crear
        System.out.println(" ");
        System.out.println("Ingreso de Arbitro.");
        System.out.println(" ");
        System.out.println("Ingrese el nombre del Arbitro: ");
        String nombre = teclado.nextLine();
        System.out.println("Ingrese el apellido del Arbitro: ");
        String apellido = teclado.nextLine();
        System.out.println("Ingrese el documento del Arbitro: ");
        //Utilizo el metodo ingresoDocumento para pedir el documento del arbitro
        Integer documento = ingresoDocumento();
        System.out.println("Ingrese la fecha de nacimiento del Arbitro  AAAA-MM-DD: ");
        //Utilizo el metodo ingresoFecha para pedir la fecha de nacimiento del arbitro
        LocalDate fechaNacimiento = ingresoFecha();
        System.out.println("Ingrese el puesto del Arbitro: ");
        //Utilizo el metodo ingresoPuestoArbitro para pedir el puesto del arbitro
        String puesto = ingresoPuestoArbitro();
        //Utilizo el metodo doyProximoIdArbitro para obtener el id del arbitro
        Integer idArbitro = doyProximoIdArbitro();
        //Creo un objeto arbitro con los datos ingresados
        Arbitro arbitro = new Arbitro(idArbitro, nombre, apellido, documento, fechaNacimiento, puesto);
        //Agrego el arbitro al ArrayList de arbitros
        arbitros.add(arbitro);
        //utilizo el metodo escribirArbitro de la clase pArbitro para escribir el arbitro en persistencia
        pArbitro.escribirArbitro(arbitro);
    }
    //Metodo para dar de alta un Estadio
    public static void altaEstadio() {
        //Pido los datos del estadio a crear
        System.out.println(" ");
        System.out.println("Ingreso de Estadio.");
        System.out.println(" ");
        System.out.println("Ingrese el nombre del Estadio: ");
        String nombre = teclado.nextLine();
        System.out.println("Ingrese la ciudad del Estadio: ");
        String ciudad = teclado.nextLine();
        //Utilizo el metodo doyProximoIdEstadio para obtener el id del estadio
        Integer idEstadio = doyProximoIdEstadio();
        //Creo un objeto estadio con los datos ingresados
        Estadio estadio = new Estadio(idEstadio, nombre, ciudad);
        //Agrego el estadio al ArrayList de estadios
        estadios.add(estadio);
        //utilizo el metodo escribirEstadio de la clase pEstadio para escribir el estadio en persistencia
        pEstadio.escribirEstadio(estadio);
    }
    //Metodo para dar de alta un Partido
    public static void altaPartido(String idPartido, Equipo equipoLocal, Equipo equipoVisitante, LocalDate fechaPartido){
        System.out.println(" ");
        System.out.println("Ingrese la hora del partido en firma HH:MM: ");
        //Utilizo el metodo ingresoHora para pedir la hora del partido
        String horaPartido = ingresoHora();
        System.out.println("Ingrese el estadio del partido: ");
        //Utilizo el metodo ingresoEstadio para pedir el estadio del partido
        Estadio estadioPartido = ingresoEstadio();
        System.out.println("Ingrese el clima del partido: ");
        //Utilizo el metodo ingresoClima para pedir el clima del partido
        String climaPartido = ingresoClima();
        //Creo un ArrayList de arbitros para el partido
        ArrayList <Arbitro> arbitrosPartido = new ArrayList<>();
        System.out.println("Ingrese el arbitro principal del partido: ");
        //Utilizo el metodo ingresoArbitroPrincipal para pedir el arbitro principal del partido
        Arbitro arbitroPrincipal = ingresoArbitroPrincipal(arbitrosPartido);
        //Agrego el arbitro principal al ArrayList de arbitros del partido
        arbitrosPartido.add(arbitroPrincipal);
        System.out.println("Ingrese el primer linea del partido: ");
        //Utilizo el metodo ingresoArbitroAsistente para pedir el primer linea del partido
        Arbitro arbitroLinea1 = ingresoArbitroAsistente(arbitrosPartido);
        //Agrego el primer linea al ArrayList de arbitros del partido
        arbitrosPartido.add(arbitroLinea1);
        System.out.println("Ingrese el segundo linea del partido: ");
        //Utilizo el metodo ingresoArbitroAsistente para pedir el segundo linea del partido
        Arbitro arbitroLinea2 = ingresoArbitroAsistente(arbitrosPartido);
        //Agrego el segundo linea al ArrayList de arbitros del partido
        arbitrosPartido.add(arbitroLinea2);
        System.out.println("Ingrese el cuarto arbitro: ");
        //Utilizo el metodo ingresoArbitroPrincipal para pedir el cuarto arbitro del partido
        Arbitro cuartoArbitro = ingresoArbitroPrincipal(arbitrosPartido);
        //Agrego el cuarto arbitro al ArrayList de arbitros del partido
        arbitrosPartido.add(cuartoArbitro);
        System.out.println("Ingrese la formacion del equipo local: ");
        //Utilizo el metodo ingresoFormacion para pedir la formacion del equipo local
        String formacionInicialLocal = ingresoFormacion(equipoLocal);
        //muestro la formacion inicial del equipo local
        muestroFormacion(formacionInicialLocal);
        System.out.println("Ingrese la formacion del equipo visitante: ");
        //Utilizo el metodo ingresoFormacion para pedir la formacion del equipo visitante
        String formacionInicialVisitante = ingresoFormacion(equipoVisitante);
        //muestro la formacion inicial del equipo visitante
        muestroFormacion(formacionInicialVisitante);
        //Creo un objeto partido con los datos ingresados
        Partido partido = new Partido(idPartido, fechaPartido, horaPartido, climaPartido, equipoLocal.getIdEquipo(), equipoVisitante.getIdEquipo(), estadioPartido.getIdEstadio(), arbitroPrincipal.getIdArbitro(), arbitroLinea1.getIdArbitro(), arbitroLinea2.getIdArbitro(), cuartoArbitro.getIdArbitro(), formacionInicialLocal, formacionInicialVisitante);
        System.out.println("Ya esta todo pronto para comenzar el partido!");
        //Creo las variables para guardar los datos del partido
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
        //Entramos en un bucle para que el usuario pueda ingresar los datos del partido
        while (opcionPartido != 5) {
            System.out.println(" ");
            System.out.println("Que desea hacer?");
            System.out.println("1. Ingresar un gol del equipo local.");
            System.out.println("2. Ingresar un gol del equipo visitante.");
            System.out.println("3. Ingresar un cambio del equipo local.");
            System.out.println("4. Ingresar un cambio del equipo visitante.");
            System.out.println("5. Terminar el partido.");
            opcionPartido = ingresoByte();
            //Utilizo un switch para que el usuario pueda elegir que desea hacer
            switch (opcionPartido){
            case 1:
                //Utilizo el metodo ultimoMinutoGol para pedir el minuto del ultimo gol hasta el momento
                ultimoMinuto = ultimoMinutoGol(golesLocal, golesVisitante);
                //Utilizo el metodo ingresoGol para pedir el gol del equipo local y lo agrego al String de goles del equipo local
                golesLocal = ingresoGol(titularesLocal, golesLocal, ultimoMinuto);
                break;
            case 2:
                //Utilizo el metodo ultimoMinutoGol para pedir el minuto del ultimo gol hasta el momento
                ultimoMinuto = ultimoMinutoGol(golesLocal, golesVisitante);
                //Utilizo el metodo ingresoGol para pedir el gol del equipo visitante y lo agrego al String de goles del equipo visitante
                golesVisitante = ingresoGol(titularesVisitante, golesVisitante, ultimoMinuto);
                break;
            case 3:
                //Verifico que el equipo local no haya realizado los 3 cambios permitidos
                if (contadorCambiosLocal < 3) {
                    //Utilizo el metodo realizarCambio para hacer efectivo el cambio del equipo local
                    String cambio1 = realizoCambio(titularesLocal, suplentesLocal);
                    //Agrego el cambio al String de cambios del equipo local utilizando el String devuelto por el metodo realizarCambio
                    cambiosLocal = cambiosLocal + cambio1.split(" ")[0] + "#" + cambio1.split(" ")[1] + "-#-" ;
                    //Actualizo el Array titulatesLocal con el resultado del metodo realizoCambio enviando el String devuelto por el metodo realizarCambio los titulares y los suplentes con el tipo titulares
                    titularesLocal = realizoCambio(titularesLocal, suplentesLocal, cambio1, "titulares");
                    //Actualizo el Array suplentesLocal con el resultado del metodo realizoCambio enviando el String devuelto por el metodo realizarCambio los titulares y los suplentes con el tipo suplentes
                    suplentesLocal = realizoCambio(titularesLocal, suplentesLocal, cambio1, "suplentes");
                    //Aumento el contador de cambios del equipo local
                    contadorCambiosLocal++;
                } else {
                    System.out.println("Ya se realizaron los 3 cambios permitidos para el equipo local.");
                }
                break;
            case 4:
                //Verifico que el equipo visitante no haya realizado los 3 cambios permitidos
                if (contadorCambiosVisitante < 3) {
                    //Utilizo el metodo realizarCambio para hacer efectivo el cambio del equipo visitante
                    String cambio2 = realizoCambio(titularesVisitante, suplentesVisitante);
                    //Agrego el cambio al String de cambios del equipo visitante utilizando el String devuelto por el metodo realizarCambio
                    cambiosVisitante = cambiosVisitante + cambio2.split(" ")[0] + "#" + cambio2.split(" ")[1] + "-#-";
                    //Actualizo el Array titulatesVisitante con el resultado del metodo realizoCambio enviando el String devuelto por el metodo realizarCambio los titulares y los suplentes con el tipo titulares
                    titularesVisitante = realizoCambio(titularesVisitante, suplentesVisitante, cambio2, "titulares");
                    //Actualizo el Array suplentesVisitante con el resultado del metodo realizoCambio enviando el String devuelto por el metodo realizarCambio los titulares y los suplentes con el tipo suplentes
                    suplentesVisitante = realizoCambio(titularesVisitante, suplentesVisitante, cambio2, "suplentes");
                    //Aumento el contador de cambios del equipo visitante
                    contadorCambiosVisitante++;
                } else {
                    System.out.println("Ya se realizaron los 3 cambios permitidos para el equipo visitante.");
                }
                break;
            case 5:
                //Comienzo a cerrar el partido
                System.out.println("El partido ha finalizado.");
                //Cargo los goles del local al partido
                partido.setGolesLocal(golesLocal);
                //Cargo los goles del visitante al partido
                partido.setGolesVisitante(golesVisitante);
                //Cargo los cambios del local al partido
                partido.setCambiosLocal(cambiosLocal);
                //Cargo los cambios del visitante al partido
                partido.setCambiosVisitante(cambiosVisitante);
                //Cargo la formacion final del local al partido
                partido.setFormacionFinalLocal(pasoDeArrayAString(titularesLocal));
                //Cargo la formacion final del visitante al partido
                partido.setFormacionFinalVisitante(pasoDeArrayAString(titularesVisitante));
                //Utilizo el metodo ultimoMinutoGol para pedir el minuto del ultimo gol hasta el momento
                ultimoMinuto = ultimoMinutoGol(golesLocal, golesVisitante);
                System.out.println("Ingrese la duracion del partido en minutos: ");
                //Utilizo el metodo ingresoInteger para pedir la duracion del partido
                Integer duracionPartido = ingresoInteger();
                //Verifico que la duracion del partido sea mayor al ultimo gol
                while (duracionPartido < ultimoMinuto) {
                    //Si no es mayor, pido nuevamente la duracion del partido
                    System.out.println("La duracion del partido no puede ser menor al ultimo minuto en el que se anoto un gol.");
                    System.out.println("Ingrese la duracion del partido en minutos: ");
                    duracionPartido = ingresoInteger();
                }
                //Cargo la duracion del partido al partido
                partido.setDuracion(duracionPartido);
                //Agrego el partido a la lista de partidos
                partidos.add(partido);
                //Utilizo el metodo escriboPartido de la clase pPartido para escribir el partido en persistencia
                pPartido.escriboPartido(partido);
                break;
            }
        }
    }

    //Metodos para eliminar los objetos
    public static void bajaEquipo() {
        //Pido los datos del equipo a eliminar
        System.out.println(" ");
        System.out.println("Baja de equipos.");
        System.out.println(" ");
        System.out.println("Ingrese el id del equipo a dar de baja: ");

        Integer idEquipo = 0;
        //Utilizo el metodo ingresoInteger para pedir el id del equipo a eliminar
        idEquipo = ingresoInteger();
        //Verifico que el id del equipo a eliminar exista utilizando el metodo existeEquipo
        if (existeEquipo(idEquipo)) {
            //Recorro la lista de equipos
            for (Equipo equipo : equipos) {
                //Verifico que el id del equipo a eliminar sea igual al id del equipo de la lista
                if (equipo.getIdEquipo() == idEquipo) {
                    //Elimino el equipo de la lista
                    equipos.remove(equipo);
                    break;
                }
            }
            //Utilizo el metodo cargoNuevaListaEquipo de la clase pEquipo para escribir la lista de equipos en persistencia
            pEquipo.cargoNuevaListaEquipo(equipos);
            //Elimino los jugadores que pertenecian al equipo eliminado
            for (int i = jugadores.size() - 1; i >= 0; i--) {
                if (jugadores.get(i).getIdEquipo() == idEquipo) {
                    jugadores.remove(i);
                }
            }
            //Utilizo el metodo cargoNuevaListaJugador de la clase pJugador para escribir la lista de jugadores en persistencia
            pJugador.cargoNuevaListaJugador(jugadores);
            //Elimino el director tecnico que pertenecia al equipo eliminado
            for (int i = directoresTecnicos.size() - 1; i >= 0; i--) {
                if (directoresTecnicos.get(i).getIdEquipo() == idEquipo) {
                    directoresTecnicos.remove(i);
                }
            }
            //Utilizo el metodo cargoNuevaListaDirectorTecnico de la clase pDirectorTecnico para escribir la lista de directores tecnicos en persistencia
            pDirectorTecnico.cargoNuevaListaDirectorTecnico(directoresTecnicos);
            System.out.println("Equipo eliminado.");
        } else {
            System.out.println("El id ingresado no existe.");
        }


    }
    //Metodo para eliminar un jugador de la lista de jugadores recibiendo el id del jugador a eliminar
    public static void bajaJugador(Integer idJugador) {
        //Recorro la lista de jugadores
        for (int i = 0; i < jugadores.size(); i++) {
            //Verifico que el id del jugador a eliminar sea igual al id del jugador de la lista
            if (jugadores.get(i).getIdJugador() == idJugador) {
                //Elimino el jugador de la lista
                jugadores.remove(i);
                //Utilizo el metodo cargoNuevaListaJugador de la clase pJugador para escribir la lista de jugadores en persistencia
                pJugador.cargoNuevaListaJugador(jugadores);
            }
        }
    }
    //Metodo para eliminar un director tecnico de la lista de directores tecnicos recibiendo el id del equipo del director tecnico a eliminar
    public static void bajaDirectorTecnicoPorEquipo(Integer idEquipo) {
        //Recorro la lista de directores tecnicos
        for (int i = 0; i < directoresTecnicos.size(); i++) {
            //Verifico que el id del equipo del director tecnico a eliminar sea igual al id del equipo del director tecnico de la lista
            if (directoresTecnicos.get(i).getIdEquipo() == idEquipo) {
                //Elimino el director tecnico de la lista
                directoresTecnicos.remove(i);
                //Utilizo el metodo cargoNuevaListaDirectorTecnico de la clase pDirectorTecnico para escribir la lista de directores tecnicos en persistencia
                pDirectorTecnico.cargoNuevaListaDirectorTecnico(directoresTecnicos);
            }
        }
    }
    //Metodo para eliminar un arbitro de la lista de arbotrps recibiendo el id del arbitro a eliminar
    public static void bajaArbitro(Integer idArbitro) {
        //Recorro la lista de arbitros
        for (int i = 0; i < arbitros.size(); i++) {
            //Verifico que el id del arbitro a eliminar sea igual al id del arbitro de la lista
            if (arbitros.get(i).getIdArbitro() == idArbitro) {
                //Elimino el arbitro de la lista
                arbitros.remove(i);
                //Utilizo el metodo cargoNuevaListaArbitro de la clase pArbitro para escribir la lista de arbitros en persistencia
                pArbitro.cargoNuevaListaArbitro(arbitros);
            }
        }
    }
    //Metodo para eliminar un estadio de la lista de estadios recibiendo el id del estadio a eliminar
    public static void bajaEstadio(Integer idEstadio) {
        //Recorro la lista de estadios
        for (int i = 0; i < estadios.size(); i++) {
            //Verifico que el id del estadio a eliminar sea igual al id del estadio de la lista
            if (estadios.get(i).getIdEstadio() == idEstadio) {
                //Elimino el estadio de la lista
                estadios.remove(i);
                //Utilizo el metodo cargoNuevaListaEstadio de la clase pEstadio para escribir la lista de estadios en persistencia
                pEstadio.cargoNuevaListaEstadio(estadios);
            }
        }
    }

    //Metodos para ingresar los datos por teclado
    //Metodo para ingresar un documento por teclado
    public static Integer ingresoDocumento() {
        //Declaro una variable para almacenar el documento ingresado por teclado
        Integer numeroValido = 0;
        //Declaro una variable para validar que el documento ingresado sea correcto
        Boolean validado = false;
        //Mientras el documento no sea valido
        do {
            //Control de excepciones para verificar que el documento ingresado sea un numero
            try {
                //Pido el documento por teclado y lo almaceno en la variable numeroValido utilizando el metodo parseInt de la clase Integer para convertir el String en un Integer
                //Si no se puede convertir el String en un Integer se lanza una excepcion
                numeroValido = Integer.parseInt(teclado.nextLine());
                //verifico que el numero ingresado tenga 8 digitos y no comience con 0
                if (numeroValido.toString().length() == 8 && numeroValido.toString().charAt(0) != '0') {
                    //Verifico que el documento no exista en otra persona utilizando el metodo existeDocumento
                    if (!existeDocumento(numeroValido)) {
                        //Si el documento no existe en otra persona valido el documento
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
        //Retorno el documento ingresado por teclado
        return numeroValido;
    }
    //Metodo para ingresar una fecha por teclado
    public static LocalDate ingresoFecha() {
        //Declaro una variable para almacenar la fecha ingresada por teclado
        LocalDate fecha = null;
        //Declaro una variable para validar que la fecha ingresada sea correcta
        Boolean fechaValida = false;
        //Mientras la fecha no sea valida
        do {
            //Control de excepciones para verificar que la fecha ingresada sea correcta
            try {
                //Pido la fecha por teclado y la almaceno en la variable fecha utilizando el metodo parse de la clase LocalDate para convertir el String en un LocalDate
                //Si no se puede convertir el String en un LocalDate se lanza una excepcion
                fecha = LocalDate.parse(teclado.nextLine());
                //Pasp a trur la variable fechaValida
                fechaValida = true;
            } catch (DateTimeParseException e) {
                //Si se lanza una excepcion muestro un mensaje de error con el formato de fecha correcto
                System.out.println("Fecha invalida. Formato esperado AAAA-MM-DD Ingrese nuevamente: ");
            }
        } while (!fechaValida);
        //Retorno la fecha ingresada por teclado
        return fecha;
    }
    //Metodo para ingresar un Short por teclado
    public static Short ingresoShort() {
        //Declaro una variable para almacenar el numero ingresado por teclado
        Short numeroValido = 0;
        //Declaro una variable para validar que el numero ingresado sea correcto
        Boolean validado = false;
        //Mientras el numero no sea valido
        do {
            //Control de excepciones para verificar que el numero ingresado sea un numero
            try {
                //Pido el numero por teclado y lo almaceno en la variable numeroValido utilizando el metodo parseShort de la clase Short para convertir el String en un Short
                //Si no se puede convertir el String en un Short se lanza una excepcion
                numeroValido = Short.parseShort(teclado.nextLine());
                //Paso a true la variable validado
                validado = true;
            } catch (NumberFormatException e) {
                //Si se lanza una excepcion muestro un mensaje de error
                System.out.println("Debe ser numérico menor a 32767. Ingrese nuevamente: ");
            }
        } while (!validado);
        //Retorno el numero ingresado por teclado
        return numeroValido;
    }
    //Metodo para ingresar un numero de camiseta por teclado recibiendo el equipo al que pertenece el jugador
    public static Short ingresoCamiseta(Integer idEquipo){
        //Declaro una variable para almacenar el numero de camiseta ingresado por teclado
        Short numeroValido = 0;
        //Declaro una variable para validar que el numero de camiseta ingresado sea correcto
        Boolean validado = false;
        //Mientras el numero de camiseta no sea valido
        do {
            //Control de excepciones para verificar que el numero de camiseta ingresado sea un numero
            try {
                //Pido el numero de camiseta por teclado y lo almaceno en la variable numeroValido utilizando el metodo ingresoShort
                numeroValido = ingresoShort();
                //Verifico que el numero de camiseta este entre 1 y 99
                if (numeroValido > 0 && numeroValido < 100) {
                    //Verifico que el numero de camiseta no exista en otro jugador del mismo equipo utilizando el metodo numeroCamisetaEnEquipo
                    if (!numeroCamisetaEnEquipo(numeroValido, idEquipo)) {
                        //Si el numero de camiseta no existe en otro jugador del mismo equipo valido el numero de camiseta
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
        //Retorno el numero de camiseta ingresado por teclado
        return numeroValido;
    }
    //Metodo para ingresar un Integer por teclado
    public static Integer ingresoInteger() {
        //Declaro una variable para almacenar el numero ingresado por teclado
        Integer numeroValido = 0;
        //Declaro una variable para validar que el numero ingresado sea correcto
        Boolean validado = false;
        //Mientras el numero no sea valido
        do {
            //Control de excepciones para verificar que el numero ingresado sea un numero
            try {
                //Pido el numero por teclado y lo almaceno en la variable numeroValido utilizando el metodo parseInt de la clase Integer para convertir el String en un Integer
                //Si no se puede convertir el String en un Short se lanza una excepcion
                numeroValido = Integer.parseInt(teclado.nextLine());
                //Paso a true la variable validado
                validado = true;
            } catch (NumberFormatException e) {
                System.out.println("Debe ser numérico menor a 2147483647. Ingrese nuevamente: ");
            }
        } while (!validado);
        //Retorno el numero ingresado por teclado
        return numeroValido;
    }
    //Metodo para ingresar un Boolean por teclado
    public static Byte ingresoByte() {
        //Declaro una variable para almacenar el numero ingresado por teclado
        Byte numeroValido = 0;
        //Declaro una variable para validar que el numero ingresado sea correcto
        Boolean validado = false;
        //Mientras el numero no sea valido
        do {
            //Control de excepciones para verificar que el numero ingresado sea un numero
            try {
                //Pido el numero por teclado y lo almaceno en la variable numeroValido utilizando el metodo parseByte de la clase Byte para convertir el String en un Byte
                numeroValido = Byte.parseByte(teclado.nextLine());
                //Paso a true la variable validado
                validado = true;
            } catch (NumberFormatException e) {
                System.out.println("Debe ser numérico menor a 127. Ingrese nuevamente: ");
            }
        } while (!validado);
        //Retorno el numero ingresado por teclado
        return numeroValido;
    }
    //Metodo para ingresar un Character por teclado
    public static Character ingresoChar() {
        //Declaro una variable para almacenar el caracter ingresado por teclado
        Character caracterValido = null;
        //Declaro una variable para validar que el caracter ingresado sea correcto
        Boolean validado = false;
        //Mientras el caracter no sea valido
        do {
            //Control de excepciones para verificar que el caracter ingresado sea un caracter
            try {
                //Pido el caracter por teclado y lo almaceno en la variable caracterValido utilizando el metodo charAt para obtener el primer caracter del String ingresado por teclado
                //Si no se puede obtener el primer caracter del String en forma de Character se lanza una excepcion
                caracterValido = teclado.nextLine().charAt(0);
                //Paso a true la variable validado
                validado = true;
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Debe ingresar un caracter. Ingrese nuevamente: ");
            }
        } while (!validado);
        //Retorno el caracter ingresado por teclado
        return caracterValido;
    }
    //Metodo para ingresar un la hora por teclado
    public static String ingresoHora() {
        //Declaro una variable para almacenar la hora ingresada por teclado
        String horaValida = "";
        //Declaro una variable para validar que la hora ingresada sea correcta
        Boolean validado = false;
        //Mientras la hora no sea valida
        do {
            //Control de excepciones para verificar que la hora ingresada sea correcta
            try {
                //Pido la hora por teclado y la almaceno en la variable horaValida
                horaValida = teclado.nextLine();
                //Verifico que la hora ingresada tenga el formato correcto
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
        //Declaro una variable para almacenar el puesto ingresado por teclado
        String puesto = teclado.nextLine();
        //Declaro una variable para validar que el puesto ingresado sea correcto
        Boolean puestoValido = false;
        //Mientras el puesto no sea valido
        do {
            //Verifico que el puesto ingresado sea correcto
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
        //Declaro una variable para almacenar el puesto ingresado por teclado
        String puesto = teclado.nextLine();
        //Declaro una variable para validar que el puesto ingresado sea correcto
        Boolean puestoValido = false;
        //Mientras el puesto no sea valido
        do {
            //Verifico que el puesto ingresado sea correcto
            if (puesto.equals("arbitro") || puesto.equals("asistente") ) {
                //Paso a true la variable puestoValido
                puestoValido = true;
            } else {
                System.out.println("Puesto invalido. \nLos puestos validos son: arbitro y asistente. \nIngrese nuevamente: ");
                puesto = teclado.nextLine();
            }
        } while (!puestoValido);
        return puesto;
    }
    public static Equipo ingresoEquipo() {
        //Declaro una variable para almacenar el equipo ingresado por teclado
        Equipo equipo = null;
        //Variable utilizada para validar que sea numero
        Integer numeroValido = 0;
        //Declaro una variable para validar que el equipo ingresado sea correcto
        Boolean validado = false;
        //String utilizado para almacenar lo ingresado por teclado
        String textoEntrada = "";
        //Mientras el equipo no sea valido
        do {
            //Control de excepciones para verificar que el equipo ingresado sea correcto
            try {
                //Pido el equipo por teclado y lo almaceno en la variable textoEntrada
                textoEntrada = teclado.nextLine();
                //Si el usuario ingresa el texto "list"
                if (textoEntrada.equals("list")){
                    //Muestro la lista de equipos
                    listarEquipos();
                } else {
                    //Verifico que el equipo ingresado sea un numero
                    numeroValido = Integer.parseInt(textoEntrada);
                    //Verifico que el equipo ingresado exista
                    if (existeEquipo(numeroValido)) {
                        //Si el equipo esta completo
                        if (equipoCompleto(numeroValido)) {
                            //Igualo el equipo al retorno de la funcion doyEquipoPorId
                            equipo = doyEquipoPorId(numeroValido);
                            //Paso a true la variable validado
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
        //Retorno el equipo
        return equipo;
    }
    public static String ingresoClima(){
        //Declaro una variable para almacenar el clima ingresado por teclado
        String clima = teclado.nextLine();
        //Declaro una variable para validar que el clima ingresado sea correcto
        Boolean climaValido = false;
        //Mientras el clima no sea valido
        do {
            //Verifico que el clima ingresado sea correcto
            if (clima.equals("soleado") || clima.equals("nublado") || clima.equals("lluvioso")) {
                //Paso a true la variable climaValido
                climaValido = true;
            } else {
                System.out.println("Clima invalido. \nLos climas validos son: soleado, nublado, lluvioso. \nIngrese nuevamente: ");
                clima = teclado.nextLine();
            }
        } while (!climaValido);
        return clima;
    }
    public static Estadio ingresoEstadio() {
        //Declaro una variable para almacenar el estadio ingresado por teclado
        Estadio estadio = null;
        //Variable utilizada para validar que sea numero
        Integer numeroValido = 0;
        //Declaro una variable para validar que el estadio ingresado sea correcto
        Boolean validado = false;
        //String utilizado para almacenar lo ingresado por teclado
        String textoEntrada = "";
        //Mientras el estadio no sea valido
        do {
            //Control de excepciones para verificar que el estadio ingresado sea correcto
            try {
                //Pido el estadio por teclado y lo almaceno en la variable textoEntrada
                textoEntrada = teclado.nextLine();
                //Si el usuario ingresa el texto "list"
                if (textoEntrada.equals("list")){
                    //Muestro la lista de estadios
                    listarEstadios();
                } else {
                    //Verifico que el estadio ingresado sea un numero
                    numeroValido = Integer.parseInt(textoEntrada);
                    //Verifico que el estadio ingresado exista utilizando la funcion existeEstadio
                    if (existeEstadio(numeroValido)) {
                        //Igualo el estadio al retorno de la funcion doyEstadioPorId
                        estadio = doyEstadioPorId(numeroValido);
                        //Paso a true la variable validado
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
        //Declaro una variable para almacenar el arbitro ingresado por teclado
        Arbitro arbitro = null;
        //Variable utilizada para validar que sea numero
        Integer numeroValido = 0;
        //Declaro una variable para validar que el arbitro ingresado sea correcto
        Boolean validado = false;
        //String utilizado para almacenar lo ingresado por teclado
        String textoEntrada = "";
        //Mientras el arbitro no sea valido
        do {
            //Control de excepciones para verificar que el arbitro ingresado sea correcto
            try {
                //Pido el arbitro por teclado y lo almaceno en la variable textoEntrada
                textoEntrada = teclado.nextLine();
                //Si el usuario ingresa el texto "list"
                if (textoEntrada.equals("list")){
                    //Muestro la lista de arbitros
                    listarArbitros();
                } else {
                    //Verifico que el arbitro ingresado sea un numero
                    numeroValido = Integer.parseInt(textoEntrada);
                    //Verifico que el arbitro ingresado no este en la lista de arbitros recibida por parametro
                    if (existeArbitro(numeroValido, arbitros)) {
                        System.out.println("El arbitro ingresado ya esta asignado en este partido. Ingrese nuevamente: ");
                    } else {
                        //Verifico que el arbitro ingresado exista utilizando la funcion existeArbitro
                        if (existeArbitro(numeroValido)) {
                            //Igualo el arbitro al retorno de la funcion doyArbitroPorId
                            arbitro = doyArbitroPorId(numeroValido);
                            //Si el tipo de arbitro es arbitro
                            if (arbitro.getPuesto().equals("arbitro")) {
                                //Paso a true la variable validado
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
        //Retorno el arbitro
        return arbitro;
    }
    public static Arbitro ingresoArbitroAsistente(ArrayList<Arbitro> arbitros) {
        //Declaro una variable para almacenar el arbitro ingresado por teclado
        Arbitro arbitro = null;
        //Variable utilizada para validar que sea numero
        Integer numeroValido = 0;
        //Declaro una variable para validar que el arbitro ingresado sea correcto
        Boolean validado = false;
        //String utilizado para almacenar lo ingresado por teclado
        String textoEntrada = "";
        //Mientras el arbitro no sea valido
        do {
            //Control de excepciones para verificar que el arbitro ingresado sea correcto
            try {
                //Pido el arbitro por teclado y lo almaceno en la variable textoEntrada
                textoEntrada = teclado.nextLine();
                //Si el usuario ingresa el texto "list"
                if (textoEntrada.equals("list")){
                    //Muestro la lista de arbitros
                    listarArbitros();
                } else {
                    //Verifico que el arbitro ingresado sea un numero
                    numeroValido = Integer.parseInt(textoEntrada);
                    //Verifico que el arbitro ingresado no este en la lista de arbitros recibida por parametro
                    if (existeArbitro(numeroValido, arbitros)) {
                        System.out.println("El arbitro ingresado ya esta asignado en este partido. Ingrese nuevamente: ");
                    } else {
                        //Verifico que el arbitro ingresado exista utilizando la funcion existeArbitro
                        if (existeArbitro(numeroValido)) {
                            //Igualo el arbitro al retorno de la funcion doyArbitroPorId
                            arbitro = doyArbitroPorId(numeroValido);
                            //Si el tipo de arbitro es asistente
                            if (arbitro.getPuesto().equals("asistente")) {
                                //Paso a true la variable validado
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
        //Retorno el arbitro
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
        //Retorno la formacion
        return formacionString;
    }
    public static String ingresoGol(ArrayList<Jugador> jugadores, String anterior, Short ultimoMinutoGol) {
        //Declaro la variable para almacenar el gol ingresado por teclado y la igualo a la variable anterior que recibo por parametro y contiene los goles hasta el momento
        String gol = anterior;
        //Declaro una variable que utilizare para validar que el gol ingresado sea correcto
        Boolean validado = false;
        //Declaro una variable auxiliar para la validacion
        String textoEntrada = "";
        //Mientras el gol no sea valido
        do {
            //Pido el nombre del jugador que hizo el gol
            System.out.println("Ingrese el numero de camiseta del jugador que hizo el gol: ");
            textoEntrada = teclado.nextLine();
            //Si el usuario ingresa el texto "list"
            if (textoEntrada.equals("list")){
                //Muestro la lista de jugadores del equipo y vuelvo a pedir el jugador que hizo el gol
                for (Jugador jugador : jugadores) {
                    System.out.println(jugador.getNumeroCamiseta() + " - " + jugador.getNombre() + " " + jugador.getApellido());
                }
            } else {
                //Control de excepciones para verificar que el gol ingresado sea numerico
                try {
                    //Verifico que el gol ingresado sea un Short
                    //Si no es un Short salta una excepcion
                    Short numero = Short.parseShort(textoEntrada);
                    //Verifico que el jugador este en la lista de jugadores
                    if (existeJugador(numero, jugadores)){
                        System.out.println("Ingrese el minuto en el que hizo el gol: ");
                        //Pido el minuto en el que hizo el gol
                        Short minuto = ingresoShort();
                        //Verifico que el minuto ingresado sea mayor al minuto del ultimo gol ingresado
                        while (minuto <= ultimoMinutoGol) {
                            System.out.println("El minuto ingresado debe ser mayor al ultimo gol. Ingrese nuevamente: ");
                            minuto = ingresoShort();
                        }
                        //Agrego el numero de camiseta del jugador que hizo el gol y el minuto en el que lo hizo al string gol
                        gol += numero + "#" + minuto + "-#-";
                        //Paso a true la variable validado
                        validado = true;
                    } else {
                        System.out.println("El jugador no pertenece al equipo. Ingrese nuevamente: ");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Debe ser numérico. Ingrese nuevamente: ");
                }
            }
        } while (!validado);
        //Retorno el gol
        return gol;
    }


    //Metodos doyProximoId Retorna el id del objeto que se encuentra ultimo en la lista para utilizarlos como id del proximo objeto que se agregue a la lista
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

    //Metodos Existe Retorna true si el objeto existe en la lista y false si no existe en algunos casos reciben la lista donde se busca.
    //En el caso de existeArbitro se utiliza polimorfismo ya que puede recibir solo el id del arbitro o el id del arbitro y la lista donde buscar
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
    public static Boolean existeEquipo(Integer idEquipo) {
        Boolean existe = false;
        for (Equipo equipo : equipos) {
            if (equipo.getIdEquipo() == idEquipo) {
                existe = true;
            }
        }
        return existe;
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

    //Metodos que devuelven objetos recibiendo el id del objeto que se desea obtener tambien se puede recibir el id del equipo en el que hay que buscar
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
            //Muestro completo o incompleto dependiendo el resultado de la funcion equipoCompleto
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
            //Muestro solo los jugadores del equipo que se pasa por parametro
            if (jugador.getIdEquipo() == idEquipo) {
                System.out.println(jugador);
            }
        }
    }
    public static void muestroFormacion(String formacion) {
        //Se utiliza un ASCII ART para mostrar la formacion dependiendo de cuantos jugadores tenga la formacion que se pasa por parametro
        //Paso la formacion a un array de String
        String[] jugadores = formacion.split(" ");
        //Si la formacion tiene 11 jugadores es la formacion final por lo que no se muestran los suplentes
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
            //Si la formacion no tiene 11 jugadores es la formacion inicial por lo que se muestran los suplentes
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
