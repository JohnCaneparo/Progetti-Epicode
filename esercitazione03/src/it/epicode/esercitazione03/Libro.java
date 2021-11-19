package it.epicode.esercitazione03;

public class Libro extends Catalogo{
	private String autore;
	private String genere;
	
	public Libro(String codiceISBN, String titolo, String annoPubblicazione, int numPagine, String autore,
			String genere) {
		super(codiceISBN, titolo, annoPubblicazione, numPagine);
		this.autore = autore;
		this.genere = genere;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	@Override
	public String toString() {
		return "Libro [autore=" + autore + ", genere=" + genere + ", codiceISBN=" + codiceISBN + ", titolo=" + titolo
				+ ", annoPubblicazione=" + annoPubblicazione + ", numPagine=" + numPagine + "]";
	}
	
	

}
