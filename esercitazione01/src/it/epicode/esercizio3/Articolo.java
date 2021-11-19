package it.epicode.esercizio3;

public class Articolo {
	private int codiceArticolo;
	private String descrizioneArticolo;
	private double prezzo;
	private int numeroPezziDisponibiliMagazzino;
	
	public int getCodiceArticolo() {
		return codiceArticolo;
	}
	public void setCodiceArticolo(int codiceArticolo) {
		this.codiceArticolo = codiceArticolo;
	}
	public String getDescrizioneArticolo() {
		return descrizioneArticolo;
	}
	public void setDescrizioneArticolo(String descrizioneArticolo) {
		this.descrizioneArticolo = descrizioneArticolo;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public int getNumeroPezziDisponibiliMagazzino() {
		return numeroPezziDisponibiliMagazzino;
	}
	public void setNumeroPezziDisponibiliMagazzino(int numeroPezziDisponibiliMagazzino) {
		this.numeroPezziDisponibiliMagazzino = numeroPezziDisponibiliMagazzino;
	}
	
	public Articolo(int codiceArticolo, String descrizioneArticolo, double prezzo, int numeroPezziDisponibiliMagazzino) {
		this.codiceArticolo = codiceArticolo;
		this.descrizioneArticolo = descrizioneArticolo;
		this.prezzo = prezzo;
		this.numeroPezziDisponibiliMagazzino = numeroPezziDisponibiliMagazzino;
	}
}
