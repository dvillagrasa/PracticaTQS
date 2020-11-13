package mastermind.api.view;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;

/**
 * Clase VistaTest - Clase donde se encuentran los metodos de test relacionados
 * con la vista del juego.
 * 
 * @author Daniel Luis Garcia
 * @author Daniel Villagrasa Ramirez
 */
public class VistaTest {

	Vista vista = new Vista();

	/**
	 * Comprueba que el menu que muestra por pantalla el metodo mostrarmenu es el
	 * correcto.
	 */
	@Test
	public void testMostrarMenu() {
		String menuEsperado = "##############################\n" + "######### MASTERMIND #########\n"
				+ "##############################\n" + "###     [1] JUGAR          ###\n"
				+ "###     [2] SALIR          ###\n" + "##############################\n"
				+ "Selecciona una opcion (1 o 2).";

		assertEquals(menuEsperado, vista.mostrarMenu());
	}

	/**
	 * Comprueba que el mensaje que muestra por pantalla el metodo
	 * solicitarCombinacion es el correcto.
	 */
	@Test
	public void testSolicitarCombinacion() {
		String mensajeEsperado = "Inserta la combinacion con el siguiente formato: XXXX";
		assertEquals(mensajeEsperado, vista.solicitarCombinacion());
	}

	/**
	 * --------------- Test del metodo mostrarJugada --------------- Comprueba como
	 * se muestran las jugadas del jugador en una partida. Se utilizan entradas y
	 * resultados aleatorios para 9 jugadas.
	 * 
	 * mensajeEsperadoXXXXXXXX -> Mensaje que debe mostrar por pantalla.
	 * resultadoEntradaJugadorXXXX -> Valores casteados que introdujo el usuario.
	 * jugadaX -> Numero de jugada [1-9]. aciertosXXXXXXXX -> Semejanzas respecto la
	 * combinacion secreta.
	 */
	@Test
	public void testMostrarJugada() {

		String mensajeEsperado1234N0B0 = "Jugada #1 [1, 2, 3, 4] [N, 0, B, 0]";
		String mensajeEsperado8620NNNN = "Jugada #2 [8, 6, 2, 0] [N, N, N, N]";
		String mensajeEsperado51840000 = "Jugada #3 [5, 1, 8, 4] [0, 0, 0, 0]";
		String mensajeEsperado0184NB00 = "Jugada #4 [0, 1, 8, 4] [N, B, 0, 0]";
		String mensajeEsperado28160BBN = "Jugada #5 [2, 8, 1, 6] [0, B, B, N]";
		String mensajeEsperado7408BBBB = "Jugada #6 [7, 4, 0, 8] [B, B, B, B]";
		String mensajeEsperado3628NBNB = "Jugada #7 [3, 6, 2, 8] [N, B, N, B]";
		String mensajeEsperado6543BNBN = "Jugada #8 [6, 5, 4, 3] [B, N, B, N]";
		String mensajeEsperado41850NN0 = "Jugada #9 [4, 1, 8, 5] [0, N, N, 0]";

		char[] resultadoEntradaJugador1234 = { '1', '2', '3', '4' };
		char[] resultadoEntradaJugador8620 = { '8', '6', '2', '0' };
		char[] resultadoEntradaJugador5184 = { '5', '1', '8', '4' };
		char[] resultadoEntradaJugador0184 = { '0', '1', '8', '4' };
		char[] resultadoEntradaJugador2816 = { '2', '8', '1', '6' };
		char[] resultadoEntradaJugador7408 = { '7', '4', '0', '8' };
		char[] resultadoEntradaJugador3628 = { '3', '6', '2', '8' };
		char[] resultadoEntradaJugador6543 = { '6', '5', '4', '3' };
		char[] resultadoEntradaJugador4185 = { '4', '1', '8', '5' };

		int jugada1 = 1;
		int jugada2 = 2;
		int jugada3 = 3;
		int jugada4 = 4;
		int jugada5 = 5;
		int jugada6 = 6;
		int jugada7 = 7;
		int jugada8 = 8;
		int jugada9 = 9;

		char[] aciertos1234N0B0 = { 'N', '0', 'B', '0' };
		char[] aciertos8620NNNN = { 'N', 'N', 'N', 'N' };
		char[] aciertos51840000 = { '0', '0', '0', '0' };
		char[] aciertos0184NB00 = { 'N', 'B', '0', '0' };
		char[] aciertos28160BBN = { '0', 'B', 'B', 'N' };
		char[] aciertos7408BBBB = { 'B', 'B', 'B', 'B' };
		char[] aciertos3628NBNB = { 'N', 'B', 'N', 'B' };
		char[] aciertos6543BNBN = { 'B', 'N', 'B', 'N' };
		char[] aciertos41850NN0 = { '0', 'N', 'N', '0' };

		assertEquals(mensajeEsperado1234N0B0,
				vista.mostrarJugada(resultadoEntradaJugador1234, jugada1, aciertos1234N0B0));
		assertEquals(mensajeEsperado8620NNNN,
				vista.mostrarJugada(resultadoEntradaJugador8620, jugada2, aciertos8620NNNN));
		assertEquals(mensajeEsperado51840000,
				vista.mostrarJugada(resultadoEntradaJugador5184, jugada3, aciertos51840000));
		assertEquals(mensajeEsperado0184NB00,
				vista.mostrarJugada(resultadoEntradaJugador0184, jugada4, aciertos0184NB00));
		assertEquals(mensajeEsperado28160BBN,
				vista.mostrarJugada(resultadoEntradaJugador2816, jugada5, aciertos28160BBN));
		assertEquals(mensajeEsperado7408BBBB,
				vista.mostrarJugada(resultadoEntradaJugador7408, jugada6, aciertos7408BBBB));
		assertEquals(mensajeEsperado3628NBNB,
				vista.mostrarJugada(resultadoEntradaJugador3628, jugada7, aciertos3628NBNB));
		assertEquals(mensajeEsperado6543BNBN,
				vista.mostrarJugada(resultadoEntradaJugador6543, jugada8, aciertos6543BNBN));
		assertEquals(mensajeEsperado41850NN0,
				vista.mostrarJugada(resultadoEntradaJugador4185, jugada9, aciertos41850NN0));
	}

