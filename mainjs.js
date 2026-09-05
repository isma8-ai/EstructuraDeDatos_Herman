const matriz = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9]
];

console.log("Matriz recorrida de forma secuencial:");
for (let i = 0; i < matriz.length; i++) {
  let filaStr = "";
  for (let j = 0; j < matriz[i].length; j++) {
    filaStr += matriz[i][j] + " ";
  }
  console.log(filaStr);
}


//comandos para ejecucion
//node mainjs.js
