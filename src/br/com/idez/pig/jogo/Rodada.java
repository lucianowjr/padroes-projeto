package br.com.idez.pig.jogo;

public class Rodada {

	private Jogada jogadaAtual;

	private int placarRodada = 0;

	public Rodada() {
		this.jogadaAtual = new Jogada();
		this.placarRodada = 0;
	}

	public void criarJogada() {
		this.jogadaAtual = new Jogada();
	}

	public int getPlacarRodada() {
		return this.placarRodada;
	}

	public void incrementaPlacarRodada(int valor) {
		this.placarRodada += valor;
	}

}
