
public class DriveLeft implements Command{
	
	
	Auto car;
	
	public DriveLeft(Auto car)
	{
		this.car=car;
	}
	public void execute()
	{
		car.left();
	}

}
