package peca.xadrez;

import tabuleiro.Tabuleiro;
import xadrez.Color;
import xadrez.PecaXadrez;

public class Torre extends PecaXadrez {

	public Torre(Tabuleiro tabuleiro, Color color) {
		super(tabuleiro, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "R";// vai entrar na hora de imprimir o tabuleiro

	}

	@Override
	public boolean[][] movimentosPossiveis() {

		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

		// TODO Auto-generated method stub
		return mat;
	}

}
