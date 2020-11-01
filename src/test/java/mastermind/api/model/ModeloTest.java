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
	
	/**
	 * testgenerarCombinaconAleatoria es una función que prueba el correcto funcionamiento de la función
	 * generarCombinacionAleatoria. Comprobando que realmente no se repite ningún número.
	 */
	/*@Test
	public void testgenerarCombinacionAleatoria() {
		boolean esRepetido = false;
		char[][] resultado = Modelo.generarCombinacionAleatoria();
		//char[][] resultado = {{'5'},{'4'},{'0'},{'0'}}; //Array de carácteres para comprobar que sí funciona el test.
		
		//System.out.println(Arrays.deepToString(resultado)); Imprime [[5], [4], [0], [0]]
		
		for (int i = 0; i < resultado.length; i++) { 
			for (int j = i + 1 ; j < resultado.length; j++) { 
				//System.out.println("tstI " + Arrays.toString(resultado[i])); //Imprime [5] (si i = 0)
				//System.out.println("tstJ " + Arrays.toString(resultado[j])); //Imprime [4] (si j = 1)
				if(resultado[i][0] == resultado[j][0]) {
					//System.out.println("Repetido: " + Arrays.toString(resultado[i])); //Imprime cuál es el número repetido (en este caso el [0])
					esRepetido = true;
				}
			}
		assertFalse(esRepetido); //Esperamos que sea falso, es decir, que no encuentre ninguna repetición.
		} 
	}*/
	
	@Test
	public void testrevisarAciertosJugador() {
		boolean esIgual = true;
		//char[][] combinacionAleatoria = Modelo.generarCombinacionAleatoria();
		//char[] entradaJugador = vista.obtenerEntradaJugador();
		
		char[][] combinacionAleatoria = {{'5'},{'4'},{'0'},{'0'}};
		//char[] entradaJugador = {'5','4','0','0'};
		char[][] entradaJugador = {{'5'},{'4'},{'0'},{'0'}};
		
		for (int i = 0; i < combinacionAleatoria.length; i++) { 
			System.out.println("tstI " + Arrays.toString(combinacionAleatoria[i]));
			//System.out.println("tstJ " + Array.getChar(entradaJugador, i));
			System.out.println("tstI " + Arrays.toString(entradaJugador[i]));
			if(combinacionAleatoria[i][0] != entradaJugador[i][0]) {
				esIgual = false;
			}
		}
		assertTrue(esIgual); //Esperamos que sea true, es decir, que sean iguales.
	}
}
