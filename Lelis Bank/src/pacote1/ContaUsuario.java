package pacote1;

import java.util.ArrayList;

public class ContaUsuario {
	
	public String nome, cidade, estado, pais, gerente;
	public int idade, RG, senha, Login;
	
	ArrayList<Conta> Contas = new ArrayList();
	
	
	public ContaUsuario(int Login, int senha, String nome, int RG, String cidade, String estado, String pais)
	{
		this.Login = Login;
		this.senha = senha;
		this.nome = nome;
		this.RG = RG;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
	}
	
	public ContaUsuario(int Login, int senha, String nome, int RG, String cidade, String estado, String pais, String gerente)
	{
		this.Login = Login;
		this.senha = senha;
		this.nome = nome;
		this.RG = RG;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
		this.gerente = gerente;
	}
	
	public ContaUsuario()
	{}
	
	private void setNome(String nome)
	{
		this.nome = nome;
	}
	private void setIdade(int idade)
	{
		this.idade = idade;
	}
	public void setSenha(int senha)
	{
		this.senha = senha;
	}
	private void setCidade(String cidade)
	{
		this.cidade = cidade;
	}
	private void setEstado(String estado)
	{
		this.estado = estado;
	}
	private void setPais(String pais)
	{
		this.pais = pais;
	}
	public void setrg(int RG)
	{
		this.RG = RG;
	}
	
	public String getNome()
	{
		return nome;
	}
	public int getIdade()
	{
		return idade;
	}
	public int getSenha()
	{
		return senha;
	}
	public String getCidade()
	{
		return cidade;
	}
	public String getEstado()
	{
		return estado;
	}
	public String getPais()
	{
		return pais;
	}
	public int getRG()
	{
		return RG;
	}
	public int getLogin()
	{
		return Login;
	}
	public void add(Conta c1) {
		// TODO Auto-generated method stub
		Contas.add(c1);
	}
	
	
}
