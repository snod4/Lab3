import java.util.ArrayList;
import java.util.HashMap;

//Generates L-System based on rules and an axiom
public class LSystem {

	private String axiom; //axiom of L-System
	private ArrayList<Rule> rules; //list of rules passed in to class
	HashMap<Character, Rule> ruleMap; //hash map created to store rules by their input values
	private int iterations; //number of iterations string generation
	
	public LSystem(String axiom, ArrayList<Rule> rules, int iterations) {
		this.axiom = axiom;
		this.rules = rules;
		this.iterations = iterations;
		
		//puts list of rules into hash map
		ruleMap = new HashMap<Character, Rule>();
		for(int i = 0; i < this.rules.size(); i++) {
			ruleMap.put(this.rules.get(i).getInput(), this.rules.get(i));
		}
		
	}
	
	/*
	 * allows rules to be added to an L-System
	 * rule, a rule Object
	 * */
	public void addRule(Rule rule) {
		ruleMap.put(rule.getInput(), rule);
	}
	
	/*
	 * returns generated string based on axiom and rules
	 * */
	public String generateString() {
		
		String tempAxiomString = new String(axiom);
		String outputString = "";	//string to build off of
		for(int i = 0; i < iterations; i++) {
			char stringChar; //char in tempAxiom
			for(int g = 0; g < tempAxiomString.length(); g++) {
				stringChar = tempAxiomString.charAt(g);
				if(ruleMap.containsKey(stringChar)) {
					//if stringChar is in hash map, then apply rule and append to outputString
					outputString += ruleMap.get(stringChar).getOutput();
				}
				else {
					//if stringChar not in hash map, just append stringChar to outputString
					outputString += stringChar;
				}
			}
			//makes tempAxiomString into outputString and resets outputString
			tempAxiomString = new String(outputString);
			outputString = "";
			
		}
		return tempAxiomString;
	}
}
