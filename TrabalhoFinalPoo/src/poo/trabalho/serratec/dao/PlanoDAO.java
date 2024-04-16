package poo.trabalho.serratec.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import poo.trabalho.serratec.conexao.ConexaoBD;
import poo.trabalho.serratec.model.Plano;

public class PlanoDAO {
	static PreparedStatement ps = null;
	
	public static void cadastra(Plano plano) {
		Scanner s = new Scanner(System.in);
		
		String sqlPlano = "INSERT INTO PLANO (nomePlano, duracao, valor, descricao) VALUES (?, ?, ?, ?)";

		try {
			ps = ConexaoBD.getConexao().prepareStatement(sqlPlano);
			ps.setString(1, plano.getNomePlano()); 
			ps.setInt(2, plano.getDuracao());
			ps.setDouble(3, plano.getValor());
			ps.setString(4, plano.getDescricao());
			ps.executeUpdate();
								
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static StringBuilder getTodosPlanos() {
		ResultSet rs = null;
		String stringFormatada = "";
		StringBuilder sb = new StringBuilder();
		
		String sqlDadosPessoaisAluno = "SELECT * FROM PLANOS";
		
		try {
			ps = ConexaoBD.getConexao().prepareStatement(sqlDadosPessoaisAluno);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				while(rs.next()) {
					String nomePlano =rs.getString("nomePlano");
					String duracao =rs.getString("duracao");
					String valor =rs.getString("valor");
					String descricao =rs.getString("descricao");
					
					stringFormatada = String.format("""
							Nome do Plano: %s
							Duração:  %d
							Valor: %.2f
							Descricao: %s
							
							""", nomePlano,duracao,valor,descricao);
					
					sb.append(stringFormatada);
				} 
			}else {
				System.out.println("Aluno não encontrado!");
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return sb;
	}
	
	public static StringBuilder getListaNomesPlanos() {
		ResultSet rs = null;
		String stringFormatada = "";
		StringBuilder sb = new StringBuilder();
		String sqlGetListaPlanos = "SELECT nomePlano, planoID FROM PLANO";
		
		try {
			ps = ConexaoBD.getConexao().prepareStatement(sqlGetListaPlanos);
			
			rs = ps.executeQuery();
			System.out.println("                      PLANOS DISPONIVEIS NO MOMENTO: \n");
		
			while(rs.next()) {
				String nomePlano = rs.getString("nomePlano");
				int planoID =rs.getInt("planoID");
				stringFormatada = String.format("%s- %s \n", planoID, nomePlano);
				sb.append(stringFormatada);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return sb;
	}
	
	public static String getNomePlanoByID(int opcao) {
		Scanner s = new Scanner(System.in);
		ResultSet rs;
		String nome = "";
		boolean encontrado = false;
		String sqlGetNomePlano = "SELECT nomePlano FROM PLANO WHERE PLANOID = ?";
		
		try {
			while(!encontrado) {
			ps = ConexaoBD.getConexao().prepareStatement(sqlGetNomePlano);
			ps.setInt(1, opcao);
			rs = ps.executeQuery();

				if(rs.next()) {
					nome = rs.getString("nomePlano");
					return nome;
				} else {
					System.out.println("Plano não encontrado! Digite novamente");
					opcao = s.nextInt();
				}
			} 
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return nome;
	}
	
	public static StringBuilder getAllPlanos() {
		StringBuilder todosPlanos = null;
		ResultSet rs;
		String stringFormatada = "";
		String sqlGetNomePlano = "SELECT * FROM PLANO";
		
		try {
			ps = ConexaoBD.getConexao().prepareStatement(sqlGetNomePlano);
			rs = ps.executeQuery();

			while(rs.next()) {
				String nomePlano = rs.getString("nomePlano");
				int planoID = rs.getInt("planoID");
				double valor = rs.getDouble("valor");
				String descricao = rs.getString("descricao");
				
				stringFormatada = String.format(
				"""
						ID do plano: %d
						Nome do plano: %s
						Valor: R$ %.2f
						Descrição: %s
			___________________________________________________________		
				""", planoID, nomePlano, valor, descricao);
				todosPlanos.append(stringFormatada);
			} 
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return todosPlanos; 
	}
}
