package mastermind.api.controller;

import mastermind.api.model.*;
import mastermind.api.view.*;

/** 
 * Clase Controlador - Controla todo lo que sucede en el juego gracias al tratamiento de datos
 * obtenidos de las clases Vista y Modelo. Una vez estos datos esten tratados los mandara a la
 * clase Vista para poder ser mostrados por pantalla.
 * 
 * @author Daniel Luis Garcia 
 * @author Daniel Villagrasa Ramirez
 */ 
public class Controlador {
	/**
	 * Numero de jugadas que dispone el jugador para adivinar la combinacion generada por la maquina.
	 */
	public static final int MAX_INTENTOS = 10;
	
	/**
	 * Variable que almacenara el numero de jugadas del jugador. La primera de todas sera igual a 1.
	 */
	public int vecesJugado = 1;
	
	/**
	 * Array de cadenas de caracteres de un rango de 0 a 8, que son los numeros para el codigo aleatorio secreto.
	 */
	static String[] numeros = {"0","1","2","3","4","5","6","7","8"};
	
	Vista vista = new Vista();
	Modelo modelo = new Modelo();
	String entradaJugador = null;
	char[] entradaJugadorCasteada = null;
	char[] aciertos;
	char[] combinacionSecretaCasteada;
	
	/**
	 * Realiza las llamadas a los metodos de la clase Vista y Modelo y controlara que el 
	 * jugador alcance la victoria o agote el numero de turnos en funcion de sus jugadas y
	 * de la combinacion aleatoria generada por la maquina. El flujo del controlador es el
	 * siguiente:
	 * 
	 * Mientras el numero de veces jugadas sea menor a MAX_INTENTOS se mostrara por pantalla 
	 * la solicitud de introduccion de combinacion al jugador y se almacenara. Seguidamente, 
	 * mientras la entrada del jugador sea incorrecta se volvera a solicitar una combinacion 
	 * al jugador sin incrementar el numero de jugadas y se almacenara. Cuando la entrada del 
	 * jugador sea valida, se realizara una comprobacion entre la entrada del jugador y la
	 * combinacion aleatoria generada por la maquina y se almacenara. Seguidamente, se 
	 * comprobara si el jugador ha acertado la combinacion generada por la maquina y, en ese
	 * caso, se mostrara un mensaje de victoria junto con la combinacion ganadora. En caso 
	 * contrario, se seguira el curso de la partida mostrando el numero de jugada junto con 
	 * el intento y los aciertos correspondientes en calidad de blancos o negros. Cuando el
	 * numero de veces jugado llegue a MAX_INTENTOS se mostrara por pantalla un mensaje de
	 * derrota junto con la combinacion generada por la maquina y finalizara la partida.
	 *  
	 * @param vista - Instancia de la clase vista.
	 * @param modelo - Instancia de la clase modelo.
	 */
	public Controlador(Vista vista, Modelo modelo) {
		
		try {
			do {
				combinacionSecretaCasteada = mastermind.api.model.Modelo.generarCombinacionSecreta(numeros);
			} while(!modelo.validarCombinacionSecreta(combinacionSecretaCasteada));
				
			while (vecesJugado < MAX_INTENTOS) {
				vista.solicitarCombinacion();
				entradaJugador = vista.obtenerCombinacionJugador();
				entradaJugadorCasteada = modelo.castearEntradaJugador(entradaJugador);
				
				while(!Modelo.validarEntradaJugador(entradaJugadorCasteada)) {
					vista.solicitarCombinacion();						
					entradaJugador = vista.obtenerCombinacionJugador();
					entradaJugadorCasteada = modelo.castearEntradaJugador(entradaJugador);
				}
				
				aciertos = mastermind.api.model.Modelo.compararCombinaciones(combinacionSecretaCasteada, entradaJugadorCasteada);
				
				if (mastermind.api.model.Modelo.comprobarVictoria(aciertos)) {
					vista.mostrarMensajeVictoria(entradaJugadorCasteada);
					break;
				} else {
					vista.mostrarJugada(entradaJugadorCasteada, vecesJugado, aciertos);
					vecesJugado++;
				}
			}
			if(vecesJugado == MAX_INTENTOS) {
				vista.mostrarMensajeDerrota(combinacionSecretaCasteada);
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}