package tabuleiro;

public class Piece {
	protected Posicao posicao;// a pe�a tem uma posicao
	// protect pois simples de matriz
	// a pe�a conhece o tabuleiro que est�
	private Tabuleiro tabuleiro;

	public Piece(Tabuleiro tabuleiro) {//posi��o no inicio � nula, por isso nao recebe position
		this.tabuleiro = tabuleiro;
		posicao = null;
	}

	protected Tabuleiro getTabuleiro() {//mesmo pacote ou subclasse poder�o acessar 
		return tabuleiro;
	}

	
}
