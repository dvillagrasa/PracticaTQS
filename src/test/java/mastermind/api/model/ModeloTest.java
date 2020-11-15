package mastermind.api.model;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import mastermind.Aleatorio;
import mastermind.InterfazAleatorio;
import mastermind.InterfazEscaner;
import mastermind.MockAleatorio;
import mastermind.MockEscaner;
import mastermind.api.view.*;

/**
 * Clase ModeloTest - Clase donde se encuentran los metodos de test relacionados
 * con el modelo del juego.
 * 
 * @author Daniel Luis Garcia
 * @author Daniel Villagrasa Ramirez
 */
public class ModeloTest {
	/**
	 * Instancia de la clase Modelo.
	 */
	Modelo modelo = new Modelo();

	/**
	 * Numero de posiciones del tablero del juego. En este caso son 4 tanto para los
	 * numeros (serian los colores exceptuando el blanco y negro), como para mostrar
	 * los aciertos de numeros y/o posicion (serian los colores blanco y negro).
	 */
	public static final int MAX_CLAVIJAS = 4;

	/**
	 * Array de cadenas de caracteres de un rango de 0 a 8, que son los numeros para
	 * el codigo aleatorio secreto.
	 */
	static String[] numeros = { "0", "1", "2", "3", "4", "5", "6", "7", "8" };

	//////////////////////////////////////////////////////////////////////////////////////////////////////// Particiones
	//////////////////////////////////////////////////////////////////////////////////////////////////////// equivalentes
	//////////////////////////////////////////////////////////////////////////////////////////////////////// validas.
	// EL VALOR FRONTERA "0000" ESTA EN LA LINEA 80 APROX.
	String combinacionJugador8888 = "8888"; // Valores frontera 8.

	String combinacionJugador0628 = "0628"; // Valores frontera 0 y 8.
	String combinacionJugador8462 = "8462"; // Valor frontera 8.
	String combinacionJugador4860 = "4860"; // Valores frontera 0 y 8.
	String combinacionJugador4602 = "4602"; // Valor frontera 0.

	String combinacionJugador4127 = "4127"; // Valores limite 1 y 7.
	String combinacionJugador7461 = "7461"; // Valores limite 1 y 7.
	String combinacionJugador4712 = "4712"; // Valores limite 1 y 7.
	String combinacionJugador1672 = "1672"; // Valores limite 1 y 7.

	char[] entradaCasteada8888 = modelo.castearCombinacionJugador(combinacionJugador8888);

	char[] combinacionCasteada4127 = modelo.castearCombinacionJugador(combinacionJugador4127);
	char[] combinacionCasteada7461 = modelo.castearCombinacionJugador(combinacionJugador7461);
	char[] combinacionCasteada4712 = modelo.castearCombinacionJugador(combinacionJugador4712);
	char[] combinacionCasteada1672 = modelo.castearCombinacionJugador(combinacionJugador1672);

	char[] combinacionCasteada0628 = modelo.castearCombinacionJugador(combinacionJugador0628);
	char[] combinacionCasteada8462 = modelo.castearCombinacionJugador(combinacionJugador8462);
	char[] combinacionCasteada4860 = modelo.castearCombinacionJugador(combinacionJugador4860);
	char[] combinacionCasteada4602 = modelo.castearCombinacionJugador(combinacionJugador4602);

	/**
	 * Pair-wise testing de numeros [0-8]
	 * ------------------------------------------- 0 | 0 | 0 | 0 1 | 1 | 1 | 1 2 | 2
	 * | 2 | 2 3 | 3 | 3 | 3 4 | 4 | 4 | 4 5 | 5 | 5 | 5 6 | 6 | 6 | 6 7 | 7 | 7 | 7
	 * 8 | 8 | 8 | 8
	 * 
	 * https://pairwise.teremokgames.com/x4a8/
	 */
	String combinacionJugador0000 = "0000"; // Valores frontera 0.
	String combinacionJugador0111 = "0111";
	String combinacionJugador0222 = "0222";
	String combinacionJugador0333 = "0333";
	String combinacionJugador0444 = "0444";
	String combinacionJugador0555 = "0555";
	String combinacionJugador0666 = "0666";
	String combinacionJugador0777 = "0777";
	String combinacionJugador0888 = "0888";
	String combinacionJugador1123 = "1123";
	String combinacionJugador1234 = "1234";
	String combinacionJugador1345 = "1345";
	String combinacionJugador1456 = "1456";
	String combinacionJugador1567 = "1567";
	String combinacionJugador1678 = "1678";
	String combinacionJugador1780 = "1780";
	String combinacionJugador1801 = "1801";
	String combinacionJugador1012 = "1012";
	String combinacionJugador2246 = "2246";
	String combinacionJugador2357 = "2357";
	String combinacionJugador2468 = "2468";
	String combinacionJugador2570 = "2570";
	String combinacionJugador2681 = "2681";
	String combinacionJugador2702 = "2702";
	String combinacionJugador2813 = "2813";
	String combinacionJugador2024 = "2024";
	String combinacionJugador2135 = "2135";
	String combinacionJugador3360 = "3360";
	String combinacionJugador3471 = "3471";
	String combinacionJugador3582 = "3582";
	String combinacionJugador3603 = "3603";
	String combinacionJugador3714 = "3714";
	String combinacionJugador3825 = "3825";
	String combinacionJugador3036 = "3036";
	String combinacionJugador3147 = "3147";
	String combinacionJugador3258 = "3258";
	String combinacionJugador4483 = "4483";
	String combinacionJugador4504 = "4504";
	String combinacionJugador4615 = "4615";
	String combinacionJugador4726 = "4726";
	String combinacionJugador4837 = "4837";
	String combinacionJugador4048 = "4048";
	String combinacionJugador4150 = "4150";
	String combinacionJugador4261 = "4261";
	String combinacionJugador4372 = "4372";
	String combinacionJugador5516 = "5516";
	String combinacionJugador5627 = "5627";
	String combinacionJugador5738 = "5738";
	String combinacionJugador5840 = "5840";
	String combinacionJugador5051 = "5051";
	String combinacionJugador5162 = "5162";
	String combinacionJugador5273 = "5273";
	String combinacionJugador5384 = "5384";
	String combinacionJugador5405 = "5405";
	String combinacionJugador6630 = "6630";
	String combinacionJugador6741 = "6741";
	String combinacionJugador6852 = "6852";
	String combinacionJugador6063 = "6063";
	String combinacionJugador6174 = "6174";
	String combinacionJugador6285 = "6285";
	String combinacionJugador6306 = "6306";
	String combinacionJugador6417 = "6417";
	String combinacionJugador6528 = "6528";
	String combinacionJugador7753 = "7753";
	String combinacionJugador7864 = "7864";
	String combinacionJugador7075 = "7075";
	String combinacionJugador7186 = "7186";
	String combinacionJugador7207 = "7207";
	String combinacionJugador7318 = "7318";
	String combinacionJugador7420 = "7420";
	String combinacionJugador7531 = "7531";
	String combinacionJugador7642 = "7642";
	String combinacionJugador8876 = "8876";
	String combinacionJugador8087 = "8087";
	String combinacionJugador8108 = "8108";
	String combinacionJugador8210 = "8210";
	String combinacionJugador8321 = "8321";
	String combinacionJugador8432 = "8432";
	String combinacionJugador8543 = "8543";
	String combinacionJugador8654 = "8654";
	String combinacionJugador8765 = "8765";

