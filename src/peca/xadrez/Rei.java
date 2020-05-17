package peca.xadrez;

import tabuleiro.Posicao;
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

	private boolean podeMover(Posicao posicao) {
		// se o rei pode mover para essa posicao
		PecaXadrez p = (PecaXadrez) getTabuleiro().piece(posicao);
		return p == null || p.getColor() != getColor();
		//ou casa vazia ou peca outro time
	}

	@Override
	public boolean[][] movimentosPossiveis() {

		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		Posicao p = new Posicao(0, 0);

		// para cima
		p.setValues(posicao.getLinha() - 1, posicao.getColuna());
		if (getTabuleiro().posicaoExistente(p) && podeMover(p)) {
			// entao pode se mover para essa posicao
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		// para baixo
		p.setValues(posicao.getLinha() + 1, posicao.getColuna());
		if (getTabuleiro().posicaoExistente(p) && podeMover(p)) {
			// entao pode se mover para essa posicao
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//para esquerda
		p.setValues(posicao.getLinha(), posicao.getColuna()-1);
		if (getTabuleiro().posicaoExistente(p) && podeMover(p)) {
		// entao pode se mover para essa posicao
		mat[p.getLinha()][p.getColuna()] = true;
		}
		//para direita
		p.setValues(posicao.getLinha(), posicao.getColuna()+1);
		if (getTabuleiro().posicaoExistente(p) && podeMover(p)) {
		// entao pode se mover para essa posicao
		mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//noroeste
		p.setValues(posicao.getLinha()-1, posicao.getColuna()-1);
		if (getTabuleiro().posicaoExistente(p) && podeMover(p)) {
		// entao pode se mover para essa posicao
		mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//nordeste
		p.setValues(posicao.getLinha()-1, posicao.getColuna()+1);
		if (getTabuleiro().posicaoExistente(p) && podeMover(p)) {
		// entao pode se mover para essa posicao
		mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//sudoeste

		p.setValues(posicao.getLinha()+1, posicao.getColuna()-1);
		if (getTabuleiro().posicaoExistente(p) && podeMover(p)) {
		// entao pode se mover para essa posicao
		mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//sudeste

		p.setValues(posicao.getLinha()+1, posicao.getColuna()+1);
		if (getTabuleiro().posicaoExistente(p) && podeMover(p)) {
		// entao pode se mover para essa posicao
		mat[p.getLinha()][p.getColuna()] = true;
		}


		// TODO Auto-generated method stub
		return mat;
	}

}
