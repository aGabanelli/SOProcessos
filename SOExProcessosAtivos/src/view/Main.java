package view;

import javax.swing.JOptionPane;

import controller.KillController;

public class Main {

	public static void main(String[] args) {
		
		KillController kc = new KillController();
		
		int opcao = 0;
		
		while (opcao!= 3) {
			
			opcao =  Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção: \n1- Lista de processos \n2- Matar PID \n3- Matar Processo \n4- Sair"));
			
			switch(opcao) {
				case 1: kc.listaProcessos();;
				break;
				case 2: 
					int pid = Integer.parseInt(JOptionPane.showInputDialog("PID "));
					kc.mataPid(pid);;
				break;
				case 3:
					String nome = JOptionPane.showInputDialog("Nome ");
					kc.mataNome(nome);
				break;
				case 4:JOptionPane.showMessageDialog(null, "Fim");
				break;
				default:JOptionPane.showMessageDialog(null, "Opção Inválida");
			}
		}
		
	}
	
}
