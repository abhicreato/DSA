public class TransformToSumTree {
    public void toSumTree(Node root){
        //add code here.
       solve(root);
        
   }
   
   public int solve(Node node){
       
       if(node == null) return 0;
       
       int left = solve(node.left);
       int right = solve(node.right);
       
       int sum = node.data + left + right;
       
       node.data = left + right;
       
       return sum;
       
   }
}

/* recursivly calculate left node sum and right node sum ans update root = left sum + right sum */
