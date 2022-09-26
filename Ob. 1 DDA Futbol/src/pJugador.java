import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class pJugador {
    public static void crearArchivo() {
        File archivo = null;
        FileWriter escribir = null;
        try {
            archivo = new File("Jugador.txt");
            if (archivo.exists()) {

            } else {
                escribir = new FileWriter(archivo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != escribir)
                    escribir.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    public static void escribirJugador (Jugador unJugador) {
        String texto = unJugador.getIdJugador() + "@" + unJugador.getNombre() + "@" + unJugador.getApellido() + "@" + unJugador.getDocumento() + "@" + unJugador.getFechaNacimiento() + "@" + unJugador.getNumeroCamiseta() + "@" + unJugador.getPuesto() + "@" + unJugador.getIdEquipo();
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("Jugador.txt", true);
            pw = new PrintWriter(fichero);
            pw.println(texto);
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
    }
    public static void cargoNuevaListaJugador(ArrayList<Jugador> jugadores) {
        //Elimino el archivo
        File archivo = new File("Jugador.txt");
        archivo.delete();
        //Creo el archivo
        crearArchivo();
        //Cargo la lista
        for (int i = 0; i < jugadores.size(); i++) {
            escribirJugador(jugadores.get(i));
        }
    }
    public static ArrayList<Jugador> leerJugadores(){
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            archivo = new File("Jugador.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("@");
                Jugador unJugador = new Jugador(Integer.parseInt(datos[0]), datos[1], datos[2], Integer.parseInt(datos[3]), LocalDate.parse(datos[4]), Short.parseShort(datos[5]), datos[6], Integer.parseInt(datos[7]));
                jugadores.add(unJugador);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return jugadores;
    }
    public static Jugador pasoDeStringAJugador(String unJugador) {
        String[] datos = unJugador.split("@");
        Jugador jugador = new Jugador(Integer.parseInt(datos[0]), datos[1], datos[2], Integer.parseInt(datos[3]), LocalDate.parse(datos[4]), Short.parseShort(datos[5]), datos[6], Integer.parseInt(datos[7]));
        return jugador;
    }
}
