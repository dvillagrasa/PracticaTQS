package mastermind.api.model;

import static org.junit.Assert.*;

import java.util.Arrays;
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
	public void testGenerarCombinacionAleatoria() {
		boolean esRepetido = false;
		boolean esRepetidoEsperado = false;
		char[][] resultado = Modelo.generarCombinacionAleatoria();		
		for (int i = 0; i < resultado.length; i++) { 
			for (int j = i + 1 ; j < resultado.length; j++) { 
				if(resultado[i][0] == resultado[j][0]) {
					esRepetido = true;
					break;
				}
			}
		assertEquals(esRepetido, esRepetidoEsperado); //Esperamos que sea falso, es decir, que no encuentre ninguna repetición, si no da fallo
		} 
	}
	
	/*
	 * ----------------------------------------------------------
	 * TESTS MÉTODO compararCombinaciones
	 * ----------------------------------------------------------
	 */
	
	/*
	 * Función que testea el método CompararCombinaciones del modelo
	 * fijamos una combinación aleatoria, una introducida por el jugado
	 * y el resultado que esperamos en formato {Aciertos negros, Aciertos Blancos}
	 * comparamos el esperado con el obtenido
	 * Caso 1: 4 Negros, 0 Blancos
	 */
	@Test
	public void testCompararCombinacionesLimiteSuperior1() {
		char[][] combinacionAleatoria = {{'5'},{'4'},{'1'},{'0'}};
		char[][] combinacionJugador = {{'5'},{'4'},{'1'},{'0'}};
		int[] esperado = {4, 0};
	    int[] resultado = Modelo.compararCombinaciones(combinacionAleatoria, combinacionJugador);
	    assertEquals(Arrays.toString(esperado), Arrays.toString(resultado));
	}
	
	/*
	 * Función que testea el método CompararCombinaciones del modelo
	 * fijamos una combinación aleatoria, una introducida por el jugado
	 * y el resultado que esperamos en formato {Aciertos negros, Aciertos Blancos}
	 * comparamos el esperado con el obtenido
	 * Caso 2: 0 Negros, 4 Blancos
	 */
	@Test
	public void testCompararCombinacionesLimiteSuperior2() {    
		char[][] combinacionAleatoria = {{'5'},{'4'},{'1'},{'0'}};
		char[][] combinacionJugador = {{'0'},{'1'},{'4'},{'5'}};
		int[] esperado = {0, 4};
	    int[] resultado = Modelo.compararCombinaciones(combinacionAleatoria, combinacionJugador);
	    assertEquals(Arrays.toString(esperado), Arrays.toString(resultado));  
	}
	
	/*
	 * Función que testea el método CompararCombinaciones del modelo
	 * fijamos una combinación aleatoria, una introducida por el jugado
	 * y el resultado que esperamos en formato {Aciertos negros, Aciertos Blancos}
	 * comparamos el esperado con el obtenido
	 * Caso 3: 0 Negros, 0 Blancos
	 */
	@Test
	public void testCompararCombinacionesLimiteInferior() {
		char[][] combinacionAleatoria = {{'5'},{'4'},{'1'},{'0'}};
		char[][] combinacionJugador = {{'3'},{'6'},{'2'},{'7'}};
		int[] esperado = {0, 0};
	    int[] resultado = Modelo.compararCombinaciones(combinacionAleatoria, combinacionJugador);
	    assertEquals(Arrays.toString(esperado), Arrays.toString(resultado));
	}	
	
	/*
	 * -------------------------------------------------------
	 * TESTS MÉTODO haGanado
	 * -------------------------------------------------------
	 */

	
	/**
	 * Función que testea que un usuario ha ganado si introduce una combinación correcta (4 aciertos negros)
	 * La llamada a la función en Modelo debe devolver un true, que es el valor esperado
	 */
	@Test
	public void testHaGanado() {
		int[] aciertos = {4, 0};		
		boolean esperado = true;
		boolean obtenido = Modelo.comprobarVictoria(aciertos);
	    assertEquals(esperado, obtenido);
	}
	
	/**
	 * Funcion que testea si un usuario introduce una combinación que no cuenta con 4 aciertos negros
	 * devuelve un false
	 */
	@Test
	public void testSigueJugandoLimiteSuperior() {
		int[] aciertos = {3, 1};	
		boolean esperado = false;
		boolean obtenido = Modelo.comprobarVictoria(aciertos);
	    assertEquals(esperado, obtenido);
	}
	
	/**
	 * Funcion que testea que si un usuario introduce una combinación que no cuenta con 4 aciertos negros
	 * devuelve un false
	 */
	@Test
	public void testSigueJugandoLimiteInferior() {
		int[] aciertos = {0, 0};
		boolean esperado = false;
		boolean obtenido = Modelo.comprobarVictoria(aciertos);
	    assertEquals(esperado, obtenido);
	}
	/**
	 * Funcion que testea qué pasa si un usuario introduce una combinación que no cuenta con 4 aciertos negros pero sí 4 blancos
	 * devuelve un false
	 */
	@Test
	public void testSigueJugandoValorBlanco() {
		int[] aciertos = {0, 4};		
		boolean esperado = false;
		boolean obtenido = Modelo.comprobarVictoria(aciertos);
	    assertEquals(esperado, obtenido);
	}
	
	/**
	 * Funcion que testea qué pasa si un usuario introduce una combinación que cuenta con 5 aciertos negros
	 * devuelve un false
	 */
	@Test
	public void testSigueJugandoLimiteSuperiorFuera() {
		int[] aciertos = {5, 0};		
		boolean esperado = false;
		boolean obtenido = Modelo.comprobarVictoria(aciertos);
	    assertEquals(esperado, obtenido);
	}
	
	/*
	 * -------------------------------------------------------
	 * TESTS MÉTODO comprobarEntradaJugador
	 * -------------------------------------------------------
	 */
	
	/**
	 * Test que comprueba que si se introduce una variable incorrecta
	 * el método comprobador devuelve false
	 */
	@Test
	public void testcomprobarEntradaJugadorIncorrectaPorArriba() {
		char[][] entrada = {{'0'}, {'2'} , {'9'} , {'4'}};
		boolean esperado = false;
		boolean resultado = Modelo.comprobarEntradaJugador(entrada);
		
		assertEquals(resultado, esperado);
	}
	
	/**
	 * Test que comprueba que si se introduce una variable correcta
	 * el método comprobador devuelve true
	 */
	@Test
	public void testcomprobarEntradaJugadorCorrecta() {
		char[][] entrada = {{'0'}, {'2'} , {'8'} , {'4'}};
		boolean esperado = true;
		boolean resultado = Modelo.comprobarEntradaJugador(entrada);
		
		assertEquals(resultado, esperado);
	}
	
	
}
