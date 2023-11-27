package br.com.dreamtravel.modelo;

import java.time.LocalDate;

public class Passagem implements Registro {

	private Integer id;
	private String origem;
	private LocalDate dataPartida;
	private Destino destino;
	private Promocao promocao;
	private CompanhiaAerea companhiaAerea;
		
	@Override
	public String toString() {
		return "Passagem [id=" + id + ", origem=" + origem + ", dataPartida=" + dataPartida + ", destino=" + destino
				+ ", promocao=" + promocao + ", companhiaAerea=" + companhiaAerea + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public LocalDate getDataPartida() {
		return dataPartida;
	}
	public void setDataPartida(LocalDate dataPartida) {
		this.dataPartida = dataPartida;
	}
	public Destino getDestino() {
		return destino;
	}
	public void setDestino(Destino destino) {
		this.destino = destino;
	}
	public Promocao getPromocao() {
		return promocao;
	}
	public void setPromocao(Promocao promocao) {
		this.promocao = promocao;
	}
	public CompanhiaAerea getCompanhiaAerea() {
		return companhiaAerea;
	}
	public void setCompanhiaAerea(CompanhiaAerea companhiaAerea) {
		this.companhiaAerea = companhiaAerea;
	}	
}
