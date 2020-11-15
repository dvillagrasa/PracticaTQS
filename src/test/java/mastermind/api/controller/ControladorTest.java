package mastermind.api.controller;

import mastermind.InterfazAleatorio;
import mastermind.InterfazEscaner;
import mastermind.MockAleatorio;
import mastermind.MockEscaner;
import mastermind.api.model.Modelo;
import mastermind.api.model.ModeloTest;
import mastermind.api.view.Vista;
import mastermind.api.view.VistaTest;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Test;

/**
 * Clase ControladorTest - Clase donde se encuentran los metodos de test
 * relacionados con el controlador del juego.
 * 
 * @author Daniel Luis Garcia
 * @author Daniel Villagrasa Ramirez
 */
public class ControladorTest {

	/**
	 * Metodo de test que reune todos los tests disponibles para el juego
	 * Mastermind.
	 */
	@Test
	public void testTodoEnUno() {

		// Instancias de las clases VistaTest y ModeloTest.
		VistaTest vistaTest = new VistaTest();
		ModeloTest modeloTest = new ModeloTest();
		
		// Tests de la clase ControladorTest.
		testGestorMenu();
		testJugarMastermind1();
		testJugarMastermind2();
		testJugarMastermind3();
		testgestorMastermind1();
		testgestorMastermind2();
		
		// Tests de la clase ModeloTest.
		modeloTest.testMockObtenerOpcionMenu();
		modeloTest.testComprobarOpcion();
		modeloTest.testMockObtenerEntradaJugador();
		modeloTest.validarCombinacionJugador();
		modeloTest.testCompararCombinaciones();
		modeloTest.testComprobarVictoriaTodasCombinaciones();
		modeloTest.testComprobarVictoriaPairWise();
		modeloTest.testCastearEntradaJugadorPairWise();
		
		// Tests de la clase VistaTest.
		vistaTest.testSolicitarCombinacion();
		vistaTest.testMostrarMenu();
		vistaTest.testMostrarJugada();
		vistaTest.testMostrarMensajeDerrota();
		vistaTest.testMostrarMensajeVictoria();
		vistaTest.testMostrarDespedida();
		vistaTest.testMostrarOpcionInvalida();

		Vista vista = new Vista();
		Modelo modelo = new Modelo();
		Controlador controlador = new Controlador(vista, modelo);
	
		String args[] = null;
		Controlador.main(args);
	}

	
	//@Test
	public void testGestorMenu() {
		Vista vista = new Vista();
		Modelo modelo = new Modelo();
		Controlador controlador = new Controlador(vista,modelo);

		ArrayList<String> vectorSuposiciones = new ArrayList<String>();
		
		vectorSuposiciones.add("0");
		vectorSuposiciones.add("a");
		vectorSuposiciones.add("99");
		vectorSuposiciones.add("-");
		vectorSuposiciones.add("1"); // Por fin entra la opcionMenu
		vectorSuposiciones.add("b");
		
		InterfazEscaner interfazEscaner = new MockEscaner(vectorSuposiciones);
		
		char suposicionEsperada = controlador.gestorMenu(interfazEscaner);
		assertEquals(suposicionEsperada, '1');
		
		ArrayList<String> vectorSuposiciones1 = new ArrayList<String>();

		vectorSuposiciones1.add("3");
		vectorSuposiciones1.add("t");
		vectorSuposiciones1.add("40");
		vectorSuposiciones1.add("*");
		vectorSuposiciones1.add("2"); // Por fin entra la opcionMenu
		vectorSuposiciones1.add("W");
		
		InterfazEscaner interfazEscaner1 = new MockEscaner(vectorSuposiciones1);

		char suposicionEsperada1 = controlador.gestorMenu(interfazEscaner1);
		assertEquals(suposicionEsperada1, '2');
	}
	
