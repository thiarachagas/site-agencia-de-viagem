package br.com.dreamtravel.menu;

import java.util.List;
import java.util.Scanner;

import br.com.dreamtravel.crud.CrudBase;
import br.com.dreamtravel.crud.CrudFormaPagamento;
import br.com.dreamtravel.modelo.FormaPagamento;
import br.com.dreamtravel.modelo.Registro;

public class MenuFormaPagamento implements Menu {

	private Scanner scanner;
	private CrudBase crud;
	
	public MenuFormaPagamento(Scanner scanner) {
		this.scanner = scanner;
		this.crud = new CrudBase(new CrudFormaPagamento());
	}
	
	@Override
	public int lista() {
		
		System.out.println("\nFormas de Pagamento\n");
		
		List<Registro> registros = crud.lista();
		
		for (Registro r : registros) {
			System.out.println((FormaPagamento) r);
		}
		
		System.out.println();
		
		return registros.size();
	}
	
	@Override
	public void insere() {
		
		System.out.println("\nInsere Forma de Pagamento\n");
		FormaPagamento f = new FormaPagamento();
		f = preencheCampos(f);
		
		crud.insere(f);
		
		System.out.println("\nForma de Pagamento inserida!\n");
	}

	@Override
	public void atualiza() {

		System.out.println("\nAtualiza Forma de Pagamento");
		lista();
		FormaPagamento f = buscaRegistro();
		if (f == null) {
			return;
		}
		
		f = preencheCampos(f);
		
		crud.atualiza(f);
		
		System.out.println("\nForma de Pagamento atualizada!\n");
	}

	@Override
	public void exclui() {
		
		System.out.println("\nExclui Forma de Pagamento");
		lista();
		
		FormaPagamento f = buscaRegistro();
		if (f == null) {
			return;
		}
		
		crud.exclui(f.getId());
		
		System.out.println("\nForma de Pagamento excluida!\n");
	}

	@Override
	public String getTitulo() {
		return "FORMA DE PAGAMENTO";
	}

	@Override
	public Scanner getScanner() {
		return scanner;
	}
	
	private FormaPagamento preencheCampos(FormaPagamento f) {
		System.out.print("Nome: ");
		f.setNome(scanner.nextLine());
		
		return f;
	}
	
	public FormaPagamento buscaRegistro() {
		
		System.out.print("Id: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		
		FormaPagamento f = (FormaPagamento) crud.busca(id);
		
		if (f == null) {
			System.out.println("Id "+ id + " nao encontrado!\n");
		}
		
		return f;
	}

}
