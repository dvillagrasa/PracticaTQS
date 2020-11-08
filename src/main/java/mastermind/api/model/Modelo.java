package mastermind.api.model;



import java.util.ArrayList;
import java.util.Random;

/**
 * Clase Modelo - Esta clase se encargar� de c�lculos y de dar valores/objetos que tengamos
 * que utilizar en nuestro programa.
 *  
 * @author Daniel Luis Garcia
 * @author Daniel Villagrasa Ram�rez
 */
public class Modelo {

	/**
	 * MAX_CLAVIJAS es el n�mero de posiciones del tablero del juego. En este caso son 4
	 * tanto para los n�meros (ser�an los colores exceptuando el blanco y negro), como 
	 * para mostrar los aciertos de n�meros y/o posici�n (ser�an los colores blanco y negro).
	 */
	public static final int MAX_CLAVIJAS = 4;	

	/**
	 * aleatorio es la variable que nos permite obtener un n�mero aleatorio dentro de un
	 * conjunto de datos.
	 */
	public static final Random aleatorio = new Random(); // funci�n a la que llamamos para que nos devuelva un aleatorio
	/**
	 * numeros es un array de cadenas de car�cteres. Estos car�cteres establecen un rango
	 * de 0 a 8, que son los n�meros que pueden ser usados tanto para las tiradas del
	 * jugador como para el c�digo aleatorio secreto.
	 */
	static String[] numeros = {"0","1","2","3","4","5","6","7","8"};
	
	/**
	 * generarCombinacionAleatoria devuelve un array de cadena de car�cteres. Este array es 
	 * la combinaci�n secreta del juego, la cual deber� ser adivinada por el jugador.
	 * 
	 * @return Devuelve el array de cadenas de car�cteres secreto. 
	 */
	public static char[][] generarCombinacionAleatoria(){
		
		String[] combinacionAleatoria = new String [4];
		char[][] combinacionAleatoriaCasteada = new char [combinacionAleatoria.length][];
		
		ArrayList<String> cola = new ArrayList<>();
		for(int i = 0; i < 9; i++) {
			cola.add(numeros[i]);
		}
		//System.out.println(cola); // Imprime [0, 1, 2, 3, 4, 5, 6, 7, 8]
		for(int i = 0; i < 4; i++) //Saca 5 numeros de la cola, as� quedan 4.
		{
			int numAleatorio = aleatorio.nextInt(cola.size());
			combinacionAleatoria[i] = cola.get(numAleatorio);
			cola.remove(numAleatorio);
			
			combinacionAleatoriaCasteada[i] = combinacionAleatoria[i].toCharArray(); 
		}
		return combinacionAleatoriaCasteada;
	}
	
	/**
	 * comprobarEntradaJugador es una funci�n que comprueba que los car�cteres que el jugador ha introducido por teclado
	 * sean entre 0 y 8, ambos inclu�dos. En caso de que no sea as� se mostrar� un mensaje por pantalla con un aviso.
	 * @param entradaJugadorCasteada es el array de car�cteres de la funci�n obtenerEntradaJugador().
	 * @return Devuelve un booleano que ser� verdadero cuando toda la entrada del jugador sean car�cteres dentro del
	 * rango de 0 a 8 (ambos inclu�dos).
	 */
	public static boolean comprobarEntradaJugador(char[][] entradaJugadorCasteada) {
		boolean entradaJugadorCorrecta = true;
		for(int i = 0; i < entradaJugadorCasteada.length; i++) {
			if((entradaJugadorCasteada[i][0] < '0') || (entradaJugadorCasteada[i][0] > '8')) {
				entradaJugadorCorrecta = false;
				return entradaJugadorCorrecta;
				//throw new Exception("El n�mero " + entradaJugadorCasteada[i] + " est� fuera del rango [0 - 8]."); // Si se ejecuta la execpci�n nunca har� el return.
			}
		}
		//System.out.println(entradaJugadorCorrecta);
		return entradaJugadorCorrecta;
	}
	
	/**
	 * M�todo que recorre y compara ambas combinaciones y devuelve el n�mero de aciertos 
	 * en base a las normas del Mastermind
	 * @param Aleatoria - Es la combinacion aleatoria generada por el programa
	 * @param Usuario - Es la combinaci�n entrada por el usuario
	 * @return Devuelve un string de int donde se muestra el n�mero de [aciertosNegros, aciertosBlancos]
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
	 * @param aciertos - Recibimos el string de int con el n�mero de aciertos negros y blancos
	 * @return Devolvemos true si el n�mero de aciertos negros es = 4
	 * false si el n�mero de aciertos negros es cualquier otro
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