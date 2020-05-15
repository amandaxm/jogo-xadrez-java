package tabuleiro;

public class Tabuleiro {
	public int linhas;
	public int colunas;
	// tera uma matriz de pe�as

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
	public void lugarPeca(Piece peca, Posicao posicao) {
	//essa matriz na posi��o dada atribuir a peca no tabuleiro
	pecas[posicao.getLinha()][posicao.getColuna()] = peca;
	//tirar da posicao nulo
	peca.posicao= posicao;//acessivel diretamente protected classe no mesmo pacote acesso livre
	
	
		
		
	}
}
