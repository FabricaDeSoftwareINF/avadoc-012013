package br.ufg.inf.avadoc.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.ufg.inf.avadoc.modelo.AbstractEntity;

/**
 * Classe responsavel por realizar as transaÃ§oes mais comuns no banco como
 * salvar uma entidade e remover uma entidade.
 * 
 * */

public class GenericDAO<T extends AbstractEntity> {

	/**
	 * Variavel estatica que armazena um appender
	 * 
	 * @see log4j.properties
	 * */
	private final Logger LOGGER = Logger.getLogger("avadoc");

	/**
	 * variavel estatica para um recurso que Ã© muito utilizado como obtencao do
	 * entityManager
	 * 
	 * @see {@link Conexao.obtemConexao()}
	 * */
	private final EntityManager obtem_conexao = Conexao.obtemConexao();

	private final Class<T> classe_persistente;

	@SuppressWarnings("unchecked")
	public GenericDAO() {
		Appender myAppender;
		LOGGER.setLevel(Level.ALL);
		// Define Appender
		myAppender = new ConsoleAppender(new SimpleLayout());
		// myAppender.setLayout(new SimpleLayout());
		LOGGER.addAppender(myAppender);

		this.classe_persistente = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 * Metodo que encerra uma conexao com o banco de dados.
	 * 
	 * */

	public void close() {
		obtem_conexao.close();
	}

	/**
	 * Este metodo salva uma entidade generica no banco de dados
	 * 
	 * @see Entidade
	 * @exception PersistenceException
	 * 
	 * */
	public void salvar(T entidade) {

		LOGGER.info("Obtendo conexÃ£o com o banco de dados...");

		try {

			obtem_conexao.getTransaction().begin();
			LOGGER.info("ConexÃ£o obtida.");

		} catch (Exception e1) {

			LOGGER.info("Ocorreu um problema de conexÃ£o: " + e1);

		}

		try {

			LOGGER.debug("Gravando entidade no banco - INÃ?CIO:");

			if (entidade.getId() == null) {

				obtem_conexao.persist(entidade);
				obtem_conexao.flush();

			} else {

				obtem_conexao.merge(entidade);

			}

			obtem_conexao.getTransaction().commit();

			LOGGER.debug("Gravando entidade no banco - FIM");

		} catch (PersistenceException e) {

			LOGGER.debug("Ocorreu um erro ao gravar a entidade: "
					+ entidade.getClass()
					+ "no banco de dados, fazendo Rollback...");
			LOGGER.info(e);

			obtem_conexao.getTransaction().rollback();

			LOGGER.debug("Rollback realizado!");

		} finally {
			close();
			LOGGER.info("ConexÃ£o com o banco encerrada");
		}
	}

	/**
	 * Este metodo exclui uma entidade generica do banco de dados
	 * 
	 * @see
	 * @exception PersistenceException
	 * 
	 * */

	public void excluir(T entidade) {

		LOGGER.info("Obtendo conexÃ£o com o banco de dados...");
		try {
			obtem_conexao.getTransaction().begin();
			LOGGER.info("ConexÃ£o obtida.");
		} catch (Exception e1) {
			LOGGER.info("Ocorreu um problema de conexÃ£o: " + e1);
		}
		try {
			LOGGER.debug("Excluindo entidade no banco - INÃ?CIO:");
			if (entidade.getId() == null) {
				obtem_conexao.remove(entidade);
			}

			obtem_conexao.getTransaction().commit();

			LOGGER.debug("Gravando entidade no banco - FIM");

		} catch (PersistenceException e) {

			LOGGER.debug("Ocorreu um erro ao gravar a entidade: "
					+ entidade.getClass()
					+ "no banco de dados, fazendo Rollback");
			LOGGER.info(e);
			obtem_conexao.getTransaction().rollback();

		} finally {
			close();
			LOGGER.info("ConexÃ£o com o banco encerrada");

		}

	}

	/**
	 * Este metodo retorna todos os objetos genericos de uma entidade especifica
	 * em uma lista do tipo Entidade. Util para consultar todos os registros e
	 * colocar em uma lista na tela
	 * 
	 * @return resultSet retorno da sql de busca em uma lista.
	 * */
	@SuppressWarnings("unchecked")
	public List<T> consultaTodos() {

		Session session = (Session) obtem_conexao.getDelegate();

		return session.createCriteria(classe_persistente).list();

	}

	@SuppressWarnings("unchecked")
	public T consultaPorId(int id) {
		Session session = (Session) obtem_conexao.getDelegate();

		return (T) session.createCriteria(classe_persistente)
				.add(Restrictions.eq("id", id)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public T consultaPorNome(String nome) {
		Session session = (Session) obtem_conexao.getDelegate();

		return (T) session.createCriteria(classe_persistente)
				.add(Restrictions.eq("nome", nome)).uniqueResult();

	}

}
