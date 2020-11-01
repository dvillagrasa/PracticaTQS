package mastermind.api.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
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

		String[] resultado = Modelo.generarCombinacionAleatoria();
		for (int i = 0; i < resultado.length; i++) { 
			for (int j = i + 1 ; j < resultado.length; j++) { 
				if (resultado[i].equals(resultado[j])) { 
					esRepetido = true; 
				}	
			}
		assertFalse(esRepetido);//Esperamos que sea falso, es decir, que no encuentre ninguna repetición.
		} 
	}
}
