package mastermind.api.view;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;


public class VistaTest{
	
	String Entrada[] = new String[]{"22", "2" , "3" , "4"};
	
	/*
	 * Bueno, te comento: Esta función de test es diferente a la otra. Aquí no estamos comprobando que 
	 * el output generado sea correcto, sino que el input introducido se trate bien, por lo que hay que 
	 * probar LO DE DENTRO de la función. Mi idea ha sido la de replicar la misma función que tenemos en la vista
	 * pero primero en el test (creo que lo suyo habría sido hacer esta antes que la de la vista).
	 * Básicamente lo que se está haciendo es simular una partida en la que siempre se introducen los mismos númeos
	 * lo que controlamos es que sean números enteros entre 0 y 8. He retocado cosas en las excepciones y habría que tener en cuenta otras condiciones
	 */

	@Test
	public void testPedirNumeros() {
		int vecesJugado = 0;
		boolean valorEsperado = false;
		boolean valor = false;
		while (vecesJugado < 9) {
			try {

				int combinacionJugador[] = new int[4];

				for (int i = 0; i < Entrada.length; i++) {
					combinacionJugador[i] = Integer.parseInt(Entrada[i]);
				}

				for (int i = 0; i < combinacionJugador.length; i++) {
					if ((combinacionJugador[i] < 0) || (combinacionJugador[i] > 8)) {
						valor = true;
						throw new Exception("El número " +combinacionJugador[i] + " está fuera del rango [0 - 8].");
					} else {
						System.out.println("El número " + combinacionJugador[i] + " es válido.");
					}

				}
				vecesJugado++;
				System.out.println("\n" + "Número de jugadas: " + vecesJugado);
			} catch (NumberFormatException e) {
				System.out.println("La combinación debe de ser numérica.");
				valor = true;
				break;
			
			} catch (Exception e) {
				System.out.println(e);
				break;
			}

		}
		assertEquals(valorEsperado,valor);
	}

}
