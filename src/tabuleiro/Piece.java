package tabuleiro;

public class Piece {
	protected Posicao posicao;// a peça tem uma posicao
	// protect pois simples de matriz
	// a peça conhece o tabuleiro que está
	private Tabuleiro tabuleiro;

	public Piece(Tabuleiro tabuleiro) {//posição no inicio é nula, por isso nao recebe position
		this.tabuleiro = tabuleiro;
		posicao = null;
	}

	protected Tabuleiro getTabuleiro() {//mesmo pacote ou subclasse poderão acessar 
		return tabuleiro;
	}

	
}
