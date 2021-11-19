package it.epicode.esercitazione03;

public abstract class Catalogo {
	protected String codiceISBN;
	protected String titolo;
	protected String annoPubblicazione;
	protected int numPagine;

	public Catalogo() {
	}

	public Catalogo(String codiceISBN, String titolo, String annoPubblicazione, int numPagine) {
		super();
		this.codiceISBN = codiceISBN;
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numPagine = numPagine;
	}

	public String getCodiceISBN() {
		return codiceISBN;
	}

	public void setCodiceISBN(String codiceISBN) {
		this.codiceISBN = codiceISBN;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAnnoPubblicazione() {
		return annoPubblicazione;
	}

	public void setAnnoPubblicazione(String annoPubblicazione) {
		this.annoPubblicazione = annoPubblicazione;
	}

	public int getNumPagine() {
		return numPagine;
	}

	public void setNumPagine(int numPagine) {
		this.numPagine = numPagine;
	}

}
