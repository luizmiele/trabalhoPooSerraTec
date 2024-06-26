package poo.trabalho.serratec.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import poo.trabalho.serratec.conexao.ConexaoBD;
import poo.trabalho.serratec.model.Cargo;
import poo.trabalho.serratec.model.Funcionario;
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
			ps.setObject(1, personal.getEspecialidade()); // Set object dando proglema  Não pode inferir um tipo SQL a ser usado para uma instância de poo.trabalho.serratec.model.Especialidade.
			ps.setString(2, personal.getCref());
			ps.setString(3, personal.getHorarioAtendimento());
			ps.executeUpdate();
			
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public static Funcionario personalLogado(String cpf, String senha) {
		ResultSet rs = null;
		Funcionario funcionarioLogado = new Funcionario();
		String sqlDadosPessoaisAluno = "SELECT pessoa.*, personal.* " +
			    "FROM pessoa " +
			    "JOIN funcionario ON pessoa.pessoaID = funcionario.funcionarioID " +
			    "WHERE pessoa.cpf = ?";
		try {
			ps = ConexaoBD.getConexao().prepareStatement(sqlDadosPessoaisAluno);
			ps.setString(1,cpf);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				int funcionarioID = rs.getInt("funcionarioID");
				String nome = rs.getString("nome");
				String dataNascimentoStr = rs.getString("datanascimento");
				LocalDate dataNascimento = Date.valueOf(dataNascimentoStr).toLocalDate();
				String telefone =rs.getString("telefone");
				String email =rs.getString("email");
				String tipo = "Funcionario";
				Cargo cargo = (Cargo) rs.getObject("cargo");
				
				funcionarioLogado = new Funcionario(funcionarioID, nome, cpf, dataNascimento, telefone, email, senha, tipo,cargo);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return funcionarioLogado;
	}
	
	public static StringBuilder getTodosPersonal() {
		StringBuilder todosPersonal = new StringBuilder();
		ResultSet rs;
		String stringFormatada = "";
		String sqlGetNomePlano = "SELECT * FROM pessoa "
				+ "JOIN personal on personal.personalID = pessoa.pessoaID "
				+ "where tipo = 'personal'";
		
		try {
			ps = ConexaoBD.getConexao().prepareStatement(sqlGetNomePlano);
			rs = ps.executeQuery();

			while(rs.next()) {
				int personalID = rs.getInt("personalID");
				String nome = rs.getString("nome");
				String dataNascimento = rs.getString("dataNascimento"); 
				String telefone = rs.getString("telefone");
				String email = rs.getString("email");
				String tipo = rs.getString("tipo");
				String especialidade = rs.getString("especialidade");
				String horarioAgendamentos = rs.getString("horarioAgendamentos");
				
				stringFormatada = String.format(
				"""
			|			
			|	● ID do Personal: %d             
			|	● Nome : %s					 
			|	● Data Nascimento: %s			 
			|	● Telefone: %s				 
			|	● Email: %s					 
			|	● Tipo: %s					 
			|	● Especialidade: %s            
			|	● Horário de atendimento: %s   
			|___________________________________________________________________________
				""", personalID, nome, dataNascimento, telefone, email, tipo, especialidade, horarioAgendamentos);
				todosPersonal.append(stringFormatada);
			} 
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return todosPersonal; 
	}
}