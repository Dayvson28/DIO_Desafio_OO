package br.com.banco;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public abstract class Conta implements IConta {

	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected double taxa; // Novo atributo
	protected Cliente cliente;
	protected List<Transacao> historicoTransacoes; // Novo atributo

	public Conta(Cliente cliente) {
		this.agencia = AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.historicoTransacoes = new ArrayList<>();
	}

	@Override
	public void sacar(double valor) {

		saldo -= valor;
		historicoTransacoes.add(new Transacao("Saque", valor));
	}

	@Override
	public void depositar(double valor) {

		saldo += valor;
		historicoTransacoes.add(new Transacao("Depósito", valor));
	}

	@Override
	public void transferir(double valor, Conta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
		historicoTransacoes.add(new Transacao("Transferência enviada", valor));
		contaDestino.getHistoricoTransacoes().add(new Transacao("Transferência recebida", valor));
	}
	protected void imprimirInfosComuns() {

		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
		System.out.println(String.format("Taxa: %.2f", this.taxa));
	}

	public void imprimirHistoricoTransacoes() {
		System.out.println("Historico de Transações:");
		for (Transacao transacao : historicoTransacoes) {
			System.out.println(transacao);
		}
	}

	public void ajustarTaxa(double novaTaxa) {
		this.taxa = novaTaxa;
		historicoTransacoes.add(new Transacao("Ajuste de Taxa", novaTaxa));
	}

}
