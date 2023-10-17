package com.belemtour.menu;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import com.belemtour.dao.PedidoDAO;
import com.belemtour.database.DataBaseConnection;
import com.belemtour.model.Cliente;
import com.belemtour.model.Pedido;

public class PedidoIO {
	static Connection connection = DataBaseConnection.createConnection(); // Criando a conexão

	static PedidoDAO pedidoDAO = new PedidoDAO(connection);
	
	
	public static int SubMenuPedido(Scanner scanner) {
		
		
		int option = Integer.MAX_VALUE;
		do {
			System.out.println("************************ Menu Pedido ******************************************");
			System.out.println("************** Escolha uma das Opções Abaixo: *******************\n" + "1- Cadastrar Pedido\n"
					+ "2- Consultar Pedido\n" + "3- Atualizar Pedido\n" + "4-Deletar Pedido\n" + "5- Sair");

		
			option = scanner.nextInt();

			switch (option) {
			case 1:
				scanner.nextLine();
				Pedido pedido = new Pedido();
				Cliente cliente = new Cliente();

				System.out.println("Digite o Nome do Cliente: ");
				cliente.setNome(scanner.nextLine());

				System.out.println("Digite a Data do pedido ");
				String dataEHora = scanner.nextLine();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy HH:mm:ss");
				pedido.setDataPedido(LocalDateTime.parse(dataEHora, formatter));
		
				System.out.println("Digite o Status do Pedido ");
				pedido.setStatus(scanner.nextLine());
				
				System.out.println("Digite a Forma de Pagamento ");
				pedido.setFormaPagamento(scanner.nextLine().toUpperCase().trim());

				
				pedidoDAO.createPedido(pedido);

				break;

			case 2:

				pedidoDAO.readAllPedido();

			case 3:
				Pedido pedidoAtualizado = new Pedido();
				

			     Cliente clientePedido = new Cliente();
				
				System.out.println("Digite o ID do Pedido a ser atualizado");
				pedidoAtualizado.setIdPedido(scanner.nextInt());
			
				System.out.println("Digite o Nome do Cliente a ser Atualizado: ");
				clientePedido.setNome(scanner.nextLine());
				pedidoAtualizado.setCliente(clientePedido);
				
				System.out.println("Digite a Data do pedido a ser Atualizada ");
				String dataEHoraUP = scanner.nextLine();
				DateTimeFormatter formatterUP = DateTimeFormatter.ofPattern("dd/mm/yyyy HH:mm:ss");
				pedidoAtualizado.setDataPedido(LocalDateTime.parse(dataEHoraUP, formatterUP));
									
				System.out.println("Digite o Status do Pedido a ser Atualizado ");
				pedidoAtualizado.setStatus(scanner.nextLine());
				
				System.out.println("Digite a Forma de Pagamento a ser Atualizada  ");
				pedidoAtualizado.setFormaPagamento(scanner.nextLine().toUpperCase().trim());

				
				pedidoDAO.createPedido(pedidoAtualizado);

				break;
			case 4:
				System.out.println("Digite  o Id do Cliente a ser Deletado");
				int idPedido = scanner.nextInt();
				pedidoDAO.deletePedido(idPedido);

				break;

			default:
				System.out.println("Opção Digitada Invalida!");

				break;
			}

		} while (option != 0);
		return option;
	

		
	}
	
	
	
	
	
	

}
