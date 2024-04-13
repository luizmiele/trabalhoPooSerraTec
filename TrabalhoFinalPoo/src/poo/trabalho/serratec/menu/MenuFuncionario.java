package poo.trabalho.serratec.menu;

import java.io.PrintStream;

public class MenuFuncionario {
	
	public static PrintStream exibeMenuFuncionario() {
		return  System.out.printf("""
				 --------------------------------------------------------
				 	  BEM VINDO _______(nome do funcionario)
				 --------------------------------------------------------			
				 1. Cadastrar novo plano
				 2. Cadastrar novo aluno
				 3. Cadastrar novo Personal Trainer
				 4. Emtir relatório de planos
				 5. Emitir relatório de alunos
				 6. Emitir relatório de equipe (funcionários e personal trainers)
				 7. Emitir relação de avaliações físicas por período
				 
				 Informe a opção desejada:
				"""
				);
	}
}