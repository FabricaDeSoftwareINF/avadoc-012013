package br.ufg.inf.avadoc.modelo.atividade;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Produto
 * 
 * Item produzido pelo docente.
 *
 */
@Entity
public class Produto implements Serializable {
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
	 * Id do produto.
	 */
	private Long id;
	
	public Produto(){
	}
	
	/**
	 * Retorna Id do produto
	 * @return id
	 */
	@Id
	public Long getId() {
		return id;
	}

	/**
	 * Altera Id do produto
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * Retorna o código do artefato/atividade.
	 * @return codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	
	/**
	 * Altera o código do artefato/atividade.
	 * @param codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * Retorna pontos do produto.
	 * @return pontos
	 */
	public int getPontos() {
		return pontos;
	}
	
	/**
	 * Altera pontos do produto.
	 * @param pontos
	 */
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
	/**
	 * Retorna o máximo de pontos que o artefato/atividade pode ter. 
	 * @return
	 */
	public int getPontuacaoMaxima() {
		return pontuacaoMaxima;
	}

	/**
	 * Altera a pontuação máxima do artefato/atividade. 
	 * @param pontuacaoMaxima
	 */
	public void setPontuacaoMaxima(int pontuacaoMaxima) {
		this.pontuacaoMaxima = pontuacaoMaxima;
	}
}
