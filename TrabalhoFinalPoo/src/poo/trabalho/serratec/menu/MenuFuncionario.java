package poo.trabalho.serratec.menu;

import java.io.PrintStream;

public class MenuFuncionario {
	
	public static PrintStream exibeMenuFuncionario(String nome) {
		return  System.out.printf("""
				 --------------------------------------------------------
				 	              	BEM VINDO %s
				 --------------------------------------------------------			
				 1. Cadastrar novo plano
				 2. Cadastrar novo aluno
				 3. Cadastrar novo Personal Trainer
				 4. Emtir relatório de planos
				 5. Emitir relatório de alunos
				 6. Emitir relatório de equipe (funcionários e personal trainers)
				 7. Emitir relação de avaliações físicas por período
				 8. Sair.
				 
				 Informe a opção desejada:
				""",nome
				);
	}
}