package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ContaPoupanca extends ContaBancaria{
	
	private int diaRendimento;

	public ContaPoupanca() {
		setConta("Conta 2");
		setNumConta(2);
		setSaldo(2000);
		setDiaRendimento(15);
	}

	
	public String calcNovoSaldo(float taxa){
		float saldo = getSaldo();
		if (taxa < 0) {
			return "Taxa de rendimento inválida";
		} else {
			saldo = saldo + (saldo * (taxa * 0.01f));
			setSaldo(saldo);
			return "Seu novo saldo é: R$" + saldo;
		}
	}
	
	@Override
	public String toString() {
		return "Conta Poupança "+getConta()+"; Número da Conta: "+getNumConta()+"; Saldo: R$"+getSaldo()+"; Dia de Rendimento: dia "+getDiaRendimento();
	}
}
