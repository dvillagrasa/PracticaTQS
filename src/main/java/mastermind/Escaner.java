package mastermind;

import java.util.Scanner;

/**
 * Clase Escaner - Implementa la interfaz InterfazEscaner. Obtiene la entrada
 * del menu y de la combinacion por teclado.
 * 
 * @author Daniel Luis Garcia
 * @author Daniel Villagrasa Ramirez
 * 
 */
public class Escaner implements InterfazEscaner {
	/**
	 * Constructor de la clase Escaner. Inicializa una instancia de la clase
	 * Scanner.
	 */
	public Escaner() {
		Scanner escaner = new Scanner(System.in);
	}

	/**
	 * Recoge la entrada de la combinacion del jugador introducida mediante teclado.
	 * 
	 * @return Devuelve un String con la combinacion del jugador.
	 */
	public String cogerEntradaJugador() {

		String entradaJugador = null;
		Scanner escaner = new Scanner(System.in);

		if (escaner.hasNextLine()) {
			entradaJugador = escaner.nextLine();
		}
		return entradaJugador;
	}

	/**
	 * Recoge la opcion del menu introducida por el jugador mediante el teclado.
	 * 
	 * @return Devuelve un String con la entrada del menu del jugador.
	 */
	public String cogerOpcionMenu() {
		String opcion;
		Scanner escaner = new Scanner(System.in);
		opcion = escaner.nextLine();

		return opcion;
	}
}
