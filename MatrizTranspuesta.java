public class MatrizTranspuesta {
    public static int[][] matrizTranspuesta(int[][] matrizA, int[][] matrizB,int x, int y) {
        if (x == matrizA.length) {
            return matrizB;
        }
        if (y == matrizA[0].length) {
            return matrizTranspuesta(matrizA, matrizB, x + 1, 0);
        }

        // Sumar los elementos correspondientes y almacenarlos en la matrizC
        matrizB[y][x] = matrizA[x][y];

        // Llamada recursiva para la siguiente columna de la misma fila
        return matrizTranspuesta(matrizA, matrizB, x, y + 1);
        
    }
    

    // Función para imprimir una matriz
    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Definir dos matrices de ejemplo
        int[][] matrizA = {
            {1, 2},
            {3, 2},
            {5, 6},
            {7, 8},
        };
        int[][] matrizB = new int[ matrizA[0].length][matrizA.length];

        imprimirMatriz(matrizTranspuesta(matrizA, matrizB, 0, 0));
        
    }
}
