package mastermind;

public class Menu {
	
	void mostrarMenu() {
		
		System.out.println("---------- MASTER MIND ----------");
		System.out.println("---------------------------------");
		System.out.println("- [1] - Jugar");
		System.out.println("- [2] - Salir");
		System.out.println("---------------------------------");
		System.out.println("");
		System.out.println("Selecciona una opción (1 o 2).");
	}
	
	
	public boolean comprobarOpcion(int opcion) {
		boolean esCorrecto = true;
		
		if((opcion < 1) || (opcion > 2)) {
			esCorrecto = false;
		}
		return esCorrecto;
	}
}