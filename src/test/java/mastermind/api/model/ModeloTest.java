package mastermind.api.model;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import mastermind.api.view.Vista;

public class ModeloTest {
	/**
	 * modelo es una instancia de la clase Modelo.
	 */
	Modelo modelo = new Modelo();
	Vista vista = new Vista();
	public static final int MAX_CLAVIJAS = 4;
	
	/**
	 * testgenerarCombinaconAleatoria es una función que prueba el correcto funcionamiento de la función
	 * generarCombinacionAleatoria. Comprobando que realmente no se repite ningún número.
	 */
	@Test
	public void testgenerarCombinacionAleatoria() {
		boolean esRepetido = false;
		char[][] resultado = Modelo.generarCombinacionAleatoria();
		
		for (int i = 0; i < resultado.length; i++) { 
			for (int j = i + 1 ; j < resultado.length; j++) { 
				if(resultado[i][0] == resultado[j][0]) {
					esRepetido = true;
					break;
				}
			}
		assertFalse(esRepetido); //Esperamos que sea falso, es decir, que no encuentre ninguna repetición, si no da fallo
		} 
	}
	
	/*
	 * Función que testea el método CompararCombinaciones del modelo
	 * fijamos una combinación aleatoria, una introducida por el jugado
	 * y el resultado que esperamos en formato {Aciertos negros, Aciertos Blancos}
	 * comparamos el esperado con el obtenido
	 * Hay varios casos, hay que descomentar solo el que se vaya a utilizar
	 */
	@Test
	public void testCompararCombinaciones() {
		
		// Caso 1: 4 Negros, 0 Blancos #BLM
		
		char[][] combinacionAleatoria = {{'5'},{'4'},{'1'},{'0'}};
		char[][] combinacionJugador = {{'5'},{'4'},{'1'},{'0'}};
		int[] esperado = {4, 0};
	    int[] resultado = Modelo.CompararCombinaciones(combinacionAleatoria, combinacionJugador);
	    assertEquals(Arrays.toString(esperado), Arrays.toString(resultado));
		
		
		// Caso 2: 2 Negros, 2 Blancos
	    /*
		char[][] combinacionAleatoria = {{'5'},{'4'},{'1'},{'0'}};
		char[][] combinacionJugador = {{'5'},{'4'},{'0'},{'1'}};
		int[] esperado = {2, 2};
	    int[] resultado = Modelo.CompararCombinaciones(combinacionAleatoria, combinacionJugador);
	    assertEquals(Arrays.toString(esperado), Arrays.toString(resultado));
	    */
		
		// Caso 3: 0 Negros, 4 Blancos
	    /*
		char[][] combinacionAleatoria = {{'5'},{'4'},{'1'},{'0'}};
		char[][] combinacionJugador = {{'0'},{'1'},{'4'},{'5'}};
		int[] esperado = {0, 4};
	    int[] resultado = Modelo.CompararCombinaciones(combinacionAleatoria, combinacionJugador);
	    assertEquals(Arrays.toString(esperado), Arrays.toString(resultado));
	    */
		
	    // Caso 4: 0 Negros, 0 Blancos
		/*
		char[][] combinacionAleatoria = {{'5'},{'4'},{'1'},{'0'}};
		char[][] combinacionJugador = {{'3'},{'6'},{'2'},{'7'}};
		int[] esperado = {0, 0};
	    int[] resultado = Modelo.CompararCombinaciones(combinacionAleatoria, combinacionJugador);
	    assertEquals(Arrays.toString(esperado), Arrays.toString(resultado));
	    */
	}

}
