package mastermind.api.view;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;


public class VistaTest{
	
	String Entrada[] = new String[]{"22", "2" , "3" , "4"};
	
	/*
	 * Bueno, te comento: Esta funci�n de test es diferente a la otra. Aqu� no estamos comprobando que 
	 * el output generado sea correcto, sino que el input introducido se trate bien, por lo que hay que 
	 * probar LO DE DENTRO de la funci�n. Mi idea ha sido la de replicar la misma funci�n que tenemos en la vista
	 * pero primero en el test (creo que lo suyo habr�a sido hacer esta antes que la de la vista).
	 * B�sicamente lo que se est� haciendo es simular una partida en la que siempre se introducen los mismos n�meos
	 * lo que controlamos es que sean n�meros enteros entre 0 y 8. He retocado cosas en las excepciones y habr�a que tener en cuenta otras condiciones
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
						throw new Exception("El n�mero " +combinacionJugador[i] + " est� fuera del rango [0 - 8].");
					} else {
						System.out.println("El n�mero " + combinacionJugador[i] + " es v�lido.");
					}

				}
				vecesJugado++;
				System.out.println("\n" + "N�mero de jugadas: " + vecesJugado);
			} catch (NumberFormatException e) {
				System.out.println("La combinaci�n debe de ser num�rica.");
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
