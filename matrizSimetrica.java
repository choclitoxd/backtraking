

public class matrizSimetrica {

    // Matriz definida
    int[][] matriz = {{1, 2, 3},
                      {2, 5, 6},
                      {8, 6, 9}};

    // Método para verificar si la matriz es simétrica
    public boolean esSimetrica() {
        int n = matriz.length;

        // Verificar si la matriz es cuadrada
        if (n == 0 || n != matriz[0].length) {
            return false;
        }

        // Iniciar recursividad
        return SimetricaRecursivo(matriz, 0, 0);
    }

    // Método recursivo para comprobar simetría
    private boolean SimetricaRecursivo(int[][] matriz, int fila, int columna) {
        // Si hemos recorrido todas las filas, la matriz es simétrica
        if (fila >= matriz.length) {
            return true;
        }

        // Comparar elementos fuera de la diagonal (debajo de la diagonal)
        if (columna < fila) {
            if (matriz[fila][columna] != matriz[columna][fila]) {
                return false;  // Si encontramos una diferencia, la matriz no es simétrica
            }
        }

        // Recursión para mover a la siguiente columna
        if (columna + 1 < matriz.length) {
            return SimetricaRecursivo(matriz, fila, columna + 1);
        } else {
            // Pasar a la siguiente fila cuando terminamos las columnas
            return SimetricaRecursivo(matriz, fila + 1, 0);
        }
    }

}

