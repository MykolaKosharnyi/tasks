package patterns;

public class BuilderApp {

	public static void main(String[] args) {
//		Car car = new CarBuilder()
//				.buildMake("Mersedes")
//				.buildTransmission(Transmission.AUTO)
//				.buildMaxSpeed(240)
//				.build();
//		System.out.println(car);
		
		Director director = new Director();
		director.setBuilder(new SubaruBuilder());
		Car car = director.buildCar();
		System.out.println(car);
	}
}

enum Transmission {
	MANUAL, AUTO
}

class Car{
	private String model;
	private Transmission transmission;
	private int maxSpeed;
	
	public String getName() {
		return model;
	}
	public void setName(String model) {
		this.model = model;
	}
	public Transmission getTransmission() {
		return transmission;
	}
	public void setTransmission(Transmission transmission) {
		this.transmission = transmission;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	@Override
	public String toString() {
		return "Car [model=" + model + ", transmission=" + transmission + ", maxSpeed=" + maxSpeed + "]";
	}
}

//class CarBuilder{
//	private String m = "Default";
//	private Transmission t = Transmission.MANUAL;
//	private int s = 120;
//	
//	CarBuilder buildMake(String m){
//		this.m = m;
//		return this;
//	}
//	
//	CarBuilder buildTransmission(Transmission t){
//		this.t = t;
//		return this;
//	}
//	
//	CarBuilder buildMaxSpeed(int s){
//		this.s = s;
//		return this;
//	}
//	
//	Car build(){
//		Car car = new Car();
//		car.setName(m);
//		car.setTransmission(t);
//		car.setMaxSpeed(s);
//		return car;
//	}
//}

abstract class CarBuilder{
	Car car;
	void createCar(){car = new Car();}
	
	abstract void buildMake();
	abstract void buildTransmission();
	abstract void buildMaxSpeed();
	
	Car getCar(){
		return car;
	}
}

class FordMandeoBuilder extends CarBuilder {

	void buildMake() {
		car.setName("Ford Mandeo");
	}

	void buildTransmission() {
		car.setTransmission(Transmission.AUTO);
	}

	void buildMaxSpeed() {
		car.setMaxSpeed(280);
	}
}

class SubaruBuilder extends CarBuilder {

	void buildMake() {
		car.setName("Subaru");
	}

	void buildTransmission() {
		car.setTransmission(Transmission.MANUAL);
	}

	void buildMaxSpeed() {
		car.setMaxSpeed(320);
	}
}

class Director {
	CarBuilder builder;

	public void setBuilder(CarBuilder builder) {
		this.builder = builder;
	}
	
	Car buildCar(){
		builder.createCar();
		builder.buildMake();
		builder.buildTransmission();
		builder.buildMaxSpeed();
		return builder.getCar();
	}
}