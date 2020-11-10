package mastermind.api.model;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;
import mastermind.api.view.*;
/**
 * Clase ModeloTest - Clase donde se encuentran los métodos de test relacionados
 * con el modelo del juego.
 * 
 * @author Daniel Luis Garcia
 * @author Daniel Villagrasa Ramírez
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
	 * Número de posiciones del tablero del juego. En este caso son 4 tanto para los números 
	 * (serían los colores exceptuando el blanco y negro), como para mostrar los aciertos de 
	 * números y/o posición (serían los colores blanco y negro).
	 */
	public static final int MAX_CLAVIJAS = 4;
	
	/**
	 * -------------------------------- Tests del método obtenerEntradaJugador() --------------------------------
	 */
	/**
	 * Test caja negra #1 de valor límite superior. 5 números en vez de 4.
	 * 
	 * Comprueba si el tamaño de la entrada del jugador es mayor al permitido.
	 */
	@Test
	public void testObtenerEntradaJugadorMayor() {
		boolean valorEsperado = false;
		String[] entrada = {"1","2","3","4","5"};
		char[][] entradaCasteada = modelo.castearEntradaJugador(entrada);

		assertEquals(valorEsperado, modelo.validarEntradaJugador(entradaCasteada));
	}
	
	/**
	 * Test caja negra #2 de valor límite interior. 3 números en vez de 4.
	 * 
	 * Comprueba si el tamaño de la entrada del jugador es menor al permitido.
	 */
	@Test
	public void testObtenerEntradaJugadorMenor() {
		boolean valorEsperado = false;
		String[] entrada = {"1","2","3"};
		char[][] entradaCasteada = modelo.castearEntradaJugador(entrada);
		// Valorar cambiarlo por assertFalse y eliminar la linea 55
		assertEquals(valorEsperado, modelo.validarEntradaJugador(entradaCasteada));
	}
	
	/**
	 * Test caja negra #3 de valor límite interior. 0 números en vez de 4.
	 * 
	 * Comprueba si el tamaño de la entrada del jugador es menor al permitido.
	 */
	@Test
	public void testObtenerEntradaJugadorCero() {
		boolean valorEsperado = false;
		String[] entrada = {""};
		char[][] entradaCasteada = modelo.castearEntradaJugador(entrada);

		assertEquals(valorEsperado, modelo.validarEntradaJugador(entradaCasteada));
	}
	
	/**
	 * Test caja negra #4 de valor frontera. 4 números.
	 * 
	 * Comprueba si el tamaño de la entrada del jugador igual al permitido.
	 */
	@Test
	public void testObtenerEntradaJugadorExacta() {
		boolean valorEsperado = true;
		String[] entrada = {"1","2","3","4"};
		char[][] entradaCasteada = modelo.castearEntradaJugador(entrada);

		assertEquals(valorEsperado, modelo.validarEntradaJugador(entradaCasteada));
	}
	
	/**
	 * -------------------------------- Tests del método castearEntradaJugador() --------------------------------
	 */
	@SuppressWarnings("deprecation")
	/**
	 * Comprueba que realiza la transformación del tipo de dato de forma correcta.
	 * 
	 * Primero se crea un array de cadena de carácteres simulando que una secuencia
	 * de 4 numeros ha sido sometida a un split(). Segundo, creamos un array de
	 * carácteres que servirá para comprobar posición a posición con el array de 
	 * carácteres que contendrá valores que han sido transformados de array de 
	 * cadena de carácteres a carácteres. En caso de que la comprobación de 
	 * alguna posición no sea equivalente, el flag de esCorrecto será false
	 * y terminará la ejecución del test ya que el código desarrollado no
	 * realizaría de forma correcta la transformación de datos.
	 */
	@Test
	public void testCastearEntradaJugador() {		
		String[] entradaDePrueba = {"1", "2", "3", "4"};
		char[][] resultadoEsperadoCasteado = {{'1'}, {'2'}, {'3'}, {'4'}};
		char[][] entradaDePruebaCasteada = modelo.castearEntradaJugador(entradaDePrueba);
		
		assertEquals(resultadoEsperadoCasteado, entradaDePruebaCasteada);	
	}
	
	/**
	 * -------------------------------- Tests del método comprobarCombinaciones() --------------------------------
	 */
	
	/**
	 * Comprueba el correcto funcionamiento de la función generarCombinacionAleatoria, 
	 * verificando si realmente no se repite ningún número dentro de la combinación aleatoria.
	 * 
	 * Primero obtenemos la combinación generada por la máquina y la almacenamos, seguidamente, 
	 * por cada valor de la combinación generada por la máquina y por cada posición por delante 
	 * del valor resultado[i] se comprueba si el valor de la combinación generada por la máquina 
	 * es igual a los valores de cada posición por delante del valor. En caso afirmativo, existe 
	 * una repetición dentro de la combinación aleatoria y termina la ejecución del bucle if ya 
	 * que se ha hallado un fallo en el código desarrollado. Para finalizar, se realiza una 
	 * comprobación para saber si el assert es (false, false).
	 */
	@Test
	public void testGenerarCombinacionAleatoria() {
		
		boolean esRepetido = false;
		boolean esRepetidoEsperado = false;
		char[][] resultado = Modelo.generarCombinacionSecreta();		
		
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
	 * -------------------------------- Tests del método comprobarCombinaciones() --------------------------------
	 */
	
	/**
	 * Test de caja negra #1 del método comprobarCombinaciones().
	 * 
	 * Comprueba que al comparar una combinación aleatoria y una combinación del jugador
	 * que son idénticas nos devuelve 4 aciertos negros y 0 aciertos blancos.
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
	 * Test de caja negra #2 del método comprobarCombinaciones().
	 * 
	 * Comprueba que al comparar una combinación aleatoria y una combinación del jugador
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
	 * Test de caja negra #3 del método comprobarCombinaciones().
	 * 
	 * Comprueba que al comparar una combinación aleatoria y una combinación del jugador
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
	 * Test de caja negra del método comprobarVictoria().
	 * 
	 * Comprueba que únicamente es victoria cuando es {'N','N','N','N'}.
	 */
	@Test
	public void testComprobarVictoria() {
		
		char[] aciertos0000 = {'0','0','0','0'};
		char[] aciertos000B = {'0','0','0','B'};
		char[] aciertos00B0 = {'0','0','B','0'};
		char[] aciertos00BB = {'0','0','B','B'};
		char[] aciertos0B00 = {'0','B','0','0'};
		char[] aciertos0B0B = {'0','B','0','B'};
		char[] aciertos0BB0 = {'0','B','B','0'};
		char[] aciertos0BBB = {'0','B','B','B'};
		char[] aciertosB000 = {'B','0','0','0'};
		char[] aciertosB00B = {'B','0','0','B'};
		char[] aciertosB0B0 = {'B','0','B','0'};
		char[] aciertosB0BB = {'B','0','B','B'};
		char[] aciertosBB00 = {'B','B','0','0'};
		char[] aciertosBB0B = {'B','B','0','B'};
		char[] aciertosBBB0 = {'B','B','B','0'};
		char[] aciertosBBBB = {'B','B','B','B'};
		
		assertFalse(Modelo.comprobarVictoria(aciertos0000));
		assertFalse(Modelo.comprobarVictoria(aciertos000B));
		assertFalse(Modelo.comprobarVictoria(aciertos00B0));
		assertFalse(Modelo.comprobarVictoria(aciertos00BB));
		assertFalse(Modelo.comprobarVictoria(aciertos0B00));
		assertFalse(Modelo.comprobarVictoria(aciertos0B0B));
		assertFalse(Modelo.comprobarVictoria(aciertos0BB0));
		assertFalse(Modelo.comprobarVictoria(aciertos0BBB));
		assertFalse(Modelo.comprobarVictoria(aciertosB000));
		assertFalse(Modelo.comprobarVictoria(aciertosB00B));
		assertFalse(Modelo.comprobarVictoria(aciertosB0B0));
		assertFalse(Modelo.comprobarVictoria(aciertosB0BB));
		assertFalse(Modelo.comprobarVictoria(aciertosBB00));
		assertFalse(Modelo.comprobarVictoria(aciertosBB0B));
		assertFalse(Modelo.comprobarVictoria(aciertosBBB0));
		assertFalse(Modelo.comprobarVictoria(aciertosBBBB));
		
		char[] aciertos000N = {'0','0','0','N'};
		char[] aciertos00N0 = {'0','0','N','0'};
		char[] aciertos00NN = {'0','0','N','N'};
		char[] aciertos0N00 = {'0','N','0','0'};
		char[] aciertos0N0N = {'0','N','0','N'};
		char[] aciertos0NN0 = {'0','N','N','0'};
		char[] aciertos0NNN = {'0','N','N','N'};
		char[] aciertosN000 = {'N','0','0','0'};
		char[] aciertosN00N = {'N','0','0','N'};
		char[] aciertosN0N0 = {'N','0','N','0'};
		char[] aciertosN0NN = {'N','0','N','N'};
		char[] aciertosNN00 = {'N','N','0','0'};
		char[] aciertosNN0N = {'N','N','0','N'};
		char[] aciertosNNN0 = {'N','N','N','0'};
		char[] aciertosNNNN = {'N','N','N','N'};

		assertFalse(Modelo.comprobarVictoria(aciertos000N));
		assertFalse(Modelo.comprobarVictoria(aciertos00N0));
		assertFalse(Modelo.comprobarVictoria(aciertos00NN));
		assertFalse(Modelo.comprobarVictoria(aciertos0N00));
		assertFalse(Modelo.comprobarVictoria(aciertos0N0N));
		assertFalse(Modelo.comprobarVictoria(aciertos0NN0));
		assertFalse(Modelo.comprobarVictoria(aciertos0NNN));
		assertFalse(Modelo.comprobarVictoria(aciertosN000));
		assertFalse(Modelo.comprobarVictoria(aciertosN00N));
		assertFalse(Modelo.comprobarVictoria(aciertosN0N0));
		assertFalse(Modelo.comprobarVictoria(aciertosN0NN));
		assertFalse(Modelo.comprobarVictoria(aciertosNN00));
		assertFalse(Modelo.comprobarVictoria(aciertosNN0N));
		assertFalse(Modelo.comprobarVictoria(aciertosNNN0));
		assertTrue(Modelo.comprobarVictoria(aciertosNNNN));
		
		char[] aciertosNNNB = {'N','N','N','B'};
		char[] aciertosNNBN = {'N','N','B','N'};
		char[] aciertosNNBB = {'N','N','B','B'};
		char[] aciertosNBNN = {'N','B','N','N'};
		char[] aciertosNBNB = {'N','B','N','B'};
		char[] aciertosNBBN = {'N','B','B','N'};
		char[] aciertosNBBB = {'N','B','B','B'};
		char[] aciertosBNNN = {'B','N','N','N'};
		char[] aciertosBNNB = {'B','N','N','B'};
		char[] aciertosBNBN = {'B','N','B','N'};
		char[] aciertosBNBB = {'B','N','B','B'};
		char[] aciertosBBNN = {'B','B','N','N'};
		char[] aciertosBBNB = {'B','B','N','B'};
		char[] aciertosBBBN = {'B','B','B','N'};
		
		assertFalse(Modelo.comprobarVictoria(aciertosNNNB));
		assertFalse(Modelo.comprobarVictoria(aciertosNNBN));
		assertFalse(Modelo.comprobarVictoria(aciertosNNBB));
		assertFalse(Modelo.comprobarVictoria(aciertosNBNN));
		assertFalse(Modelo.comprobarVictoria(aciertosNBNB));
		assertFalse(Modelo.comprobarVictoria(aciertosNBBN));
		assertFalse(Modelo.comprobarVictoria(aciertosNBBB));
		assertFalse(Modelo.comprobarVictoria(aciertosBNNN));
		assertFalse(Modelo.comprobarVictoria(aciertosBNNB));
		assertFalse(Modelo.comprobarVictoria(aciertosBNBN));
		assertFalse(Modelo.comprobarVictoria(aciertosBNBB));
		assertFalse(Modelo.comprobarVictoria(aciertosBBNN));
		assertFalse(Modelo.comprobarVictoria(aciertosBBNB));
		assertFalse(Modelo.comprobarVictoria(aciertosBBBN));		
	}
	
	/**
	 * -------------------------------- Tests del método comprobarEntradaJugador() --------------------------------
	 */
	
	/**
	 * Test de caja negra #1 del método comprobarEntradaJugador().
	 * 
	 * Comprueba el límite superior del rango [0-8] con el valor 9.
	 * El método comprobarEntradaJugador debe devolver false al
	 * tratarse de un valor fuera del rango [0-8].
	 */
	@Test
	public void testComprobarLimiteSuperiorEntradaJugador() {
		char[][] entrada = {{'0'}, {'2'} , {'9'} , {'4'}};
		boolean esperado = false;
		boolean resultado = Modelo.validarEntradaJugador(entrada);
		
		assertEquals(resultado, esperado);
	}
	
	/**
	 * Test de caja negra #2 del método comprobarEntradaJugador().
	 * 
	 * Comprueba el límite superior del rango [0-8] con el valor -.
	 * El método comprobarEntradaJugador debe devolver false al
	 * tratarse de un valor fuera del rango [0-8].
	 */
	@Test
	public void testComprobarLimiteInferiorEntradaJugador() {
		char[][] entrada = {{'0'}, {'2'} , {'-'} , {'4'}};
		boolean esperado = false;
		boolean resultado = Modelo.validarEntradaJugador(entrada);
		
		assertEquals(resultado, esperado);
	}
	
	
	/**
	 * Test de caja negra #3 del método comprobarEntradaJugador().
	 * 
	 * Comprueba el valor frontera superior del rango [0-8] con el valor 8.
	 * El método comprobarEntradaJugador debe devolver true al
	 * tratarse de un valor dentro del rango [0-8].
	 */
	@Test
	public void testComprobarValorFronteraSuperiorEntradaJugadorCorrecta() {
		char[][] entrada = {{'6'}, {'2'} , {'8'} , {'4'}};
		boolean esperado = true;
		boolean resultado = Modelo.validarEntradaJugador(entrada);
		
		assertEquals(resultado, esperado);
	}
	
	/**
	 * Test de caja negra #4 del método comprobarEntradaJugador().
	 * 
	 * Comprueba el valor frontera del rango [0-8] con el valor 0.
	 * El método comprobarEntradaJugador debe devolver true al
	 * tratarse de un valor dentro del rango [0-8].
	 */
	@Test
	public void testComprobarValorFronteraInferiorEntradaJugadorCorrecta() {
		char[][] entrada = {{'6'}, {'2'} , {'0'} , {'4'}};
		boolean esperado = true;
		boolean resultado = Modelo.validarEntradaJugador(entrada);
		
		assertEquals(resultado, esperado);
	}
}