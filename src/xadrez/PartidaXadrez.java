package xadrez;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import peca.xadrez.Bispo;
import peca.xadrez.Cavalo;
import peca.xadrez.Dama;
import peca.xadrez.Peao;
import peca.xadrez.Rei;
import peca.xadrez.Torre;
import tabuleiro.Piece;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public class PartidaXadrez {
	// cora��o do jogo
	private int vez;
	private Color atualJogador;
	private Tabuleiro tabuleiro;
	private List<Piece> pecasNoTabuleiro = new ArrayList<>();
	private List<Piece> pecasCapturadas = new ArrayList<>();
	private boolean cheque;// inicia com false
	private boolean chequeMate;

	public PartidaXadrez() {
		// dizer o tamanho
		// crio o tabuleiro e inicia o jogo
		tabuleiro = new Tabuleiro(8, 8);
		vez = 1;
		atualJogador = Color.WHITE;
		iniciarJogo();
	}

	public boolean getCheque() {
		return cheque;

	}

	public boolean getChequeMate() {
		return chequeMate;

	}

	public int gerVez() {
		return vez;
	}

	public Color atualJogador() {
		return atualJogador;
	}

	// retornar uma matriz de pe�as de xadrez
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

	public boolean[][] possibleMoves(PosicaoXadrez posicaoOrigem) {
		Posicao posicao = posicaoOrigem.toPosition();
		// validar posicao
		// imprimir posicao de
		posicaoOrigemValida(posicao);
		return tabuleiro.piece(posicao).movimentosPossiveis();
	}

	public PecaXadrez executarMovimento(PosicaoXadrez atualPosicao, PosicaoXadrez posicaoDestino) {

		Posicao atual = atualPosicao.toPosition();
		Posicao destino = posicaoDestino.toPosition();
		posicaoOrigemValida(atual);
		posicaoDestinoValida(atual, destino);

		Piece pecaCapturada = fazerMovimento(atual, destino);
		// testar se jogador se colocou em cheque
		if (testarCheque(atualJogador)) {
			desfazerMovimento(atual, destino, pecaCapturada);
			throw new ExcecaoXadrez("Voce nao pode colocar seu rei em cheque :)");

		}
		// testar se o oponente ficou em cheque
		cheque = (testarCheque(oponente(atualJogador))) ? true : false;

		// testar se ficou em cheque mate
		if (testarChequeMate(oponente(atualJogador))) {
			chequeMate = true;
		} else {
			nextTurn();

		}
		return (PecaXadrez) pecaCapturada;

		// validar posicao
		// makemove realizar movimento

	}

	private Piece fazerMovimento(Posicao atual, Posicao destino) {
		PecaXadrez p = (PecaXadrez) tabuleiro.removePiece(atual);
		// remover possivel peca que esteja na posicao de destino
		p.increaseMoveCount();

		Piece pecaCapturada = tabuleiro.removePiece(destino);
		tabuleiro.lugarPeca(p, destino);
		// tira da origem poe no destino
		if (pecaCapturada != null) {
			pecasNoTabuleiro.remove(pecaCapturada);
			pecasCapturadas.add(pecaCapturada);
		}
		return pecaCapturada;
	}

	private void desfazerMovimento(Posicao origem, Posicao destino, Piece pecaCapturada) {
		PecaXadrez p = (PecaXadrez) tabuleiro.removePiece(destino);

		tabuleiro.lugarPeca(p, origem);// devolve peca para posi��o de origem
		if (pecaCapturada != null) {
			// se tiver capturado alguma peca devlver
			tabuleiro.lugarPeca(pecaCapturada, origem);
			pecasCapturadas.remove(pecaCapturada);
			pecasNoTabuleiro.add(pecaCapturada);
		}

	}

	private void posicaoOrigemValida(Posicao posicao) {
		if (!tabuleiro.eUmaPeca(posicao)) {
			throw new ExcecaoXadrez("Nao existe um peca aqui");

		}

		if (atualJogador != ((PecaXadrez) tabuleiro.piece(posicao)).getColor()) {
			// peca adversaria, nao pode move-la
			throw new ExcecaoXadrez("A peca escolhida nao e sua");

		}

		// se nao tiver nenhum movimento possivel

		if (!tabuleiro.piece(posicao).eUmMovimentoPossivel()) {
			throw new ExcecaoXadrez("Nao existe movimentos possiveis para essa peca");

		}

	}

	public boolean[][] movimentosPossiveis(PosicaoXadrez sourcePosition) {

		Posicao position = sourcePosition.toPosition();

		posicaoOrigemValida(position);

		return tabuleiro.piece(position).movimentosPossiveis();

	}

	private void posicaoDestinoValida(Posicao atual, Posicao destino) {
		if (!tabuleiro.piece(atual).possivelMovimento(destino)) {
			// se para a peca de origem o destino nao � um movimento possivel
			// nao posso mexer para la
			throw new ExcecaoXadrez("A peca de origem nao pode se mover para o destino");

		}

	}

	private void nextTurn() {
		vez++;
		atualJogador = (atualJogador == Color.WHITE) ? Color.BLACK : Color.WHITE;

	}

	private Color oponente(Color color) {
		return (color == Color.WHITE) ? Color.BLACK : Color.WHITE;

	}

	private PecaXadrez rei(Color color) {
		List<Piece> list = pecasNoTabuleiro.stream().filter(x -> ((PecaXadrez) x).getColor() == color)
				.collect(Collectors.toList());
		for (Piece p : list) {
			if (p instanceof Rei) {
				return (PecaXadrez) p;
			}

		}
		throw new IllegalStateException("Nao existe o rei " + color + " no tabuleiro");

	}

	private boolean testarCheque(Color color) {
		// pegar posicao do rei no formato de matriz
		Posicao posicaoRei = rei(color).getPosicaoXadrez().toPosition();
		List<Piece> pecasOponentes = pecasNoTabuleiro.stream()
				.filter(x -> ((PecaXadrez) x).getColor() == oponente(color)).collect(Collectors.toList());

		// se tem alguma peca que leva a posicao do p
		for (Piece p : pecasOponentes) {
			boolean[][] mat = p.movimentosPossiveis();
			if (mat[posicaoRei.getLinha()][posicaoRei.getColuna()]) {
				return true;// o rei esta em cheque
			}

		}
		return false;

	}

	private boolean testarChequeMate(Color color) {
		// testar se esta em cheque primeiro
		if (!testarCheque(color)) {
			return false;
		}
		// todas as pecas dessa cor, ver se podem salvar o rei

		List<Piece> list = pecasNoTabuleiro.stream().filter(x -> ((PecaXadrez) x).getColor() == color)
				.collect(Collectors.toList());
		for (Piece p : list) {

			boolean[][] mat = p.movimentosPossiveis();
			for (int i = 0; i < tabuleiro.getLinhas(); i++) {
				for (int j = 0; j < tabuleiro.getColunas(); j++) {
					// se for movimento possivel
					if (mat[i][j]) {
						// tira do cheque
						Posicao origem = ((PecaXadrez) p).getPosicaoXadrez().toPosition();
						Posicao destino = new Posicao(i, j);
						Piece pecaCapturada = fazerMovimento(origem, destino);
						// movimentado, testar se esta em cheque ainda
						boolean testarCheque = testarCheque(color);
						desfazerMovimento(origem, destino, pecaCapturada);
						// se nao estava em cheque, entao nao e cheque mate
						if (!testarCheque) {
							return false;
						}
					}

				}
			}
		}
		return true;
	}

	private void placeNewPiece(char coluna, int linha, PecaXadrez peca) {
		tabuleiro.lugarPeca(peca, new PosicaoXadrez(coluna, linha).toPosition());
		pecasNoTabuleiro.add(peca);
	}

	private void iniciarJogo() {
		placeNewPiece('h', 7, new Torre(tabuleiro, Color.WHITE));

		placeNewPiece('c', 1, new Bispo(tabuleiro, Color.WHITE));

		placeNewPiece('e', 1, new Rei(tabuleiro, Color.WHITE));

		placeNewPiece('e', 2, new Peao(tabuleiro, Color.WHITE));

		placeNewPiece('d', 1, new Dama(tabuleiro, Color.WHITE));

		placeNewPiece('b', 1, new Cavalo(tabuleiro, Color.WHITE));

		placeNewPiece('b', 8, new Torre(tabuleiro, Color.BLACK));

		placeNewPiece('a', 8, new Rei(tabuleiro, Color.BLACK));

		placeNewPiece('c', 8, new Bispo(tabuleiro, Color.BLACK));

	}

}
