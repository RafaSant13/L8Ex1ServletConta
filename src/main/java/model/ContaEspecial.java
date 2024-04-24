package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaEspecial extends ContaBancaria{
	
	private float limite;

	public ContaEspecial() {
		setConta("Conta 1");
		setNumConta(1);
		setSaldo(1000);
		setLimite(500);
	}

	
	
	@Override
	public String sacar(float valor) {
		if (valor>(getSaldo()+limite)) {
			return "Saldo Insuficiente; Saldo: R$"+getSaldo()+"; Limite: R$"+limite;
		}
		else {
			float saldo = getSaldo() - valor;
			if (saldo<0) {
				float limite = getLimite() + saldo;
				setLimite(limite);
			}
			setSaldo(saldo);
			return "Valor Sacado";
		}
	}



	@Override
	public String toString() {
		return "Conta Especial "+getConta()+"; Número da Conta: "+getNumConta()+"; Saldo: R$"+getSaldo()+"; Limite: R$"+getLimite();
	}

	
}
