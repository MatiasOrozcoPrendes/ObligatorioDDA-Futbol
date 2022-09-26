import java.io.*;
import java.util.ArrayList;

public class pEstadio {
    public static void crearArchivo(){
        File archivo = null;
        FileWriter escribir = null;
        try {
            archivo = new File("Estadio.txt");
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
    public static void escribirEstadio (Estadio unEstadio){
        String texto = unEstadio.getIdEstadio() + "@" + unEstadio.getNombre() + "@" + unEstadio.getCiudad();
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("Estadio.txt", true);
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
    public static void cargoNuevaListaEstadio(ArrayList<Estadio> estadios){
        //Elimino el archivo
        File archivo = new File("Estadio.txt");
        archivo.delete();
        //Creo el archivo
        crearArchivo();
        //Cargo la lista
        for (int i = 0; i < estadios.size(); i++) {
            escribirEstadio((Estadio) estadios.get(i));
        }
    }
    public static ArrayList<Estadio> leerEstadios(){
        ArrayList<Estadio> estadios = new ArrayList<Estadio>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            archivo = new File("Estadio.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                estadios.add(pasoDeStringAEstadio(linea));
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
        return estadios;
    }
    public static Estadio pasoDeStringAEstadio(String unEstadio){
        String[] datos = unEstadio.split("@");
        Estadio estadio = new Estadio(Integer.parseInt(datos[0]), datos[1], datos[2]);
        return estadio;
    }
}
