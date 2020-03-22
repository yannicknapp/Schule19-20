
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
	@Override
	public void undo() {
		// TODO Auto-generated method stub
		Command state = (Command) car.getState();
		state.execute();
	}
	

}
