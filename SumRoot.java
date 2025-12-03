
import java.util.Stack;


public class SumRoot {
    public int sum(TreeNode root) {
    
        helper(root,0);
        return sum;
    }
    int sum = 0;
    void helper(TreeNode root,int temp_sum){
        if(root==null) return;

        temp_sum = temp_sum*10 + root.val ;
        if(root.right == null && root.left ==null )
            sum +=temp_sum;


        helper(root.right,temp_sum);
        helper(root.left,temp_sum);

    }


    int sum2(TreeNode root){
        return helper2(root,0);
    }
    int helper2(TreeNode root,int sum){
        if(root == null) return 0;
        sum = sum*10 +root.val; 
        if(root.right == null && root.left ==null)
            return sum;

        return helper2(root.right,sum) + helper2(root.left,sum);
    }

 
    int sum3(TreeNode root){
    
        Stack<Object[]> s = new Stack<Object[]>();
        s.push(new Object[]{root,0});
        int total  =0;
        while(!s.isEmpty()){
            Object[] cur = s.pop();
            int sum = ((int)cur[1]) * 10 + ((TreeNode)cur[0]).val; 
            if(((TreeNode)cur[0]).right == null && ((TreeNode)cur[0]).left == null)
                total += sum;

            if( ((TreeNode)cur[0]).right !=null){
                s.push(new Object[]{ ((TreeNode)cur[0]).right,sum});
            }
            if( ((TreeNode)cur[0]).left !=null){
                s.push(new Object[]{ ((TreeNode)cur[0]).left,sum});

            }
            
            

        }
        return total ; 


    }




}
