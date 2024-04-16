package poo.trabalho.serratec.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import poo.trabalho.serratec.conexao.ConexaoBD;

public class MenuDAO {
	
	public static List<String> autenticaLogin(String cpf, String senha) {
		PreparedStatement ps = null;
		String nome = "";
		String tipo = "";
		List<String> alunoLocal = new ArrayList<>();
		
			String sqlNomeSenha = "SELECT NOME, TIPO, CPF FROM PESSOA WHERE CPF = ? AND SENHA = ? ";
		
			try {
				ps = ConexaoBD.getConexao().prepareStatement(sqlNomeSenha);
				ps.setString(1, cpf);
				ps.setString(2, senha);
				
				ResultSet rs = ps.executeQuery();
				
				try {
					if(rs.next()) {
						nome = rs.getString("NOME");
						tipo = rs.getString("TIPO");
						cpf = rs.getString("CPF");
				
						alunoLocal.add(nome);
						alunoLocal.add(tipo);
						alunoLocal.add(cpf);
						
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
