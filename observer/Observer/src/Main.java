
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subscriber anton=new Subscriber("anton",10);
		Subscriber peter=new Subscriber("peter",12);
		Observable ob=new Observable();
		ob.subscribe(anton);
		ob.subscribe(peter);
		
		ob.setValue(12);
		
		
	}

}
