package br.ufg.inf.avadoc.persistencia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.Before;
import org.junit.Test;

import br.ufg.inf.avadoc.modelo.Docente;
import br.ufg.inf.avadoc.modelo.Usuario;
import br.ufg.inf.avadoc.modelo.atividade.AtividadeAdministrativaRepresentacao;
import br.ufg.inf.avadoc.modelo.atividade.AtividadeEnsino;
import br.ufg.inf.avadoc.modelo.atividade.AtividadeOutra;
import br.ufg.inf.avadoc.modelo.atividade.AtividadePesquisaExtensao;
import br.ufg.inf.avadoc.modelo.atividade.ExtratoAtividades;
import br.ufg.inf.avadoc.modelo.atividade.Producao;
import br.ufg.inf.avadoc.modelo.atividade.ProducaoIntelectual;
import br.ufg.inf.avadoc.modelo.atividade.Produto;
import br.ufg.inf.avadoc.persistencia.dao.ExtratoAtividadesDAO;
import br.ufg.inf.avadoc.persistencia.dao.UsuarioDAO;
import br.ufg.inf.avadoc.persistencia.impl.ExtratoAtividadesDAOImpl;
import br.ufg.inf.avadoc.persistencia.impl.UsuarioDAOImpl;
import br.ufg.inf.avadoc.xml.XmlExtratoAtividades;

public class DAOTest {
	private SessionFactory sessionFactory;
	
