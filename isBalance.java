
public class isBalance {
    


    boolean res = true;
    int _balance(TreeNode n,int deep){  
        if(n ==null)
            return deep; 
       int d_left =  _balance(n.left,deep+1);
       int d_right = _balance(n.right,deep+1);
       int diff = Math.abs(d_left-d_right) ;
       if(diff >= 2)
            res= false;
        return Math.max(d_left,d_right) ;
    }

    public boolean isBalanced(TreeNode root) {
        _balance(root,0);
        return res;
    }



}
