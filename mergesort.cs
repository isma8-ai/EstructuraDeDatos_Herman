using System;

class Program
{
    static void Merge(int[] a, int l, int m, int r)
    {
        int a1 = m - l + 1;
        int a2 = r - m;

        // crea arrays temporales
        int[] L = new int[a1];
        int[] R = new int[a2];

        // copia los datos de los arrays temporales L y R
        for (int j = 0; j < a1; j++)
        {
            L[j] = a[l + j];
        }

        for (int k = 0; k < a2; k++)
        {
            R[k] = a[m + 1 + k];
        }

        int i = 0;
        int j2 = 0;
        int k2 = l;

        while (i < a1 && j2 < a2)
        {
            if (L[i] <= R[j2])
            {
                a[k2] = L[i];
                i = i + 1;
            }
            else
            {
                a[k2] = R[j2];
                j2 = j2 + 1;
            }

            k2 = k2 + 1;
        }

        while (i < a1)
        {
            a[k2] = L[i];
            i = i + 1;
            k2 = k2 + 1;
        }

        while (j2 < a2)
        {
            a[k2] = R[j2];
            j2 = j2 + 1;
            k2 = k2 + 1;
        }
    }


    static void MergeSort(int[] a, int l, int r)
    {
        if (l < r)
        {
            int m = l + (r - l) / 2;

            MergeSort(a, l, m);
            MergeSort(a, m + 1, r);
            Merge(a, l, m, r);
        }
    }


    static void Main()
    {
        int[] a = { 39, 28, 44, 11 };
        int s = a.Length;

        Console.WriteLine("Antes de ordenar el arreglo:");

        for (int j = 0; j < s; j++)
        {
            Console.Write(a[j] + " ");
        }

        MergeSort(a, 0, s - 1);

        Console.WriteLine("\nDespués de ordenar el arreglo:");

        for (int j = 0; j < s; j++)
        {
            Console.Write(a[j] + " ");
        }
    }
}
