
import java.util.LinkedList;
import java.util.Queue;

public class countNode {

    
    public int countNodes(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if(root ==null)
            return 0;
        q.add(root);
        int count =0;
        while(!q.isEmpty()){
            TreeNode cur = q.remove();
            if(cur.right !=null )
                q.add(cur.right);
            if(cur.left !=null ) 
                q.add(cur.left);
            count +=1; 
        }

        return count;
    }

}
