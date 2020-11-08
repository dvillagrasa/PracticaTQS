package mastermind.api.view;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Clase Vista - Gestiona la parte visual del juego y la forma en que se muestran los datos por pantalla.
 *  
 * @author Daniel Luis Garcia
 * @author Daniel Villagrasa Ram�rez
 */
public class Vista {
	/**
	 * Variable necesaria para poder obtener la entrada por teclado del jugador.
	 */
	public Scanner escaner = new Scanner(System.in);

	/**
	 * Muestra un mensaje por pantalla solicitando al jugador que inserte una combinaci�n de 4 n�meros 
	 * con el formato "XXXX".
	 */
	public void solicitarCombinacion() {
		System.out.println("Inserta la combinaci�n con el siguiente formato: XXXX \n"); // Muestra el mensaje de solicitud de una combinaci�n.
	}

	/**
	 * Recibe la entrada por teclado del jugador y lo almacena en un array de cadena de car�cteres, seguidamente
	 * ese array de cadena de car�cteres se convierte a un array de car�cteres para poder ser utilizado
	 * en el resto de m�todos del programa.
	 * 
	 * @return Devuelve la entrada del jugador como un array de car�cteres.
	 */
	public char[][] obtenerEntradaJugador() {
		char[][] entradaJugadorCasteada = new char[4][]; // Creaci�n e inicializaci�n del array de car�cteres que ser� necesario para todo el programa.
		
		if(escaner.hasNextLine()) { // Comprueba si existe una entrada por teclado.
			String[] str = escaner.nextLine().split(""); // Caso de ejemplo: Separa la entrada 1234 en 1, 2, 3, 4.
			for(int i = 0; i < str.length; i++) { // Por cada elemento del array de cadena de car�cteres.
				entradaJugadorCasteada[i] = str[i].toCharArray(); // Convierte cada posici�n del array de cadena de car�cteres a tipo car�cter y lo almacena en un array de car�cteres.
			}
		}
		return entradaJugadorCasteada;
	}

	/**
	 * Muestra por pantalla el n�mero de jugada (entre 1 y 9, ambos inclu�dos) junto con la combinaci�n que ha intentado
	 * el jugador para adivinar la combinaci�n generada por la m�quina. Seguidamente se muestra una l�nea divisoria que
	 * separa, de forma visual, la jugada N de la jugada N+1.
	 * 
	 * @param resultadoEntradaJugador - Combinaci�n del jugador obtenida de la funci�n obtenerEntradaJugador().
	 * @param vecesJugado - N�mero de veces que el jugador ha insertado una combinaci�n v�lida.
	 * @param aciertos - Array de enteros de 2 posiciones. La posici�n 0 almacena el n� de aciertos negros y la posici�n
	 * 1 almacena el n� de aciertos blancos.
	 */
	public void mostrarJugada(char[][] resultadoEntradaJugador, int vecesJugado, int[] aciertos) {		
		System.out.println("Jugada #" + vecesJugado + " " + Arrays.deepToString(resultadoEntradaJugador) + "\n"); // Muestra el n� de jugada y la entrada del jugador.
		System.out.println("Aciertos Negros: " + aciertos[0] + "\n" + "Aciertos Blancos: " + aciertos[1] + "\n"); // Muestra el n� de aciertos de cada tipo.
		System.out.println("--------------------------------"); // Delimitador entre jugadas.
	}
	
	/**
	 * Muestra por pantalla un mensaje informando al jugador sobre su victoria y le muestra, tambi�n por pantalla,
	 * la combinaci�n aleatoria generada por la m�quina.
	 *  
	 * @param resultadoEntradaJugador - Combinaci�n del jugador (obtenida de la funci�n obtenerEntradaJugador())
	 * que ha resultado ser id�ntica a la combinaci�n generada por la m�quina.
	 */
	public void mostrarMensajeVictoria(char[][] resultadoEntradaJugador) {
		System.out.println("�Felicidades, has ganado!"); // Mensaje de victoria.
		System.out.println("Has acertado la combinaci�n secreta: " + Arrays.deepToString(resultadoEntradaJugador)); // Muestra la combinaci�n ganadora del jugador.
	}
	
	/**
	 * Muestra por pantalla un mensaje informando al jugador sobre su derrota y le muestra, tambi�n por pantalla,
	 * cu�l era la combinaci�n aleatoria generada por la m�quina.
	 * 
	 * @param combinacionAleatoria - Combinaci�n aleatoria generada por la m�quina, la cu�l el jugador ten�a que
	 * adivinar.
	 */
	public void mostrarMensajeDerrota(char [][] combinacionAleatoria) {
		System.out.println("�Has perdido!"); // Mensaje de derrota.
		System.out.println("La combinaci�n secreta era: " + Arrays.deepToString(combinacionAleatoria)); // Muestra la combinaci�n aleatoria generada por la m�quina.
	}
}
