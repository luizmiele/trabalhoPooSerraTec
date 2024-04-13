package poo.trabalho.serratec.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import poo.trabalho.serratec.conexao.ConexaoBD;

public class AgendamentoDAO {
	static PreparedStatement ps = null;
	
	public static String getHorarioAtendimentoPorAluno() {
		
		String sqlGetHorario = "SELECT * FROM agendamento WHERE alunoID = ? ";
		ResultSet rs;
		int planoID = 0;
		
		try {
			ps = ConexaoBD.getConexao().prepareStatement(sqlGetHorario);
			ps.setString(1, aluno.getAlunoID());
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
