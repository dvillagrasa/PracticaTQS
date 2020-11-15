package mastermind;

import java.util.Random;

public class Aleatorio implements InterfazAleatorio {
	String numAleatorio;
	int aux;
	public Aleatorio(){
		Random aleatorio = new Random();
		numAleatorio = "";
		for (int i = 0; i < 4; i++) {
			int aux = aleatorio.nextInt(9);
			numAleatorio += Integer.toString(aux);
		}
	}

	public String obtenerValorAleatorio(){
		return numAleatorio;
	}

}
