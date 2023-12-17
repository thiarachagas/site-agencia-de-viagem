package br.com.dreamtravel.model;

import java.io.Serializable;
import java.util.Base64;

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
	private String descricao;
	private String localizacao;
	private Double precoMedio;
	private byte[] imagem;
	private Boolean internacional;
	
	public Destino() {}
	
	public Destino(Integer id, String nome, String descricao, String localizacao, Double precoMedio, 
			byte[] imagem, Boolean internacional) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao= descricao;
		this.localizacao = localizacao;
		this.precoMedio = precoMedio;
		this.imagem = imagem;
		this.internacional = internacional;
	}
	
	@Override
	public String toString() {
		return "Destino [id=" + id + ", nome=" + nome + ", descricao=" + descricao 
				+ ", localizacao=" + localizacao + ", precoMedio=" + precoMedio
				+ ", internacional=" + internacional
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
	public byte[] getImagem() {
		return imagem;
	}
	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}
	public String getImagemBase64() {
		return "data:image/png;base64," + Base64.getEncoder().encodeToString(imagem);
	}
	public Boolean getInternacional() {
		return internacional;
	}
	public void setInternacional(Boolean internacional) {
		this.internacional = internacional;
	}
}
