package br.com.banco;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Gerente {
	private String nome;
	private String cpf;
	private String matricula;

	public Gerente(String nome, String cpf, String matricula) {
		this.nome = nome;
		this.cpf = cpf;
		this.matricula = matricula;
	}
	
	public void ajustarLimite(ContaCorrente conta, double novoLimite) {
		conta.setLimite(novoLimite);
	}
	
	public void ajustarTaxa(Conta conta, double novaTaxa) {
		conta.ajustarTaxa(novaTaxa);
	}

}
