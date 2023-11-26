package br.com.dreamtravel.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Destino implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String localizacao;
	private Double precoMedio;
	
	public Destino() {}
	
	public Destino(Integer id, String nome, String localizacao, Double precoMedio) {
		super();
		this.id = id;
		this.nome = nome;
		this.localizacao = localizacao;
		this.precoMedio = precoMedio;
	}
	
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
