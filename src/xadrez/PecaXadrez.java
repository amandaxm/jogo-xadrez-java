package xadrez;

import tabuleiro.Piece;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public abstract class PecaXadrez extends Piece {
	
	private Color color;

	public PecaXadrez(Tabuleiro tabuleiro, Color color) {
		super(tabuleiro);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
	protected boolean isThereOpponentPiece(Posicao posicao) {
		//pegar peça que está nessa posição
		PecaXadrez p = (PecaXadrez)getTabuleiro().piece(posicao);
		return p != null && p.getColor() != color; 
		//se nao for vazio e a cor da peca for diferente 
		//é uma peca adversária
	}

	
}
