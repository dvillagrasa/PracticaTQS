package mastermind;

import java.util.ArrayList;

public class MockAleatorio implements InterfazAleatorio {
	
	ArrayList<String> listaAleatoria = new ArrayList<String>();
	int contador = 0;

	public MockAleatorio(ArrayList<String> listaAleatoriaParametro){
		listaAleatoria = listaAleatoriaParametro;
	}

	public String obtenerValorAleatorio(){
		String combinacionAleaotriaSimulada = listaAleatoria.get(contador);
		contador++;

		return combinacionAleaotriaSimulada;
	}
}
