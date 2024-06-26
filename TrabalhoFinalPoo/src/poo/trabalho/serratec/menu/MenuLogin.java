package poo.trabalho.serratec.menu;

import java.util.List;
import java.util.Scanner;

import poo.trabalho.serratec.dao.AlunoDAO;
import poo.trabalho.serratec.dao.FuncionarioDAO;
import poo.trabalho.serratec.dao.MenuDAO;
import poo.trabalho.serratec.dao.PersonalDAO;
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
			
			if(rsLogin.size() == 0) {
				
			}else {
				if(rsLogin.get(1).equalsIgnoreCase("Aluno")) {
					Aluno alunoLogado = AlunoDAO.alunoLogado(cpfInserido, senhaInserido);
					retorna = true;
					while(retorna) {
						retorna = MenuPrincipal.menuAluno(alunoLogado);	
					}
				}else if(rsLogin.get(1).equalsIgnoreCase("personal")) {
					// REFATOREI PRA INSTANCIAR UM PERSONAL "FULL"
					//Personal personalLogadotrue = PersonalDAO.personalLogado(cpfInserido, senhaInserido);
					
					Personal personalLogado = new Personal(cpfInserido, "personal", senhaInserido);
					retorna = true;
					while(retorna) {
						retorna = MenuPrincipal.menuPersonal(personalLogado);
					}
				}else if(rsLogin.get(1).equalsIgnoreCase("funcionario")) {
					// REFATOREI PRA INSTANCIAR UM PERSONAL "FULL"
					//Funcionario funcionarioLogadotrue = FuncionarioDAO.funcionarioLogado(cpfInserido, senhaInserido);
					Funcionario funcionarioLogado = new Funcionario(cpfInserido, "funcionario", senhaInserido);
					retorna = true;
					while(retorna) {
						retorna = MenuPrincipal.menuFuncionario(funcionarioLogado);
					}
				}
			}
		}
	}
}
