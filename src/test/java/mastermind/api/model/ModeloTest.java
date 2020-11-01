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
		//char[][] resultado = {{'5'},{'4'},{'0'},{'0'}}; //Array de carácteres para comprobar que sí funciona el test.
		
		//System.out.println(Arrays.deepToString(resultado)); Imprime [[5], [4], [0], [0]]
		
		for (int i = 0; i < resultado.length; i++) { 
			for (int j = i + 1 ; j < resultado.length; j++) { 
				//System.out.println("tstI " + Arrays.toString(resultado[i])); Imprime [5] (si i = 0)
				//System.out.println("tstJ " + Arrays.toString(resultado[j])); Imprime [4] (si j = 1)
				if(resultado[i][0] == resultado[j][0]) {
					//System.out.println("Repetido: " + Arrays.toString(resultado[i])); //Imprime cuál es el número repetido (en este caso el [0])
					esRepetido = true;
				}
			}
		assertFalse(esRepetido); //Esperamos que sea falso, es decir, que no encuentre ninguna repetición.
		} 
	}
	
	/*@Test
	public void testrevisarAciertosJugador() {
		String[] combinacionAleatoria = {};
	}*/
}
