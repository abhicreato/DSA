package Graph;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {
      
    Map<Node,Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
  
        if(node == null) return node;
        
        if(visited.containsKey(node)) return visited.get(node);
    
        Node clone = new Node(node.val);
        
        visited.put(node, clone);
        
        for(Node ad : node.neighbors){
            clone.neighbors.add(cloneGraph(ad));
        }
        
        return clone;
    }
}
