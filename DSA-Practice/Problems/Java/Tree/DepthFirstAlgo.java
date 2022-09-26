import java.util.*;;

//A Binary Tree node
class Node {
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
}

public class DepthFirstAlgo {

    ArrayList<Integer> op = new ArrayList();

    void solvePreOrder(Node curr){
        
        if(curr == null){
            return;
        }
        
        op.add(curr.data);
        solvePreOrder(curr.left);
        solvePreOrder(curr.right);
        
    }

    void solveInorder(Node curr){
        
        if(curr == null){
            return;
        }
        
        solveInorder(curr.left);
        op.add(curr.data);
        solveInorder(curr.right);
  
    }

    void solvePostorder(Node curr){
        
        if(curr == null){
            return;
        }
        
        solvePostorder(curr.left);
        solvePostorder(curr.right);
        
        op.add(curr.data);
        
    }
    
}