	char[] combinacionCasteada0000 = modelo.castearCombinacionJugador(combinacionJugador0000);
	char[] combinacionCasteada0111 = modelo.castearCombinacionJugador(combinacionJugador0111);
	char[] combinacionCasteada0222 = modelo.castearCombinacionJugador(combinacionJugador0222);
	char[] combinacionCasteada0333 = modelo.castearCombinacionJugador(combinacionJugador0333);
	char[] combinacionCasteada0444 = modelo.castearCombinacionJugador(combinacionJugador0444);
	char[] combinacionCasteada0555 = modelo.castearCombinacionJugador(combinacionJugador0555);
	char[] combinacionCasteada0666 = modelo.castearCombinacionJugador(combinacionJugador0666);
	char[] combinacionCasteada0777 = modelo.castearCombinacionJugador(combinacionJugador0777);
	char[] combinacionCasteada0888 = modelo.castearCombinacionJugador(combinacionJugador0888);
	char[] combinacionCasteada1123 = modelo.castearCombinacionJugador(combinacionJugador1123);
	char[] combinacionCasteada1234 = modelo.castearCombinacionJugador(combinacionJugador1234);
	char[] combinacionCasteada1345 = modelo.castearCombinacionJugador(combinacionJugador1345);
	char[] combinacionCasteada1456 = modelo.castearCombinacionJugador(combinacionJugador1456);
	char[] combinacionCasteada1567 = modelo.castearCombinacionJugador(combinacionJugador1567);
	char[] combinacionCasteada1678 = modelo.castearCombinacionJugador(combinacionJugador1678);
	char[] combinacionCasteada1780 = modelo.castearCombinacionJugador(combinacionJugador1780);
	char[] combinacionCasteada1801 = modelo.castearCombinacionJugador(combinacionJugador1801);
	char[] combinacionCasteada1012 = modelo.castearCombinacionJugador(combinacionJugador1012);
	char[] combinacionCasteada2246 = modelo.castearCombinacionJugador(combinacionJugador2246);
	char[] combinacionCasteada2357 = modelo.castearCombinacionJugador(combinacionJugador2357);
	char[] combinacionCasteada2468 = modelo.castearCombinacionJugador(combinacionJugador2468);
	char[] combinacionCasteada2570 = modelo.castearCombinacionJugador(combinacionJugador2570);
	char[] combinacionCasteada2681 = modelo.castearCombinacionJugador(combinacionJugador2681);
	char[] combinacionCasteada2702 = modelo.castearCombinacionJugador(combinacionJugador2702);
	char[] combinacionCasteada2813 = modelo.castearCombinacionJugador(combinacionJugador2813);
	char[] combinacionCasteada2024 = modelo.castearCombinacionJugador(combinacionJugador2024);
	char[] combinacionCasteada2135 = modelo.castearCombinacionJugador(combinacionJugador2135);
	char[] combinacionCasteada3360 = modelo.castearCombinacionJugador(combinacionJugador3360);
	char[] combinacionCasteada3471 = modelo.castearCombinacionJugador(combinacionJugador3471);
	char[] combinacionCasteada3582 = modelo.castearCombinacionJugador(combinacionJugador3582);
	char[] combinacionCasteada3603 = modelo.castearCombinacionJugador(combinacionJugador3603);
	char[] combinacionCasteada3714 = modelo.castearCombinacionJugador(combinacionJugador3714);
	char[] combinacionCasteada3825 = modelo.castearCombinacionJugador(combinacionJugador3825);
	char[] combinacionCasteada3036 = modelo.castearCombinacionJugador(combinacionJugador3036);
	char[] combinacionCasteada3147 = modelo.castearCombinacionJugador(combinacionJugador3147);
	char[] combinacionCasteada3258 = modelo.castearCombinacionJugador(combinacionJugador3258);
	char[] combinacionCasteada4483 = modelo.castearCombinacionJugador(combinacionJugador4483);
	char[] combinacionCasteada4504 = modelo.castearCombinacionJugador(combinacionJugador4504);
	char[] combinacionCasteada4615 = modelo.castearCombinacionJugador(combinacionJugador4615);
	char[] combinacionCasteada4726 = modelo.castearCombinacionJugador(combinacionJugador4726);
	char[] combinacionCasteada4837 = modelo.castearCombinacionJugador(combinacionJugador4837);
	char[] combinacionCasteada4048 = modelo.castearCombinacionJugador(combinacionJugador4048);
	char[] combinacionCasteada4150 = modelo.castearCombinacionJugador(combinacionJugador4150);
	char[] combinacionCasteada4261 = modelo.castearCombinacionJugador(combinacionJugador4261);
	char[] combinacionCasteada4372 = modelo.castearCombinacionJugador(combinacionJugador4372);
	char[] combinacionCasteada5516 = modelo.castearCombinacionJugador(combinacionJugador5516);
	char[] combinacionCasteada5627 = modelo.castearCombinacionJugador(combinacionJugador5627);
	char[] combinacionCasteada5738 = modelo.castearCombinacionJugador(combinacionJugador5738);
	char[] combinacionCasteada5840 = modelo.castearCombinacionJugador(combinacionJugador5840);
	char[] combinacionCasteada5051 = modelo.castearCombinacionJugador(combinacionJugador5051);
	char[] combinacionCasteada5162 = modelo.castearCombinacionJugador(combinacionJugador5162);
	char[] combinacionCasteada5273 = modelo.castearCombinacionJugador(combinacionJugador5273);
	char[] combinacionCasteada5384 = modelo.castearCombinacionJugador(combinacionJugador5384);
	char[] combinacionCasteada5405 = modelo.castearCombinacionJugador(combinacionJugador5405);
	char[] combinacionCasteada6630 = modelo.castearCombinacionJugador(combinacionJugador6630);
	char[] combinacionCasteada6741 = modelo.castearCombinacionJugador(combinacionJugador6741);
	char[] combinacionCasteada6852 = modelo.castearCombinacionJugador(combinacionJugador6852);
	char[] combinacionCasteada6063 = modelo.castearCombinacionJugador(combinacionJugador6063);
	char[] combinacionCasteada6174 = modelo.castearCombinacionJugador(combinacionJugador6174);
	char[] combinacionCasteada6285 = modelo.castearCombinacionJugador(combinacionJugador6285);
	char[] combinacionCasteada6306 = modelo.castearCombinacionJugador(combinacionJugador6306);
	char[] combinacionCasteada6417 = modelo.castearCombinacionJugador(combinacionJugador6417);
	char[] combinacionCasteada6528 = modelo.castearCombinacionJugador(combinacionJugador6528);
	char[] combinacionCasteada7753 = modelo.castearCombinacionJugador(combinacionJugador7753);
	char[] combinacionCasteada7864 = modelo.castearCombinacionJugador(combinacionJugador7864);
	char[] combinacionCasteada7075 = modelo.castearCombinacionJugador(combinacionJugador7075);
	char[] combinacionCasteada7186 = modelo.castearCombinacionJugador(combinacionJugador7186);
	char[] combinacionCasteada7207 = modelo.castearCombinacionJugador(combinacionJugador7207);
	char[] combinacionCasteada7318 = modelo.castearCombinacionJugador(combinacionJugador7318);
	char[] combinacionCasteada7420 = modelo.castearCombinacionJugador(combinacionJugador7420);
	char[] combinacionCasteada7531 = modelo.castearCombinacionJugador(combinacionJugador7531);
	char[] combinacionCasteada7642 = modelo.castearCombinacionJugador(combinacionJugador7642);
	char[] combinacionCasteada8876 = modelo.castearCombinacionJugador(combinacionJugador8876);
	char[] combinacionCasteada8087 = modelo.castearCombinacionJugador(combinacionJugador8087);
	char[] combinacionCasteada8108 = modelo.castearCombinacionJugador(combinacionJugador8108);
	char[] combinacionCasteada8210 = modelo.castearCombinacionJugador(combinacionJugador8210);
	char[] combinacionCasteada8321 = modelo.castearCombinacionJugador(combinacionJugador8321);
	char[] combinacionCasteada8432 = modelo.castearCombinacionJugador(combinacionJugador8432);
	char[] combinacionCasteada8543 = modelo.castearCombinacionJugador(combinacionJugador8543);
	char[] combinacionCasteada8654 = modelo.castearCombinacionJugador(combinacionJugador8654);
	char[] combinacionCasteada8765 = modelo.castearCombinacionJugador(combinacionJugador8765);

	//////////////////////////////////////////////////////////////////////////////////////////////////////// Particiones
	//////////////////////////////////////////////////////////////////////////////////////////////////////// equivalentes
	//////////////////////////////////////////////////////////////////////////////////////////////////////// invalidas
	// if(X == 4)
	String combinacionJugadorNULL = ""; // Valor limite 0.
	String combinacionJugadorEspacio = " "; // Valor limite 1.
	String combinacionJugador0 = "0"; // Valor limite 1.
	String combinacionJugador00 = "00"; // Valor limite 2.
	String combinacionJugador000 = "000"; // Valor limite 3.
	String combinacionJugador00000 = "00000"; // Valor limite 5.
	String combinacionJugador50 = "00000000000000000000000000000000000000000000000000"; // Valor limite 50.

	// if((Y < '0') || (Y > '8'))
	String combinacionJugador4629 = "4629"; // Valor limite 9.
	String combinacionJugador9462 = "9462"; // Valor limite 9.
	String combinacionJugador4962 = "4962"; // Valor limite 9.
	String combinacionJugador4692 = "4692"; // Valor limite 9.
	String combinacionJugador12R3 = "12-3"; // Valor limite -
	String combinacionJugador12R34 = "12-34"; // Valor limite -

	// Ambos casos
	String combinacionJugador9 = "9"; // Valor limite 1 y valor limite 9.
	String combinacionJugador96 = "96"; // Valor limite 2 y valor limite 9.
	String combinacionJugador969 = "969"; // Valor limite 3 y valor limite 9.
	String combinacionJugador96999 = "96999"; // Valor limite 5 y valor limite 9.

	String combinacionJugador96250 = "96250"; // Valor limite 5 y valor limite 9.
	String combinacionJugador90462 = "90462"; // Valor limite 5 y valor limite 9.
	String combinacionJugador95062 = "95062"; // Valor limite 5 y valor limite 9.
	String combinacionJugador96502 = "96502"; // Valor limite 5 y valor limite 9.

	char[] entradaCasteada0 = modelo.castearCombinacionJugador(combinacionJugador0);
	char[] entradaCasteada00 = modelo.castearCombinacionJugador(combinacionJugador00);
	char[] entradaCasteadaNULL = modelo.castearCombinacionJugador(combinacionJugadorNULL);
	char[] entradaCasteadaEspacio = modelo.castearCombinacionJugador(combinacionJugadorEspacio);
	char[] entradaCasteada000 = modelo.castearCombinacionJugador(combinacionJugador000);
	char[] entradaCasteada00000 = modelo.castearCombinacionJugador(combinacionJugador00000);
	char[] entradaCasteada50 = modelo.castearCombinacionJugador(combinacionJugador50);

	char[] combinacionCasteada4629 = modelo.castearCombinacionJugador(combinacionJugador4629);
	char[] combinacionCasteada9462 = modelo.castearCombinacionJugador(combinacionJugador9462);
	char[] combinacionCasteada4962 = modelo.castearCombinacionJugador(combinacionJugador4962);
	char[] combinacionCasteada4692 = modelo.castearCombinacionJugador(combinacionJugador4692);
	char[] entradaCasteada12R3 = modelo.castearCombinacionJugador(combinacionJugador12R3);
	char[] entradaCasteada12R34 = modelo.castearCombinacionJugador(combinacionJugador12R34);

	char[] combinacionCasteada9 = modelo.castearCombinacionJugador(combinacionJugador9);
	char[] combinacionCasteada96 = modelo.castearCombinacionJugador(combinacionJugador96);
	char[] combinacionCasteada969 = modelo.castearCombinacionJugador(combinacionJugador969);
	char[] combinacionCasteada96999 = modelo.castearCombinacionJugador(combinacionJugador96999);

	char[] combinacionCasteada96250 = modelo.castearCombinacionJugador(combinacionJugador96250);
	char[] combinacionCasteada90462 = modelo.castearCombinacionJugador(combinacionJugador90462);
	char[] combinacionCasteada95062 = modelo.castearCombinacionJugador(combinacionJugador95062);
	char[] combinacionCasteada96502 = modelo.castearCombinacionJugador(combinacionJugador96502);

	char[] opcion0 = { '0' };
	char[] opcion1 = { '1' };
	char[] opcion2 = { '2' };
	char[] opcion3 = { '3' };
	char[] opcion4 = { '4' };
	char[] opcion5 = { '5' };
	char[] opcion6 = { '6' };
	char[] opcion7 = { '7' };
	char[] opcion8 = { '8' };
	char[] opcion9 = { '9' };
	char[] opciona = { 'a' };
	char[] opcionb = { 'b' };
	char[] opcionc = { 'c' };
	char[] opciond = { 'd' };
	char[] opcione = { 'e' };
	char[] opcionf = { 'f' };
	char[] opciong = { 'g' };
	char[] opcionh = { 'h' };
	char[] opcioni = { 'i' };
	char[] opcionj = { 'j' };
	char[] opcionk = { 'k' };
	char[] opcionl = { 'l' };
	char[] opcionm = { 'm' };
	char[] opcionn = { 'n' };
	char[] opciono = { 'o' };
	char[] opcionp = { 'p' };
	char[] opcionq = { 'q' };
	char[] opcionr = { 'r' };
	char[] opcions = { 's' };
	char[] opciont = { 't' };
	char[] opcionu = { 'u' };
	char[] opcionv = { 'v' };
	char[] opcionw = { 'w' };
	char[] opcionx = { 'x' };
	char[] opciony = { 'y' };
	char[] opcionz = { 'z' };
	char[] opcionA = { 'A' };
	char[] opcionB = { 'B' };
	char[] opcionC = { 'C' };
	char[] opcionD = { 'D' };
	char[] opcionE = { 'E' };
	char[] opcionF = { 'F' };
	char[] opcionG = { 'G' };
	char[] opcionH = { 'H' };
	char[] opcionI = { 'I' };
	char[] opcionJ = { 'J' };
	char[] opcionK = { 'K' };
	char[] opcionL = { 'L' };
	char[] opcionM = { 'M' };
	char[] opcionN = { 'N' };
	char[] opcionO = { 'O' };
	char[] opcionP = { 'P' };
	char[] opcionQ = { 'Q' };
	char[] opcionR = { 'R' };
	char[] opcionS = { 'S' };
	char[] opcionT = { 'T' };
	char[] opcionU = { 'U' };
	char[] opcionV = { 'V' };
	char[] opcionW = { 'W' };
	char[] opcionX = { 'X' };
	char[] opcionY = { 'Y' };
	char[] opcionZ = { 'Z' };
	char[] opcionBarra = { '/' };
	char[] opcionResta = { '-' };
	char[] opcionAsterisco = { '*' };
	char[] opcionMas = { '+' };
	char[] opcionGorro = { '^' };
	char[] opcioContraBarra = { '\\' };
	char[] opcionEx1 = { '!' };
	char[] opcionPipe = { '|' };
	char[] opcionArroba = { '@' };
	char[] opciobCorchete = { '#' };
	char[] opcionDolar = { '$' };
	char[] opcionEspana = { '~' };
	char[] opcioXCiento = { '%' };
	char[] opcionAnd = { '&' };
	char[] opcionSlash = { '/' };
	char[] opcionParentesis1 = { '(' };
	char[] opcionParentesis2 = { ')' };
	char[] opcionIgual = { '=' };
	char[] opcionInterrogante1 = { '?' };
	char[] opcioComilla = { '\'' };
	char[] opcion1234 = { '1', '2', '3', '4' };
	char[] opcion2314 = { '2', '3', '1', '4' };

