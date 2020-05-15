package tabuleiro;

public class Tabuleiro {
	public int linhas;
	public int colunas;
	// tera uma matriz de pe�as

	private Piece[][] pecas;

	public Tabuleiro(int linhas, int colunas) {
		// quantidade de linhas e colunas deve ser pelo menos 1
		if (linhas < 1 || colunas < 1) {

			throw new ExcecaoTabuleiro("Tabuleiro deve ter pelo menos 1 linha e 1 coluna");
		}
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Piece[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}

	public Piece piece(int linha, int coluna) {
		// retorna matriz pecas na linha e coluna
		if(!posicaoExistente(linha,coluna)) {
			//se essa posi��o nao exitir
			throw new ExcecaoTabuleiro("Posi��o n�o existe no tabuleiro");
		}
		
		return pecas[linha][coluna];

	}

	public Piece piece(Posicao posicao) {
		if(!posicaoExistente(posicao)) {
			//se essa posi��o nao exitir
			throw new ExcecaoTabuleiro("Posi��o n�o existe no tabuleiro");
		}
		
		
		return pecas[posicao.getLinha()][posicao.getColuna()];

	}

	public void lugarPeca(Piece peca, Posicao posicao) {
		//testar se j� existe uma pe�a nessa posi��o
		if(eUmaPeca(posicao)) {
			throw new ExcecaoTabuleiro("J� existe uma pe�a aqui!" +posicao);
			
		}
		
		// essa matriz na posi��o dada atribuir a peca no tabuleiro
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		// tirar da posicao nulo
		peca.posicao = posicao;// acessivel diretamente protected classe no mesmo pacote acesso livre

	}

	private boolean posicaoExistente(int linha, int coluna) {
		// tem que estar dentro do tabuleiro
		// maior que zero e menor que a quantidade de col/lin do tabuleiro
		return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
	}

	private boolean posicaoExistente(Posicao posicao) {
//testa se existe
		return posicaoExistente(posicao.getLinha(), posicao.getColuna());
	}

	public boolean eUmaPeca(Posicao posicao) {
		//verificar se a posi��o existe primeiro
		if(!posicaoExistente(posicao)) {
			//se essa posi��o nao exitir
			throw new ExcecaoTabuleiro("Posi��o n�o existe no tabuleiro");
		}
		
		return piece(posicao) != null;// se posicao diferente de null
		// tem uma peca nessa posi��o

	}
}
