package br.ufg.inf.avadoc.modelo.atividade;

/**
 * AtividadePesquisaExtensao
 * 
 * Atividades e artefatos referentes a Pesquisa e Extensão
 * 
 */
public class AtividadePesquisaExtensao implements IAtividade {
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
