package br.ufg.inf.avadoc.modelo.atividade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.ufg.inf.avadoc.enums.EnumTipoProducao;

/**
 * Producao
 * 
 * Representa o que foi produzido em uma subatividade.
 * 
 */
@Entity
public class Producao implements Serializable {

	private static final long serialVersionUID = 3041614986590545497L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "producaos")
	private List<Produto> produtos;
	
	@Enumerated(EnumType.STRING)
	private EnumTipoProducao tipoProducao;

	public Producao() {
		produtos = new ArrayList<Produto>();
	}

	/**
	 * Retorna Id
	 * 
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Altera Id
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Total de pontos
	 * 
	 * @return pontos
	 */
	public int getPontos() {
		int pontos = 0;
		for (Produto p : produtos)
			pontos += p.getPontos();

		return pontos;
	}

	/**
	 * Lista de produtos
	 * 
	 * @return lista
	 */

	public List<Produto> getProdutos() {
		return produtos;
	}

	/**
	 * Altera lista de produtos
	 * 
	 * @param produtos
	 */
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public EnumTipoProducao getTipoProducao() {
		return tipoProducao;
	}

	public void setTipoProducao(EnumTipoProducao tipoProducao) {
		this.tipoProducao = tipoProducao;
	}
	
}
