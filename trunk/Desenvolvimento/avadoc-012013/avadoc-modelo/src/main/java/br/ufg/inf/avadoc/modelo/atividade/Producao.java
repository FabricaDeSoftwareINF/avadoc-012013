package br.ufg.inf.avadoc.modelo.atividade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * Producao
 * 
 * Representa o que foi produzido em uma subatividade.
 *
 */
@Entity
public class Producao implements Serializable{
	private static final long serialVersionUID = 3041614986590545497L;
	
	private List<Produto> produtos;
	private Long id;
	
	public Producao(){
		produtos = new ArrayList<Produto>();
	}
	
	/**
	 * Retorna Id
	 * @return id
	 */
	@Id
	public Long getId() {
		return id;
	}

	/**
	 * Altera Id
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
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
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="PRODUTO_ID")
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
