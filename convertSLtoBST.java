
import java.util.ArrayList;
import java.util.List;

public class convertSLtoBST {
    ListNode head ;
    int size; 
    TreeNode bst1(ListNode h){
        head  =help1.copyLN(h);
        size = help1.amount(head);
     
        
        return _bst1(1,size,"right",true);
    }
    TreeNode bst1_2(ListNode h){
        head  =help1.copyLN(h);
        size = help1.amount(head);
     
        
        return _bst1_2(1,size+1);
    }

    TreeNode bst2(ListNode h){
        head  =help1.copyLN(h);
        size = help1.amount(head);
      
        return _bst2(1,size,"left",false);
    }

    TreeNode bst2_2(ListNode h){
        head  =help1.copyLN(h);
        size = help1.amount(head);
      
        return _bst2_2(0,size);
    }
    

   
    TreeNode bst4(ListNode h){
        head  =help1.copyLN(h);
        size = help1.amount(head);
    
        return _bst4(1,size,"init","init",0);
    }

    TreeNode _bst4(int start,int end,String dir,String parent_dir,int count){
        int mid;
        String old_dir = dir; 
        if(dir != parent_dir){
            count++;
        }   
        
        if(count<=1){
            if(start >end) return null;
            if(start == end) return null;
               
            
        }
        else{
            if(start+1 ==end ||start>=end) return null;
        }


 
       
        if(count > 1){
            mid =  start + (end-start+1)/2;
        }
        else if(count==0 && dir =="init"){
            mid =  start + (end-start+1)/2;
             count = 0; 
        }
        else{
            if(dir =="left")
                mid = start + (end-start)/2;
            else
                mid = start + (end-start)/2 +1; 
        }
        
        
        TreeNode left_tree = _bst4(start,mid,"left",old_dir,count);
        TreeNode root = new TreeNode(head.val);
        //System.out.print(head.val+dir+"("+count+")"+" ");
        head =head.next;    
       
        TreeNode right_tree = _bst4(mid,end,"right",old_dir,count);

        root.left = left_tree;
        root.right = right_tree;
        return root;        



    }




    TreeNode bst3(ListNode h){
        head  =help1.copyLN(h);
        size = help1.amount(head);
        ListNode tail = head;
        while( tail != null && tail.next !=null){
            tail= tail.next;
        }
        return _bst3(head,tail);
    }
    



    TreeNode _bst2(int left,int right,String dir,boolean comp){
        int mid;boolean cur_comp; 

        if(comp==false && dir=="left" && left ==right){

        }
        else if(left >= right) return null;


        if(dir == "left")
            cur_comp =false;
        else
            cur_comp =true;
        
        boolean new_comp = comp || cur_comp;
        if(new_comp){
            mid = left+ (right-left)/2 + 1; 
        }
        else{
            mid = left+ (right-left+1)/2 ; 
        }
        TreeNode left_tree = _bst2(left,mid-1,"left",new_comp);
        TreeNode root = new TreeNode(head.val);
        head =head.next;

        TreeNode right_tree = _bst2(mid,right,"right",new_comp);
        root.left = left_tree;
        root.right = right_tree;
        return root;

    }







    TreeNode _bst1(int left,int right,String dir,boolean comp){
        int mid;
        boolean cur_comp; 

        if(dir =="right" && comp==true && left == right ){
            
        }
        else if(left>=right){return null;}

    

        if(dir == "left")
            cur_comp =false;
        else   
            cur_comp =true;

        boolean new_comp = comp && cur_comp;

        if(new_comp ==false){
            mid =left + (right-left)/2;
        }
        else {
            mid = left + (right-left+1)/2;
        }
        
        
        TreeNode left_tree = _bst1(left,mid,"left",new_comp);
        TreeNode root = new TreeNode(head.val);
       // System.out.print(head.val);
        head =head.next;
   
          // System.out.print("("+left+" "+right+")  ");
        
        TreeNode right_tree = _bst1(mid+1,right,"right",new_comp);
        root.left = left_tree;
        root.right = right_tree;
        return root;


    }
    TreeNode _bst1_2(int left,int right){
        int mid;
        if(left ==right)
            return null;
        mid = left+ (right-left)/2;
        TreeNode left_tree = _bst1_2(left,mid);
        TreeNode root = new TreeNode(head.val);
        head =head.next;
        
        TreeNode right_tree = _bst1_2(mid+1,right);
        root.left = left_tree;
        root.right = right_tree;

        return root;

    }
    TreeNode _bst2_2(int left,int right){
        int mid ;
        if(left ==right)
            return null;
        mid = left+ (right-left)/2 +1;
        TreeNode left_tree = _bst1_2(left,mid-1);
        TreeNode root = new TreeNode(head.val);
        head =head.next;

        TreeNode right_tree = _bst1_2(mid,right);
        root.left = left_tree;
        root.right = right_tree;

        return root;


    }



 






    TreeNode _bst3(ListNode h,ListNode t){
        if(h==null) return null;
        if(t !=null){
            if(h.val > t.val) return null;
        }
       
        if(h==t) return new TreeNode(h.val); 
       
        
        ListNode fast =h; 
        ListNode slow = h;
        ListNode behind=h;

        ListNode tail=t;
        if( t!= null){
            tail= t.next;
        }
        while(fast !=tail && fast.next!=tail){
          fast =fast.next.next;   
          behind =slow;
          slow = slow.next;
        }

        TreeNode left_tree  =  _bst3(h,behind);
        TreeNode root = new TreeNode(slow.val);


        
        TreeNode right_tree  =  _bst3(slow.next,t);
        root.left = left_tree;
        root.right = right_tree;
        return root;
    
        
    }
    










    ////
    private ListNode node; 
    public TreeNode convert(ListNode head){
        int size =0;
        ListNode temp = head;
        node = head;
        
        while(temp != null){
            size++;
            temp = temp.next;
        }
        if(size ==0)
            return new TreeNode();
        
        return helper(0,size-1);
    }
    TreeNode helper(int left,int right){
        if(left >= right){
            int val  = node.val;
            node= node.next; 
            return new TreeNode(val) ;  
        }
        int mid = (left+right)/2;
        TreeNode root = new TreeNode();    
        root.left = helper(left,mid);
        root.val = node.val;
        node = node.next;
        root.right = helper(mid+1,right);
        return root;
    }


    





    
}
