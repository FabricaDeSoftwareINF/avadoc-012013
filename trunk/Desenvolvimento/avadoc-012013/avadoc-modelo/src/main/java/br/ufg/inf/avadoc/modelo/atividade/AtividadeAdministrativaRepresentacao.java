package br.ufg.inf.avadoc.modelo.atividade;

/**
 * AtividadeAdministrativaRepresentacao
 * 
 * Atividades e artefatos referentes a atividades administrativas e de
 * representação
 * 
 */
public class AtividadeAdministrativaRepresentacao implements IAtividade {
	/**
	 * Atividades de direção ou de função gratificada
	 */
	private Producao direcaoFuncaoGratificada;
	/**
	 * Atividades administrativas
	 */
	private Producao administrativa;
	/**
	 * Outras atividades administrativas
	 */
	private Producao outraAdministrativa;
	/**
	 * Atividades de representação fora da UFG
	 */
	private Producao representacaoFora;
	
	public AtividadeAdministrativaRepresentacao(){
		direcaoFuncaoGratificada = new Producao();
		administrativa = new Producao();
		outraAdministrativa = new Producao();
		representacaoFora = new Producao();
	}

	@Override
	public int getPontos() {
		return direcaoFuncaoGratificada.getPontos()
				+ administrativa.getPontos() + outraAdministrativa.getPontos()
				+ representacaoFora.getPontos();
	}

	/**
	 * Sub-atividade referente a atividades de direção ou de função gratificada
	 * 
	 * @return direcaoFuncaoGratificada
	 */
	public Producao getDirecaoFuncaoGratificada() {
		return direcaoFuncaoGratificada;
	}

	/**
	 * Altera Sub-atividade referente a atividades de direção ou de função
	 * gratificada
	 * 
	 * @param direcaoFuncaoGratificada
	 */
	public void setDirecaoFuncaoGratificada(Producao direcaoFuncaoGratificada) {
		this.direcaoFuncaoGratificada = direcaoFuncaoGratificada;
	}

	/**
	 * Sub-atividade referente a atividades administrativas
	 * 
	 * @return administrativa
	 */
	public Producao getAdministrativa() {
		return administrativa;
	}

	/**
	 * Altera Sub-atividade referente a atividades administrativas
	 * 
	 * @param administrativa
	 */
	public void setAdministrativa(Producao administrativa) {
		this.administrativa = administrativa;
	}

	/**
	 * Sub-atividade referente a outros tipos de atividades administrativas ou
	 * de representação
	 * 
	 * @return outraAdministrativa
	 */
	public Producao getOutraAdministrativa() {
		return outraAdministrativa;
	}

	/**
	 * Altera Sub-atividade referente a outros tipos de atividades
	 * administrativas ou de representação
	 * 
	 * @param outraAdministrativa
	 */
	public void setOutraAdministrativa(Producao outraAdministrativa) {
		this.outraAdministrativa = outraAdministrativa;
	}

	/**
	 * Sub-atividade referente a atividades de representação fora da UFG
	 * 
	 * @return representacaoFora
	 */
	public Producao getRepresentacaoFora() {
		return representacaoFora;
	}

	/**
	 * Altera Sub-atividade referente a atividades de representação fora da UFG
	 * 
	 * @param representacaoFora
	 */
	public void setRepresentacaoFora(Producao representacaoFora) {
		this.representacaoFora = representacaoFora;
	}

}
