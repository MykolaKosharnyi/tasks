package lessons;

public class HumanApp {
	public static void main(String[] args) {

	}
}

interface State{
	void getState();
}

class Hunter implements State{
	public void getState() {
		System.out.println("Hunter");
	}	
}

class Fisher implements State{
	public void getState() {
		System.out.println("Fisher");
	}	
}

class Musher implements State{
	public void getState() {
		System.out.println("Musher");
	}	
}

class Human{
	State state;
	
	public void setState(State state){
		this.state = state;
	}
	
	void changeStateUsingPlace(String place){
		if("forest".equals(place)){
			setState(new Musher());
			
		} else if("water".equals(place)){
			setState(new Fisher());
			
		} else if("see zvera".equals(place)){
			setState(new Hunter());
		}
	}
	
	
}