	/**
	 * Comprueba que solamente es correcto introducir los valores 1 o 2 en el metodo
	 * ObtenerOpcionMenu.
	 */
	@Test
	public void testMockObtenerOpcionMenu() {
		Modelo modelo = new Modelo();
		ArrayList<String> vectorSuposiciones = new ArrayList<String>();

		vectorSuposiciones.add("0");
		vectorSuposiciones.add("1");
		vectorSuposiciones.add("2");
		vectorSuposiciones.add("3");
		vectorSuposiciones.add("4");
		vectorSuposiciones.add("5");
		vectorSuposiciones.add("6");
		vectorSuposiciones.add("7");
		vectorSuposiciones.add("8");
		vectorSuposiciones.add("9");
		vectorSuposiciones.add("a");
		vectorSuposiciones.add("b");
		vectorSuposiciones.add("c");
		vectorSuposiciones.add("d");
		vectorSuposiciones.add("e");
		vectorSuposiciones.add("f");
		vectorSuposiciones.add("g");
		vectorSuposiciones.add("h");
		vectorSuposiciones.add("i");
		vectorSuposiciones.add("j");
		vectorSuposiciones.add("k");
		vectorSuposiciones.add("l");
		vectorSuposiciones.add("m");
		vectorSuposiciones.add("n");
		vectorSuposiciones.add("o");
		vectorSuposiciones.add("p");
		vectorSuposiciones.add("q");
		vectorSuposiciones.add("r");
		vectorSuposiciones.add("s");
		vectorSuposiciones.add("t");
		vectorSuposiciones.add("u");
		vectorSuposiciones.add("v");
		vectorSuposiciones.add("w");
		vectorSuposiciones.add("x");
		vectorSuposiciones.add("y");
		vectorSuposiciones.add("z");
		vectorSuposiciones.add("A");
		vectorSuposiciones.add("B");
		vectorSuposiciones.add("C");
		vectorSuposiciones.add("D");
		vectorSuposiciones.add("E");
		vectorSuposiciones.add("F");
		vectorSuposiciones.add("G");
		vectorSuposiciones.add("H");
		vectorSuposiciones.add("I");
		vectorSuposiciones.add("J");
		vectorSuposiciones.add("K");
		vectorSuposiciones.add("L");
		vectorSuposiciones.add("M");
		vectorSuposiciones.add("N");
		vectorSuposiciones.add("O");
		vectorSuposiciones.add("P");
		vectorSuposiciones.add("Q");
		vectorSuposiciones.add("R");
		vectorSuposiciones.add("S");
		vectorSuposiciones.add("T");
		vectorSuposiciones.add("U");
		vectorSuposiciones.add("V");
		vectorSuposiciones.add("W");
		vectorSuposiciones.add("X");
		vectorSuposiciones.add("Y");
		vectorSuposiciones.add("Z");
		vectorSuposiciones.add("/");
		vectorSuposiciones.add("-");
		vectorSuposiciones.add("*");
		vectorSuposiciones.add("+");
		vectorSuposiciones.add("^");
		vectorSuposiciones.add("\\");
		vectorSuposiciones.add("!");
		vectorSuposiciones.add("|");
		vectorSuposiciones.add("\"");
		vectorSuposiciones.add("@");
		vectorSuposiciones.add("#");
		vectorSuposiciones.add("$");
		vectorSuposiciones.add("~");
		vectorSuposiciones.add("%");
		vectorSuposiciones.add("&");
		vectorSuposiciones.add("/");
		vectorSuposiciones.add("(");
		vectorSuposiciones.add(")");
		vectorSuposiciones.add("=");
		vectorSuposiciones.add("?");
		vectorSuposiciones.add("'");

		InterfazEscaner interfazEscaner = new MockEscaner(vectorSuposiciones);

		for (int i = 0; i < vectorSuposiciones.size(); i++) {
			String opcion = modelo.obtenerOpcionMenu(interfazEscaner);
			char[] optCasteada = modelo.castearOpcionMenu(opcion);

			if (modelo.validarOpcionMenu(optCasteada)) {
				//System.out.println("True: " + Arrays.toString(optCasteada));
				assertTrue(modelo.validarOpcionMenu(optCasteada));
			} else {
				//System.out.println("False: " + Arrays.toString(optCasteada));
				assertFalse(modelo.validarOpcionMenu(optCasteada));
			}
		}
	}

	/**
	 * 
	 */
	@Test
	public void testMockObtenerEntradaJugador() {
		Modelo modelo = new Modelo();
		ArrayList<String> vectorSuposiciones = new ArrayList<String>();

		vectorSuposiciones.add("1000");
		vectorSuposiciones.add("2000");
		vectorSuposiciones.add("3000");
		vectorSuposiciones.add("4000");
		vectorSuposiciones.add("1239");

		vectorSuposiciones.add(combinacionJugador0000);
		vectorSuposiciones.add(combinacionJugador0111);
		vectorSuposiciones.add(combinacionJugador0222);
		vectorSuposiciones.add(combinacionJugador0333);
		vectorSuposiciones.add(combinacionJugador0444);
		vectorSuposiciones.add(combinacionJugador0555);
		vectorSuposiciones.add(combinacionJugador0666);
		vectorSuposiciones.add(combinacionJugador0777);
		vectorSuposiciones.add(combinacionJugador0888);
		vectorSuposiciones.add(combinacionJugador1123);
		vectorSuposiciones.add(combinacionJugador1234);
		vectorSuposiciones.add(combinacionJugador1345);
		vectorSuposiciones.add(combinacionJugador1456);
		vectorSuposiciones.add(combinacionJugador1567);
		vectorSuposiciones.add(combinacionJugador1678);
		vectorSuposiciones.add(combinacionJugador1780);
		vectorSuposiciones.add(combinacionJugador1801);
		vectorSuposiciones.add(combinacionJugador1012);
		vectorSuposiciones.add(combinacionJugador2246);
		vectorSuposiciones.add(combinacionJugador2357);
		vectorSuposiciones.add(combinacionJugador2468);
		vectorSuposiciones.add(combinacionJugador2570);
		vectorSuposiciones.add(combinacionJugador2681);
		vectorSuposiciones.add(combinacionJugador2702);
		vectorSuposiciones.add(combinacionJugador2813);
		vectorSuposiciones.add(combinacionJugador2024);
		vectorSuposiciones.add(combinacionJugador2135);
		vectorSuposiciones.add(combinacionJugador3360);
		vectorSuposiciones.add(combinacionJugador3471);
		vectorSuposiciones.add(combinacionJugador3582);
		vectorSuposiciones.add(combinacionJugador3603);
		vectorSuposiciones.add(combinacionJugador3714);
		vectorSuposiciones.add(combinacionJugador3825);
		vectorSuposiciones.add(combinacionJugador3036);
		vectorSuposiciones.add(combinacionJugador3147);
		vectorSuposiciones.add(combinacionJugador3258);
		vectorSuposiciones.add(combinacionJugador4483);
		vectorSuposiciones.add(combinacionJugador4504);
		vectorSuposiciones.add(combinacionJugador4615);
		vectorSuposiciones.add(combinacionJugador4726);
		vectorSuposiciones.add(combinacionJugador4837);
		vectorSuposiciones.add(combinacionJugador4048);
		vectorSuposiciones.add(combinacionJugador4150);
		vectorSuposiciones.add(combinacionJugador4261);
		vectorSuposiciones.add(combinacionJugador4372);
		vectorSuposiciones.add(combinacionJugador5516);
		vectorSuposiciones.add(combinacionJugador5627);
		vectorSuposiciones.add(combinacionJugador5738);
		vectorSuposiciones.add(combinacionJugador5840);
		vectorSuposiciones.add(combinacionJugador5051);
		vectorSuposiciones.add(combinacionJugador5162);
		vectorSuposiciones.add(combinacionJugador5273);
		vectorSuposiciones.add(combinacionJugador5384);
		vectorSuposiciones.add(combinacionJugador5405);
		vectorSuposiciones.add(combinacionJugador6630);
		vectorSuposiciones.add(combinacionJugador6741);
		vectorSuposiciones.add(combinacionJugador6852);
		vectorSuposiciones.add(combinacionJugador6063);
		vectorSuposiciones.add(combinacionJugador6174);
		vectorSuposiciones.add(combinacionJugador6285);
		vectorSuposiciones.add(combinacionJugador6306);
		vectorSuposiciones.add(combinacionJugador6417);
		vectorSuposiciones.add(combinacionJugador6528);
		vectorSuposiciones.add(combinacionJugador7753);
		vectorSuposiciones.add(combinacionJugador7864);
		vectorSuposiciones.add(combinacionJugador7075);
		vectorSuposiciones.add(combinacionJugador7186);
		vectorSuposiciones.add(combinacionJugador7207);
		vectorSuposiciones.add(combinacionJugador7318);
		vectorSuposiciones.add(combinacionJugador7420);
		vectorSuposiciones.add(combinacionJugador7531);
		vectorSuposiciones.add(combinacionJugador7642);
		vectorSuposiciones.add(combinacionJugador8876);
		vectorSuposiciones.add(combinacionJugador8087);
		vectorSuposiciones.add(combinacionJugador8108);
		vectorSuposiciones.add(combinacionJugador8210);
		vectorSuposiciones.add(combinacionJugador8321);
		vectorSuposiciones.add(combinacionJugador8432);
		vectorSuposiciones.add(combinacionJugador8543);
		vectorSuposiciones.add(combinacionJugador8654);
		vectorSuposiciones.add(combinacionJugador8765);

		vectorSuposiciones.add("0000"); // Valores frontera 0.
		vectorSuposiciones.add("8888"); // Valores frontera 8.
		vectorSuposiciones.add("0628"); // Valores frontera 0 y 8.
		vectorSuposiciones.add("8462"); // Valor frontera 8.
		vectorSuposiciones.add("4860"); // Valores frontera 0 y 8.
		vectorSuposiciones.add("4602"); // Valor frontera 0.
		vectorSuposiciones.add("4127"); // Valores limite 1 y 7.
		vectorSuposiciones.add("7461"); // Valores limite 1 y 7.
		vectorSuposiciones.add("4712"); // Valores limite 1 y 7.
		vectorSuposiciones.add("1672"); // Valores limite 1 y 7.

		vectorSuposiciones.add(""); // Valor limite)
		vectorSuposiciones.add(" "); // Valor limite 1.
		vectorSuposiciones.add("0"); // Valor limite 1.
		vectorSuposiciones.add("00"); // Valor limite 2.
		vectorSuposiciones.add("000"); // Valor limite 3.
		vectorSuposiciones.add("00000"); // Valor limite 5.
		vectorSuposiciones.add("00000000000000000000000000000000000000000000000000"); // Valor limite 50.

		vectorSuposiciones.add("4629"); // Valor limite 9.
		vectorSuposiciones.add("9462"); // Valor limite 9.
		vectorSuposiciones.add("4962"); // Valor limite 9.
		vectorSuposiciones.add("4692"); // Valor limite 9.
		vectorSuposiciones.add("12-3"); // Valor limite -
		vectorSuposiciones.add("12-34"); // Valor limite -

		vectorSuposiciones.add("9"); // Valor limite 1 y valor limite 9.
		vectorSuposiciones.add("96"); // Valor limite 2 y valor limite 9.
		vectorSuposiciones.add("969"); // Valor limite 3 y valor limite 9.
		vectorSuposiciones.add("96999"); // Valor limite 5 y valor limite 9.
		vectorSuposiciones.add("96250"); // Valor limite 5 y valor limite 9.
		vectorSuposiciones.add("90462"); // Valor limite 5 y valor limite 9.
		vectorSuposiciones.add("95062"); // Valor limite 5 y valor limite 9.
		vectorSuposiciones.add("96502"); // Valor limite 5 y valor limite 9.

		InterfazEscaner interfazEscaner = new MockEscaner(vectorSuposiciones);

		for (int i = 0; i < vectorSuposiciones.size(); i++) {

			String opcion = modelo.obtenerCombinacionJugador(interfazEscaner);
			char[] optCasteada = modelo.castearCombinacionJugador(opcion);

			if (modelo.validarCombinacionJugador(optCasteada)) {
				//System.out.println("True: " + Arrays.toString(optCasteada));
				assertTrue(modelo.validarCombinacionJugador(optCasteada));

			} else {
				//System.out.println("False: " + Arrays.toString(optCasteada));
				assertFalse(modelo.validarCombinacionJugador(optCasteada));

			}
		}

	}

