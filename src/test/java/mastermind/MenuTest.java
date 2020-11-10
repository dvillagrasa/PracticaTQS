package mastermind;

import static org.junit.Assert.*;

import org.junit.Test;

public class MenuTest {

	@Test
	public void testComprobarOpcion() {
		
		Menu menu = new Menu();
		
		assertFalse(menu.comprobarOpcion(-50)); // Límite inferior extremo.
		assertFalse(menu.comprobarOpcion(-1)); // Límite inferior alejado.
		assertFalse(menu.comprobarOpcion(0)); // Frontera inferior.
		
		assertTrue(menu.comprobarOpcion(1)); // Frontera inferior.
		assertTrue(menu.comprobarOpcion(2)); // Frontera superior.
		
		assertFalse(menu.comprobarOpcion(3)); // Límite superior alejado.
		assertFalse(menu.comprobarOpcion(50)); // Límite superior extremo.

	}
}
