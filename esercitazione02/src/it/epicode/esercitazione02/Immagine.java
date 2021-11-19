package it.epicode.esercitazione02;

public class Immagine extends ElementoMultimediale implements Luminosita {

	protected int luminosita;

	public Immagine(String titolo, int luminosita) {
		super(titolo);
		this.luminosita = luminosita;
	}

	public int getLuminosita() {
		return luminosita;
	}

	public void setLuminosita(int luminosita) {
		this.luminosita = luminosita;
	}

	public void aumentaLuminosita() {
		luminosita++;
	}

	public void diminuisciLuminosita() {
		luminosita--;
	}

	public void show() {
		String asterisco = "";
		for(int i = 0; i < luminosita; i++) {
			asterisco += "*";
		}
		System.out.println(titolo + asterisco);
	}
	
}
