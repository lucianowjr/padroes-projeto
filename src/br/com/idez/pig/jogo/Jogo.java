package br.com.idez.pig.jogo;

import java.util.ArrayList;
import java.util.List;

public class Jogo {

	private Rodada rodadaAtual;
	private List<Jogador> jogadores;
	private int placarGeral = 0;
	private int numeroDeDados;
	private int inicio;
	private int fim;
	private int numeroJogadas;

	public Jogo() {
		this.rodadaAtual = new Rodada();
		this.jogadores = new ArrayList<Jogador>();
		this.placarGeral = 0;
		this.numeroDeDados = 1;
		this.inicio = 1;
		this.fim = 6;
		this.numeroJogadas = 0;		
	}

	public int getPlacarRodada() {
		return rodadaAtual.getPlacarRodada();
	}

	public void criarRodada() {
		Rodada novaRodada = new Rodada();
		this.rodadaAtual = novaRodada;
	}

	public int getPlacarGeral() {
		return this.placarGeral;
	}

	public void setPlacarGeral(int placarGeral) {
		this.placarGeral = placarGeral;
	}

	public void setNumeroDeDados(int numeroDeDados) {
		this.numeroDeDados = numeroDeDados;
	}

	public void parar() {
		setPlacarGeral(this.placarGeral + rodadaAtual.getPlacarRodada());
		criarRodada();
	}

	public void jogar() {
		this.rodadaAtual.jogar(this.numeroDeDados, this.inicio, this.fim);
		this.numeroJogadas++;
	}

	public List<Integer> getValoresJogada() {
		return this.rodadaAtual.getValoresJogada();
	}

	public boolean isPig() {

		boolean retorno = false;

		for (Integer integer : this.rodadaAtual.getValoresJogada()) {
			if (integer.intValue() == 1) {
				this.rodadaAtual = new Rodada();
				retorno = true;
			}
		}

		return retorno;
	}

	public String getNumeroJogadas() {
		return "" + numeroJogadas;
	}

}