class Node {
    int data;
    Node left, right,next;
    
    public Node(int data){
        this.data = data;
    }
}

public class PopulateInorderSuccessorAllNodes {
    Node prev = null;
    
    public void populateNext(Node root){
        //code here
        if(root == null) return;
        
        populateNext(root.right);
        
        root.next = prev;
        prev = root;
       
        populateNext(root.left);
        
    }
}
