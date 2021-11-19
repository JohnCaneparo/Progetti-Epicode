package it.epicode.esercitazione02;

public class Video extends ElementoMultimedialeRiproducibile implements Luminosita {

	protected int luminosita;

	public Video(String titolo, int durata, int volume, int luminosita) {
		super(titolo, durata, volume);
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
	
	public void play() {
		String asterisco = "";
		String esclamativo = "";
		for(int i = 0; i < volume; i++) {
			esclamativo += "!";
		}
		for(int i = 0; i < luminosita; i++) {
			asterisco += "*";
		}
		for(int i = 0; i < durata; i++) {
		System.out.println(titolo + esclamativo + asterisco + "\n");
		}
	}
}
