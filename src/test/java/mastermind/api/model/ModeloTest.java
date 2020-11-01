package mastermind.api.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class ModeloTest {
	/**
	 * modelo es una instancia de la clase Modelo.
	 */
	Modelo modelo = new Modelo();
	
	/**
	 * testgenerarCombinaconAleatoria es una función que prueba el correcto funcionamiento de la función
	 * generarCombinacionAleatoria. Comprobando que realmente no se repite ningún número.
	 */
	@Test
	public void testgenerarCombinacionAleatoria() {
		boolean esRepetido = false;

		char[][] resultado = Modelo.generarCombinacionAleatoria();
		//char[][] resultado = {'1', '2' , '3' , '5'}; //Array de carácteres para comprobar que sí funciona el test.
		for (int i = 0; i < resultado.length; i++) { 
			for (int j = i + 1 ; j < resultado.length; j++) { 
				if(resultado[i] == resultado[j]) {
					//System.out.println("Repetido: " + resultado[i]);
					esRepetido = true;
				}
			}
		assertFalse(esRepetido);//Esperamos que sea falso, es decir, que no encuentre ninguna repetición.
		} 
	}
	
	/*@Test
	public void testrevisarAciertosJugador() {
		String[] combinacionAleatoria = {};
	}*/
}
