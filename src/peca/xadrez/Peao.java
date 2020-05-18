package peca.xadrez;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.Color;
import xadrez.PecaXadrez;

public class Peao extends PecaXadrez {

	public Peao(Tabuleiro tabuleiro, Color color) {
		super(tabuleiro, color);
		
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

		Posicao p = new Posicao(0, 0);
		
		if(getColor() == Color.WHITE) {
			//andar para cima
			p.setValues(posicao.getLinha() -1, posicao.getColuna());
			//ir uma linha pra frente
			if(getTabuleiro().posicaoExistente(p) && !getTabuleiro().eUmaPeca(p)) {
				mat[p.getLinha()][p.getColuna()]= true;
				
			//se tiver vazio
			}
			p.setValues(posicao.getLinha() -2, posicao.getColuna());
			//verificar se pode andar duas casas
			//verificar se a posicao 1 esta vazia
			Posicao p2 = new Posicao(posicao.getLinha() -1, posicao.getColuna());
			if(getTabuleiro().posicaoExistente(p) && !getTabuleiro().eUmaPeca(p)  &&!getTabuleiro().eUmaPeca(p2)&& getMoveCount()==0) {
				mat[p.getLinha()][p.getColuna()]= true;
				
			
			}
			//verificar para cima
			
			p.setValues(posicao.getLinha() -1, posicao.getColuna()-1);
			//ir uma linha pra frente
			if(getTabuleiro().posicaoExistente(p) &&isThereOpponentPiece(p) ) {
				mat[p.getLinha()][p.getColuna()]= true;
				
			}
			
			p.setValues(posicao.getLinha() -1, posicao.getColuna()+1);
			if(getTabuleiro().posicaoExistente(p) &&isThereOpponentPiece(p) ) {
				mat[p.getLinha()][p.getColuna()]= true;
				
			}
			
		}else {
			//se for preta
			
			//andar para cima
			p.setValues(posicao.getLinha() +1, posicao.getColuna());
			//ir uma linha pra frente
			if(getTabuleiro().posicaoExistente(p) && !getTabuleiro().eUmaPeca(p)) {
				mat[p.getLinha()][p.getColuna()]= true;
				
			//se tiver vazio
			}
			p.setValues(posicao.getLinha() +2, posicao.getColuna());
			//verificar se pode andar duas casas
			//verificar se a posicao 1 esta vazia
			Posicao p2 = new Posicao(posicao.getLinha() +1, posicao.getColuna());
			if(getTabuleiro().posicaoExistente(p) && !getTabuleiro().eUmaPeca(p)  &&!getTabuleiro().eUmaPeca(p2)&& getMoveCount()==0) {
				mat[p.getLinha()][p.getColuna()]= true;
				
			
			}
			//verificar para cima
			
			p.setValues(posicao.getLinha() +1, posicao.getColuna()-1);
			//ir uma linha pra frente
			if(getTabuleiro().posicaoExistente(p) &&isThereOpponentPiece(p) ) {
				mat[p.getLinha()][p.getColuna()]= true;
				
			}
			
			p.setValues(posicao.getLinha() +1, posicao.getColuna()+1);
			if(getTabuleiro().posicaoExistente(p) &&isThereOpponentPiece(p) ) {
				mat[p.getLinha()][p.getColuna()]= true;
				
			}
			
			
		}
		
		return mat;
	}
	
	@Override
	public String toString() {
		return "P";
		
		
	}

}
