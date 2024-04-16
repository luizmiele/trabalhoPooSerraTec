package poo.trabalho.serratec.menu;

import java.util.List;
import java.util.Scanner;

import poo.trabalho.serratec.dao.MenuDAO;
import poo.trabalho.serratec.model.Aluno;
import poo.trabalho.serratec.model.Funcionario;
import poo.trabalho.serratec.model.Personal;

public class MenuLogin {
	public static void login() {
		Scanner sc = new Scanner(System.in);
		boolean retorna = false;
		while(!retorna) {
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
				Aluno alunoLogado = new Aluno(cpfInserido, "aluno", senhaInserido);
				retorna = true;
				while(retorna) {
					retorna = MenuPrincipal.menuAluno(alunoLogado);	
				}
			}else if(rsLogin.get(1).equalsIgnoreCase("personal")) {
				Personal personalLogado = new Personal(cpfInserido, "personal", senhaInserido);
				retorna = true;
				while(retorna) {
					retorna = MenuPrincipal.menuPersonal(personalLogado);
				}
			}else if(rsLogin.get(1).equalsIgnoreCase("funcionario")) {
				Funcionario funcionarioLogado = new Funcionario(cpfInserido, "funcionario", senhaInserido);
				retorna = true;
				while(retorna) {
					retorna = MenuPrincipal.menuFuncionario(funcionarioLogado);
				}
			}
		}
	}
}
