package poo.trabalho.serratec.main;


import java.time.LocalDate;

import poo.trabalho.serratec.DAO.AlunoDAO;
import poo.trabalho.serratec.models.Aluno;

public class Main {

	public static void main(String[] args) {
		
		Aluno alunoPURAO = new Aluno("GUGU", "12345678910", LocalDate.of(1999, 1, 1), "22222-2222", "Gugu@BV.com.br", "123456", "PINK", LocalDate.of(2024, 1,1) );
		
		
		AlunoDAO aluno = new AlunoDAO();
		
		aluno.cadastra(alunoPURAO); //FAZ O L.
		
	}
}