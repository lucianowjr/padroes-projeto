package br.com.idez.pig.fachada;

import br.com.idez.pig.jogo.Jogo;

public class JogoFacade {

	private Jogo jogo;

	public void criarJogo() {
		this.jogo = new Jogo();
	}

	public int getPlacarRodada() {
		return this.jogo.getPlacarRodada();
	}

	public int getPlacarGeral() {
		return this.jogo.getPlacarGeral();
	}

}