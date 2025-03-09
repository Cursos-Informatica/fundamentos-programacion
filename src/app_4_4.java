public class app_4_4 {
    public static void main(String[] args) {
        System.out.print("¿Qué nota has sacado en el último examen? ");
        String line = System.console().readLine();
        double nota = Double.parseDouble( line );
        if (nota >= 14) {
        System.out.println("Felicitaciones!, ¡has aprobado!");
        } else {
        System.out.println("Lo siento, has suspendido.");
        }
    }
}
