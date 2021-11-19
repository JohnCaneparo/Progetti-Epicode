package it.epicode.jee.service;

import java.util.List;

import it.epicode.jee.dao.ProdottoDAO;
import it.epicode.jee.model.Prodotto;

public class ProdottoService {
	ProdottoDAO p = new ProdottoDAO();
	
	public void saveProdotto(Prodotto prod) {
		p.saveProdotto(prod);
	}
	
	public void updateProdotto(int codiceProd, Prodotto prod) {
		p.updateProdotto(codiceProd, prod);
	}
	
	public void deleteProdotto(int codiceProd) {
		p.deleteProdotto(codiceProd);
	}
	
	public Prodotto getProdotto(int codiceProd) {
		return p.getProdotto(codiceProd);
	}
	
	public List<Prodotto> getProdottoAll() {
		return p.getProdottoAll();
	}
	
	public List<Prodotto> getProdottoPerForn(int forn) {
		return p.getProdottoPerForn(forn);
	}
}
