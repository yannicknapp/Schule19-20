
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
	@Override
	public void undo() {
		// TODO Auto-generated method stub
		Command state = (Command) car.getState();
		state.execute();
	}
}
