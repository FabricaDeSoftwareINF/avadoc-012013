package br.ufg.inf.avadoc.modelo.atividade;

import java.io.Serializable;

import javax.persistence.Entity;

import br.ufg.inf.avadoc.enums.EnumTipoAtividade;
import br.ufg.inf.avadoc.modelo.AbstractEntity;

/**
 * AtividadePesquisaExtensao
 * 
 * Atividades e artefatos referentes a Pesquisa e Extensão
 * 
 */
@Entity
public class AtividadePesquisaExtensao extends AbstractEntity implements IAtividade, Serializable {
	private static final long serialVersionUID = -7628360259213604614L;

	/**
	 * Atividades de pesquisa
	 */
	private Producao pesquisa;
	/**
	 * Atividades de Extensão
	 */
	private Producao extensao;
	
	
	public AtividadePesquisaExtensao(){
		pesquisa = new Producao();
		extensao = new Producao();
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
		pesquisa.setTipoAtividade(EnumTipoAtividade.ATIVIDADE_PESQUISA_EXTENSAO);
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
		extensao.setTipoAtividade(EnumTipoAtividade.ATIVIDADE_PESQUISA_EXTENSAO);
		this.extensao = extensao;
	}
}
