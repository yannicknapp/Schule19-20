
public class User {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Remote r=new Remote();
		Auto car=new Auto();
		DriveForward df=new DriveForward(car);
		r.setCommand(new DriveForward(car));
		r.action("execute");
		r.setCommand(new DriveLeft(car));
		r.action("undo");
		
		

	}

}
