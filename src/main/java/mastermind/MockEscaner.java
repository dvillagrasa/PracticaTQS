package mastermind;

import java.util.ArrayList;

/**
 * 
 * @author Daniel Luis Garcia
 * @author Daniel Villagrasa Ramirez
 *
 */
public class MockEscaner implements InterfazEscaner {
	ArrayList<String> vectorJugadas;
	int contador = 0;

	public MockEscaner(ArrayList<String> mockEntradaJugadorParametro) {
		vectorJugadas = mockEntradaJugadorParametro;
	}

	public String cogerEntradaJugador() {
		String entradaJugadorSimulada = vectorJugadas.get(contador);
		contador++;
		return entradaJugadorSimulada;
	}

	public String cogerOpcionMenu() {
		String opcionMenuSimulada = vectorJugadas.get(contador);
		contador++;
		return opcionMenuSimulada;
	}

}