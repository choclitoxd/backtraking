public class MatrizSumaNumero {
    public static void main(String[] args) {
        String [][] matrizNumeros= {
                {"454" ,"1010", "4141", "4444", "234"},
                {"100", "2163", "5456", "222", "444"},
                {"1001", "0", "99", "111", "5654"},
                {"13", "89", "6", "112", "555"}
        };

        int i = 0;
        int j = 0;
        List<String> listaNumeros= new ArrayList<>();
        recorrerMatriz(matrizNumeros, matrizNumeros.length-1, j,listaNumeros);
    }

    private static void recorrerMatriz(String[][] matrizNumeros, int i, int j, List<String> listaNumeros) {


        if (i < 0) {
            System.out.println("Lista de Numeros: ");
            imprimirMatrizNumeros(listaNumeros, 0);
            return;
        }
        if (j == matrizNumeros[0].length) {
            recorrerMatriz(matrizNumeros, i - 1, 0, listaNumeros);
        }else {
            if (verificarSumaNumeros(matrizNumeros[i][j], 0, 0)){
                listaNumeros.add(matrizNumeros[i][j]);
            }
            recorrerMatriz(matrizNumeros, i, j + 1, listaNumeros);

        }


    }

    public static boolean verificarSumaNumeros(String numero, int indice, int suma) {

        if (indice == numero.length()) {
            return false;
        }
        suma = suma + Character.getNumericValue(numero.charAt(indice));
        if (suma >= 10) {
            return true;
        }
        return verificarSumaNumeros(numero, indice + 1, suma);
    }

    private static void imprimirMatrizNumeros(List<String> lista, int i) {
        if (i == lista.size()) {
            System.out.println(" ");
            return;
        }
        System.out.print(lista.get(i) + ", ");
        imprimirMatrizNumeros(lista, i + 1);
    }
}
