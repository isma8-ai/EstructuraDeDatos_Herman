public class MergeSort {

    static void merge(int[] a, int l, int m, int r) {

        int a1 = m - l + 1;
        int a2 = r - m;

        // crea arrays temporales
        int[] L = new int[a1];
        int[] R = new int[a2];

        // copia los datos de los arrays temporales L y R
        for (int j = 0; j < a1; j++) {
            L[j] = a[l + j];
        }

        for (int k = 0; k < a2; k++) {
            R[k] = a[m + 1 + k];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while (i < a1 && j < a2) {

            if (L[i] <= R[j]) {
                a[k] = L[i];
                i = i + 1;
            } else {
                a[k] = R[j];
                j = j + 1;
            }

            k = k + 1;
        }

        while (i < a1) {
            a[k] = L[i];
            i = i + 1;
            k = k + 1;
        }

        while (j < a2) {
            a[k] = R[j];
            j = j + 1;
            k = k + 1;
        }
    }


    static void mergeSort(int[] a, int l, int r) {

        if (l < r) {

            int m = l + (r - l) / 2;

            mergeSort(a, l, m);
            mergeSort(a, m + 1, r);

            merge(a, l, m, r);
        }
    }


    public static void main(String[] args) {

        int[] a = {39, 28, 44, 11};
        int s = a.length;

        System.out.println("Antes de ordenar el arreglo:");

        for (int j = 0; j < s; j++) {
            System.out.print(a[j] + " ");
        }

        mergeSort(a, 0, s - 1);

        System.out.println("\nDespues de ordenar el arreglo:");

        for (int j = 0; j < s; j++) {
            System.out.print(a[j] + " ");
        }
    }
}
