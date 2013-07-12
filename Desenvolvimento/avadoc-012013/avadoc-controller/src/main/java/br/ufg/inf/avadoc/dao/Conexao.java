package br.ufg.inf.avadoc.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 * Esta classe e responsavel por criar as conexoes com o banco de dados apartir da definicao
 * da unidade de peristencia.
 * 
 * 
 * */

public class Conexao {


	@PersistenceContext(type = PersistenceContextType.TRANSACTION)
	static EntityManager emSisloc;
	static EntityManagerFactory emfAvadoc;


	/**
	 * Este metodo retorna um entityManager para obtencao de conexoes com o banco
	 * possibilitando interação com as operacoes fornecidas pelo hibernate e JPA
	 * @see EntityManager
	 * @return {@link EntityManager}
	 * */
	public static EntityManager obtemConexao(){
		try {
			//instanciando unidade de persistencia
			emfAvadoc = Persistence.createEntityManagerFactory("avadoc");
			//criando conexao com a unidade de persistencia
			emSisloc = emfAvadoc.createEntityManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emSisloc;
	}

}
