package mastermind;

import static org.junit.Assert.*;

import org.junit.Test;

public class MenuTest {
	/**
	 * Test del m�todo comprobarOpci�n.
	 */
	@Test
	public void testComprobarOpcion() {
		
		Menu menu = new Menu();
	
		assertFalse(menu.comprobarOpcion('-')); // L�mite.
		assertFalse(menu.comprobarOpcion('*')); // L�mite.
		
		assertFalse(menu.comprobarOpcion('0')); // L�mite inferior.
		
		assertTrue(menu.comprobarOpcion('1')); // Frontera inferior.
		assertTrue(menu.comprobarOpcion('2')); // Frontera superior.
		
		assertFalse(menu.comprobarOpcion('3')); // L�mite superior alejado.
		assertFalse(menu.comprobarOpcion('4')); // L�mite superior alejado.
		assertFalse(menu.comprobarOpcion('5')); // L�mite superior alejado.
		assertFalse(menu.comprobarOpcion('6')); // L�mite superior alejado.
		assertFalse(menu.comprobarOpcion('7')); // L�mite superior alejado.
		assertFalse(menu.comprobarOpcion('8')); // L�mite superior alejado.
		assertFalse(menu.comprobarOpcion('9')); // L�mite superior alejado.
	}
}
