package br.com.banco;

public class Main {

	public static void main(String[] args) {

		Cliente cliente = new Cliente("João Silva", "123.456.789-00", "Rua das Flores, 123");

		Conta cc = new ContaCorrente(cliente, 500);

		Conta poupanca = new ContaPoupanca(cliente);

		cc.depositar(1000);
		cc.transferir(300, poupanca);

		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
		
		Gerente gerente = new Gerente("David", "987.654.321-00", "GER001");
		gerente.ajustarLimite((ContaCorrente) cc, 1000);
		gerente.ajustarTaxa(cc, 15.0);
		gerente.ajustarTaxa(poupanca, 10.0);
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();

	}

}
