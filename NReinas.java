import java.util.ArrayList;
import java.util.List;

public class NReinas {
    // Tablero de ajedrez 8x8
    public char[][] tableroAjedrez = {
        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }
};

// Lista para almacenar todas las soluciones encontradas
private List<String> soluciones = new ArrayList<>();

// Método principal
public static void main(String[] args) {
    NReinas m = new NReinas();
    m.resuelve(0); // Intenta resolver a partir de la fila 0
    
    for (String solucion : m.soluciones) {
        System.out.println(solucion);
    }
    System.out.println("Soluciones encontradas: " + m.soluciones.size());
}

// Método para iniciar la resolución
public void resuelve(int fila) {
    colocarReinas(fila, 0); // Comenzamos a intentar colocar reinas desde la fila 0
}

// Función recursiva para colocar reinas
public boolean colocarReinas(int fila, int col) {
    // Caso base: Si hemos colocado todas las reinas, almacenamos la solución
    if (fila == 8) {
        soluciones.add(imprimirtableroAjedrezRecursivo(0, 0)); // Añadir la solución al final
        return false; // Seguimos buscando más soluciones
    }

    // Si llegamos al final de las columnas sin éxito, retrocedemos
    if (col == 8) {
        return false;
    }

    // Intentar colocar una reina en la columna actual
    if (esPosicionSegura(fila, col)) {
        tableroAjedrez[fila][col] = 'Q'; // Colocamos la reina

        // Intentamos colocar la reina en la siguiente fila
        colocarReinas(fila + 1, 0); // Reinicia las columnas para la nueva fila

        // Si no encontramos una solución, retiramos la reina (backtracking)
        tableroAjedrez[fila][col] = 'X'; // Retiramos la reina y probamos la siguiente columna
    }

    // Continuar probando la siguiente columna en la fila actual
    return colocarReinas(fila, col + 1);
}

// Verificar si es seguro colocar una reina en la fila y columna dadas
public boolean esPosicionSegura(int fila, int col) {
    return verificarSeguridad(fila, col, fila - 1); // Comienza verificando desde la fila anterior
}

private boolean verificarSeguridad(int fila, int col, int i) {
    // Caso base: si hemos revisado todas las filas anteriores y no hay conflictos
    if (i < 0) {
        return true;
    }

    // Verificar la misma columna o diagonales
    if (tableroAjedrez[i][col] == 'Q' || 
        (col - (fila - i) >= 0 && tableroAjedrez[i][col - (fila - i)] == 'Q') || 
        (col + (fila - i) < 8 && tableroAjedrez[i][col + (fila - i)] == 'Q')) {
        return false;
    }

    // Llamada recursiva para verificar la siguiente fila anterior
    return verificarSeguridad(fila, col, i - 1);
}

// Función recursiva para imprimir el tablero en forma de string
private String imprimirtableroAjedrezRecursivo(int x, int y) {
    if (x == tableroAjedrez.length) {
        return "";
    }

    // Caso base: si la columna supera el tamaño de las columnas, pasa a la siguiente fila
    if (y == tableroAjedrez[x].length) {
        return "\n" + imprimirtableroAjedrezRecursivo(x + 1, 0); // Salto de línea para la nueva fila
    }

    // Imprime el elemento actual y llama recursivamente para el siguiente elemento
    return tableroAjedrez[x][y] + " " + imprimirtableroAjedrezRecursivo(x, y + 1);
}
}
