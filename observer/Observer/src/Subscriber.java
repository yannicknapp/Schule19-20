
public class Subscriber implements IObserver 
{
	private String name;
	private int value;
	
	
	public Subscriber(String n, int v)
	{
		name=n;value=v;
		
	}
	
	public void update(int value)
	{
		System.out.println(name+" hat "+value+" erhalten ");
	}
	
	public int getValue()
	{
		return value;
	}

}