	/**
	 * Cubre todo el metodo pero no gana la partida.
	 */
	//@Test
	public void testJugarMastermind1() {
		
		Vista vista = new Vista();
		Modelo modelo = new Modelo();
		Controlador controlador = new Controlador(vista,modelo);
		
		ArrayList<String> vectorSuposiciones = new ArrayList<String>();
						
		vectorSuposiciones.add("5902");
		vectorSuposiciones.add("5");
		vectorSuposiciones.add("5082785274");
		vectorSuposiciones.add("5-82");
		vectorSuposiciones.add("320");
		vectorSuposiciones.add("9999");
		vectorSuposiciones.add("*+*2");
		vectorSuposiciones.add("5863"); // Por fin la acepta como combinacion secreta.
		vectorSuposiciones.add("1234");
		
		InterfazAleatorio interfazAleatorio = new MockAleatorio(vectorSuposiciones);
				
		ArrayList<String> vectorSuposicionesDerrota = new ArrayList<String>();
		vectorSuposicionesDerrota.add("96999");
		vectorSuposicionesDerrota.add("1234"); //1
		vectorSuposicionesDerrota.add("12-4");
		vectorSuposicionesDerrota.add("1234"); //2
		vectorSuposicionesDerrota.add("1234"); //3 
		vectorSuposicionesDerrota.add("1234"); //4
		vectorSuposicionesDerrota.add("1234"); //5
		vectorSuposicionesDerrota.add("1234"); //6
		vectorSuposicionesDerrota.add("5602"); //7
		vectorSuposicionesDerrota.add("1234"); //8
		vectorSuposicionesDerrota.add("1234"); //9
		
		InterfazEscaner interfazEscaner = new MockEscaner(vectorSuposicionesDerrota);
		
		controlador.jugarMastermind(interfazEscaner, interfazAleatorio);
	}

	/**
	 * Cubre todo el metodo pero no llega a que vecesJugado sea igual a MAX_INTENTOS porque gana.
	 */
	//@Test
	public void testJugarMastermind2() {

		Vista vista = new Vista();
		Modelo modelo = new Modelo();
		Controlador controlador = new Controlador(vista, modelo);

		ArrayList<String> vectorSuposiciones = new ArrayList<String>();

		vectorSuposiciones.add("5902");
		vectorSuposiciones.add("5");
		vectorSuposiciones.add("5082785274");
		vectorSuposiciones.add("5-82");
		vectorSuposiciones.add("320");
		vectorSuposiciones.add("9999");
		vectorSuposiciones.add("*+*2");
		vectorSuposiciones.add("5863"); // Por fin la acepta como combinacion secreta.
		vectorSuposiciones.add("1234");

		InterfazAleatorio interfazAleatorio = new MockAleatorio(vectorSuposiciones);

		ArrayList<String> vectorSuposicionesVictoria = new ArrayList<String>();
		vectorSuposicionesVictoria.add("96999");
		vectorSuposicionesVictoria.add("1234"); // 1
		vectorSuposicionesVictoria.add("12-4");
		vectorSuposicionesVictoria.add("1234"); // 2
		vectorSuposicionesVictoria.add("1234"); // 3
		vectorSuposicionesVictoria.add("1234"); // 4
		vectorSuposicionesVictoria.add("1234"); // 5
		vectorSuposicionesVictoria.add("1234"); // 6
		vectorSuposicionesVictoria.add("5602"); // 7
		vectorSuposicionesVictoria.add("1234"); // 8
		vectorSuposicionesVictoria.add("5863"); // 9

		InterfazEscaner interfazEscanerVictoria = new MockEscaner(vectorSuposicionesVictoria);

		controlador.jugarMastermind(interfazEscanerVictoria, interfazAleatorio);
	}
	
	/**
	 * Cubre todo el metodo pero no muestra el mensaje de victoria.
	 */
	//@Test
	public void testJugarMastermind3() {

		Vista vista = new Vista();
		Modelo modelo = new Modelo();
		Controlador controlador = new Controlador(vista, modelo);

		ArrayList<String> vectorSuposiciones = new ArrayList<String>();

		vectorSuposiciones.add("5902");
		vectorSuposiciones.add("5");
		vectorSuposiciones.add("5082785274");
		vectorSuposiciones.add("5-82");
		vectorSuposiciones.add("320");
		vectorSuposiciones.add("9999");
		vectorSuposiciones.add("*+*2");
		vectorSuposiciones.add("5863"); // Por fin la acepta como combinacion secreta.
		vectorSuposiciones.add("1234");

		InterfazAleatorio interfazAleatorio = new MockAleatorio(vectorSuposiciones);

		ArrayList<String> vectorSuposicionesVictoria = new ArrayList<String>();
		vectorSuposicionesVictoria.add("96999");
		vectorSuposicionesVictoria.add("1234"); // 1
		vectorSuposicionesVictoria.add("12-4");
		vectorSuposicionesVictoria.add("1234"); // 2
		vectorSuposicionesVictoria.add("1234"); // 3
		vectorSuposicionesVictoria.add("1234"); // 4
		vectorSuposicionesVictoria.add("1234"); // 5
		vectorSuposicionesVictoria.add("1234"); // 6
		vectorSuposicionesVictoria.add("5602"); // 7
		vectorSuposicionesVictoria.add("1234"); // 8
		vectorSuposicionesVictoria.add("0304"); // 9

		InterfazEscaner interfazEscanerVictoria = new MockEscaner(vectorSuposicionesVictoria);

		controlador.jugarMastermind(interfazEscanerVictoria, interfazAleatorio);
	}
	
