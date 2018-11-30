import java.util.Stack;;

class ParenthesesBalance {
	
	static String complete (String p) {
		
		//Initialize two Stacks (one for each style of parentheses
		Stack<Character> leftPStack = new Stack<Character>();
		Stack<Character> rightPStack = new Stack<Character>();
		
		//Initialize two empty strings to concatenated with the input string later
		String leftPString = "";
		String rightPString = "";
		
		/*
			Iterate through the string from left to right, pushing to the left parenthesis stack
			when finding the correct character and popping from that stack when finding the opposite
		*/
		for(int i = 0; i < p.length(); i++) {
			if(p.charAt(i) == '(') {
				leftPStack.push(p.charAt(i));
			}
			
			else if(p.charAt(i) == ')') {
				
				if(!leftPStack.empty()) {
					leftPStack.pop();
				}
			}
		}
		
		//Repeating the same process as before but in reverse for the right parenthesis
		for(int i = p.length() - 1; i >= 0; i--) {
			if(p.charAt(i) == '(') {
				
				if(!rightPStack.empty()) {
					rightPStack.pop();
				}
			}
			
			else if(p.charAt(i) == ')') {
				rightPStack.push(p.charAt(i));
			}
		}
		
		//Building the right parenthesis string by counting the number of characters in the left parenthesis stack
		while(!leftPStack.empty()) {
			rightPString += ")";
			leftPStack.pop();
		}
		
		//Repeat for left parenthesis string
		while(!rightPStack.empty()) {
			leftPString += "(";
			rightPStack.pop();
		}
		
		//String concatenation
		return leftPString + p + rightPString;
	}
	
	public static void main(String[] args) {
		
		System.out.println(complete("()))()))))"));
	}
}