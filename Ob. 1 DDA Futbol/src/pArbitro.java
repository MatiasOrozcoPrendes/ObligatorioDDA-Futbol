import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class pArbitro {
    public static void crearArchivo() {
        File archivo = null;
        FileWriter escribir = null;
        try {
            archivo = new File("Arbitro.txt");
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
    public static void escribirArbitro(Arbitro unArbitro){
        String texto = unArbitro.getIdArbitro() + "@" + unArbitro.getNombre() + "@" + unArbitro.getApellido() + "@" + unArbitro.getDocumento() + "@" + unArbitro.getFechaNacimiento() + "@" + unArbitro.getPuesto();
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("Arbitro.txt", true);
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
    public static void cargoNuevaListaArbitro(ArrayList<Arbitro> arbitros) {
        //Elimino el archivo
        File archivo = new File("Arbitro.txt");
        archivo.delete();
        //Creo el archivo
        crearArchivo();
        //Cargo la lista
        for (int i = 0; i < arbitros.size(); i++) {
            escribirArbitro(arbitros.get(i));
        }
    }
    public static ArrayList<Arbitro> leerArbitros(){
        ArrayList<Arbitro> arbitros = new ArrayList<Arbitro>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            archivo = new File("Arbitro.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                arbitros.add(pasoDeStringAArbitro(linea));
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
        return arbitros;
    }
    public static Arbitro pasoDeStringAArbitro(String texto){
        String[] datos = texto.split("@");
        Arbitro unArbitro = new Arbitro(Integer.parseInt(datos[0]), datos[1], datos[2], Integer.parseInt(datos[3]), LocalDate.parse(datos[4]), datos[5]);
        return unArbitro;
    }

}
