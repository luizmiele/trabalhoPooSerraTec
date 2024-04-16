package poo.trabalho.serratec.model;

import java.time.LocalDate;

public class Personal extends Pessoa{
	private Especialidade especialidade;
	private String cref;
	private String horarioAtendimento;
	
	public Personal(String nome, String cpf, LocalDate dataNascimento, String telefone, String email, String senha, String tipo, 
			Especialidade especialidade, String cref, String horarioAtendimento) {
		super(nome, cpf, dataNascimento, telefone, email, senha, tipo);
		this.especialidade = especialidade;
		this.cref = cref;
		this.horarioAtendimento = horarioAtendimento;
	}
	
	public Personal(String cpf, String tipo, String senha) {
		super(cpf, tipo, senha);
	}

	public Especialidade getEspecialidade() {
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