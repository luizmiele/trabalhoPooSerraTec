package poo.trabalho.serratec.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import poo.trabalho.serratec.model.Cargo;

public class MenuService {
	
	public static String leDescricao() {
		Scanner s = new Scanner(System.in);
		String descricao = "";
		boolean descricaoOK = false;
		
		while(!descricaoOK) {
			System.out.println("Informe a descrição do plano: ");
			descricao = s.nextLine();
			if(descricao.isBlank() || descricao.length() > 200) {
				System.out.println("Descrição invalida!");
			}else {
				break;
			}
		}
		return descricao;
	}
	
	public static double leValor() {
		// FAZER
		return 0.0;
	}
	public static String leDuracao() {
		// FAZER
		return "PARA DE DAR ERRO PORRA";
	}
	
	public static String leNomePlano() {
		//FAZER UM METODO PARA BUSCAR TUDO DE TODOS OS PLANOS BUSCADO , FAZER UM MENU PARA A PESSOA ESCOLHER O PLANO PELO ID
		//FAZER 
		return "PARA DER DAR ERRO DESGRAÇA!";
	}
	
	public static Cargo leCargo() {
		Scanner s = new Scanner(System.in);
		int opcao = -1;
		Cargo cargo = null;
		
		boolean cargoOK = false;
			while(!cargoOK) {
				System.out.printf("""	
						Selecione o cargo desejado:
						1- Recepcionista
						2- ADM
						3- Gerente
						
						""");
				
	    		opcao = s.nextInt();
	    		
	    		if(opcao == 1) {
	    			cargo = Cargo.RECEPCIONISTA;
	    			break;
	    		}else if (opcao == 2) {
	    			cargo = Cargo.ADM;
	    			break;
	    		}else if (opcao == 3) {
	    			cargo = Cargo.GERENTE;
	    			break;
	    		} else {
	    			System.out.println("Cargo invalido! Selecione uma opção existente!");
	    		}
			}
		return cargo;
	}
	
	public static String leSenha() {
		Scanner s = new Scanner(System.in);
    	String senha = "";
    	boolean senhaOK = false;
    	
    	while(!senhaOK) {
    		System.out.println("Digite uma senha de até 10 digitos: ");
    		senha = s.nextLine();
    		if (senha.length() > 10) {
	        	System.out.println("Senha muito longa! Digite novamente!");
	        }else {
	        	break;
	        }
    	}
    	return senha;
	}
	
	public static String leCpf() {
    	Scanner scanner = new Scanner(System.in);
    	String cpf = "";
    	String cpfNumerico = "";
    	boolean cpfCorreto = false;
    	while(!cpfCorreto) {
	        System.out.print("Digite o CPF: ");
	        cpf = scanner.nextLine();
	        
	        cpfNumerico = cpf.replaceAll("[^0-9]", "");

	        if (cpfNumerico.length() != 11) {
	        	System.out.println("CPF INVALIDO! Digite novamente!");
	        }else {
	        	break;
	        }
    	}
    	return cpfNumerico;
    }
	
	public static String leCref() {
		Scanner s = new Scanner(System.in);
		String numCref;
		
		while(true) {
			System.out.println("Insira apenas os numeros do CREF: ");
			numCref = s.nextLine();
			
			Pattern pattern = Pattern.compile("^\\d{1,5}$");
            Matcher matcher = pattern.matcher(numCref);
            
            if(matcher.matches()) {
            	 return "CREF-" + numCref;
            }   
		}
	}
	
	public static String leEmail() {
		Scanner s = new Scanner(System.in);
		String email;

		while(true) {
			System.out.println("Insira o email: ");
			email = s.nextLine();
			
			Pattern pattern = Pattern.compile("^[a-zA-Z0-9+&-]+(?:\\.[a-zA-Z0-9_+&-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
            Matcher matcher = pattern.matcher(email);
            
            if (matcher.matches()) {
                break;
            } else {
                System.out.println("Formato do email invalido!");
            }
		}
		return email;
	}
	
	public static LocalDate leDataNascimento(){
		Scanner  s = new Scanner(System.in);
		boolean dataCorreta = false;
		LocalDate data = null;
		String dataNascimento = "";
		
		while(!dataCorreta) {
			System.out.println("Digite a Data de Nascimento: (no formato dd-MM-yyyy) ");
			dataNascimento = s.nextLine();
			
			DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			
			try {
				data = LocalDate.parse(dataNascimento, df);
				
				if (data.getYear() >= (LocalDate.now().getYear() - 140) && data.getYear() <= LocalDate.now().getYear()) {
                    break;
				}
                System.out.println("Ano inválido. O ano deve estar entre " + (LocalDate.now().getYear() - 140) +  " e " + LocalDate.now().getYear());
			}catch(Exception e) {
				System.out.println("Formato de data inválido. Use o formato dd-MM-yyyy.");
			}
		}
		return data;
	}
	
	public static String leNome() {
		Scanner s = new Scanner(System.in);
		String nome;
        while (true) {
            System.out.println("Digite o nome: ");
            nome = s.nextLine();

            Pattern pattern = Pattern.compile("^[a-zA-ZÀ-ÿ]+(\\s+[a-zA-ZÀ-ÿ]+)*$");
            Matcher matcher = pattern.matcher(nome);

            if (matcher.matches()) {
                break;
            } else {
                System.out.println("Nome inválido. Use apenas letras e espaços.");
            }
        }
        return nome;
    }
	
	public static String leTelefone() {
		Scanner sc = new Scanner(System.in);
		boolean quebra = true;
		
		String telefoneRegex = "\\d{9}";
		String telefoneFormat = "";
		while(quebra == true) {
			System.out.println("Telefone 9 digitos ( apenas numero): ");
			String telefone = sc.nextLine();
			if(telefone.length() == 9) {
				if (Pattern.matches(telefoneRegex, telefone)) {
					telefoneFormat = telefone.replaceAll("(\\d{5})(\\d{4})", "$1-$2");
		            return telefoneFormat;
				}
			}else {   
	            System.out.println("Telefone inválido! Digite o telefone novamente!");
	            quebra = true;
		    }
		}
		return telefoneFormat;
	}
}
