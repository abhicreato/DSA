/*

**************** Problem Description ****************
Given an array, find the nearest smaller element G[i] for every element A[i] in the array such that
the element has an index smaller than i.

  G[i] for an element A[i] = an element A[j] such that 
  j is maximum possible AND 
  j < i AND
  A[j] < A[i]

  Example : 

  Input: 
  A = [4, 5, 2, 10, 8]
  
  Output:
  G = [-1, 4, -1, 2, 2]

  Explanation:
  index 1: No element less than 4 in left of 4, G[1] = -1
  index 2: A[1] is only element less than A[2], G[2] = A[1]
  index 3: No element less than 2 in left of 2, G[3] = -1
  index 4: A[3] is nearest element which is less than A[4], G[4] = A[3]
  index 4: A[3] is nearest element which is less than A[5], G[5] = A[3]

*/

public class NearestSmallerElement {

    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        
        ArrayList<Integer> op = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        
        for(int i=0;i<A.size();i++){
            
            while(!s.empty() && s.peek()>=A.get(i)){
                s.pop();
            }
            if(s.empty()){
                op.add(-1);
            }else{
                op.add(s.peek());
            }
            s.push(A.get(i));
            
        }
        
        return op;
    }

    
}

/*
**************** Logic ****************
Iterate over array and Push the elements on the left side into stack.
Pop elements until top is greater than current element or the stack is empty.
If stack becomes empty then no smaller element exists on left side.

*/
