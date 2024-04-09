package poo.trabalho.serratec.uteis;

import java.io.PrintStream;

public class MenuUteis {
	public static PrintStream exibeMenuAluno() {
		return  System.out.printf("""
				 --------------------------------------------------------
				 	  BEM VINDO _______(nome do aluno)
				 --------------------------------------------------------			
				 1. Visualizar dados pessoais e plano contratado.
				 2. Solicitar agendamento de horário com personal trainer.
				 3. Visualizar histórico de agendamentos.
				 4. Cancelar agendamento.
				 5. Visualizar avaliações físicas.
		
				 Informe a opção desejada:
				"""
				);
	}
	
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
	
	public static PrintStream exibeMenuPersonal() {
		return  System.out.printf("""
				 --------------------------------------------------------
				 	  BEM VINDO _______(nome do personal)
				 --------------------------------------------------------			
				 1. Visualizar agenda de atendimentos.
				 2. Registrar avaliações físicas dos alunos.
				 3. Visualizar lista de avaliações realizadas.

				 Informe a opção desejada:
				"""
				);
	}
}
