package mastermind.api.model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Clase Modelo - Realiza c�lculos y proporciona los resultados que son necesarios para uilizar en nuestro programa.
 *  
 * @author Daniel Luis Garcia
 * @author Daniel Villagrasa Ram�rez
 */
public class Modelo {

	/**
	 * N�mero de posiciones del tablero del juego. En este caso son 4 tanto para los n�meros (ser�an los colores 
	 * exceptuando el blanco y negro), como para mostrar los aciertos de n�meros y/o posici�n (ser�an los 
	 * colores blanco y negro).
	 */
	public static final int MAX_CLAVIJAS = 4;	

	/**
	 * Variable que permite obtener un valor aleatorio dentro de un conjunto de datos.
	 */
	public static final Random aleatorio = new Random(); // funci�n a la que llamamos para que nos devuelva un aleatorio
	
	/**
	 * Array de cadenas de car�cteres de un rango de 0 a 8, que son los n�meros para el c�digo aleatorio secreto.
	 */
	static String[] numeros = {"0","1","2","3","4","5","6","7","8"};

	/**
	 * Genera la combinaci�n aleatoria de la partida a partir de una cola que contiene los n�meros del 0 al 8,
	 * ambos inclu�dos. De esta cola se extraen de forma aleatoria y sin repetici�n 4 n�meros que formar�n parte
	 * de la combinaci�n aleatoria.
	 * 
	 * @return Devuelve el array de car�cteres que almacena la combinaci�n aleatoria de la partida. 
	 */
	public static char[][] generarCombinacionAleatoria(){
		
		String[] combinacionAleatoria = new String [4];
		char[][] combinacionAleatoriaCasteada = new char [combinacionAleatoria.length][];
		
		ArrayList<String> cola = new ArrayList<>();
		for(int i = 0; i < numeros.length; i++) { // Por cada valor del array de cadena de car�cteres.
			cola.add(numeros[i]); // Se a�ade a la cola.
		}
		//System.out.println(cola); // Imprime [0, 1, 2, 3, 4, 5, 6, 7, 8]
		for(int i = 0; i < 4; i++) { // Por cada n�mero de la cola hasta hacerlo 4 veces.
			int numAleatorio = aleatorio.nextInt(cola.size()); // Variable que almacena un entero que se encuentra dentro de la cola.
			combinacionAleatoria[i] = cola.get(numAleatorio); // El n�mero seleccionado de forma aleatoria se a�ade al array de la combinaci�n aleatoria.
			cola.remove(numAleatorio); // Se elimina de la cola el n�mero seleccionado de forma aleatoria.
			
			combinacionAleatoriaCasteada[i] = combinacionAleatoria[i].toCharArray(); //Convierte cada posici�n del array de cadena de car�cteres a tipo car�cter y lo almacena en un array de car�cteres.
		}
		return combinacionAleatoriaCasteada;
	}
	/**
	 * Recibe un array de cadena de car�cteres el cual convierte a un array de car�cteres para poder ser utilizado
	 * en el resto de m�todos del programa.	
	 * 
	 * @param entradaJugador - Array de cadena de car�cteres con la entrada del jugador separada por car�cteres.
	 * @return Devuelve el array de cadena de car�cteres transformado a array de car�cteres.
	 */
	public char[][] castearEntradaJugador(String[] entradaJugador) {
		char[][] entradaJugadorCasteada = new char[entradaJugador.length][];
		
		for(int i = 0; i < entradaJugador.length; i++) { // Por cada elemento del array de cadena de car�cteres.
			entradaJugadorCasteada[i] = entradaJugador[i].toCharArray(); // Convierte cada posici�n del array de cadena de car�cteres a tipo car�cter y lo almacena en un array de car�cteres.
		}
		return entradaJugadorCasteada;
	}
	/**
	 * Comprueba que los car�cteres que el jugador ha introducido por teclado sean entre 0 y 8, ambos inclu�dos.
	 * 
	 * @param entradaJugadorCasteada - Array de car�cteres de la funci�n obtenerEntradaJugador().
	 * @return Devuelve un booleano que ser� true cuando toda la entrada del jugador sean car�cteres dentro del
	 * rango de 0 a 8 (ambos inclu�dos).
	 */
	public static boolean comprobarEntradaJugador(char[][] entradaJugadorCasteada) {
		
		boolean entradaJugadorCorrecta = true;
		
		if(entradaJugadorCasteada.length == MAX_CLAVIJAS) {
			for(int i = 0; i < entradaJugadorCasteada.length; i++) { // Por cada elemento del array de car�cteres.
				if((entradaJugadorCasteada[i][0] < '0') || (entradaJugadorCasteada[i][0] > '8')) { // Comprobamos si se encuentra fuera del rango [0-8].
					entradaJugadorCorrecta = false; // Se pone entradaJugadorCorrecta a falso.
					break;
					//throw new Exception("El n�mero " + entradaJugadorCasteada[i] + " est� fuera del rango [0 - 8]."); // Si se ejecuta la execpci�n nunca har� el return.
				}
			}
			//entradaJugadorCorrecta = false; // Se pone entradaJugadorCorrecta a falso.
			//return entradaJugadorCorrecta;
		} else {
			entradaJugadorCorrecta = false;
			return entradaJugadorCorrecta;
		}
		return entradaJugadorCorrecta; // En caso de que todos los elementos del array de car�cteres se encuentren en el rango [0-8] entradaJugadorCorrecta ser� true.
	}
	
