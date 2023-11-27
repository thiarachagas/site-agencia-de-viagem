package br.com.dreamtravel.modelo;

public class Destino implements Registro {
	
	private Integer id;
	private String nome;
	private String localizacao;
	private Double precoMedio;
		
	@Override
	public String toString() {
		return "Destino [id=" + id + ", nome=" + nome + ", localizacao=" + localizacao + ", precoMedio=" + precoMedio
				+ "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	public Double getPrecoMedio() {
		return precoMedio;
	}
	public void setPrecoMedio(Double precoMedio) {
		this.precoMedio = precoMedio;
	}
}
