package br.com.idez.pig.visao;

import java.util.Scanner;

import br.com.idez.pig.fachada.JogoFacade;
import br.com.idez.pig.recorde.GerenciadorRecordeImpl;
import br.com.idez.pig.recorde.IGerenciadorRecorde;
import br.com.idez.pig.validacao.DadosInvalidosException;
import br.com.idez.pig.validacao.Validador;

public class Visao {

	static int PONTUACAO_MAXIMA = 10;

	JogoFacade fachada = new JogoFacade();
	Scanner scanner = new Scanner(System.in);
	Validador validadorJogarParar;
	Validador validadorSimNao;
	IGerenciadorRecorde gerenciadorRecorde;

	public static void main(String[] args) {
		Visao visao = new Visao();
		visao.iniciar();
	}

	private void iniciar() {

		fachada.criarJogo();
		validadorJogarParar = fachada.gerarValidadorJogarParar();
		validadorSimNao = fachada.gerarValidadorSimNao();
		gerenciadorRecorde = new GerenciadorRecordeImpl();

		boolean continuar = true;

		while (continuar) {
			imprimirPlacares();
			String opcao = imprimirOpcoes();
			if (opcao.equalsIgnoreCase("J")) {
				fachada.jogar();
				if (fachada.isPig()) {
					System.out.println();
					System.out.println("PIG!");
				} else if (fachada.getPlacarGeral() + fachada.getPlacarRodada() >= PONTUACAO_MAXIMA) {

					fachada.getJogo().setPlacarGeral(
							fachada.getPlacarGeral()
									+ fachada.getPlacarRodada());

					System.out.println();
					System.out.println("Valor Dado: "
							+ fachada.getValoresJogada());
					imprimirPlacares();

					boolean isRecord = gerenciadorRecorde
							.verificaRecorde(fachada.getNumeroJogadas());

					System.out.println("Parabéns! Você chegou aos "
							+ fachada.getPlacarGeral() + " pontos em "
							+ fachada.getNumeroJogadas()
							+ " jogadas.\nRecorde: "
							+ gerenciadorRecorde.getRecorde() + " jogadas");

					if (isRecord) {
						System.out.println("Você bateu um novo recorde!");
					}

					String jogarMaisUma = jogarMaisUma();

					if (jogarMaisUma.equals("S")) {
						fachada.criarJogo();
					} else if (jogarMaisUma.equals("N")) {
						continuar = false;
					}

				} else {
					System.out.println();
					System.out.println("Valor Dado: "
							+ fachada.getValoresJogada());
				}
			} else if (opcao.equalsIgnoreCase("P")) {
				fachada.parar();
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

			String letra = scanner.nextLine();

			try {
				validadorJogarParar.validar(letra);
				retorno = letra;
				continuar = false;
			} catch (DadosInvalidosException e) {
				System.out.println(e.getMessage());
			}
		}
		return retorno;
	}

	private String jogarMaisUma() {
		String retorno = new String();
		boolean continuar = true;

		while (continuar) {
			System.out.println("Quer jogar mais uma? [S]im ou [N]ão?");

			String letra = scanner.next();

			try {
				validadorSimNao.validar(letra);
				retorno = letra.toUpperCase();
				continuar = false;
			} catch (DadosInvalidosException e) {
				System.out.println(e.getMessage());
			}
		}

		return retorno;
	}

	private void imprimirPlacares() {
		System.out.println("Placar Geral: " + fachada.getPlacarGeral());
		System.out.println("Placar Rodada: " + fachada.getPlacarRodada());
	}

}