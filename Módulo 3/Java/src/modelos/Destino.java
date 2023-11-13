package modelos;

public class Destino {
	  private int idDestino;
	    private double precoMedio;
	    private int qtd;
	    private String nomeDestino;
	    private String localizacao;
	    
	    
		public Destino(int idDestino, double precoMedio, int qtd, String nomeDestino, String localizacao) {
			this.idDestino = idDestino;
			this.precoMedio = precoMedio;
			this.qtd = qtd;
			this.nomeDestino = nomeDestino;
			this.localizacao = localizacao;
		}


		public Destino(double precoMedio, int qtd, String nomeDestino, String localizacao) {
			this.precoMedio = precoMedio;
			this.qtd = qtd;
			this.nomeDestino = nomeDestino;
			this.localizacao = localizacao;
		}


		public Destino() {
		}


		public int getIdDestino() {
			return idDestino;
		}


		public void setIdDestino(int idDestino) {
			this.idDestino = idDestino;
		}


		public double getPrecoMedio() {
			return precoMedio;
		}


		public void setPrecoMedio(double precoMedio) {
			this.precoMedio = precoMedio;
		}


		public int getQtd() {
			return qtd;
		}


		public void setQtd(int qtd) {
			this.qtd = qtd;
		}


		public String getNomeDestino() {
			return nomeDestino;
		}


		public void setNomeDestino(String nomeDestino) {
			this.nomeDestino = nomeDestino;
		}


		public String getLocalizacao() {
			return localizacao;
		}


		public void setLocalizacao(String localizacao) {
			this.localizacao = localizacao;
		}


		@Override
		public String toString() {
			return "Destino [idDestino=" + idDestino + ", precoMedio=" + precoMedio + ", qtd=" + qtd + ", nomeDestino="
					+ nomeDestino + ", localizacao=" + localizacao + "]";
		}
	        
	    
}
