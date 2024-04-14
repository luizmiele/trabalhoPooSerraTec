package poo.trabalho.serratec.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import poo.trabalho.serratec.conexao.ConexaoBD;
import poo.trabalho.serratec.model.Funcionario;

public class FuncionarioDAO {
	
	static PreparedStatement ps = null;
	
	public void cadastra(Funcionario funcionario) {
		
		String sqlPessoa = "INSERT INTO PESSOA (NOME, CPF, DATANASCIMENTO, TELEFONE, EMAIL, SENHA, TIPO) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			ps = ConexaoBD.getConexao().prepareStatement(sqlPessoa);
			ps.setString(1, funcionario.getNome());
			ps.setString(2, funcionario.getCpf());
			ps.setDate(3, java.sql.Date.valueOf(funcionario.getDataNascimento()));
			ps.setString(4, funcionario.getEmail());
			ps.setString(5, funcionario.getTelefone());
			ps.setString(6, funcionario.getSenha());
			ps.setString(7, "Funcionario");
			ps.executeUpdate(); 
			
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sqlFuncionario = "INSERT INTO FUNCIONARIO (funcionarioID, cargo) values (currval('pessoa_pessoaID_seq'), ?)";
		
		try {
			ps = ConexaoBD.getConexao().prepareStatement(sqlFuncionario);
			ps.setString(1, funcionario.getCargo());
			ps.executeUpdate();
			
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}