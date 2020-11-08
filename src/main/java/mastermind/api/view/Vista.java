package mastermind.api.view;

import java.util.Scanner;
import java.util.Arrays;

//import java.util.Scanner;

/**
 * Clase Vista - Esta clase gestiona c�mo se muestran los datos del juego.
 *  
 * @author Daniel Luis Garcia
 * @author Daniel Villagrasa Ram�rez
 */
public class Vista {
	/**
	 * escaner ser� de utilidad para poder obtener la entrada por teclado del jugador.
	 */
	public Scanner escaner = new Scanner(System.in);

	/*public Vista() {

	}*/

	/**
	 * solicitarCombinaci�n es una funci�n que simplemente muestra un mensaje por pantalla solicitando al
	 * jugador que inserte una combinaci�n de 4 n�meros con un formato "XXXX".
	 */
	public void solicitarCombinacion() {
		System.out.println("Inserta la combinaci�n con el siguiente formato: XXXX \n");
	}

	/**
	 * obtenerEntradaJugador es una funci�n que recibe lo que el jugador introduce por teclado y lo almacena
	 * en un array de cadenas de car�cteres para convertirlo a un array de car�cteres m�s tarde.
	 * @return Devuelve la entrada del jugador como un array de car�cteres.
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
	 * mostrarJugada es una funci�n que muestra por pantalla las jugadas del jugador, indicando el n�mero de tirada
	 * y la combinaci�n entrada por �l mismo.
	 * @param resultadoEntradaJugador es el array de car�cteres de la funci�n obtenerEntradaJugador().
	 * @param vecesJugado es el n�mero de veces que se ha intentado una combinaci�n.
	 */
	public void mostrarJugada(char[][] resultadoEntradaJugador, int vecesJugado, int[] aciertos) {		
		System.out.println("Jugada #" + vecesJugado + " " + Arrays.deepToString(resultadoEntradaJugador) + "\n");
		System.out.println("Aciertos Negros: " + aciertos[0] + "\n" + "Aciertos Blancos: " + aciertos[1] + "\n");
		System.out.println("--------------------------------");
	}
	
	/**
	 * Le dice al jugador que ha ganado y muestra la combinaci�n 
	 * @param resultadoEntradaJugador es el array de car�cteres de la combinaci�n introducida por el jugador
	 */
	public void haGanado(char[][] resultadoEntradaJugador) {
		System.out.println("�Felicidades, has ganado!");
		System.out.println("Has acertado la combinaci�n secreta: " + Arrays.deepToString(resultadoEntradaJugador));
		
	}
	
	public void haPerdido(char [][] combAleatoria) {
		System.out.println("�Has perdido!");
		System.out.println("La combinaci�n secreta era: " + Arrays.deepToString(combAleatoria));
	}
}
