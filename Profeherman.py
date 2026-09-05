from string import printable

import numpy as np

#Con una libreria de python como numpy podemos hacer las cosas mas faciles y se usa para poder hacer formulas cientificas

vector = list(range(10))
print(vector)
#este es un vector que me imprime lo que yo le doy en rango desde el cero al vector de un solo sentido poniendo donde quiero que finalice este en el 10.

vector = [0] * 10
print(vector)
#Este es un vector que me imprime el cero las veces que yo le indique fuera de los corchetes es solo logico de el lenguaje.

vector = [10,9,9,9,9,5,5,54,43,4,43,33,6]
print(vector)
#de esta manera imprimo un vector con los numeros que yo quiera meter dentro y en el orden que defina dentro de las llaves.

vector = np.arange(10)
print(vector)  # Resultado: [0 1 2 3 4 5 6 7 8 9]































print("Eliminando elemento de la posicion 0")
#Programa para eliminar un elemento al principio de un array
inputArr = [11, 21, 31, 41, 51, 61]
print("Antes de la eliminacion el array es: ")
for j in range(len(inputArr)):
    print(inputArr[j], end=" ")
#ELIMINANDO EL PRIMER ELEMENTO DE EL INPUTARR[0]
inputArr.pop(0)
print("\nDespues de la eliminacion, el array es: ")
for j in range(len(inputArr)):
    print(inputArr[j], end=" ")


print("                                            ")
print("                                            ")




























print("                                      ")
print("Eliminando elemento de la ultima posicion ")
#Eliminacion de el ultimo elmento de el vector
inputArr = [11, 21, 31, 41, 51, 61]
print("Antes de la eliminacion el array es: ")
for j in range(len(inputArr)):
    print(inputArr[j], end=" ")
#ELIMINANDO EL ULTIMO ELEMENTO
inputArr.pop()
print("\nDespues de la eliminacion, el array es: ")
for j in range(len(inputArr)):
    print(inputArr[j], end=" ")





print("                                      ")
print("                                      ")
#Algoritmo para la busqueda de elementos dentro de un array esta es una busqueda secuencial
def finEle(inputArr, s, targetEle):
    for j in range(s):
        if (inputArr[j] == targetEle): #aplicando la busqueda lineal
            return j # ELEMENTO ENCONTRADO EN EL INDICE J
    #No se encuentra el elmento objetivo
    return -1
if __name__== '__main__':
    inputArr = [12, 34, 10, 6, 40, 89, 98, 57, 19, 69]
    targetElement = 40
    s = len(inputArr)
    #Operacion de busqueda
    idx = finEle(inputArr, s, targetElement)
    if idx != -1:
        print("El elmento se encuentra en la posicion: " + str(idx+1))
    else:
        print("No se encuentra el elemento.")


print("            ")
print("matris de dos dimensioness")
#Matriz o array de dos dimensiones en python
TwoDimensionalArray = [
[1,2,3],
[4,5,6],
[7,8,9]
]
print("Los elementos del array son: ")
for row in TwoDimensionalArray:
    for element in row:
        print(element, end=" ") # mostrando los elementos de la fila separados por espacios
    print() #ir a la siguiente linea despues de mostar una fila
















print("            ")
print("matris de tres dimensioness")
#Implementación en Python
ThreeDimensionalArray = [
  [ [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
  ],
  [ [10, 11, 12],
    [13, 14, 15],
    [16, 17, 18]
  ]
]
print("Los elementos del array son: ")
for TwoDimensionalArray in ThreeDimensionalArray:
    for row in TwoDimensionalArray:
        for element in row:
            print(element, end=" ") # Mostrar los elementos de la fila separados por espacio
        print() # Ir a la siguiente línea después de mostrar una fila
