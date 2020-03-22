
public class DriveLeft implements Command
{
	Auto car;
	public DriveLeft(Auto car)
	{
		this.car=car;
	}
	public void execute()
	{
		car.forward();
	}
	@Override
	public void undo() {
		// TODO Auto-generated method stub
		Command state = (Command) car.getState();
		state.execute();
	}
}
