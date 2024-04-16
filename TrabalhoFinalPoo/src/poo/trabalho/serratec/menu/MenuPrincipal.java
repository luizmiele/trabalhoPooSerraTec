package poo.trabalho.serratec.menu;

import java.time.LocalDate;
import java.util.Scanner;

import poo.trabalho.serratec.dao.AlunoDAO;
import poo.trabalho.serratec.dao.FuncionarioDAO;
import poo.trabalho.serratec.dao.PlanoDAO;
import poo.trabalho.serratec.model.Aluno;
import poo.trabalho.serratec.model.Cargo;
import poo.trabalho.serratec.model.Funcionario;
import poo.trabalho.serratec.model.Plano;
import poo.trabalho.serratec.service.MenuService;

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
				MenuFuncionario.exibeMenuFuncionario(nome);
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
				MenuPersonal.exibeMenuPersonal(nome);
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
		Scanner s = new Scanner(System.in);
	    int opcao = -1;
	    boolean retorna = true;
	    
	    while (opcao != 8) {
	    	  opcao = opcaoMenu;
	        
	        if (opcao == 1) {
	            System.out.println("\nCadastrando novo plano...\n");
	            
	            String nomePlano = "";
	            String descricao = MenuService.leDescricao();
	            int duracao = 30;
	            double valor = 0.0;
	            
	            Plano plano = new Plano(nomePlano, duracao, valor, descricao);
	            PlanoDAO planoDAO = new Plano(plano);
	            
	        } else if (opcao == 2) {
	            System.out.println("\nCadastrando novo aluno...\n");
	            
	            String nome = MenuService.leNome();
	            String cpf = MenuService.leCpf();
	            LocalDate dataNascimento = MenuService.leDataNascimento();
	            String telefone = MenuService.leTelefone();
	            String email = MenuService.leEmail();
	            String senha = MenuService.leSenha();
	            String nomePlano = MenuService.leNomePlano();
	            
	            
	            Aluno aluno = new Aluno(nome,cpf,dataNascimento,telefone,email,senha,nomePlano, nomePlano, LocalDate.now());
	            AlunoDAO.cadastra(aluno);
	        } else if (opcao == 3) {
	            System.out.println("\nCadastrando novo Personal Trainer...\n");
	        
	            String nome = MenuService.leNome();
	            String cpf = MenuService.leCpf();
	            LocalDate dataNascimento = MenuService.leDataNascimento();
	            String telefone = MenuService.leTelefone();
	            String email = MenuService.leEmail();
	            String senha = MenuService.leSenha();
	            String tipo = "Funcionario";
	            Cargo cargo = MenuService.leCargo();
	            
	            Funcionario funcionario = new Funcionario(nome,cpf,dataNascimento,telefone,email,senha,tipo, cargo);
	            FuncionarioDAO.cadastra(funcionario);
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
	
	public static void menuAluno(int opcaoMenu) {
	    int opcao = -1;
	    
	    while (opcao != 6) {
	        opcao = opcaoMenu;
	        if (opcao == 1) {
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
	        	break;
	        } else{
	            System.out.println("\nOpção inválida! Tente novamente.\n");
	        }
	    };
	}
	
	public static boolean menuPersonal(int opcaoMenu) {
	    int opcao = -1;
	    boolean retorna = true;
	    
	    while (opcao != 4) {
	        //MenuPersonal.exibeMenuPersonal(nome);
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