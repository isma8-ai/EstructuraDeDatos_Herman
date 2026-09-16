#include <iostream>

using namespace std;

// Función para implementar el algoritmo de selección
void selection(int a[], int size) {
    for (int i = 0; i < size; i++) { // Recorre todo el arreglo
        int small = i; // Índice del elemento más pequeño
        for (int j = i + 1; j < size; j++) { // Encuentra el elemento más pequeño en el arreglo
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
void printArr(int a[], int size) {
    for (int i = 0; i < size; i++) { // Recorre todo el arreglo
        cout << a[i] << " "; // Imprime el elemento
    }
    cout << endl;
}

int main() {
    int a[] = {65, 26, 13, 23, 12}; // Arreglo desordenado
    int size = 5;

    cout << "Arreglo antes de ser ordenado: " << endl;
    printArr(a, size);

    selection(a, size);

    cout << "\nArreglo después de ser ordenado: " << endl;
    printArr(a, size);

    return 0;
}
