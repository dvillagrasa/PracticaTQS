package mastermind.api.view;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Clase Vista - Gestiona la parte visual del juego y la forma en que se muestran los datos por pantalla.
 *  
 * @author Daniel Luis Garcia
 * @author Daniel Villagrasa Ramírez
 */
public class Vista {
	/**
	 * Variable necesaria para poder obtener la entrada por teclado del jugador.
	 */
	public Scanner escaner = new Scanner(System.in);

	/**
	 * Muestra un mensaje por pantalla solicitando al jugador que inserte una combinación de 4 números 
	 * con el formato "XXXX".
	 */
	public void solicitarCombinacion() {
		System.out.println("Inserta la combinación con el siguiente formato: XXXX \n"); // Muestra el mensaje de solicitud de una combinación.
	}

	/**
	 * Recibe la entrada por teclado del jugador y lo almacena en un array de cadena de carácteres, seguidamente
	 * ese array de cadena de carácteres se convierte a un array de carácteres para poder ser utilizado
	 * en el resto de métodos del programa.
	 * 
	 * @return Devuelve la entrada del jugador como un array de carácteres.
	 */
	public char[][] obtenerEntradaJugador() {
		char[][] entradaJugadorCasteada = new char[4][]; // Creación e inicialización del array de carácteres que será necesario para todo el programa.
		
		if(escaner.hasNextLine()) { // Comprueba si existe una entrada por teclado.
			String[] str = escaner.nextLine().split(""); // Caso de ejemplo: Separa la entrada 1234 en 1, 2, 3, 4.
			for(int i = 0; i < str.length; i++) { // Por cada elemento del array de cadena de carácteres.
				entradaJugadorCasteada[i] = str[i].toCharArray(); // Convierte cada posición del array de cadena de carácteres a tipo carácter y lo almacena en un array de carácteres.
			}
		}
		return entradaJugadorCasteada;
	}

	/**
	 * Muestra por pantalla el número de jugada (entre 1 y 9, ambos incluídos) junto con la combinación que ha intentado
	 * el jugador para adivinar la combinación generada por la máquina. Seguidamente se muestra una línea divisoria que
	 * separa, de forma visual, la jugada N de la jugada N+1.
	 * 
	 * @param resultadoEntradaJugador - Combinación del jugador obtenida de la función obtenerEntradaJugador().
	 * @param vecesJugado - Número de veces que el jugador ha insertado una combinación válida.
	 * @param aciertos - Array de enteros de 2 posiciones. La posición 0 almacena el nº de aciertos negros y la posición
	 * 1 almacena el nº de aciertos blancos.
	 */
	public void mostrarJugada(char[][] resultadoEntradaJugador, int vecesJugado, int[] aciertos) {		
		System.out.println("Jugada #" + vecesJugado + " " + Arrays.deepToString(resultadoEntradaJugador) + "\n"); // Muestra el nº de jugada y la entrada del jugador.
		System.out.println("Aciertos Negros: " + aciertos[0] + "\n" + "Aciertos Blancos: " + aciertos[1] + "\n"); // Muestra el nº de aciertos de cada tipo.
		System.out.println("--------------------------------"); // Delimitador entre jugadas.
	}
	
	/**
	 * Muestra por pantalla un mensaje informando al jugador sobre su victoria y le muestra, también por pantalla,
	 * la combinación aleatoria generada por la máquina.
	 *  
	 * @param resultadoEntradaJugador - Combinación del jugador (obtenida de la función obtenerEntradaJugador())
	 * que ha resultado ser idéntica a la combinación generada por la máquina.
	 */
	public void mostrarMensajeVictoria(char[][] resultadoEntradaJugador) {
		System.out.println("¡Felicidades, has ganado!"); // Mensaje de victoria.
		System.out.println("Has acertado la combinación secreta: " + Arrays.deepToString(resultadoEntradaJugador)); // Muestra la combinación ganadora del jugador.
	}
	
	/**
	 * Muestra por pantalla un mensaje informando al jugador sobre su derrota y le muestra, también por pantalla,
	 * cuál era la combinación aleatoria generada por la máquina.
	 * 
	 * @param combinacionAleatoria - Combinación aleatoria generada por la máquina, la cuál el jugador tenía que
	 * adivinar.
	 */
	public void mostrarMensajeDerrota(char [][] combinacionAleatoria) {
		System.out.println("¡Has perdido!"); // Mensaje de derrota.
		System.out.println("La combinación secreta era: " + Arrays.deepToString(combinacionAleatoria)); // Muestra la combinación aleatoria generada por la máquina.
	}
}
