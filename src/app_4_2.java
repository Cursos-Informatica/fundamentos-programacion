public class app_4_2 {
    public static void main(String[] args) {
        System.out.print("¿Cuál es la capital de Peru? ");
        String respuesta = System.console().readLine();
        if (respuesta.equals("Lima")) {
        System.out.println("¡La respuesta es correcta!");
        } else {
        System.out.println("Lo siento, la respuesta es incorrecta.");
        }
    }
}
