import java.util.Stack;

public class CelibrityProblem {


    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	// code here 
    	Stack<Integer> s = new Stack();
    	
    	for(int i=0;i<n;i++){
    	    s.push(i);
    	}
    	
    	while(s.size() > 1){
    	    int firstPerson = s.pop();
    	    int secondPerson = s.pop();
    	    
    	    if(M[firstPerson][secondPerson] == 1) s.push(secondPerson);
    	    else s.push(firstPerson);
    	}
    	
        if(!s.isEmpty()){
            
            int potentialCelib = s.peek();
            
            for(int i=0;i<n;i++){
                
                if(M[potentialCelib][i] == 1){
                    return -1;
                }
                
                if(i!=potentialCelib && M[i][potentialCelib] == 0){
                    return -1;
                }
                
            }
            
            return potentialCelib;
            
        }
        
        return -1;
    }
    
}
