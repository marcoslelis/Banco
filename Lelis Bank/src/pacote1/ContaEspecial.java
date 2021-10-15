package pacote1;

public class ContaEspecial extends Conta{
	
	private double limite;
	
	public int sacar(double valor)
	{
		if(valor <= 110.000)
		{
			if((saldo - valor) < 0)
			{
				if((saldo + limite) > 0)
				{
					System.out.println("Saque efetuado com sucesso! (Limite utilizado)");
					saldo = (saldo + limite) - valor;
					System.out.printf("Saldo + Limite Atualizado: %.2lf\n", saldo+ limite);
					return 1;
				}
				else
				{
					System.out.println("Saldo insuficiente. Saque nao efetuado");
					return -1;
				}
			}
			else
			{
				saldo = saldo - valor;
				System.out.println("Saque efetuado com sucesso!");
				System.out.printf("Saldo atualizado: %.2lf\n", saldo);
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
			if((saldo + limite) > 0)
			{
				System.out.println("Saque efetuado com sucesso! (Limite utilizado)");
				saldo = (saldo + limite) - valor;
				System.out.printf("Saldo + Limite Atualizado: %.2lf\n", saldo+ limite);
				return 1;
			}
			else
			{
				System.out.println("Saldo insuficiente. Saque nao efetuado");
				return -1;
			}
		}
		else
		{
			System.out.println("Saque efetuado com sucesso!");
			System.out.printf("Saldo atualizado: %.2lf\n", saldo);
			return 1;
		}
	}
	
	public ContaEspecial(int idConta, double limite)
	{
		this.saldo = 0.0;
		this.idConta = idConta;
		this.limite = limite;
	}
	public ContaEspecial()
	{}
	
	public void setLimite(double limite)
	{
		this.limite = limite;
	}
}
