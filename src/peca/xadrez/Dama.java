package peca.xadrez;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.Color;
import xadrez.PecaXadrez;

public class Dama extends PecaXadrez {

	public Dama(Tabuleiro tabuleiro, Color color) {
		super(tabuleiro, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "D";// vai entrar na hora de imprimir o tabuleiro

	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

		Posicao p = new Posicao(0, 0);

		// acima

		p.setValues(posicao.getLinha() - 1, posicao.getColuna());

		while (getTabuleiro().posicaoExistente(p) && !getTabuleiro().eUmaPeca(p)) {

			mat[p.getLinha()][p.getColuna()] = true;

			p.setLinha(p.getLinha() - 1);

		}

		if (getTabuleiro().posicaoExistente(p) && isThereOpponentPiece(p)) {

			mat[p.getLinha()][p.getColuna()] = true;

		}

		// left

		p.setValues(posicao.getLinha(), posicao.getColuna() - 1);

		while (getTabuleiro().posicaoExistente(p) && !getTabuleiro().eUmaPeca(p)) {

			mat[p.getLinha()][p.getColuna()] = true;

			p.setColuna(p.getColuna() - 1);

		}

		if (getTabuleiro().posicaoExistente(p) && isThereOpponentPiece(p)) {

			mat[p.getLinha()][p.getColuna()] = true;

		}

		// right

		p.setValues(posicao.getLinha(), posicao.getColuna() + 1);

		while (getTabuleiro().posicaoExistente(p) && !getTabuleiro().eUmaPeca(p)) {

			mat[p.getLinha()][p.getColuna()] = true;

			p.setColuna(p.getColuna() + 1);

		}

		if (getTabuleiro().posicaoExistente(p) && isThereOpponentPiece(p)) {

			mat[p.getLinha()][p.getColuna()] = true;

		}

		// below

		p.setValues(posicao.getLinha() + 1, posicao.getColuna());

		while (getTabuleiro().posicaoExistente(p) && !getTabuleiro().eUmaPeca(p)) {

			mat[p.getLinha()][p.getColuna()] = true;

			p.setLinha(p.getLinha() + 1);

		}

		if (getTabuleiro().posicaoExistente(p) && isThereOpponentPiece(p)) {

			mat[p.getLinha()][p.getColuna()] = true;

		}
		

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