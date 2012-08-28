package br.com.idez.pig.validacao;

public class DadosInvalidosException extends Exception {

	private static final long serialVersionUID = -2199977637047892167L;

	public DadosInvalidosException() {
		super("Opção Inválida!");
	}

}