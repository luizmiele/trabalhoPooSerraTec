package poo.trabalho.serratec.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import poo.trabalho.serratec.conexao.ConexaoBD;
import poo.trabalho.serratec.model.Cargo;
import poo.trabalho.serratec.model.Funcionario;
import poo.trabalho.serratec.model.Plano;

public class FuncionarioDAO {
	
	static PreparedStatement ps = null;
	
	public static void cadastra(Funcionario funcionario) {
		
		String sqlPessoa = "INSERT INTO PESSOA (NOME, CPF, DATANASCIMENTO, TELEFONE, EMAIL, SENHA, TIPO) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			ps = ConexaoBD.getConexao().prepareStatement(sqlPessoa);
			ps.setString(1, funcionario.getNome());
			ps.setString(2, funcionario.getCpf());
			ps.setObject(3, funcionario.getDataNascimento()); // TESTAR SE O OBJECT VAI FUNCIONAR
			ps.setString(4, funcionario.getTelefone());
			ps.setString(5, funcionario.getEmail());
			ps.setString(6, funcionario.getSenha());
			ps.setString(7, funcionario.getTipo());
			ps.executeUpdate(); 
			
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sqlFuncionario = "INSERT INTO FUNCIONARIO (funcionarioID, cargo) values (currval('pessoa_pessoaID_seq'), ?)";
		
		try {
			ps = ConexaoBD.getConexao().prepareStatement(sqlFuncionario);
			ps.setObject(1, funcionario.getCargo()); 
			ps.executeUpdate();
			
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public static Funcionario funcionarioLogado(String cpf, String senha) {
		ResultSet rs = null;
		Funcionario funcionarioLogado = new Funcionario();
		String sqlDadosPessoaisAluno = "SELECT pessoa.*, funcionario.* " +
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
	
	public static String getDadosPessoaisFuncionario(String cpfInserido) {
		ResultSet rs = null;
		String stringFormatada = "";
		
		String sqlDadosPessoaisAluno = "SELECT pessoa.*, funcionario.*\r\n"
				+ "FROM pessoa\r\n"
				+ "JOIN funcionario ON pessoa.pessoaID = funcionario.funcionarioID\r\n"
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
				String cargo = rs.getString("cargo");
				
				stringFormatada = String.format("""
						● Nome: %s
						● CPF:  %s
						● DataNascimento: %s
						● Telefone: %s
						● Email: %s
						● Cargo: %s
						""", nome,cpf,dataNascimento,telefone,email,cargo);
				
			} else {
				System.out.println("Aluno não encontrado!");
			}	
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return stringFormatada;
	}
	
	public static StringBuilder getTodosFuncionarios() {
		StringBuilder todosFuncionarios = new StringBuilder();
		ResultSet rs;
		String stringFormatada = "";
		String sqlGetNomePlano = "SELECT * FROM pessoa "
				+ "JOIN funcionario on funcionario.funcionarioID = pessoa.pessoaID "
				+ "where tipo = 'funcionario'" ;
		
		try {
			ps = ConexaoBD.getConexao().prepareStatement(sqlGetNomePlano);
			rs = ps.executeQuery();

			while(rs.next()) {
				int funcionarioID = rs.getInt("funcionarioID");
				String nome = rs.getString("nome");
				String dataNascimento = rs.getString("dataNascimento");
				String telefone = rs.getString("telefone");
				String email = rs.getString("email");
				String cargo = rs.getString("cargo");
				
				stringFormatada = String.format(
				"""
			|			
			|	● ID do Funcionario: %d             
			|	● Nome : %s					 
			|	● Data Nascimento: %s			 
			|	● Telefone: %s				 
			|	● Email: %s					 				 
			|	● Cargo: %s   
			|___________________________________________________________________________	
				""", funcionarioID, nome, dataNascimento, telefone, email, cargo);
				todosFuncionarios.append(stringFormatada);
			} 
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return todosFuncionarios; 
	}
}