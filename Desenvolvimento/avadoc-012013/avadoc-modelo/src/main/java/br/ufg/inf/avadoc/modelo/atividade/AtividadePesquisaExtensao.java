package br.ufg.inf.avadoc.modelo.atividade;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * AtividadePesquisaExtensao
 * 
 * Atividades e artefatos referentes a Pesquisa e Extensão
 * 
 */
@Entity
public class AtividadePesquisaExtensao implements IAtividade, Serializable {
	private static final long serialVersionUID = -7628360259213604614L;
	
	/**
	 * Atividades de pesquisa
	 */
	private Producao pesquisa;
	/**
	 * Atividades de Extensão
	 */
	private Producao extensao;
	/**
	 * Id da atividade
	 */
	private Long id;
	
	public AtividadePesquisaExtensao(){
		pesquisa = new Producao();
		extensao = new Producao();
	}
	
	/**
	 * Retorna Id da atividade
	 * @return id
	 */
	@Id
	public Long getId() {
		return id;
	}

	/**
	 * Altera Id da atividade
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int getPontos() {
		return pesquisa.getPontos() + extensao.getPontos();
	}

	/**
	 * Sub-atividade referente a atividades de pesquisa.
	 * 
	 * @return pesquisa
	 */
	public Producao getPesquisa() {
		return pesquisa;
	}

	/**
	 * Altera Sub-atividade referente a atividades de pesquisa.
	 * 
	 * @param pesquisa
	 */
	public void setPesquisa(Producao pesquisa) {
		this.pesquisa = pesquisa;
	}

	/**
	 * Sub-atividade referente a atividades de extensão.
	 * 
	 * @return extensao
	 */
	public Producao getExtensao() {
		return extensao;
	}

	/**
	 * Altera Sub-atividade referente a atividades de extensão.
	 * 
	 * @param extensao
	 */
	public void setExtensao(Producao extensao) {
		this.extensao = extensao;
	}
}
