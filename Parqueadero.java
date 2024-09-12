public class Parqueadero {
    public String[][]parqueaderoU = {
        { "L"," ","L","D","R1","L"," "},
        { "L"," ","L","C"," ", "L"," "},
        { " "," "," ","C"," ", " "," "},
        { "C"," "," ","C","D", "D"," "},
        { "C"," "," "," "," ", "L"," "},
        { "C"," ","C"," "," ", "L"," "},
        { "C"," ","C"," ","C", "C"," "},
        { " "," ","C"," "," ", " "," "},
        { "C"," ","C"," ","C", " ", "C"},
        { "C"," ","R"," ","C", " ", "R"},
        { " "," ","R"," ","C", "C", "R"},
        { "E"," ","R"," "," ", " ", "R2"}
};

/* --------------------- PRUEBA DEL ALGORITMO --------------------- */
public static void main(String[] args) {
    Parqueadero m = new Parqueadero(); // construimos un objeto de la clase Laberinto por defecto
    m.resuelve(11, 0);
    String resultado = m.imprimirLaberintoRecursivo(0, 0); // ahora, introducimos la entrada (S) en las coordenadas											// (8,1) y llamamos al algoritmo
    System.out.println(resultado); // imprimimos el laberinto ya resuelto (si tiene solución)
}

/* ----------------- IMPLEMENTACIÓN DEL ALGORITMO ----------------- */
public void resuelve(int x, int y) { // permite introducir unas coordenadas (x, y)
    if (paso(x, y)) { // intentará resolver el laberinto en estas coordenadas
        parqueaderoU[x][y] = "P"; // introduce en las coordenadas (x, y) la entrada
    }
}

private boolean paso(int x, int y) {

    boolean result; // se coloca S de START)

    result = validarPaso(x, y + 1); // intentamos ir hacia la DERECHA. Primera llamada recursiva
    if (result)
        return true;
    
    result = validarPaso(x - 1, y); // intentamos ir hacia ARRIBA. Segunda llamada recursiva
    if (result)
        return true;
    result = validarPaso(x + 1, y); // intentamos ir hacia ABAJO. Cuarta llamada recursiva
    if (result)
        return true;
    result = validarPaso(x, y - 1); // intentamos ir hacia la IZQUIERDA. Tercera llamada recursiva
    if (result)
        return true;

    

    // si no hemos encontrado la solución en estos cuatros movimientos, volvemos
    // atrás, aunque hay que
    // considerar que en este punto, todas las llamadas recursivas han finalizado.
    // Si en ninguna de ellas
    // se ha conseguido el éxito, entonces el algoritmo termina y devuelve false.
    parqueaderoU[x][y] = "f"; // en el caso de no ser el resultado, se marca con +. Ya fue pisado
    return false;
}

private boolean validarPaso(int x, int y) {
    String palabra = "LCEPRDf*";
    if (x  < 0 || y < 0 || x == parqueaderoU.length|| y == parqueaderoU[0].length) {
        return false;
    }
    if (palabra.contains(parqueaderoU[x][y])) { // Si encontramos una pared o un punto no válido
        return false;
    }
    if (parqueaderoU[x][y].equals("R1") || parqueaderoU[x][y].equals("R2") ) {
        parqueaderoU[x][y] = "P";
        if (zonaParqueo(0, 0)) {
            limpiarParqueaderoU(0, 0);
            imprimirParqueadero();
            validarPasoDevuelta(x, y);
        }else{
            limpiarParqueaderoU(0, 0);
            return true;
        }
    }


    // si no se cumple ninguna de estas dos situaciones, quiere decir que nos
    // encontramos en un
    // caso intermedio, por lo tanto, que empezamos a recorrer o todavía no hemos
    // llegado a nada
    parqueaderoU[x][y] = "*"; // marcamos la posición como visitada (si es la primera, en las coordenadas x e
                            // y
    paso(x, y);
    return false;

}
private boolean zonaParqueo(int x, int y){
    if (x == parqueaderoU.length) {
        return false;
    }
    if (y == parqueaderoU[0].length) {
        return zonaParqueo(x + 1, 0);
    }
    if (parqueaderoU[x][y].equals("R1") || parqueaderoU[x][y].equals("R2")){
        return true;
    }
    return zonaParqueo(x, y+1);

}
private boolean validarPasoDevuelta(int x, int y){
    String palbra = "LCPRDf*";
    if (x  < 0 || y < 0 || x == parqueaderoU.length|| y == parqueaderoU[0].length) {
        return false;
    }
    if (parqueaderoU[x][y].contains(palbra)) { // si llegamos a una pared o																// al mismo punto,
        return false; // entonces el laberinto no puede resolverse y termina.
    }if (parqueaderoU[x][y].equals("E")) {
        resuelve(x, y);
    }
    

    // si no se cumple ninguna de estas dos situaciones, quiere decir que nos
    // encontramos en un
    // caso intermedio, por lo tanto, que empezamos a recorrer o todavía no hemos
    // llegado a nada
    parqueaderoU[x][y] = "*"; // marcamos la posición como visitada (si es la primera, en las coordenadas x e
                            // y
    paso(x, y);
    return false;
}
private void imprimirParqueadero() {
    for (int i = 0; i < parqueaderoU.length; i++) {
        for (int j = 0; j < parqueaderoU[i].length; j++) {
            System.out.print(parqueaderoU[i][j] + " ");
        }
        System.out.println(); // Salto de línea después de cada fila
    }
    System.out.println(); // Espacio extra entre impresiones
}
private void limpiarParqueaderoU(int x, int y){
    String palabra = "f*";
    if (x == parqueaderoU.length) {
        return;
    }
    if (y == parqueaderoU[0].length) {
        limpiarParqueaderoU( x + 1, 0);
        return;
    }
    if (palabra.contains(parqueaderoU[x][y])) {
        parqueaderoU[x][y] = " ";
    }
    limpiarParqueaderoU(x, y + 1);
}
private String imprimirLaberintoRecursivo(int x, int y) {
    if (x == parqueaderoU.length) {
        return "";
    }

    // Caso base: si la columna supera el tamaño de las columnas, pasa a la
    // siguiente fila
    if (y == parqueaderoU[x].length) {
        return "\n" + imprimirLaberintoRecursivo(x + 1, 0); // Salto de línea para la nueva fila
    }

    // Imprime el elemento actual y llama recursivamente para el siguiente elemento
    return parqueaderoU[x][y] + " " + imprimirLaberintoRecursivo(x, y + 1);
}
}
