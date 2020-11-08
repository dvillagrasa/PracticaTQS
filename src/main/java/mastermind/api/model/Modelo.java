package mastermind.api.model;



import java.util.ArrayList;
import java.util.Random;

/**
 * Clase Modelo - Esta clase se encargará de cálculos y de dar valores/objetos que tengamos
 * que utilizar en nuestro programa.
 *  
 * @author Daniel Luis Garcia
 * @author Daniel Villagrasa Ramírez
 */
public class Modelo {

	/**
	 * MAX_CLAVIJAS es el número de posiciones del tablero del juego. En este caso son 4
	 * tanto para los números (serían los colores exceptuando el blanco y negro), como 
	 * para mostrar los aciertos de números y/o posición (serían los colores blanco y negro).
	 */
	public static final int MAX_CLAVIJAS = 4;	

	/**
	 * aleatorio es la variable que nos permite obtener un número aleatorio dentro de un
	 * conjunto de datos.
	 */
	public static final Random aleatorio = new Random(); // función a la que llamamos para que nos devuelva un aleatorio
	/**
	 * numeros es un array de cadenas de carácteres. Estos carácteres establecen un rango
	 * de 0 a 8, que son los números que pueden ser usados tanto para las tiradas del
	 * jugador como para el código aleatorio secreto.
	 */
	static String[] numeros = {"0","1","2","3","4","5","6","7","8"};
	
	/**
	 * generarCombinacionAleatoria devuelve un array de cadena de carácteres. Este array es 
	 * la combinación secreta del juego, la cual deberá ser adivinada por el jugador.
	 * 
	 * @return Devuelve el array de cadenas de carácteres secreto. 
	 */
	public static char[][] generarCombinacionAleatoria(){
		
		String[] combinacionAleatoria = new String [4];
		char[][] combinacionAleatoriaCasteada = new char [combinacionAleatoria.length][];
		
		ArrayList<String> cola = new ArrayList<>();
		for(int i = 0; i < 9; i++) {
			cola.add(numeros[i]);
		}
		//System.out.println(cola); // Imprime [0, 1, 2, 3, 4, 5, 6, 7, 8]
		for(int i = 0; i < 4; i++) //Saca 5 numeros de la cola, así quedan 4.
		{
			int numAleatorio = aleatorio.nextInt(cola.size());
			combinacionAleatoria[i] = cola.get(numAleatorio);
			cola.remove(numAleatorio);
			
			combinacionAleatoriaCasteada[i] = combinacionAleatoria[i].toCharArray(); 
		}
		return combinacionAleatoriaCasteada;
	}
	
	/**
	 * comprobarEntradaJugador es una función que comprueba que los carácteres que el jugador ha introducido por teclado
	 * sean entre 0 y 8, ambos incluídos. En caso de que no sea así se mostrará un mensaje por pantalla con un aviso.
	 * @param entradaJugadorCasteada es el array de carácteres de la función obtenerEntradaJugador().
	 * @return Devuelve un booleano que será verdadero cuando toda la entrada del jugador sean carácteres dentro del
	 * rango de 0 a 8 (ambos incluídos).
	 */
	public static boolean comprobarEntradaJugador(char[][] entradaJugadorCasteada) {
		boolean entradaJugadorCorrecta = true;
		for(int i = 0; i < entradaJugadorCasteada.length; i++) {
			if((entradaJugadorCasteada[i][0] < '0') || (entradaJugadorCasteada[i][0] > '8')) {
				entradaJugadorCorrecta = false;
				return entradaJugadorCorrecta;
				//throw new Exception("El número " + entradaJugadorCasteada[i] + " está fuera del rango [0 - 8]."); // Si se ejecuta la execpción nunca hará el return.
			}
		}
		//System.out.println(entradaJugadorCorrecta);
		return entradaJugadorCorrecta;
	}
	
	/**
	 * Método que recorre y compara ambas combinaciones y devuelve el número de aciertos 
	 * en base a las normas del Mastermind
	 * @param Aleatoria - Es la combinacion aleatoria generada por el programa
	 * @param Usuario - Es la combinación entrada por el usuario
	 * @return Devuelve un string de int donde se muestra el número de [aciertosNegros, aciertosBlancos]
	 */
	public static int[] CompararCombinaciones(char[][] Aleatoria, char[][] Usuario) {

		char[][] combinacionAleatoria = Aleatoria;
		char[][] combinacionJugador = Usuario;
		int aciertosNegros = 0;
		int aciertosBlancos = 0;
		

		for(int i = 0; i < MAX_CLAVIJAS; i++){
			for (int j = 0; j < combinacionAleatoria.length; j++){
				if(combinacionAleatoria[i][0] == combinacionJugador[j][0]){
					if(combinacionAleatoria[i][0] == combinacionJugador[i][0]) {
						aciertosNegros++; //ACIERTO POSICION Y COLOR (RECORDATORIO PARA DANI PORQUE ME OLVIDO DE COMO VA ESTO)
					} else {
						aciertosBlancos++; //ACIERTO SOLO POSICION (RECORDATORIO PARA DANI PORQUE ME OLVIDO DE COMO VA ESTO)
						}
					}
				}
			}
		return new int[] {aciertosNegros, aciertosBlancos};
		}
	/**
	 * 
	 * @param aciertos - Recibimos el string de int con el número de aciertos negros y blancos
	 * @return Devolvemos true si el número de aciertos negros es = 4
	 * false si el número de aciertos negros es cualquier otro
	 */
	public static boolean haGanado(int[] aciertos) {
		
		boolean ganar = false;
		
		if(aciertos[0] == MAX_CLAVIJAS) {
			ganar = true;
		}
		else {
			ganar = false;
		}	
		return ganar;
	}
	
	
}