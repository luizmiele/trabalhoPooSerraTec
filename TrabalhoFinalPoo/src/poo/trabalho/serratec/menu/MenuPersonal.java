package poo.trabalho.serratec.menu;

import java.io.PrintStream;

public class MenuPersonal {

	public static PrintStream exibeMenuPersonal(String nome) {
		return  System.out.printf("""
				 --------------------------------------------------------
				  					BEM VINDO 
				 --------------------------------------------------------			
				 1. Visualizar agenda de atendimentos.
				 2. Registrar avaliações físicas dos alunos.
				 3. Visualizar lista de avaliações realizadas.
				 4. Sair.

				 Informe a opção desejada:
				"""
				);
	}
}
