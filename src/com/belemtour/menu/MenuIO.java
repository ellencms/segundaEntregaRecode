package com.belemtour.menu;

import java.util.Scanner;

public class MenuIO {

	
	
	public static int menu(Scanner scanner){
		
		System.out.println("****************************** Menu Principal ****************************************************\n"
				+ "\n 1- Cadastrar Cliente" + "\n 2 - Cadastrar Pedido" + "\n 3 - Cadastrar Destino");
		 return scanner.nextInt();
		 
		 
		
	}
	
	
	
}
	