import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;

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
public class clonegraph {
      //https://leetcode.com/problems/clone-graph/solutions/1792834/c-easy-explanation-dfs/
      //bfs:  https://leetcode.com/problems/clone-graph/solutions/1792858/python3-iterative-bfs-beats-98-explained/
      public Node cloneGraph(Node node) {
        var mp = new HashMap<Node,Node>();
        if(node ==null) return null;  
        dfs(node,mp);
       
        return mp.get(node);
 }
 void dfs(Node root,Map<Node,Node> mp){


        Node mo = new Node(root.val);
        mp.put(root, mo);
        for(var adj_node : root.neighbors ){
            if(!mp.containsKey(adj_node)){
                dfs(adj_node,mp);
                mo.neighbors.add(mp.get(adj_node));
            }
            else
                mo.neighbors.add(mp.get(adj_node)); 
                
        }
        
   }
}


