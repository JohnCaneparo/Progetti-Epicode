package it.epicode.jee.service;

import java.util.List;

import it.epicode.jee.dao.FornitoreDAO;
import it.epicode.jee.model.Fornitore;

public class FornitoreService {
	FornitoreDAO f = new FornitoreDAO();
	
	public void saveFornitore(Fornitore forn) {
		f.saveFornitore(forn);
	}
	
	public void updateFornitore(int codiceForn, Fornitore forn) {
		f.updateFornitore(codiceForn, forn);
	}
	
	public void deleteFornitore(int codiceForn) {
		f.deleteFornitore(codiceForn);
	}
	
	public Fornitore getFornitore(int codiceForn) {
		return f.getFornitore(codiceForn);
	}
	
	public List<Fornitore> getFornitoreAll() {
		return f.getFornitoreAll();
	}
	
	public List<Fornitore> getFornitorePerCitta(String cittaPar) {
		return f.getFornitorePerCitta(cittaPar);
	}
}
