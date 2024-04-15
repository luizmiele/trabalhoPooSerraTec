package poo.trabalho.serratec.menu;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
		
		List<String> rsLogin = autenticaLogin(cpfInserido, senhaInserido);
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

	public static List<String> autenticaLogin(String cpf, String senha) {
		PreparedStatement ps = null;
		String nome = "";
		String tipo = "";
		List<String> alunoLocal = new ArrayList<>();
		
			String sqlNomeSenha = "SELECT NOME, TIPO FROM PESSOA WHERE CPF = ? AND SENHA = ? ";
		
			try {
				ps = ConexaoBD.getConexao().prepareStatement(sqlNomeSenha);
				ps.setString(1, cpf);
				ps.setString(2, senha);
				
				ResultSet rs = ps.executeQuery();
				
				try {
					if(rs.next()) {
						nome = rs.getString("NOME");
						tipo = rs.getString("TIPO");
				
						alunoLocal.add(nome);
						alunoLocal.add(tipo);
						
						return alunoLocal;
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
			return alunoLocal;
	}
}
