package poo.trabalho.serratec.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import poo.trabalho.serratec.conexao.ConexaoBD;
import poo.trabalho.serratec.model.Aluno;

public class AlunoDAO {
	static PreparedStatement ps = null;
								 			
	public static void cadastra(Aluno aluno) {

		String sqlPessoa = "INSERT INTO PESSOA (NOME, CPF, DATANASCIMENTO, TELEFONE, EMAIL, SENHA, TIPO) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			ps = ConexaoBD.getConexao().prepareStatement(sqlPessoa);
			ps.setString(1, aluno.getNome()); 
			ps.setString(2, aluno.getCpf());
			ps.setObject(3, aluno.getDataNascimento());
			ps.setString(4, aluno.getTelefone());
			ps.setString(5, aluno.getEmail());
			ps.setString(6, aluno.getSenha());
			ps.setString(7, "Aluno");
			ps.executeUpdate();
								
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sqlAluno = "INSERT INTO ALUNO (alunoID, planoContratado, dataMatricula) VALUES (currval('pessoa_pessoaID_seq'), ?, ?)";
		
		try {
			PreparedStatement ps = ConexaoBD.getConexao().prepareStatement(sqlAluno);
			ps.setInt(1, getPlanoID(aluno.getPlanoContratado()));
			ps.setObject(2,LocalDateTime.now()); // TESTAR PARA VE SE O SETOBJECT VAI FUNCIONAR
			ps.executeUpdate();
			
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public static String getDadosPessoaisAluno(String cpfInserido) {
		ResultSet rs = null;
		String stringFormatada = "";
		
		String sqlDadosPessoaisAluno = "SELECT pessoa.*, aluno.*, plano.*\r\n"
				+ "FROM pessoa\r\n"
				+ "JOIN aluno ON pessoa.pessoaID = aluno.alunoID\r\n"
				+ "JOIN plano ON aluno.planoContratado = plano.planoID\r\n"
				+ "WHERE pessoa.CPF = ?;\r\n"
				+ "";
		
		try {
			ps = ConexaoBD.getConexao().prepareStatement(sqlDadosPessoaisAluno);
			ps.setString(1,cpfInserido);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String nome =rs.getString("nome");
				String cpf =rs.getString("CPF");
				String dataNascimento =rs.getString("dataNascimento");
				String telefone =rs.getString("telefone");
				String email =rs.getString("email");
				String planoContratado = rs.getString("nomePlano");
				
				stringFormatada = String.format("""
						Nome: %s
						CPF:  %s
						DataNascimento: %s
						Telefone: %s
						Email: %s
						plano Contratado: %s
						""", nome,cpf,dataNascimento,telefone,email,planoContratado);
				
			} else {
				System.out.println("Aluno não encontrado!");
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return stringFormatada;
	}
	
	public static ResultSet getHorarioAtendimentoPorAluno(String cpf) {
		
		String sqlGetHorario = "SELECT * FROM agendamento WHERE CPF = ? ";
		ResultSet rs;
		ResultSet horarioAgendamento = null;
		try {
			ps = ConexaoBD.getConexao().prepareStatement(sqlGetHorario);
			ps.setString(1, cpf);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				horarioAgendamento = rs;
			} else {
				System.out.println("Aluno não encontrado!");
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return horarioAgendamento;
}

	public static int getPlanoID(String nomePlano) {
		String sqlGetPlanoID = "SELECT planoID FROM PLANO WHERE nomePlano = ?";
		ResultSet rs;
		int planoID = 0;
		
		try {
			ps = ConexaoBD.getConexao().prepareStatement(sqlGetPlanoID);
			ps.setString(1, nomePlano);
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
	
	@Override
	public String toString() {
		return super.toString();
}	
}