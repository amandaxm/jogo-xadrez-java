package tabuleiro;

public class Tabuleiro {
	public int linhas;
	public int colunas;
	// tera uma matriz de peças

	private Piece[][] pecas;

	public Tabuleiro(int linhas, int colunas) {
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Piece[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public void setLinhas(int linhas) {
		this.linhas = linhas;
	}

	public int getColunas() {
		return colunas;
	}

	public void setColunas(int colunas) {
		this.colunas = colunas;
	}

	public Piece piece(int linha, int coluna) {
		// retorna matriz pecas na linha e coluna
		return pecas[linha][coluna];

	}
	
	public Piece piece(Posicao posicao) {
		return pecas[posicao.getLinha()][posicao.getColuna()];
		
		
	}
}
