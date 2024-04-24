package model;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ContaBancaria {
	
	private String conta;
	private int numConta;
	private float saldo;

	public ContaBancaria() {
		this.conta = "";
		this.numConta = 0;
		this.saldo = 0;
	}


	public void setSaldo(float saldo) {
		if (saldo < 0) {
			this.saldo = 0;
		}
		else {
			this.saldo = saldo;
		}
		
	}
	
	public String sacar(float valor) {
		if (valor>saldo) {
			return "Saldo Insuficiente; Saldo: R$"+saldo;
		}
		else {
			this.saldo = saldo - valor;
			return "Valor sacado";
		}
	}
	
	public String deposito(float valor) {
		this.saldo = saldo + valor;
		return "Valor Depositado";
	}
	
	

}
