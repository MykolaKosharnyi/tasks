package patterns;

public class StateApp {

	public static void main(String[] args) {
		
		HumanState human = new HumanState();
		human.setState(new Work());
		for(int i=0; i < 10; i++){
			human.doSomething();			
		}
		
		System.out.println("-------------------");
		Station dfm = new RadioDFM();
		Radio radio = new Radio();
		radio.setStation(dfm);
		
		for(int i=0; i < 10; i++){
			radio.play();
			radio.nextStation();			
		}
	}
}

//Context
class HumanState{
	private Activity state;
	public void setState(Activity state){
		this.state=state;
	}
	
	public void doSomething(){
		state.doSomething(this);
	}
}

//State
interface Activity{
	void doSomething(HumanState context);
}

class Work implements Activity{
	@Override
	public void doSomething(HumanState context) {
		System.out.println("Work!!!");
		context.setState(new WeekEnd());
	}
}

class WeekEnd implements Activity{
	private int count = 0;
	
	@Override
	public void doSomething(HumanState context) {
		if(count<3){
			System.out.println("Make weekend.. Zzz");
			count++;
		} else {
			context.setState(new Work());
		}
		
	}
	
}



//State
interface Station{
	void play();
}

class Radio7 implements Station {
	public void play(){
		System.out.println("Radio7...");
	}
}

class RadioDFM implements Station {
	public void play(){
		System.out.println("RadioDFM...");
	}
}

class VestiFM implements Station {
	public void play(){
		System.out.println("VestiFM...");
	}
}

class Radio{
	Station station;
	
	void setStation(Station station){
		this.station=station;
	}
	
	void nextStation(){
		if(station instanceof Radio7){
			setStation(new RadioDFM());
			
		} else if(station instanceof RadioDFM){
			setStation(new VestiFM());
			
		} else if(station instanceof VestiFM){
			setStation(new Radio7());
		}
	}
	
	void play(){
		station.play();
	}
	
}