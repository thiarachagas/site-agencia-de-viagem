package br.com.dreamtravel.modelo;

public class Cliente implements Registro {

	private String cpf;
	private String email;
	private String tel;
	private String nome;
	private String senha;
	
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
