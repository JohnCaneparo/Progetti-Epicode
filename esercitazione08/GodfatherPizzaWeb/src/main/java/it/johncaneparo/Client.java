package it.johncaneparo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "it.gestioneOrdine" })
public class Client {

	public static void main(String[] args) {
		SpringApplication.run(Client.class, args);
		GestioneMenu m = new GestioneMenu();
		m.stampaMenu();
		
	}

}
