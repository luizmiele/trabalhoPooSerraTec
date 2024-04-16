package poo.trabalho.serratec.menu;

import java.util.List;
import java.util.Scanner;

import poo.trabalho.serratec.dao.MenuDAO;

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
				boolean retorna = true;
				while(retorna) {
					retorna = true;
					int opcaoInserida = MenuPrincipal.leMenu(rsLogin.get(1), rsLogin.get(0));
					retorna = MenuPrincipal.menuAluno(opcaoInserida);	
				}
			}else if(rsLogin.get(1).equalsIgnoreCase("personal")) {
				boolean retorna = true;
				while(retorna) {
					int opcaoInserida = MenuPrincipal.leMenu(rsLogin.get(1), rsLogin.get(0));
					retorna = MenuPrincipal.menuPersonal(opcaoInserida);
				}
			}else if(rsLogin.get(1).equalsIgnoreCase("funcionario")) {
				boolean retorna = true;
				while(retorna) {
				int opcaoInserida = MenuPrincipal.leMenu(rsLogin.get(1), rsLogin.get(0));
				retorna = MenuPrincipal.menuFuncionario(opcaoInserida);
				}
			}
			sc.close();
		}
	}

	
}
