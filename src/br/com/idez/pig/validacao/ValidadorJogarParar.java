package br.com.idez.pig.validacao;

public class ValidadorJogarParar extends Validador{

	//Valida se é J ou P
	public void validar(String dadoParaValidacao) throws DadosInvalidosException{
		boolean valido = false;
		if (dadoParaValidacao.equalsIgnoreCase("J") || dadoParaValidacao.equalsIgnoreCase("P")) {
			valido = true;
			validarSucessor(dadoParaValidacao);
		}
		if (! valido) {
			throw new DadosInvalidosException();
		}
	}
}
