package conta_bancaria;

import java.util.InputMismatchException;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {

	private static final Scanner leia = new Scanner(System.in);
	private static final ContaController contaController = new ContaController();

	public static void main(String[] args) {

		criarContasTeste();

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
			System.out.println("                                                      " + Cores.TEXT_RESET);

			try {

				opcao = leia.nextInt();
				leia.nextLine();

			} catch (InputMismatchException e) {
				opcao = -1;
				System.out.println("\nDigite um número inteiro!");
				leia.nextLine();
			}

			if (opcao == 0) {
				System.out.println("\nBanco do Brazil com Z - O seu futuro começa aqui!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {

			case 1:
				System.out.println(Cores.TEXT_WHITE + "Criar Conta \n\n");

				cadastrarConta();

				keypress();
				break;

			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todas as Contas \n\n");

				listarContas();

				keypress();
				break;

			case 3:
				System.out.println(Cores.TEXT_WHITE + "Buscar Conta - Por Número \n\n");

				keypress();
				break;

			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar Dados da Conta \n\n");

				keypress();
				break;

			case 5:
				System.out.println(Cores.TEXT_WHITE + "Apagar a Conta \n\n");

				keypress();
				break;

			case 6:
				System.out.println(Cores.TEXT_WHITE + "Saque \n\n");

				keypress();
				break;

			case 7:
				System.out.println(Cores.TEXT_WHITE + "Deposito \n\n");

				keypress();
				break;

			case 8:
				System.out.println(Cores.TEXT_WHITE + "Transferencia entre Contas \n\n");

				keypress();
				break;
			default:
				System.out.print(Cores.TEXT_RED_BOLD + "\nOpção Invalida!!!\n" + Cores.TEXT_RESET);

				keypress();
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

	public static void keypress() {
		System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
		leia.nextLine();
	}

	private static void listarContas() {

		contaController.listarTodas();

	}

	private static void cadastrarConta() {

		System.out.println("Digite o numero da Agencia: ");
		int agencia = leia.nextInt();

		System.out.println("Digite o nome do Titular: ");
		leia.skip("\\R");
		String titular = leia.nextLine();

		System.out.print("Digite o tipo da conta (1 - CC | 2 - CP): ");
		int tipo = leia.nextInt();

		System.out.println("Digite o Saldo inicial da conta: ");
		float saldo = leia.nextFloat();

		switch (tipo) {
		case 1 -> {
			System.out.println("Digite o limite da conta: ");
			float limite = leia.nextFloat();
			contaController
					.cadastrar(new ContaCorrente(contaController.gerarNumero(), agencia, tipo, titular, saldo, limite));

		}
		case 2 -> {
			System.out.println("Digite o dia do aniversario da conta: ");
			int aniversario = leia.nextInt();
			contaController.cadastrar(
					new ContaPoupanca(contaController.gerarNumero(), agencia, tipo, titular, saldo, aniversario));

		}
		default -> System.out.println(Cores.TEXT_RED_BOLD + "Tipo de conta invalido!" + Cores.TEXT_RESET);
		}
	}

	private static void criarContasTeste() {
		contaController
				.cadastrar(new ContaCorrente(contaController.gerarNumero(), 123, 1, "João da Silva", 100.00f, 100.00f));
		contaController.cadastrar(
				new ContaCorrente(contaController.gerarNumero(), 456, 1, "Maria dos Santos", 2000.00f, 200.00f));
		contaController.cadastrar(
				new ContaCorrente(contaController.gerarNumero(), 789, 2, "Mariana Hernandez", 10000.00f, 12));
		contaController.cadastrar(
				new ContaCorrente(contaController.gerarNumero(), 123, 2, "Giovanna Giunchetti", 8000.00f, 23));

	}

}
