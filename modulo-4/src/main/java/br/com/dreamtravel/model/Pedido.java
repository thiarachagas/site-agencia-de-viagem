package br.com.dreamtravel.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private LocalDate dataCompra;
	private LocalTime horaCompra;
	private Double precoCompra;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_cliente_cpf")
	private Cliente cliente;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_passagem_id")
	private Passagem passagem;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_forma_pagamento_id")
	private FormaPagamento formaPagamento;
	
	public Pedido() {}
	
	public Pedido(Integer id, LocalDate dataCompra, LocalTime horaCompra, Double precoCompra, Cliente cliente,
			Passagem passagem, FormaPagamento formaPagamento) {
		super();
		this.id = id;
		this.dataCompra = dataCompra;
		this.horaCompra = horaCompra;
		this.precoCompra = precoCompra;
		this.cliente = cliente;
		this.passagem = passagem;
		this.formaPagamento = formaPagamento;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", dataCompra=" + dataCompra 
				+ ", horaCompra=" + horaCompra + ", precoCompra=" + precoCompra 
				+ ", cliente=" + cliente + ", passagem=" + passagem 
				+ ", formaPagamento=" + formaPagamento + "]";
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(LocalDate dataCompra) {
		this.dataCompra = dataCompra;
	}
	public LocalTime getHoraCompra() {
		return horaCompra;
	}
	public void setHoraCompra(LocalTime horaCompra) {
		this.horaCompra = horaCompra;
	}
	public Double getPrecoCompra() {
		return precoCompra;
	}
	public void setPrecoCompra(Double precoCompra) {
		this.precoCompra = precoCompra;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Passagem getPassagem() {
		return passagem;
	}
	public void setPassagem(Passagem passagem) {
		this.passagem = passagem;
	}
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
}
