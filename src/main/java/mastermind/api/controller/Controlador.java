package mastermind.api.controller;

import mastermind.api.model.*;
import mastermind.api.view.*;

/** 
 * Clase Controlador - Como su nombre indica controlar� todo lo que sucede 
 * en el juego y se comunicar� con el modelo, tratar� los datos y los enviar� a la vista
 * 
 * @author Daniel Luis Garcia 
 * @author Daniel Villagrasa Ram�rez
 */ 
public class Controlador {
	
	Vista Vista;
	Modelo Modelo;
	
	public static final int MAX_INTENTOS = 10;
	public int vecesJugado = 1;
	
	/*
	 * Controlador del programa, har� las llamadas a funciones de vista y modelo
	 * controlar� que se haya ganado o agotado turnos
	 */
		
	public Controlador(Vista vista, Modelo modelo){
		Modelo = modelo;
		Vista = vista;
		
		char[][] resultadoEntradaJugador = null;
		int[] aciertos;
		//ArrayList<Integer> combinacionAleatoria = Modelo.generarCombinacionAleatoria();
		try {
			char[][] combinacionAleatoria = mastermind.api.model.Modelo.generarCombinacionAleatoria();
			while (vecesJugado < MAX_INTENTOS) {
				Vista.solicitarCombinacion();
				resultadoEntradaJugador = Vista.obtenerEntradaJugador();
				while(!mastermind.api.model.Modelo.comprobarEntradaJugador(resultadoEntradaJugador)) {
					Vista.solicitarCombinacion();
					resultadoEntradaJugador = Vista.obtenerEntradaJugador();
				}
				aciertos = mastermind.api.model.Modelo.CompararCombinaciones(combinacionAleatoria, resultadoEntradaJugador);
				if (mastermind.api.model.Modelo.haGanado(aciertos)) { //llamada a funci�n que compruebe si hemos ganado
					Vista.haGanado(resultadoEntradaJugador);
					break;
				} else { //no hemos ganado
					Vista.mostrarJugada(resultadoEntradaJugador,vecesJugado,aciertos);
					vecesJugado++;
				}

			}
			Vista.haPerdido(combinacionAleatoria);
			//System.out.println("La combinaci�n secreta era: " + combinacionAleatoria);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}
	}

