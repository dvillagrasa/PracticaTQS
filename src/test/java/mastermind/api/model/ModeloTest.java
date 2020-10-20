package mastermind.api.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class ModeloTest {


	@Test
	public void testgenerarCombinacionAleatoria() {//función que prueba el correcto funcionamiento de la función de la clase Modelo generarCombinacionAleatoria 
		Modelo modelo = new Modelo();
		ArrayList<Integer> lista = modelo.generarCombinacionAleatoria();
		boolean repetidoEsperado = false;
		boolean repetido = false;
		System.out.println(lista);
		
		for(int i =0; i < lista.size(); i++) {
			  if (lista.lastIndexOf(lista.get(i)) != i)  {
			    	repetido = true;
			  }
			}
		assertEquals(repetido,repetidoEsperado);
		//plantear break del for
		
		/*Set<String> set = new HashSet<>();
		for(int i = 0; i < lista.size(); i++) {
		    if (set.contains(lista.get(i))) {
		    	repetido = true;
		    	assertEquals(repetido,repetidoEsperado);
		    	i++;
		    	
		    } else {
		    	repetido = true;
		    	assertEquals(repetido,repetidoEsperado);
		    	i++;
		    }
		}*/
	}

}
