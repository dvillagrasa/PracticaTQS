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

	public static final int MAX_INTENTOS = 9;
	public static final int MAX_CLAVIJAS = 4;

	private String suposicion[][];
	private String respuesta[];
	// private String[] combinacionSecreta;

	public Vista() {
		// obtenido = new String[]{"1","2","3","4"};
		suposicion = new String[MAX_INTENTOS][MAX_CLAVIJAS];
		respuesta = new String[MAX_CLAVIJAS];
		}

	/**
	 * función que muestra por pantalla el tablero
	 */
	public void dibujarTablero(ArrayList<Integer> combinacionAleatoria) {

		// ArrayList<Integer> Combinacion = combinacionAleatoria;

		System.out.println("                ________________");
		System.out.println("               |  " + combinacionAleatoria + "  |  ");
		System.out.println(" _______________________      _______________________");

		for (int j = 0; j < MAX_INTENTOS; j++) {
			for (int k = 0; k < MAX_CLAVIJAS; k++) {
				suposicion[j][k] = "    ";
				respuesta[k] = " ";
			}
			System.out.println("| " + suposicion[j][0] + "| " + suposicion[j][1] + "| " + suposicion[j][2] + "| "
					+ suposicion[j][3] + "| == |  " + respuesta[0] + "  |  " + respuesta[1] + "  |  " + respuesta[2]
					+ "  |  " + respuesta[3] + "  |  ");
			System.out.println(" _______________________      _______________________");
		}
	}

	@SuppressWarnings("resource")
	public void PedirNumeros() {
		int vecesJugado = 0;
		while (vecesJugado < MAX_INTENTOS) {
			try {
				System.out.println("Inserta la combinación con el siguiente formato: X X X X");
				Scanner escaner = new Scanner(System.in);

				int combinacionJugador[] = new int[4];
				String entradaJugador[] = escaner.nextLine().split(" ");

				for (int i = 0; i < entradaJugador.length; i++) {
					combinacionJugador[i] = Integer.parseInt(entradaJugador[i]);
				}

				for (int i = 0; i < combinacionJugador.length; i++) {
					if ((combinacionJugador[i] < 0) || (combinacionJugador[i] > 8)) {
						throw new Exception("El número " +combinacionJugador[i] + " está fuera del rango [0 - 8].");
					} else {
						System.out.println("El número " + combinacionJugador[i] + " es válido.");
					}

				}
				vecesJugado++;
				System.out.println("\n" + "Número de jugadas: " + vecesJugado);
				// escaner.close();
			} catch (NumberFormatException e) {
				System.out.println("La combinación debe de ser numérica.");
			
			} catch (Exception e) {
				System.out.println(e);
			}

		}

	}

	private void print(String string) {
		// TODO Auto-generated method stub

	}
}
