import java.util.ArrayList;

public class Runner {

	public static void main(String[] args) {
		ArrayList<Rule> ruleList = new ArrayList<Rule>();
		
//		Rule rule1 = new Rule('A', "AB");
//		Rule rule2 = new Rule('B', "A");
//		
//		ruleList.add(rule1);
//		ruleList.add(rule2);
//		
//		LSystem system1 = new LSystem("A", ruleList, 7);
//		String output = system1.generateString();
//		System.out.println(output.equals("ABAABABAABAABABAABABAABAABABAABAAB"));
//		
//		ruleList.clear();
//		
//		ruleList.add(new Rule('F', "F+F--F+F"));
//		
//		LSystem system2 = new LSystem("F", ruleList, 3);
//		String system2Output = system2.generateString();
//		System.out.println(system2Output.equals("F+F--F+F+F+F--F+F--F+F--F+F+F+F--F+F+F+F--F+F+F+F--F+F--F+F--F+F+F+F--F+F--F+F--F+F+F+F--F+F--F+F--F+F+F+F--F+F+F+F--F+F+F+F--F+F--F+F--F+F+F+F--F+F"));
//
//		LSystemInterpreter LSysInterpret = new LSystemInterpreter(system2Output, 100, 60);
		
		ruleList.clear();
//		ruleList.add(new Rule('F', " FF-F-F-F-FF"));
//		LSystem system3 = new LSystem("F - F - F - F", ruleList, 3);
//		
//		LSystemInterpreter LSysInterpret2 = new LSystemInterpreter(system3.generateString(), 100, 90);
		
//		ruleList.add(new Rule('F', "FF+[+F-F-F]-[-F+F+F]"));
//		LSystem system4 = new LSystem("F", ruleList, 4);
//		LSystemInterpreter interpreter4 = new LSystemInterpreter(system4.generateString(), 40, 22.5);
		
		ruleList.clear();
		
//		ruleList.add(new Rule('F', " F[+FF][-FF]F[-F][+F]F"));
//		LSystem system5 = new LSystem("F", ruleList, 4);
//		LSystemInterpreter interpreter5 = new LSystemInterpreter(system5.generateString(), 40, 35);

		ruleList.clear();
		ruleList.add(new Rule('F', ">F<"));
		ruleList.add(new Rule('a', "F[+x]Fb"));
		ruleList.add(new Rule('b', "F[-y]Fa"));
		ruleList.add(new Rule('x', "a"));
		ruleList.add(new Rule('y', "b"));
		LSystem system6 = new LSystem("a", ruleList, 10);
		String outputStr = system6.generateString();
		LSystemInterpreter interpreter6 = new LSystemInterpreter(outputStr, 30, 45, 0, 0, 1.36);
		
		
		
		
	}

}
