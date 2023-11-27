package br.com.dreamtravel.menu;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import br.com.dreamtravel.crud.CrudBase;
import br.com.dreamtravel.crud.CrudCliente;
import br.com.dreamtravel.crud.CrudFormaPagamento;
import br.com.dreamtravel.crud.CrudPassagem;
import br.com.dreamtravel.crud.CrudPedido;
import br.com.dreamtravel.modelo.Cliente;
import br.com.dreamtravel.modelo.FormaPagamento;
import br.com.dreamtravel.modelo.Passagem;
import br.com.dreamtravel.modelo.Pedido;
import br.com.dreamtravel.modelo.Promocao;
import br.com.dreamtravel.modelo.Registro;

public class MenuPedido implements Menu {
	
	private Scanner scanner;
	private CrudBase crud;
	private MenuCliente menuCliente;
	private MenuPassagem menuPassagem;
	private MenuFormaPagamento menuFormaPagamento;
	
	public MenuPedido(Scanner scanner) {
		this.scanner = scanner;
		crud = new CrudBase(new CrudPedido());
		menuCliente = new MenuCliente(scanner);
		menuPassagem = new MenuPassagem(scanner);
		menuFormaPagamento = new MenuFormaPagamento(scanner);
	}

	@Override
	public void insere() {
		
		System.out.println("\nInsere Pedido\n");
		Pedido p = new Pedido();
		p = preencheCampos(p);
		if (p == null) {
			return;
		}
		
		crud.insere(p);
		
		System.out.println("\nPedido inserido!\n");
	}

	@Override
	public void atualiza() {
		
		System.out.println("\nAtualiza Pedido\n");
		lista();

		Pedido p = buscaRegistro();
		
		if (p == null) {
			return;
		}
		
		p = preencheCampos(p);
		if (p == null) {
			return;
		}
		crud.atualiza(p);
		
		System.out.println("\nPedido atualizado!\n");
	}

	@Override
	public int lista() {
		
		System.out.println("\nPedidos\n");
		
		List<Registro> pedidos = crud.lista();
		for (Registro r : pedidos) {
			System.out.println((Pedido) r);
		}
		
		System.out.println();
		
		return pedidos.size();
	}

	@Override
	public void exclui() {
		System.out.println("\nExclui Pedido\n");
		lista();
		Pedido p = buscaRegistro();
		if (p == null) {
			return;
		}
		
		crud.exclui(p.getId());
		
		System.out.println("\nPedido excluido!\n");
		
	}

	@Override
	public String getTitulo() {
		return "PEDIDOS";
	}

	@Override
	public Scanner getScanner() {
		return scanner;
	}
	
	public Pedido buscaRegistro() {
		
		System.out.print("Id: ");
		int idPedido = scanner.nextInt();
		scanner.nextLine();
		
		Pedido p = (Pedido) crud.busca(idPedido);
		if (p == null) {
			System.out.println("Id "+ idPedido + " nao encontrado!\n");
		}
		
		return p;
	}
	
	private Pedido preencheCampos(Pedido p) {
		
		int numClientes = menuCliente.lista();
		
		if (numClientes == 0) {
			System.out.println("Nao ha clientes registrados!");
			return null;
		}
		
		Cliente c = menuCliente.buscaRegistro();
		if (c == null) {
			return null;
		}
		
		p.setCliente(c);
		
		int numPassagens = menuPassagem.lista();
		if (numPassagens == 0) {
			System.out.println("Nao ha passagens registradas!");
			return null;
		}
		
		Passagem pa = menuPassagem.buscaRegistro();
		if (pa == null) {
			return null;
		}
		
		p.setPassagem(pa);
		
		double precoMedio = pa.getDestino().getPrecoMedio();
		Promocao pr = pa.getPromocao();
		double desconto = pr == null ? 0 : pr.getDesconto();
		double precoCompra = precoMedio - desconto;
		p.setPrecoCompra(precoCompra);
		
		int numFormasPagamento = menuFormaPagamento.lista();
		if (numFormasPagamento == 0) {
			System.out.println("Nao ha formas de pagamento registradas!");
			return null;
		}
		
		FormaPagamento f = menuFormaPagamento.buscaRegistro();
		if (f == null) {
			return null;
		}
		p.setFormaPagamento(f);
		
		System.out.print("Data da compra (aaaa-mm-dd): ");
		LocalDate dataCompra = LocalDate.parse(scanner.nextLine());
		
		System.out.print("Hora da compra (HH:MM): ");
		LocalTime horaCompra = LocalTime.parse(scanner.nextLine());
		
		p.setDataCompra(dataCompra);
		p.setHoraCompra(horaCompra);
		
		return p;
	}

}
