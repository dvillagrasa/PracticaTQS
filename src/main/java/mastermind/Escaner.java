package mastermind;

import java.util.Scanner;

/**
 * Clase Escaner - Esta clase implementa los metodos de la interfaz
 * InterfazEscaner y sera de utilidad en el momento que se necesite la entrada
 * por teclado de un jugador.
 * 
 * @author Daniel Luis Garcia
 * @author Daniel Villagrasa Ramirez
 * 
 */
public class Escaner implements InterfazEscaner {
	/**
	 * Constructor de la clase Escaner.
	 */
	public Escaner() {
		Scanner escaner = new Scanner(System.in);
	}

	/**
	 * Recoge la entrada de la combinacion del jugador introducida mediante teclado.
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
	 */
	public String cogerOpcionMenu() {
		String opcion;
		Scanner escaner = new Scanner(System.in);
		opcion = escaner.nextLine();

		return opcion;
	}
}
