package conta.controller;

import java.util.ArrayList;

import conta.model.conta;
import conta.repository.contaRepository;

public class contaController implements contaRepository {
	
	private ArrayList <conta> listaContas = new ArrayList <conta> ();
	int numero = 0;

	@Override
	public void procurarPorNumero(int numero) {
			var conta = buscarNaCL(numero);
			if (conta != null)
				conta.visualizar();
			else 
				System.out.println("\nA conta de número " + numero + " não foi encontrada");
			return;
	}

	@Override
	public void listarTodas() {
		for (var conta : listaContas) {
			conta.visualizar();
		}
	}

	@Override
	public void cadastrar(conta Conta) {
		listaContas.add(Conta);
		System.out.println("\n A conta número: " + conta.getNumero() + " foi criada com sucesso");
	}

	@Override
	public void atualizar(conta Conta) {
		var buscaConta = buscarNaCL(conta.getNumero());
		
		if (buscaConta != null) {
			listaContas.set(listaContas.indexOf(buscaConta), Conta);
			System.out.println("\n A conta de número: " + conta.getNumero() + " foi atualizada");
		} else 
			System.out.println("\n A conta de número: " + conta.getNumero() + " não foi encontrada");
	}

	@Override
	public void deletar(int numero) {
		var conta =	buscarNaCL(numero);
		
		if (conta !=null) {
			if (listaContas.remove(conta) == true)
				System.out.println("\n A conta de número: " + numero + " foi deletada ");
		}else 
			System.out.println("A conta de número " + numero + " não foi encontrada");
	}

	@Override
	public void sacar(int numero, float valor) {
		var conta = buscarNaCL(numero);
		
		if (conta != null) {
		
		if (conta.sacar(valor) == true);
		System.out.println("O saque da conta de número: " + numero + " foi efetuado com sucesso");
		} else 
			System.out.println("A conta de número: " + numero + " não foi efetuado");
		
	}

	@Override
	public void depositar(int numero, float valor) {
		var conta = buscarNaCL (numero);
		if (conta !=null) {
			conta.depositar(valor);
			System.out.println("O depósito da conta: " + numero + " foi efetuado com sucesso");
		}else 
			System.out.println("\n A conta: " + numero + " não foi encontrada ou não é uma conta corrente");
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		var contaOrigem = buscarNaCL(numeroOrigem);
		var contaDestino = buscarNaCL (numeroDestino);
		
		if (contaOrigem !=null && contaDestino != null) {
			
			if (contaOrigem.sacar(valor) == true) {
				contaDestino.depositar(valor);
				System.out.println("A transferência foi efetuada com sucesso");
			}
		}else 
			System.out.println("A conta origem e/ou destino não foram encontrada");
		
		
	}
	
	public int gerarNumero() {
		return ++ numero;
	}
	
	public conta buscarNaCL(int numero) {
		for (var conta : listaContas) {
			if (conta.getNumero() == numero) {
				return conta;
			}
			
		}
		return null;
	}

}
