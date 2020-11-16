package mastermind;

import java.util.ArrayList;

/**
 * Clase MockEscaner - Implementa la interfaz InterfazEscaner. Obtiene
 * combinaciones y opciones de menu a partir de un ArrayList donde los numeros
 * se encuentran almacenados.
 * 
 * @author Daniel Luis Garcia
 * @author Daniel Villagrasa Ramirez
 *
 */
public class MockEscaner implements InterfazEscaner {

	ArrayList<String> vectorJugadas;
	int contador = 0;

	/**
	 * Constructor de la clase MockEscaner. Almacena el vector de combinaciones y
	 * opciones de menu en un vector de la clase.
	 * 
	 * @param mockEntradaJugadorParametro
	 */
	public MockEscaner(ArrayList<String> mockEntradaJugadorParametro) {
		vectorJugadas = mockEntradaJugadorParametro;
	}

	/**
	 * Obtiene una combinacion del vector de la clase por cada vez que se ejecuta el
	 * metodo.
	 */
	public String cogerEntradaJugador() {
		String entradaJugadorSimulada = vectorJugadas.get(contador);
		contador++;
		return entradaJugadorSimulada;
	}

	/**
	 * Obtiene una opcion de menu del vector de la clase por cada vez que se ejecuta
	 * el metodo.
	 */
	public String cogerOpcionMenu() {
		String opcionMenuSimulada = vectorJugadas.get(contador);
		contador++;
		return opcionMenuSimulada;
	}

}