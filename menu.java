package contaBancaria;

import java.util.InputMismatchException;
import java.util.Scanner;

import conta.model.conta;
import conta.util.Cores;
import conta.model.contaPoupanca;
import conta.model.contaCorrente;

public class menu {

	public static void main(String[] args) {

				Scanner input = new Scanner(System.in);

				int opcao;
				
				 
				
		        
				System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND);

				contaCorrente cc1 = new contaCorrente(1, 123, 1, "Claudio Roberto", 0.0f, 1000.0f);
				cc1.visualizar();
				cc1.sacar(12000.0f);
				cc1.visualizar();
				cc1.depositar(5000.0f);
				cc1.visualizar();
				
		  
				contaPoupanca cp1 = new contaPoupanca(2, 123, 2, "Careca Junior", 100000.0f, 15);
				cp1.visualizar();
		        cp1.sacar(1000.0f);
				cp1.visualizar();
				cp1.depositar(5000.0f);
				cp1.visualizar();
				System.out.println("                                                 "+ Cores.TEXT_RESET);

				while (true) {

					System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
							+ "*****************************************************");
					System.out.println("                                                     ");
					System.out.println("                BANCO FAMÍLIA 69                     ");
					System.out.println("                                                     ");
					System.out.println("*****************************************************");
					System.out.println("                                                     ");
					System.out.println("            1 - Criar Conta                          ");
					System.out.println("            2 - Listar todas as Contas               ");
					System.out.println("            3 - Buscar Conta por Numero              ");
					System.out.println("            4 - Atualizar Dados da Conta             ");
					System.out.println("            5 - Apagar Conta                         ");
					System.out.println("            6 - Sacar                                ");
					System.out.println("            7 - Depositar                            ");
					System.out.println("            8 - Transferir valores entre Contas      ");
					System.out.println("            9 - Sair                                 ");
					System.out.println("                                                     ");
					System.out.println("*****************************************************");
					System.out.println("Entre com a opção desejada:                          ");
					System.out.println("                                                     " + Cores.TEXT_RESET);
					
					try {
						opcao =input.nextInt();
					}catch (InputMismatchException e){
						System.out.println("\nDigite valores inteiros!");
						input.nextLine();
						opcao=0;
					}

					opcao = input.nextInt();

					if (opcao == 9) {
						System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco Família 69 - O seu Futuro começa aqui!");
		                  		sobre();
						input.close();
						System.exit(0);
					}

					switch (opcao) {
					case 1:
						System.out.println(Cores.TEXT_WHITE_BOLD + "Criar Conta\n\n");

						break;
					case 2:
						System.out.println(Cores.TEXT_WHITE_BOLD + "Listar todas as Contas\n\n");

						break;
					case 3:
						System.out.println(Cores.TEXT_WHITE_BOLD + "Consultar dados da Conta - por número\n\n");

						break;
					case 4:
						System.out.println(Cores.TEXT_WHITE_BOLD + "Atualizar dados da Conta\n\n");

						break;
					case 5:
						System.out.println(Cores.TEXT_WHITE_BOLD + "Apagar a Conta\n\n");

						break;
					case 6:
						System.out.println(Cores.TEXT_WHITE_BOLD + "Saque\n\n");

						break;
					case 7:
						System.out.println(Cores.TEXT_WHITE_BOLD + "Depósito\n\n");

						break;
					case 8:
						System.out.println(Cores.TEXT_WHITE_BOLD + "Transferência entre Contas\n\n");

						break;
					default:
						System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n");
						break;
					}
				}

			}
    
	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("Vitória França-vitoria.s.franca07@gmail.com e Generation Brasil - generation@generation.org");
		System.out.println("https://github.com/VitoriaFrancaS github.com/conteudoGeneration");
		System.out.println("*********************************************************");

	}

}
