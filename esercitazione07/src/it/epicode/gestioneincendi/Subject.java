package it.epicode.gestioneincendi;

import java.util.ArrayList;
import java.util.List;


public abstract class Subject {
	List<Observer> observers = new ArrayList<Observer>();
	public abstract void notifyObservers();
	public abstract void addObserver(Observer o);
	public abstract void removeObserver(Observer o);
	public abstract void getObservers();
}
