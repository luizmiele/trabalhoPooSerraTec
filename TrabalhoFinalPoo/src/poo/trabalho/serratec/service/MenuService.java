package poo.trabalho.serratec.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MenuService {
	
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
	
	public static String leDataNascimento(){
		Scanner  s = new Scanner(System.in);
		boolean dataCorreta = false;
		LocalDate data = null;
		String dataNascimento = "";
		String dataFormatada = null;
		
		while(!dataCorreta) {
			System.out.println("Digite a Data de Nascimento: (no formato dd-MM-yyyy)");
			dataNascimento = s.nextLine();
			
			DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			
			try {
				data = LocalDate.parse(dataNascimento, df);
				
				if (data.getYear() >= (LocalDate.now().getYear() - 140) && data.getYear() <= LocalDate.now().getYear()) {
					dataFormatada = df.format(data);
                    break;
				}
                System.out.println("Ano inválido. O ano deve estar entre " + (LocalDate.now().getYear() - 140) +  " e " + LocalDate.now().getYear());
			}catch(Exception e) {
				System.out.println("Formato de data inválido. Use o formato dd-MM-yyyy.");
			}
		}
		return dataFormatada;
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
