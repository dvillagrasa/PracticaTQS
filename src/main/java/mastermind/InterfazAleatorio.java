package mastermind;

/**
 * Interfaz InterfazAleatorio - Declara el String numeroAleatorio y declara el
 * metodo obtenerValorAleatorio() para ser usados en las clases Aleatorio y/o
 * MockAkeatorio.
 * 
 * @author Daniel Luis Garcia
 * @author Daniel Villagrasa Ramirez
 *
 */
public interface InterfazAleatorio {
	String numeroAleatorio = "";

	String obtenerValorAleatorio();
}
