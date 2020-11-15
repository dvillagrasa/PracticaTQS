package mastermind.api.controller;

import mastermind.Aleatorio;
import mastermind.Escaner;
import mastermind.InterfazAleatorio;
import mastermind.InterfazEscaner;
import mastermind.api.model.*;
import mastermind.api.view.*;

/**
 * Clase Controlador - Controla todo lo que sucede en el juego gracias al
 * tratamiento de datos obtenidos de las clases Vista y Modelo. Una vez estos
 * datos esten tratados los mandara a la clase Vista para poder ser mostrados
 * por pantalla.
 * 
 * @author Daniel Luis Garcia
 * @author Daniel Villagrasa Ramirez
 */
public class Controlador {
	
	/**
	 * Numero de jugadas que dispone el jugador para adivinar la combinacion
	 * generada por la maquina.
	 */
	public static final int MAX_INTENTOS = 10;
	String entradaJugador = null;
	char[] entradaJugadorCasteada = null;
	char[] aciertos;
	char[] combinacionSecretaCasteada;
	static char opcionSwitch;
	static char jugarOtra;
	char[] jugarOtra1;

	/**
	 * 
	 * @param vista  - Instancia de la clase vista.
	 * @param modelo - Instancia de la clase modelo.
	 */
	public Controlador(Vista vista, Modelo modelo) { }
	static Vista vista = new Vista();
	static Modelo modelo = new Modelo();
	static Controlador controlador = new Controlador(vista, modelo);

	/**
	 * Metodo principal del juego Master Mind.
	 * 
	 * @param args - Array de cadena de caracteres con los argumentos introducidos
	 *             desde la linea de comandos.
	 */
	public static void main(String[] args) {
		InterfazEscaner interfazEscaner = new Escaner();
		InterfazAleatorio interfazAleatorio = new Aleatorio();		
		Controlador controladorMain = new Controlador(vista, modelo);		
		controladorMain.init(interfazEscaner, interfazAleatorio);

	}
	
	public void init(InterfazEscaner interfazEscaner, InterfazAleatorio interfazAleatorio) {
		boolean salirMastermind = false;
		char opcionMenu;
		do {
			opcionMenu = controlador.gestorMenu(interfazEscaner);
			if (opcionMenu == '1') {
				logicaMastermind(interfazEscaner, interfazAleatorio);
			} 
			if (opcionMenu == '2') {
				vista.mostrarMensajeDespedida();
				salirMastermind = true;
			}
		} while(!salirMastermind);
	}

	public char gestorMenu(InterfazEscaner interfazEscaner) {
		boolean esValida = false;
		do {
			vista.mostrarMenu();
			String opcionMenu = modelo.obtenerOpcionMenu(interfazEscaner);
			char[] opcionMenuCasteada = modelo.castearOpcionMenu(opcionMenu);
			esValida = modelo.validarOpcionMenu(opcionMenuCasteada);
			opcionSwitch = opcionMenu.charAt(0);
			if (!esValida) {
				vista.mostrarOpcionInvalida();
			}
		} while (!esValida);
		return opcionSwitch;
	}
	
	/**
	 * Realiza las llamadas a los metodos de la clase Vista y Modelo y controlara
	 * que el jugador alcance la victoria o agote el numero de turnos en funcion de
	 * sus jugadas y de la combinacion aleatoria generada por la maquina. El flujo
	 * del controlador es el siguiente:
	 * 
	 * Mientras el numero de veces jugadas sea menor a MAX_INTENTOS se mostrara por
	 * pantalla la solicitud de introduccion de combinacion al jugador y se
	 * almacenara. Seguidamente, mientras la entrada del jugador sea incorrecta se
	 * volvera a solicitar una combinacion al jugador sin incrementar el numero de
	 * jugadas y se almacenara. Cuando la entrada del jugador sea valida, se
	 * realizara una comprobacion entre la entrada del jugador y la combinacion
	 * aleatoria generada por la maquina y se almacenara. Seguidamente, se
	 * comprobara si el jugador ha acertado la combinacion generada por la maquina
	 * y, en ese caso, se mostrara un mensaje de victoria junto con la combinacion
	 * ganadora. En caso contrario, se seguira el curso de la partida mostrando el
	 * numero de jugada junto con el intento y los aciertos correspondientes en
	 * calidad de blancos o negros. Cuando el numero de veces jugado llegue a
	 * MAX_INTENTOS se mostrara por pantalla un mensaje de derrota junto con la
	 * combinacion generada por la maquina y finalizara la partida.
	 */
	public void logicaMastermind(InterfazEscaner interfazEscaner, InterfazAleatorio interfazAleatorio) {
		char[] combinacionSecretaCasteada = Modelo.generarCombinacionSecreta(interfazAleatorio);
		int vecesJugado = 1;
		while (vecesJugado < MAX_INTENTOS) {
			vista.solicitarCombinacion();
			entradaJugador = modelo.obtenerCombinacionJugador(interfazEscaner);
			entradaJugadorCasteada = modelo.castearCombinacionJugador(entradaJugador);
			while (!modelo.validarCombinacionJugador(entradaJugadorCasteada)) {
				vista.solicitarCombinacion();
				entradaJugador = modelo.obtenerCombinacionJugador(interfazEscaner);
				entradaJugadorCasteada = modelo.castearCombinacionJugador(entradaJugador);
			} 
			aciertos = Modelo.compararCombinaciones(combinacionSecretaCasteada, entradaJugadorCasteada);
			if (Modelo.comprobarVictoria(aciertos)) {
				vista.mostrarMensajeVictoria(entradaJugadorCasteada);
				break;
			} else {
				vista.mostrarJugada(entradaJugadorCasteada, vecesJugado, aciertos);
				vecesJugado++;
				if (vecesJugado == MAX_INTENTOS) {
					vista.mostrarMensajeDerrota(combinacionSecretaCasteada);
				}
			}
		}
		vecesJugado = 1;
	}
}