package br.com.idez.pig.jogo;

import java.util.ArrayList;
import java.util.List;

public class Rodada {

	private Jogada jogadaAtual;

	private int placarRodada;
	
	public Rodada() {
		this.placarRodada = 0;
	}

	public int getPlacarRodada() {
		return this.placarRodada;
	}

	public void incrementaPlacarRodada(int valor) {
		this.placarRodada += valor;
	}

	public List<Integer> jogar(int numeroDeDados, int inicio, int fim) {
		List<Integer> retorno = new ArrayList<Integer>();

		this.jogadaAtual = new Jogada(numeroDeDados, inicio, fim);		

		retorno = this.jogadaAtual.getValores();

		for (Integer integer : retorno) {
			incrementaPlacarRodada(integer.intValue());
		}

		return retorno;
	}

	public List<Integer> getValoresJogada() {
		return jogadaAtual.getValores();
	}

}