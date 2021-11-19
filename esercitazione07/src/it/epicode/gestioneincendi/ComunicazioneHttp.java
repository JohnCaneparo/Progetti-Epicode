package it.epicode.gestioneincendi;

public class ComunicazioneHttp extends CanaleComunicazione {
	private String baseUrlNotifica;

	public ComunicazioneHttp(String baseUrlNotifica) {
		this.baseUrlNotifica = baseUrlNotifica;
	}

	@Override
	public void sendGet(InfoSonda i) {
		System.out.println("Chiamata: " + baseUrlNotifica + "?=idsonda=" + i.getId() + "&lat=" + i.getLatitude() + "&lon="
				+ i.getLongitude() + "&smokelevel=" + i.getSmokeLevel());
	}

}
