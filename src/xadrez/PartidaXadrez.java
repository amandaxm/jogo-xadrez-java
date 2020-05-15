package xadrez;

import tabuleiro.Tabuleiro;

public class PartidaXadrez {
 //coração do jogo
	private Tabuleiro tabuleiro;
	public PartidaXadrez() {
		//dizer o tamanho
		tabuleiro = new Tabuleiro(8,8);
	}
	//retornar uma matriz de peças de xadrez
	//correspondente a essa partida
	public PecaXadrez[][] getPecas(){
		// o tabuleiro tem as pecas
	PecaXadrez [][] matriz = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];	
	//percorrer a matriz de pecas do tabuleiro 	
	for (int i =0;i<tabuleiro.getLinhas();i++) {
		for (int j =0;j<tabuleiro.getColunas();j++) {
			matriz[i][j] = (PecaXadrez) tabuleiro.piece(i,j);
			
		}
	}
	return matriz;
	}
}
