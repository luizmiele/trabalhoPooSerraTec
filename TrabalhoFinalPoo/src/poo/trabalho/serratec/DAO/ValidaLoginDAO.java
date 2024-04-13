package poo.trabalho.serratec.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import poo.trabalho.serratec.conexao.ConexaoBD;
import poo.trabalho.serratec.models.Aluno;

public class ValidaLoginDAO {
	//pegar as informaçoes do BD para poder usar na funcao ValidaLogin.java
	static PreparedStatement ps = null;
	
	insira um cpf:
	cfpInserido = scanner.nextLine();
	cpfDoBanco() = select senhha from Pessoa where cpf = cpfInserido
	if(cpfInserido tem no Banco) {
		senhaBanco = pessoa.getSenha();
	}
	insira a senha:
	senhaInserida = scanner.nextLine();
	
	if (senhaInserida == senhaBanco) {
		tipo = pessoa.getTipo();
		abrir menu de acordo com o tipo.
	}
	
	
	public int getCpf(Aluno aluno) {
		String sqlGetPlanoID = "SELECT  FROM PLANO WHERE nomePlano = ?";
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
	
	public int getSenha(Aluno aluno) {
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
	
	
}
