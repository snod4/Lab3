//Stores turtles position
public class TurtleState {
	private double x; //x position of turtle
	private double y; //y position of turtle
	private double angle; //angle of turtle
	public TurtleState(double x, double y, double angle){
		this.x = x;
		this.y = y;
		this.angle = angle;
	}
	
	//returns x, a double
	public double getX() {
		return x;
	}

	//returns y, a double
	public double getY() {
		return y;
	}

	//returns angle, a double
	public double getAngle() {
		return angle;
	}
	
	
	
}
