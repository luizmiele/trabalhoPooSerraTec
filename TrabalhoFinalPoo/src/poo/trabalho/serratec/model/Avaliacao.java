package poo.trabalho.serratec.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Avaliacao {
	private int avaliacaoID;
	private int alunoID;
	private int personalID;
	private LocalDate data;
	private LocalTime hora ;
	
	
	public Avaliacao(int avaliacaoID, int alunoID, int personalID, LocalDate data, LocalTime hora) {
		this.avaliacaoID = avaliacaoID;
		this.alunoID = alunoID;
		this.personalID = personalID;
		this.data = data;
		this.hora = hora;
	}
	
	public Avaliacao(int alunoID, int personalID, LocalDate data, LocalTime hora) {
		this.alunoID = alunoID;
		this.personalID = personalID;
		this.data = data;
		this.hora = hora;
	}

	public int getAvaliacaoID() {
		return avaliacaoID;
	}

	public int getAlunoID() {
		return alunoID;
	}

	public int getPersonalID() {
		return personalID;
	}

	public LocalDate getData() {
		return data;
	}

	public LocalTime getHora() {
		return hora;
	}

	@Override
	public String toString() {
		return "Avaliacao [avaliacaoID=" + avaliacaoID + ", alunoID=" + alunoID + ", personalID=" + personalID
				+ ", data=" + data + ", hora=" + hora + "]";
	}
}
