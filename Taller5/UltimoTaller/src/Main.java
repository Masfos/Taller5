public class Main {
    /**
     * Punto de entrada del programa.
     * Crea una instancia del sistema e inicia el programa.
     *
     * @param args Los argumentos de línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        // Crear una instancia del sistema
        Sistema sistema = new SistemImpl();
        // Iniciar el programa
        sistema.starProgram();
    }
}