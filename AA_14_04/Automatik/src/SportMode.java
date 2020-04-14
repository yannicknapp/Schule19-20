
public class SportMode implements Strategy
{
	private int extra=0;
	private int gear;
	@Override
	public void gearshift(double speed, boolean turbo,double oldspeed) {
		// TODO Auto-generated method stub
		if(oldspeed<speed)
		{
			if(turbo)extra=5;
			if(speed>100+extra)gear=5;
			if(speed>80+extra)if(gear<4)gear=4;
			if(speed>50+extra)if(gear<3)gear=3;
			if(speed>30+extra)if(gear<2)gear=2;
			if(speed>0+extra)if(gear<1)gear=1;	
		}else
		{
			if(speed==0)gear=0;	
			if(speed<30)if(gear>1)gear=1;
			if(speed>50)if(gear>2)gear=2;
			if(speed>70)if(gear>3)gear=3;
			if(speed>90)if(gear>4)gear=4;
		}
		
		System.out.println(gear);
		
	}

}
