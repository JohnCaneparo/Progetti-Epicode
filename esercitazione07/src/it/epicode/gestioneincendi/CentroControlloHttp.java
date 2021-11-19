package it.epicode.gestioneincendi;

public class CentroControlloHttp implements CentroControlloInterface{

	private ComunicazioneHttp canaleComunicazione;
	private String baseUrlNotifica = "http://host/alarm";
	
	
	
	public CentroControlloHttp() {
		this.canaleComunicazione = new ComunicazioneHttp(baseUrlNotifica);
	}



	@Override
	public void rilevaIncendio(InfoSonda i) {
		canaleComunicazione.sendGet(i);
	}

}
