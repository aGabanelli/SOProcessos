package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DistroController {

	public DistroController() {
		super();
	}
	
	
	private String os() {
		return System.getProperty("os.name").toLowerCase();
	}
	
	
	public void exibeDistro() {
		String os = os();
		if (os.contains("linux")) {
			try {
				Process processo = Runtime.getRuntime().exec("cat /etc/os-release");
				BufferedReader reader = new BufferedReader(new InputStreamReader(processo.getInputStream()));
				String linha;
				String nomeDistro = "";
				String versaoDistro = "";
				
				while((linha = reader.readLine()) != null ) {
					if(linha.startsWith("NAME=")){
						nomeDistro = linha.split("=")[1].replace("\"", "");
					} else if (linha.startsWith("VERSION=")){
						versaoDistro = linha.split("=")[1].replace("\"", "");
					}
				}
				
				if(!nomeDistro.isEmpty() && !versaoDistro.isEmpty()) {
					System.out.println("Distribuição: " + nomeDistro);
					System.out.println("Versão: " + versaoDistro);
				} else {
					System.out.println("Não foi possivel identificar a distrubuição linux");
				}
				
				reader.close();
				
			} catch(Exception e){
				e.printStackTrace();
			}
		} else {
			System.out.println("SO não é linux");
		}
	}
	
}
