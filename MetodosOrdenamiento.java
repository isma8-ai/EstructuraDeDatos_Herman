import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MetodosOrdenamiento {

    // Algoritmo de la burbuja
    public static void bubbleSort(List<Integer> arr) {
        int n = arr.size();
        for (int i = 0; i < n; i++) {
            boolean intercambio = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    // Intercambio simple con variable temporal
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                    intercambio = true;
                }
            }
            // Si no hubo intercambios, ya está ordenado
            if (!intercambio) {
                break;
            }
        }
    }

    // Genera los datos según el estado
    public static List<Integer> generarDatos(int tamano, String estado) {
        List<Integer> datos = new ArrayList<>();

        if (estado.equals("aleatorio")) {
            Random rand = new Random();
            for (int i = 0; i < tamano; i++) {
                datos.add(rand.nextInt(1000000) + 1); // Número entre 1 y 1000000
            }
        } else if (estado.equals("invertido")) {
            for (int i = 0; i < tamano; i++) {
                datos.add(tamano - i); // Llenar de mayor a menor
            }
        }

        return datos;
    }

    public static void main(String[] args) {
        int[] tamanos = {100, 1000, 10000, 100000};
        String[] estados = {"aleatorio", "invertido"};

        System.out.printf("%-10s | %-10s | %-20s%n", "Tamaño", "Estado", "Tiempo (segundos)");
        System.out.println("------------------------------------------");

        for (int tamano : tamanos) {
            for (String estado : estados) {

                List<Integer> datos = generarDatos(tamano, estado);

                // Medir tiempo en nanosegundos y convertir a segundos
                long inicio = System.nanoTime();
                bubbleSort(datos);
                long fin = System.nanoTime();

                double tiempo = (fin - inicio) / 1_000_000_000.0;

                System.out.printf("%-10d | %-10s | %-20.6f s%n", tamano, estado, tiempo);
            }
        }
    }
}

//compilar y correr en la bash ya estoy harto
// javac MetodosOrdenamiento.java
// java MetodosOrdenamiento
