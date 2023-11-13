package modelos;

import java.util.Date;

public class Promoçoes {
	private String idPromocoes;
    private String descricao;
    private String destinoRelacionado;
    private String nomePromocao;
    private java.util.Date dataTermino;
    private java.util.Date dataInicio;
    private double desconto;
    
    
	public Promoçoes(String idPromocoes, String descricao, String destinoRelacionado, String nomePromocao,
			Date dataTermino, Date dataInicio, double desconto) {
		this.idPromocoes = idPromocoes;
		this.descricao = descricao;
		this.destinoRelacionado = destinoRelacionado;
		this.nomePromocao = nomePromocao;
		this.dataTermino = dataTermino;
		this.dataInicio = dataInicio;
		this.desconto = desconto;
	}


	public Promoçoes(String descricao, String destinoRelacionado, String nomePromocao, Date dataTermino,
			Date dataInicio, double desconto) {
		this.descricao = descricao;
		this.destinoRelacionado = destinoRelacionado;
		this.nomePromocao = nomePromocao;
		this.dataTermino = dataTermino;
		this.dataInicio = dataInicio;
		this.desconto = desconto;
	}


	public Promoçoes() {
	}


	public String getIdPromocoes() {
		return idPromocoes;
	}


	public void setIdPromocoes(String idPromocoes) {
		this.idPromocoes = idPromocoes;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getDestinoRelacionado() {
		return destinoRelacionado;
	}


	public void setDestinoRelacionado(String destinoRelacionado) {
		this.destinoRelacionado = destinoRelacionado;
	}


	public String getNomePromocao() {
		return nomePromocao;
	}


	public void setNomePromocao(String nomePromocao) {
		this.nomePromocao = nomePromocao;
	}


	public java.util.Date getDataTermino() {
		return dataTermino;
	}


	public void setDataTermino(java.util.Date dataTermino) {
		this.dataTermino = dataTermino;
	}


	public java.util.Date getDataInicio() {
		return dataInicio;
	}


	public void setDataInicio(java.util.Date dataInicio) {
		this.dataInicio = dataInicio;
	}


	public double getDesconto() {
		return desconto;
	}


	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}


	@Override
	public String toString() {
		return "Promoçoes [idPromocoes=" + idPromocoes + ", descricao=" + descricao + ", destinoRelacionado="
				+ destinoRelacionado + ", nomePromocao=" + nomePromocao + ", dataTermino=" + dataTermino
				+ ", dataInicio=" + dataInicio + ", desconto=" + desconto + "]";
	}
    
    
    
      
}
