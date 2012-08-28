package br.com.idez.pig.validacao;

public class ValidadorCaracter extends Validador{

	//Valida se a entrada é uma letra (se for outro caracter qualquer, retorna erro)
	public void validar(String dadoParaValidacao) throws DadosInvalidosException{
		boolean isLetra = dadoParaValidacao.matches("[a-zA-Z]");

		if (isLetra) {
			validarSucessor(dadoParaValidacao);
		} else {
			throw new DadosInvalidosException();
		}
	}			
}
