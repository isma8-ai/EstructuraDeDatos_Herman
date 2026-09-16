public class Main {
    // Función para implementar el algoritmo de selección
    public static void selection(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) { // Recorre todo el arreglo
            int small = i; // Índice del elemento más pequeño
            for (int j = i + 1; j < n; j++) { // Encuentra el elemento más pequeño en el arreglo
                if (a[small] > a[j]) { // Compara el elemento más pequeño con el siguiente elemento
                    small = j; // Actualiza el índice del elemento más pequeño
                }
            }
            // Intercambia el elemento más pequeño con el primer elemento
            int temp = a[i];
            a[i] = a[small];
            a[small] = temp;
        }
    }

    // Función para imprimir el array
    public static void printArr(int[] a) {
        for (int i = 0; i < a.length; i++) { // Recorre todo el arreglo
            System.out.print(a[i] + " "); // Imprime el elemento
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {65, 26, 13, 23, 12}; // Arreglo desordenado

        System.out.println("Arreglo antes de ser ordenado: ");
        printArr(a);

        selection(a);

        System.out.println("\nArreglo después de ser ordenado: ");
        printArr(a);
    }
}
