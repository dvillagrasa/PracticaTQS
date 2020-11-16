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

	static char opcionEscogida;

	static Vista vista = new Vista();
	static Modelo modelo = new Modelo();
	static Controlador controlador = new Controlador(vista, modelo);

	/**
	 * Constructor de la clase Controlador.
	 * 
	 * @param vista  - Instancia de la clase vista.
	 * @param modelo - Instancia de la clase modelo.
	 */
	public Controlador(Vista vista, Modelo modelo) {

	}

	/**
	 * Metodo principal del juego Mastermind.
	 * 
	 * @param args - String que contiene argumentos introducidos desde la linea de
	 *             comandos (en este caso, ninguno).
	 */
	public static void main(String[] args) {
		InterfazEscaner interfazEscaner = new Escaner();
		InterfazAleatorio interfazAleatorio = new Aleatorio();
		Controlador controladorMain = new Controlador(vista, modelo);
		controladorMain.gestorMastermind(interfazEscaner, interfazAleatorio);
	}

	/**
	 * Obtiene, a traves de la interfaz del escaner y de la interfaz del aleatorio
	 * las opciones y combinaciones introducidas por el usuario mediante el Scanner
	 * o introducida en el test mediante el MockObject y la combinacion secreta
	 * generada por Aleatorio o introducida en el test mediante el MockObject. A
	 * parte de esto, dependiendo de las opciones introducidas se iniciara el juego
	 * Mastermind o se finalizara la ejecucion del programa.
	 * 
	 * @param interfazEscaner   - Instancia de la interfaz InterfazEscaner.
	 * @param interfazAleatorio - Instancia de la interfaz InterfazAleatorio.
	 */
	public void gestorMastermind(InterfazEscaner interfazEscaner, InterfazAleatorio interfazAleatorio) {
		boolean salirMastermind = false;
		char[] opcionMenu;
		do {
			opcionMenu = controlador.gestorMenu(interfazEscaner);
			if (opcionMenu[0] == '1') {
				jugarMastermind(interfazEscaner, interfazAleatorio);
			}
			if (opcionMenu[0] == '2') {
				vista.mostrarMensajeDespedida();
				salirMastermind = true;
			}
		} while (!salirMastermind);
	}

	/**
	 * Obtiene, a traves de la interfaz del escaner las opciones introducidas por el
	 * usuario mediante el Scanner o introducida en el test mediante el MockObject.
	 * Mientras la opcion no sea valida el metodo seguira solicitando una opcion
	 * para el menu.
	 * 
	 * @param interfazEscaner - Instancia de la interfaz InterfazEscaner.
	 * @return Devuelve la opcion del menu validada.
	 */
	public char[] gestorMenu(InterfazEscaner interfazEscaner) {
		boolean esValida = false;
		char[] opcionMenuCasteada;
		do {
			vista.mostrarMenu();
			String opcionMenu = modelo.obtenerOpcionMenu(interfazEscaner);
			opcionMenuCasteada = modelo.castearOpcionMenu(opcionMenu);
			esValida = modelo.validarOpcionMenu(opcionMenuCasteada);

			if (!esValida) {
				vista.mostrarOpcionInvalida();
			}
		} while (!esValida);
		return opcionMenuCasteada;
	}

	/**
	 * Obtiene, a traves de la interfaz del escaner y de la interfaz del aleatorio
	 * las opciones y combinaciones introducidas por el usuario mediante el Scanner
	 * o introducida en el test mediante el MockObject y la combinacion secreta
	 * generada por Aleatorio o introducida en el test mediante el MockObject. A
	 * parte de esto si el numero de veces jugadas es inferior a MAX_INTENTOS (10)
	 * el controlador llamara a la vista para solicitar una combinacion a la
	 * interfazEscaner, una vez obtenida se convierte a un vector de caracteres y se
	 * valida. En caso de que no sea una combinacion valida se volvera a repetir el
	 * proceso hasta que sea valida. Seguidamente se realiza una comparacion entre
	 * la combinacion de la iterfazEscaner con la combinacion de la
	 * interfazAleatorio y se almacenan los resultados en un vector de caracteres.
	 * En funcion de este ultimo vector se comprueba si se ha conseguido la
	 * victoria, si se han agotado los intentos o se necesita volver a repetir todo
	 * el proceso, todo ello mostrando mensajes por pantalla, resultado de
	 * comunicarse con la vista.
	 * 
	 * @param interfazEscaner   - Instancia de la interfaz InterfazEscaner.
	 * @param interfazAleatorio - Instancia de la interfaz InterfazAleatorio.
	 */
	public void jugarMastermind(InterfazEscaner interfazEscaner, InterfazAleatorio interfazAleatorio) {
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