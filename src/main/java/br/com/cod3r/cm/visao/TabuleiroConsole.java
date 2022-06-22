package br.com.cod3r.cm.visao;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Iterator;

import br.com.cod3r.cm.modelo.Tabuleiro;
import br.com.cod3r.cm.excecao.SairException;
import br.com.cod3r.cm.excecao.ExplosaoException;

public class TabuleiroConsole {
	private Tabuleiro tabuleiro;
	private Scanner entrada = new Scanner(System.in);

	public TabuleiroConsole(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;

		executarJogo();
	}

	private void executarJogo() {
		try {
			boolean continuar = true;

			while (continuar) {
				cicloDoJogo();

				System.out.println("Outra partida? (S/n)");
				String resposta = entrada.nextLine();

				if("n".equalsIgnoreCase(resposta)) {
					continuar = false;
				} else {
					tabuleiro.reiniciar();
				}
			}

		} catch(SairException e) {
			System.out.println("Tchau!");

		} finally {
			entrada.close();
		}
	}

	private void cicloDoJogo() {
		try {
			while(!tabuleiro.objetivoAlcancado()) {
				System.out.println(tabuleiro);
				String digitado = capturadoValorDigitado("Digita (x, y): ");

				Iterator<Integer> xy = Arrays.stream(digitado.split(","))
					.map(e -> Integer.parseInt(e.trim())).iterator();

				digitado = capturadoValorDigitado("1 - Abrir ou 2 - (Des)marcar: ");

				if("1".equalsIgnoreCase(digitado)) {
					tabuleiro.abrir(xy.next(), xy.next());

				} else if("2".equalsIgnoreCase(digitado)) {
					tabuleiro.alternarMarcacao(xy.next(), xy.next());
				}
			}

			System.out.println(tabuleiro);
			System.out.println("Tu ganhaste!");
		} catch(ExplosaoException e) {
			System.out.println(tabuleiro);
			System.out.println("Tu perdeste!");
		}
	}

	private String capturadoValorDigitado(String texto) {
		System.out.print(texto);
		String digitado = entrada.nextLine();

		if("sair".equalsIgnoreCase(digitado)) {
			throw new SairException();
		}

		return digitado;
	}
}