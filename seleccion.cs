using System;

class Program
{
    // Función para implementar el algoritmo de selección
    static void Selection(int[] a)
    {
        int n = a.Length;
        for (int i = 0; i < n; i++) // Recorre todo el arreglo
        {
            int small = i; // Índice del elemento más pequeño
            for (int j = i + 1; j < n; j++) // Encuentra el elemento más pequeño en el arreglo
            {
                if (a[small] > a[j]) // Compara el elemento más pequeño con el siguiente elemento
                {
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
    static void PrintArr(int[] a)
    {
        for (int i = 0; i < a.Length; i++) // Recorre todo el arreglo
        {
            Console.Write(a[i] + " "); // Imprime el elemento
        }
        Console.WriteLine();
    }

    static void Main()
    {
        int[] a = { 65, 26, 13, 23, 12 }; // Arreglo desordenado

        Console.WriteLine("Arreglo antes de ser ordenado: ");
        PrintArr(a);

        Selection(a);

        Console.WriteLine("\nArreglo después de ser ordenado: ");
        PrintArr(a);
    }
}
