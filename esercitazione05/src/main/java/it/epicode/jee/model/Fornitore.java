package it.epicode.jee.model;

public class Fornitore {
	private int codiceFornitore;
	private String nome;
	private String indirizzo;
	private String citta;
	
	public Fornitore() {
		
	}

	public Fornitore(int codiceFornitore, String nome, String indirizzo, String citta) {
		super();
		this.codiceFornitore = codiceFornitore;
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.citta = citta;
	}

	public int getCodiceFornitore() {
		return codiceFornitore;
	}

	public Fornitore setCodiceFornitore(int codiceFornitore) {
		setCodiceFornitore(codiceFornitore);
		this.codiceFornitore = codiceFornitore;
		return this;
	}

	public String getNome() {
		return nome;
	}

	public Fornitore setNome(String nome) {
		setNome(nome);
		this.nome = nome;
		return this;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public Fornitore setIndirizzo(String indirizzo) {
		setIndirizzo(indirizzo);
		this.indirizzo = indirizzo;
		return this;
	}

	public String getCitta() {
		return citta;
	}

	public Fornitore setCitta(String citta) {
		setCitta(citta);
		this.citta = citta;
		return this;
	}

	@Override
	public String toString() {
		return "Fornitore [codiceFornitore=" + codiceFornitore + ", nome=" + nome + ", indirizzo=" + indirizzo
				+ ", citta=" + citta + "]";
	}

}
