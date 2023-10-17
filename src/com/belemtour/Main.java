package com.belemtour;

import java.util.Scanner;

import com.belemtour.menu.ClienteIO;
import com.belemtour.menu.DestinoIO;
import com.belemtour.menu.MenuIO;
import com.belemtour.menu.PedidoIO;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in);
	     var option = Integer.MAX_VALUE;;
		
		
	    do {
	    	option = MenuIO.menu(scanner);
	    	
	    	
             switch(option) {
             case 1:
            	 
            	 ClienteIO.SubMenuCliente(scanner);
            	 
            	 break;

             case 2:
            	 
            	 PedidoIO.SubMenuPedido(scanner);
            	 
            	 break;
             case 3:
            	 
              DestinoIO.SubMenuDestino(scanner);
            	 
            	 break;

}
			
			option = MenuIO.menu(scanner);
			
			
			
		} while (option != 5);
	    scanner.close();
		

		
	}
	
	

}
