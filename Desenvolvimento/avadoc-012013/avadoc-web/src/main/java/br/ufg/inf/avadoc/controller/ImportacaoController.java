package br.ufg.inf.avadoc.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("session")
@Component(ImportacaoController.KEY_COMPONENT)
public class ImportacaoController extends Controller {

	private static final long serialVersionUID = 7444607033271769749L;

	public static final String KEY_COMPONENT = "importacaoController";

	private Boolean importacao = Boolean.FALSE;

	private Boolean renderedDocente = Boolean.TRUE;

	private UploadedFile arquivo;

	public void upload(FileUploadEvent event) {
		if (importacao) {
			FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void mudaRendered() {
		if (importacao) {
			renderedDocente = Boolean.FALSE;
		} else {
			renderedDocente = Boolean.TRUE;
		}
	}

	public Boolean getRenderedDocente() {
		return renderedDocente;
	}

	public void setRenderedDocente(Boolean renderedDocente) {
		this.renderedDocente = renderedDocente;
	}

	public Boolean getImportacao() {
		return importacao;
	}

	public void setImportacao(Boolean importacao) {
		this.importacao = importacao;
	}

	public UploadedFile getArquivo() {
		return arquivo;
	}

	public void setArquivo(UploadedFile arquivo) {
		this.arquivo = arquivo;
	}

}
