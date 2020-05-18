package xadrez;

import tabuleiro.Posicao;

public class PosicaoXadrez {
	private char coluna;
	private int linha;

	public PosicaoXadrez(char coluna, int linha) {
		if (coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8) {

			throw new ExcecaoXadrez("Erro, posicoes de a/h e 1/8");
		}
		this.coluna=coluna;
		this.linha=linha;

	}

	public char getColuna() {
		return coluna;
	}

	public int getLinha() {
		return linha;
	}

	protected Posicao toPosition() {
		// converte a b em posicao 5 6
		return new Posicao(8 - linha, coluna - 'a');

	}

	protected static PosicaoXadrez paraPosicao(Posicao posicao) {

		return new PosicaoXadrez((char) ('a' + posicao.getColuna()), 8 - posicao.getLinha());

	}
	@Override
	public String toString() {
		//imprimir coluna linha
		return ""+ coluna+ linha;
		
	}

}
