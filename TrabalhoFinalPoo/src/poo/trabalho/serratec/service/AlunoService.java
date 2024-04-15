package poo.trabalho.serratec.service;

import java.util.regex.Pattern;

public class AlunoService {
	
	String telefone = "123456789";
	
	
	public String telefoneFormat(String telefone) {
		
		String telefoneRegex = "\\d{9}";
		
		do {
			boolean quebra = false;
			if(telefone.length() == 9) {
				if (Pattern.matches(telefoneRegex, telefone)) {
					quebra = false;
		            return telefone.replaceAll("(\\d{5})(\\d{4})", "$1-$2");
		        }else {
		            
		            System.out.println("Telefone inválido! Digite o telefone novamente!");
		            quebra = true;
		        }
			}
			return "?????????????";
		}while(true);
	}
	/*
	public  String formatarTelefone(String telefone) {
        
		
		String telefoneRegex = "\\d{9}";
		do {
			
			if(telefone.length() == 9) {
				if (Pattern.matches(telefoneRegex, telefone)) {
		            return telefone.replaceAll("(\\d{5})(\\d{4})", "$1-$2");
		        }else {
		            // Retorna o telefone original se não for válido
		            System.out.println("Telefone inválido!");
		            return "aaaa" ;
		        }
			}
	}	
		return "aa";
	*/
}
