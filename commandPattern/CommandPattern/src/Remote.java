
public class Remote 
{
	Command command;
	
	public void setCommand(Command command)
	{
		this.command=command;
	}
	
	public void action()
	{
		command.execute();
	}
}
