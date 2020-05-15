package xadrez;

import peca.xadrez.Rei;
import peca.xadrez.Torre;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public class PartidaXadrez {
	// coração do jogo
	private Tabuleiro tabuleiro;

	public PartidaXadrez() {
		// dizer o tamanho
		// crio o tabuleiro e inicia o jogo
		tabuleiro = new Tabuleiro(8, 8);
		iniciarJogo();
	}

	// retornar uma matriz de peças de xadrez
	// correspondente a essa partida
	public PecaXadrez[][] getPecas() {
		// o tabuleiro tem as pecas
		PecaXadrez[][] matriz = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		// percorrer a matriz de pecas do tabuleiro
		for (int i = 0; i < tabuleiro.getLinhas(); i++) {
			for (int j = 0; j < tabuleiro.getColunas(); j++) {
				matriz[i][j] = (PecaXadrez) tabuleiro.piece(i, j);

			}
		}
		return matriz;
	}

	private void placeNewPiece(char coluna, int linha, PecaXadrez peca) {
		tabuleiro.lugarPeca(peca, new PosicaoXadrez(coluna, linha).toPosition());

	}

	private void iniciarJogo() {
		placeNewPiece('b', 6, new Torre(tabuleiro, Color.WHITE));
		placeNewPiece('e', 8, new Rei(tabuleiro, Color.BLACK));
		placeNewPiece('e', 1, new Rei(tabuleiro, Color.WHITE));

	}
}
