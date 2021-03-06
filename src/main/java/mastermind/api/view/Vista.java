package mastermind.api.view;

import java.util.Arrays;

/**
 * Clase Vista - Gestiona la parte visual del juego y la forma en que se
 * muestran los datos por pantalla.
 * 
 * @author Daniel Luis Garcia
 * @author Daniel Villagrasa Ramirez
 */
public class Vista {

	/**
	 * Muestra el menu del juego.
	 * 
	 * @return Devuelve el menu del juego almacenado en un String.
	 */
	public String mostrarMenu() {
		String mostrarMenu = "##############################\n" + "######### MASTERMIND #########\n"
				+ "##############################\n" + "###     [1] JUGAR          ###\n"
				+ "###     [2] SALIR          ###\n" + "##############################\n"
				+ "Selecciona una opcion (1 o 2).";

		System.out.println(mostrarMenu);

		return mostrarMenu;
	}

	/**
	 * Muestra un mensaje por pantalla solicitando al jugador que inserte una
	 * combinacion de 4 numeros con el formato "XXXX".
	 * 
	 * @return Devuelve el mensaje almacenado en un String.
	 */
	public String solicitarCombinacion() {

		String solicitarCombinacion = "Inserta una combinacion de 4 numeros [0-8] con el siguiente formato: XXXX";
		System.out.println(solicitarCombinacion);

		return solicitarCombinacion;
	}

	/**
	 * Muestra por pantalla el numero de jugada (entre 1 y 9, ambos incluidos) junto
	 * con la combinacion que ha sido utilizada para adivinar la combinacion
	 * secreta. Seguidamente se muestra una linea divisoria que separa, de forma
	 * visual, la jugada N de la jugada N+1.
	 * 
	 * @param resultadoEntradaJugador - Combinacion del jugador obtenida de la
	 *                                funcion obtenerEntradaJugador().
	 * @param vecesJugado             - Numero de veces que el jugador ha insertado
	 *                                una combinacion valida.
	 * @param aciertos                - Array de enteros de 2 posiciones. La
	 *                                posicion 0 almacena el numero de aciertos
	 *                                negros y la posicion 1 almacena el numero de
	 *                                aciertos blancos.
	 * 
	 * @return Devuelve el mensaje almacenado en un String.
	 */
	public String mostrarJugada(char[] resultadoEntradaJugador, int vecesJugado, char[] aciertos) {

		String mostrarJugada = "Jugada #" + vecesJugado + " " + Arrays.toString(resultadoEntradaJugador) + " "
				+ Arrays.toString(aciertos);
		System.out.println(mostrarJugada);
		System.out.println("-----------------------------------");

		return mostrarJugada;
	}

	/**
	 * Muestra por pantalla un mensaje informando al jugador sobre su victoria y le
	 * muestra, tambien por pantalla, la combinacion aleatoria secreta de la
	 * partida.
	 * 
	 * @param resultadoEntradaJugador - Combinacion del jugador (obtenida de la
	 *                                funcion obtenerEntradaJugador()) que ha
	 *                                resultado ser identica a la combinacion
	 *                                generada por la maquina.
	 * @return Devuelve el mensaje almacenado en un String.
	 */
	public String mostrarMensajeVictoria(char[] resultadoEntradaJugador) {

		String mostrarMensajeVictoria = "!Felicidades, has ganado! \nHas acertado la combinacion secreta: "
				+ Arrays.toString(resultadoEntradaJugador) + "\n";
		System.out.println(mostrarMensajeVictoria);

		return mostrarMensajeVictoria;
	}

	/**
	 * Muestra por pantalla un mensaje informando al jugador sobre su derrota y le
	 * muestra, tambien por pantalla, cu�l era la combinacion secreta
	 * 
	 * @param combinacionSecreta - Combinacion aleatoria secreta, la cual el jugador
	 *                           tenia que adivinar.
	 * @return Devuelve el mensaje almacenado en un String.
	 */
	public String mostrarMensajeDerrota(char[] combinacionSecreta) {

		String mostrarMensajeDerrota = "!Has perdido! \nLa combinacion secreta era: "
				+ Arrays.toString(combinacionSecreta) + "\n";
		System.out.println(mostrarMensajeDerrota);

		return mostrarMensajeDerrota;
	}

	/**
	 * Muestra por pantalla un mensaje de despedida hacia el jugador.
	 * 
	 * @return Devuelve el mensaje almacenado en un String.
	 */
	public String mostrarMensajeDespedida() {

		String mensajeDespedida = "!Hasta pronto!";
		System.out.println(mensajeDespedida);

		return mensajeDespedida;
	}

	/**
	 * Muestra por pantalla un mensaje informando al jugador de que la entrada no ha
	 * sido valida.
	 * 
	 * @return Devuelve el mensaje almacenado en un String.
	 */
	public String mostrarOpcionInvalida() {

		String mostrarOpcionInvalida = "\nOpcion invalida, intentalo de nuevo.\n";
		System.out.println(mostrarOpcionInvalida);

		return mostrarOpcionInvalida;
	}
}