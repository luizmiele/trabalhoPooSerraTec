package poo.trabalho.serratec.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import poo.trabalho.serratec.conexao.ConexaoBD;
import poo.trabalho.serratec.model.Personal;

public class PersonalDAO {
static PreparedStatement ps = null;
	
	public static void cadastra(Personal personal) {
		
		String sqlPessoa = "INSERT INTO PESSOA (NOME, CPF, DATANASCIMENTO, TELEFONE, EMAIL, SENHA) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			ps = ConexaoBD.getConexao().prepareStatement(sqlPessoa);
			ps.setString(1, personal.getNome());
			ps.setString(2, personal.getCpf());
			ps.setDate(3, Date.valueOf(personal.getDataNascimento()));
			ps.setString(4, personal.getTelefone());
			ps.setString(5, personal.getEmail());
			ps.setString(6, personal.getSenha());
			ps.setString(7, "Personal");
			ps.executeUpdate(); 
			
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sqlpersonal = "INSERT INTO personal (personalID,) values (currval('pessoa_pessoaID_seq'), ?, ?, ?)";
		
		try {
			ps = ConexaoBD.getConexao().prepareStatement(sqlpersonal);
			ps.setObject(1, personal.getEspecialidade());
			ps.setString(2, personal.getCref());
			ps.setString(3, personal.getHorarioAtendimento());
			ps.executeUpdate();
			
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
