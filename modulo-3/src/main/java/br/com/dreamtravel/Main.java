package br.com.dreamtravel;

import java.util.List;
import java.util.Scanner;

import br.com.dreamtravel.menu.MenuCliente;
import br.com.dreamtravel.menu.MenuCompanhiaAerea;
import br.com.dreamtravel.menu.MenuDestino;
import br.com.dreamtravel.menu.MenuFormaPagamento;
import br.com.dreamtravel.menu.MenuPassagem;
import br.com.dreamtravel.menu.MenuPedido;
import br.com.dreamtravel.menu.MenuPromocao;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		MenuCliente menuCliente = new MenuCliente(scanner);
		MenuCompanhiaAerea menuCompanhiaAerea = new MenuCompanhiaAerea(scanner);
		MenuFormaPagamento menuFormaPagamento = new MenuFormaPagamento(scanner);
		MenuDestino menuDestino = new MenuDestino(scanner);
		MenuPromocao menuPromocao = new MenuPromocao(scanner);
		MenuPassagem menuPassagem = new MenuPassagem(scanner);
		MenuPedido menuPedido = new MenuPedido(scanner);
		
		while (true) {
			
			System.out.println("\nDream Travel Console");
			System.out.println("1) Cliente");
			System.out.println("2) Companhia Aerea");
			System.out.println("3) Forma de Pagamento");
			System.out.println("4) Destino");
			System.out.println("5) Promocao");
			System.out.println("6) Passagem");
			System.out.println("7) Pedido");
			System.out.println("0) Sair");
			System.out.print("Selecione uma opcao: ");
			
			int opcao = scanner.nextInt();
			scanner.nextLine();
			
			switch (opcao) {
				case 1:
					menuCliente.exibeMenu();
					break;
				case 2:
					menuCompanhiaAerea.exibeMenu();
					break;
				case 3:
					menuFormaPagamento.exibeMenu();
					break;
				case 4:
					menuDestino.exibeMenu();
					break;
				case 5:
					menuPromocao.exibeMenu();
					break;
				case 6:
					menuPassagem.exibeMenu();
					break;
				case 7:
					menuPedido.exibeMenu();
					break;
				case 0:
					return;
				default:
					System.out.println("Opcao invalida!\n");
			}
		}
		
	}

}
