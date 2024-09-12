

public class Laberinto {

	public char[][] laberinto = {
			{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
			{ '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#' },
			{ '#', ' ', '#', ' ', '#', '#', '#', '#', '#', '#' },
			{ '#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#' },
			{ '#', '#', '#', ' ', ' ', ' ', '#', '#', '#', '#' },
			{ '#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#' },
			{ '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#' },
			{ '#', ' ', ' ', ' ', '#', ' ', '#', ' ', '#', '#' },
			{ '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#' },
			{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
	};

	/* --------------------- PRUEBA DEL ALGORITMO --------------------- */
	public static void main(String[] args) {
		Laberinto m = new Laberinto(); // construimos un objeto de la clase Laberinto por defecto
		m.laberinto[8][1] = 'X'; // introducimos en este caso, la salida (X) en las coordenadas (1,1)
		m.resuelve(1, 1);
		String resultado = m.imprimirLaberintoRecursivo(0, 0); // ahora, introducimos la entrada (S) en las coordenadas
																// (8,1) y llamamos al algoritmo
		System.out.println(resultado); // imprimimos el laberinto ya resuelto (si tiene solución)
	}

	/* ----------------- IMPLEMENTACIÓN DEL ALGORITMO ----------------- */
	public void resuelve(int x, int y) { // permite introducir unas coordenadas (x, y)
		if (paso(x, y)) { // intentará resolver el laberinto en estas coordenadas
			laberinto[x][y] = 'S'; // introduce en las coordenadas (x, y) la entrada
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

		result = validarPaso(x, y - 1); // intentamos ir hacia la IZQUIERDA. Tercera llamada recursiva
		if (result)
			return true;

		result = validarPaso(x + 1, y); // intentamos ir hacia ABAJO. Cuarta llamada recursiva
		if (result)
			return true;

		// si no hemos encontrado la solución en estos cuatros movimientos, volvemos
		// atrás, aunque hay que
		// considerar que en este punto, todas las llamadas recursivas han finalizado.
		// Si en ninguna de ellas
		// se ha conseguido el éxito, entonces el algoritmo termina y devuelve false.
		laberinto[x][y] = 'f'; // en el caso de no ser el resultado, se marca con +. Ya fue pisado
		return false;
	}

	private boolean validarPaso(int x, int y) {
		if (laberinto[x][y] == 'X') { // si hemos llegado a X quiere decir que hemos encontrado solución
			return true; // luego, el algoritmo termina
		}
		if (laberinto[x][y] == '#' || laberinto[x][y] == '*' || laberinto[x][y] == 'f') { // si llegamos a una pared o
																							// al mismo punto,
			return false; // entonces el laberinto no puede resolverse y termina.
		}
		// si no se cumple ninguna de estas dos situaciones, quiere decir que nos
		// encontramos en un
		// caso intermedio, por lo tanto, que empezamos a recorrer o todavía no hemos
		// llegado a nada
		laberinto[x][y] = '*'; // marcamos la posición como visitada (si es la primera, en las coordenadas x e
								// y
		paso(x, y);
		return false;

	}

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
		if (x == laberinto.length) {
			return "";
		}

		// Caso base: si la columna supera el tamaño de las columnas, pasa a la
		// siguiente fila
		if (y == laberinto[x].length) {
			return "\n" + imprimirLaberintoRecursivo(x + 1, 0); // Salto de línea para la nueva fila
		}

		// Imprime el elemento actual y llama recursivamente para el siguiente elemento
		return laberinto[x][y] + " " + imprimirLaberintoRecursivo(x, y + 1);
	}

}