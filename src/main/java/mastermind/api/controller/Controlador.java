package mastermind.api.controller;

import java.util.ArrayList;

import mastermind.api.model.*;
import mastermind.api.view.*;
/** 
 * Clase Controlador - abcdefghijk
 * @author Daniel Luis Garcia 
 * @author Daniel Villagrasa Ram�rez
 */ 
public class Controlador {//clase Controlador. Como su nombre indica controlar� todo lo que sucede en el juego y se comunicar� con el modelo, tratar� los datos y los enviar� a la vista
	
	Vista Vista;
	Modelo Modelo;
		
	public Controlador(Vista vista, Modelo modelo) throws Exception {
		Modelo = modelo;
		Vista = vista;
		
		ArrayList<Integer> combinacionAleatoria = Modelo.generarCombinacionAleatoria();
		//String[] combinacionJugador = Vista.pedirNumeros();
		//char[] entradaJugadorObtenida = Vista.obtenerEntradaJugador();
		//Vista.pedirNumeros();
		
		Vista.buclePrincipal(combinacionAleatoria);
		/*try {
			Vista.comprobarEntradaJugador(entradaJugadorObtenida);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();*/
	}
		//Vista.dibujarTablero(combinacionAleatoria);
}

