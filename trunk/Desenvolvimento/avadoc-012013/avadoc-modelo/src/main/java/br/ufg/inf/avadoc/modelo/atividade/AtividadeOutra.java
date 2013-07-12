package br.ufg.inf.avadoc.modelo.atividade;

import java.io.Serializable;

import br.ufg.inf.avadoc.enums.EnumTipoAtividade;
import br.ufg.inf.avadoc.modelo.AbstractEntity;

/**
 * AtividadeOutra
 * 
 * Outras atividades
 * 
 */
public class AtividadeOutra extends AbstractEntity implements IAtividade, Serializable {
	private static final long serialVersionUID = 5832616413995668556L;

	/**
	 * Atividades Acadêmicas - Orientação
	 */
	private Producao orientacao;
	/**
	 * Atividades Acadêmicas – Bancas e Cursos
	 */
	private Producao bancaCurso;
	/**
	 * Atividades de Aprendizado e Aperfeiçoamento
	 */
	private Producao aprendizadoAperfeicoamento;
	
	public AtividadeOutra(){
		orientacao = new Producao();
		bancaCurso = new Producao();
		aprendizadoAperfeicoamento = new Producao();
	}
	
	@Override
	public int getPontos() {
		return orientacao.getPontos() + bancaCurso.getPontos()
				+ aprendizadoAperfeicoamento.getPontos();
	}

	/**
	 * Sub-atividade referente a atividades de orientação.
	 * 
	 * @return orientacao
	 */
	public Producao getOrientacao() {
		return orientacao;
	}

	/**
	 * Altera Sub-atividade referente a atividades de orientação.
	 * 
	 * @param orientacao
	 */
	public void setOrientacao(Producao orientacao) {
		orientacao.setTipoAtividade(EnumTipoAtividade.ATIVIDADE_OUTRA);
		this.orientacao = orientacao;
	}

	/**
	 * Sub-atividade referente a atividades de bancas e cursos.
	 * 
	 * @return bancaCurso
	 */
	public Producao getBancaCurso() {
		return bancaCurso;
	}

	/**
	 * Altera Sub-atividade referente a atividades de bancas e cursos.
	 * 
	 * @param bancaCurso
	 */
	public void setBancaCurso(Producao bancaCurso) {
		bancaCurso.setTipoAtividade(EnumTipoAtividade.ATIVIDADE_OUTRA);
		this.bancaCurso = bancaCurso;
	}

	/**
	 * Sub-atividade referente a atividades de aprendizado e aperfeiçoamento.
	 * 
	 * @return aprendizadoAperfeicoamento
	 */
	public Producao getAprendizadoAperfeicoamento() {
		return aprendizadoAperfeicoamento;
	}

	/**
	 * Altera Sub-atividade referente a atividades de aprendizado e
	 * aperfeiçoamento.
	 * 
	 * @param aprendizadoAperfeicoamento
	 */
	public void setAprendizadoAperfeicoamento(
			Producao aprendizadoAperfeicoamento) {
		aprendizadoAperfeicoamento.setTipoAtividade(EnumTipoAtividade.ATIVIDADE_OUTRA);
		this.aprendizadoAperfeicoamento = aprendizadoAperfeicoamento;
	}

}
