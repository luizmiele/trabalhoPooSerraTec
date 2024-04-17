package poo.trabalho.serratec.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import poo.trabalho.serratec.conexao.ConexaoBD;
import poo.trabalho.serratec.model.Personal;

public class AvaliacaoDAO {
	static PreparedStatement ps = null;
	
	public static void cadastrarAvaliacao(Personal personal) {
		Scanner s = new Scanner(System.in);
		LocalDate data = null;
		LocalTime hora = null;
		String descricao = "";
		int alunoID = 0;
		boolean sai = false;
		
		while (!sai) { //F V
			System.out.println("Informe o ID do personal: ");
			alunoID = s.nextInt();
			s.nextLine();
			System.out.println("Informe a data da avaliação (formato yyyy-MM-dd): ");
            String dataStr = s.nextLine();
            data = LocalDate.parse(dataStr);
            System.out.println("Informe a hora da avaliação (formato hh:mm:ss): ");
            String horaStr = s.nextLine();
            hora = LocalTime.parse(horaStr);
            System.out.println("Descrição: ");
            descricao = s.nextLine();
            sai = true;
		}
		
		String sql = "INSERT INTO avaliacao (alunoid, personalid, data, descricao) "
				+ "VALUES (?, ?, ?, ?)";
		try {
			ps = ConexaoBD.getConexao().prepareStatement(sql);
			ps.setInt(1, alunoID);
			ps.setInt(2, personal.getID());
			ps.setDate(3, Date.valueOf(data));
			ps.setString(4, descricao);
			
			ps.executeUpdate();
			ps.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static String exibirAvaliacao(String cpf) {
		String sql = "SELECT pA.nome AS Aluno, ppT.nome AS Personal, av.descricao, av.data AS periodo " +
			    "FROM avaliacao av " +
			    "JOIN personal pt ON av.personalid = pt.personalid " +
			    "JOIN aluno a ON av.alunoid = a.alunoid " +
			    "JOIN pessoa pA ON pA.pessoaid = a.alunoid " +
			    "JOIN pessoa ppT ON ppT.pessoaid = pt.personalid " +
			    "WHERE pA.cpf = '85' OR ppT.cpf = '115' " +
			    "ORDER BY av.data";
		
		StringBuilder dadosAvaliacao = new StringBuilder();
		
		try {
			ps = ConexaoBD.getConexao().prepareStatement(sql);
			ps.setString(1, cpf);
			ps.setString(2, cpf);
			
			try (ResultSet rs = ps.executeQuery()) {
				while(rs.next()) {
					String aluno = rs.getString("Aluno");
					String personal = rs.getString("Personal");
					String descricao = rs.getString("descricao");
					String periodo = rs.getString("periodo");
					
					dadosAvaliacao.append(String.format("""
							
					Aluno: %s
					Personal: %s
					Descricao: %s
					Data: %s
					------------------------------------
					""", aluno, personal, descricao, periodo));
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return dadosAvaliacao.toString();		
	}
	
	public static String exibirAvaliacaoPeriodo(int dataInicio, int dataFim) {
		StringBuilder dados = new StringBuilder();
		String sql = "SELECT pA.nome AS Aluno, ppT.nome AS Personal, av.descricao, av.data " +
			    "FROM avaliacao av " +
			    "JOIN personal pT ON av.personalID = pT.personalID " +
			    "JOIN aluno a ON av.alunoID = a.alunoID " +
			    "JOIN pessoa pA ON pA.pessoaID = a.alunoID " +
			    "JOIN pessoa ppT ON ppT.pessoaID = pT.personalID " +
			    "WHERE ppT.cpf = ? OR pA.cpf = ?" +
			    "ORDER BY av.data";
		
		try {
			ps = ConexaoBD.getConexao().prepareStatement(sql);
			ps.setInt(1, dataInicio);
			ps.setInt(2, dataFim);
			ResultSet rs = ps.executeQuery();
			
				while(rs.next()) {
					String aluno = rs.getString("Aluno");
					String personal = rs.getString("Personal");
					String descricao = rs.getString("descricao");
					String periodo = rs.getString("periodo");
					
					dados.append(String.format("""
							
					Aluno: %s
					Personal: %s
					Descricao: %s
					Data: %s
					------------------------------------
					""", aluno, personal, descricao, periodo));
				}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return dados.toString();
	}
}