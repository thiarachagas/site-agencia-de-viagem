package br.com.dreamtravel.menu;

import java.util.List;
import java.util.Scanner;

import br.com.dreamtravel.crud.CrudBase;
import br.com.dreamtravel.crud.CrudCliente;
import br.com.dreamtravel.modelo.Cliente;
import br.com.dreamtravel.modelo.Registro;

public class MenuCliente implements Menu {
	
	private Scanner scanner;
	private CrudBase crud;
	
	public MenuCliente(Scanner scanner) {
		this.scanner = scanner;
		this.crud = new CrudBase(new CrudCliente());
	}
	
	@Override
	public int lista() {
		
		System.out.println("Clientes\n");
		
		List<Registro> registros = crud.lista();
		
		for (Registro r : registros) {
			System.out.println((Cliente) r);
		}
		
		System.out.println();
		
		return registros.size();
	}
	
	@Override
	public void insere() {
		System.out.println("\nInsere Cliente\n");
		Cliente cliente = new Cliente();
		System.out.print("CPF: ");
		cliente.setCpf(scanner.nextLine());
		cliente = preencheCampos(cliente);
		
		crud.insere(cliente);
		
		System.out.println("\nCliente inserido!\n");
		
	}

	@Override
	public void atualiza() {
		
		System.out.println("\nAtualiza Cliente");
		lista();
		Cliente cliente = buscaRegistro();
		
		if (cliente == null) {
			return;
		}
		
		cliente = preencheCampos(cliente);
		
		crud.atualiza(cliente);
		
		System.out.println("\nCliente atualizado!\n");
	}
	
	@Override
	public void exclui() {
		System.out.println("\nExclui Cliente");
		lista();
		Cliente cliente = buscaRegistro();
		
		if (cliente == null) {
			return;
		}
		
		crud.exclui(cliente.getCpf());
		
		System.out.println("\nCliente excluido!\n");
	}
	
	@Override
	public Scanner getScanner() {
		return scanner;
	}
	
	@Override
	public String getTitulo() {
		return "CLIENTE";
	}
	
	public Cliente buscaRegistro() {
		System.out.print("CPF: ");
		String cpf = scanner.nextLine();
		
		Cliente cliente = (Cliente) crud.busca(cpf);
		
		if (cliente == null) {
			System.out.println("CPF "+ cpf + " nao encontrado!\n");
			return null;
		}
		
		return cliente;
	}
	
	private Cliente preencheCampos(Cliente cliente) {
		
		System.out.print("E-mail: ");
		cliente.setEmail(scanner.nextLine());
		System.out.print("Telefone: ");
		cliente.setTel(scanner.nextLine());
		System.out.print("Nome: ");
		cliente.setNome(scanner.nextLine());
		System.out.print("Senha: ");
		cliente.setSenha(scanner.nextLine());
		
		return cliente;
	}

}
