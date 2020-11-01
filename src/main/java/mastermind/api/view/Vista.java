package mastermind.api.view;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
		System.out.println("Inserta la combinación con el siguiente formato: XXXX");
	}
	public void solicitarNuevamenteCombinacion() {
		System.out.println("Por favor, entra una combinación con formato XXXX de números entre 0 y 8.");
	}
	/**
	 * obtenerEntradaJugador es una función que recibe lo que el jugador introduce por teclado y lo almacena
	 * en un array de cadenas de carácteres para convertirlo a un array de carácteres más tarde.
	 * @return Devuelve la entrada del jugador como un array de carácteres.
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
	 * comprobarEntradaJugador es una función que comprueba que los carácteres que el jugador ha introducido por teclado
	 * sean entre 0 y 8, ambos incluídos. En caso de que no sea así se mostrará un mensaje por pantalla con un aviso.
	 * @param entradaJugadorCasteada es el array de carácteres de la función obtenerEntradaJugador().
	 * @throws Exception
	 * @return Devuelve un booleano que será verdadero cuando toda la entrada del jugador sean carácteres dentro del
	 * rango de 0 a 8 (ambos incluídos).
	 */
	//public static boolean comprobarEntradaJugador(char[] entradaJugadorCasteada) throws Exception {
	public static boolean comprobarEntradaJugador(char[] entradaJugadorCasteada) {
		boolean entradaJugadorCorrecta = true;
		for(int i = 0; i < entradaJugadorCasteada.length; i++) {
			if((entradaJugadorCasteada[i] < '0') || (entradaJugadorCasteada[i] > '8')) {
				entradaJugadorCorrecta = false;
				return entradaJugadorCorrecta;
				//throw new Exception("El número " + entradaJugadorCasteada[i] + " está fuera del rango [0 - 8]."); // Si se ejecuta la execpción nunca hará el return.
			}
		}
		//System.out.println(entradaJugadorCorrecta);
		return entradaJugadorCorrecta;
	}
	/**
	 * mostrarJugada es una función que muestra por pantalla las jugadas del jugador, indicando el número de tirada
	 * y la combinación entrada por él mismo.
	 * @param entradaJugadorCasteada es el array de carácteres de la función obtenerEntradaJugador().
	 * @param vecesJugado es el número de veces que se ha intentado una combinación.
	 */
	public void mostrarJugada(char[] entradaJugadorCasteada, int vecesJugado) {
		System.out.println("Jugada #" + vecesJugado + " " + Arrays.toString(entradaJugadorCasteada) + "\n");
	}
}
