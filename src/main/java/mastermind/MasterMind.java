package mastermind;

import mastermind.api.view.*;
import mastermind.api.controller.*;
import mastermind.api.model.*;

/** 
 * Clase MasterMind - abcdefghijk
 * @author Daniel Luis Garcia 
 * @author Daniel Villagrasa Ramírez
 */ 
public class MasterMind {
	public static void main(String[] args) {//Main del programa, llamamos a los constructores de cada clase	
		Vista vista = new Vista();
		Modelo modelo = new Modelo();
		Controlador controlador = new Controlador (vista, modelo);
	}
}
