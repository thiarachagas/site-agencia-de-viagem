package br.com.dreamtravel.menu;

import java.util.List;
import java.util.Scanner;

import br.com.dreamtravel.crud.CrudBase;
import br.com.dreamtravel.crud.CrudCompanhiaAerea;
import br.com.dreamtravel.modelo.CompanhiaAerea;
import br.com.dreamtravel.modelo.Registro;

public class MenuCompanhiaAerea implements Menu {
	
	private Scanner scanner;
	private CrudBase crud;
	
	public MenuCompanhiaAerea(Scanner scanner) {
		this.scanner = scanner;
		this.crud = new CrudBase(new CrudCompanhiaAerea());
	}
	
	@Override
	public int lista() {
		
		System.out.println("\nCompanhias Aereas\n");
		
		List<Registro> registros = crud.lista();
		
		for (Registro r : registros) {
			System.out.println((CompanhiaAerea) r);
		}
		
		System.out.println();
		
		return registros.size();
	}

	@Override
	public void insere() {

		System.out.println("\nInsere Companhia Aerea\n");
		CompanhiaAerea c = new CompanhiaAerea();
		c = preencheCampos(c);
		
		crud.insere(c);
		
		System.out.println("\nCompanhia Aerea inserida!\n");
	}

	@Override
	public void atualiza() {
		
		System.out.println("\nAtualiza Companhia Aerea");
		lista();
		CompanhiaAerea c = buscaRegistro();
		
		if (c == null) {
			return;
		}
		
		c = preencheCampos(c);
		
		crud.atualiza(c);
		
		System.out.println("\nCompanhia Aerea atualizada!\n");
	}

	@Override
	public void exclui() {
		
		System.out.println("Exclui Companhia Aerea\n");
		lista();
		CompanhiaAerea c = buscaRegistro();
		
		if (c == null) {
			return;
		}
		
		crud.exclui(c.getId());
		
		System.out.println("Companhia Aerea excluida!\n");
	}
	
	@Override
	public Scanner getScanner() {
		return scanner;
	}
	
	@Override
	public String getTitulo() {
		return "COMPANHIA AEREA";
	}
	
	private CompanhiaAerea preencheCampos(CompanhiaAerea c) {
		
		System.out.print("Nome: ");
		c.setNome(scanner.nextLine());
		
		return c;
	}
	
	public CompanhiaAerea buscaRegistro() {
		
		System.out.print("Id: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		
		CompanhiaAerea c = (CompanhiaAerea) crud.busca(id);
		
		if (c == null) {
			System.out.println("Id "+ id + " nao encontrado!\n");
		}
		
		return c;
	}

}
