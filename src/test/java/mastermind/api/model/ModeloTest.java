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

		assertEquals(valorEsperado, modelo.comprobarEntradaJugador(entradaCasteada));
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
		assertEquals(valorEsperado, modelo.comprobarEntradaJugador(entradaCasteada));
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

		assertEquals(valorEsperado, modelo.comprobarEntradaJugador(entradaCasteada));
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

		assertEquals(valorEsperado, modelo.comprobarEntradaJugador(entradaCasteada));
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
	 * -------------------------------- Tests del método comprobarVictoria() --------------------------------
	 */
	
	/**
	 * Test de caja negra #1 del método comprobarVictoria().
	 * 
	 * Comprueba el valor frontera superior del número de aciertos 
	 * permitido. En este caso el valor fronteran superior es 4. 
	 * El método comprobarVictoria debe devolver true al tratarse 
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
	 * Test de caja negra #2 del método comprobarVictoria().
	 * 
	 * Comprueba el valor interior del número de aciertos permitido. 
	 * En este caso el valor interior es 3. El método comprobarVictoria 
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
	 * Test de caja negra #3 del método comprobarVictoria().
	 * 
	 * Comprueba el valor frontera inferior del número de aciertos 
	 * permitido. En este caso el valor frontera superior es 0. El 
	 * método comprobarVictoria debe devolver false al no obtener 
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
	 * Test de caja negra #4 del método comprobarVictoria().
	 * 
	 * Comprueba el valor frontera inferior del número de aciertos 
	 * blancos permitido. En este caso el valor frontera superior 
	 * es 4. El método comprobarVictoria debe devolver false al no 
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
	 * Test de caja negra #5 del método comprobarVictoria().
	 * 
	 * Comprueba el valor límite superior del número de aciertos 
	 * permitido. En este caso el valor límite superior es 5. El 
	 * método comprobarVictoria debe devolver false al no ser 4 
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
		boolean resultado = Modelo.comprobarEntradaJugador(entrada);
		
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
		boolean resultado = Modelo.comprobarEntradaJugador(entrada);
		
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
		boolean resultado = Modelo.comprobarEntradaJugador(entrada);
		
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
		boolean resultado = Modelo.comprobarEntradaJugador(entrada);
		
		assertEquals(resultado, esperado);
	}
}