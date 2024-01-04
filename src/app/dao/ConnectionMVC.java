package app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMVC {
	
	public Connection getConnection() {
		
		Connection conn=null;
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
        String url = "jdbc:postgresql://localhost:5432/dbpersonalbudget";
        String usuario = "postgres";
        String senha = "8941";
		try {
			conn = DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
