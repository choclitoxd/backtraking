public class Matriz {
    public static void crearMatriz(int[][] matrizA, int[][] matrizB){
        int[][] matrizC = new int[matrizA.length][matrizB[0].length];
        System.out.println("Resultado de la suma de las matrices:");
        imprimirMatriz(sumarMatrices(matrizC,matrizA,matrizB,0,0));
        System.out.println("Resultado de la restaoy de las matrices:");
        imprimirMatriz(restarMatrices(matrizC,matrizA,matrizB,0,0));
    };
    public static int[][] sumarMatrices(int[][] matrizC,int[][] matrizA, int[][] matrizB,int x, int y) {
        if (x == matrizA.length) {
            return matrizC;
        }
        if (y == matrizA[0].length) {
            return sumarMatrices(matrizC, matrizA, matrizB, x + 1, 0);
        }

        // Sumar los elementos correspondientes y almacenarlos en la matrizC
        matrizC[x][y] = matrizA[x][y] + matrizB[x][y];

        // Llamada recursiva para la siguiente columna de la misma fila
        return sumarMatrices(matrizC, matrizA, matrizB, x, y + 1);
        
    }
    public static int[][] restarMatrices(int[][] matrizC,int[][] matrizA, int[][] matrizB,int x, int y) {
        if (x == matrizA.length) {
            return matrizC;
        }
        if (y == matrizA[0].length) {
            return restarMatrices(matrizC, matrizA, matrizB, x + 1, 0);
        }

        // Sumar los elementos correspondientes y almacenarlos en la matrizC
        matrizC[x][y] = matrizA[x][y] - matrizB[x][y];

        // Llamada recursiva para la siguiente columna de la misma fila
        return restarMatrices(matrizC, matrizA, matrizB, x, y + 1);
        
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
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] matrizB = {
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
        };

        // Sumar las matrices
        crearMatriz(matrizA, matrizB);

        // Imprimir la matriz resultante
        
    }
}
