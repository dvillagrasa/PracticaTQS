package mastermind.api.model;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;
import mastermind.api.view.*;
/**
 * Clase ModeloTest - Clase donde se encuentran los m�todos de test relacionados
 * con el modelo del juego.
 * 
 * @author Daniel Luis Garcia
 * @author Daniel Villagrasa Ram�rez
 */
public class ModeloTest {
	/**
	 * Instancia de la clase Modelo.
	 */
	Modelo modelo = new Modelo();
	
	/**
	 * Instancia de la clase Vista.
	 */
	Vista vista = new Vista();
	/**
	 * N�mero de posiciones del tablero del juego. En este caso son 4 tanto para los n�meros 
	 * (ser�an los colores exceptuando el blanco y negro), como para mostrar los aciertos de 
	 * n�meros y/o posici�n (ser�an los colores blanco y negro).
	 */
	public static final int MAX_CLAVIJAS = 4;
	
	/**
	 * -------------------------------- Tests del m�todo obtenerEntradaJugador() --------------------------------
	 */
	/**
	 * Test caja negra #1 de valor l�mite superior. 5 n�meros en vez de 4.
	 * 
	 * Comprueba si el tama�o de la entrada del jugador es mayor al permitido.
	 */
	@Test
	public void testObtenerEntradaJugadorMayor() {
		boolean valorEsperado = false;
		String[] entrada = {"1","2","3","4","5"};
		char[][] entradaCasteada = modelo.castearEntradaJugador(entrada);

		assertEquals(valorEsperado, modelo.comprobarEntradaJugador(entradaCasteada));
	}
	
	/**
	 * Test caja negra #2 de valor l�mite interior. 3 n�meros en vez de 4.
	 * 
	 * Comprueba si el tama�o de la entrada del jugador es menor al permitido.
	 */
	@Test
	public void testObtenerEntradaJugadorMenor() {
		boolean valorEsperado = false;
		String[] entrada = {"1","2","3"};
		char[][] entradaCasteada = modelo.castearEntradaJugador(entrada);
		// Valorar cambiarlo por assertFalse y eliminar la linea 55
		assertEquals(valorEsperado, modelo.comprobarEntradaJugador(entradaCasteada));
	}
	
	/**
	 * Test caja negra #3 de valor l�mite interior. 0 n�meros en vez de 4.
	 * 
	 * Comprueba si el tama�o de la entrada del jugador es menor al permitido.
	 */
	@Test
	public void testObtenerEntradaJugadorCero() {
		boolean valorEsperado = false;
		String[] entrada = {""};
		char[][] entradaCasteada = modelo.castearEntradaJugador(entrada);

		assertEquals(valorEsperado, modelo.comprobarEntradaJugador(entradaCasteada));
	}
	
	/**
	 * Test caja negra #4 de valor frontera. 4 n�meros.
	 * 
	 * Comprueba si el tama�o de la entrada del jugador igual al permitido.
	 */
	@Test
	public void testObtenerEntradaJugadorExacta() {
		boolean valorEsperado = true;
		String[] entrada = {"1","2","3","4"};
		char[][] entradaCasteada = modelo.castearEntradaJugador(entrada);

		assertEquals(valorEsperado, modelo.comprobarEntradaJugador(entradaCasteada));
	}
	
	/**
	 * -------------------------------- Tests del m�todo castearEntradaJugador() --------------------------------
	 */
	@SuppressWarnings("deprecation")
	/**
	 * Comprueba que realiza la transformaci�n del tipo de dato de forma correcta.
	 * 
	 * Primero se crea un array de cadena de car�cteres simulando que una secuencia
	 * de 4 numeros ha sido sometida a un split(). Segundo, creamos un array de
	 * car�cteres que servir� para comprobar posici�n a posici�n con el array de 
	 * car�cteres que contendr� valores que han sido transformados de array de 
	 * cadena de car�cteres a car�cteres. En caso de que la comprobaci�n de 
	 * alguna posici�n no sea equivalente, el flag de esCorrecto ser� false
	 * y terminar� la ejecuci�n del test ya que el c�digo desarrollado no
	 * realizar�a de forma correcta la transformaci�n de datos.
	 */
	@Test
	public void testCastearEntradaJugador() {		
		String[] entradaDePrueba = {"1", "2", "3", "4"};
		char[][] resultadoEsperadoCasteado = {{'1'}, {'2'}, {'3'}, {'4'}};
		char[][] entradaDePruebaCasteada = modelo.castearEntradaJugador(entradaDePrueba);
		
		assertEquals(resultadoEsperadoCasteado, entradaDePruebaCasteada);	
	}
	
	/**
	 * -------------------------------- Tests del m�todo comprobarCombinaciones() --------------------------------
	 */
	
