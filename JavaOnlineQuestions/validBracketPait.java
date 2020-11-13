 //Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 //Leetcode question link ==> https://leetcode.com/problems/valid-parentheses/
 
 //this is a great solution I found.
 
 public boolean isValid(String s) {
        //push brackets one by one
        //once we have a match (open & closed) we pop the stack
        //if the stack is not empty we return false
        Stack<Character> stack = new Stack();
        for(char ch: s.toCharArray()){
		//subtracting one or two from ch and comparing to top of stack because that is the difference between open and closed breackets in the ascii table					
            if(!stack.empty() && (stack.peek() == ch - 1 || stack.peek() == ch - 2)){
                stack.pop();
            }else{
            stack.push(ch); 
            }
        }
        return stack.empty();
    }
