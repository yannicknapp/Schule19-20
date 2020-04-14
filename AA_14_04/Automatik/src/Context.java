
public class Context 
{
	private Strategy strategy;
	private double oldspeed=0;
	private int kW;
	private boolean turbo;
	public Context(Strategy strategy,int kW,boolean turbo)
	{
		this.strategy=strategy;
		this.kW=kW;
		this.turbo=turbo;
	}
	
	public void switchgear(int speed)
	{
		double s=speed-(kW/50);
		this.strategy.gearshift(s,turbo,oldspeed);
		oldspeed=speed;
	}

	
	
}
