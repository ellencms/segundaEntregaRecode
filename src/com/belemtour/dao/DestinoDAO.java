package com.belemtour.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.belemtour.model.Destino;
import com.belemtour.model.Pedido;

public class DestinoDAO {
	
	private static String sql;

	private final Connection connection;

	public DestinoDAO(Connection connection) {// criação do construtor
		this.connection = connection;

}
	
	// Create
	
	public void createDestino(Destino destino) {
		
		sql = "INSERT INTO destino (nomeDestino,categoriaDestino,tempo,valor) VALUES (?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			
			
			stmt.setString(1, destino.getNomeDestino());
			stmt.setString(2, destino.getCategoriaDestino());
			stmt.setString(3, destino.getTempo());
			stmt.setDouble(4,destino.getValor());

			stmt.executeUpdate();

			System.out.println(" Destino Cadastrado com Sucesso! " + " Destino:" + destino.getNomeDestino() + " valor:" 
			+ destino.getValor());

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		
	}

		// Criação do Read

		public  void readAllDestino () {
			
			
			sql = "SELECT * FROM destino  as d " + "INNER JOIN pedido as p " + "ON d.idPedido = c.idPedido"; // vai mostrar todos os dados 
			
			try(PreparedStatement stmt = connection.prepareStatement(sql)){

				ResultSet r = stmt.executeQuery();
				while(r.next()) {
					
					Destino destino = new Destino ();
					destino.setIdDestino(r.getInt("idPedido"));
					destino.setNomeDestino(r.getString("nomeDestino"));
					destino.setCategoriaDestino(r.getString("categoriaDestino"));
					destino.setTempo(r.getString("tempo"));
					destino.setValor(r.getDouble("valor"));
                       
					
	                // Dados do pedido
	                
	            	Pedido pedido = new Pedido();
					pedido.setIdPedido(r.getInt("idPedido"));
					pedido.setDataPedido(r.getTimestamp("DataPedido").toLocalDateTime());
					pedido.setStatus(r.getString("status"));
	                pedido.setFormaPagamento(r.getString("FormaPagamento"));
	                
	                
					
		 			System.out.printf(" IdPedido: %d\n NomeDestino: %s\n Categoria:%s\n Valor:",pedido.getIdPedido(),
		 					destino.getNomeDestino(),destino.getCategoriaDestino(), destino.getValor());	
			
		}
				if(!r.next()) {
									
					System.out.println("Não ha Dados");
				}
							
				} catch (SQLException e) {
					
					System.out.println("[LOG] Não foi possivel acessar as informações." + "Mensagem:" + e.getMessage());
				}
			
	}
	
	// Criação do UPDATE
		
		
		 public void updateDestino(Destino destino) {
         	Pedido pedido = new Pedido();

			 sql= "UPDATE destino SET idDestino= ?, nomeDestino = ?,categoriaDestino = ?, tempo = ?, valor = ? WHERE idPedido = ?";
				try (PreparedStatement stmt = connection.prepareStatement(sql)) {
				stmt.setInt(1, destino.getIdDestino());
				stmt.setString(2,destino.getNomeDestino());
				stmt.setString(3,destino.getCategoriaDestino());
				stmt.setString(4,destino.getTempo());
				stmt.setDouble(5,destino.getValor());
				stmt.setInt(6,pedido.getIdPedido());

	
					
					stmt.executeUpdate();
					System.out.println("Destino Atualizado com Sucesso" + "Destino:" + destino.getNomeDestino() + "\n  Categoria:"
					+ destino.getCategoriaDestino() + "\n Tempo:" + destino.getTempo() + "\n valor:" + destino.getValor());

					
				} catch (SQLException e) {
					System.out.println("[LOG] Não foi Possivel Atualizar o destino. " + "Mensagem: " + e.getMessage());
					
				}
			 
			 
		 }
		 	 
		 public void deleteDestino(int id) {
			 
			 sql = "DELETE  FROM  destino WHERE  idDestino = ?";
			 
			 try (PreparedStatement stmt = connection.prepareStatement(sql))  {
					stmt.setInt(1, id);
					stmt.executeUpdate();

				
			} catch (SQLException e) {
				
				System.out.println( "Não foi Possivel Deletar o destino." + "Mensagem:" + e.getMessage());

				
			}
			 
			 
		 }
	
}