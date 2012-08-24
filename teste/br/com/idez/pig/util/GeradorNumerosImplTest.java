package br.com.idez.pig.util;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class GeradorNumerosImplTest {

	GeradorNumerosImpl gerador = new GeradorNumerosImpl();

	@Test
	public void getNumeroAleatorioTeste() {
		List<Integer> lista = new ArrayList<>();
		for (int i = 0; i <= 100; i++) {
			lista.add(new Integer(gerador.getNumeroAleatorio(1, 6)));
		}

		Assert.assertEquals(true, lista.contains(new Integer(1)));
		Assert.assertEquals(true, lista.contains(new Integer(2)));
		Assert.assertEquals(true, lista.contains(new Integer(3)));
		Assert.assertEquals(true, lista.contains(new Integer(4)));
		Assert.assertEquals(true, lista.contains(new Integer(5)));
		Assert.assertEquals(true, lista.contains(new Integer(6)));
		Assert.assertEquals(false, lista.contains(new Integer(7)));
	}

}
