package br.com.idez.pig.validacao;

public class ValidadorSimNao extends Validador{

	//Valida se é S ou N
	public void validar(String dadoParaValidacao) throws DadosInvalidosException{
		boolean valido = false;
		if (dadoParaValidacao.equalsIgnoreCase("S") || dadoParaValidacao.equalsIgnoreCase("N")) {
			valido = true;
			validarSucessor(dadoParaValidacao);
		}
		if (! valido) {
			throw new DadosInvalidosException();
		}
	}
	
}