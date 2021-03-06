package peca.xadrez;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.Color;
import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;

public class Rei extends PecaXadrez {
	private PartidaXadrez partidaXadrez;
	public Rei(Tabuleiro tabuleiro, Color color, PartidaXadrez partidaXadrez) {	
		
	super(tabuleiro, color);
	this.partidaXadrez=partidaXadrez;
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
	private boolean testeTorreRoque(Posicao position) {


		PecaXadrez p = (PecaXadrez)getTabuleiro().piece(position);


		return p != null && p instanceof Torre && p.getColor() == getColor() && p.getMoveCount() == 0;


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
		
		
		if (getMoveCount() == 0 && !partidaXadrez.getCheque()) {


			// #specialmove castling kingside rook


			Posicao posT1 = new Posicao(posicao.getLinha(), posicao.getColuna() + 3);


			if (testeTorreRoque(posT1)) {


				Posicao p1 = new Posicao(posicao.getLinha(), posicao.getColuna() + 1);


				Posicao p2 = new Posicao(posicao.getLinha(), posicao.getColuna() + 2);


				if (getTabuleiro().piece(p1) == null && getTabuleiro().piece(p2) == null) {


					mat[posicao.getLinha()][posicao.getColuna() + 2] = true;


				}


			}


			// #specialmove castling queenside rook


			Posicao posT2 = new Posicao(posicao.getLinha(), posicao.getColuna() - 4);


			if (testeTorreRoque(posT2)) {


				Posicao p1 = new Posicao(posicao.getLinha(), posicao.getColuna() - 1);


				Posicao p2 = new Posicao(posicao.getLinha(), posicao.getColuna() - 2);


				Posicao p3 = new Posicao(posicao.getLinha(), posicao.getColuna() - 3);


				if (getTabuleiro().piece(p1) == null && getTabuleiro().piece(p2) == null && getTabuleiro().piece(p3) == null) {


					mat[posicao.getLinha()][posicao.getColuna() - 2] = true;


				}


			}


		}
		// TODO Auto-generated method stub
		return mat;
	}

}
