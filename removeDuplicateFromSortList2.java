
public class removeDuplicateFromSortList2 {
    public ListNode removeDup(ListNode head){
        if(head==null) return null;
        ListNode pre= head; 
        ListNode fast=head;
    
        boolean dup = false; 
        while(fast != null){

            fast= fast.next;
            dup =false;
            
            if(fast ==null) break;

            while(fast.next !=null && fast.val == fast.next.val ){
                fast =fast.next; 
        
            }
 
            if(fast.val == pre.val ){
                //System.out.println(pre.val+" "+fast.val);
                
                head=fast.next;
                pre =fast.next;
                fast =fast.next;
                 
            }
            else{
                if(pre.next == fast ){
                    //System.out.println(pre.val+" "+fast.val);
                    pre = pre.next; 
                    dup =false;
                }
                else{
                    pre.next  = fast.next; 
                    dup =true; 
                }
            }


        }
        return head; 
         
        
    }


     public ListNode removeDup2(ListNode head){
        ListNode fast = head;
        ListNode pre = head;
        if(head==null) return null; 
        while(fast!=null && fast.next !=null ){
            fast = fast.next;
            while(fast.next != null && fast.next.val == fast.val ){
                fast = fast.next; 
            }
          
            if(head.val == fast.val){
                    head = fast.next;
                    pre=fast.next; 
                    fast = fast.next;
            }else if(pre.next != fast){
                pre.next = fast.next;
                continue;
            }
        
            
            pre =fast; 

        }
        return head;

        
     }





    



}
