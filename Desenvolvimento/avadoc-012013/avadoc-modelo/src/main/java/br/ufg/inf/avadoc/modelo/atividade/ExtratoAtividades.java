/**
 * 
 */
package br.ufg.inf.avadoc.modelo.atividade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.ufg.inf.avadoc.modelo.Docente;

/**
 * ExtratoAtividades
 * 
 * Extrato com atividades do docente (Radoc)
 */
@Entity
public class ExtratoAtividades implements Serializable {
	private static final long serialVersionUID = -7740600208068664832L;
	
	/**
	 * Id do extrato de atividades
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Docente avaliado
	 */
	@ManyToOne
	@JoinColumn(name="id_docente")
	private Docente docente;
	/**
	 * Data inicial das atividades
	 */
	@Temporal(TemporalType.DATE)
	private Date dataInicial;
	/**
	 * Data final das atividades
	 */
	@Temporal(TemporalType.DATE)
	private Date dataFinal;
	/**
	 * Atividades de ensino
	 */
	@ManyToOne
	@JoinColumn(name="id_docente")
	private AtividadeEnsino atividadeEnsino;
	/**
	 * Atividades de produção intelectual
	 */
	@OneToOne
	@JoinColumn(name = "id_producao_intelectual")
	private ProducaoIntelectual producaoIntelectual;
	/**
	 * Atividades de pesquisa e extensão
	 */
	private AtividadePesquisaExtensao atividadePesquisaExtensao;
	/**
	 * Atividades administrativas e de representação
	 */
	private AtividadeAdministrativaRepresentacao atividadeAdministrativaRepresentacao;
	/**
	 * Outras atividades
	 */
	private AtividadeOutra atividadeOutra;
	
	public ExtratoAtividades(){
	}
	
	/**
	 * Retorna Id do extrato
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Altera Id do extrato
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Retorna Docente avaliado
	 * @return docente
	 */
	public Docente getDocente() {
		return docente;
	}

	/**
	 * Altera docente avaliado
	 * @param docente
	 */
	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	/**
	 * Data inicial das atividades
	 * @return dataInicial
	 */
	public Date getDataInicial() {
		return dataInicial;
	}

	/**
	 * Altera data inicial das atividades
	 * @param dataInicial
	 */
	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	/**
	 * Data final das atividades
	 * @return dataFinal
	 */
	public Date getDataFinal() {
		return dataFinal;
	}

	/**
	 * Altera data final das atividades
	 * @param dataFinal
	 */
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	/**
	 * Atividades de ensino
	 * @return atividadeEnsino
	 */
	public AtividadeEnsino getAtividadeEnsino() {
		return atividadeEnsino;
	}

	/**
	 * Altera atividades de ensino
	 * @param atividadeEnsino
	 */
	public void setAtividadeEnsino(AtividadeEnsino atividadeEnsino) {
		this.atividadeEnsino = atividadeEnsino;
	}

	/**
	 * Atividades de produção intelectual
	 * @return producaoIntelectual
	 */
	public ProducaoIntelectual getProducaoIntelectual() {
		return producaoIntelectual;
	}

	/**
	 * Altera atividades de produção intelectual
	 * @param producaoIntelectual
	 */
	public void setProducaoIntelectual(ProducaoIntelectual producaoIntelectual) {
		this.producaoIntelectual = producaoIntelectual;
	}

	/**
	 * Atividades de pesquisa e extensão
	 * @return atividadePesquisaExtensao
	 */
	public AtividadePesquisaExtensao getAtividadePesquisaExtensao() {
		return atividadePesquisaExtensao;
	}

	/**
	 * Altera atividades de pesquisa e extensão
	 * @param atividadePesquisaExtensao
	 */
	public void setAtividadePesquisaExtensao(
			AtividadePesquisaExtensao atividadePesquisaExtensao) {
		this.atividadePesquisaExtensao = atividadePesquisaExtensao;
	}

	/**
	 * Atividades administrativas e de representação
	 * @return atividadeAdministrativaRepresentacao
	 */
	public AtividadeAdministrativaRepresentacao getAtividadeAdministrativaRepresentacao() {
		return atividadeAdministrativaRepresentacao;
	}

	/**
	 * Altera atividades administrativas e de representação
	 * @param atividadeAdministrativaRepresentacao
	 */
	public void setAtividadeAdministrativaRepresentacao(
			AtividadeAdministrativaRepresentacao atividadeAdministrativaRepresentacao) {
		this.atividadeAdministrativaRepresentacao = atividadeAdministrativaRepresentacao;
	}

	/**
	 * Outras atividades
	 * @return atividadeOutra
	 */
	public AtividadeOutra getAtividadeOutra() {
		return atividadeOutra;
	}

	/**
	 * Altera outras atividades
	 * @param atividadeOutra
	 */
	public void setAtividadeOutra(AtividadeOutra atividadeOutra) {
		this.atividadeOutra = atividadeOutra;
	}

	/**
	 * Retorna quantidade total de pontos
	 * @return pontos
	 */
	public int getPontos() {
		return atividadeEnsino.getPontos() + producaoIntelectual.getPontos()
				+ atividadePesquisaExtensao.getPontos()
				+ atividadeAdministrativaRepresentacao.getPontos()
				+ atividadeOutra.getPontos();
	}
}
