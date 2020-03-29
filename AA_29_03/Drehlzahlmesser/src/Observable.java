import java.util.ArrayList;

public class Observable 
{
	private int value;
	private ArrayList<IObserver> observers;
	private int maxspeed;
	
	public Observable()
	{
		observers= new ArrayList<IObserver>();
	}
	
	
	public void setCurrentSpeed(int value)
	{
		this.value=value;
		notifysubscribers(value);
	}
	public void setMaxSpeed(int maxspeed)
	{
		this.maxspeed=maxspeed;
		
	}


	private void notifysubscribers(int value) 
	{
		if(maxspeed<value)
		{
			for (int i=0;i<observers.size();i++)
			{
				observers.get(i).update(value);
			}
		}
		
	}
	
	
	public void subscribe(IObserver a)
	{
		observers.add(a);
	}
	

}
