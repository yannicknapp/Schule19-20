
public class DriveRight implements Command
{
	Auto car;
	
	public DriveRight(Auto car)
	{
		this.car=car;
	}
	public void execute()
	{
		car.right();
	}
}
