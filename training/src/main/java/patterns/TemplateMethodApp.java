package patterns;

public class TemplateMethodApp {
	public static void main(String[] args) {
		C a = new ATemplate();
		a.templateMethod();
		
		System.out.println();
		
		C b = new BTemplate();
		b.templateMethod();
	}
}

abstract class C{
	void templateMethod(){
		System.out.print("1");
		differ();
		System.out.print("3");
	}
	abstract void differ();
}

class ATemplate extends C{
	void differ(){
		System.out.print("2");
	}
}

class BTemplate extends C{
	void differ(){
		System.out.print("4");
	}
}