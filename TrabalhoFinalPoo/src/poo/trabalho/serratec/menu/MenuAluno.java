package poo.trabalho.serratec.menu;

import java.io.PrintStream;

public class MenuAluno {
		
	public static PrintStream exibeMenuAluno(String nome) {
		return  System.out.printf("""
				 --------------------------------------------------------
				 	         BEM VINDO %s
				 --------------------------------------------------------			
				 1. Visualizar dados pessoais e plano contratado.
				 2. Solicitar agendamento de horário com personal trainer.
				 3. Visualizar histórico de agendamentos.
				 4. Cancelar agendamento.
				 5. Visualizar avaliações físicas.
				 6. Sair.
		
				 Informe a opção desejada:
				""",nome
				);
	}
}
