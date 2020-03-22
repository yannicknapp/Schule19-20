
public class DriveBack implements Command{
Auto car;
	
	public  DriveBack(Auto car)
	{
		this.car=car;
	}
	public void execute()
	{
		car.backwards();
	}

}