	/**
	 * Comprueba el correcto funcionamiento de la funci�n generarCombinacionAleatoria, 
	 * verificando si realmente no se repite ning�n n�mero dentro de la combinaci�n aleatoria.
	 * 
	 * Primero obtenemos la combinaci�n generada por la m�quina y la almacenamos, seguidamente, 
	 * por cada valor de la combinaci�n generada por la m�quina y por cada posici�n por delante 
	 * del valor resultado[i] se comprueba si el valor de la combinaci�n generada por la m�quina 
	 * es igual a los valores de cada posici�n por delante del valor. En caso afirmativo, existe 
	 * una repetici�n dentro de la combinaci�n aleatoria y termina la ejecuci�n del bucle if ya 
	 * que se ha hallado un fallo en el c�digo desarrollado. Para finalizar, se realiza una 
	 * comprobaci�n para saber si el assert es (false, false).
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
		assertEquals(esRepetido, esRepetidoEsperado);
		} 
	}

	/**
	 * -------------------------------- Tests del m�todo comprobarCombinaciones() --------------------------------
	 */
	
	/**
	 * Test de caja negra #1 del m�todo comprobarCombinaciones().
	 * 
	 * Comprueba que al comparar una combinaci�n aleatoria y una combinaci�n del jugador
	 * que son id�nticas nos devuelve 4 aciertos negros y 0 aciertos blancos.
	 * 
	 * Caso 1: 4 Negros, 0 Blancos
	 */
	@Test
	public void testCompararCombinacionesIdenticas() {
		char[][] combinacionAleatoria = {{'5'},{'4'},{'1'},{'0'}};
		char[][] combinacionJugador = {{'5'},{'4'},{'1'},{'0'}};
		int[] esperado = {4, 0};
	    int[] resultado = Modelo.compararCombinaciones(combinacionAleatoria, combinacionJugador);
	    
	    assertEquals(Arrays.toString(esperado), Arrays.toString(resultado));
	}
	
	/**
	 * Test de caja negra #2 del m�todo comprobarCombinaciones().
	 * 
	 * Comprueba que al comparar una combinaci�n aleatoria y una combinaci�n del jugador
	 * que una es la inversa de la otra nos devuelve 0 aciertos negros y 4 aciertos blancos.
	 * 
	 * Caso 2: 0 Negros, 4 Blancos
	 */
	@Test
	public void testCompararCombinacionesInversas() {    
		char[][] combinacionAleatoria = {{'5'},{'4'},{'1'},{'0'}};
		char[][] combinacionJugador = {{'0'},{'1'},{'4'},{'5'}};
		int[] esperado = {0, 4};
	    int[] resultado = Modelo.compararCombinaciones(combinacionAleatoria, combinacionJugador);
	    
	    assertEquals(Arrays.toString(esperado), Arrays.toString(resultado));  
	}
	
	/**
	 * Test de caja negra #3 del m�todo comprobarCombinaciones().
	 * 
	 * Comprueba que al comparar una combinaci�n aleatoria y una combinaci�n del jugador
	 * totalmente distintas una de la otra nos devuelve 0 aciertos negros y 0 aciertos blancos.
	 * 
	 * Caso 3: 0 Negros, 0 Blancos
	 */
	@Test
	public void testCompararCombinacionesQueNoCompartenNumeros() {
		char[][] combinacionAleatoria = {{'5'},{'4'},{'1'},{'0'}};
		char[][] combinacionJugador = {{'3'},{'6'},{'2'},{'7'}};
		int[] esperado = {0, 0};
	    int[] resultado = Modelo.compararCombinaciones(combinacionAleatoria, combinacionJugador);
	    
	    assertEquals(Arrays.toString(esperado), Arrays.toString(resultado));
	}	
	

	/**
	 * -------------------------------- Tests del m�todo comprobarVictoria() --------------------------------
	 */
	
	/**
	 * Test de caja negra #1 del m�todo comprobarVictoria().
	 * 
	 * Comprueba el valor frontera superior del n�mero de aciertos 
	 * permitido. En este caso el valor fronteran superior es 4. 
	 * El m�todo comprobarVictoria debe devolver true al tratarse 
	 * de un valor frontera.
	 */
	@Test
	public void testValorFronteraSuperiorComprobarVictoria() {
		int[] aciertos = {4, 0};		
		boolean esperado = true;
		boolean obtenido = Modelo.comprobarVictoria(aciertos);
	    
		assertEquals(esperado, obtenido);
	}
	
	/**
	 * Test de caja negra #2 del m�todo comprobarVictoria().
	 * 
	 * Comprueba el valor interior del n�mero de aciertos permitido. 
	 * En este caso el valor interior es 3. El m�todo comprobarVictoria 
	 * debe devolver false al no obtener la victoria.
	 */
	@Test
	public void testValorInteriorComprobarVictoria() {
		int[] aciertos = {3, 1};	
		boolean esperado = false;
		boolean obtenido = Modelo.comprobarVictoria(aciertos);
	    
		assertEquals(esperado, obtenido);
	}
	
