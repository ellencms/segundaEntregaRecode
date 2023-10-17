package com.belemtour.menu;

import java.sql.Connection;
import java.util.Scanner;

import com.belemtour.dao.ClienteDAO;
import com.belemtour.database.DataBaseConnection;
import com.belemtour.model.Cliente;

public class ClienteIO {

	static Connection connection = DataBaseConnection.createConnection(); // Criando a conexão

	static ClienteDAO clienteDAO = new ClienteDAO(connection);

	public static int SubMenuCliente(Scanner scanner) {
		
		int option = Integer.MAX_VALUE;
		do {
			System.out.println("************************ Menu Cliente ******************************************");
			System.out.println("************** Escolha uma das Opções Abaixo: *******************\n" + "1- Cadastrar\n"
					+ "2- Consultar Dados\n" + "3- Atualizar Dados\n" + "4-Deletar Dados\n" + "0- Sair");

			option = scanner.nextInt();

			switch (option) {
			case 1:
				scanner.nextLine();
				Cliente cliente = new Cliente();
				System.out.println("Digite o Nome Completo: ");
				cliente.setNome(scanner.nextLine());

				System.out.println("Digite o Número do seu CPF: ");
				cliente.setCpf(scanner.next().trim());

				System.out.println("Digite o Número do Telefone: ");
				cliente.setTelefone(scanner.next().trim());
				System.out.println("Digite seu Endereço: ");
				cliente.setEndereco(scanner.nextLine());

				scanner.nextLine();

				System.out.println("Digite seu Email: ");
				cliente.setEmail(scanner.nextLine());

				clienteDAO.createCliente(cliente);

				break;

			case 2:

				clienteDAO.readAllCliente();

			case 3:
				Cliente clienteAtualizado = new Cliente();

				System.out.println("Digite o ID do Cliente a ser atualizado");
				clienteAtualizado.setIdCliente(scanner.nextInt());
				scanner.nextLine();

				System.out.println("Digite o Nome Completo: ");
				clienteAtualizado.setNome(scanner.nextLine());

				System.out.println("Digite o Número do seu CPF: ");
				clienteAtualizado.setCpf(scanner.next().trim());

				System.out.println("Digite o Número do Telefone: ");
				clienteAtualizado.setTelefone(scanner.next().trim());

				System.out.println("Digite  seu Endereço: ");
				clienteAtualizado.setEndereco(scanner.nextLine());
				scanner.nextLine();

				System.out.println("Digite seu Email ");
				clienteAtualizado.setEmail(scanner.nextLine());

				clienteDAO.updateCliente(clienteAtualizado);
				break;
			case 4:
				System.out.println("Digite  o Id do Cliente a ser Deletado");
				int idCliente = scanner.nextInt();
				clienteDAO.deleteCliente(idCliente);

				break;

			default:
				System.out.println("Opção Digitada Invalida!");

				break;
			}

		} while (option != 0);
		return option;
	

	}

}