	/**
	 * Test caja negra de castearEntradaJugador. R -> Simbolo de restar (-). A ->
	 * Simbolo asterisco (*).
	 */
	@Test
	public void testCastearEntradaJugadorPairWise() {

		/**
		 * 
		 * Pair-wise testing de numeros y simbolos Char numerico | Char simbolo |Char
		 * numerico | Char simbolo Char simbolo | Char numerico | Char simbolo | Char
		 * numerico
		 * 
		 * R -> Simbolo de restar (-). A -> Simbolo asterisco (*).
		 * 
		 */
		String combinacionJugador0R0A = "0-0*";
		char[] combinacionCasteadaEsperada0R0A = { '0', '-', '0', '*' };
		char[] combinacionCasteada0R0A = modelo.castearCombinacionJugador(combinacionJugador0R0A);
		assertArrayEquals(combinacionCasteadaEsperada0R0A, combinacionCasteada0R0A);

		String combinacionJugadorR2A8 = "-2*8";
		char[] combinacionCasteadaEsperadaR2A8 = { '-', '2', '*', '8' };
		char[] combinacionCasteadaR2A8 = modelo.castearCombinacionJugador(combinacionJugadorR2A8);
		assertArrayEquals(combinacionCasteadaEsperadaR2A8, combinacionCasteadaR2A8);

		char[] combinacionEsperada0000 = { '0', '0', '0', '0' };
		char[] combinacionEsperada0111 = { '0', '1', '1', '1' };
		char[] combinacionEsperada0222 = { '0', '2', '2', '2' };
		char[] combinacionEsperada0333 = { '0', '3', '3', '3' };
		char[] combinacionEsperada0444 = { '0', '4', '4', '4' };
		char[] combinacionEsperada0555 = { '0', '5', '5', '5' };
		char[] combinacionEsperada0666 = { '0', '6', '6', '6' };
		char[] combinacionEsperada0777 = { '0', '7', '7', '7' };
		char[] combinacionEsperada0888 = { '0', '8', '8', '8' };
		char[] combinacionEsperada1123 = { '1', '1', '2', '3' };
		char[] combinacionEsperada1234 = { '1', '2', '3', '4' };
		char[] combinacionEsperada1345 = { '1', '3', '4', '5' };
		char[] combinacionEsperada1456 = { '1', '4', '5', '6' };
		char[] combinacionEsperada1567 = { '1', '5', '6', '7' };
		char[] combinacionEsperada1678 = { '1', '6', '7', '8' };
		char[] combinacionEsperada1780 = { '1', '7', '8', '0' };
		char[] combinacionEsperada1801 = { '1', '8', '0', '1' };
		char[] combinacionEsperada1012 = { '1', '0', '1', '2' };
		char[] combinacionEsperada2246 = { '2', '2', '4', '6' };
		char[] combinacionEsperada2357 = { '2', '3', '5', '7' };
		char[] combinacionEsperada2468 = { '2', '4', '6', '8' };
		char[] combinacionEsperada2570 = { '2', '5', '7', '0' };
		char[] combinacionEsperada2681 = { '2', '6', '8', '1' };
		char[] combinacionEsperada2702 = { '2', '7', '0', '2' };
		char[] combinacionEsperada2813 = { '2', '8', '1', '3' };
		char[] combinacionEsperada2024 = { '2', '0', '2', '4' };
		char[] combinacionEsperada2135 = { '2', '1', '3', '5' };
		char[] combinacionEsperada3360 = { '3', '3', '6', '0' };
		char[] combinacionEsperada3471 = { '3', '4', '7', '1' };
		char[] combinacionEsperada3582 = { '3', '5', '8', '2' };
		char[] combinacionEsperada3603 = { '3', '6', '0', '3' };
		char[] combinacionEsperada3714 = { '3', '7', '1', '4' };
		char[] combinacionEsperada3825 = { '3', '8', '2', '5' };
		char[] combinacionEsperada3036 = { '3', '0', '3', '6' };
		char[] combinacionEsperada3147 = { '3', '1', '4', '7' };
		char[] combinacionEsperada3258 = { '3', '2', '5', '8' };
		char[] combinacionEsperada4483 = { '4', '4', '8', '3' };
		char[] combinacionEsperada4504 = { '4', '5', '0', '4' };
		char[] combinacionEsperada4615 = { '4', '6', '1', '5' };
		char[] combinacionEsperada4726 = { '4', '7', '2', '6' };
		char[] combinacionEsperada4837 = { '4', '8', '3', '7' };
		char[] combinacionEsperada4048 = { '4', '0', '4', '8' };
		char[] combinacionEsperada4150 = { '4', '1', '5', '0' };
		char[] combinacionEsperada4261 = { '4', '2', '6', '1' };
		char[] combinacionEsperada4372 = { '4', '3', '7', '2' };
		char[] combinacionEsperada5516 = { '5', '5', '1', '6' };
		char[] combinacionEsperada5627 = { '5', '6', '2', '7' };
		char[] combinacionEsperada5738 = { '5', '7', '3', '8' };
		char[] combinacionEsperada5840 = { '5', '8', '4', '0' };
		char[] combinacionEsperada5051 = { '5', '0', '5', '1' };
		char[] combinacionEsperada5162 = { '5', '1', '6', '2' };
		char[] combinacionEsperada5273 = { '5', '2', '7', '3' };
		char[] combinacionEsperada5384 = { '5', '3', '8', '4' };
		char[] combinacionEsperada5405 = { '5', '4', '0', '5' };
		char[] combinacionEsperada6630 = { '6', '6', '3', '0' };
		char[] combinacionEsperada6741 = { '6', '7', '4', '1' };
		char[] combinacionEsperada6852 = { '6', '8', '5', '2' };
		char[] combinacionEsperada6063 = { '6', '0', '6', '3' };
		char[] combinacionEsperada6174 = { '6', '1', '7', '4' };
		char[] combinacionEsperada6285 = { '6', '2', '8', '5' };
		char[] combinacionEsperada6306 = { '6', '3', '0', '6' };
		char[] combinacionEsperada6417 = { '6', '4', '1', '7' };
		char[] combinacionEsperada6528 = { '6', '5', '2', '8' };
		char[] combinacionEsperada7753 = { '7', '7', '5', '3' };
		char[] combinacionEsperada7864 = { '7', '8', '6', '4' };
		char[] combinacionEsperada7075 = { '7', '0', '7', '5' };
		char[] combinacionEsperada7186 = { '7', '1', '8', '6' };
		char[] combinacionEsperada7207 = { '7', '2', '0', '7' };
		char[] combinacionEsperada7318 = { '7', '3', '1', '8' };
		char[] combinacionEsperada7420 = { '7', '4', '2', '0' };
		char[] combinacionEsperada7531 = { '7', '5', '3', '1' };
		char[] combinacionEsperada7642 = { '7', '6', '4', '2' };
		char[] combinacionEsperada8876 = { '8', '8', '7', '6' };
		char[] combinacionEsperada8087 = { '8', '0', '8', '7' };
		char[] combinacionEsperada8108 = { '8', '1', '0', '8' };
		char[] combinacionEsperada8210 = { '8', '2', '1', '0' };
		char[] combinacionEsperada8321 = { '8', '3', '2', '1' };
		char[] combinacionEsperada8432 = { '8', '4', '3', '2' };
		char[] combinacionEsperada8543 = { '8', '5', '4', '3' };
		char[] combinacionEsperada8654 = { '8', '6', '5', '4' };
		char[] combinacionEsperada8765 = { '8', '7', '6', '5' };

		assertArrayEquals(combinacionEsperada0000, combinacionCasteada0000);
		assertArrayEquals(combinacionEsperada0111, combinacionCasteada0111);
		assertArrayEquals(combinacionEsperada0222, combinacionCasteada0222);
		assertArrayEquals(combinacionEsperada0333, combinacionCasteada0333);
		assertArrayEquals(combinacionEsperada0444, combinacionCasteada0444);
		assertArrayEquals(combinacionEsperada0555, combinacionCasteada0555);
		assertArrayEquals(combinacionEsperada0666, combinacionCasteada0666);
		assertArrayEquals(combinacionEsperada0777, combinacionCasteada0777);
		assertArrayEquals(combinacionEsperada0888, combinacionCasteada0888);
		assertArrayEquals(combinacionEsperada1123, combinacionCasteada1123);
		assertArrayEquals(combinacionEsperada1234, combinacionCasteada1234);
		assertArrayEquals(combinacionEsperada1345, combinacionCasteada1345);
		assertArrayEquals(combinacionEsperada1456, combinacionCasteada1456);
		assertArrayEquals(combinacionEsperada1567, combinacionCasteada1567);
		assertArrayEquals(combinacionEsperada1678, combinacionCasteada1678);
		assertArrayEquals(combinacionEsperada1780, combinacionCasteada1780);
		assertArrayEquals(combinacionEsperada1801, combinacionCasteada1801);
		assertArrayEquals(combinacionEsperada1012, combinacionCasteada1012);
		assertArrayEquals(combinacionEsperada2246, combinacionCasteada2246);
		assertArrayEquals(combinacionEsperada2357, combinacionCasteada2357);
		assertArrayEquals(combinacionEsperada2468, combinacionCasteada2468);
		assertArrayEquals(combinacionEsperada2570, combinacionCasteada2570);
		assertArrayEquals(combinacionEsperada2681, combinacionCasteada2681);
		assertArrayEquals(combinacionEsperada2702, combinacionCasteada2702);
		assertArrayEquals(combinacionEsperada2813, combinacionCasteada2813);
		assertArrayEquals(combinacionEsperada2024, combinacionCasteada2024);
		assertArrayEquals(combinacionEsperada2135, combinacionCasteada2135);
		assertArrayEquals(combinacionEsperada3360, combinacionCasteada3360);
		assertArrayEquals(combinacionEsperada3471, combinacionCasteada3471);
		assertArrayEquals(combinacionEsperada3582, combinacionCasteada3582);
		assertArrayEquals(combinacionEsperada3603, combinacionCasteada3603);
		assertArrayEquals(combinacionEsperada3714, combinacionCasteada3714);
		assertArrayEquals(combinacionEsperada3825, combinacionCasteada3825);
		assertArrayEquals(combinacionEsperada3036, combinacionCasteada3036);
		assertArrayEquals(combinacionEsperada3147, combinacionCasteada3147);
		assertArrayEquals(combinacionEsperada3258, combinacionCasteada3258);
		assertArrayEquals(combinacionEsperada4483, combinacionCasteada4483);
		assertArrayEquals(combinacionEsperada4504, combinacionCasteada4504);
		assertArrayEquals(combinacionEsperada4615, combinacionCasteada4615);
		assertArrayEquals(combinacionEsperada4726, combinacionCasteada4726);
		assertArrayEquals(combinacionEsperada4837, combinacionCasteada4837);
		assertArrayEquals(combinacionEsperada4048, combinacionCasteada4048);
		assertArrayEquals(combinacionEsperada4150, combinacionCasteada4150);
		assertArrayEquals(combinacionEsperada4261, combinacionCasteada4261);
		assertArrayEquals(combinacionEsperada4372, combinacionCasteada4372);
		assertArrayEquals(combinacionEsperada5516, combinacionCasteada5516);
		assertArrayEquals(combinacionEsperada5627, combinacionCasteada5627);
		assertArrayEquals(combinacionEsperada5738, combinacionCasteada5738);
		assertArrayEquals(combinacionEsperada5840, combinacionCasteada5840);
		assertArrayEquals(combinacionEsperada5051, combinacionCasteada5051);
		assertArrayEquals(combinacionEsperada5162, combinacionCasteada5162);
		assertArrayEquals(combinacionEsperada5273, combinacionCasteada5273);
		assertArrayEquals(combinacionEsperada5384, combinacionCasteada5384);
		assertArrayEquals(combinacionEsperada5405, combinacionCasteada5405);
		assertArrayEquals(combinacionEsperada6630, combinacionCasteada6630);
		assertArrayEquals(combinacionEsperada6741, combinacionCasteada6741);
		assertArrayEquals(combinacionEsperada6852, combinacionCasteada6852);
		assertArrayEquals(combinacionEsperada6063, combinacionCasteada6063);
		assertArrayEquals(combinacionEsperada6174, combinacionCasteada6174);
		assertArrayEquals(combinacionEsperada6285, combinacionCasteada6285);
		assertArrayEquals(combinacionEsperada6306, combinacionCasteada6306);
		assertArrayEquals(combinacionEsperada6417, combinacionCasteada6417);
		assertArrayEquals(combinacionEsperada6528, combinacionCasteada6528);
		assertArrayEquals(combinacionEsperada7753, combinacionCasteada7753);
		assertArrayEquals(combinacionEsperada7864, combinacionCasteada7864);
		assertArrayEquals(combinacionEsperada7075, combinacionCasteada7075);
		assertArrayEquals(combinacionEsperada7186, combinacionCasteada7186);
		assertArrayEquals(combinacionEsperada7207, combinacionCasteada7207);
		assertArrayEquals(combinacionEsperada7318, combinacionCasteada7318);
		assertArrayEquals(combinacionEsperada7420, combinacionCasteada7420);
		assertArrayEquals(combinacionEsperada7531, combinacionCasteada7531);
		assertArrayEquals(combinacionEsperada7642, combinacionCasteada7642);
		assertArrayEquals(combinacionEsperada8876, combinacionCasteada8876);
		assertArrayEquals(combinacionEsperada8087, combinacionCasteada8087);
		assertArrayEquals(combinacionEsperada8108, combinacionCasteada8108);
		assertArrayEquals(combinacionEsperada8210, combinacionCasteada8210);
		assertArrayEquals(combinacionEsperada8321, combinacionCasteada8321);
		assertArrayEquals(combinacionEsperada8432, combinacionCasteada8432);
		assertArrayEquals(combinacionEsperada8543, combinacionCasteada8543);
		assertArrayEquals(combinacionEsperada8654, combinacionCasteada8654);
		assertArrayEquals(combinacionEsperada8765, combinacionCasteada8765);
	}

