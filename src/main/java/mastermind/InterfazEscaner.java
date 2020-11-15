package mastermind;

/**
 * Interfaz InterfazEscaner - Esta interfaz sera de utilidad en el momento que
 * se necesite realizar un escaneado de entradas mediante teclado (Clase
 * Escaner) o bien mediante datos de test (Clase MockEscaner).
 * 
 * @author Daniel Luis Garcia
 * @author Daniel Villagrasa Ramirez
 *
 */
public interface InterfazEscaner {

	String cogerEntradaJugador();

	String cogerOpcionMenu();

}
