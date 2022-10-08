import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class pPartido {
    public static boolean crearArchivo() {
        boolean resultado = false;
        File archivo = null;
        FileWriter escribir = null;
        try {
            archivo = new File("Partido.txt");
            if (archivo.exists()) {
                resultado = false;
            } else {
                escribir = new FileWriter(archivo);
                resultado = true;
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
        return resultado;
    }
    public static void escriboPartido (Partido unPartido) {
        String texto = unPartido.getIdPartido() + "@" + unPartido.getFecha() + "@" + unPartido.getHora() + "@" + unPartido.getClima() + "@" + unPartido.getIdEquipoLocal() + "@" + unPartido.getIdEquipoVisitante() + "@" + unPartido.getIdEstadio() + "@" + unPartido.getIdArbitroPrincipal() + "@" + unPartido.getIdLinea1() + "@" + unPartido.getIdLinea2() + "@" + unPartido.getIdCuartoArbitro() + "@" + unPartido.getFormacionInicialLocal() + "@" + unPartido.getFormacionInicialVisitante() + "@" + unPartido.getFormacionFinalLocal() + "@" + unPartido.getFormacionFinalVisitante() + "@" + unPartido.getGolesLocal() + "@" + unPartido.getGolesVisitante() + "@" + unPartido.getCambiosLocal() + "@" + unPartido.getCambiosVisitante() + "@" + unPartido.getDuracion();
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("Partido.txt", true);
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
    public static void cargoNuevaListaPartido(ArrayList<Partido> partidos) {
        //Elimino el archivo
        File archivo = new File("Partido.txt");
        archivo.delete();
        //Creo el archivo
        crearArchivo();
        //Cargo la lista
        for (int i = 0; i < partidos.size(); i++) {
            escriboPartido(partidos.get(i));
        }
    }
    public static ArrayList<Partido> leerPartidos(){
        ArrayList<Partido> partidos = new ArrayList<Partido>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            archivo = new File("Partido.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("@");
                Partido unPartido = new Partido(datos[0], LocalDate.parse(datos[1]), datos[2], datos[3], Integer.parseInt(datos[19]), Integer.parseInt(datos[4]), Integer.parseInt(datos[5]), Integer.parseInt(datos[6]), Integer.parseInt(datos[7]), Integer.parseInt(datos[8]), Integer.parseInt(datos[9]), Integer.parseInt(datos[10]), datos[11], datos[12], datos[13], datos[14], datos[15], datos[16], datos[17], datos[18]);
                partidos.add(unPartido);
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
        return partidos;
    }
}
