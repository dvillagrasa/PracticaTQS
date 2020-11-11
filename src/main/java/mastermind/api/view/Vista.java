package mastermind.api.view;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Clase Vista - Gestiona la parte visual del juego y la forma en que se muestran los datos por pantalla.
 *  
 * @author Daniel Luis Garcia
 * @author Daniel Villagrasa Ramirez
 */
public class Vista {
	/**
	 * Variable necesaria para poder obtener la entrada por teclado del jugador.
	 */
	public Scanner escaner = new Scanner(System.in);

	/**
	 * Muestra un mensaje por pantalla solicitando al jugador que inserte una 
	 * combinacion de 4 numeros con el formato "XXXX".
	 */
	public String solicitarCombinacion() {
		
		String solicitarCombinacion = "Inserta la combinacion con el siguiente formato: XXXX";
		System.out.println(solicitarCombinacion);
		
		return solicitarCombinacion;
	}

	/**
	 * Comprueba si existe una entrada por teclado, si es asi recibe la entrada
	 * por teclado del jugador, separa los caracteres y lo almacena en una 
	 * cadena de caracteres.
	 * 
	 * @return Devuelve la cadena de caracteres con la entrada del jugador o null.
	 */
	public String obtenerCombinacionJugador() {
		
		String entrada = null;
		
		if(escaner.hasNextLine()) { // 
			entrada = escaner.nextLine();
		}
		return entrada;
	}

	/**
	 * Muestra por pantalla el numero de jugada (entre 1 y 9, ambos incluidos) junto con la combinacion que ha intentado
	 * el jugador para adivinar la combinacion generada por la maquina. Seguidamente se muestra una linea divisoria que
	 * separa, de forma visual, la jugada N de la jugada N+1.
	 * 
	 * @param resultadoEntradaJugador - Combinacion del jugador obtenida de la funcion obtenerEntradaJugador().
	 * @param vecesJugado - Numero de veces que el jugador ha insertado una combinacion valida.
	 * @param aciertos - Array de enteros de 2 posiciones. La posicion 0 almacena el numero de aciertos negros y la posicion
	 * 1 almacena el numero de aciertos blancos.
	 */
	public String mostrarJugada(char[] resultadoEntradaJugador, int vecesJugado, char[] aciertos) {		
		
		String mostrarJugada = "Jugada #" + vecesJugado + " " + Arrays.toString(resultadoEntradaJugador) + " "+ Arrays.toString(aciertos);
		System.out.println(mostrarJugada);
		System.out.println("-----------------------------------");
		
		return mostrarJugada;
	}
	
	/**
	 * Muestra por pantalla un mensaje informando al jugador sobre su victoria y le muestra, tambien por pantalla,
	 * la combinacion aleatoria generada por la maquina.
	 *  
	 * @param resultadoEntradaJugador - Combinacion del jugador (obtenida de la funcion obtenerEntradaJugador())
	 * que ha resultado ser identica a la combinacion generada por la maquina.
	 */
	public String mostrarMensajeVictoria(char[] resultadoEntradaJugador) {
		
		String mostrarMensajeVictoria = "!Felicidades, has ganado! \nHas acertado la combinacion secreta: " + Arrays.toString(resultadoEntradaJugador);
		System.out.println(mostrarMensajeVictoria);
		
		return mostrarMensajeVictoria;
	}
	
	/**
	 * Muestra por pantalla un mensaje informando al jugador sobre su derrota y le muestra, tambien por pantalla,
	 * cuál era la combinacion aleatoria generada por la maquina.
	 * 
	 * @param combinacionSecreta - Combinacion aleatoria generada por la maquina, la cual el jugador tenia que
	 * adivinar.
	 */
	public String mostrarMensajeDerrota(char[] combinacionSecreta) {
		
		String mostrarMensajeDerrota = "!Has perdido! \nLa combinacion secreta era: " + Arrays.toString(combinacionSecreta);
		System.out.println(mostrarMensajeDerrota);
		
		return mostrarMensajeDerrota;
	}
}
