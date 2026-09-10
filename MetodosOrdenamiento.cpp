#include <iostream>
#include <vector>
#include <string>
#include <cstdlib> // Para rand()
#include <ctime>   // Para clock() y medir tiempo

using namespace std; // Para evitar poner std:: en cada linea

// Algoritmo de la burbuja
void bubbleSort(vector<int>& arr) {
    int n = arr.size();
    for (int i = 0; i < n; i++) {
        bool intercambio = false;
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                // Intercambio simple
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                intercambio = true;
            }
        }
        // Si no hubo intercambios, ya esta ordenado
        if (!intercambio) {
            break;
        }
    }
}

// Genera los datos segun el estado
vector<int> generarDatos(int tamano, string estado) {
    vector<int> datos(tamano);

    if (estado == "aleatorio") {
        for (int i = 0; i < tamano; i++) {
            datos[i] = rand() % 1000000 + 1; // Numero al azar entre 1 y 1000000
        }
    }
    else if (estado == "invertido") {
        for (int i = 0; i < tamano; i++) {
            datos[i] = tamano - i; // Llenar de mayor a menor
        }
    }

    return datos;
}

int main() {
    int tamanos[] = {100, 1000, 10000, 100000};
    string estados[] = {"aleatorio", "invertido"};

    cout << "Tamano     | Estado     | Tiempo (segundos)\n";
    cout << "------------------------------------------\n";

    for (int i = 0; i < 4; i++) { // Bucle para los 4 tamanos
        for (int j = 0; j < 2; j++) { // Bucle para los 2 estados

            int tamano = tamanos[i];
            string estado = estados[j];

            vector<int> datos = generarDatos(tamano, estado);

            // Medir el tiempo
            clock_t inicio = clock();
            bubbleSort(datos);
            clock_t fin = clock();

            // Calcular diferencia en segundos
            double tiempo = double(fin - inicio) / CLOCKS_PER_SEC;

            cout << tamano << " | " << estado << " | " << tiempo << " s\n";
        }
    }

    return 0;
}

//Correr programa
// // g++ MetodosOrdenamiento.cpp -o MetodosOrdenamiento.exe
// .\MetodosOrdenamiento.exe
