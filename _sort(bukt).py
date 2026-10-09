def insertion_sort(bukt):
    for j in range(1, len(bukt)):
        val = bukt[j]
        k = j - 1

        while k >= 0 and bukt[k] > val:
            bukt[k + 1] = bukt[k]
            k -= 1

        bukt[k + 1] = val


def bucket_sort(inputArr):
    s = len(inputArr)
    bucketArr = [[] for _ in range(s)]

    # Colocar cada elemento en su bucket
    for j in inputArr:
        b1 = int(s * j)

        if b1 >= s:
            b1 = s - 1

        bucketArr[b1].append(j)

    # Ordenar cada bucket
    for bukt in bucketArr:
        insertion_sort(bukt)

    # Unir todos los buckets
    idx = 0

    for bukt in bucketArr:
        for j in bukt:
            inputArr[idx] = j
            idx += 1


# Ejemplo de uso
inputArr = [0.77, 0.16, 0.38, 0.25, 0.71,
            0.93, 0.22, 0.11, 0.24, 0.67]

print("Arreglo antes de ordenar:")
print(" ".join(map(str, inputArr)))

bucket_sort(inputArr)

print("Arreglo después de ordenar:")
print(" ".join(map(str, inputArr)))
