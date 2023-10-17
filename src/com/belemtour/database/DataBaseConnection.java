package com.belemtour.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
	
	private static final String url="jdbc:mysql://localhost:3306/belemtour";
	
	private static final String user="root";
	
	private static final String password="root";
	
	public static final Connection createConnection() {// Criação do contrutor de conexâo
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // Inicializando o driver
			System.out.println("Driver Encontrado!");
			
							
		} catch (ClassNotFoundException e) { 
			
			System.out.println("Driver não Encontrado! Mensagem: " + e.getMessage());
			
		}
		try {
			Connection connection = DriverManager.getConnection(url, user,password); //Inicializando a conexão
			System.out.println("Conectado com Sucesso!");
			return connection;
		
		} catch (SQLException e) {
			System.out.println("Não foi possivel conectar ao banco! Mensagem:" + e.getMessage());
			return null;
			
		}
		
		
		
		
		
	}


	
	

}
