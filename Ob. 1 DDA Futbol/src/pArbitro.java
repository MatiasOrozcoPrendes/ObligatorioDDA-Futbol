import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
//Clase pArbitro con los metodos necesarios para persistir los datos de los arbitros
public class pArbitro {
    //Metodo para crear el archivo "Arbitros.txt" si no existe
    public static void crearArchivo() {
        //Se crea el archivo y se iguala a null
        File archivo = null;
        //Se crea el FileWriter "escribir" que utilizaremos para escribir en el archivo y se iguala a null
        FileWriter escribir = null;
        //Se crea el try-catch para manejar las excepciones
        try {
            //Se iguala el archivo a un nuevo archivo con el nombre "Arbitros.txt"
            archivo = new File("Arbitro.txt");
            //Si no existe un archivo con el nombre "Arbitros.txt"
            if (!archivo.exists()) {
                //Igualamos el FileWriter "escribir" a un nuevo FileWriter con el archivo "Arbitros.txt"
                escribir = new FileWriter(archivo);
            }
        } catch (Exception e) {
            //Si hay una excepcion se imprime el error
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
    public static void escribirArbitro(Arbitro unArbitro){
        //Se crea el String "texto" que contendra el texto que se escribira en el archivo con los datos del arbitro separados por el caracter '@'
        String texto = unArbitro.getIdArbitro() + "@" + unArbitro.getNombre() + "@" + unArbitro.getApellido() + "@" + unArbitro.getDocumento() + "@" + unArbitro.getFechaNacimiento() + "@" + unArbitro.getPuesto();
        //Se crea el FileWriter "fichero" que utilizaremos para escribir en el archivo y se iguala a null
        FileWriter fichero = null;
        //Se crea el PrintWriter "pw" para agregar cada linea al archivo y se iguala a null
        PrintWriter pw = null;
        //Se crea el try-catch para manejar las excepciones
        try {
            //Igualamos el FileWriter "fichero" a un nuevo FileWriter con el archivo "Arbitros.txt" y el booleano "true" para que no sobreescriba el archivo
            fichero = new FileWriter("Arbitro.txt", true);
            //Igualamos el PrintWriter "pw" a un nuevo PrintWriter con las lineas del FileWriter "fichero"
            pw = new PrintWriter(fichero);
            //Se agrega la linea texto al PrintWriter "pw"
            pw.println(texto);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Aprovechamos el finally para cerrar el FileWriter "escribir" y evitar errores
            try {
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    //Metodo para sobreescribir el archivo "Arbitros.txt" con los datos recibidos en el ArrayList "arbitros"
    public static void cargoNuevaListaArbitro(ArrayList<Arbitro> arbitros) {
        //Creo un archivo "archivo" y lo igualo a un nuevo archivo con el nombre "Arbitros.txt"
        File archivo = new File("Arbitro.txt");
        //Elimino el archivo "Arbitros.txt"
        archivo.delete();
        //Creo el archivo "Arbitros.txt" utilizando el metodo "crearArchivo()" de esta misma clase
        crearArchivo();
        //Recorro el ArrayList "arbitros" y escribo cada arbitro utilizando el metodo "escribirArbitro()" de esta misma clase enviando como parametro cada arbitro
        for (int i = 0; i < arbitros.size(); i++) {
            escribirArbitro(arbitros.get(i));
        }
    }
    //Metodo para leer el archivo "Arbitros.txt" y cargar los datos en un    ArrayList y retornarlo
    public static ArrayList<Arbitro> leerArbitros(){
        //Creo el ArrayList "arbitros" que contendra los arbitros leidos del archivo
        ArrayList<Arbitro> arbitros = new ArrayList<Arbitro>();
        //Se crea el archivo y se iguala a null
        File archivo = null;
        //Se crea el FileReader "fr" que utilizaremos para leer el archivo y se iguala a null
        FileReader fr = null;
        //Se crea el BufferedReader "br" para poder leer linea por linea el archivo y se iguala a null
        BufferedReader br = null;
        //Se crea el try-catch para manejar las excepciones
        try {
            //Se iguala el archivo a un nuevo archivo con el nombre "Arbitros.txt"
            archivo = new File("Arbitro.txt");
            //Se iguala el FileReader "fr" a un nuevo FileReader utilizando el archivo que contiene los datos de "Arbitros.txt".
            fr = new FileReader(archivo);
            //Se iguala el BufferedReader "br" a un nuevo BufferedReader utilizando el FileReader "fr" para poder leer linea por linea el archivo
            br = new BufferedReader(fr);
            //Se crea el String "linea" que contendra cada linea del archivo
            String linea;
            //Utilizamos un while que se ejecutara mientras la linea que se lea en br no sea null
            while ((linea = br.readLine()) != null) {
                //Se utiliza el metodo pasoDeStringAArbitro() de esta misma clase enviando como parametro la linea leida, este metodo retornara un arbitro con los datos de la linea leida.
                //Se agrega el arbitro retornado por el metodo "pasoDeStringAArbitro()" al ArrayList "arbitros" para luego retornarlo
                arbitros.add(pasoDeStringAArbitro(linea));
            }
        } catch (Exception e) {
            //Si hay una excepcion se imprime el error
            e.printStackTrace();
        } finally {
            //Aprovechamos el finally para cerrar el FileReader "fr" y evitar errores
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
    //Metodo que recibe un String "texto" con los datos de un arbitro separados por el caracter '@' y retorna un nuevo arbitro con los datos del String
    public static Arbitro pasoDeStringAArbitro(String texto){
        //Se crea un Array "datos" que contendra los datos del String "texto" separados por el caracter '@'
        String[] datos = texto.split("@");
        //Se crea un nuevo arbitro "unArbitro" y se iguala a un nuevo arbitro con los datos del Array "datos" utilizando el constructor que creamos en la clase Arbitro
        Arbitro unArbitro = new Arbitro(Integer.parseInt(datos[0]), datos[1], datos[2], Integer.parseInt(datos[3]), LocalDate.parse(datos[4]), datos[5]);
        //Se retorna el arbitro "unArbitro"
        return unArbitro;
    }

}
