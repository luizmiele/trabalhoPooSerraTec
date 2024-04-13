package poo.trabalho.serratec.main;


import java.time.LocalDate;

import poo.trabalho.serratec.DAO.FuncionarioDAO;
import poo.trabalho.serratec.models.Funcionario;

public class Main {

	public static void main(String[] args) {
		
		//Aluno alunoPURAO = new Aluno("Lucas Amorin2", "12345678900", LocalDate.of(2007, 2, 11), "11111-1111", "lucas@amorin.com.br", "456", "PINK", LocalDate.of(2024, 4,12) );
		
		
		//AlunoDAO aluno = new AlunoDAO();
		
		//aluno.cadastra(alunoPURAO);
		
		
		Funcionario funcionarioOBJ = new Funcionario("Boeck", "12332112332", LocalDate.of(2000, 4, 17), "11111-1111", "Boeck@Academia.com", "1234", "Gerente mar brabo");
		
		FuncionarioDAO funcionario = new FuncionarioDAO();
		
		funcionario.cadastra(funcionarioOBJ);
	}
}