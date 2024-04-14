package poo.trabalho.serratec.menu;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import poo.trabalho.serratec.conexao.ConexaoBD;

public class MenuLogin {
	public static void login() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("----- TELA DE LOGIN ------");
		System.out.println("Insira o cpf:");
		String cpfInserido = sc.nextLine();
		System.out.println("Insira a senha:");
		String senhaInserido = sc.nextLine();
		
		String rsLogin = autenticaLogin(cpfInserido, senhaInserido);
		if(rsLogin.equalsIgnoreCase("Aluno")) {	
			boolean retorna = true;
			while(retorna) {
				retorna = true;
				int opcaoInserida = MenuPrincipal.leMenu("aluno");
				retorna = MenuPrincipal.menuAluno(opcaoInserida);
				
			}
		}else if(rsLogin.equalsIgnoreCase("Personal")) {
			boolean retorna = true;
			while(retorna) {
				int opcaoInserida = MenuPrincipal.leMenu("personal");
				retorna = MenuPrincipal.menuPersonal(opcaoInserida);
			}
		}else if(rsLogin.equalsIgnoreCase("Funcionario")) {
			boolean retorna = true;
			while(retorna) {
			int opcaoInserida = MenuPrincipal.leMenu("funcionario");
			retorna = MenuPrincipal.menuFuncionario(opcaoInserida);
			}
		}
		sc.close();
	}

	public static String autenticaLogin(String cpf, String senha) {
		PreparedStatement ps = null;
		String tipo = "";
		
			String sqlNomeSenha = "SELECT TIPO FROM PESSOA WHERE CPF = ? AND SENHA = ? ";
		
			try {
				ps = ConexaoBD.getConexao().prepareStatement(sqlNomeSenha);
				ps.setString(1, cpf);
				ps.setString(2, senha);
				
				ResultSet rs = ps.executeQuery();
				
				try {
					if(rs.next()) {
						tipo = rs.getString("TIPO");
						return tipo;
					}else {
						System.out.println("CPF OU SENHA INVALIDO!");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}			
			}catch(SQLException e) {
				e.printStackTrace();
				return null;
			}
			return tipo;
	}
}
