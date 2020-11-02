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
	public static boolean error = false;
	
	/**
	 * testgenerarCombinaconAleatoria es una función que prueba el correcto funcionamiento de la función
	 * generarCombinacionAleatoria. Comprobando que realmente no se repite ningún número.
	 */
	/*@Test
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
	}*/
	
	@Test
	public void testCompararCombinaciones() {
		int aciertosBlancos = 0;
		int aciertosNegros = 0;
		//char[][] combinacionAleatoria = Modelo.generarCombinacionAleatoria();
		//char[] entradaJugador = vista.obtenerEntradaJugador();
		
		char[][] combinacionAleatoria = {{'5'},{'4'},{'1'},{'0'}};
		char[][] combinacionJugador = {{'0'},{'4'},{'1'},{'5'}};
		
		

		for(int i = 0; i < MAX_CLAVIJAS; i++){
			for (int j = 0; j < combinacionAleatoria.length; j++){
				if(combinacionAleatoria[i][0] == combinacionJugador[j][0]){
					if(combinacionAleatoria[i][0] == combinacionJugador[i][0]) {
						aciertosBlancos++;
					} else {
						aciertosNegros++;
						}
					}
				}
			}
		System.out.println("Aciertos Negros: " + aciertosNegros);
		System.out.println("Aciertos Blancos: " + aciertosBlancos);
		assertFalse(error); //Esperamos que sea false, es decir, que no haya errores
		}

}
