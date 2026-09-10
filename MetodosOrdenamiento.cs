using System;
using System.Collections.Generic;
using System.Diagnostics; // Necesario para medir el tiempo con Stopwatch

class Program
{
    // Algoritmo de la burbuja
    static void BubbleSort(List<int> arr)
    {
        int n = arr.Count;
        for (int i = 0; i < n; i++)
        {
            bool intercambio = false;
            for (int j = 0; j < n - i - 1; j++)
            {
                if (arr[j] > arr[j + 1])
                {
                    // Intercambio simple con variable temporal
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    intercambio = true;
                }
            }
            // Si no hubo intercambios, ya esta ordenado
            if (!intercambio)
            {
                break;
            }
        }
    }

    // Genera los datos segun el estado
    static List<int> GenerarDatos(int tamano, string estado)
    {
        List<int> datos = new List<int>();

        if (estado == "aleatorio")
        {
            Random rand = new Random();
            for (int i = 0; i < tamano; i++)
            {
                datos.Add(rand.Next(1, 1000001)); // Numero al azar entre 1 y 1000000
            }
        }
        else if (estado == "invertido")
        {
            for (int i = 0; i < tamano; i++)
            {
                datos.Add(tamano - i); // Llenar de mayor a menor
            }
        }

        return datos;
    }

    static void Main()
    {
        int[] tamanos = { 100, 1000, 10000, 100000 };
        string[] estados = { "aleatorio", "invertido" };

        Console.WriteLine("Tamano     | Estado     | Tiempo (segundos)");
        Console.WriteLine("------------------------------------------");

        for (int i = 0; i < tamanos.Length; i++)
        {
            for (int j = 0; j < estados.Length; j++)
            {
                int tamano = tamanos[i];
                string estado = estados[j];

                List<int> datos = GenerarDatos(tamano, estado);

                // Medir el tiempo con Stopwatch
                Stopwatch reloj = new Stopwatch();
                reloj.Start();

                BubbleSort(datos);

                reloj.Stop();

                // Convertir el tiempo medido a segundos
                double tiempo = reloj.Elapsed.TotalSeconds;

                Console.WriteLine($"{tamano,-10} | {estado,-10} | {tiempo:F6} s");
            }
        }
    }
}
