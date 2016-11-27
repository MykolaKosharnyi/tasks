package patterns;

public class VisitorApp {
	public static void main(String[] args){
//		Element body = new BodyElement();
//		Element engine = new EngineElement();
//		Visitor hooligan = new HooliganVisitor();
//		
//		body.accept(hooligan);
//		engine.accept(hooligan);
		
		Element car = new CarElement();
		car.accept(new HooliganVisitor());
		
		System.out.println();
		
		car.accept(new MechanicVisitor());
		
	}
}

interface Visitor{
	void visid(EngineElement engine);
	void visid(BodyElement body);	
	void visid(CarElement car);
	void visid(WheelElement wheel);
}

interface Element{
	void accept(Visitor visitor);
}

class BodyElement implements Element{
	public void accept(Visitor visitor){
		visitor.visid(this);
	}
}

class EngineElement implements Element{
	public void accept(Visitor visitor){
		visitor.visid(this);
	}
}

class WheelElement implements Element{
	private String name;

	public WheelElement(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void accept(Visitor visitor){
		visitor.visid(this);
	}
}

class CarElement implements Element{
	Element[] elements;
	
	public CarElement(){
		elements = new Element[]{
				new WheelElement("front left"),new WheelElement("front right"),
				new WheelElement("back left"),new WheelElement("back right"),
				new BodyElement(), new EngineElement()
		};
	}
	
	public void accept(Visitor visitor){
		for(Element element : elements){
			element.accept(visitor);
		}
		visitor.visid(this);
	}
}

class HooliganVisitor implements Visitor{

	@Override
	public void visid(EngineElement engine) {
		System.out.println("Start engine");		
	}

	@Override
	public void visid(BodyElement body) {
		System.out.println("Knock on body");	
	}

	@Override
	public void visid(CarElement car) {
		System.out.println("Smoke inside the car");
	}

	@Override
	public void visid(WheelElement wheel) {
		System.out.println("Kicked " + wheel.getName() + " wheel");
	}
}

class MechanicVisitor implements Visitor{

	@Override
	public void visid(EngineElement engine) {
		System.out.println("Check engine");
	}

	@Override
	public void visid(BodyElement body) {
		System.out.println("Polirazed cuzov");
	}

	@Override
	public void visid(CarElement car) {
		System.out.println("Check outer look of the car");
	}

	@Override
	public void visid(WheelElement wheel) {
		System.out.println("Pumped up " + wheel.getName() + " wheel");
	}
}