package br.com.banco;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Transacao {
	private String tipo;
	private double valor;
}
