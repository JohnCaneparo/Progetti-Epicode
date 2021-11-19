package it.epicode.esercizio3;

public class Cliente {
	private int codiceCliente;
	private String nomeECognome;
	private String email;
	private String dataIscrizione;
	
	public int getCodiceCliente() {
		return codiceCliente;
	}
	public void setCodiceCliente(int codiceCliente) {
		this.codiceCliente = codiceCliente;
	}
	public String getNomeECognome() {
		return nomeECognome;
	}
	public void setNomeECognome(String nomeECognome) {
		this.nomeECognome = nomeECognome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDataIscrizione() {
		return dataIscrizione;
	}
	public void setDataIscrizione(String dataIscrizione) {
		this.dataIscrizione = dataIscrizione;
	}
	
	public Cliente(int codiceCliente, String nomeECognome, String email, String dataIscrizione) {
		this.codiceCliente = codiceCliente;
		this.nomeECognome = nomeECognome;
		this.email = email;
		this.dataIscrizione = dataIscrizione;
	}
	
}
