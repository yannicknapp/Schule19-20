
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
	@Override
	public void undo() {
		// TODO Auto-generated method stub
		Command state = (Command) car.getState();
		state.execute();
	}

}
