package poo.trabalho.serratec.menu;

import java.util.List;
import java.util.Scanner;

import poo.trabalho.serratec.dao.MenuDAO;
import poo.trabalho.serratec.model.Aluno;

public class MenuLogin {
	public static void login() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("""
                                               ------------------------------------------------------
                                               |              Portugol Health & Fitness             |
                                               |                Centers - Sistema                   |
                                               ------------------------------------------------------
                            """);
			System.out.println("Insira o cpf:");
			String cpfInserido = sc.nextLine();
			System.out.println("Insira a senha:");
			String senhaInserido = sc.nextLine();
			
			List<String> rsLogin = MenuDAO.autenticaLogin(cpfInserido, senhaInserido);
			if(rsLogin.get(1).equalsIgnoreCase("Aluno")) {	
				Aluno alunoLogado = new Aluno(cpfInserido, senhaInserido);
				boolean retorna = true;
				while(retorna) {
					retorna = true;
					int opcaoInserida = MenuPrincipal.leMenu(rsLogin.get(0), rsLogin.get(1), rsLogin.get(2));
					MenuPrincipal.menuAluno(opcaoInserida, alunoLogado);	
				}
			}else if(rsLogin.get(1).equalsIgnoreCase("personal")) {
				boolean retorna = true;
				while(retorna) {
					int opcaoInserida = MenuPrincipal.leMenu(rsLogin.get(0), rsLogin.get(1), rsLogin.get(2));
					retorna = MenuPrincipal.menuPersonal(opcaoInserida);
				}
			}else if(rsLogin.get(1).equalsIgnoreCase("funcionario")) {
				boolean retorna = true;
				while(retorna) {
				int opcaoInserida = MenuPrincipal.leMenu(rsLogin.get(0), rsLogin.get(1), rsLogin.get(2));
				MenuPrincipal.menuFuncionario(opcaoInserida);
				}
			}
			sc.close();
		}
	}

	
}
