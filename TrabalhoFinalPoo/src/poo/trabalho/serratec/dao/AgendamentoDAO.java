package poo.trabalho.serratec.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import poo.trabalho.serratec.conexao.ConexaoBD;
import poo.trabalho.serratec.model.Aluno;
import poo.trabalho.serratec.model.Personal;

public class AgendamentoDAO {	
	static PreparedStatement ps = null;

	public static void agendamento(Aluno alunoLogado) {
		Scanner s = new Scanner(System.in);
		int personalID = 0;
		LocalDate data = null;
		LocalTime hora = null;
		boolean sai = false;
		while (!sai) { //F V
			System.out.println("Informe o ID do personal: ");
			personalID = s.nextInt();
			s.nextLine();
			System.out.println("Informe a data da avaliação (formato yyyy-MM-dd): ");
            String dataStr = s.nextLine();
            data = LocalDate.parse(dataStr);
            System.out.println("Informe a hora da avaliação (formato hh:mm:ss): ");
            String horaStr = s.nextLine();
            hora = LocalTime.parse(horaStr);
            sai = true;
		}
		
		String sqlAgendamento = "INSERT INTO AGENDAMENTO (DATA, HORARIO, PERSONALID, ALUNOID) VALUES (?, ?, ?, ?)";
		
		try {
			ps = ConexaoBD.getConexao().prepareStatement(sqlAgendamento);
			ps.setDate(1, Date.valueOf(data));
			ps.setTime(2, Time.valueOf(hora));
			ps.setInt(3, personalID);
			ps.setInt(4, alunoLogado.getID());
			ps.executeUpdate();
			
			ps.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	public static StringBuilder agendaAtendimentosByID(Personal personalLogado) {
		ResultSet rs;
		StringBuilder agendamentos = new StringBuilder();
		String sqlAgenda = "SELECT * FROM AGENDAMENTO WHERE personalID = ?";
		String stringFormatada = "";
		try {
			ps = ConexaoBD.getConexao().prepareStatement(sqlAgenda);
			ps.setInt(1, personalLogado.getID());
			rs = ps.executeQuery(); 
			
			
			while(rs.next()) {
				int agendamentoID = rs.getInt("agendamentoID");
				int alunoID = rs.getInt("alunoID");
				int personalID = rs.getInt("personalID");
				String data = rs.getString("data");
				String hora = rs.getString("horario");
				
				stringFormatada = String.format(
				"""
				_____________________________________________________	
				|			
			    |ID do agendamento: %s
				|ID do Aluno: %d
				|ID do Personal : %s
				|Data: %s
				|Hora: %s
			    |__________________________________________________		
				""", agendamentoID, alunoID, personalID, data, hora);
				agendamentos.append(stringFormatada);
				//ps.close();
			}
		}catch (SQLException e) {
			e.printStackTrace();	
		}		
		return agendamentos;
	}
	
	public static StringBuilder historicoAgendamentoAluno(Aluno alunoLogado) {
		ResultSet rs;
		String stringFormatada = "";
		String sqlHistorico = "SELECT * FROM AGENDAMENTO WHERE ALUNOID = ?";
		StringBuilder historicoAgendamentos = new StringBuilder();
		
		try {
			ps = ConexaoBD.getConexao().prepareStatement(sqlHistorico);
			ps.setInt(1, alunoLogado.getID());
			rs = ps.executeQuery(); 
			
			
			while(rs.next()) {
				int agendamentoID = rs.getInt("agendamentoID");
				int alunoID = rs.getInt("alunoID");
				int personalID = rs.getInt("personalID");
				String data = rs.getString("data");
				String hora = rs.getString("horario");
				
				stringFormatada = String.format(
				"""
				_____________________________________________________	
				|			
			    |ID do agendamento: %s
				|ID do Aluno: %d
				|ID do Personal : %s
				|Data: %s
				|Hora: %s
			    |__________________________________________________		
				""", agendamentoID, alunoID, personalID, data, hora);
				historicoAgendamentos.append(stringFormatada);
				//ps.close();
			}
		}catch (SQLException e) {
			e.printStackTrace();	
		}		
		return historicoAgendamentos;
	}
	
	
	public static void cancelaAgendamento() {
		Scanner s = new Scanner(System.in);
		int agendamentoID = 0;
		
		System.out.println("Informe o ID do Agendamento: ");
		agendamentoID = s.nextInt();
		
		String sqlCancelamento = "DELETE  FROM AGENDAMENTO WHERE AGENDAMENTOID= ?";

		try {
			ps = ConexaoBD.getConexao().prepareStatement(sqlCancelamento);
			ps.setInt(1, agendamentoID);
			
			ps.executeUpdate(); 
			
			ps.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("AGENDAMENTO CANCELADO!");
	}
}