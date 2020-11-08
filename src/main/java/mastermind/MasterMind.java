package mastermind;

import mastermind.api.view.*;
import mastermind.api.controller.*;
import mastermind.api.model.*;

/** 
 * Clase MasterMind - Clase principal del juego Master Mind que contiene el método principal del juego.
 * 
 * @author Daniel Luis Garcia 
 * @author Daniel Villagrasa Ramírez
 */ 
public class MasterMind {
	
	/**
	 * Método principal del juego Master Mind. Aquí se generan llamadas a los constructores de las clases
	 * Vista, Modelo y Controlador.
	 * 
	 * @param args - Array de cadena de carácteres con los argumentos introducidos desde la línea de comandos.
	 */
	public static void main(String[] args) {
		Vista vista = new Vista();
		Modelo modelo = new Modelo();
		Controlador controlador = new Controlador (vista, modelo);
	}
}
