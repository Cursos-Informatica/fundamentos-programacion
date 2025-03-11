package app_9_4;

public class PruebaPolimorfismo {

    // Método que recibe un Animal y ejecuta el método vuela() sin importar su tipo
    public static void probarVuelo(Animal animal) {
        animal.vuela(); // Gracias al polimorfismo, se ejecuta el método correcto
    }

    public static void main(String[] args) {
        Animal miAve = new Ave();
        Animal miPinguino = new Pinguino();
        Animal miGatito = new Gato();

        // Usamos el método genérico para probar el vuelo de cualquier Animal
        probarVuelo(miAve);       // Salida: Estoy volando
        probarVuelo(miPinguino);  // Salida: No puedo volar
        probarVuelo(miGatito);  // Salida: No puedo volar
    }
}
