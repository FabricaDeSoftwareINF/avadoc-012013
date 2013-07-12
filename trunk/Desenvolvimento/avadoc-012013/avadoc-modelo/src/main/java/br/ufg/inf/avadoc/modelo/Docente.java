package br.ufg.inf.avadoc.modelo;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * Docente
 * 
 * Dados do docente
 * 
 */
@Entity
public class Docente extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1556372292607007986L;
	
	private String matricula;
	private String nome;
	
	public Docente(){
		matricula = "";
		nome = "";
	}

	/**
	 * Retorna matrícula do docente
	 * @return matricula
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * Altera matricula do docente
	 * @param matricula
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	/**
	 * Retorna o nome do docente
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Altera o nome do docente
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
}
