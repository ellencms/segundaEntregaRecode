package com.belemtour.menu;

import java.sql.Connection;
import java.util.Scanner;
import com.belemtour.dao.DestinoDAO;
import com.belemtour.database.DataBaseConnection;
import com.belemtour.model.Destino;


public class DestinoIO {

	static Connection connection = DataBaseConnection.createConnection(); // Criando a conexão

	static DestinoDAO destinoDAO = new DestinoDAO(connection);

	public static int SubMenuDestino(Scanner scanner) {

		int option = Integer.MAX_VALUE;
		do {
			System.out.println("************************ Menu Destino ******************************************");
			System.out.println(
					"************** Escolha uma das Opções Abaixo: *******************\n" + "1- Cadastrar Destino\n"
							+ "2- Consultar Destino\n" + "3- Atualizar Destino\n" + "4-Deletar Destino\n" + "5- Sair");

			option = scanner.nextInt();

			switch (option) {
			case 1:
				scanner.nextLine();
				Destino destino = new Destino();
			

				System.out.println("Digite o Nome do Destino: ");
				destino.setNomeDestino(scanner.nextLine());

				System.out.println("Digite a Categoria do Destino ");
				destino.setCategoriaDestino(scanner.nextLine());

				System.out.println("Digite o Valor do Destino");
				destino.setValor(scanner.nextDouble());

				System.out.println("Digite o Tempo da Viagem");
				destino.setTempo(scanner.next().toUpperCase().trim());

				destinoDAO.createDestino(destino);

				break;

			case 2:

				destinoDAO.readAllDestino();

			case 3:
				Destino destinoAtualizado = new Destino();

				System.out.println("Digite o ID do Destino a ser atualizado");
				destinoAtualizado.setIdDestino(scanner.nextInt());

				System.out.println("Digite o Nome do Destino a ser Atualizado: ");
				destinoAtualizado.setNomeDestino(scanner.nextLine());

				System.out.println("Digite a Data a Categoria a ser Atualizada ");
				destinoAtualizado.setCategoriaDestino(scanner.nextLine());

				System.out.println("Digite o Valor do Destino a ser Atualizado ");
				destinoAtualizado.setValor(scanner.nextDouble());

				System.out.println("Digite o tempo da viagem a ser  Atualizada  ");
				destinoAtualizado.setTempo(scanner.next().toUpperCase().trim());

				destinoDAO.createDestino(destinoAtualizado);

				break;
			case 4:
				System.out.println("Digite  o Id do Destino a ser Deletado");
				int idDestino = scanner.nextInt();
				destinoDAO.deleteDestino(idDestino);

				break;

			default:
				System.out.println("Opção Digitada Invalida!");

				break;
			}

		} while (option != 0);
		return option;

	}
}
