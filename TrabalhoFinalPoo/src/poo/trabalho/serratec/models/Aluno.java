package poo.trabalho.serratec.models;

import java.time.LocalDate;
import java.util.List;

public class Aluno extends Pessoa{
	private String planoContratado;
	private LocalDate dataMatricula;
	private List<String> avaliacoesFisicas;
	private double imc;
	
	
	public Aluno(String nome, String cpf, LocalDate dataNascimento, String telefone, String email, String senha,
			String planoContratado, LocalDate dataMatricula) {
		super(nome, cpf, dataNascimento, telefone, email, senha);
		this.planoContratado = planoContratado;
		this.dataMatricula = dataMatricula;
	}
	
	
	@Override
	public String toString() {
		return super.toString()+ "PlanoContratado: " + planoContratado + "\nDataMatricula: " + dataMatricula + "\nAvaliacoesFisicas: "
				+ avaliacoesFisicas + "\nImc: " + imc;
	}
	
	
	
}
