package application;

import java.util.Scanner;

import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		PartidaXadrez partidaXadrez = new PartidaXadrez();
		
		//funcao para imprimir as pecas dessa partida
		while(true) {
			
		
		Interface.imprimeTabuleiro(partidaXadrez.getPecas());
		System.out.println();
		System.out.println("Origem: ");
		PosicaoXadrez origem = Interface.lerPosicao(sc);
		
		System.out.println();
		System.out.println("Destino: ");
		PosicaoXadrez destino = Interface.lerPosicao(sc);
		
		PecaXadrez capturarPeca = partidaXadrez.executarMovimento(origem, destino);
		
		}
		}

}
