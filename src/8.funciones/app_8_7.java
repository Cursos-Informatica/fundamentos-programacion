public class app_8_7 {
    static int factorial(int n) {
        if (n == 0) return 1; // Caso base
        return n * factorial(n - 1); // Llamada recursiva
    }

    public static void main(String[] args) {
        System.out.println(factorial(5)); // 5! = 120
    }
}
