package br.com.banco;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Cliente {

	private String nome;
	private String cpf; // Novo atributo
	private String endereco; // Novo atributo

}