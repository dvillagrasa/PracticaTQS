package mastermind.api.model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Clase Modelo - Realiza cálculos y proporciona los resultados que son necesarios para uilizar en nuestro programa.
 *  
 * @author Daniel Luis Garcia
 * @author Daniel Villagrasa Ramírez
 */
public class Modelo {

	/**
	 * Número de posiciones del tablero del juego. En este caso son 4 tanto para los números (serían los colores 
	 * exceptuando el blanco y negro), como para mostrar los aciertos de números y/o posición (serían los 
	 * colores blanco y negro).
	 */
	public static final int MAX_CLAVIJAS = 4;	

	/**
	 * Variable que permite obtener un valor aleatorio dentro de un conjunto de datos.
	 */
	public static final Random aleatorio = new Random(); // función a la que llamamos para que nos devuelva un aleatorio
	
	/**
	 * Array de cadenas de carácteres de un rango de 0 a 8, que son los números para el código aleatorio secreto.
	 */
	static String[] numeros = {"0","1","2","3","4","5","6","7","8"};

	/**
	 * Genera la combinación aleatoria de la partida a partir de una cola que contiene los números del 0 al 8,
	 * ambos incluídos. De esta cola se extraen de forma aleatoria y sin repetición 4 números que formarán parte
	 * de la combinación aleatoria.
	 * 
	 * @return Devuelve el array de carácteres que almacena la combinación aleatoria de la partida. 
	 */
	public static char[][] generarCombinacionAleatoria(){
		
		String[] combinacionAleatoria = new String [4];
		char[][] combinacionAleatoriaCasteada = new char [combinacionAleatoria.length][];
		
		ArrayList<String> cola = new ArrayList<>();
		for(int i = 0; i < numeros.length; i++) { // Por cada valor del array de cadena de carácteres.
			cola.add(numeros[i]); // Se añade a la cola.
		}
		//System.out.println(cola); // Imprime [0, 1, 2, 3, 4, 5, 6, 7, 8]
		for(int i = 0; i < 4; i++) { // Por cada número de la cola hasta hacerlo 4 veces.
			int numAleatorio = aleatorio.nextInt(cola.size()); // Variable que almacena un entero que se encuentra dentro de la cola.
			combinacionAleatoria[i] = cola.get(numAleatorio); // El número seleccionado de forma aleatoria se añade al array de la combinación aleatoria.
			cola.remove(numAleatorio); // Se elimina de la cola el número seleccionado de forma aleatoria.
			
			combinacionAleatoriaCasteada[i] = combinacionAleatoria[i].toCharArray(); //Convierte cada posición del array de cadena de carácteres a tipo carácter y lo almacena en un array de carácteres.
		}
		return combinacionAleatoriaCasteada;
	}
	/**
	 * Recibe un array de cadena de carácteres el cual convierte a un array de carácteres para poder ser utilizado
	 * en el resto de métodos del programa.	
	 * 
	 * @param entradaJugador - Array de cadena de carácteres con la entrada del jugador separada por carácteres.
	 * @return Devuelve el array de cadena de carácteres transformado a array de carácteres.
	 */
	public char[][] castearEntradaJugador(String[] entradaJugador) {
		char[][] entradaJugadorCasteada = new char[entradaJugador.length][];
		
		for(int i = 0; i < entradaJugador.length; i++) { // Por cada elemento del array de cadena de carácteres.
			entradaJugadorCasteada[i] = entradaJugador[i].toCharArray(); // Convierte cada posición del array de cadena de carácteres a tipo carácter y lo almacena en un array de carácteres.
		}
		return entradaJugadorCasteada;
	}
	/**
	 * Comprueba que los carácteres que el jugador ha introducido por teclado sean entre 0 y 8, ambos incluídos.
	 * 
	 * @param entradaJugadorCasteada - Array de carácteres de la función obtenerEntradaJugador().
	 * @return Devuelve un booleano que será true cuando toda la entrada del jugador sean carácteres dentro del
	 * rango de 0 a 8 (ambos incluídos).
	 */
	public static boolean comprobarEntradaJugador(char[][] entradaJugadorCasteada) {
		
		boolean entradaJugadorCorrecta = true;
		
		if(entradaJugadorCasteada.length == MAX_CLAVIJAS) {
			for(int i = 0; i < entradaJugadorCasteada.length; i++) { // Por cada elemento del array de carácteres.
				if((entradaJugadorCasteada[i][0] < '0') || (entradaJugadorCasteada[i][0] > '8')) { // Comprobamos si se encuentra fuera del rango [0-8].
					entradaJugadorCorrecta = false; // Se pone entradaJugadorCorrecta a falso.
					break;
					//throw new Exception("El número " + entradaJugadorCasteada[i] + " está fuera del rango [0 - 8]."); // Si se ejecuta la execpción nunca hará el return.
				}
			}
			//entradaJugadorCorrecta = false; // Se pone entradaJugadorCorrecta a falso.
			//return entradaJugadorCorrecta;
		} else {
			entradaJugadorCorrecta = false;
			return entradaJugadorCorrecta;
		}
		return entradaJugadorCorrecta; // En caso de que todos los elementos del array de carácteres se encuentren en el rango [0-8] entradaJugadorCorrecta será true.
	}
	
