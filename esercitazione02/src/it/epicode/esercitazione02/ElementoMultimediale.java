package it.epicode.esercitazione02;

public abstract class ElementoMultimediale {
	protected String titolo;

	public ElementoMultimediale(String titolo) {
		this.titolo = titolo;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

}
