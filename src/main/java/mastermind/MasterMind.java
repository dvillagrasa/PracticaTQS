package mastermind;

import mastermind.api.model.*;
import mastermind.api.view.*;
import mastermind.api.controller.*;
import java.util.Scanner;

/** 
 * Clase MasterMind - Clase principal del juego Master Mind que contiene el m�todo principal del juego.
 * 
 * @author Daniel Luis Garcia 
 * @author Daniel Villagrasa Ram�rez
 */ 
public class MasterMind {
	
	/**
	 * M�todo principal del juego Master Mind.
	 * 
	 * @param args - Array de cadena de car�cteres con los argumentos introducidos desde la l�nea de comandos.
	 */
	public static void main(String[] args) {
		
		Menu menu = new Menu();
		boolean esCorrecta = false;
		
		do {
			menu.mostrarMenu();
			int opcion;
			Scanner escaner = new Scanner(System.in);
			opcion = escaner.nextInt();
			
			esCorrecta = menu.comprobarOpcion(opcion);
			
			switch(opcion) {
				case 1:
					Vista vista = new Vista();
					Modelo modelo = new Modelo();
					Controlador controlador = new Controlador(vista, modelo);
					break;
				case 2:
					System.out.println("�Hasta pronto!");
					System.exit(0);
					break;
				default:
					System.out.println("Opci�n inv�lida, int�ntalo de nuevo.");
					break;
			}
		}while(esCorrecta);
	}
}