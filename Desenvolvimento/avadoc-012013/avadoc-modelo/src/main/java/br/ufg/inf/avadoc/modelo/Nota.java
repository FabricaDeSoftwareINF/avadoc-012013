package br.ufg.inf.avadoc.modelo;

public class Nota {

	private int quantidadeMeses;
	private double nota;

	public double getNota() {
		return nota;
	}

	public int getQuantidadeMeses() {
		return quantidadeMeses;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public void setQuantidadeMeses(int quantidadeMeses) {
		this.quantidadeMeses = quantidadeMeses;
	}

}
