import random
import time

def bubble_sort(arr):
    n = len(arr)
    for i in range(n):
        intercambio = False
        for j in range (0, n - i -1):
            if arr[j] > arr[j + 1]:
                #intercambio de elementos
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
                intercambio = True
                # Si no hubo intercambios, la lista ya está ordenada
        if not intercambio:
            break
        return arr

#Una funcion que genere datos segun lo pedido de 100 1000 10000 y 100000
def generar_datos(tamano, estado):
    if estado == "aleatorio":
        # Números enteros aleatorios entre 1 y 1,000,000
        return [random.randint(1, 1000000) for _ in range(tamano)]
    elif estado == "invertido":
        # Lista ordenada de mayor a menor (peor caso para ordenamiento)
        return list(range(tamano, 0, -1))

tamanos = [100, 1000, 10000, 100000]
estados = ["aleatorio", "invertido"]

print(f"{'Tamaño':<10} | {'Estado':<10} | {'Tiempo (segundos)':<20}")
print("-" * 48)

for tamano in tamanos:
    for estado in estados:
        # Generar lista
        datos = generar_datos(tamano, estado)

        # Medir tiempo
        inicio = time.time()
        bubble_sort(datos)
        fin = time.time()

        tiempo_total = fin - inicio
        print(f"{tamano:<10} | {estado:<10} | {tiempo_total:<20.6f}")
