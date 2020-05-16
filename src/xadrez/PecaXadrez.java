package xadrez;

import tabuleiro.Piece;
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

	
}
