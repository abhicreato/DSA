/*
**************** Problem Description ****************
A celebrity is a person who is known to all but does not know anyone at a party.
If you go to a party of N people, find if there is a celebrity in the party or not.
A square NxN matrix M[][] is used to represent people at the party such that if an element of row i and column j  is set to 1 it means ith person knows jth person.
Here M[i][i] will always be 0.
Note: Follow 0 based indexing.
  Example : 
  Input:
  N = 3
  M[][] = {{0 1 0},
          {0 0 0}, 
          {0 1 0}}
  Output: 1
  Input:
  N = 2
  M[][] = {{0 1},
          {1 0}}
  Output: -1
*/

public class CelebrityProblem {
    
 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	// code here 
    	Stack<Integer> s = new Stack<>();
    	
    	for(int i=0;i<n;i++){
    	    s.push(i);
    	}
    	
    	while(s.size() > 1){
    	    int f = s.pop();
    	    int se = s.pop();
    	    
    	    if(M[f][se] == 0) s.push(f);
    	    else if(M[se][f] == 0) s.push(se);
    	} 
    	
    	int potentialCelib = -1;
    	
    	boolean knowsNoOne = true;
    	boolean knownByEve = true;
    	
    	if(!s.empty()){
    	    potentialCelib = s.peek();
    
    	for(int i=0;i<n;i++){
    	    if(M[potentialCelib][i] == 1) {
    	        knowsNoOne = false;
    	        break;
    	    }
    	    if(i!=potentialCelib && M[i][potentialCelib] == 0){
    	        knownByEve = false;
    	    }
    	}
    	} 
    	
    	if(knowsNoOne && knownByEve) return potentialCelib;
    	else return -1;
        
    }


}

/*
**************** Logic ****************
Push all the indices in the stack. Keep comparing and eliminating from stack until only one candidate remains.
Check the row and column in the matrix for the candidate to find if it is a celebrity or not.
*/
