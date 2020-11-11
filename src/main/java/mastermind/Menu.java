package mastermind;

/**
 * Clase Menu - Contiene el menu del juego MasterMind y un metodo de comprobacion
 * para la opcion del menu deseada.
 *  
 * @author Daniel Luis Garcia
 * @author Daniel Villagrasa Ramirez
 */
public class Menu {
	/**
	 * Muestra el menu del juego.
	 */
	void mostrarMenu() {
		
		System.out.println("-------------------- MASTER MIND --------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println("--     [1]  Jugar                                  --");
		System.out.println("--     [2]  Salir                                  --");
		System.out.println("-----------------------------------------------------");
		System.out.println("");
		System.out.println("Selecciona una opcion (1 o 2).");
	}
	
	/**
	 * Comprueba que el numero introducido por teclado es valido.
	 * @param opcion - opcion introducida por teclado.
	 * @return - Devuelve true o false, dependiendo de opcion.
	 */
	public boolean comprobarOpcion(char opcion) {
		boolean esCorrecto = true;
		
		if((opcion < '1') || (opcion > '2')) {
			esCorrecto = false;
		}
		return esCorrecto;
	}
}