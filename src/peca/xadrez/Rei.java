package peca.xadrez;

import tabuleiro.Tabuleiro;
import xadrez.Color;
import xadrez.PecaXadrez;

public class Rei extends PecaXadrez {

	public Rei(Tabuleiro tabuleiro, Color color) {
		super(tabuleiro, color);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "K";// vai entrar na hora de imprimir o tabuleiro

	}

}