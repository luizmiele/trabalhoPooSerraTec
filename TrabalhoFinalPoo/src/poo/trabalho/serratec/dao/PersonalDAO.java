package poo.trabalho.serratec.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import poo.trabalho.serratec.conexao.ConexaoBD;
import poo.trabalho.serratec.model.Especialidade;

public class PersonalDAO {
static PreparedStatement ps = null;
	
	public static void cadastra(String nome, String cpf, String dataNascimento, String telefone, String email, String senha, Especialidade especialidade, String cref, String horarioAtendimento) {
		
		String sqlPessoa = "INSERT INTO PESSOA (NOME, CPF, DATANASCIMENTO, TELEFONE, EMAIL, SENHA) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			ps = ConexaoBD.getConexao().prepareStatement(sqlPessoa);
			ps.setString(1, nome);
			ps.setString(2, cpf);
			ps.setString(3, dataNascimento);
			ps.setString(4, telefone);
			ps.setString(5, email);
			ps.setString(6, senha);
			ps.setString(7, "Personal");
			ps.executeUpdate(); 
			
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sqlpersonal = "INSERT INTO personal (personalID,) values (currval('pessoa_pessoaID_seq'), ?, ?, ?)";
		
		try {
			ps = ConexaoBD.getConexao().prepareStatement(sqlpersonal);
			ps.setObject(1, especialidade);
			ps.setString(2, cref);
			ps.setString(3, horarioAtendimento);
			ps.executeUpdate();
			
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
