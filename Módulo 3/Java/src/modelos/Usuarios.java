package modelos;

public class Usuarios {
	//atributos

	private int idUsuario;
    private String cpfCliente;
    private String emailUsuario;
    private String senhaUsuario;
    private String nomeUsuario;
    
    Usuarios usuario;
    Cliente cliente;
    
    //construtor
    public Usuarios() {
   	} 
    
    public Usuarios(int idUsuario, String cpfCliente, String emailUsuario, String senhaUsuario, String nomeUsuario) {
		this.idUsuario = idUsuario;
		this.cpfCliente = cpfCliente;
		this.emailUsuario = emailUsuario;
		this.senhaUsuario = senhaUsuario;
		this.nomeUsuario = nomeUsuario;
	}

	public Usuarios(String cpfCliente, String emailUsuario, String senhaUsuario, String nomeUsuario) {
		this.cpfCliente = cpfCliente;
		this.emailUsuario = emailUsuario;
		this.senhaUsuario = senhaUsuario;
		this.nomeUsuario = nomeUsuario;
	}
	
	
   // getters e setters
	
	
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
		
	}

	public String getNome() {
		        return nomeUsuario;
		    }
		    

    public void setNome(String nome) {
		   this.nomeUsuario = nome;
		    }
		    	
	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	//tostring
	
	@Override
	public String toString() {
		return "Usuarios [idUsuario=" + idUsuario + ", cpfCliente=" + cpfCliente + ", emailUsuario=" + emailUsuario
				+ ", senhaUsuario=" + senhaUsuario + nomeUsuario + "]";
	}


	
	
}
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	