package application;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import xadrez.Color;
import xadrez.PartidaXadrez;

//import com.sun.prism.paint.Color;

import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;

public class Interface {

	// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

	public static final String ANSI_RESET = "\u001B[0m";

	public static final String ANSI_BLACK = "\u001B[30m";

	public static final String ANSI_RED = "\u001B[31m";

	public static final String ANSI_GREEN = "\u001B[32m";

	public static final String ANSI_YELLOW = "\u001B[33m";

	public static final String ANSI_BLUE = "\u001B[34m";

	public static final String ANSI_PURPLE = "\u001B[35m";

	public static final String ANSI_CYAN = "\u001B[36m";

	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";

	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";

	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";

	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";

	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";

	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";

	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";

	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

	// https://stackoverflow.com/questions/2979383/java-clear-the-console

	public static void clearScreen() {

		System.out.print("\033[H\033[2J");

		System.out.flush();

	}

	public static PosicaoXadrez lerPosicao(Scanner sc) {
		try {
			// letra e numero a2
			String s = sc.nextLine();
			char coluna = s.charAt(0);
			int linha = Integer.parseInt(s.substring(1));// pega a partir do segundo caracter
			return new PosicaoXadrez(coluna, linha);

		} catch (RuntimeException e) {// qualquer coisa que acontecer
			throw new InputMismatchException("Erro lendo a posição de Xadrez, valores válidos são de a1 até h8");// erro

		}

	}

	public static void imprimirPartida(PartidaXadrez partidaXadrez, List<PecaXadrez> capturada) {

		imprimeTabuleiro(partidaXadrez.getPecas());
		System.out.println();
		imprimirPecasCapturadas(capturada);
		System.out.println();
		System.out.println("Jogada: " + partidaXadrez.gerVez());
		System.out.println("Aguardando jogador: " + partidaXadrez.atualJogador());

	}

	public static void imprimeTabuleiro(PecaXadrez[][] pecas) {
		for (int i = 0; i < pecas.length; i++) {

			System.out.print((8 - i) + " ");

			for (int j = 0; j < pecas.length; j++) {

				imprimePeca(pecas[i][j], false);

			}

			System.out.println();

		}

		System.out.println("  a b c d e f g h");

	}

	public static void imprimeTabuleiro(PecaXadrez[][] pieces, boolean[][] possibleMoves) {

		for (int i = 0; i < pieces.length; i++) {

			System.out.print((8 - i) + " ");

			for (int j = 0; j < pieces.length; j++) {

				imprimePeca(pieces[i][j], possibleMoves[i][j]);

			}

			System.out.println();

		}

		System.out.println("  a b c d e f g h");

	}

	private static void imprimePeca(PecaXadrez piece, boolean background) {

		if (background) {

			System.out.print(ANSI_BLUE_BACKGROUND);

		}

		if (piece == null) {

			System.out.print("-" + ANSI_RESET);
		}

		else {

			if (piece.getColor() == Color.WHITE) {

				System.out.print(ANSI_WHITE + piece + ANSI_RESET);

			}

			else {

				System.out.print(ANSI_YELLOW + piece + ANSI_RESET);

			}

		}

		System.out.print(" ");

	}

	private static void imprimirPecasCapturadas(List<PecaXadrez> capturada) {
		List<PecaXadrez> white = capturada.stream().filter(x -> x.getColor() == Color.WHITE).collect(Collectors.toList());//filtrando as pecas com cor branca
		List<PecaXadrez> black = capturada.stream().filter(x -> x.getColor() == Color.BLACK).collect(Collectors.toList());//filtrando as pecas com cor branca

		System.out.println("Pecas capturadas: ");
		System.out.print("Brancas: ");
		System.out.print(ANSI_WHITE);
		System.out.print(Arrays.toString(white.toArray()));
		System.out.print(ANSI_RESET);
		System.out.println();
		System.out.print("Pretas: ");
		System.out.print(ANSI_YELLOW);
		System.out.print(Arrays.toString(black.toArray()));
		System.out.print(ANSI_RESET);
		
		
		
	}
}