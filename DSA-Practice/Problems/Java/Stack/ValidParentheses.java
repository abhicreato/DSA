/*
**************** Problem Description ****************
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
  Example : 
  Input: s = "()"
  Output: true
  Input: s = "()[]{}"
  Output: true
  Input: s = "([)]"
  Output: false
*/

public class ValidParentheses {
    
    public boolean isValid(String st) {
        
        Stack<Character> s = new Stack<>();
        
        for(int i =0;i<st.length();i++){
            char c = st.charAt(i);
            
            if(!s.empty()){
                if(c == ')' && s.peek()=='('){
                    s.pop();
                }else if(c =='}' && s.peek() == '{'){
                    s.pop();
                }else if(c == ']' && s.peek() == '['){
                    s.pop();
                }else{
                    s.push(c);
                }
            }else{
                s.push(c);
            } 
        }
        
        return s.empty();
        
    }

}

/*
**************** Logic ****************
Push opening brackets in stack. If closing bracket and top is opening bracket of same type,
them pop from stack. If stack is empty in the end, then it is valid string.
*/