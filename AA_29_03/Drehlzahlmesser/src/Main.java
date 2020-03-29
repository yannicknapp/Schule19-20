
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subscribers display=new Subscribers("Display");
		Subscribers sound=new Subscribers("Sound");
		Observable ob=new Observable();
		ob.subscribe(display);
		ob.subscribe(sound);
		ob.setMaxSpeed(100);
		ob.setCurrentSpeed(110);
		ob.setCurrentSpeed(111);

	}

}
