package strikeforce.observer;

import java.util.ArrayList;

public class Subject {
	
	private ArrayList<Observer> observers;
	
	public Subject() {
		observers = new ArrayList<>();
	}
	
	public void notifyObservers(SubjectEvent event) {
		for(Observer observer : observers) {
			observer.notifyEvent(event);
		}
	}
	
	public void addObserver(Observer observer) {
		observers.add(observer);
	}
}
