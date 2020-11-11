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
	public String solicitarCombinacion() {
		String solicitarCombinacion = "Inserta la combinación con el siguiente formato: XXXX";
		System.out.println(solicitarCombinacion); // Muestra el mensaje de solicitud de una combinación.
		return solicitarCombinacion;
	}

	/**
	 * Recibe la entrada por teclado del jugador, separa los carácteres y lo almacena en un 
	 * array de cadena de carácteres.
	 * 
	 * @return Devuelve un array de cadena de carácteres.
	 */
	public String obtenerCombinacionJugador() {
		String entrada = null;
		if(escaner.hasNextLine()) { // Comprueba si existe una entrada por teclado.
			entrada = escaner.nextLine();
		}
		return entrada;
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
	public String mostrarJugada(char[] resultadoEntradaJugador, int vecesJugado, char[] aciertos) {		
		//array de 2 para ambos strings xdd
		String mostrarJugada = "Jugada #" + vecesJugado + " " + Arrays.toString(resultadoEntradaJugador) + " "+ Arrays.toString(aciertos);
		System.out.println(mostrarJugada);
		//System.out.println("Jugada #" + vecesJugado + " " + Arrays.toString(resultadoEntradaJugador) + " "+ Arrays.toString(aciertos));
		System.out.println("-----------------------------------");
		return mostrarJugada;
	}
	
	/**
	 * Muestra por pantalla un mensaje informando al jugador sobre su victoria y le muestra, también por pantalla,
	 * la combinación aleatoria generada por la máquina.
	 *  
	 * @param resultadoEntradaJugador - Combinación del jugador (obtenida de la función obtenerEntradaJugador())
	 * que ha resultado ser idéntica a la combinación generada por la máquina.
	 */
	public String mostrarMensajeVictoria(char[] resultadoEntradaJugador) {
		String mostrarMensajeVictoria = "¡Felicidades, has ganado! \nHas acertado la combinación secreta: " + Arrays.toString(resultadoEntradaJugador);
		System.out.println(mostrarMensajeVictoria);
		return mostrarMensajeVictoria;
	}
	
	/**
	 * Muestra por pantalla un mensaje informando al jugador sobre su derrota y le muestra, también por pantalla,
	 * cuál era la combinación aleatoria generada por la máquina.
	 * 
	 * @param combinacionSecreta - Combinación aleatoria generada por la máquina, la cuál el jugador tenía que
	 * adivinar.
	 */
	public String mostrarMensajeDerrota(char[] combinacionSecreta) {
		String mostrarMensajeDerrota = "¡Has perdido! \nLa combinación secreta era: " + Arrays.toString(combinacionSecreta);
		System.out.println(mostrarMensajeDerrota);
		return mostrarMensajeDerrota;
		
		//System.out.println("¡Has perdido!");
		//System.out.println("La combinación secreta era: " + Arrays.toString(combinacionSecreta));
	}
}
