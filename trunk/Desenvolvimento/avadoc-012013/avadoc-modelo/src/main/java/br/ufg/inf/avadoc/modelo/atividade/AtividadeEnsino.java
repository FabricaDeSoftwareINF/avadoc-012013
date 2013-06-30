package br.ufg.inf.avadoc.modelo.atividade;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * AtividadeEnsino
 * 
 * Atividades de ensino
 * 
 */
@Entity
public class AtividadeEnsino implements IAtividade {
	/**
	 * Horas aula semanais para graduação presenciais.
	 */
	private int graduacaoHorasAulaSemanaisPresenciais;
	/**
	 * Horas aula semanais para graduação a distância.
	 */
	private int graduacaoHorasAulaSemanaisDistancia;
	/**
	 * Horas aula semanais para pós-graduação presenciais.
	 */
	private int posGradHorasAulaSemanaisPresenciais;
	/**
	 * Horas aula semanais para pós-graduação a distância.
	 */
	private int posGradHorasAulaSemanaisDistancia;
	/**
	 * Id da Atividade
	 */
	private Long id;
	
	public AtividadeEnsino(){
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

	/**
	 * Retorna pontuação referente à atividade.
	 * 
	 * @return (total de horas semanais) * 10
	 */
	@Override
	public int getPontos() {
		return 10 * (graduacaoHorasAulaSemanaisPresenciais
				+ graduacaoHorasAulaSemanaisDistancia
				+ posGradHorasAulaSemanaisPresenciais + posGradHorasAulaSemanaisDistancia);
	}

	/**
	 * Retorna pontuação referente à graduação.
	 * 
	 * @return (total de horas semanais) * 10
	 */
	public int getPontosGraduacao() {
		return 10 * (graduacaoHorasAulaSemanaisPresenciais + graduacaoHorasAulaSemanaisDistancia);
	}

	/**
	 * Retorna pontuação referente à pós-graduação.
	 * 
	 * @return (total de horas semanais) * 10
	 */
	public int getPontosPosGraduacao() {
		return 10 * (posGradHorasAulaSemanaisPresenciais + posGradHorasAulaSemanaisDistancia);
	}

	/**
	 * Horas aula semanais para graduação (Presenciais).
	 * 
	 * @return graduacaoHorasAulaSemanaisPresenciais
	 */
	public int getGraduacaoHorasAulaSemanaisPresenciais() {
		return graduacaoHorasAulaSemanaisPresenciais;
	}

	/**
	 * Altera quantidade de horas aula semanais presenciais para graduação. <BR>
	 * 
	 * Número equivalente de horas aula semanais (= nº de horas de aula no ano ÷
	 * 32 semanas)
	 * 
	 * @param graduacaoHorasAulaSemanaisPresenciais
	 */
	public void setGraduacaoHorasAulaSemanaisPresenciais(
			int graduacaoHorasAulaSemanaisPresenciais) {
		this.graduacaoHorasAulaSemanaisPresenciais = graduacaoHorasAulaSemanaisPresenciais;
	}

	/**
	 * Horas aula semanais para graduação (A distância).
	 * 
	 * @return graduacaoHorasAulaSemanaisDistancia
	 */
	public int getGraduacaoHorasAulaSemanaisDistancia() {
		return graduacaoHorasAulaSemanaisDistancia;
	}

	/**
	 * Altera quantidade de horas aula semanais a distância para graduação. <BR>
	 * 
	 * Número equivalente de horas aula semanais (= nº de horas de aula no ano ÷
	 * 32 semanas)
	 * 
	 * @param graduacaoHorasAulaSemanaisDistancia
	 */
	public void setGraduacaoHorasAulaSemanaisDistancia(
			int graduacaoHorasAulaSemanaisDistancia) {
		this.graduacaoHorasAulaSemanaisDistancia = graduacaoHorasAulaSemanaisDistancia;
	}

	/**
	 * Horas aula semanais para pós-graduação (Presenciais).
	 * 
	 * @return posGradHorasAulaSemanaisPresenciais
	 */
	public int getPosGradHorasAulaSemanaisPresenciais() {
		return posGradHorasAulaSemanaisPresenciais;
	}

	/**
	 * Altera quantidade de horas aula semanais presenciais para pós-graduação. <BR>
	 * 
	 * Número equivalente de horas aula semanais (= nº de horas de aula no ano ÷
	 * 32 semanas)
	 * 
	 * @param posGradHorasAulaSemanaisPresenciais
	 */
	public void setPosGradHorasAulaSemanaisPresenciais(
			int posGradHorasAulaSemanaisPresenciais) {
		this.posGradHorasAulaSemanaisPresenciais = posGradHorasAulaSemanaisPresenciais;
	}

	/**
	 * Horas aula semanais para pós-graduação (A distância).
	 * 
	 * @return posGradHorasAulaSemanaisDistancia
	 */
	public int getPosGradHorasAulaSemanaisDistancia() {
		return posGradHorasAulaSemanaisDistancia;
	}

	/**
	 * Altera quantidade de horas aula semanais a distância para pós-graduação. <BR>
	 * 
	 * Número equivalente de horas aula semanais (= nº de horas de aula no ano ÷
	 * 32 semanas)
	 * 
	 * @param posGradHorasAulaSemanaisDistancia
	 */
	public void setPosGradHorasAulaSemanaisDistancia(
			int posGradHorasAulaSemanaisDistancia) {
		this.posGradHorasAulaSemanaisDistancia = posGradHorasAulaSemanaisDistancia;
	}

}
