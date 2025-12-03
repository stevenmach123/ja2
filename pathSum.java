
import java.util.AbstractMap;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

public class pathSum {
    public boolean has(TreeNode root, int targetSum){
        Deque<Map.Entry<Integer,TreeNode>> stack  =  new LinkedList<>();
        stack.push(new AbstractMap.SimpleEntry<Integer,TreeNode>(0,root));
        while(!stack.isEmpty()){
            Map.Entry<Integer,TreeNode> cur = stack.pop();
            int sum = cur.getKey() + cur.getValue().val; 
            if(cur.getValue().left ==null && cur.getValue().right ==null ){
                if(sum == targetSum) return true; 
            }
            if(cur.getValue().left !=null){
                stack.push(new AbstractMap.SimpleEntry<Integer,TreeNode>(sum,cur.getValue().left)    );
            }
            if(cur.getValue().right !=null){
                stack.push(new AbstractMap.SimpleEntry<Integer,TreeNode>(sum,cur.getValue().right)    );

            }
     
        }
        return false;

    }
}
