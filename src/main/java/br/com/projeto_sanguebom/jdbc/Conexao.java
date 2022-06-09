package br.com.projeto_sanguebom.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public static Connection conectar() {
			
			Connection con = null;
			
			try {
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("pau");
					e.printStackTrace();
				}
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sanguebom_db", "root", "toor");
				System.out.println("DEPOIS DE CONECTAR");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Erro na conexão\n " + e);
			}
			return con;
			
	}
	
}
