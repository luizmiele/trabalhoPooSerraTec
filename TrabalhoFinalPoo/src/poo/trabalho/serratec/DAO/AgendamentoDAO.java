package poo.trabalho.serratec.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import poo.trabalho.serratec.conexao.ConexaoBD;

public class AgendamentoDAO {
	
	
	public static Agendamento getHorarioAtendimento() {
		
		String sqlGetHorario = "SELECT * FROM agendamento WHERE agendamento = ? ";
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
		return horarioAgendamento;
	}
		return "aaa";
	}
}
