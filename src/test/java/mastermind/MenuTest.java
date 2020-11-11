package mastermind;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Clase MenuTest - En esta clase se realizan los tests para la clase Menu.
 * 
* @author Daniel Luis Garcia 
* @author Daniel Villagrasa Ramirez
*/ 
public class MenuTest {
	/**
	 * Test del metodo comprobarOpcion.
	 */
	@Test
	public void testComprobarOpcion() {
		
		Menu menu = new Menu();
	
		assertFalse(menu.comprobarOpcion('-')); // Limite.
		assertFalse(menu.comprobarOpcion('*')); // Limite.
		
		assertFalse(menu.comprobarOpcion('0')); // Limite inferior.
		
		assertTrue(menu.comprobarOpcion('1')); // Frontera inferior.
		assertTrue(menu.comprobarOpcion('2')); // Frontera superior.
		
		assertFalse(menu.comprobarOpcion('3')); // Limite superior alejado.
		assertFalse(menu.comprobarOpcion('4')); // Limite superior alejado.
		assertFalse(menu.comprobarOpcion('5')); // Limite superior alejado.
		assertFalse(menu.comprobarOpcion('6')); // Limite superior alejado.
		assertFalse(menu.comprobarOpcion('7')); // Limite superior alejado.
		assertFalse(menu.comprobarOpcion('8')); // Limite superior alejado.
		assertFalse(menu.comprobarOpcion('9')); // Limite superior alejado.
	}
}
