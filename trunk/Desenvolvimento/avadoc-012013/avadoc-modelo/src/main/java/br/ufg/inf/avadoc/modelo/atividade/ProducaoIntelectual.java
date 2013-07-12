package br.ufg.inf.avadoc.modelo.atividade;

import java.io.Serializable;

import javax.persistence.Entity;

import br.ufg.inf.avadoc.enums.EnumTipoAtividade;
import br.ufg.inf.avadoc.modelo.AbstractEntity;

/**
 * ProducaoIntelectual
 * 
 * Atividades e artefatos referentes a Produção Intelectual
 * 
 */
@Entity
public class ProducaoIntelectual extends AbstractEntity implements IAtividade, Serializable {
	private static final long serialVersionUID = -8781139957824478900L;

	/**
	 * Produçao Científica
	 */
	private Producao producaoCientifica;
	/**
	 * Produção Artística e Cultural
	 */
	private Producao producaoArtisticaCultural;
	/**
	 * Produção Técnica e Tecnológica
	 */
	private Producao producaoTecnicaTecnologica;
	/**
	 * Outros tipos de produção
	 */
	private Producao producaoOutra;

	@Override
	public int getPontos() {
		return producaoCientifica.getPontos()
				+ producaoArtisticaCultural.getPontos()
				+ producaoTecnicaTecnologica.getPontos()
				+ producaoOutra.getPontos();
	}

	/**
	 * Sub-atividade referente a produção científica.
	 * 
	 * @return producaoCientifica
	 */
	public Producao getProducaoCientifica() {
		return producaoCientifica;
	}

	/**
	 * Altera Sub-atividade referente a produção científica.
	 * 
	 * @param producaoCientifica
	 */
	public void setProducaoCientifica(Producao producaoCientifica) {
		producaoCientifica.setTipoAtividade(EnumTipoAtividade.PRODUCAO_INTELECTUAL);
		this.producaoCientifica = producaoCientifica;
	}

	/**
	 * Sub-atividade referente a produção artística e cultural.
	 * 
	 * @return producaoArtisticaCultural
	 */
	public Producao getProducaoArtisticaCultural() {
		return producaoArtisticaCultural;
	}

	/**
	 * Altera Sub-atividade referente a produção artística e cultural.
	 * 
	 * @param producaoArtisticaCultural
	 */
	public void setProducaoArtisticaCultural(Producao producaoArtisticaCultural) {
		producaoArtisticaCultural.setTipoAtividade(EnumTipoAtividade.PRODUCAO_INTELECTUAL);
		this.producaoArtisticaCultural = producaoArtisticaCultural;
	}

	/**
	 * Sub-atividade referente a produção técnica e tecnológica.
	 * 
	 * @return producaoTecnicaTecnologica
	 */
	public Producao getProducaoTecnicaTecnologica() {
		return producaoTecnicaTecnologica;
	}

	/**
	 * Altera Sub-atividade referente a produção técnica e tecnológica.
	 * 
	 * @param producaoTecnicaTecnologica
	 */
	public void setProducaoTecnicaTecnologica(
			Producao producaoTecnicaTecnologica) {
		producaoTecnicaTecnologica.setTipoAtividade(EnumTipoAtividade.PRODUCAO_INTELECTUAL);
		this.producaoTecnicaTecnologica = producaoTecnicaTecnologica;
	}

	/**
	 * Sub-atividade referente a outros tipos de produção.
	 * 
	 * @return producaoOutra
	 */
	public Producao getProducaoOutra() {
		return producaoOutra;
	}

	/**
	 * Altera Sub-atividade referente a outros tipos de produção.
	 * 
	 * @param producaoOutra
	 */
	public void setProducaoOutra(Producao producaoOutra) {
		producaoOutra.setTipoAtividade(EnumTipoAtividade.PRODUCAO_INTELECTUAL);
		this.producaoOutra = producaoOutra;
	}

}
