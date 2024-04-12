package poo.trabalho.serratec.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
	private static final String url = "jdbc:postgresql://localhost:5432/academia";
	private static final String usuario = "postgres";
    private static final String senha = "12345";
    
    private static Connection conn;
    
    public static Connection getConexao() {
    	try {
	    	if(conn == null) {
	    		conn = DriverManager.getConnection(url, usuario, senha);
	    		return conn;
	    	} else {
	    		return conn;
	    	}
    	}catch (SQLException e) {
    		e.printStackTrace();
    		return null;
    	}
    }
}


