package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import xadrez.ExcecaoXadrez;
import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		PartidaXadrez partidaXadrez = new PartidaXadrez();

		// funcao para imprimir as pecas dessa partida
		while (true) {
			try {
				Interface.clearScreen();
				Interface.imprimeTabuleiro(partidaXadrez.getPecas());
				System.out.println();
				System.out.println("Origem: ");
				PosicaoXadrez origem = Interface.lerPosicao(sc);

				boolean[][] possibleMoves = partidaXadrez.possibleMoves(origem);
				Interface.clearScreen();
				// colorindo as possiveis posicoes
				Interface.imprimeTabuleiro(partidaXadrez.getPecas(), possibleMoves);

				System.out.println();
				System.out.println("Destino: ");
				PosicaoXadrez destino = Interface.lerPosicao(sc);

				PecaXadrez capturarPeca = partidaXadrez.executarMovimento(origem, destino);

			} catch (ExcecaoXadrez e) {
				System.out.println(e.getMessage());
				sc.nextLine();

			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();// aguardar pessoa pressionar tecla enter

			}
		}
	}

}