	/**
	 * Comprueba la combinación generada por la máquina y la combinación itroducida por el jugador. En función de la combinación
	 * introducida por el jugador se comprobará si los números existen y si están bien ubicados respecto de la combinación
	 * generada por la máquina.
	 * 
	 * @param aleatoria - Combinacion aleatoria generada por la máquina.
	 * @param usuario - Combinación introducida por el jugador.
	 * @return Devuelve un array de enteros de 2 posiciones. La posición 0 almacena el nº de aciertos negros y la posición
	 * 1 almacena el nº de aciertos blancos.
	 */
	public static int[] compararCombinaciones(char[][] aleatoria, char[][] usuario) {

		char[][] combinacionAleatoria = aleatoria;
		char[][] combinacionJugador = usuario;
		
		int aciertosNegros = 0; // Acierto de número y posición.
		int aciertosBlancos = 0; // Acierto de número, pero no de posición.
		
		for(int i = 0; i < MAX_CLAVIJAS; i++){
			for (int j = 0; j < combinacionAleatoria.length; j++) {
				if(combinacionAleatoria[i][0] == combinacionJugador[j][0]) {
					if(combinacionAleatoria[i][0] == combinacionJugador[i][0]) {
						aciertosNegros++; // Incrementa el número de aciertos de números y la posición del mismo.
					} else {
						aciertosBlancos++; // Incrementa el número de aciertos de números.
					}
				}
			}
		}
		return new int[] {aciertosNegros, aciertosBlancos}; // [0]: aciertosNegros, [1]: aciertosBlancos.
	}
	
	/**
	 * Comprueba si el número de aciertos negros almacenados en la posición 0 del array de enteros es idéntico a MAX_CLAVIJAS.
	 * En caso de que sea idéntico (4 == 4, no existe otra posibilidad) el flag ganar se pondrá a true. En caso contrario, 
	 * seguirá siendo false.
	 * 
	 * @param aciertos - Array de enteros de 2 posiciones. La posición 0 almacena el nº de aciertos negros y la posición
	 * 1 almacena el nº de aciertos blancos.
	 * @return Devuelve true si el número de aciertos negros es igual a 4, en caso contrario, devuelve false.
	 */
	public static boolean comprobarVictoria(int[] aciertos) {
		
		boolean victoria = false;
		if(aciertos[0] == MAX_CLAVIJAS) { // Si el número de aciertos negros almacenados en la posición 0 es idéntica a MAX_CLAVIJAS.
			victoria = true;
		}
		return victoria; // Será falso si la condición no se cumple.
	}
}