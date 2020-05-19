package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import xadrez.ExcecaoXadrez;
import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		PartidaXadrez partidaXadrez = new PartidaXadrez();
		List<PecaXadrez> capturada = new ArrayList<>();
		// funcao para imprimir as pecas dessa partida
		
		while (!partidaXadrez.getChequeMate()) {
			try {
				Interface.clearScreen();
				Interface.imprimirPartida(partidaXadrez, capturada);
				System.out.println();
				System.out.print("Origem: ");
				PosicaoXadrez origem = Interface.lerPosicao(sc);

				boolean[][] possibleMoves = partidaXadrez.possibleMoves(origem);
				Interface.clearScreen();
				// colorindo as possiveis posicoes
				Interface.imprimeTabuleiro(partidaXadrez.getPecas(), possibleMoves);

				System.out.println();
				System.out.println("Destino: ");
				PosicaoXadrez destino = Interface.lerPosicao(sc);

				PecaXadrez capturarPeca = partidaXadrez.executarMovimento(origem, destino);

				if(capturarPeca != null) {
					capturada.add(capturarPeca);
				}
				if(partidaXadrez.getPromocao()!= null) {
					
				System.out.println("Entre com a peca para promocao (B/C/D/T): ");
				String tipo= sc.nextLine();
				partidaXadrez.substituirPecaPromovida(tipo);
				
				}
			} catch (ExcecaoXadrez e) {
				System.out.println(e.getMessage());
				sc.nextLine();

			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();// aguardar pessoa pressionar tecla enter

			}
		}
		Interface.clearScreen();
		Interface.imprimirPartida(partidaXadrez, capturada);
		
	}

}
