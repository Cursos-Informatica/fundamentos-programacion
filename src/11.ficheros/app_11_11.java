import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class app_11_11 {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.print("Procesando el archivo " + args[i] + "...");

            String archivo = "src/11.ficheros/" + args[i];

            // renombra el fichero añadiendo ".tmp"
            File ficheroOriginal = new File(archivo);
            File ficheroTemporal = new File(archivo + ".tmp");

            if (!ficheroOriginal.exists()) {
                System.out.println("Error: El archivo " + archivo + " no existe.");
                continue; // Salta al siguiente archivo en el loop
            }

            try {
                ficheroOriginal.renameTo(ficheroTemporal);
                
                // lee los datos del archivo temporal
                BufferedReader bf = new BufferedReader(new FileReader(archivo + ".tmp"));
                
                // crea un fichero nuevo con el nombre original
                BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
                String linea = "";
                while ( linea != null ) {
                    linea = bf.readLine();
                    if (linea != null) {
                        // cambia el tabulador por 2 espacios
                        linea = linea.replace("\t", " ");
                        bw.write(linea + "\n");
                    }
                }
                bf.close();
                bw.close();
                
                // borra el fichero temporal
                // ficheroTemporal.delete();
            } catch (IOException ioe) {
                System.out.println("Se ha producido un error de lectura/escritura");
                System.err.println(ioe.getMessage());
            }
            System.out.println("hecho");
        }
    }
}
