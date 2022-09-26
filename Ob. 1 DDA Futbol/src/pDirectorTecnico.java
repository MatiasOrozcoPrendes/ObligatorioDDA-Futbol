import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class pDirectorTecnico {
    public static void crearArchivo() {
        File archivo = null;
        FileWriter escribir = null;
        try {
            archivo = new File("DirectorTecnico.txt");
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
    public static void escribirDirectorTecnico (DirectorTecnico unDirectorTecnico){
        String texto = unDirectorTecnico.getIdDirectorTecnico() + "@" + unDirectorTecnico.getNombre() + "@" + unDirectorTecnico.getApellido() + "@" + unDirectorTecnico.getDocumento() + "@" + unDirectorTecnico.getFechaNacimiento() + "@" + unDirectorTecnico.getIdEquipo();
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("DirectorTecnico.txt", true);
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
    public static void cargoNuevaListaDirectorTecnico(ArrayList<DirectorTecnico> direcoresTecnicos) {
        //Elimino el archivo
        File archivo = new File("DirectorTecnico.txt");
        archivo.delete();
        //Creo el archivo
        crearArchivo();
        //Cargo la lista
        for (int i = 0; i < direcoresTecnicos.size(); i++) {
            escribirDirectorTecnico(direcoresTecnicos.get(i));
        }
    }
    public static ArrayList<DirectorTecnico> leerDirectoresTecnicos(){
        ArrayList<DirectorTecnico> directoresTecnicos = new ArrayList<DirectorTecnico>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File ("DirectorTecnico.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while((linea=br.readLine())!=null)
                directoresTecnicos.add(pasoDeStringADirectorTecnico(linea));
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
        return directoresTecnicos;
    }
    public static DirectorTecnico pasoDeStringADirectorTecnico(String linea){
        String[] datos = linea.split("@");
        DirectorTecnico unDirectorTecnico = new DirectorTecnico(Integer.parseInt(datos[0]), datos[1], datos[2], Integer.parseInt(datos[3]), LocalDate.parse(datos[4]), Integer.parseInt(datos[5]));
        return unDirectorTecnico;
    }
}
