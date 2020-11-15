package mastermind.api.model;

import java.util.ArrayList;
import java.util.Random;

import com.google.common.primitives.Chars;

import mastermind.InterfazAleatorio;
import mastermind.InterfazEscaner;

/**
 * Clase Modelo - Realiza calculos y proporciona los resultados que son
 * necesarios para uilizar en nuestro programa.
 * 
 * @author Daniel Luis Garcia
 * @author Daniel Villagrasa Ramirez
 */
public class Modelo {
	/**
	 * Numero de posiciones del tablero del juego. En este caso son 4 tanto para los
	 * numeros (serian los colores exceptuando el blanco y negro), como para mostrar
	 * los aciertos de numeros y/o posicion (serian los colores blanco y negro).
	 */
	public static final int MAX_CLAVIJAS = 4;

	/**
	 * Variable que permite obtener un valor aleatorio dentro de un conjunto de
	 * datos.
	 */
	public static final Random aleatorio = new Random(); // Random() devuelve un valor aleatorio.

	/**
	 * 
	 * @param interfazEscaner
	 * @return
	 */
	public String obtenerOpcionMenu(InterfazEscaner interfazEscaner) {
		String entrada = null;
		entrada = interfazEscaner.cogerOpcionMenu();
		return entrada;
	}
	
	/*public String obtenerJugarOtra(InterfazEscaner interfazEscaner) {
		String entrada = null;
		entrada = interfazEscaner.cogerOpcionMenu();
		return entrada;
	}*/

	/**
	 * Coge la opcion introducida mediante de la interfaz del escaner y la castea de
	 * String a char.
	 * 
	 * @param opcionJugador
	 * @return
	 */
	public char[] castearOpcionMenu(String opcionJugador) {
		
		char[] opcionJugadorCasteada = opcionJugador.toCharArray();
			
		return opcionJugadorCasteada;
	}

	/**
	 * Comprueba que el numero introducido mediante de la interfaz del escaner es
	 * valido.
	 * 
	 * @param opcionCasteada - opcion introducida mediante de la interfaz del
	 *                       escaner.
	 * @return - Devuelve true o false, dependiendo de opcionCasteada.
	 */
	public boolean validarOpcionMenu(char[] opcionCasteada) {
		boolean esCorrecto = true;
		int i = 0;

		if ((opcionCasteada.length != 1) || ((opcionCasteada[i] < '1') || (opcionCasteada[i] > '2'))) {
			esCorrecto = false;
		}
		return esCorrecto;
	}
	

	/**
	 * Obtiene la combinacion que se introduce mediante de la interfaz del escaner.
	 * 
	 * @param interfazEscaner - Instancia de la clase InterfazEscaner.
	 * @return entrada - Combinacion obtenida de la interfaz del escaner.
	 */
	public String obtenerCombinacionJugador(InterfazEscaner interfazEscaner) {
		String entrada = null;
		entrada = interfazEscaner.cogerEntradaJugador();

		return entrada;
	}

	/**
	 * Recibe un array de cadena de caracteres el cual convierte a un array de
	 * caracteres para poder ser utilizado en el resto de metodos del programa.
	 * 
	 * @param entradaJugador - Array de cadena de caracteres con la entrada del
	 *                       jugador separada por caracteres.
	 * @return Devuelve el array de cadena de caracteres transformado a array de
	 *         caracteres.
	 */
	public char[] castearCombinacionJugador(String entradaJugador) {

		char[] entradaJugadorCasteada = { ' ' };

		for (int i = 0; i < entradaJugador.length(); i++) {
			entradaJugadorCasteada = entradaJugador.toCharArray();
		}
		return entradaJugadorCasteada;
	}

	/**
	 * Comprueba que los caracteres que el jugador ha introducido por teclado sean
	 * entre 0 y 8, ambos incluidos.
	 * 
	 * @param entradaJugadorCasteada - Array de caracteres de la funcion
	 *                               obtenerEntradaJugador().
	 * @return Devuelve un booleano que sera true cuando toda la entrada del jugador
	 *         sean caracteres dentro del rango de 0 a 8 (ambos incluídos).
	 */
	public boolean validarCombinacionJugador(char[] entradaJugadorCasteada) {

		boolean esCorrecta = true;

		if (entradaJugadorCasteada.length == MAX_CLAVIJAS) {
			for (int i = 0; i < entradaJugadorCasteada.length; i++) {
				if ((entradaJugadorCasteada[i] < '0') || (entradaJugadorCasteada[i] > '8')) {
					esCorrecta = false;
					break;
				}
			}
		} else {
			esCorrecta = false;
		}
		return esCorrecta;
	}
	
	
	
