// Función para implementar el algoritmo de selección
function selection(a) {
    let n = a.length;
    for (let i = 0; i < n; i++) { // Recorre todo el arreglo
        let small = i; // Índice del elemento más pequeño
        for (let j = i + 1; j < n; j++) { // Encuentra el elemento más pequeño en el arreglo
            if (a[small] > a[j]) { // Compara el elemento más pequeño con el siguiente
                small = j; // Actualiza el índice del elemento más pequeño
            }
        }
        // Intercambia el elemento más pequeño con el primer elemento
        let temp = a[i];
        a[i] = a[small];
        a[small] = temp;
    }
}

// Función para imprimir el array
function printArr(a) {
    console.log(a.join(" "));
}

let a = [65, 26, 13, 23, 12]; // Arreglo desordenado

console.log("Arreglo antes de ser ordenado: ");
printArr(a);

selection(a);

console.log("\nArreglo después de ser ordenado: ");
printArr(a);
