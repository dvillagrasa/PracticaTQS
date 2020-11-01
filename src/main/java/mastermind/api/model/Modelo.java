package mastermind.api.model;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;


import mastermind.api.view.*;

/**
 * Clase Modelo - Esta clase se encargar� de c�lculos y de dar valores/objetos que tengamos
 * que utilizar en nuestro programa.
 *  
 * @author Daniel Luis Garcia
 * @author Daniel Villagrasa Ram�rez
 */
public class Modelo {

	/**
	 * MAX_CLAVIJAS es el n�mero de posiciones del tablero del juego. En este caso son 4
	 * tanto para los n�meros (ser�an los colores exceptuando el blanco y negro), como 
	 * para mostrar los aciertos de n�meros y/o posici�n (ser�an los colores blanco y negro).
	 */
	public static final int MAX_CLAVIJAS = 4;	
	/**
	 * aleatorio es la variable que nos permite obtener un n�mero aleatorio dentro de un
	 * conjunto de datos.
	 */
	public static final Random aleatorio = new Random(); // funci�n a la que llamamos para que nos devuelva un aleatorio
	/**
	 * numeros es un array de cadenas de car�cteres. Estos car�cteres establecen un rango
	 * de 0 a 8, que son los n�meros que pueden ser usados tanto para las tiradas del
	 * jugador como para el c�digo aleatorio secreto.
	 */
	static String[] numeros = {"0","1","2","3","4","5","6","7","8"};
	
	/**
	 * generarCombinacionAleatoria devuelve un array de cadena de car�cteres. Este array es 
	 * la combinaci�n secreta del juego, la cual deber� ser adivinada por el jugador.
	 * 
	 * @return Devuelve el array de cadenas de car�cteres secreto. 
	 */
	public static char[][] generarCombinacionAleatoria(){
		
		String[] combinacionAleatoria = new String [4];
		char[][] combinacionAleatoriaCasteada = new char [combinacionAleatoria.length][];
		
		ArrayList<String> cola = new ArrayList<>();
		for(int i = 0; i < 9; i++) {
			cola.add(numeros[i]);
		}
		//System.out.println(cola); // Imprime [0, 1, 2, 3, 4, 5, 6, 7, 8]
		for(int i = 0; i < 4; i++) //Saca 5 numeros de la cola, as� quedan 4.
		{
			int numAleatorio = aleatorio.nextInt(cola.size());
			combinacionAleatoria[i] = cola.get(numAleatorio);
			cola.remove(numAleatorio);
			
			combinacionAleatoriaCasteada[i] = combinacionAleatoria[i].toCharArray(); 
		}
		System.out.println(cola); // Imprime la cola sin 4 n�meros.
		System.out.println("La combinaci�n aleatoria es: " + Arrays.deepToString(combinacionAleatoriaCasteada)); // Imprime [[X],[X],[X],[X]]

		return combinacionAleatoriaCasteada;
	}
}