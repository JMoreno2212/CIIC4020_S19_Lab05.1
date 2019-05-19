package classes;

import interfaces.Stack;

public class SymmetricStringAnalyzer {
	private String s; 
	public SymmetricStringAnalyzer(String s) {
		this.s = s; 
	}

	/**
	 * Determines if the string s is symmetric
	 * @return true if it is; false, otherwise. 
	 */
	public boolean isValidContent() { 
		Stack<Character> stack = new SLLStack<>();
		for (int i=0; i < s.length(); i++) { 
			char c = s.charAt(i); 
			if (Character.isLetter(c))
				if (Character.isUpperCase(c)) stack.push(c); 
				else if (stack.isEmpty()) return false; 
				else {
					char t = stack.top(); 
					if (t == Character.toUpperCase(c))
						stack.pop();  
					else 
						return false; 
				}
			else 
				return false; 
		} 
		return stack.isEmpty(); 
	}

	public String toString() { 
		return s; 
	}

	public String parenthesizedExpression() throws StringIsNotSymmetricException 
	{
		if(!isValidContent()) throw new StringIsNotSymmetricException("String is not Symmetric");
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == Character.toUpperCase(s.charAt(i))) {
				result.append("<");
				result.append(s.charAt(i));
				result.append(" ");
			}
			else {
				result.append(s.charAt(i));
				result.append("> ");
			}
		}

		return result.toString();
	}

}
