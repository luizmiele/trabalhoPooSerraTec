package poo.trabalho.serratec.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import poo.trabalho.serratec.conexao.ConexaoBD;
import poo.trabalho.serratec.models.Personal;

public class PersonalDAO {
static PreparedStatement ps = null;
	
	public void cadastra(Personal personal) {
		
		String sqlPessoa = "INSERT INTO PESSOA (NOME, CPF, DATANASCIMENTO, TELEFONE, EMAIL, SENHA) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			ps = ConexaoBD.getConexao().prepareStatement(sqlPessoa);
			ps.setString(1, personal.getNome());
			ps.setString(2, personal.getCpf());
			ps.setDate(3, java.sql.Date.valueOf(personal.getDataNascimento()));
			ps.setString(4, personal.getEmail());
			ps.setString(5, personal.getTelefone());
			ps.setString(6, personal.getSenha());
			ps.setString(7, "Personal");
			ps.executeUpdate(); 
			
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sqlpersonal = "INSERT INTO personal (personalID,) values (currval('pessoa_pessoaID_seq'), ?)";
		
		try {
			ps = ConexaoBD.getConexao().prepareStatement(sqlpersonal);
			ps.setString(1, personal.getEspecialidade());
			ps.setString(1, personal.getCref());
			ps.setString(1, personal.getHorarioAtendimento());
			ps.executeUpdate();
			
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
