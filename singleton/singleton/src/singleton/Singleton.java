package singleton;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Singleton {

	private static Singleton instance;
	private PrintWriter writer;
	private Level lvl;
	
	enum Level
	{
		DEBUG,
		INFO,
		WARN,
		ERROR
	}
	
	private Singleton() throws IOException 
	{
		writer = new PrintWriter(new FileWriter("log.txt", true));
		lvl= Level.DEBUG;
	}
	
	public static Singleton getInstance() throws IOException
	{
		if (instance == null)
		{
			instance = new Singleton();
		}
		return instance;
	}
	
	public void log(String a, Level level) throws FileNotFoundException
	{
		if(lvl.ordinal()<=level.ordinal())
		{
		DateTimeFormatter d= DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		writer.println(d.format(LocalDateTime.now())+" " + level.name() + ": " +a);
		writer.flush();
		}
		
	}
	
	public void setLogLvl(Level level)
	{
		lvl=level;
	}

}
