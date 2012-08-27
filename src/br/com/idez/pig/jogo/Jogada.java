package br.com.idez.pig.jogo;

import java.util.List;

import br.com.idez.pig.util.GeradorNumerosImpl;
import br.com.idez.pig.util.IGeradorNumeros;

public class Jogada {

	private List<Integer> valores;
	IGeradorNumeros gerador = new GeradorNumerosImpl();

	public Jogada(int numeroDeDados, int inicio, int fim) {
		this.valores = gerador.getNumeroAleatorio(numeroDeDados, inicio, fim);	}

	public List<Integer> getValores() {
		return valores;
	}

}