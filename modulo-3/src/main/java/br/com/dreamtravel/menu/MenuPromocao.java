package br.com.dreamtravel.menu;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import br.com.dreamtravel.crud.CrudBase;
import br.com.dreamtravel.crud.CrudDestino;
import br.com.dreamtravel.crud.CrudPromocao;
import br.com.dreamtravel.modelo.Destino;
import br.com.dreamtravel.modelo.Promocao;
import br.com.dreamtravel.modelo.Registro;

public class MenuPromocao implements Menu {
	
	private Scanner scanner;
	private CrudBase crud;
	private MenuDestino menuDestino;
	
	public MenuPromocao(Scanner scanner) {
		this.scanner = scanner;
		this.crud = new CrudBase(new CrudPromocao());
		this.menuDestino = new MenuDestino(scanner);
	}
	
	@Override
	public int lista() {
		
		System.out.println("\nLista Promocoes\n");
		
		List<Registro> registros = crud.lista();
		
		for (Registro r : registros) {
			System.out.println((Promocao) r);
		}
		
		System.out.println();
		
		return registros.size();
	}

	@Override
	public void insere() {

		System.out.println("\nInsere Promocao\n");
		Promocao p = new Promocao();
		p = preencheCampos(p);
		if (p == null) {
			return;
		}
		
		crud.insere(p);
		
		System.out.println("\nPromocao inserida!\n");
	}

	@Override
	public void atualiza() {
		
		System.out.println("\nAtualiza Promocao");
		lista();
		Promocao p = buscaRegistro();

		if (p == null) {
			return;
		}
		
		p = preencheCampos(p);
		if (p == null) {
			return;
		}
		
		crud.atualiza(p);
		
		System.out.print("\nPromocao atualizada!\n");
	}

	@Override
	public void exclui() {
		System.out.println("\nExclui Promocao");
		lista();
		Promocao p = buscaRegistro();
		if (p == null) {
			return;
		}
		crud.exclui(p.getId());
		
		System.out.println("\nPromocao excluida!\n");
	}

	@Override
	public String getTitulo() {
		return "PROMOCAO";
	}

	@Override
	public Scanner getScanner() {
		return scanner;
	}
	
	private Promocao preencheCampos(Promocao p) {
		
		System.out.print("Nome: ");
		p.setNome(scanner.nextLine());
		System.out.print("Descricao: ");
		p.setDescricao(scanner.nextLine());
		System.out.print("Data Inicio (aaaa-mm-dd): ");
		p.setDataInicio(LocalDate.parse(scanner.nextLine()));
		System.out.print("Data Termino (aaaa-mm-dd): ");
		p.setDataTermino(LocalDate.parse(scanner.nextLine()));
		System.out.print("Desconto: ");
		p.setDesconto(scanner.nextDouble());
		scanner.nextLine();
		
		int numDestinos = menuDestino.lista();
		if (numDestinos == 0) {
			System.out.println("Nao ha destinos registrados");
			return null;
		}
		
		Destino d = menuDestino.buscaRegistro();
		if (d == null) {
			return null;
		}
		p.setDestino(d);
		
		return p;
	}
	
	private Promocao buscaRegistro() {
		
		System.out.print("Id: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		
		Promocao p = (Promocao) crud.busca(id);
		
		if (p == null) {
			System.out.println("Id "+ id + " nao encontrado!\n");
		}
		
		return p;
	}

}
