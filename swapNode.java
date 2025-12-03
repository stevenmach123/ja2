
import java.util.ArrayList;
import java.util.List;
public class swapNode{
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }


       ListNode cur =head;
       ListNode prev2 ;
       ListNode temp3 =head.next.next; 
       ListNode temp2 =head.next;
       

        temp2.next = cur;
        head = temp2;
        cur.next = temp3;
        cur = temp3;
        prev2 = temp2.next;
        while(cur!=null){
            if(temp3.next==null){
                break;
            }
             temp3 = cur.next.next;
           
             temp2 = cur.next;
             

            temp2.next = cur;
            cur.next = temp3;          
            cur = temp3;

            prev2.next= temp2;
            prev2 = temp2.next;
         
        }
            
     
        
        return head;
    }

    public ListNode swapPairs2(ListNode head){
        ListNode odd; 
        ListNode even;
       
        if(head==null || head.next==null )
            return head;

        odd = head;
        even = head.next;

        while(odd !=null){
            int a= odd.val ;
            int b = even.val;
            even.val =a;
            odd.val = b;
            if(even.next==null){
                break;
            }
            
            even = even.next.next;
            odd =odd.next.next;

        }

        return head;
    }





   


}