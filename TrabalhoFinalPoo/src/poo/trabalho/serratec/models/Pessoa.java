package poo.trabalho.serratec.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Pessoa {
	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	private String telefone;
	private String email;
	private String senha;
	
	
	public Pessoa(String nome, String cpf, LocalDate dataNascimento, String telefone, String email, String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
	}
	
	
	
	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}


	@Override
	public String toString() {
		return "\nNome: " + nome + "\nCpf: " + cpf + "\nDataNascimento: " + dataNascimento + "\nTelefone: " + telefone + "\nEmail: " + email
				+ "\nSenha: " + senha;
	}
}
