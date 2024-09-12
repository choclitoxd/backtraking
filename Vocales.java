import java.util.ArrayList;

public class Vocales{

    public static ArrayList<String> VocalesArrayList(String[][] palabraVocales,int x, int y,ArrayList<String> palabras) {
        if (x == palabraVocales.length) {
            return palabras;
        }
        if (y == palabraVocales[0].length) {
            return VocalesArrayList(palabraVocales, x + 1, 0,palabras);
        }

        // Sumar los elementos correspondientes y almacenarlos en la matrizC
        if (ContadorVocales(palabraVocales[x][y], 0) >= 1) {
            palabras.add(palabraVocales[x][y]);
        }
        // Llamada recursiva para la siguiente columna de la misma fila
        return VocalesArrayList(palabraVocales,x,y+1,palabras);
        
    }
    public static int ContadorVocales(String palabra, int i){
        String vocales = "aeiou";
        if (i == palabra.length()-1) {
            return 0;
        }
        if (vocales.indexOf(palabra.charAt(i)) != -1 &&vocales.indexOf(palabra.charAt(i + 1)) != -1) {
            return ContadorVocales(palabra,i+1) + 1;
        }
        return ContadorVocales(palabra, i + 1);
    }


    // Función para imprimir una matriz
    public static String imprimirArrayList(ArrayList<String> palabras, int i) {
        // Condición de parada: cuando i llega al tamaño del ArrayList, terminamos
        if (i == palabras.size()) {
            return "";
        }
        
        // Concatenar el elemento actual con el resultado de las llamadas recursivas
        return palabras.get(i) + " " + imprimirArrayList(palabras, i + 1);
    }

    public static void main(String[] args) {
        // Definir dos matrices de ejemplo
        String[][] vocales = {
            {"vacio", "carro", "baul", "perro"},
            {"colombia", "casa", "moto", "caza"},
            {"llanta", "reir", "archivo","silla"},
            {"cocina","ola", "ave","freir"}
        };
        ArrayList<String> palbras= new ArrayList<>();
        
        System.out.println(imprimirArrayList(VocalesArrayList(vocales, 0, 0, palbras),0));

    }
}