	/**
	 * Test de caja negra #3 del m�todo comprobarVictoria().
	 * 
	 * Comprueba el valor frontera inferior del n�mero de aciertos 
	 * permitido. En este caso el valor frontera superior es 0. El 
	 * m�todo comprobarVictoria debe devolver false al no obtener 
	 * la victoria.
	 */
	@Test
	public void testValorFronteraInferiorComprobarVictoria() {
		int[] aciertos = {0, 0};
		boolean esperado = false;
		boolean obtenido = Modelo.comprobarVictoria(aciertos);
	    
		assertEquals(esperado, obtenido);
	}
	
	/**
	 * Test de caja negra #4 del m�todo comprobarVictoria().
	 * 
	 * Comprueba el valor frontera inferior del n�mero de aciertos 
	 * blancos permitido. En este caso el valor frontera superior 
	 * es 4. El m�todo comprobarVictoria debe devolver false al no 
	 * obtener la victoria.
	 */
	@Test
	public void testValorFronteraSuperiorBlancoComprobarVictoria() {
		int[] aciertos = {0, 4};		
		boolean esperado = false;
		boolean obtenido = Modelo.comprobarVictoria(aciertos);
	    
		assertEquals(esperado, obtenido);
	}
	
	/**
	 * Test de caja negra #5 del m�todo comprobarVictoria().
	 * 
	 * Comprueba el valor l�mite superior del n�mero de aciertos 
	 * permitido. En este caso el valor l�mite superior es 5. El 
	 * m�todo comprobarVictoria debe devolver false al no ser 4 
	 * aciertos.
	 */
	@Test
	public void testValorLimiteSuperiorComprobarVictoria() {
		int[] aciertos = {5, 0};		
		boolean esperado = false;
		boolean obtenido = Modelo.comprobarVictoria(aciertos);
	    
		assertEquals(esperado, obtenido);
	}
	
	/**
	 * -------------------------------- Tests del m�todo comprobarEntradaJugador() --------------------------------
	 */
	
	/**
	 * Test de caja negra #1 del m�todo comprobarEntradaJugador().
	 * 
	 * Comprueba el l�mite superior del rango [0-8] con el valor 9.
	 * El m�todo comprobarEntradaJugador debe devolver false al
	 * tratarse de un valor fuera del rango [0-8].
	 */
	@Test
	public void testComprobarLimiteSuperiorEntradaJugador() {
		char[][] entrada = {{'0'}, {'2'} , {'9'} , {'4'}};
		boolean esperado = false;
		boolean resultado = Modelo.comprobarEntradaJugador(entrada);
		
		assertEquals(resultado, esperado);
	}
	
	/**
	 * Test de caja negra #2 del m�todo comprobarEntradaJugador().
	 * 
	 * Comprueba el l�mite superior del rango [0-8] con el valor -.
	 * El m�todo comprobarEntradaJugador debe devolver false al
	 * tratarse de un valor fuera del rango [0-8].
	 */
	@Test
	public void testComprobarLimiteInferiorEntradaJugador() {
		char[][] entrada = {{'0'}, {'2'} , {'-'} , {'4'}};
		boolean esperado = false;
		boolean resultado = Modelo.comprobarEntradaJugador(entrada);
		
		assertEquals(resultado, esperado);
	}
	
	
	/**
	 * Test de caja negra #3 del m�todo comprobarEntradaJugador().
	 * 
	 * Comprueba el valor frontera superior del rango [0-8] con el valor 8.
	 * El m�todo comprobarEntradaJugador debe devolver true al
	 * tratarse de un valor dentro del rango [0-8].
	 */
	@Test
	public void testComprobarValorFronteraSuperiorEntradaJugadorCorrecta() {
		char[][] entrada = {{'6'}, {'2'} , {'8'} , {'4'}};
		boolean esperado = true;
		boolean resultado = Modelo.comprobarEntradaJugador(entrada);
		
		assertEquals(resultado, esperado);
	}
	
	/**
	 * Test de caja negra #4 del m�todo comprobarEntradaJugador().
	 * 
	 * Comprueba el valor frontera del rango [0-8] con el valor 0.
	 * El m�todo comprobarEntradaJugador debe devolver true al
	 * tratarse de un valor dentro del rango [0-8].
	 */
	@Test
	public void testComprobarValorFronteraInferiorEntradaJugadorCorrecta() {
		char[][] entrada = {{'6'}, {'2'} , {'0'} , {'4'}};
		boolean esperado = true;
		boolean resultado = Modelo.comprobarEntradaJugador(entrada);
		
		assertEquals(resultado, esperado);
	}
}