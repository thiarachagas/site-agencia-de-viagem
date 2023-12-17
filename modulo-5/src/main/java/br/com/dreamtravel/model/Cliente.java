package br.com.dreamtravel.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String cpf;
	private String email;
	private String tel;
	private String nome;
	private String senha;
	
	public Cliente() {}
	
	public Cliente(String cpf, String email, String tel, String nome, String senha) {
		super();
		this.cpf = cpf;
		this.email = email;
		this.tel = tel;
		this.nome = nome;
		this.senha = senha;
	}
	
	@Override
	public String toString() {
		return "Cliente [cpf=" + cpf + ", email=" + email + ", tel=" + tel + ", nome=" + nome + ", senha=" + senha
				+ "]";
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
