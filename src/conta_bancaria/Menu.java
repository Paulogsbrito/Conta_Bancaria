package conta_bancaria;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);

		int opcao;

		while (true) {

			System.out.println("******************************************************");
			System.out.println("                                                      ");
			System.out.println("               BANCO DO BRAZIL COM Z                  ");
			System.out.println("                                                      ");
			System.out.println("******************************************************");
			System.out.println("                                                      ");
			System.out.println("              1 - Criar Conta                         ");
			System.out.println("              2 - Listar todas as Contas              ");
			System.out.println("              3 - Buscar Conta Por Numero             ");
			System.out.println("              4 - Atualizar Dados da Conta            ");
			System.out.println("              5 - Apagar Dados da Conta               ");
			System.out.println("              6 - Sacar                               ");
			System.out.println("              7 - Depositar                           ");
			System.out.println("              8 - Transferir Valores entre Contas     ");
			System.out.println("              0 - Sair                                ");
			System.out.println("                                                      ");
			System.out.println("******************************************************");
			System.out.println(" Entre com a opção Desejada:                          ");
			System.out.println("                                                      ");

			opcao = leia.nextInt();

			if (opcao == 0) {
				System.out.println("\nBanco do Brazil com Z - O seu futuro começa aqui!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {

			case 1:
				System.out.println("Criar Conta \n\n");
				break;

			case 2:
				System.out.println("Listar todas as Contas \n\n");
				break;

			case 3:
				System.out.println("Buscar Conta - Por Número \n\n");

				break;

			case 4:
				System.out.println("Atualizar Dados da Conta \n\n");
				break;

			case 5:
				System.out.println("Apagar a Conta \n\n");

				break;

			case 6:
				System.out.println("Saque \n\n");

				break;

			case 7:
				System.out.println("Deposito \n\n");

				break;

			case 8:
				System.out.println("Transferencia entre Contas \n\n");

				break;
			default:
				System.out.print("\nOpção Invalida!!!\n");
				break;
			}

		}

	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Paulo Gustavo Brito");
		System.out.println("Generation Brasil - paulogsbrito@gmail.com");
		System.out.println("https://github.com/Paulogsbrito");
		System.out.println("***********************************************************");
	}

}
