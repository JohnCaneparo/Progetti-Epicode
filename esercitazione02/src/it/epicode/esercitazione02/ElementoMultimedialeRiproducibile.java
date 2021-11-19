package it.epicode.esercitazione02;

public class ElementoMultimedialeRiproducibile extends ElementoMultimediale {
	protected int durata;
	protected int volume;

	public ElementoMultimedialeRiproducibile(String titolo, int durata, int volume) {
		super(titolo);
		this.durata = durata;
		this.volume = volume;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	public void alzaVolume() {
		volume++;
	}
	
	public void abbassaVolume() {
		volume--;
	}
		
	public void play() {
		String esclamativo = "";
		for(int i = 0; i < volume; i++) {
			esclamativo += "!";
		}
		for(int i = 0; i < durata; i++) {
			System.out.println(titolo + esclamativo + "\n");
		}
		
	}

}
