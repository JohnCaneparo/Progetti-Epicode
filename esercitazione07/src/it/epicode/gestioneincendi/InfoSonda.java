package it.epicode.gestioneincendi;

public class InfoSonda {

	private Long id;
	private double latitude;
	private double longitude;
	private int smokeLevel;
	
	public InfoSonda() {
	}
	
	public InfoSonda(Sonda sonda) {
		this.id = sonda.getId();
		this.latitude = sonda.getLatitude();
		this.longitude = sonda.getLongitude();
		this.smokeLevel = sonda.getSmokeLevel();
	}

	public Long getId() {
		return id;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public int getSmokeLevel() {
		return smokeLevel;
	}

	

}
