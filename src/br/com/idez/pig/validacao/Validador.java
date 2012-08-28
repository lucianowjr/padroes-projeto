package br.com.idez.pig.validacao;

public abstract class Validador {

	protected Validador sucessor;
	
	public abstract void validar(String dadoParaValidacao) throws DadosInvalidosException;

	public void validarSucessor(String dadoParaValidacao) throws DadosInvalidosException {
		if (getSucessor() != null) {
			getSucessor().validar(dadoParaValidacao);
		}
	}
	
	public void setSucessor(Validador sucessor) {
		this.sucessor = sucessor;
	}

	public Validador getSucessor() {
		return sucessor;
	}
}
