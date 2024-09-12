import java.util.ArrayList;

public class PrimosPerfectos {
    public static ArrayList<ArrayList<Integer>> matrizPrimosPerfectos(int[][] matrizA,int x, int y,ArrayList<Integer> primos, ArrayList<Integer> perfectos) {
        if (x < 0) {
            ArrayList<ArrayList<Integer>> primosPerfectosList = new ArrayList<>();
            primosPerfectosList.add(perfectos);
            primosPerfectosList.add(primos);
            return primosPerfectosList;
        }
        if (y == matrizA[0].length) {
            return matrizPrimosPerfectos(matrizA, x - 1, 0,primos,perfectos);
        }

        // Sumar los elementos correspondientes y almacenarlos en la matrizC
        if (esPrimo(matrizA[x][y])) {
            primos.add(matrizA[x][y]);
        }
        if (esPerfecto(matrizA[x][y])) {
            perfectos.add(matrizA[x][y]);
        }

        // Llamada recursiva para la siguiente columna de la misma fila
        return matrizPrimosPerfectos(matrizA, x, y + 1,primos,perfectos);
        
    }
    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean esPerfecto(int numero) {
        if (numero <= 1) {
            return false;
        }
        int suma = 1;
        for (int i = 2; i <= numero / 2; i++) {
            if (numero % i == 0) {
                suma += i;
            }
        }
        return suma == numero;
    }


    // Función para imprimir una matriz
    public static void imprimirArrayListConArraylist(ArrayList<ArrayList<Integer>> contenedor, int i, int j) {
        // Condición de parada para las filas
        if (i == contenedor.size()) {
            return;
        }
    
        // Condición de parada para las columnas y cambio de fila
        if (j == contenedor.get(i).size()) {
            System.out.println(); // Salto de línea al terminar una fila
            imprimirArrayListConArraylist(contenedor, i + 1, 0);
            return;
        }
    
        // Imprimir el elemento actual
        System.out.print(contenedor.get(i).get(j) + " ");
        
        // Continuar con el siguiente elemento de la fila
        imprimirArrayListConArraylist(contenedor, i, j + 1);
    }

    public static void main(String[] args) {
        // Definir dos matrices de ejemplo
        int[][] matrizA = {
            {5, 7,1,3},
            {6, 45,13,89},
            {2, 28,496,8128},
            {31,37,43,10},
        };
        ArrayList<Integer> primos = new ArrayList<>();
        ArrayList<Integer> perfectos = new ArrayList<>();
        imprimirArrayListConArraylist(matrizPrimosPerfectos(matrizA,matrizA.length - 1, 0,primos,perfectos),0,0);
        
    }
}
