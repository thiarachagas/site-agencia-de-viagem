package modelos;

import java.util.Date;

public class Pedido {
	 private int codigoPedido;
	    private String formaPagamento;
	    private double precoCompra;
	    private java.util.Date dataCompra;
	    private int idFunc;
	    private String cpfCliente;
	    
	    
		public Pedido(int codigoPedido, String formaPagamento, double precoCompra, Date dataCompra, int idFunc,
				String cpfCliente) {
			this.codigoPedido = codigoPedido;
			this.formaPagamento = formaPagamento;
			this.precoCompra = precoCompra;
			this.dataCompra = dataCompra;
			this.idFunc = idFunc;
			this.cpfCliente = cpfCliente;
		}


		public Pedido() {
		}


		public Pedido(int codigoPedido, String formaPagamento, double precoCompra, Date dataCompra, String cpfCliente) {
			this.codigoPedido = codigoPedido;
			this.formaPagamento = formaPagamento;
			this.precoCompra = precoCompra;
			this.dataCompra = dataCompra;
			this.cpfCliente = cpfCliente;
		}


		public int getCodigoPedido() {
			return codigoPedido;
		}


		public void setCodigoPedido(int codigoPedido) {
			this.codigoPedido = codigoPedido;
		}


		public String getFormaPagamento() {
			return formaPagamento;
		}


		public void setFormaPagamento(String formaPagamento) {
			this.formaPagamento = formaPagamento;
		}


		public double getPrecoCompra() {
			return precoCompra;
		}


		public void setPrecoCompra(double precoCompra) {
			this.precoCompra = precoCompra;
		}


		public java.util.Date getDataCompra() {
			return dataCompra;
		}


		public void setDataCompra(java.util.Date dataCompra) {
			this.dataCompra = dataCompra;
		}


		public int getIdFunc() {
			return idFunc;
		}


		public void setIdFunc(int idFunc) {
			this.idFunc = idFunc;
		}


		public String getCpfCliente() {
			return cpfCliente;
		}


		public void setCpfCliente(String cpfCliente) {
			this.cpfCliente = cpfCliente;
		}


		@Override
		public String toString() {
			return "Pedido [codigoPedido=" + codigoPedido + ", formaPagamento=" + formaPagamento + ", precoCompra="
					+ precoCompra + ", dataCompra=" + dataCompra + ", idFunc=" + idFunc + ", cpfCliente=" + cpfCliente
					+ "]";
		}
	    
	    
	    
	    
	    
}
