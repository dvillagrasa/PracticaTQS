package mastermind.api.controller;

import mastermind.api.model.*;
import mastermind.api.view.*;

/** 
 * Clase Controlador - Controla todo lo que sucede en el juego gracias al tratamiento de datos
 * obtenidos de las clases Vista y Modelo. Una vez estos datos est�n tratados los mandar� a la
 * clase Vista para poder ser mostrados por pantalla.
 * 
 * @author Daniel Luis Garcia 
 * @author Daniel Villagrasa Ram�rez
 */ 
public class Controlador {
	/**
	 * N�mero de jugadas que dispone el jugador para adivinar la combinaci�n generada por la m�quina.
	 */
	public static final int MAX_INTENTOS = 10;
	
	/**
	 * Variable que almacenar� el n�mero de jugadas del jugador. La primera de todas ser� igual a 1.
	 */
	public int vecesJugado = 1;
	
	/**
	 * Realiza las llamadas a los m�todos de la clase Vista y Modelo y controlar� que el 
	 * jugador alcance la victoria o agote el n�mero de turnos en funci�n de sus jugadas y
	 * de la combinaci�n aleatoria generada por la m�quina. El flujo del controlador es el
	 * siguiente:
	 * 
	 * Mientras el n�mero de veces jugadas sea menor a MAX_INTENTOS se mostrar� por pantalla 
	 * la solicitud de introducci�n de combinaci�n al jugador y se almacenar�. Seguidamente, 
	 * mientras la entrada del jugador sea incorrecta se volver� a solicitar una combinaci�n 
	 * al jugador sin incrementar el n�mero de jugadas y se almacenar�. Cuando la entrada del 
	 * jugador sea v�lida, se realizar� una comprobaci�n entre la entrada del jugador y la
	 * combinaci�n aleatoria generada por la m�quina y se almacenar�. Seguidamente, se 
	 * comprobar� si el jugador ha acertado la combinaci�n generada por la m�quina y, en ese
	 * caso, se mostrar� un mensaje de victoria junto con la combinaci�n ganadora. En caso 
	 * contrario, se seguir� el curso de la partida mostrando el n�mero de jugada junto con 
	 * el intento y los aciertos correspondientes en calidad de blancos o negros. Cuando el
	 * n�mero de veces jugado llegue a MAX_INTENTOS se mostrar� por pantalla un mensaje de
	 * derrota junto con la combinaci�n generada por la m�quina y finalizar� la partida.
	 *  
	 * @param vista - Instancia de la clase vista.
	 * @param modelo - Instancia de la clase modelo.
	 */
	public Controlador(Vista vista, Modelo modelo){
		
		char[][] resultadoEntradaJugador = null;
		int[] aciertos;

		try {
			char[][] combinacionAleatoria = mastermind.api.model.Modelo.generarCombinacionAleatoria();
			
			while (vecesJugado < MAX_INTENTOS) { // Mientras el n�mero de veces jugadas sea menor a MAX_INTENTOS
				vista.solicitarCombinacion(); // Muestra por pantalla la solicitud de introducci�n de combinaci�n al jugador.
				resultadoEntradaJugador = vista.obtenerEntradaJugador(); // Se almacena la entrada del jugador.
				while(!mastermind.api.model.Modelo.comprobarEntradaJugador(resultadoEntradaJugador)) { // Mientras la entrada del jugador sea incorrecta.
					vista.solicitarCombinacion(); // Vuelve a solicitar una combinaci�n al jugador sin incrementar el n�mero de jugadas.
					resultadoEntradaJugador = vista.obtenerEntradaJugador(); // Se almacena la entrada del jugador.
				}
				aciertos = mastermind.api.model.Modelo.compararCombinaciones(combinacionAleatoria, resultadoEntradaJugador);
				
				if (mastermind.api.model.Modelo.comprobarVictoria(aciertos)) { // Si el jugador ha acertado la combinaci�n aleatoria.
					vista.mostrarMensajeVictoria(resultadoEntradaJugador); // Se muestra el mensaje de victoria junto con la combinaci�n del jugador.
					break; // �?
				} else { // Si el jugador no ha acertado la combinaci�n aleatoria
					vista.mostrarJugada(resultadoEntradaJugador, vecesJugado, aciertos); // Se muestra la nueva jugada del jugador.
					vecesJugado++; // Incrementa el n�mero de veces jugadas de la partida.
				}

			}
			vista.mostrarMensajeDerrota(combinacionAleatoria); // Se muestra el mensaje de derrota junto con la combinaci�n aleatoria.
			//System.out.println("La combinaci�n secreta era: " + combinacionAleatoria);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}
	}

