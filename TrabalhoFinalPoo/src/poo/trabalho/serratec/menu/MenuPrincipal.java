package poo.trabalho.serratec.menu;

import java.time.LocalDate;
import java.util.Scanner;

import poo.trabalho.serratec.dao.AlunoDAO;
import poo.trabalho.serratec.dao.PersonalDAO;
import poo.trabalho.serratec.dao.PlanoDAO;
import poo.trabalho.serratec.model.Aluno;
import poo.trabalho.serratec.model.Especialidade;
import poo.trabalho.serratec.model.Funcionario;
import poo.trabalho.serratec.model.Personal;
import poo.trabalho.serratec.model.Plano;
import poo.trabalho.serratec.service.MenuService;

public class MenuPrincipal {
	
	public static int leMenu(String nome, String tipo,String cpf) {
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
				}
			}
		}while(!validador);
	return opcao;
	}
	
	public static boolean menuFuncionario(Funcionario funcionario) { 
		Scanner s = new Scanner(System.in);
	    int opcao = -1;
	    boolean retorna = true;
	    
	    while (opcao != 8) {
	    	
	    opcao = MenuPrincipal.leMenu(funcionario.getNome(), funcionario.getTipo(), funcionario.getSenha());
	        
	        if (opcao == 1) {
	            
	            String nomePlano = MenuService.leNomePlano();
	            int duracao = MenuService.leDuracao();
	            double valor = MenuService.leValor();
	            String descricao = MenuService.leDescricao();
	            
	            Plano plano = new Plano(nomePlano, duracao, valor, descricao);
	            PlanoDAO.cadastra(plano);
	            break;
	            
	        } else if (opcao == 2) {
	            System.out.println("\nCadastrando novo aluno...\n");
	            
	            String nome = MenuService.leNome();
	            String cpf = MenuService.leCpf();
	            LocalDate dataNascimento = MenuService.leDataNascimento();
	            String telefone = MenuService.leTelefone();
	            String email = MenuService.leEmail();
	            String senha = MenuService.leSenha();
	            String tipo = "Aluno";
	            Plano plano = PlanoDAO.getPlanoByID();
	            
	            Aluno aluno = new Aluno(nome,cpf,dataNascimento,telefone,email,senha,tipo, plano, LocalDate.now());
	            AlunoDAO.cadastra(aluno);
	            break;
	        } else if (opcao == 3) {
	            System.out.println("\nCadastrando novo Personal Trainer...\n");
	        
	            String nome = MenuService.leNome();
	            String cpf = MenuService.leCpf();
	            LocalDate dataNascimento = MenuService.leDataNascimento();
	            String telefone = MenuService.leTelefone();
	            String email = MenuService.leEmail();
	            String senha = MenuService.leSenha();
	            String tipo = "Funcionario";
	            Especialidade especialidade = MenuService.leEspecialidade();
	            String cref = MenuService.leCref();
	            String horarioAgendamento = MenuService.leHorarioAtendimento();
	            
	            Personal personal = new Personal(nome,cpf,dataNascimento,telefone,email,senha,tipo, especialidade, cref, horarioAgendamento);
	            PersonalDAO.cadastra(personal);
	        } else if (opcao == 4) {
	        	System.out.println("\nEmitindo relatorio de planos...\n");
	        	System.out.println(PlanoDAO.getAllPlanos()); 
	        } else if (opcao == 5) {
	            System.out.println("\nEmitindo relatório de alunos...\n");
	            
	        } else if (opcao == 6) {
	            System.out.println("\nEmitindo relatório de equipe... \n");
	        } else if (opcao == 7) {
	            System.out.println("\nEmitindo relação de avaliações físicas por período...\n");
	        } else if (opcao == 8) {
	        	break;
	        } else{
	            System.out.println("\nOpção inválida! Tente novamente.\n");
	        }
	    }
	    return retorna;
	}
	
	public static boolean menuAluno(Aluno aluno) {
		Scanner s = new Scanner(System.in);
	    int opcao = -1;
	    boolean retorna = false;
	    
	    while (opcao != 6) {
	    	opcao = leMenu(aluno.getNome(), aluno.getTipo(), aluno.getSenha());
	        if (opcao == 1) {
	        	System.out.println(AlunoDAO.getDadosPessoaisAluno(aluno.getCpf()));
	            
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
	        	return retorna;
	        } else{
	            System.out.println("\nOpção inválida! Tente novamente.\n");
	        }
	    }
	    return retorna;
	}
	
	public static boolean menuPersonal(Personal personalLogado) {
	    int opcao = -1;
	    boolean retorna = true;
	    
	    while (opcao != 4) {
	    	opcao = MenuPrincipal.leMenu(personalLogado.getNome(), personalLogado.getTipo(), personalLogado.getSenha());
	        
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