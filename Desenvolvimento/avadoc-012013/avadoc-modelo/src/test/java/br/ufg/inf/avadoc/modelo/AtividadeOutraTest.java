package br.ufg.inf.avadoc.modelo;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.ufg.inf.avadoc.modelo.atividade.AtividadeOutra;
import br.ufg.inf.avadoc.modelo.atividade.Producao;
import br.ufg.inf.avadoc.modelo.xml.XmlAtividades;

public class AtividadeOutraTest {
	private AtividadeOutra atividadeOutra;
	@Before
	public void setUp() throws Exception {
		atividadeOutra = new AtividadeOutra();
	}

	@After
	public void tearDown() throws Exception {
		atividadeOutra = null;
	}

	@Test
	public void testGetPontos() {
		Producao orientacao = new Producao();
		orientacao.getProdutos().add(XmlAtividades.getProduto("13", "Orientacao"));
		
		Producao bancaCurso = new Producao();
		bancaCurso.getProdutos().add(XmlAtividades.getProduto("6.1", "BancaCurso"));
		
		Producao aprendizadoAperfeicoamento = new Producao();
		aprendizadoAperfeicoamento.getProdutos().add(XmlAtividades.getProduto("5", "AtividadeAprendizadoAperfeicoamento"));
		
		atividadeOutra.setOrientacao(orientacao);
		atividadeOutra.setBancaCurso(bancaCurso);
		atividadeOutra.setAprendizadoAperfeicoamento(aprendizadoAperfeicoamento);
		
		assertEquals(11, atividadeOutra.getPontos());
	}
	
}