	/**
	 * Comprueba que el numero introducido mediante de la interfaz del escaner es
	 * valido.
	 * 
	 * @param opcionCasteada - opcion introducida mediante de la interfaz del
	 *                       escaner.
	 * @return - Devuelve true o false, dependiendo de opcionCasteada.
	 */
	/*public boolean validarJugarOtra(char[] jugarOtraCasteada) {
		boolean esCorrecto = false;
		int i = 0;

		if (jugarOtraCasteada[i] == 'y' || jugarOtraCasteada[i] == 'n') {
			esCorrecto = true;
		}
		return esCorrecto;
	}*/

	/**
	 * Genera la combinacion aleatoria de la partida a partir de una cola que
	 * contiene los numeros del 0 al 8, ambos incluidos. De esta cola se extraen de
	 * forma aleatoria y sin repeticion 4 numeros que formaran parte de la
	 * combinacion aleatoria.
	 * 
	 * @param numeros - Array de cadenas de caracteres de un rango de 0 a 8, que son
	 *                los numeros para el codigo aleatorio secreto.
	 * @return Devuelve el array de caracteres que almacena la combinacion aleatoria
	 *         de la partida.
	 */
	public static char[] generarCombinacionSecreta(InterfazAleatorio interfazAleatorio) {

		boolean esValida = false;
		String combinacionSecreta;
		char[] combinacionSecretaCasteada = { ' ' };

		while (!esValida) {
			esValida = true;
			combinacionSecreta = interfazAleatorio.obtenerValorAleatorio();
			combinacionSecretaCasteada = combinacionSecreta.toCharArray();

			if (combinacionSecretaCasteada.length == MAX_CLAVIJAS) {
				for (int i = 0; i < combinacionSecretaCasteada.length; i++) {
					if ((combinacionSecretaCasteada[i] < '0') || (combinacionSecretaCasteada[i] > '8')) {
						esValida = false;
						break;
					}
				}
			} else {
				esValida = false;
			}
		}
		System.out.print("Combinacion secreta: ");
		System.out.println(combinacionSecretaCasteada);

		return combinacionSecretaCasteada;
	}
	/**
	 * 
	 * @param combinacionSecretaCasteada
	 * @return
	 */
	/*public boolean validarCombinacionSecreta(char[] combinacionSecretaCasteada) {

		boolean esCorrecta = true;

		if (combinacionSecretaCasteada.length == MAX_CLAVIJAS) {
			for (int i = 0; i < combinacionSecretaCasteada.length; i++) {
				if ((combinacionSecretaCasteada[i] < '0') || (combinacionSecretaCasteada[i] > '8')) {
					esCorrecta = false;
					break;
				}
			}
		} else {
			esCorrecta = false;
		}
		return esCorrecta;
	}*/
	
	/**
	 * Comprueba la combinacion generada por la maquina y la combinacion itroducida
	 * por el jugador. En funcion de la combinacion introducida por el jugador se
	 * comprobara si los numeros existen y si estan bien ubicados respecto de la
	 * combinacion generada por la maquina.
	 * 
	 * @param combinacionSecreta - Combinacion aleatoria generada por la maquina.
	 * @param combinacionJugador - Combinacion introducida por el jugador.
	 * @return Devuelve un array de enteros de 2 posiciones. La posicion 0 almacena
	 *         el numero de aciertos negros y la posicion 1 almacena el numero de
	 *         aciertos blancos.
	 */
	public static char[] compararCombinaciones(char[] combinacionSecreta, char[] combinacionJugador) {

		char[] aciertos = { '0', '0', '0', '0' };

		for (int i = 0; i < combinacionSecreta.length; i++) {
			if (combinacionSecreta[i] == combinacionJugador[i]) {
				aciertos[i] = 'N';
			} else if (Chars.contains(combinacionSecreta, combinacionJugador[i])) {
				aciertos[i] = 'B';
			} else {
				aciertos[i] = '0';
			}
		}
		return aciertos;
	}

	/**
	 * Comprueba si el numero de aciertos negros almacenados en la posicion 0 del
	 * array de enteros es identico a MAX_CLAVIJAS. En caso de que sea identico (4
	 * == 4, no existe otra posibilidad) el flag ganar se pondra a true. En caso
	 * contrario, seguira siendo false.
	 * 
	 * @param aciertos - Array de caracteres que almacenara los fallos (0), aciertos
	 *                 de numero (B) y los aciertos de numero y posicion (N).
	 * @return Devuelve true si el numero de aciertos negros es igual a 4, en caso
	 *         contrario, devuelve false.
	 */
	public static boolean comprobarVictoria(char[] aciertos) {

		boolean victoria = false;
		int contador = 0;

		for (int i = 0; i < MAX_CLAVIJAS; i++) {
			if (aciertos[i] == 'N') {
				contador++;
			}
		}

		if (contador == MAX_CLAVIJAS) {
			victoria = true;
		}
		return victoria;
	}
}