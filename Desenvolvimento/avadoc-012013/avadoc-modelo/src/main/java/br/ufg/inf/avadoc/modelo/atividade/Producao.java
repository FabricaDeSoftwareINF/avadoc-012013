package br.ufg.inf.avadoc.modelo.atividade;

import java.util.ArrayList;
import java.util.List;

/**
 * Producao
 * 
 * Representa o que foi produzido em uma subatividade.
 *
 */
public class Producao {
	private List<Produto> produtos;
	
	public Producao(){
		produtos = new ArrayList<Produto>();
	}
	
	/**
	 * Total de pontos
	 * @return pontos
	 */
	public int getPontos(){
		int pontos = 0;
		for (Produto p : produtos)
			pontos += p.getPontos();

		return pontos;
	}
	
	/**
	 * Lista de produtos
	 * @return lista
	 */
	public List<Produto> getProdutos() {
		return produtos;
	}
	
	/**
	 * Altera lista de produtos
	 * @param produtos
	 */
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
}
