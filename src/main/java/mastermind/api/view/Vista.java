package mastermind.api.view;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
		System.out.println("Inserta la combinaci�n con el siguiente formato: XXXX");
	}
	public void solicitarNuevamenteCombinacion() {
		System.out.println("Por favor, entra una combinaci�n con formato XXXX de n�meros entre 0 y 8.");
	}
	/**
	 * obtenerEntradaJugador es una funci�n que recibe lo que el jugador introduce por teclado y lo almacena
	 * en un array de cadenas de car�cteres para convertirlo a un array de car�cteres m�s tarde.
	 * @return Devuelve la entrada del jugador como un array de car�cteres.
	 */
	public char[] obtenerEntradaJugador() {
		char[] entradaJugadorCasteada=null;

		if(escaner.hasNextLine()) {
			String entradaJugador = escaner.nextLine();
			entradaJugadorCasteada = entradaJugador.toCharArray();
		}
		//return Arrays.toString(entradaJugadorCasteada);
		return entradaJugadorCasteada;
	}
	
	/**
	 * comprobarEntradaJugador es una funci�n que comprueba que los car�cteres que el jugador ha introducido por teclado
	 * sean entre 0 y 8, ambos inclu�dos. En caso de que no sea as� se mostrar� un mensaje por pantalla con un aviso.
	 * @param entradaJugadorCasteada es el array de car�cteres de la funci�n obtenerEntradaJugador().
	 * @throws Exception
	 * @return Devuelve un booleano que ser� verdadero cuando toda la entrada del jugador sean car�cteres dentro del
	 * rango de 0 a 8 (ambos inclu�dos).
	 */
	//public static boolean comprobarEntradaJugador(char[] entradaJugadorCasteada) throws Exception {
	public static boolean comprobarEntradaJugador(char[] entradaJugadorCasteada) {
		boolean entradaJugadorCorrecta = true;
		for(int i = 0; i < entradaJugadorCasteada.length; i++) {
			if((entradaJugadorCasteada[i] < '0') || (entradaJugadorCasteada[i] > '8')) {
				entradaJugadorCorrecta = false;
				return entradaJugadorCorrecta;
				//throw new Exception("El n�mero " + entradaJugadorCasteada[i] + " est� fuera del rango [0 - 8]."); // Si se ejecuta la execpci�n nunca har� el return.
			}
		}
		//System.out.println(entradaJugadorCorrecta);
		return entradaJugadorCorrecta;
	}
	/**
	 * mostrarJugada es una funci�n que muestra por pantalla las jugadas del jugador, indicando el n�mero de tirada
	 * y la combinaci�n entrada por �l mismo.
	 * @param entradaJugadorCasteada es el array de car�cteres de la funci�n obtenerEntradaJugador().
	 * @param vecesJugado es el n�mero de veces que se ha intentado una combinaci�n.
	 */
	public void mostrarJugada(char[] entradaJugadorCasteada, int vecesJugado) {
		System.out.println("Jugada #" + vecesJugado + " " + Arrays.toString(entradaJugadorCasteada) + "\n");
	}
}
