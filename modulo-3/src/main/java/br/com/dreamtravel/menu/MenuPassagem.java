package br.com.dreamtravel.menu;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import br.com.dreamtravel.crud.CrudBase;
import br.com.dreamtravel.crud.CrudCompanhiaAerea;
import br.com.dreamtravel.crud.CrudDestino;
import br.com.dreamtravel.crud.CrudPassagem;
import br.com.dreamtravel.crud.CrudPromocao;
import br.com.dreamtravel.modelo.CompanhiaAerea;
import br.com.dreamtravel.modelo.Destino;
import br.com.dreamtravel.modelo.Passagem;
import br.com.dreamtravel.modelo.Promocao;
import br.com.dreamtravel.modelo.Registro;

public class MenuPassagem implements Menu {
	
	private Scanner scanner;
	private CrudBase crud;
	private CrudBase crudPromocao;
	private MenuDestino menuDestino;
	private MenuCompanhiaAerea menuCompanhiaAerea;
	
	public MenuPassagem(Scanner scanner) {
		this.scanner = scanner;
		this.crud = new CrudBase(new CrudPassagem());
		this.crudPromocao = new CrudBase(new CrudPromocao());
		this.menuDestino = new MenuDestino(scanner);
		this.menuCompanhiaAerea = new MenuCompanhiaAerea(scanner);
	}
	
	@Override
	public int lista() {
		
		System.out.println("\nPassagens\n");
		
		List<Registro> passagens = crud.lista();
		for (Registro r: passagens) {
			System.out.println((Passagem) r);
		}
		
		System.out.println();
		
		return passagens.size();
	}

	@Override
	public void insere() {
		
		System.out.println("\nInsere Passagem\n");
		Passagem p = new Passagem();
		p = preencheCampos(p);
		if (p == null) {
			return;
		}
		
		crud.insere(p);
		
		System.out.println("\nPassagem inserida!\n");
	}

	@Override
	public void atualiza() {
		
		System.out.println("\nAtualiza Passagem\n");
		lista();
		
		Passagem p = buscaRegistro();
		if (p == null) {
			return;
		}
		
		p = preencheCampos(p);
		if (p == null) {
			return;
		}
		
		crud.atualiza(p);
		
		System.out.println("\nPassagem atualizada!\n");
	}

	@Override
	public void exclui() {

		System.out.println("\nExclui Passagem\n");
		lista();
		
		Passagem p = buscaRegistro();
		if (p == null) {
			return;
		}
		
		crud.exclui(p.getId());
		
		System.out.println("\nPassagem excluida!\n");
	}

	@Override
	public String getTitulo() {
		return "PASSAGEM";
	}

	@Override
	public Scanner getScanner() {
		return scanner;
	}
	
	private Passagem preencheCampos(Passagem p) {
		
		System.out.print("Origem: ");
		p.setOrigem(scanner.nextLine());
		System.out.print("Data Partida (aaaa-mm-dd): ");
		p.setDataPartida(LocalDate.parse(scanner.nextLine()));
		
		menuDestino.lista();
		Destino d = menuDestino.buscaRegistro();
		if (d == null) {
			return null;
		}
		
		p.setDestino(d);
		
		System.out.print("Adiciona Promocao? (s/n): ");
		String adicionaPromocao = scanner.nextLine();
		
		Promocao pr = null;
		if (adicionaPromocao.equals("s")) {
			
			System.out.println("Promocoes para o destino Id "+ d.getId());
			
			List<String> campos1 = Arrays.asList("fk_Destino_Id");
			List<Object> valores1 = Arrays.asList(d.getId());
			List<Registro> promocoes = crudPromocao.buscaPersonalizada(
					campos1, valores1);
			
			for (Registro r: promocoes) {
				System.out.println((Promocao) r);
			}
			
			System.out.print("Id Promocao: ");
			int idPromocao = scanner.nextInt();
			scanner.nextLine();
			
			for (Registro r : promocoes) {
				Promocao promocao = (Promocao) r; 
				if (promocao.getId() == idPromocao) {
					pr = promocao;
					break;
				}
			}
		}
		
		p.setPromocao(pr);
		
		menuCompanhiaAerea.lista();
		CompanhiaAerea c = menuCompanhiaAerea.buscaRegistro();
		
		if (c == null) {
			return null;
		}
		
		p.setCompanhiaAerea(c);
		
		return p;
	}
	
	public Passagem buscaRegistro() {
		
		System.out.print("Id: ");
		Integer idPassagem = scanner.nextInt();
		scanner.nextLine();
		
		Passagem p = (Passagem) crud.busca(idPassagem);
		if (p == null) {
			System.out.println("Id "+ idPassagem + " nao encontrado!\n");
		}
		
		return p;
	}

}
