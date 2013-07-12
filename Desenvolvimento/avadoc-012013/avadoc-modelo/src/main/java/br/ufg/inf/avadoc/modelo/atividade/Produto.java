package br.ufg.inf.avadoc.modelo.atividade;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.ufg.inf.avadoc.modelo.AbstractEntity;

/**
 * Produto
 * 
 * Item produzido pelo docente.
 * 
 */
@Entity
public class Produto extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 5401913319005557356L;
	/**
	 * Código do artefato/atividade.
	 */
	private String codigo;
	/**
	 * Pontos do produto.
	 */
	private int pontos;
	/**
	 * Pontuação máxima do artefato/atividade
	 */
	private int pontuacaoMaxima;

	/**
	 * Produção a qual o produto faz parte
	 */
	@ManyToOne
	@JoinColumn(name = "id_producao")
	private Producao producao;

	public Produto() {
	}

	/**
	 * Retorna o código do artefato/atividade.
	 * 
	 * @return codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Altera o código do artefato/atividade.
	 * 
	 * @param codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Retorna pontos do produto.
	 * 
	 * @return pontos
	 */
	public int getPontos() {
		return pontos;
	}

	/**
	 * Altera pontos do produto.
	 * 
	 * @param pontos
	 */
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	/**
	 * Retorna o máximo de pontos que o artefato/atividade pode ter.
	 * 
	 * @return
	 */
	public int getPontuacaoMaxima() {
		return pontuacaoMaxima;
	}

	/**
	 * Altera a pontuação máxima do artefato/atividade.
	 * 
	 * @param pontuacaoMaxima
	 */
	public void setPontuacaoMaxima(int pontuacaoMaxima) {
		this.pontuacaoMaxima = pontuacaoMaxima;
	}
	
	/**
	 * Retorna Produção relacionada ao produto
	 * @return
	 */
	public Producao getProducao() {
		return producao;
	}

	/**
	 * Altera a produção que o produto faz parte
	 * @param producao
	 */
	public void setProducao(Producao producao) {
		this.producao = producao;
	}
}
