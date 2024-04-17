package poo.trabalho.serratec.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Agendamento {
	private LocalDate data;
	private LocalTime horario;
	private int personalID;
	private int alunoID;
	private int agendamentoID;
	
	public Agendamento(LocalDate data, LocalTime horario, int personalID, int alunoID) {
		this.data = data;
		this.horario = horario;
		this.personalID = personalID;
		this.alunoID = alunoID;
	}
	
	
	public LocalDate getData() {
		return data;
	}
	public LocalTime getHorario() {
		return horario;
	}
	public int getPersonalID() {
		return personalID;
	}
	public int getAlunoID() {
		return alunoID;
	}
	
	public int getAgendamentoID() {
		return agendamentoID;
	}


	@Override
	public String toString() {
		return "Agendamento [data=" + data + ", horario=" + horario + ", personalID=" + personalID + ", alunoID="
				+ alunoID + "]";
	}
}