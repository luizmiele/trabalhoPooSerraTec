package poo.trabalho.serratec.model;

import java.time.LocalDate;

public abstract class Pessoa {
	private int pessoaID;
	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	private String telefone;
	private String email;
	private String senha;
	private String tipo;
	
	
	public Pessoa (String cpf, String senha) {
		this.cpf = cpf;
		this.senha = senha;
	}
	public Pessoa(String nome, String cpf, LocalDate dataNascimento, String telefone, String email, String senha, String tipo) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
		this.tipo = tipo;
	}
	
	public int getID() {
		return pessoaID;
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

	

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "\nNome: " + nome + "\nCpf: " + cpf + "\nDataNascimento: " + dataNascimento + "\nTelefone: " + telefone + "\nEmail: " + email
				+ "\nSenha: " + senha;
	}



	public String getTipo() {
		return tipo;
	}
}
