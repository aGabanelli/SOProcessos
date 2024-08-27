package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KillController {

	public KillController() {
		super();
	}
	
	private String os() {
		return System.getProperty("os.name").toLowerCase();
	}
	
	
	
	public void listaProcessos() {
		try {
			String comando = "";
			String os = os();
			if(os.contains("win")) {
				comando = "TASKLIST /FO TABLE";
			} else if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
				comando = "ps -ef";
			}
			
			Process processo = Runtime.getRuntime().exec(comando);
			BufferedReader reader = new BufferedReader(new InputStreamReader(processo.getInputStream()));
			String linha;
			
			while((linha = reader.readLine()) != null ) {
				System.out.println(linha);
			}
			reader.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void mataPid(int pid) {
		try {
			String comando = "";
			String os = os();
			if(os.contains("win")) {
				comando = "TASKKILL /PID " + pid;
			} else if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
				comando = "kill -9 " + pid;
			}
			
			Runtime.getRuntime().exec(comando);
			System.out.println("PID " + pid + " foi finalizado");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void mataNome(String nomeProcesso) {
		try {
			String comando = "";
			String os = os();
			if(os.contains("win")) {
				comando = "TASKKILL /IM " + nomeProcesso;
			} else if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
				comando = "pkill -f " + nomeProcesso;
			}
			
			Runtime.getRuntime().exec(comando);
			System.out.println("Processo " + nomeProcesso + " foi finalizado");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
