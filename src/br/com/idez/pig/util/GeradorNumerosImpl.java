package br.com.idez.pig.util;

public class GeradorNumerosImpl implements GeradorNumeros {

	@Override
	public int getNumeroAleatorio(int inicio, int fim) {
		
		int i = inicio + (int) (fim * Math.random());
		
		return i;
	}
	
}