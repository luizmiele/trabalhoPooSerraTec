package poo.trabalho.serratec.menu;

import java.util.Scanner;

import poo.trabalho.serratec.dao.AlunoDAO;

public class MenuPrincipal {
	
	public static int leMenu(String tipo, String nome) {
		Scanner  s = new Scanner(System.in);
		int opcao = 0;
		boolean validador = true;
		
		do {			
			if(tipo.equalsIgnoreCase("aluno")) {
			MenuAluno.exibeMenuAluno(nome);
				 if (s.hasNextInt()) {
					 opcao = s.nextInt();
				 } else {
					 opcao = -1;
				 }
				if(opcao < 1 || opcao > 6 ) {
					System.out.println("Opção inválida!");
					validador = false;
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}	
			 }else if (tipo.equalsIgnoreCase("funcionario")) {
				MenuFuncionario.exibeMenuFuncionario();
				if (s.hasNextInt()) {
					 opcao = s.nextInt();
				} else {
					 opcao = -1;
				}			
				if(opcao < 1 || opcao > 7 ) {
					System.out.println("Opção inválida!");
					validador = false;
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}			
			} else if (tipo.equalsIgnoreCase("personal")) {
				MenuPersonal.exibeMenuPersonal();
				 if (s.hasNextInt()) {
					 opcao = s.nextInt();
				 } else {
					 opcao = -1;
				 }
				if(opcao < 1 || opcao > 3 ) {
					System.out.println("Opção inválida!");
					validador = false;
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}while(!validador);	
		return opcao;
	}
	
	public static boolean menuFuncionario(int opcaoMenu) {
	    int opcao = -1;
	    boolean retorna = true;
	    
	    while (opcao != 8) {
	    	  opcao = opcaoMenu;
	        
	        if (opcao == 1) {
	            System.out.println("\nCadastrando novo plano...\n");
	        } else if (opcao == 2) {
	            System.out.println("\nCadastrando novo aluno...\n");
	        } else if (opcao == 3) {
	            System.out.println("\nCadastrando novo Personal Trainer...\n");
	        } else if (opcao == 4) {
	            System.out.println("\nEmitindo relatório de planos...\n");
	        } else if (opcao == 5) {
	            System.out.println("\nEmitindo relatório de alunos...\n");
	        } else if (opcao == 6) {
	            System.out.println("\nEmitindo relatório de equipe... \n");
	        } else if (opcao == 7) {
	            System.out.println("\nEmitindo relação de avaliações físicas por período...\n");
	        } else if (opcao == 8) {
	        	retorna = false;
	        } else{
	            System.out.println("\nOpção inválida! Tente novamente.\n");
	        }
	    }
		return retorna;
	}
	
	public static boolean menuAluno(int opcaoMenu) {
	    int opcao = -1;
	    boolean retorna = true;
	    
	    while (opcao != 6) {
	        opcao = opcaoMenu;
	        if (opcao == 1) {
	        	System.out.println(AlunoDAO.getDadosPessoaisAluno("123"));
	            break;
	        } else if (opcao == 2) {
	            System.out.println("\nSolicitando agendamento de horário com personal trainer...\n");
	            break;
	        } else if (opcao == 3) {
	            System.out.println("\nVisualizando histórico de agendamentos...\n");
	            break;
	        } else if (opcao == 4) {
	            System.out.println("\nCancelando agendamento...\n");
	            break;
	        } else if (opcao == 5) {
	            System.out.println("\nVisualizando avaliações físicas...\n");
	            break;
	        } else if (opcao == 6) {
	        	System.out.println("\nPrograma Finalizado.\n");
	        	retorna = false;
	        } else{
	            System.out.println("\nOpção inválida! Tente novamente.\n");
	        }
	    }
		return retorna;
	}
	
	public static boolean menuPersonal(int opcaoMenu) {
	    int opcao = -1;
	    boolean retorna = true;
	    
	    while (opcao != 4) {
	        MenuPersonal.exibeMenuPersonal();
	        opcao = opcaoMenu;
	        
	        if (opcao == 1) {
	            System.out.println("\nVisualizando agenda de atendimentos...\n");
	        } else if (opcao == 2) {
	            System.out.println("\nRegistrando avaliações físicas dos alunos...\n");
	        } else if (opcao == 3) {
	            System.out.println("\nVisualizando lista de avaliações realizadas...\n");
	        } else if (opcao == 4) {
	        	retorna = false;
	        	System.out.println("\nFinalizando Programa!\n");
	        } else {
	            System.out.println("\nOpção inválida! Tente novamente.\n");
	        }
	    }
		return retorna;
	}
}