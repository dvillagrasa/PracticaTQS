package mastermind.api.view;

import java.util.Scanner;
import java.util.Arrays;

//import java.util.Scanner;

/**
 * Clase Vista - Esta clase gestiona cómo se muestran los datos del juego.
 *  
 * @author Daniel Luis Garcia
 * @author Daniel Villagrasa Ramírez
 */
public class Vista {
	/**
	 * escaner será de utilidad para poder obtener la entrada por teclado del jugador.
	 */
	public Scanner escaner = new Scanner(System.in);

	/*public Vista() {

	}*/

	/**
	 * solicitarCombinación es una función que simplemente muestra un mensaje por pantalla solicitando al
	 * jugador que inserte una combinación de 4 números con un formato "XXXX".
	 */
	public void solicitarCombinacion() {
		System.out.println("Inserta la combinación con el siguiente formato: XXXX \n");
	}

	/**
	 * obtenerEntradaJugador es una función que recibe lo que el jugador introduce por teclado y lo almacena
	 * en un array de cadenas de carácteres para convertirlo a un array de carácteres más tarde.
	 * @return Devuelve la entrada del jugador como un array de carácteres.
	 */
	public char[][] obtenerEntradaJugador() {
		char[][] entradaJugadorCasteada = new char[4][];
		
		if(escaner.hasNextLine()) {
			String[] str = escaner.nextLine().split(""); //Separa 1111 en 1, 1, 1, 1
			for(int i = 0; i < str.length; i++) {
				entradaJugadorCasteada[i] = str[i].toCharArray();
			}
		}
		return entradaJugadorCasteada;
	}

	/**
	 * mostrarJugada es una función que muestra por pantalla las jugadas del jugador, indicando el número de tirada
	 * y la combinación entrada por él mismo.
	 * @param resultadoEntradaJugador es el array de carácteres de la función obtenerEntradaJugador().
	 * @param vecesJugado es el número de veces que se ha intentado una combinación.
	 */
	public void mostrarJugada(char[][] resultadoEntradaJugador, int vecesJugado, int[] aciertos) {		
		System.out.println("Jugada #" + vecesJugado + " " + Arrays.deepToString(resultadoEntradaJugador) + "\n");
		System.out.println("Aciertos Negros: " + aciertos[0] + "\n" + "Aciertos Blancos: " + aciertos[1] + "\n");
		System.out.println("--------------------------------");
	}
	
	/**
	 * Le dice al jugador que ha ganado y muestra la combinación 
	 * @param resultadoEntradaJugador es el array de carácteres de la combinación introducida por el jugador
	 */
	public void haGanado(char[][] resultadoEntradaJugador) {
		System.out.println("¡Felicidades, has ganado!");
		System.out.println("Has acertado la combinación secreta: " + Arrays.deepToString(resultadoEntradaJugador));
		
	}
	
	public void haPerdido(char [][] combAleatoria) {
		System.out.println("¡Has perdido!");
		System.out.println("La combinación secreta era: " + Arrays.deepToString(combAleatoria));
	}
}
