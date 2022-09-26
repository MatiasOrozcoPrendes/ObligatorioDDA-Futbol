import java.io.*;
import java.util.ArrayList;


public class pEquipo {
    public static void crearArchivo() {
        File archivo = null;
        FileWriter escribir = null;
        try {
            archivo = new File("Equipo.txt");
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
    public static void escribirEquipo (Equipo unEquipo){
        String texto = unEquipo.getIdEquipo() + "@" + unEquipo.getNombre() + "@" + unEquipo.getCiudad();
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("Equipo.txt", true);
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
    public static void cargoNuevaListaEquipo(ArrayList<Equipo> equipos){
        //Elimino el archivo
        File archivo = new File("Equipo.txt");
        archivo.delete();
        //Creo el archivo
        crearArchivo();
        //Cargo la lista
        for (int i = 0; i < equipos.size(); i++) {
            escribirEquipo((Equipo) equipos.get(i));
        }
    }
    public static ArrayList<Equipo> leerEquipos(){
        ArrayList<Equipo> equipos = new ArrayList<Equipo>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File ("Equipo.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while((linea=br.readLine())!=null)
                equipos.add(pasoDeStringAEquipo(linea));
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Error al leer el archivo");
        }finally{
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try{
                if( null != fr ){
                    fr.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
        return equipos;
    }
    public static Equipo pasoDeStringAEquipo(String linea){
        String[] datos = linea.split("@");
        Equipo unEquipo = new Equipo(Integer.parseInt(datos[0]), datos[1], datos[2]);
        return unEquipo;
    }


}
