package poo.trabalho.serratec.models;

import java.time.LocalDate;
import java.util.List;

public class Aluno extends Pessoa{
	private String planoContratado;
	private LocalDate dataMatricula;
	private List<String> avaliacoesFisicas;
	
	
	public Aluno(String nome, String cpf, LocalDate dataNascimento, String telefone, String email, String senha, String tipo,
			String planoContratado, LocalDate dataMatricula) {
		super(nome, cpf, dataNascimento, telefone, email, senha, tipo);
		this.planoContratado = planoContratado;
		this.dataMatricula = dataMatricula;
	}
	
	
	
	public Aluno(String cpf, String senha) {
		super(cpf, senha);
	}


	public String getPlanoContratado() {
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
