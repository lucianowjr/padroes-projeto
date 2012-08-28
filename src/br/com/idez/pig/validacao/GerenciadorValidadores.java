package br.com.idez.pig.validacao;

public class GerenciadorValidadores {

	public Validador gerarValidadorJogarParar() {
		Validador validadorCaracter = new ValidadorCaracter();
		Validador validadorJogarParar = new ValidadorJogarParar();

		validadorCaracter.setSucessor(validadorJogarParar);

		return validadorCaracter;
	}

	public Validador gerarValidadorSimNao() {
		Validador validadorCaracter = new ValidadorCaracter();
		Validador validadorSimNao = new ValidadorSimNao();

		validadorCaracter.setSucessor(validadorSimNao);

		return validadorCaracter;
	}

}