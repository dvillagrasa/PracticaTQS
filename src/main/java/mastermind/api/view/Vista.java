package mastermind.api.view;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//import java.util.Scanner;

/**
 * Clase Vista -  Debe mostrar únicamente los datos que el controlador nos pase.
	 Su función se limita a mostrar
 * 
 * @author Daniel Luis Garcia
 * @author Daniel Villagrasa Ramírez
 */
public class Vista {


	public Scanner escaner = new Scanner(System.in);

	private char[] WWW;
	private char[] AAA;
	// private String[] combinacionSecreta;

	public Vista() {
		// obtenido = new String[]{"1","2","3","4"};
		//WWW = new char[MAX_CLAVIJAS];
		//AAA = new char[MAX_CLAVIJAS];
		}

	
	public void solicitarCombinacion() {
		System.out.println("Inserta la combinación con el siguiente formato: XXXX");
	}
	
	public char[] obtenerEntradaJugador() {
		char[] entradaJugadorCasteada=null;

		if(escaner.hasNextLine()) {
			String entradaJugador = escaner.nextLine();
			entradaJugadorCasteada = entradaJugador.toCharArray();
		}
		//return Arrays.toString(entradaJugadorCasteada);
		return entradaJugadorCasteada;
	}
	
	public void comprobarEntradaJugador(char[] entradaJugadorCasteada) throws Exception {
		for(int i = 0; i < entradaJugadorCasteada.length; i++) {
			if((entradaJugadorCasteada[i] < '0') || (entradaJugadorCasteada[i] > '8')) {
				throw new Exception("El número " + entradaJugadorCasteada[i] + " está fuera del rango [0 - 8].");
			} /*else {
				System.out.println("El número " + entradaJugadorCasteada[i] + " es válido.");
			}*/
		}
	}
	
	public void mostrarJugada(char[] entradaJugadorCasteada, int vecesJugado) {
		System.out.println("Jugada #" + vecesJugado + " " + Arrays.toString(entradaJugadorCasteada) + "\n");
	}
}
