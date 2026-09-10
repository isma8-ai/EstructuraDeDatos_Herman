// Algoritmo de la burbuja
function bubbleSort(arr) {
    let n = arr.length;
    for (let i = 0; i < n; i++) {
        let intercambio = false;
        for (let j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                // Intercambio simple con variable temporal
                let temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
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
function generarDatos(tamano, estado) {
    let datos = [];

    if (estado === "aleatorio") {
        for (let i = 0; i < tamano; i++) {
            // Número aleatorio entre 1 y 1,000,000
            datos.push(Math.floor(Math.random() * 1000000) + 1);
        }
    } else if (estado === "invertido") {
        for (let i = 0; i < tamano; i++) {
            datos.push(tamano - i); // Llenar de mayor a menor
        }
    }

    return datos;
}

function main() {
    const tamanos = [100, 1000, 10000, 100000];
    const estados = ["aleatorio", "invertido"];

    console.log("Tamaño     | Estado     | Tiempo (segundos)");
    console.log("------------------------------------------");

    for (let tamano of tamanos) {
        for (let estado of estados) {
            let datos = generarDatos(tamano, estado);

            // Medir el tiempo exacto con performance.now()
            let inicio = performance.now();
            bubbleSort(datos);
            let fin = performance.now();

            // Convertir milisegundos a segundos
            let tiempo = (fin - inicio) / 1000;

            console.log(`${tamano.toString().padEnd(10)} | ${estado.padEnd(10)} | ${tiempo.toFixed(6)} s`);
        }
    }
}

main();

//Correr este fukin programa
// node MetodosOrdenamiento.js
