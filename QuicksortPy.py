#Implementacion de quicksort en python
#Funcion para hacer la particion de el arreglo
# Implementacion de quicksort en python

# Funcion para hacer la particion del arreglo
def swap(a, j, k):
    a[j], a[k] = a[k], a[j]

def particion(a, l, h):
    # Selecciona el elemento pivote
    pvt = a[h]
    j = l - 1

    for k in range(l, h):
        if a[k] < pvt:
            j += 1
            swap(a, j, k)

    swap(a, j + 1, h)
    return j + 1

def qckSort(a, l, h):
    if l < h:
        pi = particion(a, l, h)
        qckSort(a, l, pi - 1)
        qckSort(a, pi + 1, h)

if __name__ == "__main__":
    a = [10, 7, 8, 9, 1, 5]
    size = len(a)

    print("El arreglo antes de ordenarlo: ")
    for v in a:
        print(v, end=" ")
    print()

    qckSort(a, 0, size - 1)

    print("El arreglo despues de ordenarlo: ")
    for v in a:
        print(v, end=" ")
    print()
