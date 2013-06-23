package br.ufg.inf.avadoc.modelo.atividade;

/**
 * Produto
 * 
 * Item produzido pelo docente.
 *
 */
public class Produto {
	/**
	 * Código do artefato/atividade.
	 */
	private String codigo;
	/**
	 * Pontos do produto.
	 */
	private int pontos;
	
	/**
	 * Retorna o código do artefato/atividade.
	 * @return codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	
	/**
	 * Altera o código do artefato/atividade.
	 * @param codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * Retorna pontos do produto.
	 * @return pontos
	 */
	public int getPontos() {
		return pontos;
	}
	
	/**
	 * Altera pontos do produto.
	 * @param pontos
	 */
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", pontos=" + pontos + "]";
	}
}
