
public class StandardMode implements Strategy
{
	private int extra=0;
	private int gear;
	@Override
	public void gearshift(double speed, boolean turbo,double oldspeed) {
		// TODO Auto-generated method stub
		if(oldspeed<speed)
		{
			if(turbo)extra=5;
			if(speed>90+extra)gear=5;
			if(speed>60+extra)if(gear<4)gear=4;
			if(speed>40+extra)if(gear<3)gear=3;
			if(speed>20+extra)if(gear<2)gear=2;
			if(speed>0+extra)if(gear<1)gear=1;	
		}else
		{
			if(speed==0)gear=0;	
			if(speed<20)if(gear>1)gear=1;
			if(speed>40)if(gear>2)gear=2;
			if(speed>60)if(gear>3)gear=3;
			if(speed>80)if(gear>4)gear=4;
		}
		
		System.out.println(gear);
		
	}
	
}
