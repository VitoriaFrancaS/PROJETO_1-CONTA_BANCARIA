package conta.controller;

import java.util.ArrayList;

import conta.model.conta;
import conta.repository.contaRepository;

public class contaController implements contaRepository {
	
	private ArrayList <conta> listaContas = new ArrayList <conta> ();
	int numero = 0;

	@Override
	public void procurarPorNumero(int numero) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(int numero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sacar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void depositar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		// TODO Auto-generated method stub
		
	}
	
	public int gerarNumero() {
		return ++ numero;
	}
	
	

}
