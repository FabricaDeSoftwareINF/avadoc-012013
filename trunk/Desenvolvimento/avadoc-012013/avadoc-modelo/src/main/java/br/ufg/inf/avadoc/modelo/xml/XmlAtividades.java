package br.ufg.inf.avadoc.modelo.xml;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import br.ufg.inf.avadoc.enums.EnumTipoProducao;
import br.ufg.inf.avadoc.modelo.atividade.Produto;

/**
 * XmlAtividades
 * 
 * Auxilia na leitura das atividades e pontuações contidas no arquivo
 * 'atividadesPontuacao.xml'.
 * 
 */
public class XmlAtividades {
	/**
	 * Constante para produção científica para se procurar a pontuação de uma
	 * atividade
	 */
	public static final String PRODUCAO_CIENTIFICA = "ProducaoCientifica";
	/**
	 * Constante para produção artística para se procurar a pontuação de uma
	 * atividade
	 */
	public static final String PRODUCAO_ARTISTICA_CULTURAL = "ProducaoArtisticaCultural";
	/**
	 * Constante para produção técnica e tecnológica para se procurar a
	 * pontuação de uma atividade
	 */
	public static final String PRODUCAO_TECNICA_TECNOLOGICA = "ProducaoTecnicaTecnologica";
	/**
	 * Constante para outro tipo de produção para se procurar a pontuação de uma
	 * atividade
	 */
	public static final String PRODUCAO_OUTRO = "ProducaoOutro";
	/**
	 * Constante para atividades de pesquisa para se procurar a pontuação de uma
	 * atividade
	 */
	public static final String ATIVIDADE_PESQUISA = "AtividadePesquisa";
	/**
	 * Constante para atividades de extensão para se procurar a pontuação de uma
	 * atividade
	 */
	public static final String ATIVIDADE_EXTENSAO = "AtividadeExtensao";
	/**
	 * Constante para atividades de direção e/ou função gratificada para se
	 * procurar a pontuação de uma atividade
	 */
	public static final String DIRECAO_FUNCAO_GRATIFICADA = "DirecaoFuncaoGratificada";
	/**
	 * Constante para atividades administrativas para se procurar a pontuação de
	 * uma atividade
	 */
	public static final String ATIVIDADE_ADMINISTRATIVA = "AtividadeAdministrativa";
	/**
	 * Constante para outros tipos de atividades administrativas para se
	 * procurar a pontuação de uma atividade
	 */
	public static final String ATIVIDADE_ADMINISTRATIVA_OUTRAS = "AtividadeAdministrativaOutra";
	/**
	 * Constante para atividades de representação fora da UFG para se procurar a
	 * pontuação de uma atividade
	 */
	public static final String ATIVIDADE_REPRESENTACAO = "AtividadeRepresentacaoFora";
	/**
	 * Constante para atividades acadêmicas de orientação para se procurar a
	 * pontuação de uma atividade
	 */
	public static final String ATIVIDADE_ACADEMICA_ORIENTACAO = "Orientacao";
	/**
	 * Constante para atividades acadêmicas de bancas e cursos para se procurar
	 * a pontuação de uma atividade
	 */
	public static final String ATIVIDADE_ACADEMICA_BANCAS_CURSOS = "BancaCurso";
	/**
	 * Constante para atividades de aprendizado e aperfeiçoamento para se
	 * procurar a pontuação de uma atividade
	 */
	public static final String ATIVIDADE_APRENDIZADO_APERFEICOAMENTO = "AtividadeAprendizadoAperfeicoamento";

	/**
	 * Retorna produtos de uma subatividade.
	 * 
	 * @param nomeSubAtividade
	 *            a ser procurada
	 * @return produtos da subatividade
	 */
	public static List<Produto> getProdutos(String nomeSubAtividade) {
		try {
			InputStream xmlFile = ClassLoader
					.getSystemResourceAsStream("atividades.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);

			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("atividade");

			List<Produto> produtos = new ArrayList<Produto>();

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					if (eElement.getElementsByTagName("subatividade").item(0)
							.getTextContent().equals(nomeSubAtividade)) {

						Produto p = new Produto();
						p.setCodigo(eElement.getAttribute("id"));
						p.setPontos(Integer.parseInt(eElement
								.getElementsByTagName("pontos").item(0)
								.getTextContent()));
						p.setPontuacaoMaxima(Integer.parseInt(eElement
								.getElementsByTagName("maximo").item(0)
								.getTextContent()));
						produtos.add(p);
					}
				}
			}
			return produtos;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Retorna um produto de uma subatividade através de seu código.
	 * 
	 * @param codigo
	 *            do produto
	 * @param nomeSubAtividade
	 *            nome da subAtividade
	 * @return <code>produto</code> se encontrado <code>false</code> caso
	 *         contrário.
	 */
	public static Produto getProduto(String codigo, String nomeSubAtividade) {
		List<Produto> produtos = getProdutos(nomeSubAtividade);
		for (Produto p : produtos) {
			if (p.getCodigo().equals(codigo))
				return p;
		}
		return null;
	}

}
