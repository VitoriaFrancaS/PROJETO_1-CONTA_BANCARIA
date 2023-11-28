package contaBancaria;

import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.contaController;
import conta.model.conta;
import conta.util.Cores;
import conta.model.contaPoupanca;
import conta.model.contaCorrente;

public class menu {

	public static void main(String[] args) {
		
		contaController contas = new contaController();

				Scanner input = new Scanner(System.in);

				int opcao, numero, agencia, tipo, aniversario, numDestino;
				String titular;
				float saldo, limite, valor;
				
				System.out.println("\n Criar Contas\n");
				
				contaCorrente cc1 = new contaCorrente(contas.gerarNumero(), 123, 1, "João Zulu", 1000f, 100.0f);
				contas.cadastrar(cc1);
				
				contaCorrente cc2 = new contaCorrente(contas.gerarNumero(), 124, 1, "Maria Zulu", 2000f, 100.0f);
				contas.cadastrar(cc2);
				
				contaPoupanca cp1 = new contaPoupanca(contas.gerarNumero(), 125, 2, "Vin Diesel", 4000f, 12);
				contas.cadastrar(cp1);
				
				contaPoupanca cp2 = new contaPoupanca(contas.gerarNumero(), 126, 2, "Groot Rocket", 8000f, 15);
				contas.cadastrar(cp2);
					
				contas.listarTodas();


				
				
				

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
						
						System.out.println("Digite o número da agência: ");
						agencia = input.nextInt();
						System.out.println("Digite o nome do titular: ");
						input.skip("\\R?");
						titular = input.nextLine();
						
						do {
							System.out.println("Digite o tipo da conta (1-CC ou 2-CP: ");
							tipo = input.nextInt();
						}while(tipo < 1 && tipo > 2);
						
						System.out.println("Digite o saldo da conta (R$): ");
						saldo = input.nextFloat();
						
						switch(tipo) {
						case 1 -> {
							System.out.println("Digite o limite de crédito (R$): ");
							limite = input.nextFloat();
							contas.cadastrar (new contaCorrente (contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
							}
						case 2 -> {
							System.out.println("Digite o dia do aniversário da conta: ");
							aniversario = input.nextInt();
							contas.cadastrar (new contaPoupanca (contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));

							}
						}
						keyPress();
						break;
					case 2:
						System.out.println(Cores.TEXT_WHITE_BOLD + "Listar todas as Contas\n\n");
						contas.listarTodas();
						keyPress();

						break;
					case 3:
						System.out.println(Cores.TEXT_WHITE_BOLD + "Consultar dados da Conta - por número\n\n");
						System.out.println("Digite o número da conta: ");
						numero = input.nextInt();
						
						contas.procurarPorNumero(numero);
						
						keyPress();


						break;
					case 4:
						System.out.println(Cores.TEXT_WHITE_BOLD + "Atualizar dados da Conta\n\n");
						
						System.out.println("Digite o número da conta: ");
						numero = input.nextInt();
						
						var buscaConta = contas.buscarNaCL(numero);
						
						if (buscaConta !=null) {
						
						tipo = buscaConta.getTipo();
						
						System.out.println("Digite o Numero da Agência: ");
						agencia = input.nextInt();
						System.out.println("Digite o Nome do Titular: ");
						input.skip("\\R?");
						titular = input.nextLine();
							
						System.out.println("Digite o Saldo da Conta (R$): ");
						saldo = input.nextFloat();
						
						switch(tipo) {
						case 1 -> {
							System.out.println("\n Digite o limite de crédito (R$): ");
							limite = input.nextFloat();
							
							contas.atualizar(new contaCorrente(numero, agencia, tipo, titular, saldo, limite));
						}
						case 2 -> {
							System.out.println("Digite o aniversário da conta: ");
							aniversario = input.nextInt();
							
							contas.atualizar(new contaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
							
						}
						default -> {
							System.out.println("Tipo de conta inválida");
						}
						}
						
						} else {
							System.out.println("A conta não foi encontrada");
						}
						
						keyPress();
						break;
					case 5:
						System.out.println(Cores.TEXT_WHITE_BOLD + "Apagar a Conta\n\n");
						
						System.out.println("Digite o número da conta: ");
						numero = input.nextInt();
						
						contas.deletar(numero);
						
						keyPress();
						break;
					case 6:
						System.out.println(Cores.TEXT_WHITE_BOLD + "Saque\n\n");
						
						System.out.println("Digite o número da conta: ");
						numero = input.nextInt();
						
						do {
							System.out.println("Digite o valor do saque: ");
							valor = input.nextFloat();
						}while(valor <=0);
						
						contas.sacar(numero, valor);
						
						keyPress();
						break;
					case 7:
						System.out.println(Cores.TEXT_WHITE_BOLD + "Depósito\n\n");
						
						System.out.println("Digite o número da conta: ");
						numero = input.nextInt();
						
						do {
							System.out.println("Digite o valor do depósito: ");
							valor = input.nextFloat();
						}while (valor <=0);
						
						contas.depositar(numero, valor);
						
						keyPress();
						break;
					case 8:
						System.out.println(Cores.TEXT_WHITE_BOLD + "Transferência entre Contas\n\n");
						
						System.out.println("digite o número da conta de origem: ");
						numero = input.nextInt();
						System.out.println("Digite o número da conta de destino; ");
						numDestino = input.nextInt();
						
						do {
								System.out.println("Digite o valor de transferência: ");
								valor = input.nextFloat();
						}while(valor <=0);
						
						contas.transferir(numero, numDestino, valor);
						
						keyPress();
						break;
					default:
						System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n");
						break;
					}
				}

			}
    
	private static void keyPress() {
		// TODO Auto-generated method stub
		
	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("Vitória França-vitoria.s.franca07@gmail.com e Generation Brasil - generation@generation.org");
		System.out.println("https://github.com/VitoriaFrancaS github.com/conteudoGeneration");
		System.out.println("*********************************************************");

	}

}
