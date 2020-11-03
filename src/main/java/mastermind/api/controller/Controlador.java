package mastermind.api.controller;

import java.util.ArrayList;

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
		boolean fin = false;
		
		//ArrayList<Integer> combinacionAleatoria = Modelo.generarCombinacionAleatoria();
		try {
			char[][] combinacionAleatoria = mastermind.api.model.Modelo.generarCombinacionAleatoria();
			while (vecesJugado < MAX_INTENTOS) {
				Vista.solicitarCombinacion();
				resultadoEntradaJugador = Vista.obtenerEntradaJugador();
				aciertos = mastermind.api.model.Modelo.CompararCombinaciones(combinacionAleatoria, resultadoEntradaJugador);
				System.out.println("Aciertos Negros: " + aciertos[0]);
				System.out.println("Aciertos Blancos: " + aciertos[1]);
				if (mastermind.api.model.Modelo.haGanado(aciertos)) { //llamada a funci�n que compruebe si hemos ganado
					System.out.println("Has Ganado!!! ");
					break;
				} else { //no hemos ganado
					while(!mastermind.api.view.Vista.comprobarEntradaJugador(resultadoEntradaJugador)) { //Equivale a una especie de trow
						Vista.solicitarNuevamenteCombinacion();
						resultadoEntradaJugador = Vista.obtenerEntradaJugador();
						Vista.mostrarJugada(resultadoEntradaJugador,vecesJugado);
						vecesJugado++;
					}
				}
			}
			//System.out.println("La combinaci�n secreta era: " + combinacionAleatoria);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}
	}

