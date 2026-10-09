function insertion_sort(bukt) {
    for (let j = 1; j < bukt.length; j++) {
        let val = bukt[j];
        let k = j - 1;

        while (k >= 0 && bukt[k] > val) {
            bukt[k + 1] = bukt[k];
            k--;
        }

        bukt[k + 1] = val;
    }
}

function bucket_sort(inputArr) {
    let s = inputArr.length;

    let bucketArr = Array.from(
        { length: s },
        () => []
    );

    // Colocar cada elemento en su bucket
    for (let j of inputArr) {
        let b1 = Math.floor(s * j);

        if (b1 >= s) {
            b1 = s - 1;
        }

        bucketArr[b1].push(j);
    }

    // Ordenar cada bucket
    for (let bukt of bucketArr) {
        insertion_sort(bukt);
    }

    // Unir todos los buckets
    let idx = 0;

    for (let bukt of bucketArr) {
        for (let j of bukt) {
            inputArr[idx] = j;
            idx++;
        }
    }
}

// Ejemplo de uso
let inputArr = [
    0.77, 0.16, 0.38, 0.25, 0.71,
    0.93, 0.22, 0.11, 0.24, 0.67
];

console.log("Arreglo antes de ordenar:");
console.log(inputArr.join(" "));

bucket_sort(inputArr);

console.log("Arreglo después de ordenar:");
console.log(inputArr.join(" "));
