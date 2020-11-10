package mastermind;

import static org.junit.Assert.*;

import org.junit.Test;

public class MenuTest {

	@Test
	public void testComprobarOpcion() {
		
		Menu menu = new Menu();
	
		assertFalse(menu.comprobarOpcion('-')); // Límite inferior alejado.
		assertFalse(menu.comprobarOpcion('0')); // Frontera inferior.
		
		assertTrue(menu.comprobarOpcion('1')); // Frontera inferior.
		assertTrue(menu.comprobarOpcion('2')); // Frontera superior.
		
		assertFalse(menu.comprobarOpcion('3')); // Límite superior alejado.
		assertFalse(menu.comprobarOpcion('9')); // Límite superior extremo.

	}
}
