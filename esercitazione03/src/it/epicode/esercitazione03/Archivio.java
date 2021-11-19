package it.epicode.esercitazione03;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Archivio {

	private static final Logger logger = LoggerFactory.getLogger(Archivio.class);
	private Map<String, Catalogo> mappaCatalogo = new HashMap<>();
	private final String PATH_FILE = "D:\\Epicode\\Files\\Archivio.txt";

	public static void main(String[] args) {

		Archivio cat = new Archivio();
		cat.esegui();

	}

	private void esegui() {
		Catalogo libro1 = new Libro("1234", "Game of Thrones", "2012", 963, "George Martin", "Fantasy");
		Catalogo rivista1 = new Rivista("4321", "Gossip", "2023", 20, Periodicita.MENSILE);

		aggiungiElemento(rivista1);
		aggiungiElemento(libro1);
		System.out.println();

		//stampa della mappa
//		mappaCatalogo.forEach((key, value ) -> logger.info(key + " - " + value.getTitolo() + " - " + value.getNumPagine()));

//		rimozioneElemento(rivista1);

//		//stampa della mappa
//		mappaCatalogo.forEach((key, value ) -> logger.info(key + " - " + value.getTitolo() + " - " + value.getNumPagine()));

		ricercaElementoPerISBN("1234");
		System.out.println();
		ricercaElementoPerAnnoPub("2023");
		System.out.println();
		ricercaElementoPerAutore("George Martin");
		System.out.println();
		salvataggioArchivio();
		System.out.println();
		caricaArchivio();
		
	}

	public void aggiungiElemento(Catalogo c) {
		mappaCatalogo.put(c.getCodiceISBN(), c);
		logger.info("Hai aggiunto l'elemento con successo.");
	}

	public void rimozioneElemento(Catalogo c) {
		mappaCatalogo.remove(c.getCodiceISBN());
		logger.info("Hai rimosso l'elemento con successo.");
	}

	public void ricercaElementoPerISBN(String ISBN) {
		for (String a : mappaCatalogo.keySet()) {
			if (a == ISBN) {
				logger.info("Elemento trovato con codice ISBN: " + mappaCatalogo.get(ISBN));
				return;
			} else {
				logger.error("ERROR: la chiave inserita non è presente nell'archivio");
			}
		}

	}

	public void ricercaElementoPerAnnoPub(String anno) {
		List<Catalogo> lstMap = mappaCatalogo.values().stream().collect(Collectors.toList());
		for (Catalogo a : lstMap) {

			if (anno == a.getAnnoPubblicazione()) {
				logger.info("Elemento trovato con anno pubblicazione: " + a);
				return;
			} else {
				logger.error("ERROR: elemento non trovato");
			}

		}
	}

	public void ricercaElementoPerAutore(String autore) {
		List<Catalogo> lstMap = mappaCatalogo.values().stream().collect(Collectors.toList());
		for (Catalogo a : lstMap) {
			if (a instanceof Libro) {

				if (autore == ((Libro) a).getAutore()) {
					logger.info("Elemento trovato con autore: " + a);
					return;
				} else {
					logger.error("ERROR: elemento non trovato");
				}
			}
		}
	}

	public void salvataggioArchivio() {
		String str = generaStringa();
		File f = new File(PATH_FILE);
		try {
			FileUtils.writeStringToFile(f, str, "UTF-8");
		} catch (IOException e) {
			logger.error("Errore nel salvataggio dell'archivio.");
			e.printStackTrace();
		}
		logger.info("Archivio salavato correttamente.");
	}

	public String generaStringa() {
		String libriRiviste = "";
		for (Catalogo a : mappaCatalogo.values()) {
			if (a instanceof Libro) {
				libriRiviste += a.getCodiceISBN() + " - " + a.getTitolo() + " - " + a.getAnnoPubblicazione() + " - "
						+ a.getNumPagine() + " - " + ((Libro) a).getAutore() + " - " + ((Libro) a).getGenere() + " - " + "Lib &"
						+ "\n";
			}
			if (a instanceof Rivista) {
				libriRiviste += a.getCodiceISBN() + " - " + a.getTitolo() + " - " + a.getAnnoPubblicazione() + " - "
						+ a.getNumPagine() + " - " + ((Rivista) a).getPeriodicita() + " - " + "Riv &" + "\n";
			}
		}
		return libriRiviste;
	}

	public void caricaArchivio() {
		File f = new File(PATH_FILE);
		try {
			String str = FileUtils.readFileToString(f, "UTF-8");
			mappaCatalogo.clear();
			List<String> listaStringhe = Arrays.asList(str.split("&"));
			for (String a : listaStringhe) {
				if (a.contains("Lib")) {
					String[] strLib = a.split(" - ");
					Libro l = new Libro(strLib[0], strLib[1], strLib[2], Integer.parseInt(strLib[3]), strLib[4], strLib[5]);
					this.mappaCatalogo.put(strLib[0], l);
				} else if (a.contains("Riv")) {
					String[] strLib = a.split(" - ");
					Rivista r = new Rivista(strLib[0], strLib[1], strLib[2], Integer.parseInt(strLib[3]), Periodicita.valueOf(strLib[4]));
					this.mappaCatalogo.put(strLib[0], r);
				}
			}
			mappaCatalogo.forEach((key, value ) -> logger.info(key + " - " + value.getTitolo() + " - " + value.getNumPagine()));
		} catch (IOException e) {
			logger.error("Errore di caricamento dell'archivio");
			e.printStackTrace();
		}
		logger.info("Archivio caricato con successo.");
		
	}

	
}
