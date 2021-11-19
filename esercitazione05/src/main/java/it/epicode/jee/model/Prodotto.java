package it.epicode.jee.model;

public class Prodotto {
	private int codiceProdotto;
	private String nome;
	private String descrizione;
	private String marca;
	private int fornitore;
	private double prezzo;

	public Prodotto(int codiceProdotto, String nome, String descrizione, String marca, int fornitore, double prezzo) {
		super();
		this.codiceProdotto = codiceProdotto;
		this.nome = nome;
		this.descrizione = descrizione;
		this.marca = marca;
		this.fornitore = fornitore;
		this.prezzo = prezzo;
	}

	public int getCodiceProdotto() {
		return codiceProdotto;
	}

	public void setCodiceProdotto(int codiceProdotto) {
		this.codiceProdotto = codiceProdotto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getFornitore() {
		return fornitore;
	}

	public void setFornitore(int fornitore) {
		this.fornitore = fornitore;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {
		return "Prodotto [codiceProdotto=" + codiceProdotto + ", nome=" + nome + ", descrizione=" + descrizione
				+ ", marca=" + marca + ", fornitore=" + fornitore + ", prezzo=" + prezzo + "]";
	}

}
