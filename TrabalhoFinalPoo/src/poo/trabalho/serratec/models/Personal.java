package poo.trabalho.serratec.models;

import java.time.LocalDate;

public class Personal extends Pessoa{
	private String especialidade;
	private String cref;
	private String horarioAtendimento;
	
	public Personal(String nome, String cpf, LocalDate dataNascimento, String telefone, String email, String senha, String tipo, 
			String especialidade, String cref, String horarioAtendimento) {
		super(nome, cpf, dataNascimento, telefone, email, senha, tipo);
		this.especialidade = especialidade;
		this.cref = cref;
		this.horarioAtendimento = horarioAtendimento;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public String getCref() {
		return cref;
	}

	public String getHorarioAtendimento() {
		return horarioAtendimento;
	}


	@Override
	public String toString() {
		return super.toString() + "Especialidade: " + especialidade + "\nCref: " + cref + "\nHorarioAtendimento: "
				+ horarioAtendimento;
	}
}