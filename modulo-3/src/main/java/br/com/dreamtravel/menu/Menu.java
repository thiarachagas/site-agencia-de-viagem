package br.com.dreamtravel.menu;

import java.util.Scanner;

public interface Menu {

	default void exibeMenu() {
		
		Scanner scanner = getScanner();
		
		while (true) {
			
			System.out.println();
			System.out.println(getTitulo());
			System.out.println("1) Lista");
			System.out.println("2) Insere");
			System.out.println("3) Atualiza");
			System.out.println("4) Exclui");
			System.out.println("0) Volta");
			System.out.print("Selecione uma opcao: ");
			
			int opcao = scanner.nextInt();
			// captura o enter emitido após digitar um número
			// evita que o enter atrapalhe uma leitura subsequente do teclado
			scanner.nextLine();
			
			switch (opcao) {
				case 1:
					lista();
					break;
				case 2:
					insere();
					break;
				case 3:
					atualiza();
					break;
				case 4:
					exclui();
					break;
				case 0:
					return;
				default:
					System.out.println("Opcao invalida!\n");
			}	
		}
	}
	
	void insere();
	
	void atualiza();
	
	int lista();
	
	void exclui();
	
	String getTitulo();
	
	Scanner getScanner();
}
