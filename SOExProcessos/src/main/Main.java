package main;

import java.io.IOException;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Main {

	public static void main(String[] args) throws IOException {
		RedesController rd = new RedesController();
		int opcao = 0;
		
		while (opcao!= 3) {
			
			opcao =  Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção: \n1- Método IP \n2- Método Ping \n3- Sair"));
			
			switch(opcao) {
				case 1: rd.ip();
				break;
				case 2: rd.ping();
				break;
				case 3:JOptionPane.showMessageDialog(null, "Fim");
				break;
				default:JOptionPane.showMessageDialog(null, "Opção Inválida");
			}
		}
		

		
	}
	
}
