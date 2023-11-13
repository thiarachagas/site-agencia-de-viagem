package modelos;

public class DreamTravel {

	    private int idSite;
	    private String nomeFantasma;
	    private String endereco;
	    private String cnpj;
	    private String email;
	    private String telefone;
	    private String razaoSocial;
	    
		public DreamTravel(int idSite, String nomeFantasma, String endereco, String cnpj, String email, String telefone,
				String razaoSocial) {
			this.idSite = idSite;
			this.nomeFantasma = nomeFantasma;
			this.endereco = endereco;
			this.cnpj = cnpj;
			this.email = email;
			this.telefone = telefone;
			this.razaoSocial = razaoSocial;
		}

		public DreamTravel() {
		}

		public DreamTravel(String nomeFantasma, String endereco, String cnpj, String email, String telefone,
				String razaoSocial) {
			this.nomeFantasma = nomeFantasma;
			this.endereco = endereco;
			this.cnpj = cnpj;
			this.email = email;
			this.telefone = telefone;
			this.razaoSocial = razaoSocial;
		}

		@Override
		public String toString() {
			return "DreamTravel [idSite=" + idSite + ", nomeFantasma=" + nomeFantasma + ", endereco=" + endereco
					+ ", cnpj=" + cnpj + ", email=" + email + ", telefone=" + telefone + ", razaoSocial=" + razaoSocial
					+ "]";
		}

		public int getIdSite() {
			return idSite;
		}

		public void setIdSite(int idSite) {
			this.idSite = idSite;
		}

		public String getNomeFantasma() {
			return nomeFantasma;
		}

		public void setNomeFantasma(String nomeFantasma) {
			this.nomeFantasma = nomeFantasma;
		}

		public String getEndereco() {
			return endereco;
		}

		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}

		public String getCnpj() {
			return cnpj;
		}

		public void setCnpj(String cnpj) {
			this.cnpj = cnpj;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getTelefone() {
			return telefone;
		}

		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}

		public String getRazaoSocial() {
			return razaoSocial;
		}

		public void setRazaoSocial(String razaoSocial) {
			this.razaoSocial = razaoSocial;
		}	
	
	
}
