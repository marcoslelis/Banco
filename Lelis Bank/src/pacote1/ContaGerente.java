package pacote1;

import java.util.ArrayList;

public class ContaGerente {
	
	String nome;
	int login, senha;
	
	ArrayList<ContaUsuario> ListaUsuario = new ArrayList();
	
	public int getLogin()
	{
		return login;
	}
	
	public int getSenha()
	{
		return senha;
	}
	
	public String getNome()
	{
		return nome;
	}
	
	public ContaGerente (String nome, int login, int senha)
	{
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}
	

}