	private static SessionFactory buildSessionFactory() {
        try {
        	try{
			Connection Conn = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/?user=postgres&password=postgres");
			Statement s = Conn.createStatement();
			s.executeUpdate("CREATE DATABASE avadoc");
        	} catch (Exception e){
            	System.err.println(e.getMessage());
        	}

        		AnnotationConfiguration configuration = new AnnotationConfiguration();
        		configuration.addAnnotatedClass(Usuario.class);
        		configuration.setProperty("hibernate.dialect",
        				"org.hibernate.dialect.PostgreSQLDialect");
        		configuration.setProperty("hibernate.connection.driver_class",
        				"org.postgresql.Driver");
        		configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost/avadoc");
        		configuration.setProperty("hibernate.connection.username", "postgres");
        		configuration.setProperty("hibernate.connection.password", "postgres");
        		configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        		configuration.addAnnotatedClass(Docente.class);
        		configuration.addAnnotatedClass(AtividadeAdministrativaRepresentacao.class);
        		configuration.addAnnotatedClass(AtividadeEnsino.class);
        		configuration.addAnnotatedClass(AtividadeOutra.class);
        		configuration.addAnnotatedClass(AtividadePesquisaExtensao.class);
        		configuration.addAnnotatedClass(ProducaoIntelectual.class);
        		configuration.addAnnotatedClass(Producao.class);
        		configuration.addAnnotatedClass(Produto.class);
        		configuration.addAnnotatedClass(ExtratoAtividades.class);
        		
        		System.out.println("Postgres");
                return configuration.buildSessionFactory();
        }
        catch (Throwable ex) {
			try {
				Connection Conn = DriverManager
						.getConnection("jdbc:mysql://localhost/?user=root&password=admin");
				Statement s = Conn.createStatement();
				s.executeUpdate("CREATE DATABASE avadoc");
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
        	AnnotationConfiguration configuration = new AnnotationConfiguration();
    		configuration.addAnnotatedClass(Usuario.class);
    		configuration.setProperty("hibernate.dialect",
    				"org.hibernate.dialect.MySQLDialect");
    		configuration.setProperty("hibernate.connection.driver_class",
    				"com.mysql.jdbc.Driver");
    		configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost/avadoc");
    		configuration.setProperty("hibernate.connection.username", "root");
    		configuration.setProperty("hibernate.connection.password", "admin");
    		configuration.setProperty("hibernate.hbm2ddl.auto", "update");
    		configuration.addAnnotatedClass(Docente.class);
    		configuration.addAnnotatedClass(AtividadeAdministrativaRepresentacao.class);
    		configuration.addAnnotatedClass(AtividadeEnsino.class);
    		configuration.addAnnotatedClass(AtividadeOutra.class);
    		configuration.addAnnotatedClass(AtividadePesquisaExtensao.class);
    		configuration.addAnnotatedClass(ProducaoIntelectual.class);
    		configuration.addAnnotatedClass(Producao.class);
    		configuration.addAnnotatedClass(Produto.class);
    		configuration.addAnnotatedClass(ExtratoAtividades.class);
    		
    		System.out.println("MySql");
            return configuration.buildSessionFactory();	
        }
    }

	@Before
	public void setUp() throws Exception {
		sessionFactory = buildSessionFactory();
	}

	@Test
	public void inserirUsuarioTest() {
		UsuarioDAO dao = new UsuarioDAOImpl(sessionFactory);
		Usuario u = new Usuario();
		u.setNome("usuario teste");
		dao.inserir(u);
		dao.salvar(u);
		List<Usuario> list = (List<Usuario>) dao.listar();
		assertNotNull(list);
		assertEquals("usuario teste", list.get(0).getNome());
	}
	
	@Test
	public void inserirExtratoAtividadesTest() {
		ExtratoAtividadesDAO dao = new ExtratoAtividadesDAOImpl(sessionFactory);
		ExtratoAtividades extratoAtividades = new ExtratoAtividades();
		extratoAtividades = exemploExtrato();
		dao.inserir(extratoAtividades);
		dao.salvar(extratoAtividades);
		List<ExtratoAtividades> list = (List<ExtratoAtividades>) dao.listar();
		
		ExtratoAtividades extrato = list.get(0);
		
		assertNotNull(list);
		
		AtividadeEnsino atividadeEnsino = extrato.getAtividadeEnsino();
		ProducaoIntelectual producaoIntelectual = extrato
				.getProducaoIntelectual();
		AtividadePesquisaExtensao atividadePesquisaExtensao = extrato
				.getAtividadePesquisaExtensao();
		AtividadeAdministrativaRepresentacao atividadeAdministrativaRepresentacao = extrato
				.getAtividadeAdministrativaRepresentacao();
		AtividadeOutra atividadeOutra = extrato.getAtividadeOutra();
		
		assertNotNull(extrato);
		
		assertEquals("12345", extrato.getDocente().getMatricula());
		
		assertEquals(200, atividadeEnsino.getPontosGraduacao());
		assertEquals(200, atividadeEnsino.getPontosPosGraduacao());
		assertEquals(400, atividadeEnsino.getPontos());
		
		assertEquals(66, producaoIntelectual.getProducaoCientifica().getPontos());
		assertEquals(38, producaoIntelectual.getProducaoArtisticaCultural().getPontos());
		assertEquals(54, producaoIntelectual.getProducaoTecnicaTecnologica().getPontos());
		assertEquals(9, producaoIntelectual.getProducaoOutra().getPontos());
		assertEquals(167, producaoIntelectual.getPontos());
		
		assertEquals(30, atividadePesquisaExtensao.getPesquisa().getPontos());
		assertEquals(25, atividadePesquisaExtensao.getExtensao().getPontos());
		assertEquals(55, atividadePesquisaExtensao.getPontos());
		
		assertEquals(120, atividadeAdministrativaRepresentacao.getDirecaoFuncaoGratificada().getPontos());
		assertEquals(14, atividadeAdministrativaRepresentacao.getAdministrativa().getPontos());
		assertEquals(71, atividadeAdministrativaRepresentacao.getOutraAdministrativa().getPontos());
		assertEquals(18, atividadeAdministrativaRepresentacao.getRepresentacaoFora().getPontos());
		assertEquals(223, atividadeAdministrativaRepresentacao.getPontos());
		
		assertEquals(28, atividadeOutra.getOrientacao().getPontos());
		assertEquals(6, atividadeOutra.getBancaCurso().getPontos());
		assertEquals(13, atividadeOutra.getAprendizadoAperfeicoamento().getPontos());
		assertEquals(47, atividadeOutra.getPontos());
		
		assertEquals(892, extrato.getPontos());
	}

	private ExtratoAtividades exemploExtrato(){
		String xml = null;

		try {
			InputStream inputStream = ClassLoader
					.getSystemResourceAsStream("exemploExtratoXML.xml");
			xml = IOUtils.toString(inputStream);
			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return XmlExtratoAtividades.getExtrato(xml);
	}
}
