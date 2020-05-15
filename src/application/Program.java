package application;

import xadrez.PartidaXadrez;

public class Program {

	public static void main(String[] args) {

		PartidaXadrez partidaXadrez = new PartidaXadrez();
		
		//funcao para imprimir as pecas dessa partida
		Interface.imprimeTabuleiro(partidaXadrez.getPecas());
	}

}
