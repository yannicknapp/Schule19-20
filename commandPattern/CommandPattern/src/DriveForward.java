
public class DriveForward implements Command 
{
	Auto car;
	
	public DriveForward(Auto car)
	{
		this.car=car;
	}
	public void execute()
	{
		car.forward();
	}

}
