package poo.trabalho.serratec.models;

import java.time.LocalDate;
import java.util.List;

public class Funcionario extends Pessoa {
	private String cargo;

	public Funcionario(String nome, String cpf, LocalDate dataNascimento, String telefone, String email, String senha,
			String cargo) {
		super(nome, cpf, dataNascimento, telefone, email, senha);
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return super.toString() + "Cargo: " + cargo;
	}

	
	
	
	
	
}
