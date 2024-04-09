package poo.trabalho.serratec.models;

import java.time.LocalDate;
import java.util.List;

public class Personal extends Pessoa{
	private String especialidade;
	private String cref;
	private String horarioAtendimento;
	
	
	public Personal(String nome, String cpf, LocalDate dataNascimento, String telefone, String email, String senha,
			String especialidade, String cref, String horarioAtendimento) {
		super(nome, cpf, dataNascimento, telefone, email, senha);
		this.especialidade = especialidade;
		this.cref = cref;
		this.horarioAtendimento = horarioAtendimento;
	}

	

	@Override
	public String toString() {
		return super.toString() + "Especialidade: " + especialidade + "\nCref: " + cref + "\nHorarioAtendimento: "
				+ horarioAtendimento;
	}
	
}
