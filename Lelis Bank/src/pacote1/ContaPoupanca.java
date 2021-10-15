package pacote1;

public class ContaPoupanca extends Conta {
	
	public int sacar(double valor)
	{
		if(valor <= 110.000)
		{
			if((saldo - valor) < 0)
			{
				System.out.println("Saque nao efetuado, saldo indisponivel!");
				return -1;
			}
			else
			{
				saldo = saldo - valor;
				System.out.println("Saque efetuado com sucesso!");
				System.out.printf("Saldo atualizado: %.2f\n", saldo);
				return 1;
			}	
		}
		else
		{
			System.out.println("Valor muito alto para ser sacado, contate o gerente");
			return -1;
		}	
	}
	
	public int sacarGerente(double valor)
	{
		if((saldo - valor) < 0)
		{
			System.out.println("Saque nao efetuado, saldo insuficiente!");
			return -1;
		}
		else
		{
			saldo = saldo - valor;
			System.out.println("Saque efeutado com sucesso!");
			System.out.printf("Saldo atualizado: %.2f\n", saldo);
			return 1;
		}
	}
	
	private void render(double rendimento)
	{
		saldo = saldo + (saldo * rendimento);
	}
	
	public ContaPoupanca(int idConta)
	{
		this.saldo = 0.0;
		this.idConta = idConta;
	}
	ContaPoupanca()
	{}
}
