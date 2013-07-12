package br.ufg.inf.avadoc.dao;

import javax.persistence.PersistenceContext;

import br.ufg.inf.avadoc.modelo.Docente;

public class DocenteDAO extends GenericDAO<Docente> {
	@PersistenceContext (unitName = "docente")

	/**
	 * Este metodo salva um objeto do tipo {@link Docente} utilizando o
	 * metodo generico da classe {@link GenericDAO}
	 * @see GenericDAO
	 * 
	 * */
	@Override
	public void salvar (Docente docente){
		super.salvar(docente);
	}

	/**
	 * Este metodo exclui um objeto do tipo {@link Docente} pelo id
	 * utilizando o metodo generico da classe {@link GenericDAO}
	 * @see GenericDAO
	 * 
	 * */
	public void excluir (int id){
		Docente T = consultaPorId(id);
		super.excluir(T);
	}

	public Docente pesquisarPorNome (String nome){
		Docente resultado = consultaPorNome(nome);
		return resultado;
	}

}
