/*
**************** Problem Description ****************
Design a data-structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), isFull()
and an additional operation getMin() which should return minimum element from the SpecialStack.
Your task is to complete all the functions, using stack data-Structure.
Expected Time Complexity: O(N) for getMin, O(1) for remaining all 4 functions.
Expected Auxiliary Space: O(1) for all the 5 functions.
  Example : 
  Input:
  Stack: 18 19 29 15 16
  Output: 15
  Explanation: The minimum element of the stack is 15.
*/

public class MinStackElement {

     int min = 0;
    
	public void push(int a,Stack<Integer> s)
	{
	    //add code here.
	    if(s.empty()) this.min = a;
	    
	    if(a < min){
	        s.push(2 * this.min - 1);
	        this.min = a;
	        
	    }else{
	        s.push(a);
	    }
	   
	}
	public int pop(Stack<Integer> s)
        {
            //add code here.
            if(s.peek() < min){
                min = 2 * this.min - s.peek();
            }
            
            return s.pop();
        
	}
	public int min(Stack<Integer> s)
        {
           //add code here.
           if(s.empty()) return -1;
           else return this.min;
	}
	public boolean isFull(Stack<Integer>s, int n)
        {
           //add code here.
           if(s.size() == n) return true;
           else return false;
	}
	public boolean isEmpty(Stack<Integer>s)
        {
           //add code here.
           return s.empty();
	}
    
}

/*
**************** Logic ****************
When pushing min element in stack encode it with the old min to preseve old min.
To identify if the the top is the min element or not we can push a number less than
min element instead of min element and store the actual min element in a variable.
When top is less than min then top is the encoded min element.
Before popping the min element restore the min to old min.
  Push() :
  new_min < old_min
  2*new_min - new_min < old_min
  2 * new_min - old_min < new_min
  Since 2 * new_min - old_min will always be less than new_min,
  we push 2 * new_min - old_min and store new_min in min variable. 
  Pop() :
  Restore old min before popping current min
  top = 2 * curr_min - old_min
  old_min = 2 * curr_min - top
*/
