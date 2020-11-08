package mastermind;

import mastermind.api.view.*;
import mastermind.api.controller.*;
import mastermind.api.model.*;

/** 
 * Clase MasterMind - Clase principal del juego Master Mind que contiene el m�todo principal del juego.
 * 
 * @author Daniel Luis Garcia 
 * @author Daniel Villagrasa Ram�rez
 */ 
public class MasterMind {
	
	/**
	 * M�todo principal del juego Master Mind. Aqu� se generan llamadas a los constructores de las clases
	 * Vista, Modelo y Controlador.
	 * 
	 * @param args - Array de cadena de car�cteres con los argumentos introducidos desde la l�nea de comandos.
	 */
	public static void main(String[] args) {
		Vista vista = new Vista();
		Modelo modelo = new Modelo();
		Controlador controlador = new Controlador (vista, modelo);
	}
}
