import java.util.ArrayList;

public class Auto {
	private static int zaehler;
	private static ArrayList<Command> state=new ArrayList<>();
	public void forward()
	{
		System.out.println("Auto fährt geradaus");
		state.add(new DriveForward(this));
		zaehler+=1;
	}
	public void backwards()
	{
		System.out.println("Auto fährt nach hinten");
		state.add(new DriveBack(this));
		zaehler+=1;
	}
	public void left()
	{
		System.out.println("Auto fährt nach links");
		state.add(new DriveLeft(this));
		zaehler+=1;
	}
	public void right()
	{
		System.out.println("Auto fährt nach rechts");
		state.add(new DriveRight(this));
		zaehler+=1;
	}
	
	public int getZaehler()
	{
		return zaehler;
	}
	public static Command getState() {
		return state.get(zaehler-1);
	}
	public static void setState(ArrayList<Command> state) {
		Auto.state = state;
	}
	

}
