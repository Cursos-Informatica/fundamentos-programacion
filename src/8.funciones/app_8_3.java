import matematicas.Varias;
import matematicas.Geometria;

public class app_8_3 {
    public static void main(String[] args) {
        int n;
        // Prueba esPrimo()
        System.out.print("Introduzca un número entero positivo: ");
        n = Integer.parseInt(System.console().readLine());
        if (matematicas.Varias.esPrimo(n)) {
        System.out.println("El " + n + " es primo.");
        } else {
        System.out.println("El " + n + " no es primo.");
        }
        // Prueba digitos()
        System.out.print("Introduzca un número entero positivo: ");
        n = Integer.parseInt(System.console().readLine());
        System.out.println(n + " tiene " + matematicas.Varias.digitos(n) + " dígitos.");
        // Prueba volumenCilindro()
        double r, h;
        System.out.println("Cálculo del volumen de un cilindro");
        System.out.print("Introduzca el radio en metros: ");
        r = Double.parseDouble(System.console().readLine());
        System.out.print("Introduzca la altura en metros: ");
        h = Double.parseDouble(System.console().readLine());
        System.out.println("El volumen del cilindro es " + matematicas.Geometria.volumenCilindro(r, h) + " m3");
        }
}
