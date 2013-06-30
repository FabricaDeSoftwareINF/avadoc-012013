package br.ufg.inf.avadoc.modelo.atividade;

import java.io.Serializable;

import javax.persistence.Id;

/**
 * AtividadeOutra
 * 
 * Outras atividades
 * 
 */
public class AtividadeOutra implements IAtividade, Serializable {
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
	/**
	 * Id da atividade
	 */
	private Long id;
	
	public AtividadeOutra(){
		orientacao = new Producao();
		bancaCurso = new Producao();
		aprendizadoAperfeicoamento = new Producao();
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
		this.aprendizadoAperfeicoamento = aprendizadoAperfeicoamento;
	}

}
