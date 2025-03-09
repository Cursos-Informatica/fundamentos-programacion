import java.util.Scanner;

public class app_3_5 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Introduce tres números (pueden contener decimales) separados por espacio\s: ");
        double x1 = s.nextDouble();
        double x2 = s.nextDouble();
        double x3 = s.nextDouble();
        double media = (x1 + x2 + x3) / 3;
        System.out.println("La media de esos tres números es " + media);
        }
}
