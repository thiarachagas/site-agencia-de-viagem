package br.com.dreamtravel.menu;

import java.util.List;
import java.util.Scanner;

import br.com.dreamtravel.crud.CrudBase;
import br.com.dreamtravel.crud.CrudDestino;
import br.com.dreamtravel.modelo.Destino;
import br.com.dreamtravel.modelo.Registro;

public class MenuDestino implements Menu {
	
	private Scanner scanner;
	private CrudBase crud;
	
	public MenuDestino(Scanner scanner) {
		this.scanner = scanner;
		this.crud = new CrudBase(new CrudDestino());
	}
	
	@Override
	public int lista() {

		System.out.println("\nDestinos\n");

		List<Registro> registros = crud.lista();
		
		for (Registro r : registros) {
			System.out.println((Destino) r);
		}
		
		System.out.println();
		
		return registros.size();
	}

	@Override
	public void insere() {

		System.out.println("\nInsere Destino\n");
		Destino d = new Destino();
		d = preencheCampos(d);
		
		crud.insere(d);
		
		System.out.println("\nDestino inserido!\n");
	}

	@Override
	public void atualiza() {
		
		System.out.println("\nAtualiza Destino\n");
		Destino d = buscaRegistro();
		
		if (d == null) {
			return;
		}
		
		d = preencheCampos(d);
		
		crud.atualiza(d);
		
		System.out.println("\nDestino atualizado!\n");
	}

	@Override
	public void exclui() {

		System.out.println("\nExclui Destino\n");
		Destino d = buscaRegistro();
		
		if (d == null) {
			return;
		}
		
		crud.exclui(d.getId());
		
		System.out.println("\nDestino excluido!\n");
	}

	@Override
	public String getTitulo() {
		return "DESTINO";
	}

	@Override
	public Scanner getScanner() {
		return scanner;
	}
	
	private Destino preencheCampos(Destino d) {
		System.out.print("Nome: ");
		d.setNome(scanner.nextLine());
		System.out.print("Localizacao: ");
		d.setLocalizacao(scanner.nextLine());
		System.out.print("Preco Medio: ");
		d.setPrecoMedio(scanner.nextDouble());
		
		return d;
	}

	public Destino buscaRegistro() {
		
		System.out.print("Id: ");
		Integer id = scanner.nextInt();
		scanner.nextLine();
		
		Destino d = (Destino) crud.busca(id);
		
		if (d == null) {
			System.out.println("Id "+ id + " nao encontrado!\n");
		}
		
		return d;
	}
}
