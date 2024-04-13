package poo.trabalho.serratec.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import poo.trabalho.serratec.conexao.ConexaoBD;
import poo.trabalho.serratec.models.Aluno;
import poo.trabalho.serratec.models.Pessoa;

public class AlunoDAO {
	static PreparedStatement ps = null;
	
	public void cadastra(Aluno aluno) {

		String sqlPessoa = "INSERT INTO PESSOA (NOME, CPF, DATANASCIMENTO, TELEFONE, EMAIL, SENHA) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			ps = ConexaoBD.getConexao().prepareStatement(sqlPessoa);
			ps.setString(1, aluno.getNome());
			ps.setString(2, aluno.getCpf());
			ps.setDate(3, java.sql.Date.valueOf(aluno.getDataNascimento()));
			ps.setString(4, aluno.getEmail());
			ps.setString(5, aluno.getTelefone());
			ps.setString(6, aluno.getSenha());
			ps.setString(7, "Aluno");
			ps.executeUpdate(); //executeUpdate é pra insert
								//executequery  é pra read
			
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sqlAluno = "INSERT INTO ALUNO (alunoID, planoContratado, dataMatricula) VALUES (currval('pessoa_pessoaID_seq'), ?, ?)";
		
		try {
			PreparedStatement ps = ConexaoBD.getConexao().prepareStatement(sqlAluno);
			ps.setInt(1, getPlanoID(aluno));
			ps.setDate(2,java.sql.Date.valueOf(aluno.getDataMatricula())) ;
			ps.executeUpdate();
			
			ps.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}	
	}
	
	public ResultSet autenticaLogin(Pessoa pessoa) {
		//pegar as informaçoes do BD para poder usar na funcao ValidaLogin.java
		PreparedStatement ps = null;
		
			String sqlNomeSenha = "SELECT * FROM PESSOA WHERE CPF = ? AND SENHA = ? ";
		
			try {
				ps = ConexaoBD.getConexao().prepareStatement(sqlNomeSenha);
				ps.setString(1, pessoa.getCpf());
				ps.setString(2, pessoa.getSenha());
				
				ResultSet rs = ps.executeQuery();
				return rs;
				
				
			}catch(SQLException e) {
				e.printStackTrace();
				return null;
			}
	}
	public int getPlanoID(Aluno aluno) {
		String sqlGetPlanoID = "SELECT planoID FROM PLANO WHERE nomePlano = ?";
		ResultSet rs;
		int planoID = 0;
		
		try {
			ps = ConexaoBD.getConexao().prepareStatement(sqlGetPlanoID);
			ps.setString(1, aluno.getPlanoContratado());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				planoID = rs.getInt("planoID");
			} else {
				System.out.println("Aluno não encontrado!");
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return planoID;
	}
	
public static String getAlunoId() {
		
		String sqlGetHorario = "SELECT alunoID FROM pessoa join aluno WHERE pessoa.cpf = ? ";
		ResultSet rs;
		int planoID = 0;
		
		try {
			ps = ConexaoBD.getConexao().prepareStatement(sqlGetHorario);
			ps.setString(1, Aluno.getId());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				planoID = rs.getInt("planoID");
			} else {
				System.out.println("Aluno não encontrado!");
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return horarioAgendamento;
	}
	
public static String getHorarioAtendimentoPorAluno() {
		
		String sqlGetHorario = "SELECT * FROM agendamento WHERE alunoID = ? ";
		ResultSet rs;
		int planoID = 0;
		
		try {
			ps = ConexaoBD.getConexao().prepareStatement(sqlGetHorario);
			ps.setString(1, Aluno.getId());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				planoID = rs.getInt("planoID");
			} else {
				System.out.println("Aluno não encontrado!");
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return horarioAgendamento;
	}
}