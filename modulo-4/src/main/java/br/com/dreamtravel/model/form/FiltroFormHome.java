package br.com.dreamtravel.model.form;

import java.time.LocalDate;

public class FiltroFormHome {
	
	private String origem;
	private String destino;
	private LocalDate dataInicio;
	private LocalDate dataTermino;
	
	public FiltroFormHome() {}
	
	public FiltroFormHome(String origem, String destino, LocalDate dataInicio, LocalDate dataTermino) {
		super();
		this.origem = origem;
		this.destino = destino;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
	}
		
	@Override
	public String toString() {
		return "FiltroFormHome [origem=" + origem + ", destino=" + destino + ", dataInicio=" + dataInicio
				+ ", dataTermino=" + dataTermino + "]";
	}

	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public LocalDate getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}
	public LocalDate getDataTermino() {
		return dataTermino;
	}
	public void setDataTermino(LocalDate dataTermino) {
		this.dataTermino = dataTermino;
	}
}
