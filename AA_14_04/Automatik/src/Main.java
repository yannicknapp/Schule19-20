
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StandardMode st=new StandardMode();
		SportMode sp=new SportMode();
		Context golf=new Context(st, 100, false);
		golf.switchgear(45);
	}

}
