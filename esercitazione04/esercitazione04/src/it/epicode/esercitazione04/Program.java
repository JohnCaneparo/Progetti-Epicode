package it.epicode.esercitazione04;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Program {
	
	private static final Logger logger = LoggerFactory.getLogger(Program.class);

	public static void main(String[] args) {

		FornitoreDAO f = new FornitoreDAO();
		Fornitore forn1 = new Fornitore(1, "FornitoreRoma", "via del Corso", "Roma");
		Fornitore forn2 = new Fornitore(2, "FornitoreNapoli", "via di Napoli", "Napoli");
		Fornitore forn3 = new Fornitore(3, "FornitoreMilano", "via di Brera", "Milano");
		Fornitore forn4 = new Fornitore(4, "Monge", "Piazza di Spagna", "Roma");
		
		ProdottoDAO p = new ProdottoDAO();
		Prodotto prod1 = new Prodotto(1, "Sapone", "flacone di sapone da 100mL", "marca1", 1, 2.50);
		Prodotto prod2 = new Prodotto(2, "Quaderno", "quaderno a righe da 100 pagine", "Pigna", 2, 1.00);
		Prodotto prod3 = new Prodotto(3, "Matita", "matita b2", "Stabilo", 2, 0.50);
		Prodotto prod4 = new Prodotto(4, "Maglietta", "maglietta 100% cotone", "Vans", 3, 25.50);
		Prodotto prod5 = new Prodotto(5, "Scarpe", "Stivaletti di pelle", "Dr.Martens", 4, 150.00);
				
			//salvataggio dei fornitori nella tabella Fornitore
//			f.saveFornitore(forn1);
//			f.saveFornitore(forn2);
//			f.saveFornitore(forn3);
			
			//rimozione di un fornitore dalla tabella dato il codice fornitore
//			f.deleteFornitore(forn2.getCodiceFornitore());
			
			//ricerca e stampa di un fornitore dato il codice fornitore
			logger.info(""+f.getFornitore(3));
			
			//stampa di tutti  i fornitori salvati nella tabella Fornitore
			f.getFornitoreAll().forEach(a -> logger.info(""+a) );
			
//			f.saveFornitore(forn4);
			
			//ricerca e stampa di tutti i fornitori data una città
			f.getFornitorePerCitta("Roma").forEach(a -> logger.info(""+a));
			
			
			//salvataggio dei prodotti nella tabella Prodotto
//			p.saveProdotto(prod1);
//			p.saveProdotto(prod2);
//			p.saveProdotto(prod3);
//			p.saveProdotto(prod4);
//			p.saveProdotto(prod5);
			
			//rimozione di un prodotto dalla tabella dato un codice prodotto
//			p.deleteProdotto(5);
			
			//ricerca e stampa di un prodotto dato il codice prodotto
//			logger.info(""+p.getProdotto(3));
			
			//stampa di tutti i prodotti salvati nella tabella Prodotto
//			p.getProdottoAll().forEach(a -> logger.info(""+a));
			
			//ricerca e stampa di tutti i prodotti dato un codice fornitore
//			p.getProdottoPerForn(2).forEach(a -> logger.info(""+a));
			
		
	}

}
