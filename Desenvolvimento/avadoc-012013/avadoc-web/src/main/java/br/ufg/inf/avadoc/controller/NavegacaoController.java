package br.ufg.inf.avadoc.controller;

/**
 * @author Wilker Machado
 * 
 */
public class NavegacaoController extends Controller {

	private static final long serialVersionUID = -2655198545850791277L;

	private String paginaSelecionada;

	public String getPaginaSelecionada() {
		return paginaSelecionada;
	}

	public void setPaginaSelecionada(String paginaSelecionada) {
		this.paginaSelecionada = paginaSelecionada;
	}

}
