package Managers;

import java.util.ArrayList;

public class Observable {
	private ArrayList<Observer> observers;
	
	public Observable() {
		observers = new ArrayList<Observer>();
	}
	
	public void addObserver(Observer pObservable) {
		observers.add(pObservable);
	}
	
	public void notifyObservers(Object pValue) {
		for(Observer observer : observers) {
			observer.update(this, pValue);
		}
	}
}
