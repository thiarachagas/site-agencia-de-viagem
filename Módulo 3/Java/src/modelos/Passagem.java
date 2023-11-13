package modelos;

import java.util.Date;

public class Passagem {
	private int idPassagem;
    private double preco;
    private String companhiaAerea;
    private java.util.Date dataPartida;
    private int quantidade;
    private String destino;
    private String origem;
    private int codigoPedido;
    
    
	public Passagem(int idPassagem, double preco, String companhiaAerea, Date dataPartida, int quantidade,
			String destino, String origem, int codigoPedido) {
		this.idPassagem = idPassagem;
		this.preco = preco;
		this.companhiaAerea = companhiaAerea;
		this.dataPartida = dataPartida;
		this.quantidade = quantidade;
		this.destino = destino;
		this.origem = origem;
		this.codigoPedido = codigoPedido;
	}


	public Passagem(double preco, String companhiaAerea, Date dataPartida, int quantidade, String destino,
			String origem, int codigoPedido) {
		this.preco = preco;
		this.companhiaAerea = companhiaAerea;
		this.dataPartida = dataPartida;
		this.quantidade = quantidade;
		this.destino = destino;
		this.origem = origem;
		this.codigoPedido = codigoPedido;
	}


	public Passagem() {
	}


	public int getIdPassagem() {
		return idPassagem;
	}


	public void setIdPassagem(int idPassagem) {
		this.idPassagem = idPassagem;
	}


	public double getPreco() {
		return preco;
	}


	public void setPreco(double preco) {
		this.preco = preco;
	}


	public String getCompanhiaAerea() {
		return companhiaAerea;
	}


	public void setCompanhiaAerea(String companhiaAerea) {
		this.companhiaAerea = companhiaAerea;
	}


	public java.util.Date getDataPartida() {
		return dataPartida;
	}


	public void setDataPartida(java.util.Date dataPartida) {
		this.dataPartida = dataPartida;
	}


	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	public String getDestino() {
		return destino;
	}


	public void setDestino(String destino) {
		this.destino = destino;
	}


	public String getOrigem() {
		return origem;
	}


	public void setOrigem(String origem) {
		this.origem = origem;
	}


	public int getCodigoPedido() {
		return codigoPedido;
	}


	public void setCodigoPedido(int codigoPedido) {
		this.codigoPedido = codigoPedido;
	}


	@Override
	public String toString() {
		return "Passagem [idPassagem=" + idPassagem + ", preco=" + preco + ", companhiaAerea=" + companhiaAerea
				+ ", dataPartida=" + dataPartida + ", quantidade=" + quantidade + ", destino=" + destino + ", origem="
				+ origem + ", codigoPedido=" + codigoPedido + "]";
	}
    
    
    
}
