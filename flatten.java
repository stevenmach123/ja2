
import java.util.Deque;
import java.util.LinkedList;

public class flatten {
    public void flatten1(TreeNode root) {
        if(root ==null) return;
       
        
        flatten1(root.right);
        flatten1(root.left);
 
        
         TreeNode tail = root.left;
         while(tail != null  && tail.right != null){
              tail =tail.right; 
         }
         TreeNode temp_right = root.right;
         
         if(tail != null){
             root.right = root.left;
             tail.right =temp_right;
         }
         root.left = null; 
             
        
    }
    public void flatten2(TreeNode root) {
        if(root ==null) return;
        flatten2(root.left);
        flatten2(root.right);
        TreeNode cur = root;

        TreeNode left = root.left;
        TreeNode right = root.right;
        cur.right = left;
        while(cur.right != null){
            cur =cur.right;
        }
        cur.right = right;

        root.left = null;

    }
    public void flatten3(TreeNode root){
         if(root ==null) return;    
        Deque<TreeNode> stack = new LinkedList<>();

        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(cur.right !=null){
                stack.addFirst(cur.right);
            }
            if(cur.left !=null){
                stack.addFirst(cur.left);
            }
            
            cur.right = stack.peekFirst();

            cur.left = null; 
        }
           
    }
    TreeNode prev = null;
    public void flatten4(TreeNode root){
         if(root ==null) return;    
        flatten4(root.right);
        flatten4(root.left);
        root.right = prev;
        root.left = null; 
        prev= root; 
    }
    
    











    
    void flatten21(TreeNode root){
        if(root==null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = left;
        prev = right;
        TreeNode cur =left;
        while(cur.left !=null){
            cur = cur.left;
        }
        cur.left = prev;
        root.left= null;
        flatten21(root.right);
        

    }
    void flatten31(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<>();
        if(root == null) return;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
        
            if(cur.right!=null)
                stack.push(cur.right);
            if(cur.left!=null)
                stack.push(cur.left);
            
            if(cur.left == null && cur.right ==null )
                cur.right = stack.peek();
            else{
                if(cur.left != null)
                    cur.right =cur.left;
            }

            cur.left =null;

            
        }   
     
       

    }





}
