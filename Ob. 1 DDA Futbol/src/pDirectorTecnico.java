import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
//Clase pDirectorTecnico con los metodos necesarios para persistir los datos de los directores tecnicos
public class pDirectorTecnico {
    //Metodo para crear el archivo "DirectoresTecnicos.txt" si no existe
    public static void crearArchivo() {
        //Se crea el archivo y se iguala a null
        File archivo = null;
        //Se crea el FileWriter "escribir" que utilizaremos para escribir en el archivo y se iguala a null
        FileWriter escribir = null;
        //Se crea el try-catch para manejar las excepciones
        try {
            //Se iguala el archivo a un nuevo archivo con el nombre "DirectoresTecnicos.txt"
            archivo = new File("DirectorTecnico.txt");
            //Si no existe un archivo con el nombre "DirectoresTecnicos.txt"
            if (!archivo.exists()) {
                //Igualamos el FileWriter "escribir" a un nuevo FileWriter con el archivo "DirectoresTecnicos.txt"
                escribir = new FileWriter(archivo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Aprovechamos el finally para cerrar el FileWriter "escribir" y evitar errores
            try {
                if (null != escribir)
                    escribir.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    //Metodo para escribir un director tecnico en el archivo "DirectoresTecnicos.txt"
    public static void escribirDirectorTecnico (DirectorTecnico unDirectorTecnico){
        //Se crea el String "texto" que contendra el texto que se escribira en el archivo con los datos del director tecnico separados por el caracter '@'
        String texto = unDirectorTecnico.getIdDirectorTecnico() + "@" + unDirectorTecnico.getNombre() + "@" + unDirectorTecnico.getApellido() + "@" + unDirectorTecnico.getDocumento() + "@" + unDirectorTecnico.getFechaNacimiento() + "@" + unDirectorTecnico.getIdEquipo();
        //Se crea el FileWriter "fichero" que utilizaremos para escribir en el archivo y se iguala a null
        FileWriter fichero = null;
        //Se crea el PrintWriter "pw" que utilizaremos para escribir en el archivo y se iguala a null
        PrintWriter pw = null;
        //Se crea el try-catch para manejar las excepciones
        try {
            //Igualamos el FileWriter "fichero" a un nuevo FileWriter con el archivo "DirectoresTecnicos.txt" y el parametro "true" para que no sobreescriba el archivo
            fichero = new FileWriter("DirectorTecnico.txt", true);
            //Igualamos el PrintWriter "pw" al FileWriter "fichero" para poder escribir en el archivo
            pw = new PrintWriter(fichero);
            //Escribimos en el archivo el String "texto"
            pw.println(texto);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Aprovechamos el finally para cerrar el PrintWriter "pw" y evitar errores
            try {
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }

        }
    }
    //Metodo para leer el archivo "DirectoresTecnicos.txt" y retornar un ArrayList con los directores tecnicos
    public static void cargoNuevaListaDirectorTecnico(ArrayList<DirectorTecnico> direcoresTecnicos) {
        //Creo un archivo "archivo" y lo igualo a un nuevo archivo con el nombre "DirectoresTecnicos.txt"
        File archivo = new File("DirectorTecnico.txt");
        //Elimino el archivo "DirectoresTecnicos.txt" para que no se repitan los datos
        archivo.delete();
        //Creo un nuevo archivo utilizando el metodo "crearArchivo()" de esta misma clase
        crearArchivo();
        //Recorro el ArrayList "direcoresTecnicos" con un for
        for (int i = 0; i < direcoresTecnicos.size(); i++) {
            //Escribo en el archivo "DirectoresTecnicos.txt" utilizando el metodo "escribirDirectorTecnico()" de esta misma clase y le paso como parametro el director tecnico de la posicion "i" del ArrayList "direcoresTecnicos"
            escribirDirectorTecnico(direcoresTecnicos.get(i));
        }
    }
    public static ArrayList<DirectorTecnico> leerDirectoresTecnicos(){
        //Creo un ArrayList "directoresTecnicos" de tipo DirectorTecnico y lo igualo a un nuevo ArrayList para guardar los directores tecnicos que se leen del archivo "DirectoresTecnicos.txt"
        ArrayList<DirectorTecnico> directoresTecnicos = new ArrayList<DirectorTecnico>();
        //Creo un archivo "archivo" y lo igualo a null
        File archivo = null;
        //Creo un FileReader "fr" y lo igualo a null
        FileReader fr = null;
        //Creo un BufferedReader "br" y lo igualo a null
        BufferedReader br = null;
        //Creo un try-catch para manejar las excepciones
        try {
            //Igualo el archivo a un nuevo archivo con el nombre "DirectoresTecnicos.txt"
            archivo = new File ("DirectorTecnico.txt");
            //Igualo el FileReader "fr" a un nuevo FileReader con el archivo "DirectoresTecnicos.txt"
            fr = new FileReader(archivo);
            //Igualo el BufferedReader "br" al FileReader "fr" para poder leer el archivo
            br = new BufferedReader(fr);
            //Creo un String "linea" para guardar las lineas que se leen del archivo
            String linea;
            //Utilizo un while para leer el archivo linea por linea hasta que no haya mas lineas
            while((linea=br.readLine())!=null) {
                //Se utiliza el metodo pasoDeStringADirectorTecnico() enviando como parametro la linea leida del archivo y se guarda en directoresTecnicos el resultado
                directoresTecnicos.add(pasoDeStringADirectorTecnico(linea));
            }
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Error al leer el archivo");
        }finally{
            //Aprovechamos el finally para cerrar el BufferedReader "br" y evitar errores
            try{
                if( null != fr ){
                    fr.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
        //Retornamos el ArrayList "directoresTecnicos" con los directores tecnicos leidos del archivo
        return directoresTecnicos;
    }
    //Metodo que recibe un String con los datos del director tecnico separados por el caracter '@' y retorna un objeto de tipo DirectorTecnico
    public static DirectorTecnico pasoDeStringADirectorTecnico(String linea){
        //Creo un Array de String "datos" y lo igualo al resultado de separar el String "linea" por el caracter '@'
        String[] datos = linea.split("@");
        //Se crea un nuevo DirectorTecnico "directorTecnico" con los datos del Array "datos" utilizando el constructor de la clase DirectorTecnico
        DirectorTecnico unDirectorTecnico = new DirectorTecnico(Integer.parseInt(datos[0]), datos[1], datos[2], Integer.parseInt(datos[3]), LocalDate.parse(datos[4]), Integer.parseInt(datos[5]));
        //Retorna el DirectorTecnico "directorTecnico"
        return unDirectorTecnico;
    }
}
