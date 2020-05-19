package peca.xadrez;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.Color;
import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;

public class Peao extends PecaXadrez {
	private PartidaXadrez partidaXadrez;

	public Peao(Tabuleiro tabuleiro, Color color, PartidaXadrez partidaXadrez) {
		super(tabuleiro, color);
		this.partidaXadrez = partidaXadrez;
	}

	@Override
	public boolean[][] movimentosPossiveis() {

		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

		Posicao p = new Posicao(0, 0);

		if (getColor() == Color.WHITE) {
			// andar para cima
			p.setValues(posicao.getLinha() - 1, posicao.getColuna());
			// ir uma linha pra frente
			if (getTabuleiro().posicaoExistente(p) && !getTabuleiro().eUmaPeca(p)) {
				mat[p.getLinha()][p.getColuna()] = true;

				// se tiver vazio
			}
			p.setValues(posicao.getLinha() - 2, posicao.getColuna());
			// verificar se pode andar duas casas
			// verificar se a posicao 1 esta vazia
			Posicao p2 = new Posicao(posicao.getLinha() - 1, posicao.getColuna());
			if (getTabuleiro().posicaoExistente(p) && !getTabuleiro().eUmaPeca(p) && !getTabuleiro().eUmaPeca(p2)
					&& getMoveCount() == 0) {
				mat[p.getLinha()][p.getColuna()] = true;

			}
			// verificar para cima

			p.setValues(posicao.getLinha() - 1, posicao.getColuna() - 1);
			// ir uma linha pra frente
			if (getTabuleiro().posicaoExistente(p) && isThereOpponentPiece(p)) {
				mat[p.getLinha()][p.getColuna()] = true;

			}

			p.setValues(posicao.getLinha() - 1, posicao.getColuna() + 1);
			if (getTabuleiro().posicaoExistente(p) && isThereOpponentPiece(p)) {
				mat[p.getLinha()][p.getColuna()] = true;

			}

			if (posicao.getLinha() == 3) {

				Posicao left = new Posicao(posicao.getLinha(), posicao.getColuna() - 1);

				if (getTabuleiro().posicaoExistente(left) && isThereOpponentPiece(left)
						&& getTabuleiro().piece(left) == partidaXadrez.getEnPassantVulnerable()) {

					mat[left.getLinha() - 1][left.getColuna()] = true;

				}

				Posicao right = new Posicao(posicao.getLinha(), posicao.getColuna() + 1);

				if (getTabuleiro().posicaoExistente(right) && isThereOpponentPiece(right)
						&& getTabuleiro().piece(right) == partidaXadrez.getEnPassantVulnerable()) {

					mat[right.getLinha() - 1][right.getColuna()] = true;

				}

			}

		} else {
			// se for preta

			// andar para cima
			p.setValues(posicao.getLinha() + 1, posicao.getColuna());
			// ir uma linha pra frente
			if (getTabuleiro().posicaoExistente(p) && !getTabuleiro().eUmaPeca(p)) {
				mat[p.getLinha()][p.getColuna()] = true;

				// se tiver vazio
			}
			p.setValues(posicao.getLinha() + 2, posicao.getColuna());
			// verificar se pode andar duas casas
			// verificar se a posicao 1 esta vazia
			Posicao p2 = new Posicao(posicao.getLinha() + 1, posicao.getColuna());
			if (getTabuleiro().posicaoExistente(p) && !getTabuleiro().eUmaPeca(p) && !getTabuleiro().eUmaPeca(p2)
					&& getMoveCount() == 0) {
				mat[p.getLinha()][p.getColuna()] = true;

			}
			// verificar para cima

			p.setValues(posicao.getLinha() + 1, posicao.getColuna() - 1);
			// ir uma linha pra frente
			if (getTabuleiro().posicaoExistente(p) && isThereOpponentPiece(p)) {
				mat[p.getLinha()][p.getColuna()] = true;

			}

			p.setValues(posicao.getLinha() + 1, posicao.getColuna() + 1);
			if (getTabuleiro().posicaoExistente(p) && isThereOpponentPiece(p)) {
				mat[p.getLinha()][p.getColuna()] = true;

			}

			// #specialmove en passant black

			if (posicao.getLinha() == 4) {

			Posicao left = new Posicao(posicao.getLinha(), posicao.getColuna() - 1);

				if (getTabuleiro().posicaoExistente(left) && isThereOpponentPiece(left)
						&& getTabuleiro().piece(left) == partidaXadrez.getEnPassantVulnerable()) {

					mat[left.getLinha() + 1][left.getColuna()] = true;

				}

				Posicao right = new Posicao(posicao.getLinha(), posicao.getColuna() + 1);

				if (getTabuleiro().posicaoExistente(right) && isThereOpponentPiece(right)
						&& getTabuleiro().piece(right) == partidaXadrez.getEnPassantVulnerable()) {

					mat[right.getLinha() + 1][right.getColuna()] = true;

				}

			}

		}

		return mat;
	}

	@Override
	public String toString() {
		return "P";

	}

}
