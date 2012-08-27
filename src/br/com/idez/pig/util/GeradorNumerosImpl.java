package br.com.idez.pig.util;

import java.util.ArrayList;
import java.util.List;

public class GeradorNumerosImpl implements IGeradorNumeros {

	@Override
	public List<Integer> getNumeroAleatorio(int qtdeDados, int inicio, int fim) {

		List<Integer> retorno = new ArrayList<Integer>();

		for (int i = 0; i < qtdeDados; i++) {
			int r = inicio + (int) (fim * Math.random());
			retorno.add(new Integer(r));
		}

		return retorno;
	}

}