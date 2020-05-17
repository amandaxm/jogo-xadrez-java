package tabuleiro;

public class Posicao {
	private Integer linha;
	private Integer coluna;

	public Posicao() {
	}

	public Posicao(Integer linha, Integer coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}

	public Integer getLinha() {
		return linha;
	}

	public void setLinha(Integer linha) {
		this.linha = linha;
	}

	public Integer getColuna() {
		return coluna;
	}

	public void setColuna(Integer coluna) {
		this.coluna = coluna;
	}
	//atualizar os valores de uma posicao
	public void setValues(int linha, int coluna) {
		this.coluna=coluna;
		this.linha=linha;
		
		
	}

	@Override
	public String toString() {// retorna a posição
		return linha + ", " + coluna;
	}

}
