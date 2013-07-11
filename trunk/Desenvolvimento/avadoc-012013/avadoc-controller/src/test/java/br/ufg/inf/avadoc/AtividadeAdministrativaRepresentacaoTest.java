package br.ufg.inf.avadoc;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.ufg.inf.avadoc.modelo.atividade.AtividadeAdministrativaRepresentacao;
import br.ufg.inf.avadoc.modelo.atividade.Producao;
import br.ufg.inf.avadoc.xml.XmlAtividades;

public class AtividadeAdministrativaRepresentacaoTest {
	private AtividadeAdministrativaRepresentacao atividadeAdministrativaRepresentacao;
	@Before
	public void setUp() throws Exception {
		atividadeAdministrativaRepresentacao = new AtividadeAdministrativaRepresentacao();
	}

	@After
	public void tearDown() throws Exception {
		atividadeAdministrativaRepresentacao = null;
	}

	@Test
	public void testGetPontos() {
		Producao direcaoFuncaoGratificada = new Producao();
		direcaoFuncaoGratificada.getProdutos().add(XmlAtividades.getProduto("3", "DirecaoFuncaoGratificada"));
		
		Producao administrativa = new Producao();
		administrativa.getProdutos().add(XmlAtividades.getProduto("3", "AtividadeAdministrativa"));
		
		Producao outraAdministrativa = new Producao();
		outraAdministrativa.getProdutos().add(XmlAtividades.getProduto("3", "AtividadeAdministrativaOutra"));
		
		Producao representacaoFora = new Producao();
		representacaoFora.getProdutos().add(XmlAtividades.getProduto("2", "AtividadeRepresentacaoFora"));
		
		atividadeAdministrativaRepresentacao.setDirecaoFuncaoGratificada(direcaoFuncaoGratificada);
		atividadeAdministrativaRepresentacao.setAdministrativa(outraAdministrativa);
		atividadeAdministrativaRepresentacao.setOutraAdministrativa(outraAdministrativa);
		atividadeAdministrativaRepresentacao.setRepresentacaoFora(representacaoFora);
		
		assertEquals(30, atividadeAdministrativaRepresentacao.getPontos());
	}
	
}
