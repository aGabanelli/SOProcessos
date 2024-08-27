package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class RedesController {

	public RedesController() {
		super();
	}
	
	
	private String os() {
		return System.getProperty("os.name").toLowerCase();
	}
	
	
	public void ip() throws IOException {
		String os = os();
		String comando = "";
		
		if(os.contains("win")) {
			comando = "ipconfig";
		}
		else if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
			comando = "ip a";
		}
		else {
			comando = "ip addr";
			return;
		}
		
		try {
			Process process = Runtime.getRuntime().exec(comando);
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String linha;
			
			while((linha = reader.readLine()) != null ) {
				if (linha.contains("IPv4")) {
					System.out.println(linha.trim());
				}
			}
			reader.close();
	
		} catch(IOException e) {
			e.printStackTrace();
		}
	
	}
	
	
	
	public void ping() throws IOException{
		try {
			String comando = "";
			String os = os();
			if(os.contains("win")) {
				comando = "ping -n 10 www.google.com.br";
			} else {
				comando = "ping -c 10 www.google.com.br";
			}
			
			Process processo = Runtime.getRuntime().exec(comando);
			BufferedReader reader = new BufferedReader(new InputStreamReader(processo.getInputStream()));
			String linha;
			
			while((linha = reader.readLine()) != null ) {
				if (linha.contains("Tempo médio") || linha.contains("avg")) {
					System.out.println(linha.trim());
				}
			}
			reader.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
