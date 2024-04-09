package poo.trabalho.serratec.main;

import java.time.LocalDate;

import poo.trabalho.serratec.models.Aluno;
import poo.trabalho.serratec.uteis.MenuUteis;

public class Main {

	public static void main(String[] args) {
		//MenuUteis.exibeMenuAluno();
		//MenuUteis.exibeMenuFuncionario();
		//MenuUteis.exibeMenuPersonal();
		
		Aluno aluno = new Aluno("Miele", "12345678910", LocalDate.of(1993, 2, 6), "99999-9999", "luiz.miele@hotmail.com", "123", "Gold", LocalDate.now());
		
		System.out.println(aluno);
	}

}
