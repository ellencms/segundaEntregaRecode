package com.belemtour.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import com.belemtour.model.Cliente;
import com.belemtour.model.Pedido;

public class PedidoDAO {

	private static String sql;

	private final Connection connection;

	public PedidoDAO(Connection connection) {// criação do construtor
		this.connection = connection;
	}
// Criando o CREATE

	public void createPedido( Pedido pedido) {
	

		sql = " INSERT INTO Pedido(dataPedido, status, formaPagamento, idCliente) VALUES ( ?, ?, ?, ? )";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
		Timestamp sqlDataEHora = Timestamp.valueOf(pedido.getDataPedido());
			
			stmt.setTimestamp(1,sqlDataEHora);
			stmt.setString(2, pedido.getStatus());
			stmt.setString(3, pedido.getFormaPagamento());
			stmt.setInt(4, pedido.getCliente().getIdCliente());
			
			stmt.executeUpdate(); 
			
			System.out.println("Pedido Criado com Sucesso!" + pedido.toString());
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		}
		
	}

	// Criação do Read

	public  void readAllPedido () {
		
		
		sql = "SELECT * FROM pedido  as p " + "INNER JOIN cliente as c " + "ON p.idCliente = c.idCliente"; // vai mostrar todos os dados 
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)){

			ResultSet r = stmt.executeQuery();
			while(r.next()) {
				
				Pedido pedido = new Pedido ();
            	Cliente cliente = new Cliente();

				pedido.setIdPedido(r.getInt("idPedido"));
				pedido.setDataPedido(r.getTimestamp("DataPedido").toLocalDateTime());
				pedido.setStatus(r.getString("status"));
                pedido.setFormaPagamento(r.getString("FormaPagamento"));
                         
				cliente.setIdCliente(r.getInt("idCliente"));
				cliente.setNome(r.getString("Nome"));
				
	 			System.out.printf(" IdPedido: %d\n Data: %s\n Status:%s\n Nome Cliente:",pedido.getIdPedido(),
	 			pedido.getDataPedido(),pedido.getStatus(), cliente.getNome());	
		
	}
			if(!r.next()) {
								
				System.out.println("Não ha Dados");
			}
						
			} catch (SQLException e) {
				
				System.out.println("[LOG] Não foi possivel acessar as informações." + "Mensagem:" + e.getMessage());
			}
		}
	
	// Criação UPDATE
	 public void updatePedido(Pedido pedido) {
		 
		 sql= "UPDATE pedido SET idCliente = ?, DataPedido = ?,Status = ?, FormaPagamento = ? WHERE idPedido = ?";
			try (PreparedStatement stmt = connection.prepareStatement(sql)) {
				Timestamp sqlDataHora = Timestamp.valueOf(pedido.getDataPedido());

				stmt.setInt(1, pedido.getCliente().getIdCliente());
				stmt.setTimestamp(2,sqlDataHora());
				stmt.setString(3, pedido.getStatus());
				stmt.setString(4, pedido.getFormaPagamento());
				stmt.setInt(6,pedido.getIdPedido());
				
				stmt.executeUpdate();
				System.out.println("Pedido Atualizado com Sucesso" + "Nome:" + pedido.getCliente().getNome() + "\n  Data:"
				+ pedido.getDataPedido() + "\n Status:" + pedido.getStatus());

				
			} catch (SQLException e) {
				System.out.println("[LOG] Não foi Possivel Atualizar o Pedido. " + "Mensagem: " + e.getMessage());
				
			}
		 
		 
	 }
	 	 
	 private Timestamp sqlDataHora() {
			// TODO Auto-generated method stub
			return null;
		}

	
	// Criação Delete
	 
	
	public void deletePedido(int id) {
		 
		 sql = "DELETE  FROM  pedido WHERE  idPedido = ?";
		 
		 try (PreparedStatement stmt = connection.prepareStatement(sql))  {
				stmt.setInt(1, id);
				stmt.executeUpdate();

			
		} catch (SQLException e) {
			
			System.out.println( "Não foi Possivel Deletar o Pedido." + "Mensagem:" + e.getMessage());

			
		}
		 
		 
	 }
	
	}


	

