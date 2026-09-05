#include <iostream>
using namespace std;

int main() {
    int filas = 3;
    int columnas = 3;

    // Declaración e inicialización de la matriz
    int matriz[3][3] = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };

    cout << "Matriz recorrida de forma secuencial:" << endl;
    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            cout << matriz[i][j] << " ";
        }
        cout << endl;
    }

    return 0;
}

//Comandos para ejecutar
// g++ main++.cpp -o main++.exe
// .\main++.exe
