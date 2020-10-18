package mastermind;

import java.util.Random;
import java.util.Arrays;
import java.util.Collections;
//import java.util.Scanner;

/** 
 * Clase Vista - abcdefghijk
 * @author Daniel Luis Garcia 
 * @author Daniel Villagrasa Ramírez
 */ 
public class Vista {
	public static final int MAX_INTENTOS = 9;
	public static final int MAX_CLAVIJAS = 4;
	
	private String suposicion[][];
	private String respuesta[];
	//private String[] combinacionSecreta;
	
	public Vista() {
		//obtenido = new String[]{"1","2","3","4"};
		suposicion = new String[MAX_INTENTOS][MAX_CLAVIJAS];
		respuesta = new String[MAX_CLAVIJAS];
		//dibujarTablero();
	}
	
	
	//int[] numeros = {0,1,2,3,4,5,6,7,8,9};
	public static final Random aleatorio = new Random();
	
	/**
	 * Explicación
	 */
	public void dibujarTablero(){
		
		System.out.println("                _______________________");
		System.out.println(
				"               |  " + generarCombinacionAleatoria()[0] +
				"  |  " + generarCombinacionAleatoria()[1] +
				"  |  " + generarCombinacionAleatoria()[2] +
				"  |  " + generarCombinacionAleatoria()[3] +
				"  |  ");
		System.out.println(" _______________________      _______________________");
		 
		for (int j = 0; j < MAX_INTENTOS; j++) {
		      for (int k = 0; k < MAX_CLAVIJAS; k++) {
		    	  suposicion[j][k] = "    ";
		    	  respuesta[k] = " ";
		      }
		      System.out.println(
		        "| " + suposicion[j][0] +
		        "| " + suposicion[j][1] +
		        "| " + suposicion[j][2] +
		        "| " + suposicion[j][3] +
		        "| == |  " + respuesta[0] + "  |  "+
		        respuesta[1] + "  |  "+
		        respuesta[2] + "  |  "+
		        respuesta[3] + "  |  ");
		      System.out.println(" _______________________      _______________________");
		    }
		
		/*int MAX_INTENTOS = 9;
		int vecesJugado = 0;
		
		while(vecesJugado < MAX_INTENTOS) {
			System.out.println("Inserta la combinación con el siguiente formato: X X X X");
			Scanner escaner = new Scanner(System.in);
			
			int a[] = new int[100];
			String s[]= escaner.nextLine().split(" ");
			for(int i =0 ;i < s.length;i++){
			    a[i]= Integer.parseInt(s[i]);
			}
			for(int i =0 ; i < s.length; i++) {
				 System.out.print(a[i]);
			}
			
			vecesJugado++;
			System.out.println(vecesJugado);
		}*/
	}
	
	public int[] generarCombinacionAleatoria() {
		int[] combinacionNumerica = new int[4];
		for(int i = 0; i < combinacionNumerica.length; i++) {
			combinacionNumerica[i] = aleatorio.nextInt(8); 
		}
		Collections.shuffle(Arrays.asList(combinacionNumerica));
		return combinacionNumerica;
	}
}