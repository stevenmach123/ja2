
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
   TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class  help2 {
  static List TreeManifest(TreeNode tree){
        List<LinkedList<Object>> l = new  ArrayList<LinkedList<Object>>() ;
        
        if(tree == null)
            return l;

        LinkedList<TreeNode> l_temp = new LinkedList<>();
        l_temp.add(tree);
        
        while(!l_temp.isEmpty()){
            LinkedList<TreeNode> l_new = new LinkedList<>();
            LinkedList<Object> vals = new LinkedList<>(); 

            for(TreeNode node: l_temp){
                if(node!=null)
                    vals.add(node.val); 
                else   
                    vals.add(null); 
            }
            l.add(vals);


            for(TreeNode node :l_temp){
                if(node != null){
                    l_new.add(node.left);
                    l_new.add(node.right);
                }
                
            }
           
            l_temp = l_new;
            

        }
        LinkedList e = new LinkedList<>();
    
        boolean none = true;
        for(Object i: l.get(l.size()-1)){
            if(i != null)
                none = false;
        }
        if(none) 
            l.remove(l.size()-1);    

        return l;
        
      


  }
    



    
}
