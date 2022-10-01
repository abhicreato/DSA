import java.util.*;

public class BoundaryTraversalofbinarytree {
    
    ArrayList<Integer> ans = new ArrayList<>();
    ArrayList<Integer> right = new ArrayList<>();
    
	ArrayList <Integer> boundary(Node node)
	{
	    if(node == null) return ans;
	    
	    if(isLeaf(node) == false) ans.add(node.data);
	    
	    traversLeft(node.left);
	    
	    traversLeaf(node);
	    
	    traversRight(node.right);
	    
	    Collections.reverse(right);
	    ans.addAll(right);
	    
	    return ans;
	}
	
	void traversLeft(Node node){
	    
	    if(node == null){
	        return;
	    }
	    
	    if(isLeaf(node) == false) ans.add(node.data);
	    
	    if(node.left != null){
	         traversLeft(node.left);
	    }else{
	         traversLeft(node.right);
	    }
	    
	}
	
	void traversRight(Node node){
	    
	    if(node == null){
	        return;
	    }
	    
	    if(isLeaf(node) == false) right.add(node.data);
	    
	    if(node.right != null){
	       traversRight(node.right); 
	    }else{
	       traversRight(node.left);
	    }
	  
	}
	
	void traversLeaf(Node node){
	    if(node == null){
	        return;
	    }
	    
	    if(isLeaf(node)){
	        ans.add(node.data);
	    }
	    
	    traversLeaf(node.left);
	    traversLeaf(node.right);
	    
	}
	
	boolean isLeaf(Node node){
	    
	    if(node.left == null && node.right == null){
	        return true;
	    }
	    
	    return false;
	}
	
}

/* 
**************** Logic ****************
We break the problem in 3 parts:
1. Print the left boundary in a top-down manner.
2. Print all leaf nodes from left to right, which can again be sub-divided into two sub-parts:
…..2.1 Print all leaf nodes of left sub-tree from left to right.
…..2.2 Print all leaf nodes of a right subtree from left to right.
3. Print the right boundary in a bottom-up manner.
*/