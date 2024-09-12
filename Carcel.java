

public class Carcel {

	public char[][] preso = {
			{ ' ',' ','P', 'X',' ', ' ', ' ', 'P', },
			{ ' ',' ','P', 'P',' ', ' ', ' ', 'P', },
			{ ' ',' ',' ', ' ',' ', ' ', ' ', ' ', },
			{ 'P',' ','P', 'P',' ', 'P', 'P', ' ', },
			{ 'P',' ','X', 'P',' ', 'P', 'P', ' ', },
			{ ' ',' ',' ', ' ',' ', ' ', ' ', ' ', },
			{ 'P',' ','X','P',' ', 'P', 'P', 'P', },
	};

	/* --------------------- PRUEBA DEL ALGORITMO --------------------- */
	public static void main(String[] args) {
		Carcel m = new Carcel(); // construimos un objeto de la clase Laberinto por defecto
		m.resuelve(0, 0);
		String resultado = m.imprimirLaberintoRecursivo(0, 0); // ahora, introducimos la entrada (S) en las coordenadas
		m.preso[5][7] = 'G';													// (8,1) y llamamos al algoritmo
		System.out.println(resultado); // imprimimos el laberinto ya resuelto (si tiene solución)
		System.out.println("Cuantos escaparon " + m.contador);
	}

	/* ----------------- IMPLEMENTACIÓN DEL ALGORITMO ----------------- */
	public void resuelve(int x, int y) { // permite introducir unas coordenadas (x, y)
		if (paso(x, y)) { // intentará resolver el laberinto en estas coordenadas
			preso[x][y] = 'S'; // introduce en las coordenadas (x, y) la entrada
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
		preso[x][y] = 'f'; // en el caso de no ser el resultado, se marca con +. Ya fue pisado
		return false;
	}

	private boolean validarPaso(int x, int y) {
		if (x  < 0 || y < 0 || x == 7|| y == 8) {
			return false;
		}
		if (preso[x][y] == 'G') { // si hemos llegado a G quiere decir que hemos encontrado solución
			
			return true; // luego, el algoritmo termina
		}
		if (preso[x][y] == 'P' || preso[x][y] == '*' || preso[x][y] == 'f') { // si llegamos a una pared o																// al mismo punto,
			return false; // entonces el laberinto no puede resolverse y termina.
		}if (preso[x][y] == 'X') {

			contador++;
		}

		// si no se cumple ninguna de estas dos situaciones, quiere decir que nos
		// encontramos en un
		// caso intermedio, por lo tanto, que empezamos a recorrer o todavía no hemos
		// llegado a nada
		preso[x][y] = '*'; // marcamos la posición como visitada (si es la primera, en las coordenadas x e
								// y
		paso(x, y);
		return false;

	}
	public int contador = 0;

	// private String imprimirLaberinto() { // imprimiremos nuestra solución. Debido
	// a que la clase Arrays no tiene implementado
	// String salida = ""; // un método toString para arrays bidimensionales, lo
	// programamos a mano
	// for (int x=0; x<laberinto.length; x++) { // recorremos filas
	// for (int y=0; y<laberinto[x].length; y++) { // recorremos columnas
	// salida += laberinto[x][y] + " "; // output es nuestra variable que va
	// almacenando los valores a imprimir
	// }
	// salida += "\n"; // devolvemos esta variable con un salto de línea
	// }
	// return salida;
	// }
	private String imprimirLaberintoRecursivo(int x, int y) {
		if (x == preso.length) {
			return "";
		}

		// Caso base: si la columna supera el tamaño de las columnas, pasa a la
		// siguiente fila
		if (y == preso[x].length) {
			return "\n" + imprimirLaberintoRecursivo(x + 1, 0); // Salto de línea para la nueva fila
		}

		// Imprime el elemento actual y llama recursivamente para el siguiente elemento
		return preso[x][y] + " " + imprimirLaberintoRecursivo(x, y + 1);
	}

}