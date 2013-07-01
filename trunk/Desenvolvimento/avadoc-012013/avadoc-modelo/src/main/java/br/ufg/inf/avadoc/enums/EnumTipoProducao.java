package br.ufg.inf.avadoc.enums;

public enum EnumTipoProducao {

	CIENTIFICA("Produção cientifica"),
	
	ARTISTICO_CULTURAL("Produção artistico cultural");
	
	private String key;
	
	private EnumTipoProducao(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
}
