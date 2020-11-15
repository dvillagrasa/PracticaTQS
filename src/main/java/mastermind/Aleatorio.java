package mastermind;

import java.util.Random;

/**
 * Clase Aleatorio - Implementa la interfaz InterfazAleatorio. Realiza calculos
 * de numeros aleatorios y obtiene dichos numeros almacenados en un String.
 * 
 * @author Daniel Luis Garcia
 * @author Daniel Villagrasa Ramirez
 *
 */
public class Aleatorio implements InterfazAleatorio {

	String numAleatorio;
	int aux;

	/**
	 * Constructor de la clase Aleatorio. Este calcula 4 numeros aleatorios y los
	 * almacena en un String.
	 */
	public Aleatorio() {
		Random aleatorio = new Random();
		numAleatorio = "";
		for (int i = 0; i < 4; i++) {
			int aux = aleatorio.nextInt(9);
			numAleatorio += Integer.toString(aux);
		}
	}

	/**
	 * Obtiene un String de 4 numeros aleatorios.
	 * 
	 * @return Devuelve un String de 4 numeros aleatorios
	 */
	public String obtenerValorAleatorio() {
		return numAleatorio;
	}

}
