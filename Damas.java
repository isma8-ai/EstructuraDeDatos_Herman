//Juego de Damas inglesas en lenguaje de programación Java
// Projecto: Profe Herman
// Alumno: Ismael ELiseo Chavez Anaya


//Requerimientos de el juego de damas inglesas:
// 1: Tablero de 8x8
// 2: Dos jugadores
// 3: Colocacion inicial
// 4: Mostrar el tablero
// 5: Seleccionar una ficha
// 6: Moverla
// 7: Validar Movimientos
// 8: Capturar Fichas
// 9: Convertir una ficha en dama cuando llegue al otro extremo de el tableero
// 10: Detectar cuando termina la partida
// 11: De ser posible interfaz grafica con swing
// 12: El Profe pidio un log de todos los movimientos que se hicieron en el juego

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Damas {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        char[][] tablero = new char[8][8];

        // ==========================================
        // INICIALIZAR TABLERO
        // ==========================================

        for (int fila = 0; fila < 8; fila++) {

            for (int columna = 0; columna < 8; columna++) {

                tablero[fila][columna] = ' ';
            }
        }

        colocarFichas(tablero);

        // Comienzan las negras
        char jugadorActual = 'n';

        // ==========================================
        // BUCLE PRINCIPAL
        // ==========================================

        while (true) {

            mostrarTablero(tablero);

            // ==========================================
            // COMPROBAR SI TERMINÓ LA PARTIDA
            // ==========================================

            if (juegoTerminado(tablero, jugadorActual)) {

                System.out.println();
                System.out.println("================================");
                System.out.println("       ¡FIN DE LA PARTIDA!");
                System.out.println("================================");

                char ganador = ganador(tablero, jugadorActual);

                if (ganador == 'n') {

                    System.out.println("¡GANARON LAS NEGRAS!");

                } else if (ganador == 'b') {

                    System.out.println("¡GANARON LAS BLANCAS!");
                }

                break;
            }

            System.out.println();

            System.out.println(
                    "Turno de las "
                    + (jugadorActual == 'n'
                    ? "NEGRAS"
                    : "BLANCAS"));

            System.out.println(
                    "Escribe -1 para salir.");

            // ==========================================
            // COMPROBAR CAPTURA OBLIGATORIA
            // ==========================================

            boolean capturaObligatoria =
                    existeCaptura(tablero, jugadorActual);

            if (capturaObligatoria) {

                System.out.println(
                        "¡TIENES UNA CAPTURA OBLIGATORIA!");
            }

            // ==========================================
            // SELECCIONAR FICHA
            // ==========================================

            System.out.print(
                    "Selecciona la fila de la ficha: ");

            int filaOrigen = entrada.nextInt();

            if (filaOrigen == -1) {
                break;
            }

            System.out.print(
                    "Selecciona la columna de la ficha: ");

            int columnaOrigen = entrada.nextInt();

            if (columnaOrigen == -1) {
                break;
            }

            // ==========================================
            // COMPROBAR POSICIÓN
            // ==========================================

            if (!posicionValida(
                    filaOrigen,
                    columnaOrigen)) {

                System.out.println(
                        "Posición fuera del tablero.");

                continue;
            }

            // ==========================================
            // COMPROBAR EXISTENCIA DE FICHA
            // ==========================================

            if (tablero[filaOrigen][columnaOrigen] == ' ') {

                System.out.println(
                        "No hay ninguna ficha ahí.");

                continue;
            }

            // ==========================================
            // COMPROBAR DUEÑO
            // ==========================================

            if (!esFichaDelJugador(
                    tablero[filaOrigen][columnaOrigen],
                    jugadorActual)) {

                System.out.println(
                        "Esa ficha pertenece al otro jugador.");

                continue;
            }

            // ==========================================
            // SI HAY CAPTURA OBLIGATORIA
            // LA FICHA DEBE PODER CAPTURAR
            // ==========================================

            if (capturaObligatoria
                    && !fichaPuedeCapturar(
                    tablero,
                    filaOrigen,
                    columnaOrigen,
                    jugadorActual)) {

                System.out.println(
                        "Debes seleccionar una ficha "
                        + "que pueda capturar.");

                continue;
            }

            System.out.println(
                    "Ficha seleccionada correctamente.");

            // ==========================================
            // CAPTURAS MÚLTIPLES
            // ==========================================

            boolean continuarCapturando = true;

            int filaActual = filaOrigen;
            int columnaActual = columnaOrigen;

            while (continuarCapturando) {

                // ==========================================
                // DESTINO
                // ==========================================

                System.out.print(
                        "Selecciona la fila destino: ");

                int filaDestino = entrada.nextInt();

                if (filaDestino == -1) {
                    continuarCapturando = false;
                    break;
                }

                System.out.print(
                        "Selecciona la columna destino: ");

                int columnaDestino = entrada.nextInt();

                if (columnaDestino == -1) {
                    continuarCapturando = false;
                    break;
                }

                // ==========================================
                // VALIDAR MOVIMIENTO
                // ==========================================

                if (!movimientoValido(
                        tablero,
                        filaActual,
                        columnaActual,
                        filaDestino,
                        columnaDestino,
                        jugadorActual)) {

                    System.out.println(
                            "Movimiento no válido.");

                    continue;
                }

                // ==========================================
                // SABER SI ES CAPTURA
                // ==========================================

                boolean captura = esCaptura(
                        filaActual,
                        columnaActual,
                        filaDestino,
                        columnaDestino);

                char fichaMovida =
                        tablero[filaActual][columnaActual];

                // ==========================================
                // REALIZAR MOVIMIENTO
                // ==========================================

                if (captura) {

                    capturarFicha(
                            tablero,
                            filaActual,
                            columnaActual,
                            filaDestino,
                            columnaDestino);

                    System.out.println(
                            "¡Ficha capturada!");

                } else {

                    moverFicha(
                            tablero,
                            filaActual,
                            columnaActual,
                            filaDestino,
                            columnaDestino);

                    System.out.println(
                            "Movimiento realizado correctamente.");
                }

                // ==========================================
                // CORONACIÓN
                // ==========================================

                coronarFicha(
                        tablero,
                        filaDestino,
                        columnaDestino,
                        jugadorActual);

                // ==========================================
                // GUARDAR EN LOG
                // ==========================================

                guardarMovimiento(
                        jugadorActual,
                        fichaMovida,
                        filaActual,
                        columnaActual,
                        filaDestino,
                        columnaDestino,
                        captura);

                // ==========================================
                // COMPROBAR OTRA CAPTURA
                // ==========================================

                if (captura
                        && fichaPuedeCapturar(
                        tablero,
                        filaDestino,
                        columnaDestino,
                        jugadorActual)) {

                    System.out.println();
                    System.out.println(
                            "¡Puedes realizar otra captura!");

                    filaActual = filaDestino;
                    columnaActual = columnaDestino;

                    continuarCapturando = true;

                } else {

                    continuarCapturando = false;
                }
            }

            // ==========================================
            // CAMBIAR JUGADOR
            // ==========================================

            if (!continuarCapturando) {

                if (jugadorActual == 'n') {

                    jugadorActual = 'b';

                } else {

                    jugadorActual = 'n';
                }
            }
        }

        entrada.close();
    }


    // ==========================================
    // COLOCAR FICHAS
    // ==========================================

    static void colocarFichas(char[][] tablero) {

        for (int fila = 0; fila < 8; fila++) {

            for (int columna = 0; columna < 8; columna++) {

                if ((fila + columna) % 2 == 1) {

                    if (fila < 3) {

                        tablero[fila][columna] = 'n';
                    }

                    if (fila > 4) {

                        tablero[fila][columna] = 'b';
                    }
                }
            }
        }
    }


    // ==========================================
    // POSICIÓN VÁLIDA
    // ==========================================

    static boolean posicionValida(
            int fila,
            int columna) {

        return fila >= 0
                && fila < 8
                && columna >= 0
                && columna < 8;
    }


    // ==========================================
    // COMPROBAR DUEÑO
    // ==========================================

    static boolean esFichaDelJugador(
            char ficha,
            char jugadorActual) {

        if (jugadorActual == 'n') {

            return ficha == 'n'
                    || ficha == 'N';

        } else {

            return ficha == 'b'
                    || ficha == 'B';
        }
    }


    // ==========================================
    // VALIDAR MOVIMIENTO
    // ==========================================

    static boolean movimientoValido(
            char[][] tablero,
            int filaOrigen,
            int columnaOrigen,
            int filaDestino,
            int columnaDestino,
            char jugadorActual) {

        // Destino dentro del tablero
        if (!posicionValida(
                filaDestino,
                columnaDestino)) {

            return false;
        }

        // Destino vacío
        if (tablero[filaDestino][columnaDestino] != ' ') {

            return false;
        }

        int diferenciaFila =
                Math.abs(filaDestino - filaOrigen);

        int diferenciaColumna =
                Math.abs(columnaDestino - columnaOrigen);

        char ficha =
                tablero[filaOrigen][columnaOrigen];

        // ==========================================
        // MOVIMIENTO NORMAL
        // ==========================================

        if (diferenciaFila == 1
                && diferenciaColumna == 1) {

            // Damas
            if (ficha == 'N'
                    || ficha == 'B') {

                return true;
            }

            // Negras avanzan hacia abajo
            if (ficha == 'n'
                    && jugadorActual == 'n'
                    && filaDestino > filaOrigen) {

                return true;
            }

            // Blancas avanzan hacia arriba
            if (ficha == 'b'
                    && jugadorActual == 'b'
                    && filaDestino < filaOrigen) {

                return true;
            }
        }

        // ==========================================
        // CAPTURA
        // ==========================================

        if (diferenciaFila == 2
                && diferenciaColumna == 2) {

            int filaMedio =
                    (filaOrigen + filaDestino) / 2;

            int columnaMedio =
                    (columnaOrigen + columnaDestino) / 2;

            char fichaMedio =
                    tablero[filaMedio][columnaMedio];

            // Negras comen blancas
            if (jugadorActual == 'n'
                    && (fichaMedio == 'b'
                    || fichaMedio == 'B')) {

                return true;
            }

            // Blancas comen negras
            if (jugadorActual == 'b'
                    && (fichaMedio == 'n'
                    || fichaMedio == 'N')) {

                return true;
            }
        }

        return false;
    }


    // ==========================================
    // SABER SI ES CAPTURA
    // ==========================================

    static boolean esCaptura(
            int filaOrigen,
            int columnaOrigen,
            int filaDestino,
            int columnaDestino) {

        return Math.abs(
                filaDestino - filaOrigen) == 2
                &&
                Math.abs(
                columnaDestino - columnaOrigen) == 2;
    }


    // ==========================================
    // MOVER FICHA
    // ==========================================

    static void moverFicha(
            char[][] tablero,
            int filaOrigen,
            int columnaOrigen,
            int filaDestino,
            int columnaDestino) {

        tablero[filaDestino][columnaDestino]
                = tablero[filaOrigen][columnaOrigen];

        tablero[filaOrigen][columnaOrigen] = ' ';
    }


    // ==========================================
    // CAPTURAR FICHA
    // ==========================================

    static void capturarFicha(
            char[][] tablero,
            int filaOrigen,
            int columnaOrigen,
            int filaDestino,
            int columnaDestino) {

        int filaMedio =
                (filaOrigen + filaDestino) / 2;

        int columnaMedio =
                (columnaOrigen + columnaDestino) / 2;

        // Mover ficha
        tablero[filaDestino][columnaDestino]
                = tablero[filaOrigen][columnaOrigen];

        // Eliminar ficha enemiga
        tablero[filaMedio][columnaMedio] = ' ';

        // Vaciar origen
        tablero[filaOrigen][columnaOrigen] = ' ';
    }


    // ==========================================
    // COMPROBAR SI UNA FICHA PUEDE CAPTURAR
    // ==========================================

    static boolean fichaPuedeCapturar(
            char[][] tablero,
            int fila,
            int columna,
            char jugador) {

        int[] movimientosFila =
                {-2, -2, 2, 2};

        int[] movimientosColumna =
                {-2, 2, -2, 2};

        for (int i = 0; i < 4; i++) {

            int filaDestino =
                    fila + movimientosFila[i];

            int columnaDestino =
                    columna + movimientosColumna[i];

            if (movimientoValido(
                    tablero,
                    fila,
                    columna,
                    filaDestino,
                    columnaDestino,
                    jugador)) {

                return true;
            }
        }

        return false;
    }


    // ==========================================
    // COMPROBAR SI EXISTE CAPTURA
    // ==========================================

    static boolean existeCaptura(
            char[][] tablero,
            char jugador) {

        for (int fila = 0; fila < 8; fila++) {

            for (int columna = 0; columna < 8; columna++) {

                if (esFichaDelJugador(
                        tablero[fila][columna],
                        jugador)) {

                    if (fichaPuedeCapturar(
                            tablero,
                            fila,
                            columna,
                            jugador)) {

                        return true;
                    }
                }
            }
        }

        return false;
    }


    // ==========================================
    // CORONAR
    // ==========================================

    static void coronarFicha(
            char[][] tablero,
            int filaDestino,
            int columnaDestino,
            char jugadorActual) {

        // Negra llega a fila 7
        if (jugadorActual == 'n'
                && filaDestino == 7
                && tablero[filaDestino][columnaDestino] == 'n') {

            tablero[filaDestino][columnaDestino] = 'N';

            System.out.println(
                    "¡La ficha negra se convirtió en DAMA!");
        }

        // Blanca llega a fila 0
        if (jugadorActual == 'b'
                && filaDestino == 0
                && tablero[filaDestino][columnaDestino] == 'b') {

            tablero[filaDestino][columnaDestino] = 'B';

            System.out.println(
                    "¡La ficha blanca se convirtió en DAMA!");
        }
    }


    // ==========================================
    // GUARDAR MOVIMIENTO
    // ==========================================

    static void guardarMovimiento(
            char jugador,
            char ficha,
            int filaOrigen,
            int columnaOrigen,
            int filaDestino,
            int columnaDestino,
            boolean captura) {

        try {

            FileWriter archivo =
                    new FileWriter(
                            "log.txt",
                            true);

            String jugadorTexto;

            if (jugador == 'n') {

                jugadorTexto = "NEGRAS";

            } else {

                jugadorTexto = "BLANCAS";
            }

            archivo.write(
                    jugadorTexto
                    + " | Ficha: " + ficha
                    + " | De: ("
                    + filaOrigen
                    + ","
                    + columnaOrigen
                    + ")"
                    + " | A: ("
                    + filaDestino
                    + ","
                    + columnaDestino
                    + ")"
                    + " | "
                    + (captura
                    ? "CAPTURA"
                    : "MOVIMIENTO")
                    + "\n");

            archivo.close();

        } catch (IOException e) {

            System.out.println(
                    "No se pudo guardar el movimiento.");
        }
    }


    // ==========================================
    // CONTAR FICHAS
    // ==========================================

    static int contarFichas(
            char[][] tablero,
            char jugador) {

        int contador = 0;

        for (int fila = 0; fila < 8; fila++) {

            for (int columna = 0; columna < 8; columna++) {

                char ficha =
                        tablero[fila][columna];

                if (jugador == 'n'
                        && (ficha == 'n'
                        || ficha == 'N')) {

                    contador++;
                }

                if (jugador == 'b'
                        && (ficha == 'b'
                        || ficha == 'B')) {

                    contador++;
                }
            }
        }

        return contador;
    }


    // ==========================================
    // COMPROBAR SI EL JUGADOR TIENE MOVIMIENTOS
    // ==========================================

    static boolean tieneMovimientos(
            char[][] tablero,
            char jugador) {

        for (int fila = 0; fila < 8; fila++) {

            for (int columna = 0; columna < 8; columna++) {

                if (esFichaDelJugador(
                        tablero[fila][columna],
                        jugador)) {

                    // Revisar movimientos normales
                    int[] movimientosFila =
                            {-1, -1, 1, 1};

                    int[] movimientosColumna =
                            {-1, 1, -1, 1};

                    for (int i = 0; i < 4; i++) {

                        int filaDestino =
                                fila + movimientosFila[i];

                        int columnaDestino =
                                columna + movimientosColumna[i];

                        if (movimientoValido(
                                tablero,
                                fila,
                                columna,
                                filaDestino,
                                columnaDestino,
                                jugador)) {

                            return true;
                        }
                    }

                    // Revisar capturas
                    int[] capturasFila =
                            {-2, -2, 2, 2};

                    int[] capturasColumna =
                            {-2, 2, -2, 2};

                    for (int i = 0; i < 4; i++) {

                        int filaDestino =
                                fila + capturasFila[i];

                        int columnaDestino =
                                columna + capturasColumna[i];

                        if (movimientoValido(
                                tablero,
                                fila,
                                columna,
                                filaDestino,
                                columnaDestino,
                                jugador)) {

                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }


    // ==========================================
    // COMPROBAR FIN DEL JUEGO
    // ==========================================

    static boolean juegoTerminado(
            char[][] tablero,
            char jugadorActual) {

        // No tiene fichas
        if (contarFichas(
                tablero,
                jugadorActual) == 0) {

            return true;
        }

        // Tiene fichas pero no puede mover
        if (!tieneMovimientos(
                tablero,
                jugadorActual)) {

            return true;
        }

        return false;
    }


    // ==========================================
    // DETERMINAR GANADOR
    // ==========================================

    static char ganador(
            char[][] tablero,
            char jugadorActual) {

        if (jugadorActual == 'n') {

            return 'b';

        } else {

            return 'n';
        }
    }


    // ==========================================
    // MOSTRAR TABLERO
    // ==========================================

    static void mostrarTablero(
            char[][] tablero) {

        System.out.println();

        System.out.println(
                "    0   1   2   3   4   5   6   7");

        for (int fila = 0; fila < 8; fila++) {

            System.out.print(fila + " ");

            for (int columna = 0;
                    columna < 8;
                    columna++) {

                System.out.print(
                        "[" + tablero[fila][columna] + "]");
            }

            System.out.println();
        }
    }
}
