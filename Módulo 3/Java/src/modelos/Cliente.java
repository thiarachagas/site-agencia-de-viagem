package modelos;

public class Cliente {

	    private String cpfCliente;
	    private String telCliente;
	    private String emailCliente;
	    private String nomeCliente;
	    
	    
		public String getCpfCliente() {
			return cpfCliente;
		}

		public void setCpfCliente(String cpfCliente) {
			this.cpfCliente = cpfCliente;
		}

		public String getTelCliente() {
			return telCliente;
		}

		public void setTelCliente(String telCliente) {
			this.telCliente = telCliente;
		}

		public String getEmailCliente() {
			return emailCliente;
		}

		public void setEmailCliente(String emailCliente) {
			this.emailCliente = emailCliente;
		}

		public String getNomeCliente() {
			return nomeCliente;
		}

		public void setNomeCliente(String nomeCliente) {
			this.nomeCliente = nomeCliente;
		}

		@Override
		public String toString() {
			return "Cliente [cpfCliente=" + cpfCliente + ", telCliente=" + telCliente + ", emailCliente=" + emailCliente
					+ ", nomeCliente=" + nomeCliente + "]";
		}
}
