package mastermind;

import static org.junit.Assert.*;

import org.junit.Test;

public class MenuTest {
	/**
	 * Test del método comprobarOpción.
	 */
	@Test
	public void testComprobarOpcion() {
		
		Menu menu = new Menu();
	
		assertFalse(menu.comprobarOpcion('-')); // Límite.
		assertFalse(menu.comprobarOpcion('*')); // Límite.
		
		assertFalse(menu.comprobarOpcion('0')); // Límite inferior.
		
		assertTrue(menu.comprobarOpcion('1')); // Frontera inferior.
		assertTrue(menu.comprobarOpcion('2')); // Frontera superior.
		
		assertFalse(menu.comprobarOpcion('3')); // Límite superior alejado.
		assertFalse(menu.comprobarOpcion('4')); // Límite superior alejado.
		assertFalse(menu.comprobarOpcion('5')); // Límite superior alejado.
		assertFalse(menu.comprobarOpcion('6')); // Límite superior alejado.
		assertFalse(menu.comprobarOpcion('7')); // Límite superior alejado.
		assertFalse(menu.comprobarOpcion('8')); // Límite superior alejado.
		assertFalse(menu.comprobarOpcion('9')); // Límite superior alejado.
	}
}
