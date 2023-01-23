/*
**************** Problem Description ****************
Given a string containing just the characters '(' and ')',
find the length of the longest valid (well-formed) parentheses substring.
  Example 1 : 
  Input: s = "(()"
  Output: 2
  Explanation: The longest valid parentheses substring is "()".
  Example 2 : 
  Input: s = ")()())"
  Output: 4
  Explanation: The longest valid parentheses substring is "()()".
*/
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int max = 0;
        
        for(int i=0;i<s.length();i++){

            char c = s.charAt(i);
            if(c ==')'){
                st.pop();
                if(st.empty()){
                    st.push(i);
                }else{
                    max = Math.max(max, i - st.peek());
                } 
            }else{
                st.push(i);
            }
        }
        
        return max;
        
    }
    
}


/*
**************** Logic ****************

*/
