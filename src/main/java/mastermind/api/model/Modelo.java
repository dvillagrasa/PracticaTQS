package mastermind.api.model;

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
	 * Obtiene, a traves de la interfaz del escaner la opcion introducida por el
	 * usuario mediante el Scanner o introducida en el test mediante el MockObject.
	 * 
	 * @param interfazEscaner - Instancia de la interfaz InterfazEscaner.
	 * @return Devuelve un String con la opcion del Scanner o del MockObject.
	 */
	public String obtenerOpcionMenu(InterfazEscaner interfazEscaner) {
		String entrada = null;
		entrada = interfazEscaner.cogerOpcionMenu();
		return entrada;
	}

	/**
	 * Utiliza el retorno de obtenerOpcionMenu(InterfazEscaner interfazEscaner) para
	 * transformarlo de String a char.
	 * 
	 * @param opcionJugador - Retorno del metodo obtenerOpcionMenu(InterfazEscaner
	 *                      interfazEscaner).
	 * @return Devuelve un array de chars que contiene la opcion introducida
	 *         mediante el Scanner o el MockObject en forma de char.
	 */
	public char[] castearOpcionMenu(String opcionJugador) {
		char[] opcionJugadorCasteada = opcionJugador.toCharArray();
		return opcionJugadorCasteada;
	}

	/**
	 * Utiliza el retorno de castearOpcionMenu(String opcionJugador) para comprobar
	 * que el numero introducido mediante el Scanner o el MockObject es valido.
	 * 
	 * @param opcionCasteada - Retorno del metodo castearOpcionMenu(String
	 *                       opcionJugador).
	 * @return Devuelve true o false, dependiendo de si opcionCasteada es valida o
	 *         no.
	 */
	public boolean validarOpcionMenu(char[] opcionCasteada) {
		boolean esCorrecto = true;
		int i = 0;
		if(opcionCasteada.length == 1) {
			if((opcionCasteada[i] < '1') || (opcionCasteada[i] > '2')) {
				esCorrecto = false;
			}
		}
		else {
			esCorrecto = false;
		}
		/*if ((opcionCasteada.length != 1) || ((opcionCasteada[i] < '1') || (opcionCasteada[i] > '2'))) {
			esCorrecto = false;
		}*/
		return esCorrecto;
	}

	/**
	 * Obtiene, a traves de la interfaz del escaner la combinacion introducida por
	 * el usuario mediante el Scanner o introducida en el test mediante el
	 * MockObject.
	 * 
	 * @param interfazEscaner - Instancia de la interfaz InterfazEscaner.
	 * @return Devuelve un String con la combinacion del Scanner o del MockObject.
	 */
	public String obtenerCombinacionJugador(InterfazEscaner interfazEscaner) {
		String entrada = null;
		entrada = interfazEscaner.cogerEntradaJugador();
		return entrada;
	}

	/**
	 * Utiliza el retorno del metodo obtenerCombinacionJugador(InterfazEscaner
	 * interfazEscaner) para convertirlo a un vector de caracteres.
	 * 
	 * @param entradaJugador - Retorno del metodo
	 *                       obtenerCombinacionJugador(InterfazEscaner
	 *                       interfazEscaner).
	 * @return Devuelve un vector de caracteres.
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
	 * Obtiene, a traves de la interfaz del escaner la combinacion secreta generada
	 * por el juego mediante el Scanner o introducida en el test mediante el
	 * MockObject. A partir de esta combinacion secreta se comprueba que es valida,
	 * es decir, que contiene unicamente valores entre 0 y 8 (ambos incluidos).
	 * 
	 * @param interfazAleatorio - Instancia de la interfaz InterfazEscaner.
	 * @return Devuelve el vector de caracteres que almacena la combinacion secreta
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
	 * Utiliza los retornos de los metodos
	 * generarCombinacionSecreta(InterfazAleatorio interfazAleatorio) y
	 * castearCombinacionJugador(String entradaJugador) y comprueba la combinacion
	 * generada por la maquina y la combinacion itroducida por el jugador. En
	 * funcion de la combinacion introducida por el jugador se comprobara si los
	 * numeros existen y si estan bien ubicados respecto de la combinacion generada
	 * por la maquina.
	 * 
	 * @param combinacionSecreta - Retorno del metodo
	 *                           generarCombinacionSecreta(InterfazAleatorio
	 *                           interfazAleatorio).
	 * @param combinacionJugador - Retorno del metodo
	 *                           castearCombinacionJugador(String entradaJugador).
	 * @return Devuelve un vector de caracteres de 4 posiciones que contendra los
	 *         caracteres 0, N y/o B en funcion de la semejanza entre la combinacion
	 *         secreta y la combinacion del jugador.
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
	 * Utiliza el retorno del metodo compararCombinaciones(char[]
	 * combinacionSecreta, char[] combinacionJugador) para comprobar si el numero de
	 * aciertos negros almacenados en la posicion 0 del array de enteros es identico
	 * a MAX_CLAVIJAS. En caso de que sea identico (4 == 4) el booleano victoria se
	 * pondra a true. En caso contrario, seguira siendo false.
	 * 
	 * @param aciertos - retorno del metodo compararCombinaciones(char[]
	 *                 combinacionSecreta, char[] combinacionJugador) que almacenara
	 *                 los fallos (0), aciertos de numero (B) y los aciertos de
	 *                 numero y posicion (N).
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