package peca.xadrez;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.Color;
import xadrez.PecaXadrez;

public class Cavalo extends PecaXadrez{
	public Cavalo(Tabuleiro tabuleiro, Color color) {
		super(tabuleiro, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "C";// vai entrar na hora de imprimir o tabuleiro

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

		
		p.setValues(posicao.getLinha() - 1, posicao.getColuna()-2);
		if (getTabuleiro().posicaoExistente(p) && podeMover(p)) {
			// entao pode se mover para essa posicao
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		
		p.setValues(posicao.getLinha() -2, posicao.getColuna()-1);
		if (getTabuleiro().posicaoExistente(p) && podeMover(p)) {
			// entao pode se mover para essa posicao
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		p.setValues(posicao.getLinha()-2, posicao.getColuna()+1);
		if (getTabuleiro().posicaoExistente(p) && podeMover(p)) {
		// entao pode se mover para essa posicao
		mat[p.getLinha()][p.getColuna()] = true;
		}
		p.setValues(posicao.getLinha()-1, posicao.getColuna()+2);
		if (getTabuleiro().posicaoExistente(p) && podeMover(p)) {
		mat[p.getLinha()][p.getColuna()] = true;
		}
		
		p.setValues(posicao.getLinha()+1, posicao.getColuna()+2);
		if (getTabuleiro().posicaoExistente(p) && podeMover(p)) {
		mat[p.getLinha()][p.getColuna()] = true;
		}
		
		p.setValues(posicao.getLinha()+2, posicao.getColuna()+1);
		if (getTabuleiro().posicaoExistente(p) && podeMover(p)) {
		mat[p.getLinha()][p.getColuna()] = true;
		}
		
		
		p.setValues(posicao.getLinha()+2, posicao.getColuna()-1);
		if (getTabuleiro().posicaoExistente(p) && podeMover(p)) {
		mat[p.getLinha()][p.getColuna()] = true;
		}
		
		p.setValues(posicao.getLinha()+1, posicao.getColuna()-2);
		if (getTabuleiro().posicaoExistente(p) && podeMover(p)) {
		// entao pode se mover para essa posicao
		mat[p.getLinha()][p.getColuna()] = true;
		}


		return mat;
	}

}


