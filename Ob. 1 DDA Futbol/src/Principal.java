import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    static Scanner teclado = new Scanner(System.in);
    static ArrayList<Equipo> equipos = new ArrayList<Equipo>();
    static ArrayList<DirectorTecnico> directoresTecnicos = new ArrayList<DirectorTecnico>();
    static ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    static ArrayList<Arbitro> arbitros = new ArrayList<Arbitro>();
    static ArrayList<Estadio> estadios = new ArrayList<Estadio>();

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
                case 6:
                    System.out.println("Gracias por utilizar el programa.");
                    break;
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
    }
    public static void leerArchivos() {
        equipos = pEquipo.leerEquipos();
        directoresTecnicos = pDirectorTecnico.leerDirectoresTecnicos();
        jugadores = pJugador.leerJugadores();
        arbitros = pArbitro.leerArbitros();
        estadios = pEstadio.leerEstadios();
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
                    for (Arbitro unArbitro : arbitros) {
                        System.out.println(unArbitro);
                    }
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
                    for (Estadio unEstadio : estadios) {
                        System.out.println(unEstadio);
                    }
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
            System.out.println("3 Listar Jugadores.");
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
        Short numeroCamiseta = ingresoShort();
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
    public static String ingresoPuestoJugador() {
        String puesto = teclado.nextLine();
        Boolean puestoValido = false;
        do {
            if (puesto.equalsIgnoreCase("arquero") || puesto.equalsIgnoreCase("defensor") || puesto.equalsIgnoreCase("mediocampista") || puesto.equalsIgnoreCase("delantero")) {
                puestoValido = true;
            } else {
                System.out.println("Puesto invalido. \nLos puestos validos son: arquero, defensor, mediocampista, delantero. \nIngrese nuevamente: ");
                puesto = teclado.nextLine();
            }
        } while (!puestoValido);
        return puesto;
    }
    public static String ingresoPuestoArbitro() {
        String puesto = teclado.nextLine();
        Boolean puestoValido = false;
        do {
            if (puesto.equalsIgnoreCase("arbitro") || puesto.equalsIgnoreCase("asistente") ) {
                puestoValido = true;
            } else {
                System.out.println("Puesto invalido. \nLos puestos validos son: Arbitro y Asistente. \nIngrese nuevamente: ");
                puesto = teclado.nextLine();
            }
        } while (!puestoValido);
        return puesto;
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
    //Metodos para listar
    public static void listarEquipos() {
        for (Equipo equipo : equipos) {
            System.out.println(equipo + " " + (equipoCompleto(equipo.getIdEquipo())? "Completo" : "Incompleto"));
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
    //Metodos de Partidos
    public static void iniciarPartido() {
        System.out.println(" ");
        System.out.println("Ingreso de Partido.");
        System.out.println(" ");
    }
    public static Boolean equipoCompleto(Integer idEquipo) {
        Boolean completo = false;
        ArrayList<Jugador> jugadores = jugadoresPorEquipos(idEquipo);
        DirectorTecnico directorTecnico = doyDirectorTecnicoPorEquipo(idEquipo);
        if (jugadores.size() == 16 && directorTecnico != null) {
            completo = true;
        }
        return completo;
    }


}
