package it.epicode.esercizio2;

public class Chiamata {
	private int durata;
	private String numeroChiamato;
	
	public int getDurata() {
		return durata;
	}
	public void setDurata(int durata) {
		this.durata = durata;
	}
	public String getNumeroChiamato() {
		return numeroChiamato;
	}
	public void setNumeroChiamato(String numeroChiamato) {
		this.numeroChiamato = numeroChiamato;
	}

	public Chiamata(int durata, String numeroChiamato) {
		this.durata = durata;
		this.numeroChiamato = numeroChiamato;
	}
}
