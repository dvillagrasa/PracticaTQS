package mastermind.api.controller;

import mastermind.api.model.*;
import mastermind.api.view.*;

/** 
 * Clase Controlador - Controla todo lo que sucede en el juego gracias al tratamiento de datos
 * obtenidos de las clases Vista y Modelo. Una vez estos datos estén tratados los mandará a la
 * clase Vista para poder ser mostrados por pantalla.
 * 
 * @author Daniel Luis Garcia 
 * @author Daniel Villagrasa Ramírez
 */ 
public class Controlador {
	/**
	 * Número de jugadas que dispone el jugador para adivinar la combinación generada por la máquina.
	 */
	public static final int MAX_INTENTOS = 10;
	
	/**
	 * Variable que almacenará el número de jugadas del jugador. La primera de todas será igual a 1.
	 */
	public int vecesJugado = 1;
	
	/**
	 * Realiza las llamadas a los métodos de la clase Vista y Modelo y controlará que el 
	 * jugador alcance la victoria o agote el número de turnos en función de sus jugadas y
	 * de la combinación aleatoria generada por la máquina. El flujo del controlador es el
	 * siguiente:
	 * 
	 * Mientras el número de veces jugadas sea menor a MAX_INTENTOS se mostrará por pantalla 
	 * la solicitud de introducción de combinación al jugador y se almacenará. Seguidamente, 
	 * mientras la entrada del jugador sea incorrecta se volverá a solicitar una combinación 
	 * al jugador sin incrementar el número de jugadas y se almacenará. Cuando la entrada del 
	 * jugador sea válida, se realizará una comprobación entre la entrada del jugador y la
	 * combinación aleatoria generada por la máquina y se almacenará. Seguidamente, se 
	 * comprobará si el jugador ha acertado la combinación generada por la máquina y, en ese
	 * caso, se mostrará un mensaje de victoria junto con la combinación ganadora. En caso 
	 * contrario, se seguirá el curso de la partida mostrando el número de jugada junto con 
	 * el intento y los aciertos correspondientes en calidad de blancos o negros. Cuando el
	 * número de veces jugado llegue a MAX_INTENTOS se mostrará por pantalla un mensaje de
	 * derrota junto con la combinación generada por la máquina y finalizará la partida.
	 *  
	 * @param vista - Instancia de la clase vista.
	 * @param modelo - Instancia de la clase modelo.
	 */
	public Controlador(Vista vista, Modelo modelo){
		
		char[][] resultadoEntradaJugador = null;
		int[] aciertos;

		try {
			char[][] combinacionAleatoria = mastermind.api.model.Modelo.generarCombinacionAleatoria();
			
			while (vecesJugado < MAX_INTENTOS) { // Mientras el número de veces jugadas sea menor a MAX_INTENTOS
				vista.solicitarCombinacion(); // Muestra por pantalla la solicitud de introducción de combinación al jugador.
				resultadoEntradaJugador = vista.obtenerEntradaJugador(); // Se almacena la entrada del jugador.
				while(!mastermind.api.model.Modelo.comprobarEntradaJugador(resultadoEntradaJugador)) { // Mientras la entrada del jugador sea incorrecta.
					vista.solicitarCombinacion(); // Vuelve a solicitar una combinación al jugador sin incrementar el número de jugadas.
					resultadoEntradaJugador = vista.obtenerEntradaJugador(); // Se almacena la entrada del jugador.
				}
				aciertos = mastermind.api.model.Modelo.compararCombinaciones(combinacionAleatoria, resultadoEntradaJugador);
				
				if (mastermind.api.model.Modelo.comprobarVictoria(aciertos)) { // Si el jugador ha acertado la combinación aleatoria.
					vista.mostrarMensajeVictoria(resultadoEntradaJugador); // Se muestra el mensaje de victoria junto con la combinación del jugador.
					break; // ¿?
				} else { // Si el jugador no ha acertado la combinación aleatoria
					vista.mostrarJugada(resultadoEntradaJugador, vecesJugado, aciertos); // Se muestra la nueva jugada del jugador.
					vecesJugado++; // Incrementa el número de veces jugadas de la partida.
				}

			}
			vista.mostrarMensajeDerrota(combinacionAleatoria); // Se muestra el mensaje de derrota junto con la combinación aleatoria.
			//System.out.println("La combinación secreta era: " + combinacionAleatoria);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}
	}

