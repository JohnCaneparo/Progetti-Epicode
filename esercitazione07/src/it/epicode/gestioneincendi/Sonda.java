package it.epicode.gestioneincendi;

import java.util.List;

public class Sonda extends Subject {
	private int SMOKE_TRESHOLD = 5;
	private Long id;
	private double latitude;
	private double longitude;
	private int smokeLevel;

	public Sonda() {
	}

	public Sonda(Long id, double latitude, double longitude) {
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public int getSMOKE_TRESHOLD() {
		return SMOKE_TRESHOLD;
	}

	public void setSMOKE_TRESHOLD(int sMOKE_TRESHOLD) {
		SMOKE_TRESHOLD = sMOKE_TRESHOLD;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public int getSmokeLevel() {
		return smokeLevel;
	}

	public void setSmokeLevel(int smokeLevel) {
		this.smokeLevel = smokeLevel;
		if (smokeLevel >= SMOKE_TRESHOLD) {
			notifyObservers();
		}
	}

	public void notifyObservers() {
		for(Observer obv : observers) {
			obv.update(this);
		}
		
	}

	@Override
	public void addObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	@Override
	public void getObservers() {
		for(Observer o : observers)
			System.out.println(o);
	}

	public List<Observer> getListaObservers() {
		return observers;
	}
}

