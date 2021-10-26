package pacote1;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {		
		
		Scanner ler = new Scanner(System.in);
		
		ArrayList<ContaGerente> ListaGerente = new ArrayList();
		Conta c1, c1aux;
		ContaUsuario c2;
		ContaGerente Adm = new ContaGerente("Marcos", 123, 123);
		ListaGerente.add(Adm);
		
		int usuario;
		int sair = 0, sairGerente = 0, login, senha, auxInt, auxInt2, auxInt3, auxInt4, posicaoGerente, posicaoUsuario, posicaoConta, posicaoConta2;
		String nome, cidade, estado, pais, gerente, auxString, auxString2;
		double auxDouble;
		int RG, sairTotal = 0;
		
		do
		{
			System.out.println("---------- MENU ----------");
			System.out.println("1 - Usuario");
			System.out.println("2 - Gerente");
			System.out.println("3 - Sair");
			
			usuario = ler.nextInt();
			
			if(usuario == 1)
			{
				System.out.println("---------- MENU ----------");
				System.out.println("1 - Abrir nova conta");
				System.out.println("2 - Fazer login");
				int menu1 = ler.nextInt();
				
				switch(menu1)
				{
				// Abrir nova conta
				case 1: 
						System.out.println("Digite o login: ");
						login = ler.nextInt();
						System.out.println("Digite a senha: ");
						senha = ler.nextInt();
						
						auxInt = descobrirGerenteDoUsuario(login, senha, ListaGerente);
						if(auxInt == 999)
							break;
						else
							posicaoGerente = auxInt;
						auxInt2 = fazerLoginUsuario(login, senha, ListaGerente.get(posicaoGerente).ListaUsuario);
						
						if(auxInt2 == 999)
						{
							break;
						}
						else
						{
							posicaoUsuario = auxInt2;
						}
						cadastrarDados(posicaoGerente, posicaoUsuario, ListaGerente); // cadastra a nova conta no banco usando o indice do usuario no array de usuarios
					break;
					
				case 2:
					System.out.println("Login do usuario: ");
					login = ler.nextInt();
					System.out.println("Senha do usuario: ");
					senha = ler.nextInt();
					sair = 0;
					
					auxInt = descobrirGerenteDoUsuario(login, senha, ListaGerente);
					if(auxInt == 999)
						break;
					else
						posicaoGerente = auxInt;
					auxInt2 = fazerLoginUsuario(login, senha, ListaGerente.get(posicaoGerente).ListaUsuario); // coloca a posicao da conta do usuario dentro do array em auxInt
					
					if(auxInt2 == 999)
					{
						break;
					}
					else
					{
						posicaoUsuario = auxInt2;
					}
					do
					{
						contasUsuarioID(ListaGerente.get(posicaoGerente).ListaUsuario.get(posicaoUsuario).Contas);
						System.out.println("Digite a conta que deseja operar");
						auxInt2 = ler.nextInt();
						
						auxInt3 = pegarPosicaoConta(auxInt2, ListaGerente.get(posicaoGerente).ListaUsuario.get(posicaoUsuario).Contas);
						
						if(auxInt3 == 999)
						{
							break;
						}
						else
						{
							posicaoConta = auxInt3;
						}
						
						System.out.println("---------- MENU USUARIO ----------");
						System.out.println("1 - Depositar dinheiro");
						System.out.println("2 - Sacar dinheiro");
						System.out.println("3 - Ver o saldo");
						System.out.println("4 - Ver o extrato");
						System.out.println("5 - Alterar senha");
						System.out.println("6 - Sair");
						
						int menu1b = ler.nextInt();
						
						switch(menu1b)
						{
						case 1: 
							System.out.println("Digite o valor a ser depositado");
							auxDouble = ler.nextDouble();
							
							ListaGerente.get(posicaoGerente).ListaUsuario.get(posicaoUsuario).Contas.get(posicaoConta).depositar(auxDouble);
						break;
						
						case 2:
							System.out.println("Digite o valor a ser sacado:");
							auxDouble = ler.nextDouble();
	
							ListaGerente.get(posicaoGerente).ListaUsuario.get(posicaoUsuario).Contas.get(posicaoConta).sacar(auxDouble);
						break;
						
						case 3:
							ListaGerente.get(posicaoGerente).ListaUsuario.get(posicaoUsuario).Contas.get(posicaoConta).verSaldo(); 
						break;
						
						case 4:
							// Extrato
						break;
						
						case 5: 
							System.out.println("Digite a senha atual da conta");
							auxInt = ler.nextInt();
							
							if(auxInt == ListaGerente.get(posicaoGerente).ListaUsuario.get(posicaoUsuario).getSenha())
							{
								System.out.println("Digite a nova senha para a conta");
								auxInt = ler.nextInt();
								ListaGerente.get(posicaoGerente).ListaUsuario.get(posicaoUsuario).setSenha(auxInt);
								System.out.println("Senha alterada com sucesso!");
							}
							else
							{
								System.out.println("Senha incorreta!");
							}
							
						break;
							
						case 6:	
							sair = 1;
							System.out.println("Conta deslogada com sucesso!");
						break;
						} // switch operacao quando for login
						System.out.println("Deseja realizar outra transacao? 0 - SIM / 1 = NAO");
						sair = ler.nextInt();
					} while(sair != 1);
				}	// switch criar nova conta/login
			} // switch usuario/gerente
			else if(usuario == 2)
			{
				do
				{
					System.out.println("Digite o Login do gerente");
					login = ler.nextInt();
					System.out.println("Digite a senha do gerente");
					senha = ler.nextInt();
					
					auxInt = fazerLoginGerente(login, senha, ListaGerente);
					
					if(auxInt == 999)
					{
						break;
					}
					else
					{
						posicaoGerente = auxInt;
					}
					
					System.out.println("--------- MENU GERENTE ----------");
					System.out.println("1 - Exibe contas relacionados a um cliente");
					System.out.println("2 - Verificar extrato da conta de um cliente");
					System.out.println("3 - Aplicar dinheiro para um cliente");
					System.out.println("4 - Transferir dinheiro entre contas");
					System.out.println("5 - Retira dinheiro sem limite");
					System.out.println("6 - Cadastra/Edita limite da conta");
					System.out.println("7 - Cadastra um novo usuario");
					System.out.println("8 - Alterar senha");
					System.out.println("9 - Sair");
					
					int menu2 = ler.nextInt();
					
					switch(menu2)
					{
					case 1: System.out.println("Digite o RG do usuario que deseja fazer a operacao");
							RG = ler.nextInt();
							posicaoUsuario = pegarPosicaoUsuario(RG, ListaGerente.get(posicaoGerente).ListaUsuario);
							contasUsuarioID(ListaGerente.get(posicaoGerente).ListaUsuario.get(posicaoUsuario).Contas);
							 break;
							 
					case 2: // EXTRATO
							 break;
							 
					case 3: System.out.println("Digite o RG do usuario que deseja fazer a operacao");
							RG = ler.nextInt();
							auxInt2 = pegarPosicaoUsuario(RG, ListaGerente.get(posicaoGerente).ListaUsuario);	
							if(auxInt2 == 999)
								break;
							else
								posicaoUsuario = auxInt;
							contasUsuarioID(ListaGerente.get(posicaoGerente).ListaUsuario.get(posicaoUsuario).Contas);
							
							System.out.println("Digite o ID da conta que deseja aplicar");
							auxInt = ler.nextInt();
							auxInt2 = pegarPosicaoConta(auxInt, ListaGerente.get(posicaoGerente).ListaUsuario.get(posicaoUsuario).Contas);
							if(auxInt2 == 999)
								break;
							else
								posicaoConta = auxInt2;
							
							System.out.println("Digite o valor a ser depositado");
							auxDouble = ler.nextDouble();
							ListaGerente.get(posicaoGerente).ListaUsuario.get(posicaoUsuario).Contas.get(posicaoConta).depositar(auxDouble);
							break;
							
					case 4: System.out.println("Digite o RG do usuario que deseja fazer a operacao");
							RG = ler.nextInt();
							auxInt2 = pegarPosicaoUsuario(RG, ListaGerente.get(posicaoGerente).ListaUsuario);
							if(auxInt2 == 999)
								break;
							else
								posicaoUsuario = auxInt2;
							contasUsuarioID(ListaGerente.get(posicaoGerente).ListaUsuario.get(posicaoUsuario).Contas);
							System.out.println("Digite o ID da conta que deseja tirar o dinheiro");
							auxInt = ler.nextInt();
							auxInt2 = pegarPosicaoConta(auxInt, ListaGerente.get(posicaoGerente).ListaUsuario.get(posicaoUsuario).Contas);
							if(auxInt2 == 999)
								break;
							else
								posicaoConta = auxInt2;
							System.out.println("Digite o valor que deseja transferir");
							auxDouble = ler.nextDouble();
							
							System.out.println("Digite o ID da conta que deseja depositar o dinheiro");
							auxInt = ler.nextInt();
							auxInt2 = pegarPosicaoConta(auxInt, ListaGerente.get(posicaoGerente).ListaUsuario.get(posicaoUsuario).Contas);
							if(auxInt2 == 999)
								break;
							else
								posicaoConta2 = auxInt2;
							if((ListaGerente.get(posicaoGerente).ListaUsuario.get(posicaoUsuario).Contas.get(posicaoConta).sacarGerente(auxDouble)) == 1)
							{
								ListaGerente.get(posicaoGerente).ListaUsuario.get(posicaoUsuario).Contas.get(posicaoConta2).depositar(auxDouble);
							}
							break;
							
					case 5: System.out.println("Digite o RG do usuario que deseja fazer a operacao");
							RG = ler.nextInt();
							auxInt2 = pegarPosicaoUsuario(RG, ListaGerente.get(posicaoGerente).ListaUsuario);
							if(auxInt2 == 999)
								break;
							else
								posicaoUsuario = auxInt2;
							contasUsuarioID(ListaGerente.get(posicaoGerente).ListaUsuario.get(posicaoUsuario).Contas);
							System.out.println("Digite o ID da conta que deseja sacar o dinheiro");
							auxInt = ler.nextInt();
							auxInt2 = pegarPosicaoConta(auxInt, ListaGerente.get(posicaoGerente).ListaUsuario.get(posicaoUsuario).Contas);
							if(auxInt2 == 999)
								break;
							else
								posicaoConta = auxInt2;
							System.out.println("Digite o valor a ser sacado");
							auxDouble = ler.nextDouble();
							
							ListaGerente.get(posicaoGerente).ListaUsuario.get(posicaoUsuario).Contas.get(posicaoConta).sacarGerente(auxDouble);
							break;
					
					case 6: System.out.println("Digite o RG do usuario que deseja fazer a operacao");
							RG = ler.nextInt();
							auxInt2 = pegarPosicaoUsuario(RG, ListaGerente.get(posicaoGerente).ListaUsuario);
							if(auxInt2 == 999)
								break;
							else
								posicaoUsuario = auxInt2;
							contasUsuarioID(ListaGerente.get(posicaoGerente).ListaUsuario.get(posicaoUsuario).Contas);
							System.out.println("Digite o ID da conta que deseja editar o limite");
							auxInt = ler.nextInt();
							auxInt2 = pegarPosicaoConta(auxInt, ListaGerente.get(posicaoGerente).ListaUsuario.get(posicaoUsuario).Contas);
							if(auxInt2 == 999)
								break;
							else
								posicaoConta = auxInt2;
							if(ListaGerente.get(posicaoGerente).ListaUsuario.get(posicaoUsuario).Contas.get(posicaoConta) instanceof ContaEspecial)
							{
								System.out.println("Digite o limite que deseja colocar para esta conta");
								auxDouble = ler.nextDouble();
								ListaGerente.get(posicaoGerente).ListaUsuario.get(posicaoUsuario).Contas.get(posicaoConta).setLimite(auxDouble);
							}
							else
							{
								System.out.println("Esta conta nao eh do tipo Especial, portanto nao tem limite");
							}
							break;
					
					case 7: System.out.println("Digite o login da nova conta de usuario: ");
							auxInt = ler.nextInt();
							System.out.println("Digite a senha da nova conta de usuario: ");
							auxInt2 = ler.nextInt();
							System.out.println("Digite o nome: ");
							nome = ler.next();
							System.out.println("Digite o RG: ");
							RG = ler.nextInt();
							System.out.println("Digite a cidade: ");
							cidade = ler.next();
							System.out.println("Digite o estado: ");
							estado = ler.next();
							System.out.println("Digite o pais: ");
							pais = ler.next();
							gerente = ListaGerente.get(posicaoGerente).getNome();
					
							c2 = new ContaUsuario(auxInt, auxInt2, nome, RG, cidade, estado, pais, "Gerente");
							ListaGerente.get(posicaoGerente).ListaUsuario.add(c2);
							System.out.println("Cadastro de nova conta de usuairo realizado com sucesso!");
					
					case 8: System.out.println("Digite o RG do usuario que deseja efetuar a operacao");
							RG = ler.nextInt();
							auxInt2 = pegarPosicaoUsuario(RG, ListaGerente.get(posicaoGerente).ListaUsuario);
							if(auxInt2 == 999)
								break;
							else
								posicaoUsuario = auxInt2;
							
							System.out.println("Digite a senha atual da conta: ");
							auxInt = ler.nextInt();
							
							if(ListaGerente.get(posicaoGerente).ListaUsuario.get(posicaoUsuario).senha == auxInt)
							{
								System.out.println("Digite a nova senha da conta");
								auxInt = ler.nextInt();
								ListaGerente.get(posicaoGerente).ListaUsuario.get(posicaoUsuario).setSenha(auxInt);
								System.out.println("Senha alterada com sucesso");
							}
							else
								System.out.println("Senha incorreta!");
					}
					
				}while(sairGerente != 1);
			}
			else if(usuario == 3) // escolheu a opcao de sair do menu
			{
				sairTotal = 1;
			}
			
		}while(sairTotal != 1);
		
		// TODO Auto-generated method stub
	}
	
	public static void cadastrarDados(int posicaoGerente, int posicaoUsuario, ArrayList<ContaGerente> ListaGerente)
	{
		int idConta;
		double limite;
		
		Conta c1;
		
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Digite o tipo de conta a ser criada:");
		System.out.println("1 - Conta simples");
		System.out.println("2 - Conta Poupanca");
		System.out.println("3 - Conta Especial");
		int tipoConta = ler.nextInt();
		
		System.out.println("Digite o ID da nova conta: ");
		idConta = ler.nextInt();
		
		switch(tipoConta)
		{
		case 1: c1 = new ContaSimples(idConta);
			ListaGerente.get(posicaoGerente).ListaUsuario.get(posicaoUsuario).Contas.add(c1);
			System.out.println("Conta criada com sucesso!");
			break;
		case 2: c1 = new ContaPoupanca(idConta);
			ListaGerente.get(posicaoGerente).ListaUsuario.get(posicaoUsuario).Contas.add(c1);
			System.out.println("Conta criada com sucesso!");
			break;
		case 3: 
			System.out.println("Digite o limite da conta: ");
			limite = ler.nextDouble();
			c1 = new ContaEspecial(idConta, limite);
			ListaGerente.get(posicaoGerente).ListaUsuario.get(posicaoUsuario).Contas.add(c1);
			System.out.println("Conta criada com sucesso!");
			break;
		default: System.out.println("Opcao Invalida!");
			break;
		}
	}
		
	public static int descobrirGerenteDoUsuario(int loginConta, int senha, ArrayList<ContaGerente> ListaGerente)
	{
		for(int i = 0; i < ListaGerente.size(); i++)
		{
			for(int j = 0; j < ListaGerente.get(i).ListaUsuario.size(); j++)
			{
				if(ListaGerente.get(i).ListaUsuario.get(j).getLogin() == loginConta)
				{
					if(ListaGerente.get(i).ListaUsuario.get(j).getSenha() == senha)
					{
						return i;
					}
				}
			}
		}
		
		System.out.println("Usuario nao encontrado");
		return 999;
	}
	
	public static int fazerLoginUsuario(int loginConta, int senha, ArrayList<ContaUsuario> ListaUsuario)
	{
		for(int i = 0; i < ListaUsuario.size(); i++)
		{
			if(loginConta == ListaUsuario.get(i).getLogin())
			{
				if(senha == ListaUsuario.get(i).getSenha())
				{
					return i;
				}
			}
		}
		
		System.out.println("ID ou senha nao encontrados");
		return 999;
	}
	
	public static int fazerLoginGerente(int loginConta, int senha, ArrayList<ContaGerente> ListaGerente)
	{
		for(int i = 0; i < ListaGerente.size(); i ++)
		{
			if(loginConta == ListaGerente.get(i).getLogin())
			{
				if(senha == ListaGerente.get(i).getSenha())
				{
					return i;
				}
			}
		}
		
		System.out.println("ID ou senha nao encontrados!");
		return 999;
	}
	
	public static void contasUsuarioID(ArrayList<Conta> ListaConta)
	{	
		for(int i = 0; i < ListaConta.size(); i++)
		{
				System.out.printf("Conta #%d: %d\n", i, ListaConta.get(i).getIdConta());
		}	
	}
	
	public static int pegarPosicaoConta(int id, ArrayList<Conta> ListaConta)
	{
		for(int i = 0; i < ListaConta.size(); i++)
		{
			if(id == ListaConta.get(i).getIdConta())
			{
				return i;
			}
		}
		
		System.out.println("ID nao encontrado!");
		return 999;
	}

	public static int pegarPosicaoUsuario(int RG, ArrayList<ContaUsuario> ListaUsuario)
	{
		for(int i = 0; i < ListaUsuario.size(); i++)
		{
			if(RG == ListaUsuario.get(i).getRG())
			{
				return i;
			}
		}
		
		System.out.println("Login nao encontrado!");
		return 0;
	}

}