	/**
	 * Simulacion de una partida que termina con derrota y seguidamente vuelve a
	 * jugar otra partida que termina en victoria.
	 */
	//@Test
	public void testgestorMastermind1() {
		Vista vista = new Vista();
		Modelo modelo = new Modelo();
		Controlador controlador = new Controlador(vista, modelo);

		ArrayList<String> vectorEscaner = new ArrayList<String>();
		vectorEscaner.add("1"); // Selecciona la opcion 1 del menu.
		vectorEscaner.add("123");
		vectorEscaner.add("123*");
		vectorEscaner.add("1238");
		vectorEscaner.add("1234"); // Jugada #1.
		vectorEscaner.add("1234");
		vectorEscaner.add("1234");
		vectorEscaner.add("1234");
		vectorEscaner.add("1234");
		vectorEscaner.add("9203");
		vectorEscaner.add("32*5");
		vectorEscaner.add("1234");
		vectorEscaner.add("1234");
		vectorEscaner.add("1234");
		vectorEscaner.add("1234"); // Jugada #9 -> DERROTA.
		vectorEscaner.add("6");
		vectorEscaner.add("m");
		vectorEscaner.add("1"); // Selecciona la opcion 1 del menu.
		vectorEscaner.add("1234"); // Jugada #1.
		vectorEscaner.add("1234"); // Jugada #2.
		vectorEscaner.add("1234"); // Jugada #3.
		vectorEscaner.add("7071"); // Jugada #4 -> VICTORIA.
		vectorEscaner.add("3");
		vectorEscaner.add("-");
		vectorEscaner.add("2"); // Selecciona la opcion 2 del menu.
		
		ArrayList<String> vectorAleatorio = new ArrayList<String>();
		vectorAleatorio.add("700");
		vectorAleatorio.add("701*");
		vectorAleatorio.add("7019");
		vectorAleatorio.add("7070");
		vectorAleatorio.add("9503");
		vectorAleatorio.add("7071");
		vectorAleatorio.add("8831");

		InterfazEscaner interfazEscaner = new MockEscaner(vectorEscaner);
		InterfazAleatorio interfazAleatorio = new MockAleatorio(vectorAleatorio);

		controlador.gestorMastermind(interfazEscaner, interfazAleatorio);
	}
	
	/**
	 * Simulacion de una partida que termina con derrota y seguidamente se sale del
	 * juego.
	 */
	//@Test
	public void testgestorMastermind2() {
		Vista vista = new Vista();
		Modelo modelo = new Modelo();
		Controlador controlador = new Controlador(vista, modelo);

		ArrayList<String> vectorEscaner = new ArrayList<String>();
		vectorEscaner.add("1"); // Selecciona la opcion 1 del menu.
		vectorEscaner.add("1234"); // Jugada #1.
		vectorEscaner.add("1234");
		vectorEscaner.add("1234");
		vectorEscaner.add("1234");
		vectorEscaner.add("1234");
		vectorEscaner.add("1234");
		vectorEscaner.add("1234");
		vectorEscaner.add("1234");
		vectorEscaner.add("1234"); // Jugada #9 -> DERROTA.
		vectorEscaner.add("2"); // Selecciona la opcion 2 del menu. 

		ArrayList<String> vectorAleatorio = new ArrayList<String>();
		vectorAleatorio.add("7070");

		InterfazEscaner interfazEscaner = new MockEscaner(vectorEscaner);
		InterfazAleatorio interfazAleatorio = new MockAleatorio(vectorAleatorio);

		controlador.gestorMastermind(interfazEscaner, interfazAleatorio);
	}
}