	/**
	 * --------------- Test del metodo mostrarMensajeVictoria ---------------
	 * Comprueba como se muestra el mensaje de victoria en una partida.
	 * 
	 * mensajeEsperado -> Mensaje que debe mostrar por pantalla.
	 * resultadoEntradaJugador -> Combinacion ganadora.
	 */
	@Test
	public void testMostrarMensajeVictoria() {
		char[] resultadoEntradaJugador = { '1', '2', '3', '4' };
		String mensajeEsperado = "!Felicidades, has ganado! \nHas acertado la combinacion secreta: "
				+ Arrays.toString(resultadoEntradaJugador);
		assertEquals(mensajeEsperado, vista.mostrarMensajeVictoria(resultadoEntradaJugador));

	}

	/**
	 * --------------- Test del metodo mostrarMensajeDerrota ---------------
	 * Comprueba como se muestra el mensaje de derrota en una partida.
	 * 
	 * mensajeEsperado -> Mensaje que debe mostrar por pantalla. combinacionSecreta
	 * -> Combinacion secreta generada por la maquina.
	 */
	@Test
	public void testMostrarMensajeDerrota() {
		char[] combinacionSecreta = { '5', '6', '2', '0' };
		String mensajeEsperado = "!Has perdido! \nLa combinacion secreta era: " + Arrays.toString(combinacionSecreta);
		assertEquals(mensajeEsperado, vista.mostrarMensajeDerrota(combinacionSecreta));

	}
	
	@Test
	public void testMostrarDespedida() {
		String despedidaEsperada = "!Hasta pronto!";
		assertEquals(despedidaEsperada, vista.mostrarMensajeDespedida());
	}
}