	/**
	 * Comprueba los valores interiores, limite y frontera ademas de las particiones
	 * equivalentes.
	 */
	@Test
	public void validarCombinacionJugador() {

		//////////////////////////////////////////////////////////////////////////////////////////////////////// Particiones
		//////////////////////////////////////////////////////////////////////////////////////////////////////// equivalentes
		//////////////////////////////////////////////////////////////////////////////////////////////////////// validas.
		assertTrue(modelo.validarCombinacionJugador(entradaCasteada8888));

		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada4127));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada7461));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada4712));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada1672));

		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada0628));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada8462));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada4860));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada4602));

		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada0000));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada0111));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada0222));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada0333));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada0444));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada0555));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada0666));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada0777));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada0888));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada1123));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada1234));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada1345));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada1456));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada1567));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada1678));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada1780));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada1801));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada1012));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada2246));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada2357));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada2468));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada2570));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada2681));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada2702));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada2813));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada2024));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada2135));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada3360));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada3471));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada3582));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada3603));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada3714));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada3825));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada3036));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada3147));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada3258));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada4483));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada4504));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada4615));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada4726));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada4837));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada4048));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada4150));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada4261));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada4372));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada5516));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada5627));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada5738));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada5840));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada5051));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada5162));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada5273));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada5384));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada5405));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada6630));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada6741));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada6852));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada6063));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada6174));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada6285));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada6306));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada6417));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada6528));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada7753));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada7864));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada7075));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada7186));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada7207));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada7318));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada7420));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada7531));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada7642));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada8876));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada8087));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada8108));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada8210));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada8321));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada8432));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada8543));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada8654));
		assertTrue(modelo.validarCombinacionJugador(combinacionCasteada8765));

		//////////////////////////////////////////////////////////////////////////////////////////////////////// Particiones
		//////////////////////////////////////////////////////////////////////////////////////////////////////// equivalentes
		//////////////////////////////////////////////////////////////////////////////////////////////////////// invalidas
		// if(X == 4)
		assertFalse(modelo.validarCombinacionJugador(entradaCasteada0));
		assertFalse(modelo.validarCombinacionJugador(entradaCasteada00));
		assertFalse(modelo.validarCombinacionJugador(entradaCasteada000));
		assertFalse(modelo.validarCombinacionJugador(entradaCasteada00000));
		assertFalse(modelo.validarCombinacionJugador(entradaCasteadaNULL));
		assertFalse(modelo.validarCombinacionJugador(entradaCasteadaEspacio));
		assertFalse(modelo.validarCombinacionJugador(entradaCasteada50));

		// if((Y < '0') || (Y > '8'))
		assertFalse(modelo.validarCombinacionJugador(entradaCasteada12R3));
		assertFalse(modelo.validarCombinacionJugador(entradaCasteada12R34));
		assertFalse(modelo.validarCombinacionJugador(combinacionCasteada4629));
		assertFalse(modelo.validarCombinacionJugador(combinacionCasteada9462));
		assertFalse(modelo.validarCombinacionJugador(combinacionCasteada4962));
		assertFalse(modelo.validarCombinacionJugador(combinacionCasteada4692));

		// Ambos casos
		assertFalse(modelo.validarCombinacionJugador(combinacionCasteada9));
		assertFalse(modelo.validarCombinacionJugador(combinacionCasteada96));
		assertFalse(modelo.validarCombinacionJugador(combinacionCasteada969));
		assertFalse(modelo.validarCombinacionJugador(combinacionCasteada96999));

		assertFalse(modelo.validarCombinacionJugador(combinacionCasteada96250));
		assertFalse(modelo.validarCombinacionJugador(combinacionCasteada90462));
		assertFalse(modelo.validarCombinacionJugador(combinacionCasteada95062));
		assertFalse(modelo.validarCombinacionJugador(combinacionCasteada96502));
	}

	/**
	 * Comprueba el correcto funcionamiento de la funcion generarCombinacionSecreta,
	 * verificando si realmente no se repite ningun numero dentro de la combinacion
	 * secreta.
	 */
	//@Test
	/*public void testValidarCombinacionSecreta1() {
		
		///////////////////////////////////////////////////////////////////////////////////// Particion
		///////////////////////////////////////////////////////////////////////////////////// equivalente
		///////////////////////////////////////////////////////////////////////////////////// valida.
		ArrayList<String> vectorSuposicionesAleatorio = new ArrayList<String>();
		vectorSuposicionesAleatorio.add("6548");
		InterfazAleatorio interfazAleatorio = new MockAleatorio(vectorSuposicionesAleatorio);
		
		char[] suposicionAleatoria = Modelo.generarCombinacionSecreta(interfazAleatorio);
		
		// if(X[i] != X[j])
		char[] combinacionSecretaCasteada0123 = { '0', '1', '2', '3' };
		char[] combinacionSecretaCasteada3210 = { '3', '2', '1', '0' };
		char[] combinacionSecretaCasteada5678 = { '5', '6', '7', '8' };
		char[] combinacionSecretaCasteada8765 = { '8', '7', '6', '5' };
		char[] combinacionSecretaCasteada1357 = { '1', '3', '5', '7' };
		char[] combinacionSecretaCasteada6548 = { '6', '5', '4', '8' };

		assertArrayEquals(suposicionAleatoria, combinacionSecretaCasteada0123);
		assertArrayEquals(suposicionAleatoria, combinacionSecretaCasteada3210);
		assertArrayEquals(suposicionAleatoria, combinacionSecretaCasteada5678);
		assertArrayEquals(suposicionAleatoria, combinacionSecretaCasteada8765);
		assertArrayEquals(suposicionAleatoria, combinacionSecretaCasteada1357);
		assertArrayEquals(suposicionAleatoria, combinacionSecretaCasteada6548);

		
		ArrayList<String> vectorSuposicionesJugador = new ArrayList<String>();
		vectorSuposiciones.add(e);
		
		assertArrayEquals(); 
		modelo.generarCombinacionSecreta(interfazAleatorio);

		///////////////////////////////////////////////////////////////////////////////////// Particion
		///////////////////////////////////////////////////////////////////////////////////// equivalente
		///////////////////////////////////////////////////////////////////////////////////// invalida.
		// if(X[i] == X[j])
		char[] combinacionSecretaCasteada0113 = { '0', '1', '1', '3' }; // 1==1.
		char[] combinacionSecretaCasteada3320 = { '3', '3', '2', '0' }; // 3==3.
		char[] combinacionSecretaCasteada5668 = { '5', '6', '6', '8' }; // 6==6.
		char[] combinacionSecretaCasteada8755 = { '8', '7', '5', '5' }; // 5==5.
		char[] combinacionSecretaCasteada0083 = { '0', '0', '8', '3' }; // 0==0.
		char[] combinacionSecretaCasteada8428 = { '8', '4', '2', '8' }; // 8==8.
		char[] combinacionSecretaCasteadaM428 = { '+', '4', '2', '8' }; // 8==8.

		assertTrue(modelo.validarCombinacionSecreta(combinacionSecretaCasteada0113));
		assertTrue(modelo.validarCombinacionSecreta(combinacionSecretaCasteada3320));
		assertTrue(modelo.validarCombinacionSecreta(combinacionSecretaCasteada5668));
		assertTrue(modelo.validarCombinacionSecreta(combinacionSecretaCasteada8755));
		assertTrue(modelo.validarCombinacionSecreta(combinacionSecretaCasteada0083));
		assertTrue(modelo.validarCombinacionSecreta(combinacionSecretaCasteada8428));
		assertFalse(modelo.validarCombinacionSecreta(combinacionSecretaCasteadaM428));
	}*/

	/**
	 * --------------- Test del metodo compararCombinaciones ---------------
	 * Comprueba que en funcion secreta y una combinacion del jugador simuladas
	 * devuelva el array de aciertos que se espera.
	 */
	@Test
	public void testCompararCombinaciones() {
		//////////////////////////////////////////////////////////////////////////////////////////////////////// Particiones
		//////////////////////////////////////////////////////////////////////////////////////////////////////// equivalentes
		//////////////////////////////////////////////////////////////////////////////////////////////////////// validas
		//////////////////////////////////////////////////////////////////////////////////////////////////////// (no
		//////////////////////////////////////////////////////////////////////////////////////////////////////// hay
		//////////////////////////////////////////////////////////////////////////////////////////////////////// invalidas)
		char[] combinacionSecreta2357 = { '2', '3', '5', '7' };
		char[] combinacionJugador2357 = { '2', '3', '5', '7' };
		char[] aciertosComparativa2357X2357 = Modelo.compararCombinaciones(combinacionSecreta2357,
				combinacionJugador2357);
		char[] aciertosEsperadosNNNN = { 'N', 'N', 'N', 'N' };

		char[] combinacionSecreta2367 = { '2', '3', '6', '7' };
		char[] combinacionJugador3276 = { '3', '2', '7', '6' };
		char[] aciertosComparativa2367X3276 = Modelo.compararCombinaciones(combinacionSecreta2367,
				combinacionJugador3276);
		char[] aciertosEsperadosBBBB = { 'B', 'B', 'B', 'B' };

		char[] combinacionSecreta2356 = { '2', '3', '5', '6' };
		char[] combinacionJugador1234 = { '1', '2', '3', '4' };
		char[] aciertosComparativa2356X1234 = Modelo.compararCombinaciones(combinacionSecreta2356,
				combinacionJugador1234);
		char[] aciertosEsperados0BB0 = { '0', 'B', 'B', '0' };

		char[] combinacionSecreta8740 = { '8', '7', '4', '0' };
		char[] combinacionJugador1235 = { '1', '2', '3', '5' };
		char[] aciertosComparativa8740X1235 = Modelo.compararCombinaciones(combinacionSecreta8740,
				combinacionJugador1235);
		char[] aciertosEsperados0000 = { '0', '0', '0', '0' };

		char[] combinacionSecreta7856 = { '7', '8', '5', '6' };
		char[] combinacionJugador7236 = { '7', '2', '3', '6' };
		char[] aciertosComparativa7856X7236 = Modelo.compararCombinaciones(combinacionSecreta7856,
				combinacionJugador7236);
		char[] aciertosEsperadosN00N = { 'N', '0', '0', 'N' };

		char[] combinacionSecreta4207 = { '4', '2', '0', '7' };
		char[] combinacionJugador4082 = { '4', '0', '8', '2' };
		char[] aciertosComparativa4207X4082 = Modelo.compararCombinaciones(combinacionSecreta4207,
				combinacionJugador4082);
		char[] aciertosEsperadosNBB0 = { 'N', 'B', '0', 'B' };

		char[] combinacionSecreta0351 = { '0', '3', '5', '1' };
		char[] combinacionJugador0531 = { '0', '5', '3', '1' };
		char[] aciertosComparativa0351X0531 = Modelo.compararCombinaciones(combinacionSecreta0351,
				combinacionJugador0531);
		char[] aciertosEsperadosNBBN = { 'N', 'B', 'B', 'N' };

		char[] combinacionSecreta0381 = { '0', '3', '8', '1' };
		char[] combinacionJugador3030 = { '3', '0', '3', '0' };
		char[] aciertosComparativa0381X3030 = Modelo.compararCombinaciones(combinacionSecreta0381,
				combinacionJugador3030);
		char[] aciertosEsperadosBBBB2 = { 'B', 'B', 'B', 'B' };

		assertArrayEquals(aciertosEsperadosNNNN, aciertosComparativa2357X2357);
		assertArrayEquals(aciertosEsperadosBBBB, aciertosComparativa2367X3276);
		assertArrayEquals(aciertosEsperados0BB0, aciertosComparativa2356X1234);
		assertArrayEquals(aciertosEsperados0000, aciertosComparativa8740X1235);
		assertArrayEquals(aciertosEsperadosN00N, aciertosComparativa7856X7236);
		assertArrayEquals(aciertosEsperadosNBB0, aciertosComparativa4207X4082);
		assertArrayEquals(aciertosEsperadosNBBN, aciertosComparativa0351X0531);
		assertArrayEquals(aciertosEsperadosBBBB2, aciertosComparativa0381X3030);
	}

	/**
	 * Comprueba todas las combinaciones posibles de 0, B y N en un array de 4
	 * posiciones.
	 * 
	 * https://pairwise.teremokgames.com/x4to/
	 * 
	 * La unica vez que el assert es true es cuando el array es {'N','N','N','N'}.
	 */
	@Test
	public void testComprobarVictoriaTodasCombinaciones() {

		char[] aciertos0000 = { '0', '0', '0', '0' };
		char[] aciertos000B = { '0', '0', '0', 'B' };
		char[] aciertos000N = { '0', '0', '0', 'N' };
		char[] aciertos00B0 = { '0', '0', 'B', '0' };
		char[] aciertos00BB = { '0', '0', 'B', 'B' };
		char[] aciertos00BN = { '0', '0', 'B', 'N' };
		char[] aciertos00N0 = { '0', '0', 'N', '0' };
		char[] aciertos00NB = { '0', '0', 'N', 'B' };
		char[] aciertos00NN = { '0', '0', 'N', 'N' };
		char[] aciertos0B00 = { '0', 'B', '0', '0' };
		char[] aciertos0B0B = { '0', 'B', '0', 'B' };
		char[] aciertos0B0N = { '0', 'B', '0', 'N' };
		char[] aciertos0BB0 = { '0', 'B', 'B', '0' };
		char[] aciertos0BBB = { '0', 'B', 'B', 'B' };
		char[] aciertos0BBN = { '0', 'B', 'B', 'N' };
		char[] aciertos0BN0 = { '0', 'B', 'N', '0' };
		char[] aciertos0BNB = { '0', 'B', 'N', 'B' };
		char[] aciertos0BNN = { '0', 'B', 'N', 'N' };
		char[] aciertos0N00 = { '0', 'N', '0', '0' };
		char[] aciertos0N0B = { '0', 'N', '0', 'B' };
		char[] aciertos0N0N = { '0', 'N', '0', 'N' };
		char[] aciertos0NB0 = { '0', 'N', 'B', '0' };
		char[] aciertos0NBB = { '0', 'N', 'B', 'B' };
		char[] aciertos0NBN = { '0', 'N', 'B', 'N' };
		char[] aciertos0NN0 = { '0', 'N', 'N', '0' };
		char[] aciertos0NNB = { '0', 'N', 'N', 'B' };
		char[] aciertos0NNN = { '0', 'N', 'N', 'N' };
		char[] aciertosB000 = { 'B', '0', '0', '0' };
		char[] aciertosB00B = { 'B', '0', '0', 'B' };
		char[] aciertosB00N = { 'B', '0', '0', 'N' };
		char[] aciertosB0B0 = { 'B', '0', 'B', '0' };
		char[] aciertosB0BB = { 'B', '0', 'B', 'B' };
		char[] aciertosB0BN = { 'B', '0', 'B', 'N' };
		char[] aciertosB0N0 = { 'B', '0', 'N', '0' };
		char[] aciertosB0NB = { 'B', '0', 'N', 'B' };
		char[] aciertosB0NN = { 'B', '0', 'N', 'N' };
		char[] aciertosBB00 = { 'B', 'B', '0', '0' };
		char[] aciertosBB0B = { 'B', 'B', '0', 'B' };
		char[] aciertosBB0N = { 'B', 'B', '0', 'N' };
		char[] aciertosBBB0 = { 'B', 'B', 'B', '0' };
		char[] aciertosBBBB = { 'B', 'B', 'B', 'B' };
		char[] aciertosBBBN = { 'B', 'B', 'B', 'N' };
		char[] aciertosBBN0 = { 'B', 'B', 'N', '0' };
		char[] aciertosBBNB = { 'B', 'B', 'N', 'B' };
		char[] aciertosBBNN = { 'B', 'B', 'N', 'N' };
		char[] aciertosBN00 = { 'B', 'N', '0', '0' };
		char[] aciertosBN0B = { 'B', 'N', '0', 'B' };
		char[] aciertosBN0N = { 'B', 'N', '0', 'N' };
		char[] aciertosBNB0 = { 'B', 'N', 'B', '0' };
		char[] aciertosBNBB = { 'B', 'N', 'B', 'B' };
		char[] aciertosBNBN = { 'B', 'N', 'B', 'N' };
		char[] aciertosBNN0 = { 'B', 'N', 'N', '0' };
		char[] aciertosBNNB = { 'B', 'N', 'N', 'B' };
		char[] aciertosBNNN = { 'B', 'N', 'N', 'N' };
		char[] aciertosN000 = { 'N', '0', '0', '0' };
		char[] aciertosN00B = { 'N', '0', '0', 'B' };
		char[] aciertosN00N = { 'N', '0', '0', 'N' };
		char[] aciertosN0B0 = { 'N', '0', 'B', '0' };
		char[] aciertosN0BB = { 'N', '0', 'B', 'B' };
		char[] aciertosN0BN = { 'N', '0', 'B', 'N' };
		char[] aciertosN0N0 = { 'N', '0', 'N', '0' };
		char[] aciertosN0NB = { 'N', '0', 'N', 'B' };
		char[] aciertosN0NN = { 'N', '0', 'N', 'N' };
		char[] aciertosNB00 = { 'N', 'B', '0', '0' };
		char[] aciertosNB0B = { 'N', 'B', '0', 'B' };
		char[] aciertosNB0N = { 'N', 'B', '0', 'N' };
		char[] aciertosNBB0 = { 'N', 'B', 'B', '0' };
		char[] aciertosNBBB = { 'N', 'B', 'B', 'B' };
		char[] aciertosNBBN = { 'N', 'B', 'B', 'N' };
		char[] aciertosNBN0 = { 'N', 'B', 'N', '0' };
		char[] aciertosNBNB = { 'N', 'B', 'N', 'B' };
		char[] aciertosNBNN = { 'N', 'B', 'N', 'N' };
		char[] aciertosNN00 = { 'N', 'N', '0', '0' };
		char[] aciertosNN0B = { 'N', 'N', '0', 'B' };
		char[] aciertosNN0N = { 'N', 'N', '0', 'N' };
		char[] aciertosNNB0 = { 'N', 'N', 'B', '0' };
		char[] aciertosNNBB = { 'N', 'N', 'B', 'B' };
		char[] aciertosNNBN = { 'N', 'N', 'B', 'N' };
		char[] aciertosNNN0 = { 'N', 'N', 'N', '0' };
		char[] aciertosNNNB = { 'N', 'N', 'N', 'B' };
		char[] aciertosNNNN = { 'N', 'N', 'N', 'N' };

		assertFalse(Modelo.comprobarVictoria(aciertos0000));
		assertFalse(Modelo.comprobarVictoria(aciertos000B));
		assertFalse(Modelo.comprobarVictoria(aciertos000N));
		assertFalse(Modelo.comprobarVictoria(aciertos00B0));
		assertFalse(Modelo.comprobarVictoria(aciertos00BB));
		assertFalse(Modelo.comprobarVictoria(aciertos00BN));
		assertFalse(Modelo.comprobarVictoria(aciertos00N0));
		assertFalse(Modelo.comprobarVictoria(aciertos00NB));
		assertFalse(Modelo.comprobarVictoria(aciertos00NN));
		assertFalse(Modelo.comprobarVictoria(aciertos0B00));
		assertFalse(Modelo.comprobarVictoria(aciertos0B0B));
		assertFalse(Modelo.comprobarVictoria(aciertos0B0N));
		assertFalse(Modelo.comprobarVictoria(aciertos0BB0));
		assertFalse(Modelo.comprobarVictoria(aciertos0BBB));
		assertFalse(Modelo.comprobarVictoria(aciertos0BBN));
		assertFalse(Modelo.comprobarVictoria(aciertos0BN0));
		assertFalse(Modelo.comprobarVictoria(aciertos0BNB));
		assertFalse(Modelo.comprobarVictoria(aciertos0BNN));
		assertFalse(Modelo.comprobarVictoria(aciertos0N00));
		assertFalse(Modelo.comprobarVictoria(aciertos0N0B));
		assertFalse(Modelo.comprobarVictoria(aciertos0N0N));
		assertFalse(Modelo.comprobarVictoria(aciertos0NB0));
		assertFalse(Modelo.comprobarVictoria(aciertos0NBB));
		assertFalse(Modelo.comprobarVictoria(aciertos0NBN));
		assertFalse(Modelo.comprobarVictoria(aciertos0NN0));
		assertFalse(Modelo.comprobarVictoria(aciertos0NNB));
		assertFalse(Modelo.comprobarVictoria(aciertos0NNN));
		assertFalse(Modelo.comprobarVictoria(aciertosB000));
		assertFalse(Modelo.comprobarVictoria(aciertosB00B));
		assertFalse(Modelo.comprobarVictoria(aciertosB00N));
		assertFalse(Modelo.comprobarVictoria(aciertosB0B0));
		assertFalse(Modelo.comprobarVictoria(aciertosB0BB));
		assertFalse(Modelo.comprobarVictoria(aciertosB0BN));
		assertFalse(Modelo.comprobarVictoria(aciertosB0N0));
		assertFalse(Modelo.comprobarVictoria(aciertosB0NB));
		assertFalse(Modelo.comprobarVictoria(aciertosB0NN));
		assertFalse(Modelo.comprobarVictoria(aciertosBB00));
		assertFalse(Modelo.comprobarVictoria(aciertosBB0B));
		assertFalse(Modelo.comprobarVictoria(aciertosBB0N));
		assertFalse(Modelo.comprobarVictoria(aciertosBBB0));
		assertFalse(Modelo.comprobarVictoria(aciertosBBBB));
		assertFalse(Modelo.comprobarVictoria(aciertosBBBN));
		assertFalse(Modelo.comprobarVictoria(aciertosBBN0));
		assertFalse(Modelo.comprobarVictoria(aciertosBBNB));
		assertFalse(Modelo.comprobarVictoria(aciertosBBNN));
		assertFalse(Modelo.comprobarVictoria(aciertosBN00));
		assertFalse(Modelo.comprobarVictoria(aciertosBN0B));
		assertFalse(Modelo.comprobarVictoria(aciertosBN0N));
		assertFalse(Modelo.comprobarVictoria(aciertosBNB0));
		assertFalse(Modelo.comprobarVictoria(aciertosBNBB));
		assertFalse(Modelo.comprobarVictoria(aciertosBNBN));
		assertFalse(Modelo.comprobarVictoria(aciertosBNN0));
		assertFalse(Modelo.comprobarVictoria(aciertosBNNB));
		assertFalse(Modelo.comprobarVictoria(aciertosBNNN));
		assertFalse(Modelo.comprobarVictoria(aciertosN000));
		assertFalse(Modelo.comprobarVictoria(aciertosN00B));
		assertFalse(Modelo.comprobarVictoria(aciertosN00N));
		assertFalse(Modelo.comprobarVictoria(aciertosN0B0));
		assertFalse(Modelo.comprobarVictoria(aciertosN0BB));
		assertFalse(Modelo.comprobarVictoria(aciertosN0BN));
		assertFalse(Modelo.comprobarVictoria(aciertosN0N0));
		assertFalse(Modelo.comprobarVictoria(aciertosN0NB));
		assertFalse(Modelo.comprobarVictoria(aciertosN0NN));
		assertFalse(Modelo.comprobarVictoria(aciertosNB00));
		assertFalse(Modelo.comprobarVictoria(aciertosNB0B));
		assertFalse(Modelo.comprobarVictoria(aciertosNB0N));
		assertFalse(Modelo.comprobarVictoria(aciertosNBB0));
		assertFalse(Modelo.comprobarVictoria(aciertosNBBB));
		assertFalse(Modelo.comprobarVictoria(aciertosNBBN));
		assertFalse(Modelo.comprobarVictoria(aciertosNBN0));
		assertFalse(Modelo.comprobarVictoria(aciertosNBNB));
		assertFalse(Modelo.comprobarVictoria(aciertosNBNN));
		assertFalse(Modelo.comprobarVictoria(aciertosNN00));
		assertFalse(Modelo.comprobarVictoria(aciertosNN0B));
		assertFalse(Modelo.comprobarVictoria(aciertosNN0N));
		assertFalse(Modelo.comprobarVictoria(aciertosNNB0));
		assertFalse(Modelo.comprobarVictoria(aciertosNNBB));
		assertFalse(Modelo.comprobarVictoria(aciertosNNBN));
		assertFalse(Modelo.comprobarVictoria(aciertosNNN0));
		assertFalse(Modelo.comprobarVictoria(aciertosNNNB));
		assertTrue(Modelo.comprobarVictoria(aciertosNNNN));
	}

	/**
	 * Comprueba todas las combinaciones posibles de: - 0, B y N en un array de 4
	 * posiciones | https://pairwise.teremokgames.com/x4to/ - 0 y B en un array de 4
	 * posiciones | https://pairwise.teremokgames.com/x4wg/ - 0 y N en un array de 4
	 * posiciones | https://pairwise.teremokgames.com/x520/ - B y N en un array de 4
	 * posiciones | https://pairwise.teremokgames.com/x4z8/
	 * 
	 * Todo ello usando pair-wise testing. La unica vez que el assert es true es
	 * cuando el array es {'N','N','N','N'}.
	 */
	@Test
	public void testComprobarVictoriaPairWise() {

		// Pair-wise testing de los posibles valores 0, B y N.
		char[] aciertosNNNN = { 'N', 'N', 'N', 'N' };
		char[] aciertosN000 = { 'N', '0', '0', '0' };
		char[] aciertosNBBB = { 'N', 'B', 'B', 'B' };
		char[] aciertos00BN = { '0', '0', 'B', 'N' };
		char[] aciertos0BN0 = { '0', 'B', 'N', '0' };
		char[] aciertos0N0B = { '0', 'N', '0', 'B' };
		char[] aciertosBB0N = { 'B', 'B', '0', 'N' };
		char[] aciertosBNB0 = { 'B', 'N', 'B', '0' };
		char[] aciertosB0NB = { 'B', '0', 'N', 'B' };

		assertTrue(Modelo.comprobarVictoria(aciertosNNNN));
		assertFalse(Modelo.comprobarVictoria(aciertosN000));
		assertFalse(Modelo.comprobarVictoria(aciertosNBBB));
		assertFalse(Modelo.comprobarVictoria(aciertos00BN));
		assertFalse(Modelo.comprobarVictoria(aciertos0BN0));
		assertFalse(Modelo.comprobarVictoria(aciertos0N0B));
		assertFalse(Modelo.comprobarVictoria(aciertosBB0N));
		assertFalse(Modelo.comprobarVictoria(aciertosBNB0));
		assertFalse(Modelo.comprobarVictoria(aciertosB0NB));

		// Pair-wise testing de los valores 0 y B.
		char[] aciertos0BBB = { '0', 'B', 'B', 'B' };
		char[] aciertosBB00 = { 'B', 'B', '0', '0' };
		char[] aciertosB00B = { 'B', '0', '0', 'B' };
		char[] aciertosB0B0 = { 'B', '0', 'B', '0' };
		char[] aciertos00B0 = { '0', '0', 'B', '0' };
		char[] aciertos000B = { '0', '0', '0', 'B' };
		char[] aciertos0B00 = { '0', 'B', '0', '0' };

		assertFalse(Modelo.comprobarVictoria(aciertos0BBB));
		assertFalse(Modelo.comprobarVictoria(aciertosBB00));
		assertFalse(Modelo.comprobarVictoria(aciertosB00B));
		assertFalse(Modelo.comprobarVictoria(aciertosB0B0));
		assertFalse(Modelo.comprobarVictoria(aciertos00B0));
		assertFalse(Modelo.comprobarVictoria(aciertos000B));
		assertFalse(Modelo.comprobarVictoria(aciertos0B00));

		// Pair-wise testing de los valores 0 y N.
		char[] aciertos0NNN = { '0', 'N', 'N', 'N' };
		char[] aciertosNN00 = { 'N', 'N', '0', '0' };
		char[] aciertosN00N = { 'N', '0', '0', 'N' };
		char[] aciertosN0N0 = { 'N', '0', 'N', '0' };
		char[] aciertos00N0 = { '0', '0', 'N', '0' };
		char[] aciertos000N = { '0', '0', '0', 'N' };
		char[] aciertos0N00 = { '0', 'N', '0', '0' };

		assertFalse(Modelo.comprobarVictoria(aciertos0NNN));
		assertFalse(Modelo.comprobarVictoria(aciertosNN00));
		assertFalse(Modelo.comprobarVictoria(aciertosN00N));
		assertFalse(Modelo.comprobarVictoria(aciertosN0N0));
		assertFalse(Modelo.comprobarVictoria(aciertos00N0));
		assertFalse(Modelo.comprobarVictoria(aciertos000N));
		assertFalse(Modelo.comprobarVictoria(aciertos0N00));

		// Pair-wise testing de los valores B y N.
		char[] aciertosBNNN = { 'B', 'N', 'N', 'N' };
		char[] aciertosNNBB = { 'N', 'N', 'B', 'B' };
		char[] aciertosNBBN = { 'N', 'B', 'B', 'N' };
		char[] aciertosNBNB = { 'N', 'B', 'N', 'B' };
		char[] aciertosBBNB = { 'B', 'B', 'N', 'B' };
		char[] aciertosBBBN = { 'B', 'B', 'B', 'N' };
		char[] aciertosBNBB = { 'B', 'N', 'B', 'B' };

		assertFalse(Modelo.comprobarVictoria(aciertosBNNN));
		assertFalse(Modelo.comprobarVictoria(aciertosNNBB));
		assertFalse(Modelo.comprobarVictoria(aciertosNBBN));
		assertFalse(Modelo.comprobarVictoria(aciertosNBNB));
		assertFalse(Modelo.comprobarVictoria(aciertosBBNB));
		assertFalse(Modelo.comprobarVictoria(aciertosBBBN));
		assertFalse(Modelo.comprobarVictoria(aciertosBNBB));
	}

	/**
	 * Comprueba la opcion del menu inicial del juego correcta sea unicamente la 1 o
	 * la 2.
	 */
	@Test
	public void testComprobarOpcion() {

		assertFalse(modelo.validarOpcionMenu(opcion0)); // Limite inferior.

		assertTrue(modelo.validarOpcionMenu(opcion1)); // Frontera inferior.
		assertTrue(modelo.validarOpcionMenu(opcion2)); // Frontera superior.

		assertFalse(modelo.validarOpcionMenu(opcion3)); // Limite superior alejado.
		assertFalse(modelo.validarOpcionMenu(opcion4)); // Limite superior alejado.
		assertFalse(modelo.validarOpcionMenu(opcion5)); // Limite superior alejado.
		assertFalse(modelo.validarOpcionMenu(opcion6)); // Limite superior alejado.
		assertFalse(modelo.validarOpcionMenu(opcion7)); // Limite superior alejado.
		assertFalse(modelo.validarOpcionMenu(opcion8)); // Limite superior alejado.
		assertFalse(modelo.validarOpcionMenu(opcion9)); // Limite superior alejado.
		assertFalse(modelo.validarOpcionMenu(opciona));
		assertFalse(modelo.validarOpcionMenu(opcionb));
		assertFalse(modelo.validarOpcionMenu(opcionc));
		assertFalse(modelo.validarOpcionMenu(opciond));
		assertFalse(modelo.validarOpcionMenu(opcione));
		assertFalse(modelo.validarOpcionMenu(opcionf));
		assertFalse(modelo.validarOpcionMenu(opciong));
		assertFalse(modelo.validarOpcionMenu(opcionh));
		assertFalse(modelo.validarOpcionMenu(opcioni));
		assertFalse(modelo.validarOpcionMenu(opcionj));
		assertFalse(modelo.validarOpcionMenu(opcionk));
		assertFalse(modelo.validarOpcionMenu(opcionl));
		assertFalse(modelo.validarOpcionMenu(opcionm));
		assertFalse(modelo.validarOpcionMenu(opcionn));
		assertFalse(modelo.validarOpcionMenu(opciono));
		assertFalse(modelo.validarOpcionMenu(opcionp));
		assertFalse(modelo.validarOpcionMenu(opcionq));
		assertFalse(modelo.validarOpcionMenu(opcionr));
		assertFalse(modelo.validarOpcionMenu(opcions));
		assertFalse(modelo.validarOpcionMenu(opciont));
		assertFalse(modelo.validarOpcionMenu(opcionu));
		assertFalse(modelo.validarOpcionMenu(opcionv));
		assertFalse(modelo.validarOpcionMenu(opcionw));
		assertFalse(modelo.validarOpcionMenu(opcionx));
		assertFalse(modelo.validarOpcionMenu(opciony));
		assertFalse(modelo.validarOpcionMenu(opcionz));
		assertFalse(modelo.validarOpcionMenu(opcionA));
		assertFalse(modelo.validarOpcionMenu(opcionB));
		assertFalse(modelo.validarOpcionMenu(opcionC));
		assertFalse(modelo.validarOpcionMenu(opcionD));
		assertFalse(modelo.validarOpcionMenu(opcionE));
		assertFalse(modelo.validarOpcionMenu(opcionF));
		assertFalse(modelo.validarOpcionMenu(opcionG));
		assertFalse(modelo.validarOpcionMenu(opcionH));
		assertFalse(modelo.validarOpcionMenu(opcionI));
		assertFalse(modelo.validarOpcionMenu(opcionJ));
		assertFalse(modelo.validarOpcionMenu(opcionK));
		assertFalse(modelo.validarOpcionMenu(opcionL));
		assertFalse(modelo.validarOpcionMenu(opcionM));
		assertFalse(modelo.validarOpcionMenu(opcionN));
		assertFalse(modelo.validarOpcionMenu(opcionO));
		assertFalse(modelo.validarOpcionMenu(opcionP));
		assertFalse(modelo.validarOpcionMenu(opcionQ));
		assertFalse(modelo.validarOpcionMenu(opcionR));
		assertFalse(modelo.validarOpcionMenu(opcionS));
		assertFalse(modelo.validarOpcionMenu(opcionT));
		assertFalse(modelo.validarOpcionMenu(opcionU));
		assertFalse(modelo.validarOpcionMenu(opcionV));
		assertFalse(modelo.validarOpcionMenu(opcionW));
		assertFalse(modelo.validarOpcionMenu(opcionX));
		assertFalse(modelo.validarOpcionMenu(opcionY));
		assertFalse(modelo.validarOpcionMenu(opcionZ));

		assertFalse(modelo.validarOpcionMenu(opcionResta)); // Limite.
		assertFalse(modelo.validarOpcionMenu(opcionAsterisco)); // Limite.
		assertFalse(modelo.validarOpcionMenu(opcionBarra));
		assertFalse(modelo.validarOpcionMenu(opcionResta));
		assertFalse(modelo.validarOpcionMenu(opcionAsterisco));
		assertFalse(modelo.validarOpcionMenu(opcionMas));
		assertFalse(modelo.validarOpcionMenu(opcionGorro));
		assertFalse(modelo.validarOpcionMenu(opcioContraBarra));
		assertFalse(modelo.validarOpcionMenu(opcionEx1));
		assertFalse(modelo.validarOpcionMenu(opcionPipe));
		assertFalse(modelo.validarOpcionMenu(opcionArroba));
		assertFalse(modelo.validarOpcionMenu(opciobCorchete));
		assertFalse(modelo.validarOpcionMenu(opcionDolar));
		assertFalse(modelo.validarOpcionMenu(opcionEspana));
		assertFalse(modelo.validarOpcionMenu(opcioXCiento));
		assertFalse(modelo.validarOpcionMenu(opcionAnd));
		assertFalse(modelo.validarOpcionMenu(opcionSlash));
		assertFalse(modelo.validarOpcionMenu(opcionParentesis1));
		assertFalse(modelo.validarOpcionMenu(opcionParentesis2));
		assertFalse(modelo.validarOpcionMenu(opcionIgual));
		assertFalse(modelo.validarOpcionMenu(opcionInterrogante1));
		assertFalse(modelo.validarOpcionMenu(opcioComilla));
		assertFalse(modelo.validarOpcionMenu(opcion1234));
		assertFalse(modelo.validarOpcionMenu(opcion2314));
	}
}