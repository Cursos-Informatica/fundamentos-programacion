import java.io.File;

public class app_11_5 {
    public static void main(String[] args) {
        File f = new File("."); // se indica la ruta entre comillas
        // el punto (.) es el directorio actual
        String[] listaArchivos = f.list();
        for(String nombreArchivo : listaArchivos) {
            System.out.println(nombreArchivo);
        }
    }
}
