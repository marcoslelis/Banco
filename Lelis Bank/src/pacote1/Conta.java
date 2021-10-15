package pacote1;

public abstract class Conta {
	
	public double saldo;
	public int idConta, senha;
	
	
	
	public int getIdConta() {
		return idConta;
	}

	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}
	public int getSenha()
	{
		return senha;
	}

	private double getSaldo()
	{
		return saldo;
	}
	
	public void depositar(double valor)
	{
		saldo = saldo + valor;
		System.out.println("Deposito efetuado com sucesso!");
		System.out.printf("Saldo atualizado: %.2f\n", saldo);
	}
	
	public int sacar(double valor)
	{
		if(valor <= 110.000)
		{
			if((saldo - valor) > 0)
			{
				saldo = saldo - valor;
				System.out.println("Saque efetuado com sucesso!");
				System.out.printf("Saldo atualizado: %.2f\n", saldo);
				return 1;
			}
			else
			{
				System.out.println("Saque nao efetuado, saldo insuficiente!");
				return -1;
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
		if((saldo - valor) >= 0)
		{
			saldo = saldo - valor;
			System.out.println("Saque efetuado com sucesso!");
			System.out.printf("Saldo atualizado: %.2f\n", saldo);
			return 1;
		}
		else
		{
			System.out.println("Saque nao efetuado, saldo insuficiente!");
			return -1;
		}
	}
	
	public void setLimite(double limite) // metodo criado somente para ser possivel ser usado, uma vez que existe somente na especial
	{
		
	}
	
	public void verSaldo()
	{
		System.out.printf("Saldo disponivel em conta: %.2f\n", getSaldo());
	}
}
