package com.belemtour.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.belemtour.model.Cliente;

public class ClienteDAO {

	private static String sql;

	private final Connection connection;

	public ClienteDAO(Connection connection) {// criação do construtor
		this.connection = connection;
	}

	// Construção do CREATE

	public void createCliente(Cliente cliente) {

		sql = "INSERT INTO cliente (nome,cpf,telefone,endereco,email) VALUES (?,?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getTelefone());
			stmt.setString(4, cliente.getEndereco());
			stmt.setString(5, cliente.getEmail());

			stmt.executeUpdate();

			System.out.println(" Cadastro Realizado com Sucesso! " + " Cliente:"+ cliente.getNome() + "  CPF:" + cliente.getCpf());

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}

	}
	
	// Criação do Read
	
	public void readAllCliente() {
		
		sql="SELECT * FROM cliente";
		try(PreparedStatement stmt = connection.prepareStatement(sql)){
		ResultSet r = stmt.executeQuery();
		while(r.next()) {
			
			Cliente cliente = new Cliente();
			
			cliente.setIdCliente(r.getInt("idCliente"));
			cliente.setNome(r.getString("Nome"));
			cliente.setCpf(r.getString("Cpf"));
			cliente.setTelefone(r.getString("Telefone"));
			cliente.setEndereco(r.getString("Endereco"));
			cliente.setEmail(r.getString("Email"));
 
			System.out.printf(" Id: %d\n Nome: %s\n CPF: %s\n Telefone:%s\n Endereço: %s\n Email: %s\n",cliente.getIdCliente(), cliente.getNome(), cliente.getCpf(), 
					cliente.getTelefone(), cliente.getEndereco(), cliente.getEmail());
		}
		if(!r.next()) {
			
			
			System.out.println("Não ha Dados");
		}
					
		} catch (SQLException e) {
			
			System.out.println("[LOG] Não foi possivel acessar as informações." + "Mensagem:" + e.getMessage());
		}
		
	}
	// Criação do UPDATE
	
	public void updateCliente(Cliente cliente) {
		
		sql= "UPDATE cliente SET nome = ?, cpf = ?,telefone = ?, endereco = ?, email = ? WHERE idCliente = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getTelefone());
			stmt.setString(4, cliente.getEndereco());
			stmt.setString(5, cliente.getEmail());
			stmt.setInt(6, cliente.getIdCliente());
			
			stmt.executeUpdate();
			System.out.println("Cliente Atualizado com Sucesso" + "Nome:" + cliente.getNome() + "\n  CPF:" + cliente.getCpf());

			
		} catch (SQLException e) {
			System.out.println("[LOG] Não foi Possivel Atualizar o Cliente. " + "Mensagem: " + e.getMessage());
			
		}
		
	}
	
	public void deleteCliente(int id) {
		sql= "DELETE FROM cliente WHERE idCliente = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql))  {
			stmt.setInt(1, id);
			
			stmt.executeUpdate();
			System.out.println("Cliente Deletado com Sucesso");
			
		} catch (SQLException e) {
			System.out.println( "Não foi Possivel Deletar o Cliente." + "Mensagem:" + e.getMessage());

			
		}
		
			
		
		
	}
	

}
