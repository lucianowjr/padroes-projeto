package br.com.idez.pig.visao;

import java.util.Scanner;

import br.com.idez.pig.fachada.JogoFacade;
import br.com.idez.pig.util.Util;

public class Visao {

	JogoFacade fachada = new JogoFacade();
	Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		Visao visao = new Visao();
		visao.iniciar();
	}

	private void iniciar() {

		fachada.criarJogo();

		boolean continuar = true;

		while (continuar) {		
			imprimirPlacares();
			String opcao = imprimirOpcoes();
			if (opcao.equalsIgnoreCase("J")) {
				fachada.jogar();
				if (fachada.isPig()) {
					System.out.println();
					System.out.println("PIG!");
				} else if (fachada.getPlacarGeral() >= 100) {
					System.out.println("Você Ganhou! "
							+ fachada.getNumeroJogadas() + " jogadas.");
					fachada.criarJogo();
				} else {
					System.out.println();
					System.out.println("Valor Dado: "
							+ fachada.getValoresJogada());
				}
			} else if (opcao.equalsIgnoreCase("P")) {
				fachada.parar();
				if (fachada.getPlacarGeral() >= 100) {
					System.out.println("Você ganhou com "
							+ fachada.getNumeroJogadas() + " jogadas!");
					
					System.out.println();
					System.out.println("# NOVO JOGO #");
					System.out.println();
					
					fachada.criarJogo();
				}
			} else if (opcao.equalsIgnoreCase("S")) {
				continuar = false;
			}
		}
	}

	private String imprimirOpcoes() {
		String retorno = new String();
		boolean continuar = true;
		while (continuar) {
			System.out.println("[J]ogar ou [P]arar?");

			String letra = scanner.next();

			if (Util.isInteger(letra)) {
				System.out.println("Opção Inválida");
			} else if (letra.equalsIgnoreCase("J")
					|| letra.equalsIgnoreCase("P")) {
				retorno = letra;
				continuar = false;
			} else {
				System.out.println("Opção Inválida");
			}
		}
		return retorno;
	}

	private void imprimirPlacares() {		
		System.out.println("Placar Geral: " + fachada.getPlacarGeral());
		System.out.println("Placar Rodada: " + fachada.getPlacarRodada());
	}

}