	/**
	 * Comprueba la combinaci�n generada por la m�quina y la combinaci�n itroducida por el jugador. En funci�n de la combinaci�n
	 * introducida por el jugador se comprobar� si los n�meros existen y si est�n bien ubicados respecto de la combinaci�n
	 * generada por la m�quina.
	 * 
	 * @param aleatoria - Combinacion aleatoria generada por la m�quina.
	 * @param usuario - Combinaci�n introducida por el jugador.
	 * @return Devuelve un array de enteros de 2 posiciones. La posici�n 0 almacena el n� de aciertos negros y la posici�n
	 * 1 almacena el n� de aciertos blancos.
	 */
	public static int[] compararCombinaciones(char[][] aleatoria, char[][] usuario) {

		char[][] combinacionAleatoria = aleatoria;
		char[][] combinacionJugador = usuario;
		
		int aciertosNegros = 0; // Acierto de n�mero y posici�n.
		int aciertosBlancos = 0; // Acierto de n�mero, pero no de posici�n.
		
		for(int i = 0; i < MAX_CLAVIJAS; i++){
			for (int j = 0; j < combinacionAleatoria.length; j++) {
				if(combinacionAleatoria[i][0] == combinacionJugador[j][0]) {
					if(combinacionAleatoria[i][0] == combinacionJugador[i][0]) {
						aciertosNegros++; // Incrementa el n�mero de aciertos de n�meros y la posici�n del mismo.
					} else {
						aciertosBlancos++; // Incrementa el n�mero de aciertos de n�meros.
					}
				}
			}
		}
		return new int[] {aciertosNegros, aciertosBlancos}; // [0]: aciertosNegros, [1]: aciertosBlancos.
	}
	
	/**
	 * Comprueba si el n�mero de aciertos negros almacenados en la posici�n 0 del array de enteros es id�ntico a MAX_CLAVIJAS.
	 * En caso de que sea id�ntico (4 == 4, no existe otra posibilidad) el flag ganar se pondr� a true. En caso contrario, 
	 * seguir� siendo false.
	 * 
	 * @param aciertos - Array de enteros de 2 posiciones. La posici�n 0 almacena el n� de aciertos negros y la posici�n
	 * 1 almacena el n� de aciertos blancos.
	 * @return Devuelve true si el n�mero de aciertos negros es igual a 4, en caso contrario, devuelve false.
	 */
	public static boolean comprobarVictoria(int[] aciertos) {
		
		boolean victoria = false;
		if(aciertos[0] == MAX_CLAVIJAS) { // Si el n�mero de aciertos negros almacenados en la posici�n 0 es id�ntica a MAX_CLAVIJAS.
			victoria = true;
		}
		return victoria; // Ser� falso si la condici�n no se cumple.
	}
}