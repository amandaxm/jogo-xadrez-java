package xadrez;

import tabuleiro.Piece;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public abstract class PecaXadrez extends Piece {
	
	private Color color;
	private int moveCount;

	public PecaXadrez(Tabuleiro tabuleiro, Color color) {
		super(tabuleiro);
		this.color = color;
	}
	public PosicaoXadrez getPosicaoXadrez() {
		
		return PosicaoXadrez.paraPosicao(posicao);
	}
	public Color getColor() {
		return color;
	}
	public int getMoveCount() {
		return moveCount;
	}
	public void increaseMoveCount() {
		moveCount++;
		
	}
	
	public void decreaseMoveCount() {
		moveCount--;
		
	}
	
	protected boolean isThereOpponentPiece(Posicao posicao) {
		//pegar peça que está nessa posição
		PecaXadrez p = (PecaXadrez)getTabuleiro().piece(posicao);
		return p != null && p.getColor() != color; 
		//se nao for vazio e a cor da peca for diferente 
		//é uma peca adversária
	}

	
}
