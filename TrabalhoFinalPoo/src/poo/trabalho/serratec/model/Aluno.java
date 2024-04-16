package poo.trabalho.serratec.model;

import java.time.LocalDate;
import java.util.List;

public class Aluno extends Pessoa{
	private Plano planoContratado;
	private LocalDate dataMatricula;
	private List<String> avaliacoesFisicas;
	
	public Aluno(String nome, String cpf, LocalDate dataNascimento, String telefone, String email, String senha, String tipo,
			Plano planoContratado, LocalDate dataMatricula) {
		super(nome, cpf, dataNascimento, telefone, email, senha, tipo);
		this.planoContratado = planoContratado;
		this.dataMatricula = dataMatricula;
	}

	public Aluno(String cpf, String tipo, String senha) {
		super(cpf, tipo, senha);
	}


	public Plano getPlanoContratado() {
		return planoContratado;
	}

	public LocalDate getDataMatricula() {
		return dataMatricula;
	}

	public List<String> getAvaliacoesFisicas() {
		return avaliacoesFisicas;
	}

	@Override
	public String toString() {
		return super.toString()+ "\nPlanoContratado: " + planoContratado + "\nDataMatricula: " + dataMatricula + "\nAvaliacoesFisicas: "
				+ avaliacoesFisicas;
	}
}