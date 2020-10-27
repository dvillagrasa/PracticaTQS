package mastermind.api.controller;

import java.util.ArrayList;

import mastermind.api.model.*;
import mastermind.api.view.*;
/** 
 * Clase Controlador - abcdefghijk
 * @author Daniel Luis Garcia 
 * @author Daniel Villagrasa Ramírez
 */ 
public class Controlador {//clase Controlador. Como su nombre indica controlará todo lo que sucede en el juego y se comunicará con el modelo, tratará los datos y los enviará a la vista
	
	Vista Vista;
	Modelo Modelo;
		
	public Controlador(Vista vista, Modelo modelo) {
		Modelo = modelo;
		Vista = vista;
		
		ArrayList<Integer> combinacionAleatoria = Modelo.generarCombinacionAleatoria();
		
		Vista.dibujarTablero(combinacionAleatoria);
		Vista.PedirNumeros();
		}
}
