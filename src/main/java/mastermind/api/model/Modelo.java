package mastermind.api.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import mastermind.api.view.*;

/**
 * Clase Modelo - se encargará de cálculos y de dar valores/objetos que tengamos
 * que utilizar en nuestro programa
 * 
 * @author Daniel Luis Garcia
 * @author Daniel Villagrasa Ramírez
 */
public class Modelo {

	public static final int MAX_CLAVIJAS = 4;

	// int[] numeros = {0,1,2,3,4,5,6,7,8,9};
	public static final Random aleatorio = new Random(); // función a la que llamamos para que nos devuelva un aleatorio

	/*
	 * función que nos genera una lista con números aleatorios del 0 al 7
	 */
	public ArrayList<Integer> generarCombinacionAleatoria() {

		boolean repetido = true;
		ArrayList<Integer> combinacionNumerica = new ArrayList<Integer>();
		// int[] combinacionNumerica = new int[MAX_CLAVIJAS];
		for (int i = 0; i < MAX_CLAVIJAS; i++) {
			if (combinacionNumerica.size() < MAX_CLAVIJAS) {
				while (repetido) {
					int numAleatorio = aleatorio.nextInt(8);
					if (!combinacionNumerica.contains(numAleatorio)) {
						combinacionNumerica.add(numAleatorio);
						repetido = false;
					}
				}
				repetido = true;
			}
		}
		Collections.shuffle(Arrays.asList(combinacionNumerica));
		return combinacionNumerica;
	}

	/*public char[] generarCombinacionAleatoria() {

		boolean repetido = true;
		ArrayList<Integer> combinacionNumerica = new ArrayList<Integer>();
		// int[] combinacionNumerica = new int[MAX_CLAVIJAS];
		for (int i = 0; i < MAX_CLAVIJAS; i++) {
			if (combinacionNumerica.size() < MAX_CLAVIJAS) {
				while (repetido) {
					int numAleatorio = aleatorio.nextInt(8);
					if (!combinacionNumerica.contains(numAleatorio)) {
						combinacionNumerica.add(numAleatorio);
						repetido = false;
					}
				}
				repetido = true;
			}
		}
		Collections.shuffle(Arrays.asList(combinacionNumerica));
		return combinacionNumerica;
	}*/
}
