import java.util.Stack;

public class LSystemInterpreter {

	private String input; //input string to be interpreted
	private double distance; //distance for turtle to move forward
	private double angle; //angle for turtle to turn
	private double lineWidth; //width of turtle's pen
	private double lineLengthScaleFactor; //scale factor for distance
	private double lineWidthInc; //width increment for turtle's pen width
	private Stack<TurtleState> turtleLocation; //stack for turtle's state
	
	
	public LSystemInterpreter(String input, double distance, double angle) {
		this.input = input;
		this.distance = distance;
		this.angle = angle;
		turtleLocation = new Stack<TurtleState>();
		interpret();
		
	}
	
	public LSystemInterpreter(String input, double distance, double angle, 
								double lineWidthInc, double lineWidth, double lineLengthScaleFactor) {
		this.input = input;
		this.distance = distance;
		this.angle = angle;
		this.lineWidth = lineWidth;
		this.lineLengthScaleFactor = lineLengthScaleFactor;
		this.lineWidthInc = lineWidthInc;
		turtleLocation = new Stack<TurtleState>();
		
		interpret();
		
	}
	
	/*
	 * Interprets input and draws using turtle
	 * */
	private void interpret() {
		Turtle t = new Turtle();
		t.speed(0);
		for(int i = 0; i < input.length(); i++) {
			
			//cases for different characters in input
			switch(input.charAt(i)) {
				case '|': //turns turtle around
					t.left(180);
					break;
				case '#': //increments pen width by lineWidthInc
					t.width(t.getPenWidth()+lineWidthInc);
					break;
				case '!': //decrements pen width by lineWidthInc
					t.width(t.getPenWidth()-lineWidthInc);
					break;
				case '@': //draws dot with radius of penWidth
					t.dot(t.getPenColor(), t.getPenWidth() * 2);
					break;
				case '>': //multiplies distance by lineLengthScaleFactor
					distance*=lineLengthScaleFactor;
					break;
				case '<': //divides distance by lineLengthScaleFactor
					distance/=lineLengthScaleFactor;
					break;
				case '[': //saves turtle's position and angle
					turtleLocation.push(new TurtleState(t.getX(), t.getY(), t.getDirection()));
					break;
				case ']': //reverts turtle's position and angle to most recent save
					TurtleState location = turtleLocation.pop();
					t.up();
					t.setPosition(location.getX(), location.getY(), location.getAngle());
					t.down();
					break;
				case 'F': //moves turtle forward by distance
					t.forward(distance);
					break;
				case '-': //turns turtle right by angle
					t.right(angle);
					break;
				case '+': //turns turtle left by angle
					t.left(angle);
					break;
				default:
					break;
				
			}
			
		}
	}
}
