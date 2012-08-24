package br.com.idez.pig.jogo;

public class Jogo {

	private Rodada rodadaAtual;
	private int placarGeral = 0;

	public Jogo() {
		this.rodadaAtual = new Rodada();
		this.placarGeral = 0;
	}

	public int getPlacarRodada() {
		return rodadaAtual.getPlacarRodada();
	}

	public void criarNovaRodada() {
		Rodada novaRodada = new Rodada();
		this.rodadaAtual = novaRodada;
	}

	public int getPlacarGeral() {
		return this.placarGeral;
	}

}