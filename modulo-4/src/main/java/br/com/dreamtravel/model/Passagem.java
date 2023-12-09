package br.com.dreamtravel.model;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Passagem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String origem;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataPartida;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_destino_id")
	private Destino destino;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_promocao_id")
	private Promocao promocao;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_companhia_aerea_id")
	private CompanhiaAerea companhiaAerea;
	
	public Passagem() {}
	
	public Passagem(Integer id, String origem, LocalDate dataPartida, Destino destino, Promocao promocao,
			CompanhiaAerea companhiaAerea) {
		super();
		this.id = id;
		this.origem = origem;
		this.dataPartida = dataPartida;
		this.destino = destino;
		this.promocao = promocao;
		this.companhiaAerea = companhiaAerea;
	}
	
	@Override
	public String toString() {
		return "Passagem [id=" + id + ", origem=" + origem + ", dataPartida=" + dataPartida + ", destino=" + destino
				+ ", promocao=" + promocao + ", companhiaAerea=" + companhiaAerea + "]";
	}
	
	public double calculaPrecoCompra() {
		double precoMedio = destino.getPrecoMedio();
		double desconto = promocao == null ? 0 : promocao.getDesconto();
		return precoMedio - desconto;
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
