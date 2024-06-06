package br.com.banco;

public class ContaCorrente extends Conta {

	private double limite; // novo atributo

	public ContaCorrente(Cliente cliente, double limite) {
		super(cliente);
		this.limite = limite;
	}

	@Override
	public void sacar(double valor) {
		if (saldo + limite >= valor) {
			super.sacar(valor);
		} else

		{
			System.out.println("Saldo Insuficiente.");
		}
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Corrente ===");
		super.imprimirInfosComuns();
		System.out.println(String.format("Limite: %.2f", this.limite));
		imprimirHistoricoTransacoes();
	}
	
	public void setLimite(double limite) {
		this.limite = limite;
	}
}
