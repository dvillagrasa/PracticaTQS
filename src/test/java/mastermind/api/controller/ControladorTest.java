package mastermind.api.controller;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import mastermind.Aleatorio;
import mastermind.InterfazAleatorio;
import mastermind.InterfazEscaner;
import mastermind.MockAleatorio;
import mastermind.MockEscaner;
import mastermind.api.model.Modelo;
import mastermind.api.model.ModeloTest;
import mastermind.api.view.Vista;
import mastermind.api.view.VistaTest;

/**
 * Clase ControladorTest - Clase donde se encuentran los metodos de test
 * relacionados con el controlador del juego.
 * 
 * @author Daniel Luis Garcia
 * @author Daniel Villagrasa Ramirez
 */
public class ControladorTest {

	static String[] numeros = { "0", "1", "2", "3", "4", "5", "6", "7", "8" };

	/**
	 * Metodo de test que reune todos los tests disponibles para el juego
	 * Mastermind.
	 */
	@Test
	public void testTodoEnUno() {

		VistaTest vistaTest = new VistaTest();
		ModeloTest modeloTest = new ModeloTest();
		Vista vista = new Vista();
		Modelo modelo = new Modelo();
		Controlador controlador = new Controlador(null, null);

		
		testGestorMenu();
		testLogicaMastermind1();
		testLogicaMastermind2();
		testLogicaMastermind3();
		//testJuegaOtra();
		testInit1();
		testInit2();
		//modeloTest.testValidarJugarOtra();
		
		vistaTest.testMostrarMenu();
		modeloTest.testMockObtenerOpcionMenu();
		modeloTest.testComprobarOpcion();
		
		vistaTest.testSolicitarCombinacion();
		modeloTest.testMockObtenerEntradaJugador();
		modeloTest.validarCombinacionJugador();
		vistaTest.testMostrarJugada();
		modeloTest.testCompararCombinaciones();
		modeloTest.testComprobarVictoriaTodasCombinaciones();
		modeloTest.testComprobarVictoriaPairWise();
		vistaTest.testMostrarMensajeDerrota();
		vistaTest.testMostrarMensajeVictoria();
		vistaTest.testMostrarDespedida();
		vistaTest.testMostrarOpcionInvalida();
		modeloTest.testCastearEntradaJugadorPairWise();
		
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
	
	/*@Test 
	public void testJuegaOtra(){
		Vista vista = new Vista();
		Modelo modelo = new Modelo();
		Controlador controlador = new Controlador(vista,modelo);

		ArrayList<String> vectorSuposiciones = new ArrayList<String>();
		
		vectorSuposiciones.add("x");
		vectorSuposiciones.add("0");
		vectorSuposiciones.add("-");
		vectorSuposiciones.add("2");
		vectorSuposiciones.add("y"); // Por fin entra la opcionMenu
		vectorSuposiciones.add("b");
		
		InterfazEscaner interfazEscaner = new MockEscaner(vectorSuposiciones);
		
		//char suposicionEsperada = controlador.juegaOtra(interfazEscaner);
		//assertEquals(suposicionEsperada, 'y');
		
		ArrayList<String> vectorSuposiciones1 = new ArrayList<String>();

		vectorSuposiciones1.add("G");
		vectorSuposiciones1.add("t");
		vectorSuposiciones1.add("40");
		vectorSuposiciones1.add("*");
		vectorSuposiciones1.add("n"); // Por fin entra la opcionMenu
		vectorSuposiciones1.add("W");
		
		InterfazEscaner interfazEscaner1 = new MockEscaner(vectorSuposiciones1);

		//char suposicionEsperada1 = controlador.juegaOtra(interfazEscaner1);
		//assertEquals(suposicionEsperada1, 'n');
		
	}*/
	/**
	 * Cubre todo el metodo pero no gana la partida.
	 */
	//@Test
	public void testLogicaMastermind1() {
		
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
		
		controlador.logicaMastermind(interfazEscaner, interfazAleatorio);
	}

	/**
	 * Cubre todo el metodo pero no llega a que vecesJugado sea igual a MAX_INTENTOS porque gana.
	 */
	//@Test
	public void testLogicaMastermind2() {

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

		controlador.logicaMastermind(interfazEscanerVictoria, interfazAleatorio);
	}
	
	/**
	 * Cubre todo el metodo pero no muestra el mensaje de victoria.
	 */
	//@Test
	public void testLogicaMastermind3() {

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

		controlador.logicaMastermind(interfazEscanerVictoria, interfazAleatorio);
	}
	
	//@Test
	public void testInit1() {
		Vista vista = new Vista();
		Modelo modelo = new Modelo();
		Controlador controlador = new Controlador(vista, modelo);

		ArrayList<String> vectorEscaner = new ArrayList<String>();
		vectorEscaner.add("1");
		vectorEscaner.add("1234"); //1
		vectorEscaner.add("1234");
		vectorEscaner.add("1234");
		vectorEscaner.add("1234");
		vectorEscaner.add("1234");
		vectorEscaner.add("9203");
		vectorEscaner.add("32*5");
		vectorEscaner.add("1234");
		vectorEscaner.add("1234");
		vectorEscaner.add("1234");
		vectorEscaner.add("1234"); //9
		vectorEscaner.add("6");
		vectorEscaner.add("m");
		vectorEscaner.add("1");
		vectorEscaner.add("1234");
		vectorEscaner.add("1234");
		vectorEscaner.add("1234");
		vectorEscaner.add("7071");
		vectorEscaner.add("3");
		vectorEscaner.add("-");
		vectorEscaner.add("2");
		
		ArrayList<String> vectorAleatorio = new ArrayList<String>();
		vectorAleatorio.add("7070");
		vectorAleatorio.add("9503");
		vectorAleatorio.add("7071");
		vectorAleatorio.add("8831");

		InterfazEscaner interfazEscaner = new MockEscaner(vectorEscaner);
		InterfazAleatorio interfazAleatorio = new MockAleatorio(vectorAleatorio);

		controlador.init(interfazEscaner, interfazAleatorio);
		//controlador.init(interfazEscaner, interfazAleatorio);
		//controlador.init(interfazEscaner, interfazAleatorio);
	}
	
	//@Test
	public void testInit2() {
		Vista vista = new Vista();
		Modelo modelo = new Modelo();
		Controlador controlador = new Controlador(vista, modelo);

		ArrayList<String> vectorEscaner = new ArrayList<String>();
		vectorEscaner.add("1");
		vectorEscaner.add("1234"); //1
		vectorEscaner.add("1234");
		vectorEscaner.add("1234");
		vectorEscaner.add("1234");
		vectorEscaner.add("1234");
		vectorEscaner.add("1234");
		vectorEscaner.add("1234");
		vectorEscaner.add("1234");
		vectorEscaner.add("1234"); //9
		vectorEscaner.add("2");

		/*vectorEscaner.add("1234");
		vectorEscaner.add("1234");
		vectorEscaner.add("1234");
		vectorEscaner.add("1234");
		vectorEscaner.add("7070");*/
		
		ArrayList<String> vectorAleatorio = new ArrayList<String>();
		vectorAleatorio.add("7070");
		//vectorAleatorio.add("8080");

		InterfazEscaner interfazEscaner = new MockEscaner(vectorEscaner);
		InterfazAleatorio interfazAleatorio = new MockAleatorio(vectorAleatorio);

		
		controlador.init(interfazEscaner, interfazAleatorio);
	}

}