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
	public String solicitarCombinacion() {
		String solicitarCombinacion = "Inserta la combinaci�n con el siguiente formato: XXXX";
		System.out.println(solicitarCombinacion); // Muestra el mensaje de solicitud de una combinaci�n.
		return solicitarCombinacion;
	}

	/**
	 * Recibe la entrada por teclado del jugador, separa los car�cteres y lo almacena en un 
	 * array de cadena de car�cteres.
	 * 
	 * @return Devuelve un array de cadena de car�cteres.
	 */
	public String obtenerCombinacionJugador() {
		String entrada = null;
		if(escaner.hasNextLine()) { // Comprueba si existe una entrada por teclado.
			entrada = escaner.nextLine();
		}
		return entrada;
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
	public String mostrarJugada(char[] resultadoEntradaJugador, int vecesJugado, char[] aciertos) {		
		//array de 2 para ambos strings xdd
		String mostrarJugada = "Jugada #" + vecesJugado + " " + Arrays.toString(resultadoEntradaJugador) + " "+ Arrays.toString(aciertos);
		System.out.println(mostrarJugada);
		//System.out.println("Jugada #" + vecesJugado + " " + Arrays.toString(resultadoEntradaJugador) + " "+ Arrays.toString(aciertos));
		System.out.println("-----------------------------------");
		return mostrarJugada;
	}
	
	/**
	 * Muestra por pantalla un mensaje informando al jugador sobre su victoria y le muestra, tambi�n por pantalla,
	 * la combinaci�n aleatoria generada por la m�quina.
	 *  
	 * @param resultadoEntradaJugador - Combinaci�n del jugador (obtenida de la funci�n obtenerEntradaJugador())
	 * que ha resultado ser id�ntica a la combinaci�n generada por la m�quina.
	 */
	public String mostrarMensajeVictoria(char[] resultadoEntradaJugador) {
		String mostrarMensajeVictoria = "�Felicidades, has ganado! \nHas acertado la combinaci�n secreta: " + Arrays.toString(resultadoEntradaJugador);
		System.out.println(mostrarMensajeVictoria);
		return mostrarMensajeVictoria;
	}
	
	/**
	 * Muestra por pantalla un mensaje informando al jugador sobre su derrota y le muestra, tambi�n por pantalla,
	 * cu�l era la combinaci�n aleatoria generada por la m�quina.
	 * 
	 * @param combinacionSecreta - Combinaci�n aleatoria generada por la m�quina, la cu�l el jugador ten�a que
	 * adivinar.
	 */
	public String mostrarMensajeDerrota(char[] combinacionSecreta) {
		String mostrarMensajeDerrota = "�Has perdido! \nLa combinaci�n secreta era: " + Arrays.toString(combinacionSecreta);
		System.out.println(mostrarMensajeDerrota);
		return mostrarMensajeDerrota;
		
		//System.out.println("�Has perdido!");
		//System.out.println("La combinaci�n secreta era: " + Arrays.toString(combinacionSecreta));
	}
}
