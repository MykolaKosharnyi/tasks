package patterns;

import java.util.ArrayList;
import java.util.List;

public class CompositeApp {

	public static void main(String[] args) {
		Shape square1 = new SquareComposite();
		Shape square2 = new SquareComposite();
		Shape triangle1 = new TriangleComposite();
		
		Shape square3 = new SquareComposite();
		Shape circle1 = new CircleComposite();
		Shape circle2 = new CircleComposite();
		Shape circle3 = new CircleComposite();
		
		Composite composite = new Composite();
		Composite composite1 = new Composite();
		Composite composite2 = new Composite();
		
		composite1.addComponent(square1);
		composite1.addComponent(square2);
		composite1.addComponent(triangle1);
		
		composite2.addComponent(square3);
		composite2.addComponent(circle1);
		composite2.addComponent(circle2);
		composite2.addComponent(circle3);
		
		composite.addComponent(composite1);
		composite.addComponent(composite2);
		composite.addComponent(new TriangleComposite());
		
		composite.draw();
	}
}

interface Shape{
	void draw();
}

class SquareComposite implements Shape{
	public void draw(){
		System.out.println("Hi, I'm Square.");
	}
}

class TriangleComposite implements Shape{
	public void draw(){
		System.out.println("Hi, I'm Triangle.");
	}
}

class CircleComposite implements Shape{
	public void draw(){
		System.out.println("Hi, I'm Circle.");
	}
}

class Composite implements Shape{
	private List<Shape> components = new ArrayList<>();
	
	public void addComponent(Shape component){
		components.add(component);
	}
	
	public void removeComponent(Shape component){
		components.remove(component);
	}
	
	public void draw(){
		for(Shape component: components){
			component.draw();
		}
	}
}

