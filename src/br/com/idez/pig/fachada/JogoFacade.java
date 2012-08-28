package br.com.idez.pig.fachada;

import br.com.idez.pig.jogo.Jogo;
import br.com.idez.pig.validacao.GerenciadorValidadores;
import br.com.idez.pig.validacao.Validador;

public class JogoFacade {

	private Jogo jogo;
	private GerenciadorValidadores gerenciadorValidadores = new GerenciadorValidadores();

	public void criarJogo() {
		this.jogo = new Jogo();
	}

	public int getPlacarRodada() {
		return this.jogo.getPlacarRodada();
	}

	public int getPlacarGeral() {
		return this.jogo.getPlacarGeral();
	}

	public String getValoresJogada() {
		String retorno = new String();
		for (Integer integer : this.jogo.getValoresJogada()) {
			retorno = retorno + integer + ", ";
		}

		retorno = retorno.substring(0, retorno.length() - 2);

		return retorno;
	}

	public void parar() {
		this.jogo.parar();
	}

	public void jogar() {
		this.jogo.jogar();
	}

	public boolean isPig() {
		return this.jogo.isPig();
	}

	public String getNumeroJogadas() {
		return this.jogo.getNumeroJogadas();
	}

	public Jogo getJogo() {
		return jogo;
	}

	public Validador gerarValidadorJogarParar() {
		return gerenciadorValidadores.gerarValidadorJogarParar();
	}

	public Validador gerarValidadorSimNao() {
		return gerenciadorValidadores.gerarValidadorSimNao();
	}

}