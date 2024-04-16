package poo.trabalho.serratec.model;

import java.time.LocalDate;

public class Funcionario extends Pessoa {
	private Cargo cargo;

	public Funcionario(String nome, String cpf, LocalDate dataNascimento, String telefone, String email, String senha, String tipo,
			Cargo cargo) {
		super(nome, cpf, dataNascimento, telefone, email, senha,tipo);
		this.cargo = cargo;
	}
	
	public Funcionario(String cpf, String senha) {
		super(cpf,senha);
	}
	

	public Cargo getCargo() {
		return cargo;
	}

	@Override
	public String toString() {
		return super.toString() + "Cargo: " + cargo;
	}
}
