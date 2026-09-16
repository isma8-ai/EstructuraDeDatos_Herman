function swap(a, j, k) {
    let temp = a[j];
    a[j] = a[k];
    a[k] = temp;
}

function particion(a, l, h) {
    let pvt = a[h];
    let j = l - 1;

    for (let k = l; k < h; k++) {
        if (a[k] < pvt) {
            j++;
            swap(a, j, k);
        }
    }

    swap(a, j + 1, h);
    return j + 1;
}

function qckSort(a, l, h) {
    if (l < h) {
        let pi = particion(a, l, h);
        qckSort(a, l, pi - 1);
        qckSort(a, pi + 1, h);
    }
}

let a = [10, 7, 8, 9, 1, 5];
let size = a.length;

console.log("El arreglo antes de ordenarlo: ");
console.log(a.join(" "));

qckSort(a, 0, size - 1);

console.log("El arreglo despues de ordenarlo: ");
console.log(a.join(" "));
