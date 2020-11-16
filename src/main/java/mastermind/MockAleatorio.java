package mastermind;

import java.util.ArrayList;

/**
 * Clase MockAleatorio - Implementa la interfaz InterfazAleatorio. Obtiene
 * combinaciones aleatorias a partir de un ArrayList donde los numeros se
 * encuentran almacenados.
 * 
 * @author Daniel Luis Garcia
 * @author Daniel Villagrasa Ramirez
 *
 */
public class MockAleatorio implements InterfazAleatorio {

	ArrayList<String> listaAleatoria = new ArrayList<String>();
	int contador = 0;

	/**
	 * Constructor de la clase MockAleatorio. Almacena el vector de combinaciones
	 * aleatorias en un vector de la clase.
	 * 
	 * @param listaAleatoriaParametro - Vector de combinaciones aleatorias.
	 */
	public MockAleatorio(ArrayList<String> listaAleatoriaParametro) {
		listaAleatoria = listaAleatoriaParametro;
	}

	/**
	 * Obtiene una combinacion aleatoria del vector de la clase por cada vez que se
	 * ejecuta el metodo.
	 */
	public String obtenerValorAleatorio() {
		String combinacionAleaotriaSimulada = listaAleatoria.get(contador);
		contador++;

		return combinacionAleaotriaSimulada;
	}
}
