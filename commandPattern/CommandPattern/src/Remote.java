
public class Remote 
{
	Command command;
	
	public void setCommand(Command command)
	{
		this.command=command;
	}
	
	public void action(String s)
	{
		switch(s)
		{
		
		
		case "execute":
			command.execute();
			break;
			
		case "undo":
			command.undo();
			break;
		}
	}
}
