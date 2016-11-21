package patterns;

public class DelegateApp {
	public static void main(String... args){
		Painter painter = new Painter();
		
		painter.setGraphics(new Square());
		painter.draw();
		
		painter.setGraphics(new Circle());
		painter.draw();
		
	}
}

class A {
	public void f(){
		System.out.println("f()");
		/*
		 * 
		 * 
		 * Here a lot of code
		 * and we don't want to repeat these stuff 
		 * in method of class B
		 * so we using delegate pattern in class B.
		 * 
		 * 
		 * 
		 */
		
	}
}

class B {
	A a = new A();
	public void f(){
		a.f();
	}
}

interface Graphics{
	void draw();
}
class Triangle implements Graphics {
	public void draw(){
		System.out.println("Draw TRIANGLE");
	}
}
class Square implements Graphics {
	public void draw(){
		System.out.println("Draw SQUARE");
	}
}
class Circle implements Graphics {
	public void draw(){
		System.out.println("Draw CIRCLE");
	}
}

class Painter{
	Graphics graphics;
	
	void setGraphics(Graphics graphics){
		this.graphics = graphics;
	}
	
	void draw(){
		graphics.draw();
	}
}
