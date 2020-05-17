package xadrez;

import peca.xadrez.Rei;
import peca.xadrez.Torre;
import tabuleiro.Piece;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public class PartidaXadrez {
	// coração do jogo
	private Tabuleiro tabuleiro;

	public PartidaXadrez() {
		// dizer o tamanho
		// crio o tabuleiro e inicia o jogo
		tabuleiro = new Tabuleiro(8, 8);
		iniciarJogo();
	}

	// retornar uma matriz de peças de xadrez
	// correspondente a essa partida
	public PecaXadrez[][] getPecas() {
		// o tabuleiro tem as pecas
		PecaXadrez[][] matriz = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		// percorrer a matriz de pecas do tabuleiro
		for (int i = 0; i < tabuleiro.getLinhas(); i++) {
			for (int j = 0; j < tabuleiro.getColunas(); j++) {
				matriz[i][j] = (PecaXadrez) tabuleiro.piece(i, j);

			}
		}
		return matriz;
	}
	
	public boolean [][] possibleMoves(PosicaoXadrez posicaoOrigem){
		Posicao posicao = posicaoOrigem.toPosition();
		//validar posicao
		//imprimir posicao de 
		posicaoOrigemValida(posicao);
		return tabuleiro.piece(posicao).movimentosPossiveis();
	}
	public PecaXadrez executarMovimento(PosicaoXadrez atualPosicao, PosicaoXadrez posicaoDestino) {
		
		Posicao atual = atualPosicao.toPosition();
		Posicao destino = posicaoDestino.toPosition();
		posicaoOrigemValida(atual);
		posicaoDestinoValida(atual,destino);
		
		Piece pecaCapturada = fazerMovimento(atual,destino);
		return (PecaXadrez)pecaCapturada;
		
		//validar posicao
		//makemove realizar movimento
		
	}
	
	private Piece fazerMovimento(Posicao atual, Posicao destino ) {
		Piece p = tabuleiro.removePiece(atual);
		//remover possivel peca que esteja na posicao de destino
		Piece pecaCapturada = tabuleiro.removePiece(destino);
		tabuleiro.lugarPeca(p, destino);
		return pecaCapturada;
	}
	
	private void posicaoOrigemValida(Posicao posicao) {
		if(!tabuleiro.eUmaPeca(posicao)) {
			throw new ExcecaoXadrez("Nao existe um peca aqui");
			
		}//se nao tiver nenhum movimento possivel
		if(!tabuleiro.piece(posicao).eUmMovimentoPossivel()) {
			throw new ExcecaoXadrez("Nao existe movimentos possiveis para essa peca");
			
			
		}
		
	}
	
	public boolean[][] movimentosPossiveis (PosicaoXadrez sourcePosition) {

		Posicao position = sourcePosition.toPosition();

		posicaoOrigemValida(position);

		return tabuleiro.piece(position).movimentosPossiveis();

	}
	private void posicaoDestinoValida(Posicao atual, Posicao destino){
		if(!tabuleiro.piece(atual).possivelMovimento(destino)) {
			//se para a peca de origem o destino nao é um movimento possivel
			//nao posso mexer  para la
			throw new ExcecaoXadrez("A peca de origem nao pode se mover para o destino");
			
		}
	
	} 
	
	
	private void placeNewPiece(char coluna, int linha, PecaXadrez peca) {
		tabuleiro.lugarPeca(peca, new PosicaoXadrez(coluna, linha).toPosition());

	}

	private void iniciarJogo() {
		placeNewPiece('c', 1, new Torre(tabuleiro, Color.WHITE));

		placeNewPiece('c', 2, new Torre(tabuleiro, Color.WHITE));

		placeNewPiece('d', 2, new Torre(tabuleiro, Color.WHITE));

		placeNewPiece('e', 2, new Torre(tabuleiro, Color.WHITE));

		placeNewPiece('e', 1, new Torre(tabuleiro, Color.WHITE));

		placeNewPiece('d', 1, new Rei(tabuleiro, Color.WHITE));

		placeNewPiece('c', 7, new Torre(tabuleiro, Color.BLACK));

		placeNewPiece('c', 8, new Torre(tabuleiro, Color.BLACK));

		placeNewPiece('d', 7, new Torre(tabuleiro, Color.BLACK));

		placeNewPiece('e', 7, new Torre(tabuleiro, Color.BLACK));

		placeNewPiece('e', 8, new Torre(tabuleiro, Color.BLACK));

		placeNewPiece('d', 8, new Rei(tabuleiro, Color.BLACK));

	}
	
}
