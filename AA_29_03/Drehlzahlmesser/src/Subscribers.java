
public class Subscribers implements IObserver
{
	private String name;
	
	
	
	public Subscribers(String n)
	{
		name=n;
		
	}
	
	public void update(int value)
	{
		System.out.println(name);
	}
	
}
