package mastermind.api.controller;

import java.util.ArrayList;

import mastermind.api.model.*;
import mastermind.api.view.*;
/** 
 * Clase Controlador - Como su nombre indica controlará todo lo que sucede 
 * en el juego y se comunicará con el modelo, tratará los datos y los enviará a la vista
 * 
 * @author Daniel Luis Garcia 
 * @author Daniel Villagrasa Ramírez
 */ 
public class Controlador {
	
	Vista Vista;
	Modelo Modelo;
	
	public static final int MAX_INTENTOS = 9;
	public int vecesJugado = 0;
	
	/*
	 * Controlador del programa, hará las llamadas a funciones de vista y modelo
	 * controlará que se haya ganado o agotado turnos
	 */
		
	public Controlador(Vista vista, Modelo modelo) throws Exception {
		Modelo = modelo;
		Vista = vista;
		
		char[] res = null;
		ArrayList<Integer> combinacionAleatoria = Modelo.generarCombinacionAleatoria();
		try {
			while (vecesJugado < MAX_INTENTOS) {
				Vista.solicitarCombinacion();
				res = Vista.obtenerEntradaJugador();
				Vista.comprobarEntradaJugador(res);
				Vista.mostrarJugada(res,vecesJugado);
				vecesJugado++;
			}
			
			System.out.println("La combinación secreta era: " + combinacionAleatoria);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}
	}

