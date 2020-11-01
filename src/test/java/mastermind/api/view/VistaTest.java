package mastermind.api.view;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;


public class VistaTest{
	
	/**
	 * entrada es un array de cadena de carácteres que será usado para realizar pruebas de
	 * la función comprobarEntradaJugador().
	 */
	private static final char[][] entrada = {{'0'}, {'2'} , {'9'} , {'4'}};
	
	/*
	 * Bueno, te comento: Esta función de test es diferente a la otra. Aquí no estamos comprobando que 
	 * el output generado sea correcto, sino que el input introducido se trate bien, por lo que hay que 
	 * probar LO DE DENTRO de la función. Mi idea ha sido la de replicar la misma función que tenemos en la vista
	 * pero primero en el test (creo que lo suyo habría sido hacer esta antes que la de la vista).
	 * Básicamente lo que se está haciendo es simular una partida en la que siempre se introducen los mismos númeos
	 * lo que controlamos es que sean números enteros entre 0 y 8. He retocado cosas en las excepciones y habría que tener en cuenta otras condiciones
	 */

	//@Test
	//public void comprobarEntradaJugador() throws Exception {
	@Test
	public void testcomprobarEntradaJugador() {
		boolean esperado = false;
		boolean resultado = Vista.comprobarEntradaJugador(entrada);
		
		assertEquals(resultado, esperado);
	}
}
