package tabuleiro;

public abstract class Piece {
	protected Posicao posicao;// a peça tem uma posicao
	// protect pois simples de matriz
	// a peça conhece o tabuleiro que está
	private Tabuleiro tabuleiro;

	public Piece(Tabuleiro tabuleiro) {// posição no inicio é nula, por isso nao recebe position
		this.tabuleiro = tabuleiro;
		posicao = null;
	}

	protected Tabuleiro getTabuleiro() {// mesmo pacote ou subclasse poderão acessar
		return tabuleiro;
	}

	public abstract boolean[][] movimentosPossiveis();

	public boolean possivelMovimento(Posicao posicao) {

		// retornar os possiveis movimenttos
		return movimentosPossiveis()[posicao.getLinha()][posicao.getColuna()];

	}

	public boolean eUmMovimentoPossivel() {

		boolean[][] mat = movimentosPossiveis();
		// percorrer ´pra ver se existe alguma opcao de movimento
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				// se nessa posição for true é possivel fazer o moviento
				if (mat[i][j]) {
					return true;
				}

			}
		}

		return false;
	}
}
