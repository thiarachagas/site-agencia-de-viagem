package br.com.dreamtravel.modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Pedido implements Registro {

	private Integer id;
	private LocalDate dataCompra;
	private LocalTime horaCompra;
	private Double precoCompra;
	private Cliente cliente;
	private Passagem passagem;
	private FormaPagamento formaPagamento;
		
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
