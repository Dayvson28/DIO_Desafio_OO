package br.com.banco;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class Banco {
	
	private String nome;
	private List<Conta> contas;

	

	public Banco(String nome) {
		this.nome = nome;
		this.contas = new ArrayList<>();
	}
	
	public void adicionarConta(Conta conta) {
		contas.add(conta);
	}
	
}
