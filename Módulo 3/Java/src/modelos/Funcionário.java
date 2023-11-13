package modelos;

public class Funcionário {

	private int idFunc;
    private String nomeFunc;
    private String cargoFunc;
    private double salario;
    
    
	public Funcionário(int idFunc, String nomeFunc, String cargoFunc, double salario) {
		this.idFunc = idFunc;
		this.nomeFunc = nomeFunc;
		this.cargoFunc = cargoFunc;
		this.salario = salario;
	}


	public Funcionário() {
	}


	public Funcionário(String nomeFunc, String cargoFunc, double salario) {
		this.nomeFunc = nomeFunc;
		this.cargoFunc = cargoFunc;
		this.salario = salario;
	}


	public int getIdFunc() {
		return idFunc;
	}


	public void setIdFunc(int idFunc) {
		this.idFunc = idFunc;
	}


	public String getNomeFunc() {
		return nomeFunc;
	}


	public void setNomeFunc(String nomeFunc) {
		this.nomeFunc = nomeFunc;
	}


	public String getCargoFunc() {
		return cargoFunc;
	}


	public void setCargoFunc(String cargoFunc) {
		this.cargoFunc = cargoFunc;
	}


	public double getSalario() {
		return salario;
	}


	public void setSalario(double salario) {
		this.salario = salario;
	}


	@Override
	public String toString() {
		return "Funcionário [idFunc=" + idFunc + ", nomeFunc=" + nomeFunc + ", cargoFunc=" + cargoFunc + ", salario="
				+ salario + "]";
	}	
	

}
