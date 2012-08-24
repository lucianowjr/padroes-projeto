package br.com.idez.pig.jogo;

public class Jogada {

	private int valor;

	public boolean isPig() {
		if (this.valor == 1) {
			return true;
		} else {
			return false;
		}
	}

}