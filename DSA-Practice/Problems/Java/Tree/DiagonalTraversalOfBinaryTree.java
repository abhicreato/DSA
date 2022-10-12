import java.util.*;

public class DiagonalTraversalOfBinaryTree {
    ArrayList<Integer> op = new ArrayList<>();
    LinkedList<Node> q = new LinkedList<>();
    
     public ArrayList<Integer> diagonal(Node root)
      {
           //add your code here.
           q.add(root);
           
           while(!q.isEmpty()){
            Node curr = q.remove();
            traversRight(curr);
           }
           
           return op;
      }
      
      public void traversRight(Node root){
          
          if(root == null ) return;
          
          op.add(root.data);
          if(root.left != null) q.add(root.left);
          traversRight(root.right);
          
      }
}
