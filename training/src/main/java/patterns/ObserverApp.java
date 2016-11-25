package patterns;

import java.util.ArrayList;
import java.util.List;

public class ObserverApp {

	public static void main(String[] args) {
		MeteoStation meteo = new MeteoStation();
		
		//here we can add all observer which we need
		meteo.addObserver(new ConsoleObsever());
		
		//here is setting new parameter in meteo station and notify all observers
		meteo.setMeasurements(20, 755);
		meteo.setMeasurements(18, 760);

	}
}

interface Observed{
	void addObserver(Observer o);
	void removeObserver(Observer o);
	void notifyObservers();
}

class MeteoStation implements Observed{

	private int temperature;
	private int pressure;
	
	List<Observer> observers = new ArrayList<>();
	
	public void setMeasurements(int t, int p){
		temperature = t;
		pressure = p;
		notifyObservers();
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
	public void notifyObservers() {
		for(Observer observer : observers){
			observer.handleEvent(temperature, pressure);
		}		
	}
}

interface Observer{
	void handleEvent(int temperature, int pressure);
}

class ConsoleObsever implements Observer{

	@Override
	public void handleEvent(int temperature, int pressure) {
		System.out.println("The weather is changed. Temperature = " + temperature + ", pressure = " + pressure);
		
	}
	
}