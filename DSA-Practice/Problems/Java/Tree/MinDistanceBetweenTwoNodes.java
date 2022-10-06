public class MinDistanceBetweenTwoNodes {
    
    int findDist(Node root, int a, int b) {
        // Your code here
        Node LCANode = LCA(root,a,b);
        
        return (distance(LCANode, a, 0) + distance(LCANode ,b , 0));
        
    }
    
    int distance(Node root,int a,int dist){
        if(root == null) return 0;
 
        if(root.data == a) return dist;
        
        int left = distance(root.left,a,dist + 1);
        int right = distance(root.right,a,dist + 1);
        
        return left + right;

    }
    
    public Node LCA (Node root, int a, int b){
        
        if(root == null || root.data == a || root.data == b) return root;
        
        Node left = LCA(root.left,a,b);
        Node right = LCA(root.right,a,b);
        
        if(left == null){
            return right;
        }else if(right == null){
            return left;
        }else{
            return root;
        }
        
    }
}

/*
**************** Logic ****************
Find the Lowest Common Ancestor of the two nodes.
The minimum distance between two nodes is the the sum of the distances between LCA and nodes.
*/
