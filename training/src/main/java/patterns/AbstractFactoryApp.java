package patterns;

public class AbstractFactoryApp {
	public static void main(String[] args) {
		DeviceFactory factory = getFactoryByCountyCode("RU");
		Mouse m = factory.getMouse();
		Keyboard k = factory.getKeyboard();
		Touchpad t = factory.getTouchpad();
		
		m.click();
		k.print();
		k.println();
		t.track(10, 35);
	}
	
	private static DeviceFactory getFactoryByCountyCode(String lang){
		switch(lang){
		case "RU":
			return new RuDeviceFactory();
		case "EN":
			return new EnDeviceFactory();
		default:
			throw new RuntimeException("Unsupported Country Code: " + lang);
		}
	}
}

interface Mouse{
	void click();
	void dbclick();
	void scroll(int direction);
}
interface Keyboard{
	void print();
	void println();
}
interface Touchpad{
	void track(int deltaX, int deltaY);
}

interface DeviceFactory{
	Mouse getMouse();
	Keyboard getKeyboard();
	Touchpad getTouchpad();
}

class RuMouse implements Mouse{
	public void click(){
		System.out.println("Щелчок мышью");
	}
	public void dbclick(){
		System.out.println("Двойной щелчок мышью");
	}
	public void scroll(int direction){
		if(direction>0)
			System.out.println("Скролиим верх");
		else if(direction<0)
			System.out.println("Скролиим вниз");
		else
			System.out.println("Не скроллим");
	}
}

class RuKeyboard implements Keyboard{
	public void print(){
		System.out.println("Печатаем строку");
	}
	public void println(){
		System.out.println("Печатаем строку с переводом строки");
	}
}

class RuTouchpad implements Touchpad{
	public void track(int deltaX, int deltaY){
		int s = (int) Math.sqrt(Math.pow(deltaX, 2)+Math.pow(deltaY, 2));
		System.out.println("Передвинулись на " + s + " пикселей");
	}
}

class EnMouse implements Mouse{
	public void click(){
		System.out.println("Click mouse");
	}
	public void dbclick(){
		System.out.println("Double click mouse");
	}
	public void scroll(int direction){
		if(direction>0)
			System.out.println("Scroll Up");
		else if(direction<0)
			System.out.println("Scroll Down");
		else
			System.out.println("Don't scroll");
	}
}

class EnKeyboard implements Keyboard{
	public void print(){
		System.out.println("Print");
	}
	public void println(){
		System.out.println("Print line");
	}
}

class EnTouchpad implements Touchpad{
	public void track(int deltaX, int deltaY){
		int s = (int) Math.sqrt(Math.pow(deltaX, 2)+Math.pow(deltaY, 2));
		System.out.println("Move on " + s + " pixels");
	}
}

class EnDeviceFactory implements DeviceFactory{

	@Override
	public Mouse getMouse() {
		return new EnMouse();
	}

	@Override
	public Keyboard getKeyboard() {
		return new EnKeyboard();
	}

	@Override
	public Touchpad getTouchpad() {
		return new EnTouchpad();
	}
}

class RuDeviceFactory implements DeviceFactory{

	@Override
	public Mouse getMouse() {
		return new RuMouse();
	}

	@Override
	public Keyboard getKeyboard() {
		return new RuKeyboard();
	}

	@Override
	public Touchpad getTouchpad() {
		return new RuTouchpad();
	}
}