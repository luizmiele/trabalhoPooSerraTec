package poo.trabalho.serratec.menu;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import poo.trabalho.serratec.DAO.AlunoDAO;
import poo.trabalho.serratec.models.Aluno;

public class MenuLogin {
	public static void login() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("----- TELA DE LOGIN ------");
		System.out.println("Insira o cpf:");
		String cpfInserido = sc.nextLine();
		System.out.println("Insira a senha:");
		String senhaInserido = sc.nextLine();
		
		Aluno alunoMDL = new Aluno(cpfInserido, senhaInserido);
		
		
		AlunoDAO alunoDAO = new AlunoDAO();
		ResultSet rsLogin = alunoDAO.autenticaLogin(alunoMDL);
		
		try {
			if(rsLogin.next()) {
				MenuAluno.exibeMenuAluno();
			}else {
				System.out.println(rsLogin);
				System.out.println("CPF OU SENHA INVALIDO!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sc.close();
	}
}
