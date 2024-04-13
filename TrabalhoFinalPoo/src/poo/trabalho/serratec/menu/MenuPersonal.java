package poo.trabalho.serratec.menu;

import java.io.PrintStream;

public class MenuPersonal {

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
