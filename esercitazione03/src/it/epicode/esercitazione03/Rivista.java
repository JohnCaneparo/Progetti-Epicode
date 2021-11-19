package it.epicode.esercitazione03;

public class Rivista extends Catalogo {
	private Periodicita periodicita;

	public Rivista(String codiceISBN, String titolo, String annoPubblicazione, int numPagine, Periodicita periodicita) {
		super(codiceISBN, titolo, annoPubblicazione, numPagine);
		this.periodicita = periodicita;
	}

	public Periodicita getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(Periodicita periodicita) {
		this.periodicita = periodicita;
	}

	@Override
	public String toString() {
		return "Rivista [periodicita=" + periodicita + ", codiceISBN=" + codiceISBN + ", titolo=" + titolo
				+ ", annoPubblicazione=" + annoPubblicazione + ", numPagine=" + numPagine + "]";
	}

	
}
