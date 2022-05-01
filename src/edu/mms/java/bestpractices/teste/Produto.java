package edu.mms.java.bestpractices.teste;

public class Produto {
	
	private int id = 0;
	private String descricao = "";
	private String valor = "";
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Produto [descricao=" + descricao + ", valor=" + valor + "]";
	}
	
}
