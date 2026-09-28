function merge(a, l, m, r) {
    let a1 = m - l + 1;
    let a2 = r - m;

    // crea arrays temporales
    let L = new Array(a1);
    let R = new Array(a2);

    // copia los datos de los arrays temporales L y R
    for (let j = 0; j < a1; j++) {
        L[j] = a[l + j];
    }

    for (let k = 0; k < a2; k++) {
        R[k] = a[m + 1 + k];
    }

    let i = 0;
    let j = 0;
    let k = l;

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


function mergeSort(a, l, r) {
    if (l < r) {
        let m = l + Math.floor((r - l) / 2);

        mergeSort(a, l, m);
        mergeSort(a, m + 1, r);
        merge(a, l, m, r);
    }
}


let a = [39, 28, 44, 11];
let s = a.length;

console.log("Antes de ordenar el arreglo:");

for (let j = 0; j < s; j++) {
    process.stdout.write(a[j] + " ");
}

mergeSort(a, 0, s - 1);

console.log("\nDespués de ordenar el arreglo:");

for (let j = 0; j < s; j++) {
    process.stdout.write(a[j] + " ");
}
