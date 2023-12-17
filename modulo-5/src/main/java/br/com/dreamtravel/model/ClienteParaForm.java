package br.com.dreamtravel.model;

public class ClienteParaForm {

	String cpf;
	String email;
	String tel;
	String nome;
	
	public ClienteParaForm(Cliente c) {
		super();
		this.cpf = c.getCpf();
		this.email = c.getEmail();
		this.tel = c.getTel();
		this.nome = c.getNome();
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
}
