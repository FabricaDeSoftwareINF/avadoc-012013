package br.ufg.inf.avadoc.enums;


public enum EnumTipoAtividade {
	/**
	 * Atividade de ensino
	 */
	ATIVIDADE_ENSINO("AtividadeEnsino"),
	/**
	 * Produção intelectual
	 */
	PRODUCAO_INTELECTUAL("ProducaoIntelectual"),
	/**
	 * Atividade de pesquisa e extensão
	 */
	ATIVIDADE_PESQUISA_EXTENSAO("AtividadePesquisaExtensao"),
	/**
	 * Atividade administrativa e de representação
	 */
	ATIVIDADE_ADMINISTRATIVA_REPRESENTACAO("AtividadeAdministrativaRepresentacao"),
	/**
	 * Outro tipo de atividade
	 */
	ATIVIDADE_OUTRA("AtividadeOutra");

	private String key;
	
	private EnumTipoAtividade(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
}
