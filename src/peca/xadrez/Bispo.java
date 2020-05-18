package peca.xadrez;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.Color;
import xadrez.PecaXadrez;

public class Bispo extends PecaXadrez {
	public Bispo(Tabuleiro tabuleiro, Color color) {
		super(tabuleiro, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "B";// vai entrar na hora de imprimir o tabuleiro

	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

		Posicao p = new Posicao(0, 0);

		// noroeste

		p.setValues(posicao.getLinha() - 1, posicao.getColuna()-1);

		while (getTabuleiro().posicaoExistente(p) && !getTabuleiro().eUmaPeca(p)) {

			mat[p.getLinha()][p.getColuna()] = true;

			p.setValues(p.getLinha() - 1, p.getColuna()-1);

		}

		if (getTabuleiro().posicaoExistente(p) && isThereOpponentPiece(p)) {

			mat[p.getLinha()][p.getColuna()] = true;

		}

		// nordeste

		p.setValues(posicao.getLinha()-1, posicao.getColuna() + 1);

		while (getTabuleiro().posicaoExistente(p) && !getTabuleiro().eUmaPeca(p)) {

			mat[p.getLinha()][p.getColuna()] = true;

			p.setValues(p.getLinha() - 1, p.getColuna()+1);

		}

		if (getTabuleiro().posicaoExistente(p) && isThereOpponentPiece(p)) {

			mat[p.getLinha()][p.getColuna()] = true;

		}

		// sudeste

		p.setValues(posicao.getLinha()+1, posicao.getColuna() + 1);

		while (getTabuleiro().posicaoExistente(p) && !getTabuleiro().eUmaPeca(p)) {

			mat[p.getLinha()][p.getColuna()] = true;

			p.setValues(p.getLinha() + 1, p.getColuna()+1);

		}

		if (getTabuleiro().posicaoExistente(p) && isThereOpponentPiece(p)) {

			mat[p.getLinha()][p.getColuna()] = true;

		}

		// sudoeste

		p.setValues(posicao.getLinha() + 1, posicao.getColuna()-1);

		while (getTabuleiro().posicaoExistente(p) && !getTabuleiro().eUmaPeca(p)) {

			mat[p.getLinha()][p.getColuna()] = true;

			p.setValues(p.getLinha() + 1, p.getColuna()-1);
		}

		if (getTabuleiro().posicaoExistente(p) && isThereOpponentPiece(p)) {

			mat[p.getLinha()][p.getColuna()] = true;

		}

		return mat;

	}

}

